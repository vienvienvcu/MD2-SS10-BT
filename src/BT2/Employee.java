package BT2;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Employee implements IEmployee{

    private String employeeId;
    private String employeeName;
    private boolean gender;
    private Date createDate;
    private String employeeAddress;
    private String company;
    private String department;
    private String position;
    private double coefficientsSalary;
    private int numberJobsInMonth;

    public Employee (){

    }
    public Employee(String employeeId, String employeeName,
                    boolean gender, Date createDate, String employeeAddress,
                    String company, String department, String position,
                    double coefficientsSalary, int numberJobsInMonth) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.createDate = createDate;
        this.employeeAddress = employeeAddress;
        this.company = company;
        this.department = department;
        this.position = position;
        this.coefficientsSalary = coefficientsSalary;
        this.numberJobsInMonth = numberJobsInMonth;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public int getNumberJobsInMonth() {
        return numberJobsInMonth;
    }

    public void setNumberJobsInMonth(int numberJobsInMonth) {
        this.numberJobsInMonth = numberJobsInMonth;
    }


    @Override
    public void input() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        this.employeeId = scanner.nextLine();
        System.out.println("Enter Employee Name: ");
        this.employeeName = scanner.nextLine();
        System.out.println("Enter Gender: ");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter Create Date: ");
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        this.createDate = f.parse(scanner.nextLine());
        System.out.println("Enter Employee Address: ");
        this.employeeAddress = scanner.nextLine();
        System.out.println("Enter Company: ");
        this.company = scanner.nextLine();
        System.out.println("Enter Department: ");
        this.department = scanner.nextLine();
        System.out.println("Enter Position: ");
        this.position = scanner.nextLine();
        System.out.println("Enter Coefficients Salary: ");
        this.coefficientsSalary = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Number Jobs In Month: ");
        this.numberJobsInMonth = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void display() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                "Employee Id","Employee name", "gender",
                "Date","Address","Company", "Department","Position",
                "Coefficients","numberJobsInMonth","calculateBonus","calculateSalary");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20d %-20s %-20s\n",
                this.employeeId,this.employeeName,this.gender ? "Male" : "Female",
                this.createDate, this.employeeAddress,this.company,this.department, this.position,
                this.coefficientsSalary, this.numberJobsInMonth,nf.format(calculateBonus()),nf.format(calculateSalary()));
    }

    @Override
    public double calculateBonus() {
        if (getNumberJobsInMonth()>=5 && getNumberJobsInMonth()<=7) {
            return 2000;
        }else if(getNumberJobsInMonth()>=7 && getNumberJobsInMonth()<10) {
            return 5000;
        }else if(getNumberJobsInMonth()>=10) {
            return 10000;
        }
        return 0;
    }

    @Override
    public double calculateSalary() {
        return (basicSalay * getCoefficientsSalary()) + calculateBonus();
    }
}
