package repository;

import entity.Category;
import entity.Response;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public static List<Category> getcategories() throws SQLException {
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
    public static boolean addCategory(int id, String name) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into category values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        boolean execute = preparedStatement.execute();
        return execute;
    }
    public static boolean addCurrency(int id,String name) throws SQLException {
        Connection connection=DbConfig.ulanish();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into currency values(?,?,?)");
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setBoolean(3,true);
        boolean execute=preparedStatement.execute();
        return execute;
    }
    public static Response callFunction(String name,String type,String n_name) throws SQLException {
        Response response=new Response();
        Connection connection=DbConfig.ulanish();
        CallableStatement callableStatement=connection.prepareCall("{call category_crud(?,?,?,?,?)} ");
        callableStatement.setString(1,name);
        callableStatement.setString(2,type);
        callableStatement.setString(3,n_name);
        callableStatement.registerOutParameter(4,Types.BOOLEAN);
        callableStatement.registerOutParameter(5,Types.VARCHAR);
      callableStatement.execute();
      response.setSuccess(callableStatement.getBoolean(4));
      response.setMessage(callableStatement.getString(5));

        return response;
    }
}
