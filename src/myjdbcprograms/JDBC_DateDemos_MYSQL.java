package myjdbcprograms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import dbconnectionutilities.DBConnectionFactory_MYSQL;

/*

 * mysql> create table person_records(pid int ,pname varchar(20),dob date,doj date);

Query OK, 0 rows affected (0.02 sec)

mysql> desc person_records;

+-------+-------------+------+-----+---------+-------+

| Field | Type | Null | Key | Default | Extra |

+-------+-------------+------+-----+---------+-------+

| pid | int(11) | YES | | NULL | |

| pname | varchar(20) | YES | | NULL | |

| dob | date | YES | | NULL | |

| doj | date | YES | | NULL | |

+-------+-------------+------+-----+---------+-------+

4 rows in set (0.00 sec)

mysql> insert into person_records values(10,'Devi','2000/4/18','2021/3/19');

Query OK, 1 row affected (0.01 sec)

mysql> insert into person_records values(11,'Abi','2000/8/28','2021/2/20');

Query OK, 1 row affected (0.01 sec)

mysql> insert into person_records values(13,'Rajan','2000/1/8','2021/4/29');

Query OK, 1 row affected (0.01 sec)

mysql> insert into person_records values(14,'Kanishka','2000/11/12','2021/4/2');

Query OK, 1 row affected (0.01 sec)

mysql> select * from person_records;

+------+----------+------------+------------+

| pid | pname | dob | doj |

+------+----------+------------+------------+

| 10 | Devi | 2000-04-18 | 2021-03-19 |

| 11 | Abi | 2000-08-28 | 2021-02-20 |

| 13 | Rajan | 2000-01-08 | 2021-04-29 |

| 14 | Kanishka | 2000-11-12 | 2021-04-02 |

+------+----------+------------+------------+

4 rows in set (0.00 sec)

 */

public class JDBC_DateDemos_MYSQL	{

 public static void main(String[] args) throws Exception{

 //fetching the db connection from the external file!

 Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();

 Scanner s1=new Scanner(System.in);

 System.out.println("Person No:: ");

 int id=s1.nextInt();

 s1.nextLine();

 System.out.println("PersonName:: ");

 String name=s1.nextLine();

 System.out.println("Enter DOB(YYYY-MM-DD-MYSQL):: ");

 String dob1=s1.next();

 System.out.println("Enter DOJ(YYYY-MM-DD-MYSQL):: ");

 String doj1=s1.next();

 /*

  * Date.valueof()::

  * accepts a string value and converts the given string value

  * into DATE object!

  * JDBC DATE FORMAT:: yyyy-mm-dd

  */

 Date sqdob=Date.valueOf(dob1);

 Date sqdoj=Date.valueOf(doj1);

 String query1="insert into person_records values(?,?,?,?)";

 PreparedStatement ps1=con.prepareStatement(query1);

 ps1.setInt(1, id);

 ps1.setString(2, name);

 ps1.setDate(3, sqdob);//Date object

 ps1.setDate(4, sqdoj);//Date object

 int rows=ps1.executeUpdate();//EITHER 0 OR 1

 System.out.println(rows+ " Record inserted!");

 PreparedStatement ps2=con.prepareStatement("select * from person_records");

 ResultSet rs=ps2.executeQuery();

 System.out.println("Pno\tPname\tDOB\tDOJ");

 //java.text package

 SimpleDateFormat sformat=new SimpleDateFormat("dd/MMM/yyyy");//MMM-Month in 3 letters ex: aug,sep

 while(rs.next())

 {

  System.out.print(rs.getInt(1) + "\t");

  System.out.print(rs.getString(2) + "\t");

  Date d1=rs.getDate(3);//DOB COLUMN-//default=>yyyy/mm/dd

  String r=sformat.format(d1);//applying the different date format to DOB

  System.out.print(r + "\t");

  System.out.println(rs.getDate(4) + "\t");//DOJ COLUMN-//default=>yyyy/mm/dd

 }

 PreparedStatement ps3=con.prepareStatement("select * from person_records where doj=?");

 System.out.println("Enter DOJ:: ");

 String do5=s1.next();

 Date sqw=Date.valueOf(do5);//convert string doj to date doj object

 ps3.setDate(1, sqw);//1 question mark

 ResultSet rs1=ps3.executeQuery();

 System.out.println("Pno\tPname\tDOB\tDOJ");

 while(rs1.next())

 {

  System.out.print(rs1.getInt(1) + "\t");

  System.out.print(rs1.getString(2) + "\t");

  Date d1=rs1.getDate(3);//applying the date format to DOB

  String r=sformat.format(d1);//applying the date format

  System.out.print(r + "\t");

  System.out.println(rs1.getDate(4) + "\t");

 }

 con.close();

 }

}

/*

DB Connection success!

Person No::

80

PersonName::

Thananya

Enter DOB(YYYY-MM-DD-MYSQL)::

2005-12-24

Enter DOJ(YYYY-MM-DD-MYSQL)::

2023-11-18

1 Record inserted!

Pno	Pname	DOB	DOJ

10	Devi	18/Apr/2000	2021-03-19

11	Abi	28/Aug/2000	2021-02-20

13	Rajan	08/Jan/2000	2021-04-29

14	Kanishka	12/Nov/2000	2021-04-02

80	Thananya	24/Dec/2005	2023-11-18

Enter DOJ::

2021-03-19

Pno	Pname	DOB	DOJ

10	Devi	18/Apr/2000	2021-03-19

*/