package pl.gajowy.yahtzee;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.nCopies;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class RollTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowRollsWithMoreThan5Dies() {
        new Roll(nCopies(10, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowRollsWithLessThan5Dies() {
        new Roll(nCopies(4, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowRollsWithADieSmallerThan1() {
        new Roll(nCopies(5, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowRollsWithADieBiggerThan6() {
        new Roll(nCopies(5, 7));
    }

    @Test
    public void shouldReturnDiceInAscendingOrder() {
         assertThat(new Roll(4, 5, 3, 1, 2).getDice(), Matchers.<List<Integer>>is(Lists.newArrayList(1, 2, 3, 4, 5)));
    }

    @Test
    public void shouldReturnDiceAsAnImmutableList() {
        assertThat(new Roll(1, 2, 3, 4, 5).getDice(), instanceOf(ImmutableList.class));
    }
}
