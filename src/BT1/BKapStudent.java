package BT1;

import java.util.Scanner;

public class BKapStudent extends Mark{
    private String courseName;
    private double scholarShip;

    public BKapStudent(){

    }

    public BKapStudent(String courseName, double scholarShip) {
        this.courseName = courseName;
        this.scholarShip = scholarShip;
    }

    public BKapStudent(String fullName, Boolean gender, String className, float markOfC, float markOfHTML, float markOfSQL, float markOfPHP, String courseName, double scholarShip) {
        super(fullName, gender, className, markOfC, markOfHTML, markOfSQL, markOfPHP);
        this.courseName = courseName;
        this.scholarShip = scholarShip;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScholarShip() {
        return scholarShip;
    }

    public void setScholarShip(double scholarShip) {
        this.scholarShip = scholarShip;
    }
    @Override
    public void input(){
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.println("enter courseName");
        this.courseName = scanner.nextLine();
    }

    public double calculateScholarship(){
        do {
            if (averageMark()>=8 && getMarkOfSQL()>5 && getMarkOfPHP()>5 && getMarkOfHTML()>5 && getMarkOfC()>5){
                return 3500;

            }else if (averageMark()>=7 && averageMark()<8&& getMarkOfSQL()>5 && getMarkOfPHP()>5 && getMarkOfHTML()>5 && getMarkOfC()>5)
                return 2500;
            else {
                return 0;
            }
        }while (true);

    }

    @Override
    public float averageMark(){
        return  (this.getMarkOfSQL() + this.getMarkOfHTML() + this.getMarkOfC() + this.getMarkOfPHP())/4;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Course Name: " + courseName);
        System.out.println("Scholarship: " + calculateScholarship());
    }
}
