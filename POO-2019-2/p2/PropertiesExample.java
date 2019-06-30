import java.io.*;
import java.util.*;
 
public class PropertiesExample {
    public static void main(String args[]) {
        try {
 
            Properties grades = new Properties();
 
            grades.setProperty("Geometry", "20");
            grades.setProperty("Algebra", "20");
            grades.setProperty("Physics", "18");
            grades.setProperty("Chemistry", "17");
            grades.setProperty("Biology", "19");
 
            // Save the grades properties using store() and an output stream
            FileOutputStream out = new FileOutputStream(
                    "schoolGrades.properties");
            grades.store(out, null);
            out.close();
 
            // load the properties file using load() and an input stream
            FileInputStream in = new FileInputStream("schoolGrades.properties");
            grades.load(in);
            in.close();
 
            // iterate properties file to get key-value pairs
            for (String key : grades.stringPropertyNames()) {
                String value = grades.getProperty(key);
                System.out.println("The grade in " + key + " is: " + value);
            }
 
            // search for key-value pair not in the list
            // you must define a default value, so as to return it
            // in case the key is not found in the main list
            String str = grades.getProperty("History", "No grade");
            System.out.println("The grade in History is " + str);
 
        } catch (IOException e) {
 
            e.printStackTrace();
        }
    }
}