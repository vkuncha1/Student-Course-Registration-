/**
 * File Processor takes the input from two input
 * files {courseInfo.txt and coursePrefs.txt}
 * This class implements FileDisplay
 *
 * The return type of this method fileInput is ArrayList(String)
 * which stores allocated courses along with satisfaction rate.
 *
 * @author  Venkata Achyuth Kunchapu
 *
 */

package studentCoursesBackup.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

//For taking input and process
public class FileProcessor implements FileDisplayInterface{

    public ArrayList<String> fileInput() {
        //File path for CourseInfo
        String currentpath = new File("").getAbsolutePath();
        String courseInfo = currentpath + "/courseInfo.txt";
        //String courseInfo = "/Users/achyu/IdeaProjects/Assignmen1/files/courseInfo.txt";
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
        //path for course prefs
        String coursePref = currentpath + "/coursePrefs.txt";
        //String coursePref = "/Users/achyu/IdeaProjects/Assignmen1/files/coursePref.txt";
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
        return res;
    }
}
