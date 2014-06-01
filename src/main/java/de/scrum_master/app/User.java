package de.scrum_master.app;

import java.util.HashMap;
import java.util.Map;

public class User {
	public static final Map<Long, User> userDB = new HashMap<>();

	private Long id;
	private UserInfo info;

	public static User create(Long id, UserInfo info) {
		if (userDB.get(id) != null)
			throw new IllegalArgumentException("User with ID " + id + " already exists");
		User user = new User(id, info);
		userDB.put(id, user);
		return user;
	}

	protected User(Long id, UserInfo info) { this.id = id; this.info = info; }
	public Long getId() { return id; }
	public UserInfo getInfo() { return info; }
	@Override
	public String toString() { return "User{" + "id=" + id + ", info=" + info + '}'; }

	@Cacheable(scope="session", uniqueName="userInfo")
	public static UserInfo getUserInfo(Long userId) {
		User foundUser = userDB.get(userId);
		return foundUser == null ? null : foundUser.getInfo();
	}
}
