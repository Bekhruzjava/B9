import entity.Category;
import entity.Response;
import lombok.Setter;
import repository.CategoryRepository;
import utils.DbConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER_STR=new Scanner(System.in);
    public static final Scanner SCANNER_NUM=new Scanner(System.in);
    // public static Connection ulanish = DbConfig.ulanish();

    public static void main(String[] args) throws SQLException {
//        System.out.println("Id sini kiriting:");
//        int id = SCANNER_NUM.nextInt();
//        System.out.println("name ni kiriting:");
//        String name = SCANNER_STR.nextLine();
//        CategoryRepository.addCurrency(id,name);
//        System.out.println(CategoryRepository.getcategories());


        System.out.println("Nomini kiriting:");
        String name=SCANNER_STR.nextLine();
        System.out.println("Type ni kiriting");
        String type=SCANNER_STR.nextLine();
        System.out.println("Yangi nomini kiriting:");
        String newname=SCANNER_STR.nextLine();
        Response response = CategoryRepository.callFunction(name, type, newname);
        System.out.println(response);

    }
}
