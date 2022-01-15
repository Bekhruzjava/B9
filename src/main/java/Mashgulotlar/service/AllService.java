package Mashgulotlar.service;

import java.sql.SQLException;
import java.util.Scanner;

public class AllService {
    public static final Scanner SCANNER_STR = new Scanner(System.in);
    public static final Scanner SCANNER_NUM = new Scanner(System.in);
    public static CategoryService categoryService = new CategoryService();
    static CurrencyService currencyService = new CurrencyService();
    static ProductService productService = new ProductService();
    static ClientService clientService = new ClientService();
    static MeasurementService measurementService = new MeasurementService();
    static UserService userService = new UserService();

    public void category_crud() throws SQLException {
        while (true) {
            System.out.println("1.Add Category");
            System.out.println("2.Update Category");
            System.out.println("3.Show Category");
            System.out.println("4.Delete Category");
            System.out.println("0.Back");
            System.out.println("Select:");
            int option = SCANNER_NUM.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Input id:");
                    int id = SCANNER_NUM.nextInt();
                    System.out.println("Input name:");
                    String name = SCANNER_STR.nextLine();
                    CategoryService.add_category(id, name);
                }
                break;
                case 2:{
                    System.out.println("Input id:");
                    int id = SCANNER_NUM.nextInt();
                    System.out.println("Input name:");
                    String name = SCANNER_STR.nextLine();
                    categoryService.edit_category(id,name,true);
                }
                    break;
                case 3:
                    categoryService.show_category();
                    break;
                case 4:
                    categoryService.delete_category();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void currency_crud() throws SQLException {
        System.out.println("1.Add Currency");
        System.out.println("2.Update Currency");
        System.out.println("3.Show Currency");
        System.out.println("4.Delete Currency");
        System.out.println("0.Back");
        System.out.println("Select:");
        int option = SCANNER_NUM.nextInt();
        switch (option) {
            case 1: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                currencyService.add_currency(id, name);
            }
            break;
            case 2: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                currencyService.edit_currency(id,name,true);
            }
                break;
            case 3:
                currencyService.show_currency();
                break;
            case 4:
                currencyService.delete_currency();
                break;
            case 0:
                return;
        }
    }

    public void measurement_crud() throws SQLException {
        System.out.println("1.Add Measurement");
        System.out.println("2.Update Measurement");
        System.out.println("3.Show Measurement");
        System.out.println("4.Delete Measurement");
        System.out.println("0.Back");
        System.out.println("Select:");
        int option = SCANNER_NUM.nextInt();
        switch (option) {
            case 1: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                measurementService.add_measurement(id, name);
            }
            break;
            case 2: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                measurementService.edit_measurement(id,name,true);
            }
                break;
            case 3:
                measurementService.show_measurement();
                break;
            case 4:
                measurementService.delete_measurement();
                break;
            case 0:
                return;
        }
    }

    public void product_crud() throws SQLException {
        System.out.println("1.Add Product");
        System.out.println("2.Update Product");
        System.out.println("3.Show Product");
        System.out.println("4.Delete Product");
        System.out.println("0.Back");
        System.out.println("Select:");
        int option = SCANNER_NUM.nextInt();
        switch (option) {
            case 1: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                System.out.println("Input category_id :");
                int categoryid = SCANNER_NUM.nextInt();
                System.out.println(" Input measurement_id:");
                int measurementid = SCANNER_NUM.nextInt();
                System.out.println("Input attachment_id:");
                int attachmentid = SCANNER_NUM.nextInt();
                productService.add_product(id, name, categoryid, measurementid, attachmentid);
            }
            break;
            case 2: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                System.out.println("Input category_id :");
                int categoryid = SCANNER_NUM.nextInt();
                System.out.println(" Input measurement_id:");
                int measurementid = SCANNER_NUM.nextInt();
                System.out.println("Input attachment_id:");
                int attachmentid = SCANNER_NUM.nextInt();
                productService.edit_product(id,name,true,categoryid,measurementid,attachmentid);
            }
                break;
            case 3:
                productService.show_product();
                break;
            case 4:
                productService.delete_product();
                break;
            case 0:
                return;
        }
    }

    public void user_crud() throws SQLException {
        System.out.println("1.Add User");
        System.out.println("2.Update User");
        System.out.println("3.Show User");
        System.out.println("4.Delete User");
        System.out.println("0.Back");
        System.out.println("Select:");
        int option = SCANNER_NUM.nextInt();
        switch (option) {
            case 1: {
                System.out.println(" Input id :");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input email :");
                String email = SCANNER_STR.nextLine();
                System.out.println("Input password :");
                String password = SCANNER_STR.nextLine();
                System.out.println("Input fullname :");
                String fullname = SCANNER_STR.nextLine();
                System.out.println("Input phone :");
                String phone = SCANNER_STR.nextLine();
                userService.add_user(id, email, password, fullname, phone);
            }
            break;
            case 2:{
                System.out.println(" Input id :");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input email :");
                String email = SCANNER_STR.nextLine();
                System.out.println("Input password :");
                String password = SCANNER_STR.nextLine();
                System.out.println("Input fullname :");
                String fullname = SCANNER_STR.nextLine();
                System.out.println("Input phone :");
                String phone = SCANNER_STR.nextLine();
                userService.edit_user(id,email,password,fullname,phone,true);
            }
                break;
            case 3:
                userService.show_user();
                break;
            case 4:
                userService.delete_user();
                break;
            case 0:
                return;
        }
    }

    public void client_crud() throws SQLException {
        System.out.println("1.Add Client");
        System.out.println("2.Update Client");
        System.out.println("3.Show Client");
        System.out.println("4.Delete Client");
        System.out.println("0.Back");
        System.out.println("Select:");
        int option = SCANNER_NUM.nextInt();
        switch (option) {
            case 1: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                System.out.println("Input phone:");
                String phone = SCANNER_STR.nextLine();
                clientService.add_client(id, name, phone);
            }
            break;
            case 2: {
                System.out.println("Input id:");
                int id = SCANNER_NUM.nextInt();
                System.out.println("Input name:");
                String name = SCANNER_STR.nextLine();
                System.out.println("Input phone:");
                String phone = SCANNER_STR.nextLine();
                clientService.edit_client(id,name,true,phone);
            }
                break;
            case 3:
                clientService.show_client();
                break;
            case 4:
                clientService.delete_client();
                break;
            case 0:
                return;
        }
    }
}
