package org.example.classes;

import java.util.Date;

public class Block {
    public int index;
    public String previousHash;
    public String data;
    public long timeStamp;
    public String hash;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = generateHash();
    }

    public String generateHash() {
        return Integer.toString((data + previousHash + timeStamp).hashCode());
    }

    @Override
    public String toString() {
        return "Block " + index + " [data=" + data + " || previousHash=" + previousHash + " || , hash=" + hash + "]";
    }
}