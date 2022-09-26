package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;

//Driver Class to run Student Registration code.
public class Driver {
    public static void main(String[] args) {
        try {
            FileProcessor file = new FileProcessor();
            file.fileInput();
        }catch(Exception e){
            String courseErr =  "Input File Processing Failed due to :"+e+", Please,try again";
            Results conf = new Results();
            conf.writeError(courseErr);
        }

        try{
            Results result = new Results();
            result.writeResult();
        }catch(Exception e){
            String courseErr =  "Writing into Output files failed due to :"+e+", Please,try again";
            Results conf = new Results();
            conf.writeError(courseErr);
        }

    }
}

