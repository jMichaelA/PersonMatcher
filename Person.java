import java.util.List;
import java.util.Arrays;

public class Person{
    private Integer objectId;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private Integer stateNumberFile;
    private Integer socialSecurityNumber;
    private Integer birthOrder;
    private String newbornScreeningNumber;
    private String isPartOfMultipleBirth;
    private String gender;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthCounty;
    private String motherFirstName;
    private String motherLastName;
    private String motherMiddleName;
    private String phone1;
    private String phone2;
    private String stateFileNumber;

    public Person(){

    }

    public Person(Integer newId){
        this.objectId = newId;
    }

    public Person(
            Integer objectId,    String firstName,              String middleName, 
            String lastName,     Integer birthYear,             Integer birthMonth, 
            Integer birthDay,    Integer stateNumberFile,       Integer socialSecurityNumber, 
            String gender,       String isPartOfMultipleBirth,  String newbornScreeningNumber,
            Integer birthOrder,   String birthCounty,            String phone1,   
            String phone2,       String motherFirstName,        String motherLastName,
            String motherMiddleName) {
        this.objectId = objectId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.stateNumberFile = stateNumberFile;
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = gender;
        this.newbornScreeningNumber = newbornScreeningNumber;
        this.isPartOfMultipleBirth = isPartOfMultipleBirth;
        this.birthOrder = birthOrder;
        this.birthCounty = birthCounty;
        this.motherFirstName = motherFirstName;
        this.motherLastName = motherLastName;
        this.motherMiddleName = motherMiddleName;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

        public Person(
            Integer objectId,    String firstName,              String middleName, 
            String lastName,     Integer birthYear,             Integer birthMonth, 
            Integer birthDay,    String stateFileNumber,        Integer socialSecurityNumber,
            String gender,       String isPartOfMultipleBirth,  String newbornScreeningNumber,
            Integer birthOrder,   String birthCounty,            String phone1,   
            String phone2,       String motherFirstName,        String motherLastName,
            String motherMiddleName) {
        this.objectId = objectId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.stateFileNumber = stateFileNumber;
        this.stateNumberFile = Integer.parseInt(stateFileNumber.replaceAll("\\s+",""));
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = gender;
        this.newbornScreeningNumber = newbornScreeningNumber;
        this.isPartOfMultipleBirth = isPartOfMultipleBirth;
        this.birthOrder = birthOrder;
        this.birthCounty = birthCounty;
        this.motherFirstName = motherFirstName;
        this.motherLastName = motherLastName;
        this.motherMiddleName = motherMiddleName;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    // identifying functions

    public List<Integer> identifyNum(){
        return Arrays.asList(socialSecurityNumber, stateNumberFile, birthYear, birthMonth, birthDay);
    }

    public List<String> identifyName(){
        return Arrays.asList(firstName, middleName, lastName);
    }

    public List<String> info(){
        return Arrays.asList(gender, birthCounty, motherFirstName, motherLastName, motherMiddleName, firstName, middleName, lastName, newbornScreeningNumber);
    }

    public List<String> tempInfo(){
        return Arrays.asList(phone1, phone2);
    }

    public String outputId(){
        return String.valueOf(objectId);
    }

    public String output(){
        return "Id = " + String.valueOf(objectId) + ", Name = " + firstName + " " + middleName
                + " " + lastName + ", BirthDate = " + String.valueOf(birthMonth) + "/" + String.valueOf(birthDay) + "/" 
                + String.valueOf(birthYear);
    }

    public Boolean isTwin(){
        if(isPartOfMultipleBirth == null){
            return false;
        }
        
        if(isPartOfMultipleBirth.equals("t") || isPartOfMultipleBirth.equals("T")){
            return true;
        }else{
            return false;
        }
    }

    // Getters And Setters

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getStateNumberFile() {
        return stateNumberFile;
    }

    public void setStateNumberFile(Integer stateNumberFile) {
        this.stateNumberFile = stateNumberFile;
    }

    public void setStateNumberFile() {
        if(stateFileNumber != null) {
            this.stateNumberFile = Integer.parseInt(stateFileNumber.replaceAll("\\s+", ""));
        }
    }

    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Integer socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNewbornScreeningNumber() {
        return newbornScreeningNumber;
    }

    public void setNewbornScreeningNumber(String newbornScreeningNumber) {
        this.newbornScreeningNumber = newbornScreeningNumber;
    }

    public String isPartOfMultipleBirth() {
        return isPartOfMultipleBirth;
    }

    public void setIsPartOfMultipleBirth(String twin) {
        isPartOfMultipleBirth = twin;
    }

    public Integer getBirthOrder() {
        return birthOrder;
    }

    public void setBirthOrder(Integer birthOrder) {
        this.birthOrder = birthOrder;
    }

    public String getNativeCountry() {
        return birthCounty;
    }

    public void setNativeCountry(String birthCounty) {
        this.birthCounty = birthCounty;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getMotherMiddleName() {
        return motherMiddleName;
    }

    public void setMotherMiddleName(String motherMiddleName) {
        this.motherMiddleName = motherMiddleName;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getStateFileNumber(){
        return stateFileNumber;
    }

    public void setStateFileNumber(String stateFileNumber){
        if(stateFileNumber == null){
            return;
        }
        this.stateFileNumber = stateFileNumber;
        String temp = stateFileNumber.replaceAll("\\s+","");
        stateNumberFile = Integer.parseInt(temp);
    }
    
}