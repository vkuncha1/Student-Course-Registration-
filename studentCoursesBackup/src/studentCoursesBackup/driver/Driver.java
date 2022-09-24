package studentCoursesBackup.driver;
import studentCoursesBackup.util.Course;
import studentCoursesBackup.util.Registration;
import studentCoursesBackup.util.StudentPreference;

import java.io.*;
import java.util.*;



//Driver Class to run Student Registration code.
public class Driver {
    public static void main(String[] args) throws IOException {

        //FileProcessor fileProcessor = new FileProcessor();
        //File path for CourseInfo
        String courseInfo = "/Users/achyu/IdeaProjects/Assignmen1/files/courseInfo.txt";
        Map<String, Course> map = new HashMap<>();
        ArrayList<String> res=new ArrayList<>();
        try {
            File myObj = new File(courseInfo);
            Scanner myReader = null;
            try {
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    Course course = new Course(data);
                    map.put(course.getCourseName(), course);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        //preferences and assigning
        String coursePref = "/Users/achyu/IdeaProjects/Assignmen1/files/coursePref.txt";
        try {
            File myObj = new File(coursePref);
            Scanner myReader = null;
            try {
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String split[] = data.replace(";", "").split(" ");
                    StudentPreference sp = new StudentPreference(split[0], Arrays.copyOfRange(split, 1, 10));
                    Registration reg = new Registration(sp,map);
                    res.add(reg.generate());

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        System.out.println(res.toString());

        //Write Satisfaction Rating to Text file
        try {
            FileWriter regResults = new FileWriter("registration_results.txt");
            double avgSatisfaction = 0;
            Integer totalNumber = 0 ;
            for (String i:res){
                String satisfactionRes = i;
                String value = i.substring(i.lastIndexOf("=")+1);

                avgSatisfaction +=Double.parseDouble(value);
                totalNumber+=1;

                regResults.write(satisfactionRes+ System.lineSeparator());
            }
            regResults.write("..."+ System.lineSeparator());
            regResults.write("AverageSatisfactionRating="+(avgSatisfaction/totalNumber)+ System.lineSeparator());
            regResults.close();
        }catch(Exception ex){
            System.out.println("Error in writing File: "+ex);
        }
    }
}
