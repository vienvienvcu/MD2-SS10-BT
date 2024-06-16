package BT1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerMark {
    public static BKapStudent [] arrMark;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************** Manager Mark *******************:");
            System.out.println("1. Nhập vào thông tin điểm thi của n sinh viên Bách Khoa Aptech");
            System.out.println("2. Hiển thị thông tin vừa nhập");
            System.out.println("3.Sắp xếp và hiển thị thông tin tăng dần theo tên lớp");
            System.out.println("4.Sắp xếp và hiển thị thông tin giảm dần theo học bổng nhận được");
            System.out.println("5.Tìm kiếm thông tin sinh viên theo tên lớp");
            System.out.println("6.Kết thúc");
            System.out.println("your choice is:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputMark(scanner);
                    break;
                case 2:
                    displayMark();
                    break;
                case 3:
                    sortByClassName();
                    break;
                case 4:
                    sortByScholarShip();
                    break;
                case 5:
                    searchByClassName(scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choice 1-6, please try again ");
            }
        }while (true);
    }
    public static  void inputMark(Scanner scanner){
        System.out.println("Nhập vào thông tin điểm thi của n sinh viên Bách Khoa Aptech ");
         int n = Integer.parseInt(scanner.nextLine());
         arrMark = new BKapStudent[n];
         for (int i = 0; i < n; i++) {
             arrMark[i] = new BKapStudent();
             arrMark[i].input();
         }
    }

    public static void displayMark(){
       for (int i = 0; i < arrMark.length; i++) {
           arrMark[i].display();
       }
    }
    public static void sortByClassName(){
        Arrays.sort(arrMark, new SortByClassName());

    }
    public static void sortByScholarShip(){
        Arrays.sort(arrMark, new SortByScholarShip());
    }
    public static void searchByClassName(Scanner scanner){
        System.out.println("nhap ten lop ban muon tim kiem thong tin");
        String className = scanner.nextLine().toLowerCase();
        for (int i = 0; i < arrMark.length; i++) {
            if (arrMark[i].getClassName().toLowerCase().contains(className)){
                arrMark[i].display();
            }
        }
    }
}
