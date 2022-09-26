package studentCoursesBackup.util;
//Student Registration
import java.util.*;

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
        System.out.println(sp.getId());
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
            String courseConf =  "Course Time Clash for Student ID "+sp.getId()+": Clashing Courses: "+courseClashList;
            conf.writeConflict(courseConf);
        }catch(Exception e){
            System.err.println("Allocation Failed due to :"+ e);
            String courseErr =  "Allocation Failed due to :"+e+", Please,try again";
            conf.writeError(courseErr);
        }

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
            System.out.println(courseString += "::SatisfactionRating=" + (decimal_format.toString()));
            return id + ":" + courseString;
        } catch (Exception e) {
            String courseErr = "Error While allocation :" + e + ", Please,try again";
            Results conf = new Results();
            conf.writeError(courseErr);
            return id + ":" + courseString;
        }
    }
}
