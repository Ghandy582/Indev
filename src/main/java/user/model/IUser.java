package user.model;

import core.model.User;

public interface IUser {

	public User F_login(String login, String password, String env);
}
