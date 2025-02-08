package org.example.classes;

import java.util.Scanner;

public class Supplier {
    private String supplierId;

    public Supplier(String supplierId) {
        this.supplierId = supplierId;
    }

    public void updateProductDetails(Product product, String destination) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        String enteredProductId = scanner.nextLine();

        boolean productExists = false;
        for (Block block : Blockchain.blockchain) {
            if (block.data.contains("Product ID: " + enteredProductId)) {
                productExists = true;
                break;
            }
        }

        if (productExists) {
            product.setSupplierId(supplierId);
            product.setDestination(destination);
            String data = "Product ID: " + product.getProductId() + ", Product Name: " + product.getProductName() + ", Date: " + product.getCreationDate() + ", Supplier ID: " + supplierId + ", Destination: " + destination;

            String previousHash;
            if (Blockchain.blockchain.size() > 0) {
                previousHash = Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash;
            } else {
                previousHash = "0";
            }

            Block newBlock = new Block(Blockchain.blockchain.size(), data, previousHash);
            Blockchain.addBlock(newBlock);
            System.out.println("Product details updated for product: " + product.getProductId());
        } else {
            System.err.println("Error: Product ID does not match manufacturer entries.");
        }
    }
}