package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserTest {
	
	public static void main(String[] args) {
		// // xml ���������� ���� ������ ���ؽ�Ʈ �ε�
		ApplicationContext appCtx = new GenericXmlApplicationContext("applicationContext.xml");
		// // User�� ������ ����ϴ� ����� ���� ��ü ��������
		UserPrinter printer = appCtx.getBean(UserPrinter.class);
		// // User���� ���, ������ ���� �� �Ǿ����� Ȯ��
		System.out.println("************1. ������ ����");
		printer.printUserRank();
		// // User��ü �ι� ������ �� ���� ��ü�� �����ϴ��� ��
		System.out.println("************2. �̱��� Ȯ��");
		User user1 = appCtx.getBean(VipUser.class);
		User user2 = appCtx.getBean(VipUser.class);
		System.out.println(user1 == user2);
		
	}
}
