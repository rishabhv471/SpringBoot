package myjdbcprograms;


import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.ArrayList;

import dbconnectionutilities.DBConnectionFactory_MYSQL;

class Employee_POJO

{

 int empno;

 String empname;

 float empsalary;

 String empdept;

 public int getEmpno() {

 return empno;

 }

 public void setEmpno(int empno) {

 this.empno = empno;

 }

 public String getEmpname() {

 return empname;

 }

 public void setEmpname(String empname) {

 this.empname = empname;

 }

 public float getEmpsalary() {

 return empsalary;

 }

 public void setEmpsalary(float empsalary) {

 this.empsalary = empsalary;

 }

 public String getEmpdept() {

 return empdept;

 }

 public void setEmpdept(String empdept) {

 this.empdept = empdept;

 }

}

//(JDBC)MYSQL+COLLECTION

public class JDBC_CollectionDemo {

 public static void main(String[] args)throws Exception {

 //fetching the db connection from the external file!

 Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();

 Statement s1=con.createStatement();

 ResultSet rs=s1.executeQuery("select * from vwits_emp");

 ArrayList<Employee_POJO> obj1=new ArrayList<Employee_POJO>();

 while(rs.next())

 {

  Employee_POJO e1=new Employee_POJO();//pojo class object

  e1.setEmpno(rs.getInt(1));

  e1.setEmpname(rs.getString(2));

  e1.setEmpsalary(rs.getFloat(3));

  e1.setEmpdept(rs.getString(4));

  obj1.add(e1);//************adding MYSQL table records to arraylist

 }

 System.out.println("Eno\tName\tSalary");

 for(Employee_POJO obj:obj1)//passing arraylist object

 {

 System.out.println(obj.getEmpno() + " "+obj.getEmpname() + " "+obj.getEmpsalary() + " "+obj.getEmpdept());

 }

 System.out.println("Arraylist Size:: "+obj1.size());

 }

}

/*

DB Connection success!
Eno	Name	Salary
1 John Doe 50000.0 HR
2 Jane Smith 60000.0 Sales
3 Bob Johnson 55000.0 IT
4 Mary Wilson 52000.0 Marketing
5 James Brown 58000.0 Finance
5 risabh 320000.0 sdc
Arraylist Size:: 6

*/