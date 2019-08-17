package com.blockchain.tuto.model.service.impl;

import java.security.MessageDigest;
import java.util.List;

import com.blockchain.tuto.model.BlockModel;
import com.blockchain.tuto.model.service.BlockService;

public class BlockServiceImpl implements BlockService{
	
	
	
	@Override
	public Boolean isChainValid(List<BlockModel>blockchain) {
		BlockModel currentBlock; 
		BlockModel previousBlock;
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			if(!currentBlock.hash.equals(hashSha256(currentBlock.getData()+currentBlock.getTimeStamp()+null+0)) ){
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String hashSha256(String toBeHashed) {

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			byte[] hash = digest.digest(toBeHashed.getBytes("UTF-8"));	        
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	
	}

	@Override
	public String fullBlockHash(BlockModel blockToBeHashed) {
		
		return hashSha256(blockToBeHashed.getData()+
						  blockToBeHashed.getTimeStamp()+
						  blockToBeHashed.getPreviousHash()+
						  blockToBeHashed.getMines());
	}

}
