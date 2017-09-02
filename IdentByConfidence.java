import java.util.List;
import java.util.ArrayList;

public class IdentByConfidence implements Algorithm {
    private List<Double> confidenceList;
    private Double confidence;
    
    public IdentByConfidence(){
        confidenceList = new ArrayList<Double>();
    }

    @Override
    public Boolean match(Person per1, Person per2){
        matchByIdent(per1, per2);
        matchByInfo(per1, per2);
        calConfidence();
        
        if(confidence > 0.75){
            return true;
        }
        return false;
    }

    private void matchByIdent(Person per1, Person per2){
        List<Integer> per1Ints = per1.identifyNum();
        List<Integer> per2Ints = per2.identifyNum();

        int size = 0;
        int sum = 0;

        for(int i = 0; i < per1Ints.size(); ++i){
            if(per1Ints.get(i) != null && per2Ints.get(i) != null){
                if(per2Ints.get(i).equals(per1Ints.get(i))){
                    ++sum;
                }
                ++size;
            }
        }
        pushConf(sum, size);
    }

    private void matchByInfo(Person per1, Person per2){
        List<String> per1Info = per1.info();
        List<String> per2Info = per2.info();

        int size = 0;
        int sum = 0;

        for(int i = 0; i < per1Info.size(); ++i){
            if(per1Info.get(i) != null && per2Info.get(i) != null){
                if(per2Info.get(i).equals(per1Info.get(i))){
                    ++sum;
                }
                ++size;
            }
        }

        pushConf(sum, size);
    }    

    private void calConfidence(){
        double sum = 0;

        for(int i = 0; i < confidenceList.size(); ++i){
            sum += confidenceList.get(i);
        }

        confidence = sum / (double) confidenceList.size();
    }

    private void pushConf(int sum, int size){
        if(size > 0){
            confidenceList.add((double) sum / (double) size);
        }
    }

    public List<Double> getconfidenceList(){
        return this.confidenceList;
    }

    public void setconfidenceList(List<Double> confidenceList){
        this.confidenceList = confidenceList;
    }

    public Double getconfidence(){
        return this.confidence;
    }

    public void setconfidence(Double confidence){
        this.confidence = confidence;
    }
}