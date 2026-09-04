public class Course {
    private String subjectCode;
    private String subjectID;
    private String subjectName;
    private int units;

    public String getSubjectCode() {
        return this.subjectCode;
    }
    public String getSubjectID() {
        return this.subjectID;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    public int getUnits() {
        return this.units;
    }
    
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public void setUnits(int units) {
        this.units = units;
    }
}
