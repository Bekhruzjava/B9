package Mashgulotlar;

import Mashgulotlar.service.AllService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER_STR = new Scanner(System.in);
    public static final Scanner SCANNER_NUM = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        AllService allService = new AllService();
        while (true) {
            System.out.println("1.Category CRUD");
            System.out.println("2.Currency CRUD");
            System.out.println("3.Measurement CRUD");
            System.out.println("4.Product CRUD");
            System.out.println("5.USER CRUD");
            System.out.println("6.Client CRUD:");
            System.out.println("0.Back:");
            System.out.print("Select:");
            int option = SCANNER_NUM.nextInt();
            switch (option) {
                case 1:
                    allService.category_crud();
                    break;
                case 2:
                    allService.currency_crud();
                    break;
                case 3:
                    allService.measurement_crud();
                    break;
                case 4:
                    allService.product_crud();
                    break;
                case 5:
                    allService.user_crud();
                    break;
                case 6:
                    allService.client_crud();
                    break;
                case 0:
                    return;
            }
        }
    }
}
