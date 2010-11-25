package pl.gajowy.yahtzee;

class YahtzeeStrategy extends EvaluationStrategy {

    private final Integer yahtzeeScore = 50;

    private final NOfAKindStrategy wrapped;

    public YahtzeeStrategy() {
        this.wrapped = new NOfAKindStrategy(5);
    }

    @Override
    public Integer evaluate(Roll roll) {
        return overrideNonZeroScore(wrapped.evaluate(roll));
    }

    private Integer overrideNonZeroScore(Integer score) {
        if (score > 0) {
            return yahtzeeScore;
        } else {
            return 0;
        }
    }
}
