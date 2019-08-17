package com.blockchain.tuto.model.service;

import java.util.List;

import com.blockchain.tuto.model.BlockModel;

public interface BlockService {
	
	Boolean isChainValid(List<BlockModel>blockchain);

	String hashSha256(String toBeHashed);
	
	String fullBlockHash(BlockModel blockToBeHashed);
}
