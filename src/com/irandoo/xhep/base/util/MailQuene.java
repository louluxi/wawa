package com.irandoo.xhep.base.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MailQuene {
	private static MailQuene mailQuene = new MailQuene();
	private BlockingQueue<Mail> blockingQueue = null;

	private MailQuene() {
		blockingQueue = new LinkedBlockingDeque<Mail>(1000);
	}

	public static MailQuene getInstance() {
		return mailQuene;
	}

	public BlockingQueue<Mail> getMailQuene() {
		return blockingQueue;
	}
}
