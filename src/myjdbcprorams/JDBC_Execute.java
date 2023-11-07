package myjdbcprorams;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconnectionutilities.DBConnectionFactory_MYSQL;

/*
execute() returns a boolean value and is used to execute SQL statements written 
as a String object
*/
public class JDBC_Execute {

	public static void main(String[] args) throws Exception{
		//fetching the db connection from the external file!
		Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();
		Statement s1=con.createStatement();

		//execute() method allows us to execute any kind of query like select, update. 
		//execute=>DDL,DML(RETURN TYPE IS BOOLEAN!)

		//boolean b1=s1.execute("select * from vwits_employee");//valid
		boolean b1=s1.execute("select eno,ename,salary from vwits_emp");//valid
		
		if(b1)//true
		{
			ResultSet rs=s1.getResultSet();//calling the ResultSet Interface
			while(rs.next())
			{
				int a=rs.getInt("eno");
				String b=rs.getString(2);//2nd column=>ename
				float c=rs.getFloat("salary");
				//ignoring the dept column here!
				System.out.println(a+ " "+b + " "+c);
			}
	
		}
	}

}
/*
DB Connection success!
1001 Devi 64320.4
1002 Abi 134320.0
1003 Raja 84320.4
1004 Thananya 79436.7
1005 Kanishka 75904.7
1006 Daya 85320.4
8900 Saranya 430430.0
7900 Sangavi 56549.0
*/