package net.achraf.gestionproduits.service;

import net.achraf.gestionproduits.entities.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
