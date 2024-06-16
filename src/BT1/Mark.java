package BT1;

import java.util.Scanner;

public class Mark implements IMark{
 	 private String fullName;
     private Boolean gender;
     private String className;
     private float markOfC;
     private float markOfHTML;
     private float markOfSQL;
     private float markOfPHP;


    public Mark(){

    }
    public Mark(String fullName, Boolean gender, String className, float markOfC, float markOfHTML, float markOfSQL, float markOfPHP) {
        this.fullName = fullName;
        this.gender = gender;
        this.className = className;
        this.markOfC = markOfC;
        this.markOfHTML = markOfHTML;
        this.markOfSQL = markOfSQL;
        this.markOfPHP = markOfPHP;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getMarkOfC() {
        return markOfC;
    }

    public void setMarkOfC(float markOfC) {
        this.markOfC = markOfC;
    }

    public float getMarkOfHTML() {
        return markOfHTML;
    }

    public void setMarkOfHTML(float markOfHTML) {
        this.markOfHTML = markOfHTML;
    }

    public float getMarkOfSQL() {
        return markOfSQL;
    }

    public void setMarkOfSQL(float markOfSQL) {
        this.markOfSQL = markOfSQL;
    }

    public float getMarkOfPHP() {
        return markOfPHP;
    }

    public void setMarkOfPHP(float markOfPHP) {
        this.markOfPHP = markOfPHP;
    }
    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter full name");
        this.fullName = scanner.nextLine();
        System.out.println("enter gender");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("enter class");
        this.className = scanner.nextLine();
        System.out.println("enter mark of c");
        this.markOfC = Float.parseFloat(scanner.nextLine());
        System.out.println("enter mark of html");
        this.markOfHTML = Float.parseFloat(scanner.nextLine());
        System.out.println("enter mark of SQL");
        this.markOfSQL = Float.parseFloat(scanner.nextLine());
        System.out.println("enter mark of PHP");
        this.markOfPHP = Float.parseFloat(scanner.nextLine());
    }
    @Override
    public String toString() {
        String schoolName = "Bach Khoa – Aptech";
        return schoolName;
    }

    @Override
     public void display(){
        System.out.println("Full Name: " + this.fullName);
        System.out.printf("%s\n" , this.gender?"nam":"nu");
        System.out.println("Class Name: " + this.className);
        System.out.println("Mark of C: " + this.markOfC);
        System.out.println("Mark of HTML: " + this.markOfHTML);
        System.out.println("Mark of SQL: " + this.markOfSQL);
        System.out.println("Mark of PHP: " + this.markOfPHP);
        System.out.println("Mark of average: " + averageMark());
        System.out.println("school Name: " + schoolName);
     }

    @Override
    public float averageMark() {
        return (this.markOfC + this.markOfHTML + this.markOfPHP + this.markOfSQL)/4;
    }


}
