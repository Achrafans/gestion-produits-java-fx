package net.achraf.gestionproduits.service;

import net.achraf.gestionproduits.dao.IproductDao;
import net.achraf.gestionproduits.dao.impl.ProductDaoImpl;
import net.achraf.gestionproduits.entities.Product;
import net.achraf.gestionproduits.service.impl.ProductServiceImpl;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        IProductService productService = new ProductServiceImpl(new ProductDaoImpl());
       /* Product product = new Product();
        product.setName("Iphone");
        product.setPrice(255);*/

      /*  Product product = new Product();
        product.setName("Pc Portable");
        product.setPrice(350);

        productService.addProduct(product);*/
        /*List<Product> products = productService.getAllProducts();
        products.forEach( p -> System.out.println(p.toString()));*/

        Product p = productService.getProductById(1L);
        System.out.println(p.toString());

    }
}
