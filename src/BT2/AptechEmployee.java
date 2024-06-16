package BT2;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class AptechEmployee extends Employee {
    private String unit;
    private String trainingField;

    public AptechEmployee() {

    }
    public AptechEmployee(String unit, String trainingField) {
        this.unit = unit;
        this.trainingField = trainingField;
    }

    public AptechEmployee(String employeeId, String employeeName, boolean gender, Date createDate, String employeeAddress, String company, String department, String position, double coefficientsSalary, int numberJobsInMonth, String unit, String trainingField) {
        super(employeeId, employeeName, gender, createDate, employeeAddress, company, department, position, coefficientsSalary, numberJobsInMonth);
        this.unit = unit;
        this.trainingField = trainingField;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTrainingField() {
        return trainingField;
    }

    public void setTrainingField(String trainingField) {
        this.trainingField = trainingField;
    }
    @Override
    public void input() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.println("Enter unit: ");
        this.unit = scanner.nextLine();
        System.out.println("Enter training field: ");
        this.trainingField = scanner.nextLine();
    }

    public void display() {
        super.display();
        System.out.printf("%-20s %-20s\n","Unit","Training Field");
        System.out.printf("%-20s %-20s\n",this.unit,this.trainingField);
    }
}
