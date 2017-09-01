public class Person{
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private int stateNumberFile;
    private int ssn;
    private char sex;
    private int newbornScreeningNumber;
    private boolean isTwin;
    private int twinOrder;
    private String nativeCountry;
    private String momFirstName;
    private String momLastName;
    private String momMiddleName;
    private String phone1;
    private String phone2;

    public Person(int newId){
        this.id = newId;
    }

    public Person(int id, String firstName, String middleName, String lastName, int birthYear, int birthMonth, int birthDay, int stateNumberFile, int ssn, char sex, int newbornScreeningNumber, boolean isTwin, int twinOrder, String nativeCountry, String momFirstName, String momLastName, String momMiddleName, String phone1, String phone2) {
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

    //Getters And Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getStateNumberFile() {
        return stateNumberFile;
    }

    public void setStateNumberFile(int stateNumberFile) {
        this.stateNumberFile = stateNumberFile;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getNewbornScreeningNumber() {
        return newbornScreeningNumber;
    }

    public void setNewbornScreeningNumber(int newbornScreeningNumber) {
        this.newbornScreeningNumber = newbornScreeningNumber;
    }

    public boolean isTwin() {
        return isTwin;
    }

    public void setTwin(boolean twin) {
        isTwin = twin;
    }

    public int getTwinOrder() {
        return twinOrder;
    }

    public void setTwinOrder(int twinOrder) {
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