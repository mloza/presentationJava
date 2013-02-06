package pl.edu.pk.wieik.pwj.presentation.model;

import java.security.NoSuchAlgorithmException;

public class Authentication {
	// TODO Na razie dane logowania zahardkodowane
	static private final String username = "c4ca4238a0b923820dcc509a6f75849b"; // admin  		// TODO Usunąc 
	static private final String password = "c81e728d9d4c2f636f067f89cc14862c"; // supertajne  // TODO Usunąc 
	
	public boolean login(String username, String password) throws NoSuchAlgorithmException {
		String usernameMD5 = new MD5(username).toString();
		String passwordMD5 = new MD5(password).toString();
		
		return true;
//		if(usernameMD5.equals(this.username) && passwordMD5.equals(this.password)) {
//			return true;
//		} else {
//			return false;
//		}
	}
}
