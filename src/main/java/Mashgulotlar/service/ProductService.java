package Mashgulotlar.service;

import Mashgulotlar.entity.Currency;
import Mashgulotlar.entity.Product;
import entity.Response;
import lombok.SneakyThrows;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public boolean add_product(Integer id,String name,Integer category_id,Integer measurement_id,Integer attachment_id) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        preparedStatement.setInt(4, category_id);
        preparedStatement.setInt(5, measurement_id);
        preparedStatement.setInt(6, attachment_id);
        boolean execute = preparedStatement.execute();
        System.out.println("Added!");
        return execute;
    }
@SneakyThrows
    public Response edit_product(Integer id,String name,boolean active,Integer category_id,Integer measurement_id,Integer attachment_id) {
        Response response=new Response();

        Connection connection= DbConfig.ulanish();
        CallableStatement callableStatement;
        callableStatement=connection.prepareCall("{call edit_product(?,?,?,?,?,?,?,?)}");

        callableStatement.setInt(1,id);
        callableStatement.setString(2,name);
        callableStatement.setBoolean(3,false);
        callableStatement.setInt(4,category_id);
        callableStatement.setInt(5,measurement_id);
        callableStatement.setInt(6,attachment_id);

        callableStatement.registerOutParameter(7,Types.BOOLEAN);
        callableStatement.registerOutParameter(8,Types.VARCHAR);
        callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(7));
        response.setMessage(callableStatement.getString(8));
        System.out.println("Updated!");
        return response;
    }

    public List<Product> show_product() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement = null;
        try {
            statement = ulanish.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = statement.executeQuery("select*from product");
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();

            product.setId(resultSet.getInt(1));
            product.setName(resultSet.getString(2));
            product.setActive(resultSet.getBoolean(3));
            product.setCategory_id(resultSet.getInt(4));
            product.setMeasurement_id(resultSet.getInt(5));
            product.setAttachment_id(resultSet.getInt(6));
            products.add(product);
        }
        return products;
    }

    public void delete_product() {

    }
}
