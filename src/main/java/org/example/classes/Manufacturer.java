package org.example.classes;

public class Manufacturer {
    private String manufacturerId;

    public Manufacturer(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void addProductToBlockchain(Product product) {
        String data = "Product ID: " + product.getProductId() + ", Product Name: " + product.getProductName() + ", Date: " + product.getCreationDate() + ", Manufacturer ID: " + manufacturerId;
        String previousHash = Blockchain.blockchain.size() > 0 ? Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash : "0";
        Block newBlock = new Block(Blockchain.blockchain.size(), data, previousHash);
        Blockchain.addBlock(newBlock);
    }
}