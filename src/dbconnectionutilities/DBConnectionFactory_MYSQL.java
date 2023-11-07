
package dbconnectionutilities;

import java.sql.Connection;
import java.sql.DriverManager;

/*
	 * From JDBC 4.0, we don't need to include 'Class.forName()' in our code, 
	 * to load JDBC driver. When the method 'getConnection' is called, 
	 * the 'DriverManager' will automatically load the suitable driver 
	 * among the JDBC drivers that were loaded at initialization and those 
	 * loaded explicitly using the same class loader as the current application.
	 * Any JDBC 4.0 drivers that are found in your classpath are automatically 
	 * loaded. (However, you must manually load any drivers prior to JDBC 4.0 
	 * with the method Class.forName.)
	 */

public class DBConnectionFactory_MYSQL 
{
	public static Connection mydbconnect_123()
	{
		Connection con=null;
		try
		{
	//Class.forName("com.mysql.jdbc.Driver");//type 4 mysql driver=>optional if its JDBC4 VERSION!
			//3306-mysql port number
	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/vwits", "root", "Try@1234");

		}
		catch(Exception e)
		{
		System.out.println("Connection Failed! Check console!"+e);	
		}
		if(con!=null)
		{
			System.out.println("DB Connection success!");
		}
		else
		{
			System.out.println("DB Connection Failed!");
		}
		return con;//return database connection

	}
}