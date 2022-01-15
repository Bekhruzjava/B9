package Mashgulotlar.service;

import Mashgulotlar.entity.Currency;
import Mashgulotlar.entity.Measurement;
import entity.Response;
import lombok.SneakyThrows;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeasurementService {
    public boolean add_measurement(Integer id,String name) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into measurement values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        boolean execute = preparedStatement.execute();
        System.out.println("Added!");
        return execute;
    }
@SneakyThrows
    public Response edit_measurement(Integer id,String name,boolean active) {
        Response response=new Response();

        Connection connection= DbConfig.ulanish();
        CallableStatement callableStatement;
        callableStatement=connection.prepareCall("{call edit_meausurement(?,?,?,?,?)}");

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

    public List<Measurement> show_measurement() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = null;
        try {
            statement = ulanish.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = statement.executeQuery("select*from measurement");
        List<Measurement> measurements = new ArrayList<>();
        while (resultSet.next()) {
            Measurement measurement = new Measurement();

            measurement.setId(resultSet.getInt(1));
            measurement.setName(resultSet.getString(2));
            measurement.setActive(resultSet.getBoolean(3));
            measurements.add(measurement);
        }
        return measurements;
    }

    public void delete_measurement() {

    }
}
