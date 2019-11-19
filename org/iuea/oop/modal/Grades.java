package org.iuea.oop.modal;

public class Grades {
	String courseUnit;
    static int assignment;
    static int courseWork;
    static int practical;
    static int presentation;
    static int finalExam;
    
    /*creating a constructor that help initialize the attributes of the Grades class, calculate the final mark of a student
    and assign a grade*/
    public Grades(String courseUnit, int assignment, int courseWork, int practical, int presentation, int finalExam){
        this.courseUnit=courseUnit;
        this.assignment=assignment;
        this.courseWork=courseWork;
        this.practical=practical;
        this.presentation=presentation;
        this.finalExam=finalExam;
        
        //calculating the final mark of a student
        int fmark=(assignment+courseWork+practical+presentation+finalExam)/5;
          System.out.println(fmark);
          
          //setting conditions that give a grade to a student 
          if(fmark>=80){
              System.out.println('A');
          }else if(fmark>=70){
              System.out.println('B');
          }else if(fmark>=60){
              System.out.println('C');
          }else if(fmark>=50){
              System.out.println('D');
          }else{
              System.out.println('E');
          }
    }
    
    //creating the main method to make the class be able to run
    public static void main(String[]args){
        
    }
    
  
}
