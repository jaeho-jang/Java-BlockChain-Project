package core;

import java.util.ArrayList;

import util.Util;

public class Block {

	private int blockID;
	private String previousBlockHash;
	private int nonce;
	private ArrayList<Transaction> transactionList;
	
	public int getBlockID() {
		return blockID;
	}
	
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	
	public int getNonce() {
		return nonce;
	}
	
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	public Block(int blockID, String previousBlockHash, int nonce, ArrayList transactionList) {
		super();
		this.blockID = blockID;
		this.nonce = nonce;
		this.transactionList = transactionList;
	}
	
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}
	
	public void getInformation() {
		System.out.println("-------------------------------------");
		System.out.println("Block Number : " + getBlockID());
		System.out.println("Previous Hash Value : " + getPreviousBlockHash());
		System.out.println("Mining Variable Value : " + getNonce());
		System.out.println("Number of transactions : " + transactionList.size());
		for(int i = 0; i < transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getInformation());
		}
		System.out.println("Block Hash : " + getBlockHash());
		System.out.println("-------------------------------------");
	}
	
	public String getBlockHash() {
		String transactionInformations = "";
		for (int i = 0; i < transactionList.size(); i++) {
			transactionInformations += transactionList.get(i).getInformation();
		}
		return Util.getHash(transactionInformations + nonce + previousBlockHash);
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) {
				System.out.println("You have successfully mined the block. (BlockID = " + blockID + ")");
				break;
			}
			nonce++;
		}
	}
	
}
