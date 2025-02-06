package org.example.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String productId;
    private String productName;
    private String manufacturerId;
    private String supplierId;
    private String destination;
    private String creationDate;

    public Product(String productId, String productName, String manufacturerId) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturerId = manufacturerId;
        this.creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCreationDate() {
        return creationDate;
    }
}