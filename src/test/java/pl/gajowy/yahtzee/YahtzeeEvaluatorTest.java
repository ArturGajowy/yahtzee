package pl.gajowy.yahtzee;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class YahtzeeEvaluatorTest {

    @Test
    public void shouldValue4ForARollWith4OnesClaimedAsOnes() {
        Integer numberOfOnes = 4;
        assertThat(evaluationOf(new Roll(1, 1, 1, 1, 5), Category.ones), is(numberOfOnes));
    }

    @Test
    public void shouldValue6ForARollWith3TwosClaimedAsTwos() {
        Integer numberOfTwos = 3;
        assertThat(evaluationOf(new Roll(1, 2, 2, 2, 5), Category.twos), is(numberOfTwos * 2));
    }

    @Test
    public void shouldValue9ForARollWith3ThreesClaimedAsThrees() {
        Integer numberOfThrees = 3;
        assertThat(evaluationOf(new Roll(1, 3, 3, 3, 5), Category.threes), is(numberOfThrees * 3));
    }

    @Test
    public void shouldValue8ForARollWith2FoursClaimedAsPair() {
        assertThat(evaluationOf(new Roll(1, 2, 3, 4, 4), Category.pair), is(8));
    }

    @Test
    public void shouldValue8ForARollWith2FoursAnd2ThreesClaimedAsPair() {
        assertThat(evaluationOf(new Roll(1, 3, 3, 4, 4), Category.pair), is(8));
    }

    @Test
    public void shouldValue12ForARollWith3FoursClaimedAsThreeOfAKind() {
        assertThat(evaluationOf(new Roll(3, 3, 4, 4, 4), Category.threeOfAKind), is(12));
    }

    @Test
    public void shouldValue12ForARollWith3FoursAndAFiveClaimedAsThreeOfAKind() {
        assertThat(evaluationOf(new Roll(3, 4, 4, 4, 5), Category.threeOfAKind), is(12));
    }

    @Test
    public void shouldValue0ForARollWithoutThreeEqualDiceClaimedAsThreeOfAKind() {
        assertThat(evaluationOf(new Roll(1, 2, 4, 4, 5), Category.threeOfAKind), is(0));
    }

    @Test
    public void shouldValue16ForARollWith4FoursClaimedAsFourOfAKind() {
        assertThat(evaluationOf(new Roll(4, 4, 4, 4, 5), Category.fourOfAKind), is(16));
    }

    @Test
    public void shouldValue16ForARollWith5FoursClaimedAsFourOfAKind() {
        assertThat(evaluationOf(new Roll(4, 4, 4, 4, 4), Category.fourOfAKind), is(16));
    }

    @Test
    public void shouldValue50ForRollWithAllDiceEqualClaimedAsYahtzee() {
        assertThat(evaluationOf(new Roll(4, 4, 4, 4, 4), Category.yahtzee), is(50));
    }

    @Test
    public void shouldValue0ForFalseYahtzee() {
        assertThat(evaluationOf(new Roll(1, 4, 4, 4, 4), Category.yahtzee), is(0));
    }

    @Test
    public void shouldValue0ForARollWith4FoursClaimedAsTwoPairs() {
        assertThat(evaluationOf(new Roll(1, 4, 4, 4, 4), Category.twoPairs), is(0));
    }

    @Test
    public void shouldValue10ForARollWithAPairOfOnesAndAPairOfFoursClaimedAsTwoPairs() {
        assertThat(evaluationOf(new Roll(1, 1, 3, 4, 4), Category.twoPairs), is(10));
    }

    @Test
    public void shouldValue10ForARollWithAPairOfOnesAndThreeFoursClaimedAsTwoPairs() {
        assertThat(evaluationOf(new Roll(1, 1, 4, 4, 4), Category.twoPairs), is(10));
    }

    @Test
    public void shouldValue0ForARollNotWithTwoPairsClaimedAsTwoPairs() {
        assertThat(evaluationOf(new Roll(1, 1, 1, 2, 4), Category.twoPairs), is(0));
    }

    @Test
    public void shouldValue10ForARollWith2TwosAnd3ThreesClaimedAsFullHouse() {
        assertThat(evaluationOf(new Roll(2, 2, 3, 3, 3), Category.fullHouse), is(13));
    }

    @Test
    public void shouldValue0ForARollWithoutAFullHouseClaimedAsFullHouse() {
        assertThat(evaluationOf(new Roll(1, 2, 3, 3, 3), Category.fullHouse), is(0));
    }

    private Integer evaluationOf(Roll roll, Category claimedCategory) {
        return new YahtzeeEvaluator().evaluate(roll, claimedCategory);
    }
}
