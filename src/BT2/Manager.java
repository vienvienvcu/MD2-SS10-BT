package BT2;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Manager {
    public static AptechEmployee [] arrAptechEmployee;
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*******************MENU***********************:");
            System.out.println("1. Nhập thông tin cho n nhân viên Aptech");
            System.out.println("2. Hiển thị thông tin vừa nhập");
            System.out.println("3. Sắp xếp thông tin giảm dần theo thưởng và hiển thị");
            System.out.println("4. Sắp xếp thông tin tăng dần theo phòng ban và hiển thị");
            System.out.println("5. Tìm kiếm thông tin theo phòng ban");
            System.out.println("6. Thoát");
            System.out.println("your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputData(scanner);
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                  sortSortCalculateBonus();
                    break;
                case 4:
                    sortDepartment();
                    break;
                case 5:
                    searchDepartment(scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choice 1-6, please try again");
            }
        }while (true);
    }

    public static void inputData(Scanner scanner) throws ParseException {
        System.out.println("Enter number employee information");
        int n = Integer.parseInt(scanner.nextLine());
         arrAptechEmployee = new AptechEmployee[n];
         for (int i = 0; i < n; i++) {
             arrAptechEmployee[i] = new AptechEmployee();
             arrAptechEmployee[i].input();
         }
    }

    public static void displayData() {
        for (int i = 0; i < arrAptechEmployee.length; i++) {
            arrAptechEmployee[i].display();
        }
    }

    public static void sortSortCalculateBonus(){
        Arrays.sort(arrAptechEmployee, new SortCalculateBonus());
        displayData();
    }
    public static void sortDepartment(){
        Arrays.sort(arrAptechEmployee, new SortDepartment());
        displayData();
    }

    public static void searchDepartment(Scanner scanner){
        System.out.println("Enter the name of the department you want to search");
        String departmentName = scanner.nextLine().toLowerCase();
        for (int i = 0; i < arrAptechEmployee.length; i++) {
            if (arrAptechEmployee[i].getDepartment().toLowerCase().equals(departmentName)){
                arrAptechEmployee[i].display();
            }
        }

    }

}
