package Mashgulotlar.service;

import Mashgulotlar.entity.Currency;
import entity.Category;
import entity.Response;
import lombok.SneakyThrows;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyService {
    public boolean add_currency(Integer id, String name) throws SQLException {
        Connection connection= DbConfig.ulanish();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into currency values(?,?,?)");
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setBoolean(3,true);
        boolean execute=preparedStatement.execute();
        System.out.println("Added!");
        return execute;
    }
@SneakyThrows
    public Response edit_currency(Integer id,String name,boolean active) {
        Response response=new Response();

        Connection connection= DbConfig.ulanish();
        CallableStatement callableStatement;
        callableStatement=connection.prepareCall("{call edit_currency(?,?,?,?,?)}");

        callableStatement.setInt(1,id);
        callableStatement.setString(2,name);
        callableStatement.setBoolean(3,true);

        callableStatement.registerOutParameter(4,Types.BOOLEAN);
        callableStatement.registerOutParameter(5,Types.VARCHAR);
        callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(4));
        response.setMessage(callableStatement.getString(5));
        System.out.println("Updated!");
        return response;
    }

    public List<Currency> show_currency() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = null;
        try {
            statement = ulanish.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = statement.executeQuery("select*from curreny");
        List<Currency> currencies = new ArrayList<>();
        while (resultSet.next()) {
            Currency currency = new Currency();

            currency.setId(resultSet.getInt(1));
            currency.setName(resultSet.getString(2));
            currency.setActive(resultSet.getBoolean(3));
            currencies.add(currency);
        }
        return currencies;

    }

    public void delete_currency() {

    }
}
