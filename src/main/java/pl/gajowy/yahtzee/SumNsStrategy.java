package pl.gajowy.yahtzee;

import pl.gajowy.utils.IterableUtils;

import static com.google.common.base.Predicates.equalTo;
import static com.google.common.collect.Iterables.filter;

class SumNsStrategy extends EvaluationStrategy {

    private final Integer scoredValue;

    public SumNsStrategy(Integer scoredValue) {
        this.scoredValue = scoredValue;
    }

    @Override
    public Integer evaluate(Roll roll) {
        Iterable<Integer> diceEqualToN = filter(roll.getDice(), equalTo(scoredValue));
        return IterableUtils.sum(diceEqualToN);
    }
}
