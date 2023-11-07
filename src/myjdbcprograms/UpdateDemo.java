package myjdbcprograms;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import dbconnectionutilities.DBConnectionFactory_MYSQL;
/*
 * mysql> update vwits_employee set salary=salary+20000;
Query OK, 6 rows affected (0.01 sec)
Rows matched: 7  Changed: 6  Warnings: 0

mysql> update vwits_employee set salary=salary+20000 where eno=1002;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> delete from vwits_employee where eno=3003;
Query OK, 0 rows affected (0.00 sec)
 */
public class UpdateDemo {

	public static void main(String[] args)throws Exception 
	{
		//getting the db connection from external file
		Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();
		Scanner s1=new Scanner(System.in);
		System.out.println("Eno:: ");
		int a=s1.nextInt();
		s1.nextLine();
		System.out.println("Incentive:: ");
		float c=s1.nextFloat();

		String query1="update vwits_emp set salary=salary+? where eno=?";
		PreparedStatement ps1=con.prepareStatement(query1);
		ps1.setFloat(1, c);//1 refers first question mark
		ps1.setInt(2, a); 
		int rows=ps1.executeUpdate();//either 0 or any value
		if(rows>=1)
		{
			System.out.println("Record Exist!");
			System.out.println(rows+ " Record Updated!");
		}
		else
		{
			System.out.println("Record Not Exist!");
		System.out.println(rows+ " Record Updated!");			
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
48493
Incentive:: 
9000
Record Not Exist!
0 Record Updated!
1001 Devi 54320.4 HR
1002 Abi 134320.0 Operations
1003 Raja 84320.4 HR
1004 Thananya 79436.7 Accounting
1005 Kanishka 65904.7 HR
1006 Daya 85320.4 null
1008 Sara 0.0 null
8900 Saranya 430430.0 Testing
7900 Sangavi 56549.0 Training
*/
/*
DB Connection success!
Eno:: 
1005
Incentive:: 
10000
Record Exist!
1 Record Updated!
1001 Devi 54320.4 HR
1002 Abi 134320.0 Operations
1003 Raja 84320.4 HR
1004 Thananya 79436.7 Accounting
1005 Kanishka 75904.7 HR
1006 Daya 85320.4 null
1008 Sara 0.0 null
8900 Saranya 430430.0 Testing
7900 Sangavi 56549.0 Training
*/