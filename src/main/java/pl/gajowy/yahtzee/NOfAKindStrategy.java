package pl.gajowy.yahtzee;

import java.util.List;

import static pl.gajowy.utils.IterableUtils.head;
import static pl.gajowy.utils.IterableUtils.tail;

class NOfAKindStrategy extends EvaluationStrategy {
    Integer n;

    public NOfAKindStrategy(Integer n) {
        this.n = n;
    }

    @Override
    public Integer evaluate(Roll roll) {
        List<Integer> diceInDescendingOrder = roll.getDice().reverse();
        return evaluateNotSeen(diceInDescendingOrder, 0, 0);
    }

    Integer evaluateNotSeen(List<Integer> diceNotSeen, Integer lastDie, Integer numberOfEqualDiceSeen) {
        if (numberOfEqualDiceSeen.equals(n)) {
            return lastDie * numberOfEqualDiceSeen;
        } else if (diceNotSeen.isEmpty()) {
            return 0;
        } else {
            Integer die = head(diceNotSeen);
            return evaluateNotSeen(tail(diceNotSeen), die, newNumberOfEqualDiceSeen(die, lastDie, numberOfEqualDiceSeen));
        }
    }

    Integer newNumberOfEqualDiceSeen(Integer die, Integer lastDie, Integer numberOfEqualDiceSeen) {
        if (die.equals(lastDie)) {
            return numberOfEqualDiceSeen + 1;
        } else {
            return 1;
        }
    }
}
