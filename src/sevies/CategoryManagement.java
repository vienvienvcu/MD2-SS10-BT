package sevies;

import model.Category;

import java.util.Scanner;

public class CategoryManagement {
    public static Category [] arrCategories = new Category[100];
    public static int categoryIndex = 0;
    public static void menuCategoryManagement() {
        boolean isExit = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*****************QUẢN LÝ THỂ LOẠI *********************");
            System.out.println("1.Thêm mới thể loại");
            System.out.println("2.Hiển thị danh sách theo tên thể loại A – Z");
            System.out.println("3.Thống kê thể loại và số sách có trong mỗi thể loại");
            System.out.println("4.Cập nhật thể loại");
            System.out.println("5.Xóa thể loại (kiểm tra tồn tai sách trước khi xóa)");
            System.out.println("6. Quay lại");
            System.out.println("your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CategoryManagement.inputCategory(scanner);
                    break;
                case 2:
                   CategoryManagement.displayCategory();
                    break;
                case 3:
                    CategoryManagement.statisticalCategory(scanner);
                    break;
                case 4:
                    CategoryManagement.updateCategory(scanner);
                    break;
                case 5:
                    CategoryManagement.deleteCategory(scanner);
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.out.println("please choice 1-6");
            }

        }while (isExit);
    }

    public static void inputCategory(Scanner scanner){

        System.out.println("enter the book number of elements you want to insert: ");
        int n = Integer.parseInt(scanner.nextLine());
         for (int i = 0; i <n; i++) {
             System.out.println("Book category information : " + (i +1));
             arrCategories[categoryIndex] = new Category();
             arrCategories[categoryIndex].inputData();
             categoryIndex++;
         }
    }
    public static void displayCategory(){
        for (int i = 0; i < categoryIndex; i++) {
            arrCategories[i].displayData();
        }
    }
    public static void statisticalCategory(Scanner scanner){
        System.out.println("enter book category name you want to statistics: ");
        String categoryName = scanner.nextLine().toLowerCase();
        int cntCategory = 0;
        for (int i = 0; i < categoryIndex; i++) {
           if (arrCategories[i].getCategoryName().toLowerCase().contains(categoryName)) {
               arrCategories[i].displayData();
               cntCategory++;
           }
        }
        if (cntCategory == 0){
            System.err.println("book category does not exist");
        }
        System.out.println("số sách có trong mỗi thể loại :" + cntCategory);
    }

    public static void updateCategory(Scanner scanner){
        System.out.println("enter book category id  you want to update: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int categoryIndexUpdate = getCategoryIndexById(categoryId);
        if (categoryIndexUpdate>= 0){
            arrCategories[categoryIndexUpdate].updateCategoryData(scanner);
        }else {
            System.err.println("book category does not exist");
        }
    }

    public static int getCategoryIndexById(int categoryId){
        for(int i = 0; i < categoryIndex; i++) {
         if (CategoryManagement.arrCategories[i].getCategoryId() == categoryId){
             return i;
          }
        }
        return -1;
    }
 public static void deleteCategory(Scanner scanner){
        System.out.println("enter book category id you want to delete: ");
        int categoryId = Integer.parseInt(scanner.nextLine());
        int categoryIndexDelete = getCategoryIndexById(categoryId);
        if (categoryIndexDelete >= 0){
            boolean isExist = false;
            for (int i = 0; i < BookManagement.bookIndex; i++) {
                if (BookManagement.arrBooks[i].getCategory().getCategoryId() == categoryId){
                    isExist = true;
                    break;
                }
            }
            if (isExist){
                System.err.println("book category existing in book the cannot delete, please try again, please try again");
            }else {
                for (int i = categoryIndexDelete; i < categoryIndex; i++) {
                    arrCategories[i] =arrCategories[i+1];
                }
                categoryIndex--;
            }
        }else {
            System.err.println("book category does not exist");
        }
    }

}
