package com.zee.zee5_app.service;

import com.zee.zee5_app.dto.Login;
import com.zee.zee5_app.dto.ROLE;

public interface LoginService {
	
	public String addCredentials(Login login);
	public String deleteCredentials(String username);
	public String changePassword(String username,String password);
	public String changeRole(String username, ROLE role);

}
