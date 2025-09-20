import java.util.*;
class Authentication
{
	static ArrayList<User> al=new ArrayList<>();
	static User u;
	static Scanner sc=new Scanner(System.in);
	static void login()
	{
		System.out.println("Enter credentials to Login ");
       		System.out.print("Username : ");
       		String username=sc.next();
       		System.out.print("Password : ");
       		String password=sc.next();
		if(username.equals(u.getName()) && password.equals(u.getPass()))
       		{
           		System.out.println("Login successfull :) ");
       		}
		else if(!username.equals(u.getName()) && !password.equals(u.getPass()))
       		{
           		System.out.println("Invalid credentials press 1 to know your username : ");
           		int n=sc.nextInt();
           		if(n==1)
           		{
               			while(true)
               			{
                   			System.out.print("Enter Mobile number : ");
                   			long phno=sc.nextLong();
                   			if(phno==u.getMobile())
                   			{
                       				System.out.println("Your Username : "+u.getName());
                       				System.out.print("Press 1 to Login or any key to exit : ");
                       				char ch=sc.next().charAt(0);
                       				if(ch=='1')
                        			{
                         	   			login();
                            				break;
                        			}
                        			else
                            				System.out.println("Thank you :)");
                        				break;
                   			}
                   			else
                   			{
                       				System.out.print("User not found \npress 1 to re-enter or any key to exit : ");
                       				char ch1=sc.next().charAt(0);
                       				if(ch1!='1')
                       				{
                           				System.out.println("Thank you :) ");
                           				break;
                       				}
                   			}
            			}
           		}
           		else
                		System.out.println("Thank you :)");
       		}
       		else if(!password.equals(u.getPass()))
       		{
           		System.out.println("Invalid Password press 1 to reset : ");
           		int n=sc.nextInt();
           		if(n==1)
           		{
               			System.out.print("Enter new Password : ");
               			u.setPass(sc.next());
               			System.out.println("Your Password : "+u.getPass());
               			System.out.print("Press 1 to Login or any key to exit : ");
                		char ch=sc.next().charAt(0);
                		if(ch=='1')
                    			login();
                		else
                    			System.out.println("Thank you :) ");
           		}
           		else
            			System.out.println("Thank you :) ");
       		}
	}
	static void signUp()
	{
		
	}
	public static void main(String[]args)
	{
		System.out.println("1 - Sign Up\n2 - Login");
		int n=sc.nextInt();
		if(n==1)
		{
			login();
		}
		else if(n==2)
		{
			signup();
		}
	}
}