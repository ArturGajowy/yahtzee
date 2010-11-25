package pl.gajowy.yahtzee;

import java.util.List;

class TwoPairsStrategy extends TwoBlocksStrategy {

    @Override
    Integer evaluateBlocks(List<List<Integer>> pairsOrBigger) {
        return 2 * (blockDiceValue(pairsOrBigger, 0) + blockDiceValue(pairsOrBigger, 1));
    }

    private Integer blockDiceValue(List<List<Integer>> twoPairs, int i) {
        return twoPairs.get(i).get(0);
    }
}
