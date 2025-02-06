package org.example;

import org.example.classes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("FAKE PRODUCT DETECTION USING BLOCKCHAIN TECHNOLOGY----------------------");
        System.out.println();

        Blockchain.addBlock(new Block(0, "Genesis Block", "000000"));

        System.out.println("TO BE FILLED OUT BY THE MANUFACTURER: ");
        System.out.print("Enter Manufacturer ID: ");
        String manufacturerId = scanner.nextLine();
        Manufacturer manufacturer = new Manufacturer(manufacturerId);
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Manufacturer & Product Details Saved Successfully");
        System.out.println();
        Product product = new Product(productId, productName, manufacturerId);
        manufacturer.addProductToBlockchain(product);

        System.out.println("TO BE FILLED OUT BY THE SUPPLIER: ");
        System.out.print("Enter Supplier ID: ");
        String supplierId = scanner.nextLine();
        Supplier supplier = new Supplier(supplierId);

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        supplier.updateProductDetails(product, destination);
        System.out.println("Supply Information Saved Successfully");
        System.out.println();

        System.out.println("Blockchain:");
        Blockchain.displayBlockchain();

        System.out.println("Number of blocks in the blockchain: " + Blockchain.getNumberOfBlocks());

        Customer customer = new Customer();
        System.out.print("Enter Product ID to check: ");
        String checkProductId = scanner.nextLine();

        if (customer.checkProduct(checkProductId)) {
            System.out.println("Product is authentic. Found in blockchain.");
        } else {
            System.out.println("Product is fake. Not found in blockchain.");
        }

        System.out.println("Blockchain is valid: " + Blockchain.isChainValid());

        scanner.close();
    }
}