package de.scrum_master.app;

public class UserInfo {
	private String info;

	public UserInfo(String info) { this.info = info; }
	public String getInfo() { return info; }
	@Override
	public String toString() { return "UserInfo{" + "info='" + info + '\'' + '}'; }
}
