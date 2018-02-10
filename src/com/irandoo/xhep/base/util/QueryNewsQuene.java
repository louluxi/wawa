package com.irandoo.xhep.base.util;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueryNewsQuene {
	private static QueryNewsQuene pushInfoQuene = new QueryNewsQuene();
	private BlockingQueue<String> blockingQueue = null;

	private QueryNewsQuene() {
		blockingQueue = new LinkedBlockingDeque<String>();
	}

	public static QueryNewsQuene getInstance() {
		return pushInfoQuene;
	}

	public BlockingQueue<String> getQuene() {
		return blockingQueue;
	}
}
