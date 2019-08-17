package com.blockchain.tuto.model;
/**
 * 
 */
import java.util.Date;

public class BlockModel {
	
	public String 		hash;
	public String 		previousHash;
	private String 		data; 
	private long 		timeStamp; 
	private int 		mines;
	
	public BlockModel() {
		super();
	}

	public BlockModel(String hash, String previousHash, String data, long timeStamp) {
		super();
		this.hash = hash;
		this.previousHash = previousHash;
		this.data = data;
		this.timeStamp = new Date().getTime();
	}

	public BlockModel(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getMines() {
		return mines;
	}

	public void setMines(int mines) {
		this.mines = mines;
	}
	
}
