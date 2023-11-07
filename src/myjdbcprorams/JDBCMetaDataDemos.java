package myjdbcprorams;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import dbconnectionutilities.DBConnectionFactory_MYSQL;

public class JDBCMetaDataDemos {

	public static void main(String[] args) throws Exception 
	{
		// fetching the db connection from the external file!
		Connection con = DBConnectionFactory_MYSQL.mydbconnect_123();
		PreparedStatement ps1 = con.prepareStatement("select * from vwits_emp");
		ResultSet rs = ps1.executeQuery();
		
		// --ResultSetMetaData interface is useful because it provides methods to get
		// metadata from the ResultSet object.
		ResultSetMetaData rsobj = rs.getMetaData();// similar to desc command in mysql +oracle
		int cols = rsobj.getColumnCount();// 4
		System.out.println("Total Columns:: " + rsobj.getColumnCount());
		System.out.println("1st ColumnName:: " + rsobj.getColumnName(1));// 1st column(Eno)
		System.out.println("1st Column datatype:: " + rsobj.getColumnTypeName(1));// datatype

		for (int i = 1; i <= cols; i++) {
			String colName = rsobj.getColumnName(i);
			String colType = rsobj.getColumnTypeName(i);
			System.out.println(colName + " of type " + colType);
		}

		// DatabaseMetaData interface provides methods to get meta data of a database
		// such as database product name,
		// database product version, driver name..
		DatabaseMetaData dbmd = con.getMetaData();
		System.out.println("Driver Name: " + dbmd.getDriverName());
		System.out.println("Driver Version: " + dbmd.getDriverVersion());
		System.out.println("UserName: " + dbmd.getUserName());
		System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
		System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());

		
	
	}

}
/*
DB Connection success!
Total Columns:: 4
1st ColumnName:: eno
1st Column datatype:: INT
eno of type INT
ename of type VARCHAR
salary of type FLOAT
dept of type VARCHAR
Driver Name: MySQL-AB JDBC Driver
Driver Version: mysql-connector-java-5.1.16 ( Revision: ${bzr.revision-id} )
UserName: root@localhost
Database Product Name: MySQL
Database Product Version: 5.7.39-log
*/