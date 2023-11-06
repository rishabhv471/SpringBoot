/*
 *There are 4 type of jdbc connection
 *1- jdbc+odbc (neeed to be installed on both side(client ,worker) )
 *2- Partly java tech enabled (installed on  side(client ))
 *3- pure java driver ( a middle ware server is required )
 *4- direct to db pure java driver ( no middle ware , no client side ) source code direct communicate 
 *	 with backend . 
 */

/*
 * frontend+backend = 4 steps
 * 1- connection(establish connection wih DB ) = interface 
 * 2- Driver manager(interface b/w user and driver) = java class
 * 3- Statement(execute sql query) = interface
 * 4- Resultset(cursor pointing to a row of a table) = interface
 */

//Right click project->build path->configure build path->libraries tab->add external jars->add the jar file 

package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_MYSQLDEMO {
	public static void main(String arg[]){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vwits","root", "Your password for mysql");
			st = con.createStatement();
			rs = st.executeQuery("select * from vwits_emp where dept ='hr'");
			while (rs.next())
			{
				int a = rs.getInt("eno");
				String b = rs.getString(2);
				float c = rs.getFloat("salary");
				String d = rs.getString("dept");
				System.out.println(a+" "+b+" "+c+" "+d+" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally
		{
			try
			{
				if(rs!=null) 
					rs.close();
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
			}
			catch(Exception e)
			{
				System.out.println("Finally Block::"+e);
			}
		
		}
	}

}