package pl.gajowy.yahtzee;

import java.util.List;

import static com.google.common.collect.Iterables.concat;
import static pl.gajowy.utils.IterableUtils.sum;

class FullHouseStrategy extends TwoBlocksStrategy {

    @Override
    Integer evaluateBlocks(List<List<Integer>> pairsOrBigger) {
        return sum(concat(pairsOrBigger));
    }
}
