package pl.gajowy.yahtzee;

import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

abstract class TwoBlocksStrategy extends EvaluationStrategy {

    private final Integer elementsInPair = 2;
    private final Predicate<List<Integer>> isPairOrBigger = new Predicate<List<Integer>>() {
        @Override
        public boolean apply(List<Integer> list) {
            return list.size() >= elementsInPair;
        }
    };

    @Override
    public Integer evaluate(Roll roll) {
        List<List<Integer>> pairsOrBigger
                = newArrayList(filter(new SubsequentEqualElementsListsIterable<Integer>(roll.getDice()), isPairOrBigger));
        if (thereAreTwoBlocks(pairsOrBigger)) {
            return evaluateBlocks(pairsOrBigger);
        }
        return 0;
    }

    private boolean thereAreTwoBlocks(List<List<Integer>> pairsOrBigger) {
        return pairsOrBigger.size() == 2;
    }

    abstract Integer evaluateBlocks(List<List<Integer>> pairsOrBigger);
}
