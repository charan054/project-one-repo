import java.util.*;
import java.io.*;
class Authentication
{
	static ArrayList<User> al=new ArrayList<>();
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static FileInputStream fis;
	static ObjectInputStream ois;
	static User u;
	static Scanner sc=new Scanner(System.in);
	static String path = "data.txt";
	static void login()throws Exception
    	{
        	System.out.println("Enter credentials to Login ");
        	while(true)
        	{
        	    boolean b=false;
        	    System.out.println("1 - Username\n2 - E-mail\n3 - Mobile number ");
        	    int n=Integer.parseInt(sc.nextLine());
        	    if(n==1)
        	    {
        	        System.out.print("Enter Username : ");
        	        String username=sc.nextLine();
        	        for(User x:al)
        	        {
        	            if(x.getName().equals(username))
        	            {
        	                b=!b;
        	                u=x;
        	                break;
        	            }
        	        }
        	    }
        	    else if(n==2)
        	    {
        	        System.out.print("Enter E-mail : ");
        	        String e_mail=sc.nextLine();
        	        for(User x:al)
        	        {
        	            if(x.getMail().equals(e_mail))
        	            {
        	                b=!b;
        	                u=x;
				System.out.println(u);
                	        break;
                	    }
                	}
            	}
            	else if(n==3)
            	{
            	    System.out.print("Enter Mobile number : ");
            	    long mobile_no=Long.parseLong(sc.nextLine());
            	    for(User x:al)
            	    {
            	        if(x.getMobile()==mobile_no)
            	        {
            	            b=!b;
            	            u=x;
            	            break;
            	        }
            	    }
            	}
            	else {
                	System.out.println("Invalid choice please retry ");
                	continue;
            	}
            	if(b)
            	{
            	    passwordValidation();
			break;
            	}
            	else
            	{
            	    System.out.print("User not found press 1 to re-enter or any key to exit : ");
            	    char ch1=sc.nextLine().charAt(0);
            	    if(ch1!='1')
            	    {
            	       exit();
            	       break;
            	    }
            	}
		}
    }
    static void passwordValidation()throws Exception
    {
            System.out.print("Enter password : ");
            String password=sc.nextLine();
            if(password.equals(u.getPass()))
            {
                System.out.println("Login successfull");
            }
            else
            {
                System.out.print("Invalid Password \npress 1 to reset 2 to re-enter : ");
                int n=Integer.parseInt(sc.nextLine());
                if(n==1)
                {
                    forgotPassword();
                }
                else if(n==2)
                {
                    passwordValidation();
                }
                else
                   exit();
            }
    	}
	static boolean otpGeneration()
    	{
        int otp=1000+(int)(Math.random()*8999);
        System.out.print("Please wait generating otp ");
        for(int i=0;i<5;i++)
        {
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
                System.out.print(" .");
            }
            System.out.println("\nYour OTP : "+otp);
            while(true)
            {
                System.out.print("Enter OTP : ");
                if(otp==Integer.parseInt(sc.nextLine()))
                {
                    return true;
                }
                else
                {
                    System.out.println("Invalid otp \n1 - Re-enter\n2 - Resend ");
                    int n=Integer.parseInt(sc.nextLine());
                    if(n==2)
                    {
                        otpGeneration();
                    }
                    else if(n!=1)
                        break;
                }
            }
            return false;
    }
    static void forgotPassword()throws Exception
    {
        boolean b=false,b1=false;
        System.out.print("Enter Mobile Number : ");
        long mobile_no=Long.parseLong(sc.nextLine());
        for(User x:al)
        {
            if(x.getMobile()==mobile_no)
            {
                b=!b;
                u=x;
                break;
            }
        }
        if(b)
        {
           b1=otpGeneration();
        }
        else
        {
            System.out.print("User not found press 1 to re-enter or any key to exit : ");
            char ch=sc.nextLine().charAt(0);
            if(ch=='1')
                forgotPassword();
            else
                exit();
        }
        if(b1)
        {
            System.out.print("Enter new Password : ");
            String password;
        	System.out.println("Password should contains atleast 8 characters,Should start with capital letter one special character and a number ");
		int s=0,n=0;
        	while(true)
        	{
            		System.out.print("Enter Password : ");
            		password=sc.nextLine();
            		if(password.length()>=8){
                	for(int i=0;i<password.length();i++)
                	{
                    		if(i==0)
                    		{
                        		if(password.charAt(0)<'A' || password.charAt(0)>'Z')
                        		break;
                            
                    		}
                    		else
                    		{
                        		char ch=password.charAt(i);
                        		if(ch>='A'&& ch<='Z' ||(ch>='a'&& ch<='z'))
                        		{
                            
                        		}
                        		else if(ch>='0'&& ch<='9')
                         			n++;
                        		else
                            			s++;
                    		}
                	}
                	if(n==0 || s==0)
                	{
                	    System.out.println("Password dosent match criteria try again ");
                	}
                	else
                	    break;
            	}
            	else
            	{
            	    System.out.println("Password dosent match criteria try again ");
            	}
            
        	}
		u.setPass(password);
		exit();
            System.out.println("Your Password : "+u.getPass());
            System.out.print("Press 1 to Login or any key to exit : ");
            char ch=sc.nextLine().charAt(0);
            if(ch=='1'){
                login();
			return;
		}
            else
            	exit();
        }
        else
            exit();
    }
 	static void signUp()throws Exception
	{
		System.out.println("Enter details to create new account ");
		String username;
        	while(true)
		{
            		System.out.print("Enter Username : ");
            		username=sc.nextLine();
            		boolean b=true;
            		for(User x:al)
            		{
                		if(x.getName().equals(username))
                    		b=!b;
            		}
            		if(!b)
            		{
                		System.out.println("User already exists enter new name");
            		}
            		else
                		break;
        	}
		String password;
        	System.out.println("Password should contains atleast 8 characters,Should start with capital letter one special character and a number ");
		int s=0,n=0;
        	while(true)
        	{
            		System.out.print("Enter Password : ");
            		password=sc.nextLine();
            		if(password.length()>=8){
                	for(int i=0;i<password.length();i++)
                	{
                    		if(i==0)
                    		{
                        		if(password.charAt(0)<'A' || password.charAt(0)>'Z')
                        		break;
                            
                    		}
                    		else
                    		{
                        		char ch=password.charAt(i);
                        		if(ch>='A'&& ch<='Z' ||(ch>='a'&& ch<='z'))
                        		{
                            
                        		}
                        		else if(ch>='0'&& ch<='9')
                         			n++;
                        		else
                            			s++;
                    		}
                	}
                	if(n==0 || s==0)
                	{
                	    System.out.println("Password dosent match criteria try again ");
                	}
                	else
                	    break;
            	}
            	else
            	{
            	    System.out.println("Password dosent match criteria try again ");
            	}
            
        	}
		long mobile_no;
        	while(true)
        	{
            		System.out.print("Enter Mobile Number : ");
            		mobile_no=Long.parseLong(sc.nextLine());
            		if((""+mobile_no).length()==10)
            		{
                		if((""+mobile_no).charAt(0)<'6')
                    		System.out.println("Mobile number should start with 6/7/8/9");
                		else
                    			break;
            		}
            		else
                		System.out.println("Mobile number should contain 10 digits");
        	}
		String e_mail;
        	while(true)
        	{
            		System.out.print("Enter Email : ");
            		e_mail=sc.nextLine();
            		if(!e_mail.endsWith("@gmail.com"))
            		{
                		System.out.println("Invalid email try again ");
            		}
            		else 
                		break;
        	}
		al.add(new User(username,password,mobile_no,e_mail));
        	System.out.println("Account created successfully");
        	System.out.print("Press 1 to Login or any key to exit : ");
        	char ch=sc.nextLine().charAt(0);
        	if(ch=='1')
            		login();
        	else
            		exit();		
	}
	public static void main(String[]args)throws Exception
	{
		
		fis=new FileInputStream(path);
		ois=new ObjectInputStream(fis);
		try{
			while(true)
			{
				al.add((User)ois.readObject());
				
			}
		}
		catch(EOFException e)
		{
		}
		
		/*for(User x:al)
		{
			System.out.println(x);
		}*/
		System.out.println("1 - Sign Up\n2 - Login");
		int n=Integer.parseInt(sc.nextLine());
		if(n==1)
		{
			signUp();
		}
		else if(n==2)
		{
			login();
		}
		else{
			System.out.println("Press 1 to login/signUp or any key to exit : ");
			char ch=sc.nextLine().charAt(0);
			if(ch=='1')
			{
				main(args);
			}
			else{
				exit();
			}
		}
		
		System.out.println("Thank you :)");
		ois.close();
		fis.close();
	}
	static void exit ()throws IOException
	{
		
		fos=new FileOutputStream(path);
		oos=new ObjectOutputStream(fos);
			System.out.println(al);
			for(User x: al)
			{
			oos.writeObject(x);
				oos.flush();
			}
			oos.close();
		fos.close();
	}
}