/**
 *
 * Course class carries Course related details
 * Course class includes constructors,getters and setters
 * for the fields {courseName,courseCapacity,courseTiming,courseAllocated}
 *
 */

package studentCoursesBackup.util;

//class for course Information
public class Course {
    String courseName;
    Integer courseCapacity;
    Integer courseTiming;
    Integer courseAllocated = 0;

    //Constructors
    public Course(String courseName, int courseCapacity, int courseTiming) {
        this.courseName = courseName;
        this.courseCapacity = courseCapacity;
        this.courseTiming = courseTiming;
    }

    public Course(String data) {
        String[] splitString = data.split(":");
        this.courseName = splitString[0];
        this.courseCapacity = Integer.parseInt(splitString[1]);
        this.courseTiming = Integer.parseInt(splitString[2]);
    }

    //Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public int getCourseTiming() {
        return courseTiming;
    }

    public void setCourseTiming(int courseTiming) {
        this.courseTiming = courseTiming;
    }
    //To keep the count of courses allocated.
    public void allocate() {
        this.courseAllocated++;
        return;
    }
    public boolean checkToAllocate() {
        return courseAllocated < courseCapacity;
    }
    // Course class overide toString() method.
    @Override
    public String toString() {
        return "Course Name:  "+ courseName + ", Course Capacity: "+ courseCapacity +",Course Timing: : " +courseTiming ;
    }
}
