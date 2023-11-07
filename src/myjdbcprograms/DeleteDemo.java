package myjdbcprograms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import dbconnectionutilities.DBConnectionFactory_MYSQL;

public class DeleteDemo {


	public static void main(String[] args) throws Exception{
	
		Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();
		Scanner s1=new Scanner(System.in);

		String query1="delete from vwits_emp where eno=?";
		PreparedStatement ps1=con.prepareStatement(query1);
		System.out.println("Eno:: ");
		int a=s1.nextInt();
		ps1.setInt(1, a);//1 refers first question marks
		int rows=ps1.executeUpdate();
		if(rows>=1)
		{
			System.out.println("Record Exist!");
			System.out.println(rows+ " Record Deleted!");
		}
		else
		{
			System.out.println("Record Not Exist!");
		System.out.println(rows+ " Record Deleted!");			
		}		
		PreparedStatement ps11=con.prepareStatement("select * from vwits_emp");//SQL 2
		ResultSet rs=ps11.executeQuery();
		while(rs.next())
		{
			int a1=rs.getInt("eno");
			String b1=rs.getString(2);//2nd column=>ename
			float c1=rs.getFloat("salary");
			String d1=rs.getString(4);//dept
			System.out.println(a1+ " "+b1 + " "+c1+ " "+d1);
		}	
		rs.close();
		con.close();//release DB connection

	}

}
/*
DB Connection success!
Eno:: 
313129
Record Not Exist!
0 Record Deleted!
1001 Devi 64320.4 HR
1002 Abi 134320.0 Operations
1003 Raja 84320.4 HR
1004 Thananya 79436.7 Accounting
1005 Kanishka 75904.7 HR
1006 Daya 85320.4 null
1008 Sara 0.0 null
8900 Saranya 430430.0 Testing
7900 Sangavi 56549.0 Training
*/
/*
DB Connection success!
Eno:: 
1008
Record Exist!
1 Record Deleted!
1001 Devi 64320.4 HR
1002 Abi 134320.0 Operations
1003 Raja 84320.4 HR
1004 Thananya 79436.7 Accounting
1005 Kanishka 75904.7 HR
1006 Daya 85320.4 null
8900 Saranya 430430.0 Testing
7900 Sangavi 56549.0 Training
*/