/**
 * 
 */
package com.practice.example;

/**
 * @author Ninni
 * 1. Get understand of final parameter in a method: within the method, not allowed to change (reassign a new value/new object to that para.)
 *
 */
public class KnowTrie {
	public static void main(String[] arg) {
		LoginInfo login = new LoginInfo();
		login.setPassword("1235");
        login.setUserName("mygod");
        System.out.println("username:"+login.getUserName()+",password:"+login.getPassword());
        checkLoginInfo(login);
        System.out.println("username:"+login.getUserName()+",password:"+login.getPassword());
	}
	public static void checkLoginInfo(final LoginInfo login) {
		login.setUserName("new");  // can change feature value
//		login = new LoginInfo();  // this is wrong because it is final. But...why renew/reassign new object to it? 
	}
}
class LoginInfo {
	protected String password;
	protected String name;
	public void setPassword(String pw) {
		this.password = pw;
	}
	
	public String getUserName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUserName(String name) {
		this.name = name;
	}
}
