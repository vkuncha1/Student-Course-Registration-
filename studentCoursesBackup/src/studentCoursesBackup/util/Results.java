/**
 * Results class implements StdoutDisplayInterface
 * to write into output files
 * @author  Venkata Achyuth Kunchapu
 *
 */
package studentCoursesBackup.util;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;

public class Results implements StdoutDisplayInterface{


    public void writeResult(){
        //Write Satisfaction Rating to Text file
        try {
            String currentpath = new File("").getAbsolutePath();
            String regResultsPath = currentpath + "/studentCoursesBackup/regResults.txt";
            FileWriter regResults = new FileWriter(regResultsPath);
            double avgSatisfaction = 0;
            Integer totalNumber = 0 ;
            FileProcessor file = new FileProcessor();
            ArrayList<String> res  = file.fileInput();
            for (String i:res){
                String satisfactionRes = i;
                String value = i.substring(i.lastIndexOf("=")+1);
                avgSatisfaction += Double.parseDouble(value);
                totalNumber+=1;
                regResults.write(satisfactionRes+ System.lineSeparator());
            }
            regResults.write("..."+ System.lineSeparator());
            Formatter decimal_format = new Formatter();
            decimal_format.format("%.2f", avgSatisfaction/totalNumber);
            regResults.write("AverageSatisfactionRating="+decimal_format.toString()+ System.lineSeparator());
            regResults.close();
        }catch(Exception ex){
            System.err.println("Error in writing File: "+ex);
            String courseErr =  "Error in Writing Results due to :"+ex+", Please,try again";
            Results conf = new Results();
            conf.writeError(courseErr);

        }
    }
    //Writing Conflict file
    public void writeConflict(String conflictIn){
        try {
            String currentpath = new File("").getAbsolutePath();
            String regConflictsPath = currentpath + "/studentCoursesBackup/regConflicts.txt";
            FileWriter regResults = new FileWriter(regConflictsPath,true);
            regResults.write(conflictIn+ System.lineSeparator());
            regResults.close();
        }catch(Exception ex){
            System.err.println("Error in writing File: "+ex);
            String courseErr =  "Error in writing Conflicts due to :"+ex+", Please,try again";
            Results conf = new Results();
            conf.writeError(courseErr);
        }
    }

    //Writing Error File

    public void writeError(String errorIn){
        try{
            String currentpath = new File("").getAbsolutePath();
            String regErrorPath = currentpath + "/studentCoursesBackup/errorLog.txt";
            FileWriter regResults = new FileWriter(regErrorPath,true);
            regResults.write(errorIn+ System.lineSeparator());
            regResults.close();
        }catch(Exception ex){
            System.err.println("Error in writing into Error File: "+ex);
        }
    }
}