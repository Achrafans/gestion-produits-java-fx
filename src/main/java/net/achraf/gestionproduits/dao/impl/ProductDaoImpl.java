package net.achraf.gestionproduits.dao.impl;

import net.achraf.gestionproduits.dao.DbConnection;
import net.achraf.gestionproduits.dao.IproductDao;
import net.achraf.gestionproduits.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IproductDao {
    @Override
    public void create(Product product) throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO PRODUCTS(NAME, PRICE) VALUES(?,?)");
        pstm.setString(1, product.getName());
        pstm.setDouble(2, product.getPrice());
        pstm.executeUpdate();
    }

    @Override
    public void update(Product product) throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE PRODUCTS SET name = ? , price = ? WHERE id = ? ");
        pstm.setString(1, product.getName());
        pstm.setDouble(2, product.getPrice());
        pstm.setLong(3, product.getId());
        pstm.executeUpdate();

    }

    @Override
    public void delete(Product product) throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUCTS WHERE id = ? ");
        pstm.setLong(1, product.getId());
        pstm.executeUpdate();

    }

    @Override
    public List<Product> findAll() throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PRODUCTS");
        ResultSet rs = pstm.executeQuery();
        List<Product> products = new ArrayList<Product>();
        while(rs.next()) {
            Product product = new Product();
            product.setId(rs.getLong("ID"));
            product.setName(rs.getString("NAME"));
            product.setPrice(rs.getDouble("PRICE"));
            products.add(product);
        }
        return products;
    }

    @Override
    public Product findById(Long id) throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE id = ?");
        pstm.setLong(1,id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            return product;
        } else {
            return null;
        }


    }
}
