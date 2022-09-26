package studentCoursesBackup.util;
import java.io.FileNotFoundException;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileProcessor implements FileDisplayInterface{

    public ArrayList<String> fileInput() {
        //File path for CourseInfo
        String courseInfo = "/Users/achyu/IdeaProjects/Assignmen1/files/courseInfo.txt";
        Map<String, Course> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
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
                    Registration reg = new Registration(sp, map);
                    res.add(reg.generate());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        System.out.println(res.toString());
        return res;
    }
}
