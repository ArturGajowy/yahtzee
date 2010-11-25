package pl.gajowy.yahtzee;

public class YahtzeeEvaluator {
    public Integer evaluate(Roll roll, Category claimedCategory) {
        return claimedCategory.evaluate(roll);
    }
}
