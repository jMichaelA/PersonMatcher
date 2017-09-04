import java.util.List;
import java.util.Arrays;

public class Person{
    private Integer id;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private Integer stateNumberFile;
    private Integer ssn;
    private Integer newbornScreeningNumber;
    private Integer twinOrder;
    private Boolean isTwin;
    private String sex;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nativeCountry;
    private String momFirstName;
    private String momLastName;
    private String momMiddleName;
    private String phone1;
    private String phone2;

    public Person(Integer newId){
        this.id = newId;
    }

    public Person(
            Integer     id,      String firstName,          String middleName, 
            String lastName,     Integer birthYear,         Integer birthMonth, 
            Integer birthDay,    Integer stateNumberFile,   Integer ssn, 
            String sex,          Boolean isTwin,            Integer newbornScreeningNumber,
            Integer twinOrder,   String nativeCountry,      String phone1,   
            String phone2,       String momFirstName,       String momLastName, 
            String momMiddleName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.stateNumberFile = stateNumberFile;
        this.ssn = ssn;
        this.sex = sex;
        this.newbornScreeningNumber = newbornScreeningNumber;
        this.isTwin = isTwin;
        this.twinOrder = twinOrder;
        this.nativeCountry = nativeCountry;
        this.momFirstName = momFirstName;
        this.momLastName = momLastName;
        this.momMiddleName = momMiddleName;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    // identifying functions

    public List<Integer> identifyNum(){
        return Arrays.asList(ssn, stateNumberFile, newbornScreeningNumber, birthYear, birthMonth, birthDay);
    }

    public List<String> identifyName(){
        return Arrays.asList(firstName, middleName, lastName);
    }

    public List<String> info(){
        return Arrays.asList(sex, nativeCountry, momFirstName, momLastName, momMiddleName, firstName, middleName, lastName);
    }

    public List<String> tempInfo(){
        return Arrays.asList(phone1, phone2);
    }

    public String outputId(){
        return String.valueOf(id);
    }

    public String output(){
        return "Id = " + String.valueOf(id) + ", Name = " + firstName + " " + middleName
                + " " + lastName + ", BirthDate = " + String.valueOf(birthMonth) + "/" + String.valueOf(birthDay) + "/" 
                + String.valueOf(birthYear);
    }

    // Getters And Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getNewbornScreeningNumber() {
        return newbornScreeningNumber;
    }

    public void setNewbornScreeningNumber(Integer newbornScreeningNumber) {
        this.newbornScreeningNumber = newbornScreeningNumber;
    }

    public Boolean isTwin() {
        return isTwin;
    }

    public void setTwin(Boolean twin) {
        isTwin = twin;
    }

    public Integer getTwinOrder() {
        return twinOrder;
    }

    public void setTwinOrder(Integer twinOrder) {
        this.twinOrder = twinOrder;
    }

    public String getNativeCountry() {
        return nativeCountry;
    }

    public void setNativeCountry(String nativeCountry) {
        this.nativeCountry = nativeCountry;
    }

    public String getMomFirstName() {
        return momFirstName;
    }

    public void setMomFirstName(String momFirstName) {
        this.momFirstName = momFirstName;
    }

    public String getMomLastName() {
        return momLastName;
    }

    public void setMomLastName(String momLastName) {
        this.momLastName = momLastName;
    }

    public String getMomMiddleName() {
        return momMiddleName;
    }

    public void setMomMiddleName(String momMiddleName) {
        this.momMiddleName = momMiddleName;
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
    
}