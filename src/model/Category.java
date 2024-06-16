package model;

import sevies.CategoryManagement;

import java.util.Scanner;

public class Category implements IBaseObject{
    private int categoryId;
    private String categoryName;
    private boolean status;

    public Category(){

    }
    public Category(int categoryId, String categoryName, boolean status) {

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
//1. Lớn hơn 0 tự tăng, không trùng lặp
        this.categoryId = inputCategoryId() ;
//2.Tên thể loại (không trùng nhau, từ 6-30 kí tự)
        this.categoryName = inputCategoryName(scanner);
//3.Trạng thái thể loại (chỉ nhận true/false khi nhập)
        this.status = categoryStatus(scanner);
    }

    public void updateCategoryData(Scanner scanner){
        System.out.println("da vao");
//2.Tên thể loại (không trùng nhau, từ 6-30 kí tự)
        this.categoryName = inputCategoryName(scanner);
//3.Trạng thái thể loại (chỉ nhận true/false khi nhập)
        this.status = categoryStatus(scanner);
    }

    public int inputCategoryId(){
      if (CategoryManagement.categoryIndex == 0){
          return 1;
      }else {
          int idMax = CategoryManagement.arrCategories[0].getCategoryId();
          for (int i = 1; i < CategoryManagement.categoryIndex; i++){
              if(idMax < CategoryManagement.arrCategories[i].getCategoryId()){
                  idMax = CategoryManagement.arrCategories[i].getCategoryId();
              }
          }
          return idMax +1;
      }
    }
    public String inputCategoryName(Scanner scanner){
        System.out.println("Enter Category Name: ");
        do {
            String categoryName = scanner.nextLine();
            if (categoryName.length() >0){
                boolean isExist = false;
                for (int i = 0; i <CategoryManagement.categoryIndex; i++){
                    if (CategoryManagement.arrCategories[i].getCategoryName().equals(categoryName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist){
                    System.err.println("Category Name Already Exist");
                }else {
                    return categoryName;
                }
            }else {
                System.err.println("category name cannot be empty,please try again");
            }
        }while (true);
    }

    public boolean categoryStatus(Scanner scanner){
        System.out.println("Enter Category Status: ");
        do {
            String categoryStatus = scanner.nextLine();
            if (categoryStatus.equals("true")|| categoryStatus.equals("false")){
                return Boolean.parseBoolean(categoryStatus);
            }else {
                System.err.println("category status  only value 2 true or false, please try again");
            }
        }while (true);
    }
@ Override
    public void displayData(){
        System.out.println("_______________________________________________________________________________________________");
        System.out.printf("%-15s %-20s %-10s\n", "categoryId", "categoryName", "status");
        System.out.printf("%-15s %-20s %-10s\n", this.categoryId, this.categoryName, this.status?"active": "no active");
    }
}
