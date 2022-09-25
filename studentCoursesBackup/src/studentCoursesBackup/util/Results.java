package studentCoursesBackup.util;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;

public class Results {


    public void writeResult(){
        //Write Satisfaction Rating to Text file
        try {
            FileWriter regResults = new FileWriter("registration_results.txt");
            double avgSatisfaction = 0;
            Integer totalNumber = 0 ;
            FileProcessor file = new FileProcessor();
            ArrayList<String> res  = file.fileInput();
            for (String i:res){
                String satisfactionRes = i;
                String value = i.substring(i.lastIndexOf("=")+1);
                avgSatisfaction += Double.parseDouble(value);
                totalNumber+=1;
                System.out.println("The Result is : "+i);
                regResults.write(satisfactionRes+ System.lineSeparator());
            }
            regResults.write("..."+ System.lineSeparator());
            Formatter decimal_format = new Formatter();
            decimal_format.format("%.2f", avgSatisfaction/totalNumber);
            regResults.write("AverageSatisfactionRating="+decimal_format.toString()+ System.lineSeparator());
            regResults.close();
        }catch(Exception ex){
            System.out.println("Error in writing File: "+ex);
        }
    }
}
