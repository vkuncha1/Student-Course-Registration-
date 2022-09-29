/**
 * The program works as a student registration
 * based on student preferences
 * creates an output files "regResults.txt" with registration details
 * "regConflicts.txt" with any registration conflicts if any
 * "errorLog.txt" with error log details if any
 *
 * @author  Venkata Achyuth Kunchapu
 *
 */


package studentCoursesBackup.driver;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;

//Driver Class to run Student Registration code.
public class Driver {
    public static void main(String[] args) {
        //Checking number of arguments and argument strings.

        if ((args.length ==5 )&& args[0].equals("coursePrefs.txt") && args[1].equals("courseInfo.txt") && args[2].equals("regResults.txt")
                && args[3].equals("regConflicts.txt") && args[4].equals("errorLog.txt")) {
            //Reading Input files and processing student registration (uses Interface FileDisplayInterface to accept input's)
            try {
                FileProcessor file = new FileProcessor();
                file.fileInput();
            } catch (Exception e) { //Writing into error file
                String courseErr = "Input File Processing Failed due to :" + e + ", Please,try again";
                Results conf = new Results();
                conf.writeError(courseErr);
            }
            //Writing output into output files (uses Interface StdoutDisplayInterface)
            try {
                Results result = new Results();
                result.writeResult();
            } catch (Exception e) { //Writing into error file
                String courseErr = "Writing into Output files failed due to :" + e + ", Please,try again";
                Results conf = new Results();
                conf.writeError(courseErr);
            }
        }
        else{
            System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
            System.exit(0);
        }
    }
}
