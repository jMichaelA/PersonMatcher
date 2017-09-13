import java.util.List;

/*
    If 3 non-null values don't match object reports non-match.
    Must have at least 3 non-null values
*/

public class StrikeOut implements Algorithm {
    private int strikes;
    private int nonNullVals;
    
    public StrikeOut(){
        strikes = 0;
        nonNullVals = 0;
    }

    @Override
    public Boolean match(Person per1, Person per2){
        compareValues(per1, per2);
        if(strikes < 3 && nonNullVals > 3){
            return true;
        }
        return false;
    }

    private void compareValues(Person per1, Person per2){

        List<Integer> per1Ints = per1.identifyNum();
        List<Integer> per2Ints = per2.identifyNum();
        List<String> per1Info = per1.info();
        List<String> per2Info = per2.info();
        List<String> per1TempInfo = per1.tempInfo();
        List<String> per2TempInfo = per2.tempInfo();

        compare(per1Ints, per2Ints);
        compare(per1Info, per2Info);
        compare(per1TempInfo, per2TempInfo);

        if(per1.isTwin() != null && per2.isTwin() != null){
            ++nonNullVals;
            if(per1.isTwin() != per2.isTwin()){
                ++strikes;
            }
        }
    }

    private void compare(List<?> per1, List<?> per2){
        for(int i = 0; i < per1.size(); ++i){
            if(per1.get(i) != null && per2.get(i) != null){
                if(!per2.get(i).equals(per1.get(i))){
                    ++strikes;
                }
                ++nonNullVals;
            }
        }
    }

    // getters and setters

    public int getStrikes(){
        return this.strikes;
    }

    public int getNonNullVals(){
        return this.nonNullVals;
    }
}