package pl.gajowy.yahtzee;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

import java.util.Arrays;
import java.util.Collection;

public class Roll {
    private final ImmutableList<Integer> dice;
    private static final Integer numberOfDiceInRoll = 5;

    public Roll(Integer... dice) {
        this(Arrays.<Integer>asList(dice));
    }

    public Roll(Collection<Integer> dice) {
        validateParameters(dice);
        this.dice = Ordering.natural().immutableSortedCopy(dice);
    }

    private void validateParameters(Collection<Integer> dice) {
        Preconditions.checkArgument(dice.size() == numberOfDiceInRoll,
            "There must be exactly " + numberOfDiceInRoll + " dice in a roll"
        );
        for (Integer die : dice) {
            Preconditions.checkArgument(1 <= die && die <= 6, "Every die must be between 1 and 6");
        }
    }

    public ImmutableList<Integer> getDice() {
        return dice;
    }
}
