package com.blockchain.tuto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blockchain.tuto.model.BlockModel;
import com.blockchain.tuto.model.service.impl.BlockServiceImpl;

public class Main {

	public static void main(String[] args) {

		BlockModel block1=new BlockModel();
		BlockModel block2=new BlockModel();
		
		BlockServiceImpl service= new BlockServiceImpl();
		
		block1.setData("0.0126 BTC");
		block1.setTimeStamp(new Date().getTime());
		block1.setHash(service.fullBlockHash(block1));
		
		System.out.println("First block :"+block1.hash);
		
		block2.setData("0.0199 BTC");
		block2.setTimeStamp(new Date().getTime());
		block2.setHash(service.fullBlockHash(block2));
		block2.setPreviousHash(block1.getHash());
		
		System.out.println("Second block :"+block2.hash);
		System.out.println("Second block :"+block2.previousHash);
		
		List<BlockModel>chain= new ArrayList<BlockModel>();
		chain.add(block1);
		chain.add(block2);
		
		System.out.println(service.isChainValid(chain));
		
		
	}

}
