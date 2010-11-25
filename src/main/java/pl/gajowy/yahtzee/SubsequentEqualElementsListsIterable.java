package pl.gajowy.yahtzee;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class SubsequentEqualElementsListsIterable<T> implements Iterable<List<T>> {
    private final List<T> source;

    SubsequentEqualElementsListsIterable(List<T> source) {
        this.source = source;
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new SubsequentEqualElementsListsIterator<T>(source);
    }

    private class SubsequentEqualElementsListsIterator<T> implements Iterator<List<T>> {
        private final PeekingIterator<T> sourceIterator;
        private ArrayList<T> currentSlice;

        public SubsequentEqualElementsListsIterator(List<T> source) {
            currentSlice = newArrayList();
            sourceIterator = Iterators.peekingIterator(source.iterator());
        }

        @Override
        public boolean hasNext() {
            return sourceIterator.hasNext();
        }

        @Override
        public List<T> next() {
            throwExceptionIfDoesNotHaveNext();
            populateSlice();
            List<T> result = currentSlice;
            currentSlice = newArrayList();
            return result;
        }

        private void throwExceptionIfDoesNotHaveNext() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("Call to next when hasNext() == false");
            }
        }

        private void populateSlice() {
            do {
                currentSlice.add(sourceIterator.next());
            } while (sourceIterator.hasNext() && sourceHeadBelongsToCurrentSlice());
        }

        private boolean sourceHeadBelongsToCurrentSlice() {
            return currentSlice.get(0).equals(sourceIterator.peek());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
