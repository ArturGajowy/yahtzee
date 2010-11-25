package pl.gajowy.yahtzee;

public enum Category {
    ones(new SumNsStrategy(1)),
    twos(new SumNsStrategy(2)),
    threes(new SumNsStrategy(3)),
    pair(new NOfAKindStrategy(2)),
    threeOfAKind(new NOfAKindStrategy(3)),
    fourOfAKind(new NOfAKindStrategy(4)),
    yahtzee(new YahtzeeStrategy()),
    twoPairs(new TwoPairsStrategy()),
    fullHouse(new FullHouseStrategy());

    private EvaluationStrategy evaluationStrategy;

    private Category(EvaluationStrategy evaluationStrategy) {
        this.evaluationStrategy = evaluationStrategy;
    }

    Integer evaluate(Roll roll) {
        return this.evaluationStrategy.evaluate(roll);
    }
}
