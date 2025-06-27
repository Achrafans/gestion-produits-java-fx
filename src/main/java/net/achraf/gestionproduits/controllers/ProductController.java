package net.achraf.gestionproduits.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.achraf.gestionproduits.dao.impl.ProductDaoImpl;
import net.achraf.gestionproduits.entities.Product;
import net.achraf.gestionproduits.service.IProductService;
import net.achraf.gestionproduits.service.impl.ProductServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML private TextField textFieldName;
    @FXML private TextField textFieldPrice;

    @FXML private TableView<Product> tableProducts;
    @FXML private TableColumn<Product, Long> columnId;
    @FXML private TableColumn<Product, String> columnName;
    @FXML private TableColumn<Product, Double> columnPrice;
    private IProductService productService;
    private ObservableList<Product> products = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productService = new ProductServiceImpl(new ProductDaoImpl());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        products.setAll(productService.getAllProducts());
        tableProducts.setItems(products);

        tableProducts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                loadSelectedProduct();
            }
        });

    }

    public void addProduct(){
        Product product = new Product();
        product.setName(textFieldName.getText());
        product.setPrice(Double.parseDouble(textFieldPrice.getText()));

        productService.addProduct(product);
        loadProducts();

        // Reset text field
        textFieldName.setText("");
        textFieldPrice.setText("");

    }

    public void deleteProduct(){
        Product product = tableProducts.getSelectionModel().getSelectedItem();
        productService.deleteProduct(product);
        loadProducts();

        // Reset text field
        textFieldName.setText("");
        textFieldPrice.setText("");

    }

    public void updateProduct() {
        Product product = tableProducts.getSelectionModel().getSelectedItem();
        product.setName(textFieldName.getText());
        product.setPrice(Double.parseDouble(textFieldPrice.getText()));

        productService.updateProduct(product);
        loadProducts();

        // Reset text field
        textFieldName.setText("");
        textFieldPrice.setText("");
    }

    private void loadProducts(){
        products.setAll(productService.getAllProducts());
    }

    private void loadSelectedProduct(){
        Product product  = tableProducts.getSelectionModel().getSelectedItem();
        textFieldName.setText(product.getName());
        textFieldPrice.setText(String.valueOf(product.getPrice()));
    }

}
