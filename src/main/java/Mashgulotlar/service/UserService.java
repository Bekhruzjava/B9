package Mashgulotlar.service;

import Mashgulotlar.entity.Currency;
import Mashgulotlar.entity.User;
import entity.Response;
import lombok.SneakyThrows;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public boolean add_user(Integer id,String email,String password,String full_name,String phone) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(?,?,?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, full_name);
        preparedStatement.setString(5, phone);
        preparedStatement.setBoolean(6, true);
        boolean execute = preparedStatement.execute();
        System.out.println("Added!");
        return execute;
    }
@SneakyThrows
    public Response edit_user(Integer id,String email,String password,String fullname,String phone,boolean active) {
      Response response=new Response();

      Connection connection= DbConfig.ulanish();
      CallableStatement callableStatement;
      callableStatement=connection.prepareCall("{call edit_users(?,?,?,?,?,?,?,?)}");

      callableStatement.setInt(1,id);
      callableStatement.setString(2,email);
      callableStatement.setString(3,password);
      callableStatement.setString(4,fullname);
      callableStatement.setString(5,phone);
      callableStatement.setBoolean(6,true);

      callableStatement.registerOutParameter(7,Types.VARCHAR);
      callableStatement.registerOutParameter(8,Types.BOOLEAN);
      callableStatement.execute();
      response.setSuccess(callableStatement.getBoolean(8));
      response.setMessage(callableStatement.getString(7));
      System.out.println("Updated!");
      return response;
    }

    public List<User> show_user() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = null;
        try {
            statement = ulanish.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = statement.executeQuery("select*from users");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();

            user.setId(resultSet.getInt(1));
            user.setEmail(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFull_name(resultSet.getString(4));
            user.setPhone(resultSet.getString(5));
            user.setActive(resultSet.getBoolean(6));
            users.add(user);
        }
        return users;
    }

    public void delete_user() {

    }
}
