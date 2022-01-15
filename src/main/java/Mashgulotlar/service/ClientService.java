package Mashgulotlar.service;

import Mashgulotlar.entity.Client;
import entity.Category;
import entity.Response;
import lombok.SneakyThrows;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public boolean add_client(Integer id,String name,String phone) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into client values(?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        preparedStatement.setString(4,phone);
        boolean execute = preparedStatement.execute();
        System.out.println("Added!");
        return execute;
    }
@SneakyThrows
    public Response edit_client(Integer id,String name,boolean active,String phone) {
        Response response=new Response();

        Connection connection= DbConfig.ulanish();
        CallableStatement callableStatement;
        callableStatement=connection.prepareCall("{call edit_client(?,?,?,?,?,?)}");

        callableStatement.setInt(1,id);
        callableStatement.setString(2,name);
        callableStatement.setBoolean(3,false);
        callableStatement.setString(4,phone);

        callableStatement.registerOutParameter(5,Types.BOOLEAN);
        callableStatement.registerOutParameter(6,Types.VARCHAR);
        callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(5));
        response.setMessage(callableStatement.getString(6));
        System.out.println("Updated!");
        return response;
    }

    public List<Client> show_client() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = null;
        try {
            statement = ulanish.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = statement.executeQuery("select*from client");
        List<Client> clients = new ArrayList<>();
        while (resultSet.next()) {
            Client client = new Client();

            client.setId(resultSet.getInt(1));
            client.setName(resultSet.getString(2));
            client.setActive(resultSet.getBoolean(3));
            client.setPhone(resultSet.getString(4));
            clients.add(client);
        }
        return clients;
    }

    public void delete_client() {

    }
}
