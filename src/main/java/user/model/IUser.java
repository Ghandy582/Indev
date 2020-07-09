package user.model;

import core.model.User;

public interface IUser {

	/**
	 * Get user from login
	 * @param String login
	 * @param String password
	 * @param String env
	 * @return User
	 */
	public User F_login(String login, String password, String env);
}
