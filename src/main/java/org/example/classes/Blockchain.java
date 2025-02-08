package org.example.classes;

import java.util.ArrayList;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);


            if (!currentBlock.hash.equals(currentBlock.generateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }


            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    public static void addBlock(Block newBlock) {
        blockchain.add(newBlock);
    }

    public static void displayBlockchain() {
        for (Block block : blockchain) {
            System.out.println(block);
        }
    }

    public static int getNumberOfBlocks() {
        return blockchain.size();
    }
}