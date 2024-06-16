package model;

import sevies.BookManagement;
import sevies.CategoryManagement;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Book implements IBaseObject {
    private String BookId;
    private String title;
    private String author;
    private int year;
    private String description;
    private Category category;

    public Book() {

    }
    public Book(String bookId, String title, String author, int year, String description, Category category) {
        BookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.category = category;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void inputData() {
       Scanner scanner = new Scanner(System.in);
//       1. Mã sách (bắt đầu bằng “B”, độ dài 4 kí tự, duy nhất)
        this.BookId = inputBookId(scanner);
//       2. Tiêu đề sách (từ 6-50 kí tự, duy nhất)
        this.title = inputTitle(scanner);
//       3. Tên tác giả (không bỏ trống)
        this.author = inputAuthor(scanner);
//       4. Năm xuất bản (tối thiểu từ năm 1970 và không lớn hơn năm hiện tại)
        this.year = inputYear(scanner);
//       5. Mô tả sách (không bỏ trống)
        this.description = inputDescription(scanner);
//       6. Mã thể loại sách (phải lấy từ danh sách Thể loại sách đã lưu trước đó)
        this.category = inputCategory(scanner);

    }

    public void updateBookData(Scanner scanner) {
        //       2. Tiêu đề sách (từ 6-50 kí tự, duy nhất)
        this.title = inputTitle(scanner);
//       3. Tên tác giả (không bỏ trống)
        this.author = inputAuthor(scanner);
//       4. Năm xuất bản (tối thiểu từ năm 1970 và không lớn hơn năm hiện tại)
        this.year = inputYear(scanner);
//       5. Mô tả sách (không bỏ trống)
        this.description = inputDescription(scanner);
//       6. Mã thể loại sách (phải lấy từ danh sách Thể loại sách đã lưu trước đó)
        this.category = inputCategory(scanner);

    }

    public String inputBookId(Scanner scanner){
        System.out.println("Enter Book Id:");
        do {
            String bookIdRegex = "^B\\w{3}$";
            String bookId = scanner.nextLine();
            if (Pattern.matches(bookIdRegex, bookId)) {
                boolean isExist = false;
                for (int i = 0; i < BookManagement.bookIndex; i++) {
                    if(BookManagement.arrBooks[i].getBookId().equals(bookId)){
                        isExist = true;
                        break;
                    }
                }
                if(isExist){
                    System.err.println("Book Id already exists");
                }else {
                    return bookId;
                }
            }else {
                System.out.println(" Book Id first character is B and it has 4 character. (Bxxx)");
            }

        }while (true);
    }

    public String inputTitle(Scanner scanner){
        System.out.println("Enter Title of Book:");
        do {
            String bookTitle = scanner.nextLine();
            if (bookTitle.length()>=6 && bookTitle.length()<=50) {
                boolean isExist = false;
                for (int i = 0; i < BookManagement.bookIndex; i++) {
                    if(BookManagement.arrBooks[i].getTitle().equals(bookTitle)){
                        isExist = true;
                        break;
                    }
                }
                if (isExist){
                    System.err.println("Book Title already exists");
                }else {
                    return bookTitle;
                }
            }else {
                System.err.println("Book Title length must be between 6 and 50");
            }
        }while (true);
    }
    public String inputAuthor(Scanner scanner){
        System.out.println("Enter Author of Book:");
        do {
         String bookAuthor = scanner.nextLine();
         if (bookAuthor.length()>0) {
             return bookAuthor;
         }else {
             System.err.println("Book Author cannot be empty");
         }
        }while (true);
    }

    public int inputYear(Scanner scanner){
        System.out.println("Enter Year of Book:");
        do {
            int bookYear = Integer.parseInt(scanner.nextLine());
            if (bookYear>1970 && bookYear<2024) {
                return bookYear;
            }else {
                System.err.println("Book Year must be between 1970 and 2024");
            }
        }while (true);
    }

    public String inputDescription(Scanner scanner){
        System.out.println("Enter Description of Book:");
        do {
            String bookDescription = scanner.nextLine();
            if (bookDescription.length()>0) {
                return bookDescription;
            }else {
                System.err.println("Book Description cannot be empty");
            }
        }while (true);
    }

    public Category inputCategory(Scanner scanner){
        if (CategoryManagement.categoryIndex>0){
            System.out.println("Enter Category of Book:");
            do {
                int categoryId = Integer.parseInt(scanner.nextLine());
                Category categoryFind = null;
                for (int i = 0; i < CategoryManagement.categoryIndex; i++) {
                    if (CategoryManagement.arrCategories[i].getCategoryId() == categoryId) {
                        categoryFind = CategoryManagement.arrCategories[i];
                        break;
                    }
                }
                if (categoryFind != null) {
                    return categoryFind;
                }else {
                    System.err.println("Category Id not found");
                }
            }while (true);
        }else {
            System.err.println("Before enter Category of Book:");
        }
        return null;
    }
    @Override
    public void displayData() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Book Id", "Title", "Author", "Year", "Description","Category");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", this.BookId,this.title,this.author,this.year,this.description,this.category.getCategoryName());
    }
}
