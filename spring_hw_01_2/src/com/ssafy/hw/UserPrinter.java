package com.ssafy.hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// ___________
public class UserPrinter {

	/*
	 * User ������ ����ϱ� ���� User ��ü�� �ʿ��մϴ�. 
	 * �� ��� User ��ü�� �����ϰ� �ִٰ� �� �� �ֽ��ϴ�. 
	 * Spring���� �����ϴ� �������� ����� �̿��ؼ� User��ü�� ���Թް�,(������ ����) 
	 * ���Թ��� User ������ ����� �� �ֵ��� �غ��ô�.
	 */

	// __________
	User user;

	public void setUser(User user) {
		this.user = user;
	}

	// Spring���� ���Թ��� User ���� ����ϱ�
	public void printUserRank() {
		System.out.println("I'm " + user.getRank() + "user.");
	}

}
