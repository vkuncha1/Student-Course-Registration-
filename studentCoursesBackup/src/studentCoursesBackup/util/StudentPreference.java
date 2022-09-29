/**
 * Student Preference class for student preferences and Student ID
 *
 * @author  Venkata Achyuth Kunchapu
 *
 */
package studentCoursesBackup.util;

public class StudentPreference {
    private String id;
    private String[] pref ;
    public StudentPreference(String id, String[] pref) {
        this.id = id;
        this.pref = pref;
    }
    //Getter and Setter for studentId(id)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    //Getter and Setter for Studentpreferance (Prefarance)
    public String[] getPref() {
        return pref;
    }
    public void setPref(String[] pref) {
        this.pref = pref;
    }
}