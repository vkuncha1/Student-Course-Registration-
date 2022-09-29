/**
 * Registration for classes based on student preference
 * was completed here. The method Registration takes the
 * student preference and Course Map to complete registration
 * on "First come First Serve" basis.
 *
 * @author  Venkata Achyuth Kunchapu
 *
 */
package studentCoursesBackup.util;
//Student Registration


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Formatter;
import java.util.Set;


public class Registration {
    String id;
    String[] courses;
    int satisfactionRating;
    int allocated;

    //Allocating Courses one by one student on First come First Serve
    public Registration(StudentPreference sp, Map<String, Course> courseMap) {
        this.id=sp.getId();
        this.satisfactionRating=0;
        this.courses=new String[3];
        this.allocated=0;
        try {
            register(sp, courseMap);
        }catch(Exception e){
            System.err.println("Registration Failed due to :"+ e);
            String courseErr =  "Registration Failed due to :"+e+", Please,try again";
            Results conf = new Results();
            conf.writeError(courseErr);
        }
    }
    //Allocating Courses
    private void register(StudentPreference sp,Map<String, Course> courseMap){
        String[] preferences=sp.getPref();
        Set<Integer> timeSet = new HashSet<>();
        ArrayList<String> courseClashList = new ArrayList<>();
        Results conf = new Results();
        try {
            for (int i = 0; i < 9; i++) {
                if (!courseMap.containsKey(preferences[i])) {
                    System.err.println("Course is not available");
                }
                Course course = courseMap.get(preferences[i]);


                if (course.checkToAllocate()) {
                    //timeSet
                    if (!timeSet.contains(course.getCourseTiming())) {
                        courses[allocated++] = course.getCourseName();
                        //allocated and increase count of allocated
                        courseMap.get(preferences[i]).allocate();
                        timeSet.add(course.getCourseTiming());
                        //rating
                        satisfactionRating += (9 - i);
                        if (allocated == 3) {
                            break;
                        }
                    } else {
                        courseClashList.add(course.getCourseName());
                    }
                }
            }
            if (courseClashList.size() > 0){
                String courseConf = "Clashing Courses: " + courseClashList+ " with allocated course for Student ID " + sp.getId() ;
                conf.writeConflict(courseConf);
            }
        }catch(Exception e){
            System.err.println("Allocation Failed due to :"+ e);
            String courseErr =  "Allocation Failed due to :"+e+", Please,try again";
            conf.writeError(courseErr);
        }

    }

    public void conflicts(){

    }

    //<student1_id>:<course_1>,<course_2>,<course_3>::SatisfactionRating=<value>
    public String generate() {
        String courseString = "";
        try {
            if (allocated > 0) {
                courseString += courses[0];
            } else {
                courseString += "::SatisfactionRating= 0";
                return id + ":" + courseString;
            }
            for (int i = 1; i < allocated; i++) {

                courseString += "," + courses[i];
            }
            double avg = (double) satisfactionRating / 3;

            //courseString+="::SatisfactionRating="+(avg);
            Formatter decimal_format = new Formatter();
            decimal_format.format("%.2f", avg);
            courseString += "::SatisfactionRating=" + (decimal_format.toString());
            return id + ":" + courseString;
        } catch (Exception e) {
            String courseErr = "Error While allocation :" + e + ", Please,try again";
            Results conf = new Results();
            conf.writeError(courseErr);
            return id + ":" + courseString;
        }
    }
}