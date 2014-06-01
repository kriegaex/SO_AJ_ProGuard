package de.scrum_master.app;

public class Application {
	public static void main(String[] args) {
		System.out.println(User.create(1L, new UserInfo("First")));
		System.out.println(User.create(2L, new UserInfo("Second")));
		System.out.println(User.create(3L, new UserInfo("Third")));
		System.out.println(User.create(4L, new UserInfo("Fourth")));
		System.out.println(User.create(5L, new UserInfo("Fifth")));

		System.out.println(User.getUserInfo(1L));
		System.out.println(User.getUserInfo(3L));
		System.out.println(User.getUserInfo(5L));
		System.out.println(User.getUserInfo(12345L));
	}
}
