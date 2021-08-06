import java.io.*;
import java.util.*;
import java.util.logging.*;

public class myMain {
    //Muhammad Sharul Aiman Bin Mazlan
    //KCS1103A
    //2019273606
    
    //Binary search for student id
    public static int bsearch(ArrayList<Student> a, String b){
        Student std = new Student();
        int left = 0;
        int right = a.size() - 1;
        
        while (left <= right) { 
            int m = left + (right - left) / 2; 
            std = a.get(m);
            int res = b.compareTo(std.getId()); 
  
            if (res == 0) {
                return m; 
            }if (res > 0) {
                left= m + 1;
            }else{
                right = m - 1; 
            }
        }
        return -1; 
    }//2,3,8,9,10,13,15,17
            
    //Sorting the list in ascending order based on student ID
    public static void sortid(ArrayList<Student> a){
        Student std = new Student();
        Student std2 = new Student();
        for(int o =0; o<a.size(); o++){
        for(int z = 0; z <a.size()-1; z++){
            std = a.get(z);
            std2 = a.get(z+1);
            
            if(std.getId().compareTo(std2.getId()) > 0){
                a.add(z, a.get(z+1));
                a.remove(z+2);
                }
            }
        } 
    }
    
    //Ascending order (1 for Final assessment, 2 for total marks)
    public static void sorta(ArrayList<Student> a, int b){
        
        //if 1, final assessment
        if(b == 1){
            Student std = new Student();
            Student std2 = new Student();
        for(int o =0; o<a.size(); o++){
        
        for (int i = 0; i < a.size(); i++) {
            std = a.get(i);

          for (int j = a.size() - 1; j > i; j--) {
              std2 = a.get(j);
              if (std.getFa() > std2.getFa()) {

                  Student tmp = (Student) a.get(i);
                  a.set(i,a.get(j)) ;
                  a.set(j,tmp);
                    }
                }
            }
        }
            for(int k =0; k<a.size(); k++){
            System.out.println(a.get(k));
            }
        }
        //if 2, total marks
        else if(b == 2){
        Student std = new Student();
        Student std2 = new Student();
        for(int o =0; o<a.size(); o++){
        
        for (int i = 0; i < a.size(); i++) {
            std = a.get(i);

          for (int j = a.size() - 1; j > i; j--) {
              std2 = a.get(j);
              if (std.getTotal()> std2.getTotal()) {

                  Student tmp = (Student) a.get(i);
                  a.set(i,a.get(j)) ;
                  a.set(j,tmp);
                    }
                }
            }
        }
            for(int k =0; k<a.size(); k++){
            System.out.println(a.get(k));
            }
        }
    }
    
    //Descending order (1 for Final assessment, 2 for total marks)
    public static void sortd(ArrayList<Student> a, int b){
        
        //if 1, final assessment
        if(b ==1 ){
            Student std = new Student();
        Student std2 = new Student();
        for(int o =0; o<a.size(); o++){
        
        for (int i = 0; i < a.size(); i++) {
            std = a.get(i);

          for (int j = a.size() - 1; j > i; j--) {
              std2 = a.get(j);
              if (std.getFa() < std2.getFa()) {

                  Student tmp = (Student) a.get(i);
                  a.set(i,a.get(j)) ;
                  a.set(j,tmp);
                    }
                }
            }
        }
        for(int k =0; k<a.size(); k++){
          System.out.println(a.get(k));
            }
        }
        //if 2, total marks
        else if(b == 2){
            Student std = new Student();
        Student std2 = new Student();
        for(int o =0; o<a.size(); o++){
        
        for (int i = 0; i < a.size(); i++) {
            std = a.get(i);

          for (int j = a.size() - 1; j > i; j--) {
              std2 = a.get(j);
              if (std.getTotal()< std2.getTotal()) {

                  Student tmp = (Student) a.get(i);
                  a.set(i,a.get(j)) ;
                  a.set(j,tmp);
                    }
                }
            }
        }
        for(int k =0; k<a.size(); k++){
          System.out.println(a.get(k));
            }
        }
    }

    //Calculate total marks
    public static void calTotal(ArrayList<Student> a){
        Student std = new Student();
        double test1 = 0;
        double test2 = 0;
        double ass1 = 0;
        double myfinal = 0;
        double total = 0;
        
            for(int i=0; i<a.size(); i++){
                std = a.get(i);
                test1 = std.getT1() / 100 *20;
                test2 = std.getT2() / 100 *20;
                ass1 = std.getAs1() / 50 * 10;
                myfinal = std.getFa() / 100 * 50;
                total = test1 + test2 + ass1 + myfinal;
                std.setTotal(total);
            }
    }
    
    public static void main(String[] args){
        
        String path = "C:\\Users\\PC\\Downloads\\inputcsc248.csv";
        String pathWrite = "C:\\Users\\PC\\Downloads\\output.txt";
        BufferedReader br = null;
	PrintWriter pw = null;
        String inData = null;
        String input = null;
        StringTokenizer st = null;
        ArrayList<Student> students = new ArrayList();
        Student std = new Student();
        Scanner sc = new Scanner(System.in);
            
        try {
            br = new BufferedReader(new FileReader(path));
            
            while( (inData = br.readLine()) != null){
                st = new StringTokenizer(inData, ",");
             
                String id = st.nextToken();
                String name = st.nextToken();
                double t1= Double.parseDouble(st.nextToken());
                double t2 = Double.parseDouble(st.nextToken());
                double as1 = Double.parseDouble(st.nextToken());
                double fa = Double.parseDouble(st.nextToken());
            
                students.add(new Student(id,name,t1,t2,as1,fa));
            }
            
            pw = new PrintWriter(new FileWriter(pathWrite));
            
            System.out.println("Calculating total marks...");
            myMain.calTotal(students);
            
            System.out.println("Sorting list in ascending order based on final assessment...");
            System.out.println("Displaying the sorted list...");
            
            myMain.sorta(students, 1);
            pw.println("Sorted list in ascending order based on final assessment");
            
            for(int k =0; k<students.size(); k++){
            pw.println(students.get(k));
            }
            
            System.out.println("Saving the list to output file...");
            System.out.println("Sorting list in descending order based on total marks...");
            
            System.out.println("Displaying the sorted list...");
            myMain.sortd(students, 2);
            pw.println("Sorted list in descending order based on total marks");
            
            for(int k =0; k<students.size(); k++){
            pw.println(students.get(k));
            }
            
            System.out.println("Saving the list to output file...");
            System.out.println("Closing the output file...");
            pw.close();
            
            
            System.out.println("Displaying top student for final assessment...");
            double max = Integer.MIN_VALUE;
            for (int i =0; i<students.size(); i++) {
                std = students.get(i);
                if (std.getFa()>max) {
                    max = std.getFa();
                    System.out.println(std.toString());
                }
            }
            
            System.out.println("Displaying bottom student for final assessment...");
            Student std2 = students.get(0);
            double minValue = std2.getFa();
                for(int i = 1; i<students.size(); i++){
                    std = students.get(i);
                        if(std.getFa() < minValue){
                            minValue = std.getFa();  
                    }
            }System.out.println(std.toString());
            
            
            System.out.println("Displaying top student for total mark...");
            double max2 = Integer.MIN_VALUE;
            for (int i =0; i<students.size(); i++) {
                std = students.get(i);
                if (std.getTotal()>max2) {
                    max2 = std.getTotal();
                    System.out.println(std.toString());
                }
            }
            
            System.out.println("Displaying bottom student for total mark...");
            Student std3 = students.get(0);
            double minValue2 = std3.getTotal();
                for(int i = 1; i<students.size(); i++){
                    std = students.get(i);
                        if(std.getTotal() < minValue2){
                            minValue2 = std.getTotal();  
                    }
            }System.out.println(std.toString());
            
            
            System.out.println("Preparing for binary search...");
            System.out.println("Sorting the array in ascending order based on student id...");
            myMain.sortid(students);
            System.out.print("Enter student id to search: ");
            input = sc.next();
            
            int result = myMain.bsearch(students, input);
            if (result == -1) {
                System.out.println("ID not exist"); 
            }else{
                System.out.println(input + " is at index : "+ result); 
                System.out.println("Retrieving info of student id : "+input);
                System.out.println(students.get(result));
            }
            System.out.println("End the system, thank you");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(myMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(myMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
