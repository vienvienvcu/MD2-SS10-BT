package sevies;

import model.Book;

import java.util.Scanner;

public class BookManagement {
    public static Book[] arrBooks = new Book[100];
    public static int bookIndex = 0;

    public static void menuBookManagement() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("*****************BOOK MANAGEMENT *********************");
            System.out.println("1.Add list Book");
            System.out.println("2.Show list Book");
            System.out.println("3.Update element Book");
            System.out.println("4.Delete element Book");
            System.out.println("5.Search book by mane");
            System.out.println("6. back");
            System.out.println("your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                  BookManagement.addBook(scanner);
                    break;
                case 2:
                  BookManagement.displayBook();
                    break;
                case 3:
                  BookManagement.updateBook(scanner);
                    break;
                case 4:
                  BookManagement.deleteBook(scanner);
                    break;
                case 5:
                  BookManagement.searchBookByName(scanner);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.out.println("please choice 1-6");
            }
        } while (isExit);
    }

    public static void addBook(Scanner scanner) {
        System.out.println("Enter number of books you want to add");
        int numberOfBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("book of information : " + (i + 1));
            arrBooks[bookIndex] = new Book();
            arrBooks[bookIndex].inputData();
            bookIndex++;
        }
    }
    public static void displayBook() {
        for (int i = 0; i < bookIndex; i++) {
            arrBooks[i].displayData();
        }
    }
    public static void updateBook(Scanner scanner) {
        System.out.println("Enter books id you want to update");
        String bookId = scanner.nextLine();
        int indexUpdate = getIndexById(bookId);
        if (indexUpdate>=0){
            arrBooks[indexUpdate].updateBookData(scanner);
        }else {
            System.err.println("index does not exist");
        }
    }
    public static int getIndexById(String bookId) {
        for (int i = 0; i < bookIndex; i++) {
         if (arrBooks[i].getBookId().equals(bookId)) {
             return i;
         }
        }
        return -1;
    }
    public static void deleteBook(Scanner scanner) {
       System.out.println("Enter books id you want to delete");
       String bookId = scanner.nextLine();
       int indexDelete = getIndexById(bookId);
       if (indexDelete>=0) {
           for (int i = indexDelete; i < bookIndex; i++) {
               arrBooks[i] = arrBooks[i + 1];

           }
           bookIndex--;
       }else {
           System.err.println("index does not exist");
       }
    }
    public static void searchBookByName(Scanner scanner) {
        System.out.println("Enter book name  you want to search");
        String bookName = scanner.nextLine().toLowerCase();
        int cntBook = 0;
        for (int i = 0; i < bookIndex; i++) {
            if (arrBooks[i].getTitle().toLowerCase().contains(bookName)){
                arrBooks[i].displayData();
                cntBook++;
            }
        }
       if (cntBook == 0){
           System.out.println("not fount");
       }
        System.out.println("fount book : " + cntBook);
    }
}

