package core;

import util.Util;

public class Block {

	private int blockID;
	private String previousBlockHash;
	private int nonce;
	private String data;
	
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
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	public Block(int blockID, String previousBlockHash, int nonce, String data) {
		super();
		this.blockID = blockID;
		this.nonce = nonce;
		this.data = data;
	}
	
	public void getInformation() {
		System.out.println("-------------------------------------");
		System.out.println("Block Number : " + getBlockID());
		System.out.println("Previous Hash Value : " + getPreviousBlockHash());
		System.out.println("Mining Variable Value : " + getNonce());
		System.out.println("Block Data : " + getData());
		System.out.println("Block Hash : " + getBlockHash());
		System.out.println("-------------------------------------");
	}
	
	public String getBlockHash() {
		return Util.getHash(data + nonce);
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
