package Mashgulotlar.service;

import entity.Category;
import entity.Response;
import lombok.SneakyThrows;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    public static boolean add_category(Integer id,String name) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into category values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        boolean execute = preparedStatement.execute();
        System.out.println("Added!");
        return execute;
    }
@SneakyThrows
    public Response edit_category(Integer id,String name,boolean active) {
        Response response=new Response();

        Connection connection= DbConfig.ulanish();
        CallableStatement callableStatement;
        callableStatement=connection.prepareCall("{call edit_category(?,?,?,?,?)}");

        callableStatement.setInt(1,id);
        callableStatement.setString(2,name);
        callableStatement.setBoolean(3,false);

        callableStatement.registerOutParameter(4,Types.BOOLEAN);
        callableStatement.registerOutParameter(5,Types.VARCHAR);
        callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(4));
        response.setMessage(callableStatement.getString(5));
        System.out.println("Updated!");
        return response;
    }

    public List<Category> show_category() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = null;
        try {
            statement = ulanish.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = statement.executeQuery("select*from category");
        List<Category> categories = new ArrayList<>();
        while (resultSet.next()) {
            Category category = new Category();

            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
            category.setActive(resultSet.getBoolean(3));
            categories.add(category);
        }
        return categories;
    }

    public void delete_category() {

    }


}
