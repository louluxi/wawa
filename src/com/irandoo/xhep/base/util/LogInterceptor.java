package com.irandoo.xhep.base.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * 
 * @author ager
 * @version 1.0
 */
public class LogInterceptor {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Pointcut("execution(public * com.base.frame.security.service..*.*(..))")
	public void method() {

	}

	@AfterThrowing(pointcut = "method()", throwing = "e")
	public void doAfterThrowing(JoinPoint jp, Throwable e) {
		System.out.println("�����쳣:" + e.getMessage());
		System.out.println(e.getClass().getName());
		System.out.println("�쳣������:" + jp.getTarget().getClass().getName());
		System.out.println("" + jp.getSignature().getName() + "���� throw exception");
		// logger.error("���� error����ģ�����"+e.getMessage());
		logger.error("Oops===" + jp.getTarget().getClass().getName() + "�е�" + jp.getSignature().getName() + "�����׳�" + e.getClass().getName()
				+ "�쳣");
		System.out.println("����:");
		if (jp.getArgs() != null && jp.getArgs().length > 0) {
			for (int i = 0; i < jp.getArgs().length; i++) {
				System.out.println(jp.getArgs()[i].toString());
				logger.error("����--" + jp.getArgs()[i].toString());
			}
		}
	}

	// ����ִ��֮ǰ����ִ���������
	@Before("method()")
	public void before(JoinPoint jp) {
		String className = jp.getThis().toString();
		String methodName = jp.getSignature().getName(); // ��÷�����
		if(logger.isInfoEnabled())
		{
			logger.info("Enter "+jp.getTarget().getClass().getName() + " : " + jp.getSignature().getName());
		}
	
		System.out.println("====λ�ڣ�" + className);
		System.out.println("====����" + methodName + "����-��ʼ��");
		Object[] args = jp.getArgs(); // ��ò����б�
		if (args.length <= 0) {
			System.out.println("====" + methodName + "����û�в���");
		} else {
			for (int i = 0; i < args.length; i++) {
				System.out.println("====����  " + (i + 1) + "��" + args[i]);
			}
		}

	}

	@AfterReturning("method()")
	public void AfterReturning(JoinPoint jp) {
		
	
		System.out.println("====" + jp.getSignature().getName() + "����-����");
		System.out.println("=====================================");
		
		if(logger.isInfoEnabled())
		{
			logger.info("Exit "+jp.getTarget().getClass().getName() + " : " + jp.getSignature().getName());
		}

	}
}
