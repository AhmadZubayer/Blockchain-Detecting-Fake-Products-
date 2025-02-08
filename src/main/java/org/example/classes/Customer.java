package org.example.classes;

public class Customer {
    public boolean checkProduct(String productId) {
        boolean productFound = false;
        for (Block block : Blockchain.blockchain) {
            if (block.data.contains("Product ID: " + productId)) {
                System.out.println(block.data);
                productFound = true;
            }
        }
        return productFound;
    }
}
