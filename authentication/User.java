import java.io.*;
class User implements Serializable
{
	private String username;
	private String password;
	private long mobile_no;
	private String e_mail;
	User(String username,String password,long mobile_no,String e_mail)
	{
		this.username=username;
		this.password=password;
		this.mobile_no=mobile_no;
		this.e_mail=e_mail;
	}
	void setName(String username)
	{
		this.username=username;
	}
	void setPass(String password)
	{
		this.password=password;
	}
	void setMobile(long mobile_no)
	{
		this.mobile_no=mobile_no;
	}
	void setMail(String e_mail)
	{
		this.e_mail=e_mail;
	}
	String getName()
	{
		return username;
	}
	String getPass()
	{
		return password;
	}
	long getMobile()
	{
		return mobile_no;
	}
	String getMail()
	{
		return e_mail;
	}
	public String toString()
	{
		return "Username : "+username+"\nPassword : "+password+"\nMobile number : "+mobile_no+"\nE Mail : "+e_mail;
	}
}