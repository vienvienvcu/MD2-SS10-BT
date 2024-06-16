package run;

import sevies.BookManagement;
import sevies.CategoryManagement;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************MENU**************************");
            System.out.println("1. Management categorys");
            System.out.println("2. Management books");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CategoryManagement.menuCategoryManagement();
                    break;
                case 2:
                    BookManagement.menuBookManagement();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choice 1-3");
            }
        }while (true);
    }
}
