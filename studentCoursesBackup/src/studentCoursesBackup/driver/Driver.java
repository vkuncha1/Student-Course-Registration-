package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;

import java.io.*;
import java.util.*;



//Driver Class to run Student Registration code.
public class Driver {
    public static void main(String[] args) throws IOException {

        FileProcessor file = new FileProcessor();
        file.fileInput();
        Results result = new Results();
        result.writeResult();

    }
}
