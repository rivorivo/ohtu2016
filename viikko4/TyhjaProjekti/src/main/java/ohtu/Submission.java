package ohtu;


import java.util.ArrayList;


public class Submission {

    private String student_number;
    private String week;
    private String hours;
    private ArrayList<Integer> tehdyt=new ArrayList<Integer>();
    private String a1,a2,a3,a4,a5,a6,a7,a8;

    public void setTehdytTeht() {
       if (a1.equals("true")) {
           tehdyt.add(1);
        }       
       if(a2.equals("true")){
           tehdyt.add(2);
       }
        if(a3.equals("true")){
           tehdyt.add(3);
       }
       if(a4.equals("true")){
           tehdyt.add(4);
       }
        if(a5.equals("true")){
           tehdyt.add(5);
       }
        if(a6.equals("true")){
           tehdyt.add(6);
       }
        if(a7.equals("true")){
           tehdyt.add(7);
       }
        if(a8.equals("true")){
           tehdyt.add(8);
       }   
        
    }
    
    
    
    public ArrayList getTehdytTeht(){
      
        setTehdytTeht();
  
        return tehdyt;
    }
   
 
    public int getTehdytTehtMaara(){
        setTehdytTeht();
       return tehdyt.size();
    }

    public String getStudent_number() {
        return student_number;
    }
 
    public String getWeek(){
        return week;
    }

    public String getHours(){
        return hours;
    }
    
  
    
    @Override
    public String toString() {
        return student_number;
    }
     
    
}