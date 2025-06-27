package net.achraf.gestionproduits.service.impl;

import net.achraf.gestionproduits.dao.IproductDao;
import net.achraf.gestionproduits.entities.Product;
import net.achraf.gestionproduits.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IproductDao productDao;

    public ProductServiceImpl(IproductDao productDao) {
        this.productDao = productDao;

    }

    @Override
    public void addProduct(Product product) {
        try{
            productDao.create(product);
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateProduct(Product product) {
        try{
            productDao.update(product);
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProduct(Product product) {
        try{
            productDao.delete(product);
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = null;
        try{
           products =  productDao.findAll();
        } catch(SQLException e){
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product getProductById(Long id) {
      Product product = null;
        try{
           product =  productDao.findById(id);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return product;
    }
}
