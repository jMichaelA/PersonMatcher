import java.util.List;

public class ScoreSystem implements Algorithm {
    private int primaryMultiplier;
    private int secondaryMultiplier;
    private int tertiaryMultiplier;
    private int score;
    private int maxScore;
    private int errorScore;

    public ScoreSystem() {
        primaryMultiplier = 3;
        secondaryMultiplier = 2;
        tertiaryMultiplier = 1;
        errorScore = 2*secondaryMultiplier + tertiaryMultiplier;
    }

    public ScoreSystem(int primaryMultiplier, int secondaryMultiplier, int tertiaryMultiplier, int errorScore) {
        this.primaryMultiplier = primaryMultiplier;
        this.secondaryMultiplier = secondaryMultiplier;
        this.tertiaryMultiplier = tertiaryMultiplier;
        this.errorScore = errorScore;
    }

    public ScoreSystem(int primaryMultiplier, int secondaryMultiplier, int tertiaryMultiplier) {
        this.primaryMultiplier = primaryMultiplier;
        this.secondaryMultiplier = secondaryMultiplier;
        this.tertiaryMultiplier = tertiaryMultiplier;
        errorScore = 2*secondaryMultiplier + tertiaryMultiplier;
    }

    @Override
    public Boolean match(Person per1, Person per2) {
        List<Integer> per1Ints = per1.identifyNum();
        List<Integer> per2Ints = per2.identifyNum();
        List<String> per1Info = per1.info();
        List<String> per2Info = per2.info();
        List<String> per1TempInfo = per1.tempInfo();
        List<String> per2TempInfo = per2.tempInfo();

        compare(per1Ints, per2Ints, primaryMultiplier);
        compare(per1Info, per2Info, secondaryMultiplier);
        compare(per1TempInfo, per2TempInfo, tertiaryMultiplier);

        if(maxScore - score < errorScore){
            return true;
        }
        return false;
    }

    private void compare(List<?> per1, List<?> per2, int multiply) {
        for(int i = 0; i < per1.size(); ++i){
            if(per1.get(i) != null && per2.get(i) != null){
                if(per2.get(i).equals(per1.get(i))){
                    score += multiply;
                }   

                maxScore += multiply;
            }
        }
    }

    public int getPrimaryMultiplier() {
        return primaryMultiplier;
    }

    public void setPrimaryMultiplier(int primaryMultiplier) {
        this.primaryMultiplier = primaryMultiplier;
    }

    public int getSecondaryMultiplier() {
        return secondaryMultiplier;
    }

    public void setSecondaryMultiplier(int secondaryMultiplier) {
        this.secondaryMultiplier = secondaryMultiplier;
    }

    public int getTertiaryMultiplier() {
        return tertiaryMultiplier;
    }

    public void setTertiaryMultiplier(int tiertiaryMultiplier) {
        this.tertiaryMultiplier = tertiaryMultiplier;
    }

    public int getErrorScore() {
        return errorScore;
    }

    public void setErrorScore(int errorScore){
        this.errorScore = errorScore;
    }

}