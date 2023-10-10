import java.rmi.*;

public class HelloClient {
	public static void main(String args[]) 
	{
		try 
		{
      // lookup for the object
			HelloInterface obj = (HelloInterface)	Naming.lookup("rmi://localhost:12345/mon_serveur_hello");
			
			// call methods
			String msg = obj.say();
			System.out.println(msg);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
