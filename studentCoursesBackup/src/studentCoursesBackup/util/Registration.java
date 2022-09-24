package studentCoursesBackup.util;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Registration {
    String id;
    String[] courses;
    int satisfactionRating;
    int allocated;

    public Registration(StudentPreference sp, Map<String, Course> courseMap) {
        this.id=sp.getId();
        this.satisfactionRating=0;
        this.courses=new String[3];
        this.allocated=0;
        register(sp,courseMap);
    }

    private void register(StudentPreference sp,Map<String, Course> courseMap){
        String[] preferences=sp.getPref();
        Set<Integer> timeSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if(!courseMap.containsKey(preferences[i])){
                System.out.println("Course is not available");
            }
            Course course=courseMap.get(preferences[i]);
            if(course.checkToAllocate()){
                //timeSet
                if(!timeSet.contains(course.getCourseTiming())){
                    courses[allocated++]=course.getCourseName();
                    //allocated and increase count of allocated
                    courseMap.get(preferences[i]).allocate();
                    timeSet.add(course.getCourseTiming());
                    //rating
                    satisfactionRating+=(9-i);
                    if(allocated==3){
                        break;
                    }
                }
                else{
                    System.out.println("Time mismatch "+course.getCourseName());
                }

            }
        }
    }

    //<student1_id>:<course_1>,<course_2>,<course_3>::SatisfactionRating=<value>
    public String generate(){
        String courseString="";
        if(allocated>0){
            courseString+=courses[0];
        }
        else{
            courseString+="::SatisfactionRating= 0";
            return id+":"+courseString;
        }
        for(int i=1;i<allocated;i++){

            courseString+=","+courses[i];
        }

        double avg=(double)satisfactionRating/3;
        //courseString+="::SatisfactionRating="+(avg);
        System.out.println(courseString+="::SatisfactionRating="+(avg));
        return id+":"+courseString;
    }
}
