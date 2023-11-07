package myjdbcprograms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import dbconnectionutilities.DBConnectionFactory_MYSQL;

/*

 * mysql> CREATE TABLE universities(university_name varchar(40),university_code int primary key);

Query OK, 0 rows affected (0.03 sec)

mysql> desc universities;

+-----------------+-------------+------+-----+---------+-------+

| Field | Type | Null | Key | Default | Extra |

+-----------------+-------------+------+-----+---------+-------+

| university_name | varchar(40) | YES | | NULL | |

| university_code | int(11) | NO | PRI | NULL | |

+-----------------+-------------+------+-----+---------+-------+

2 rows in set (0.01 sec)

mysql> CREATE TABLE students(student_id int primary key,full_name varchar(20),gender varchar (10),university_id int,CONSTRAINT FK_university_id FOREIGN KEY (university_id)REFERENCES universities(university_code));

Query OK, 0 rows affected (0.03 sec)

mysql> desc students;

+---------------+-------------+------+-----+---------+-------+

| Field | Type | Null | Key | Default | Extra |

+---------------+-------------+------+-----+---------+-------+

| student_id | int(11) | NO | PRI | NULL | |

| full_name | varchar(20) | YES | | NULL | |

| gender | varchar(10) | YES | | NULL | |

| university_id | int(11) | YES | MUL | NULL | |

+---------------+-------------+------+-----+---------+-------+

4 rows in set (0.00 sec)

mysql> CREATE TABLE contacts(

contact_id int(10),
mobile_number int(20),
email_address varchar (50),
student_id int,
CONSTRAINT FK_student_id FOREIGN KEY (student_id)
REFERENCES students(student_id));

Query OK, 0 rows affected (0.02 sec)

mysql> INSERT INTO universities(university_code, university_name)
VALUES(101, 'SRM University'),
(1002, 'Amity University'),
(1003, 'Anna University'),
(1004, 'Hindustan University');

Query OK, 4 rows affected (0.01 sec)

Records: 4 Duplicates: 0 Warnings: 0

mysql> INSERT INTO students(student_id, full_name, gender, university_id) VALUES

(201,'Noor Khan', 'Male', 101),

(202, 'Avneesh Mishra', 'Male', 1002),

(203,'Monika Singh', 'Female', 1003),

(204, 'Aaliya Khan', 'Female', 1004),

(205, 'Sunil Kumar', 'Male', 1004),

(206, 'Mamta Gupta', 'Female', 1004),

(207, 'Rapson Jani', 'Male', 101),

(208, 'Kundan Bharti', 'Male', 101),

(209, 'Manmohan Singh', 'Male', 1004),

(210,'Manisha Chaudhry', 'Female', 101);

Query OK, 10 rows affected (0.01 sec)

Records: 10 Duplicates: 0 Warnings: 0

mysql> INSERT INTO contacts(contact_id, mobile_number, email_address, student_id) VALUES
(51, 222, 'aaaa222@gmail.com', 201),
(52, 555, 'bbbb555@gmail.com', 202),
(53, 777, 'cccc666@gmail.com', 203),
(54, 888, 'dddd888@gmail.com', 204),
(55, 101, 'eeee101@gmail.com', 204),
(56, 121, 'ffff121@gmail.com', 204),
(57, 131, 'gggg121@gmail.com', 205),
(58, 141, 'iiii121@gmail.com', 206),
(59, 151, 'jjjj151@gmail.com', 207);

Query OK, 9 rows affected (0.01 sec)

Records: 9 Duplicates: 0 Warnings: 0

mysql> desc universities;

+-----------------+-------------+------+-----+---------+-------+

| Field | Type | Null | Key | Default | Extra |

+-----------------+-------------+------+-----+---------+-------+

| university_name | varchar(40) | YES | | NULL | |

| university_code | int(11) | NO | PRI | NULL | |

+-----------------+-------------+------+-----+---------+-------+

2 rows in set (0.00 sec)

mysql> desc students;

+---------------+-------------+------+-----+---------+-------+

| Field | Type | Null | Key | Default | Extra |

+---------------+-------------+------+-----+---------+-------+

| student_id | int(11) | NO | PRI | NULL | |

| full_name | varchar(20) | YES | | NULL | |

| gender | varchar(10) | YES | | NULL | |

| university_id | int(11) | YES | MUL | NULL | |

+---------------+-------------+------+-----+---------+-------+

4 rows in set (0.00 sec)

mysql> desc contacts;

+---------------+-------------+------+-----+---------+-------+

| Field | Type | Null | Key | Default | Extra |

+---------------+-------------+------+-----+---------+-------+

| contact_id | int(10) | YES | | NULL | |

| mobile_number | int(20) | YES | | NULL | |

| email_address | varchar(50) | YES | | NULL | |

| student_id | int(11) | YES | MUL | NULL | |

+---------------+-------------+------+-----+---------+-------+

4 rows in set (0.00 sec)

mysql> SELECT students.full_name, students.gender, contacts.mobile_number, contacts.email_address, universities.university_name FROM universities
LEFT JOIN students ON universities.university_code = students.university_id
LEFT JOIN contacts ON students.student_id = contacts.student_id;

ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '.email_address, universities.university_name FROM universities

        ' at line 2

mysql>

mysql> SELECT students.full_name, students.gender, contacts.mobile_number, contacts.email_address, universities.university_name FROM universities
LEFT JOIN students ON universities.university_code = students.university_id
LEFT JOIN contacts ON students.student_id = contacts.student_id;

+------------------+--------+---------------+-------------------+----------------------+

| full_name | gender | mobile_number | email_address | university_name |

+------------------+--------+---------------+-------------------+----------------------+

| Noor Khan | Male | 222 | aaaa222@gmail.com | SRM University |

| Rapson Jani | Male | 151 | jjjj151@gmail.com | SRM University |

| Kundan Bharti | Male | NULL | NULL | SRM University |

| Manisha Chaudhry | Female | NULL | NULL | SRM University |

| Avneesh Mishra | Male | 555 | bbbb555@gmail.com | Amity University |

| Monika Singh | Female | 777 | cccc666@gmail.com | Anna University |

| Aaliya Khan | Female | 888 | dddd888@gmail.com | Hindustan University |

| Aaliya Khan | Female | 101 | eeee101@gmail.com | Hindustan University |

| Aaliya Khan | Female | 121 | ffff121@gmail.com | Hindustan University |

| Sunil Kumar | Male | 131 | gggg121@gmail.com | Hindustan University |

| Mamta Gupta | Female | 141 | iiii121@gmail.com | Hindustan University |

| Manmohan Singh | Male | NULL | NULL | Hindustan University |

+------------------+--------+---------------+-------------------+----------------------+

12 rows in set (0.00 sec)

mysql> /*

  /*> Retrieves all the records from the first table, Matching records from the second table and NULL values in the unmatched rows.

  /*> */

public class JDBC_MYSQLJOINS {

 public static void main(String[] args) throws Throwable {

 //fetching the db connection from the external file!

 Connection con=DBConnectionFactory_MYSQL.mydbconnect_123();

 Statement s1=con.createStatement();

 String query1="SELECT students.full_name, students.gender, contacts.mobile_number, contacts.email_address, universities.university_name\r\n" +

  " FROM universities\r\n" +

  " LEFT JOIN students ON universities.university_code = students.university_id\r\n" +

  " LEFT JOIN contacts ON students.student_id = contacts.student_id";

 ResultSet rs=s1.executeQuery(query1);

 System.out.println("Name\t Gender\t MobNo \t Email \t University");

 while(rs.next())

 {

  System.out.print(rs.getString(1) + "\t");

  System.out.print(rs.getString(2) + "\t");

  System.out.print(rs.getInt(3) + "\t");

  System.out.print(rs.getString(4) + "\t");

  System.out.println(rs.getString(5) + "\t");

 }

 rs.close();

 con.close();//release DB connection

 }

}

/*

DB Connection success!

Name Gender MobNo Email University

Noor Khan	Male	222	aaaa222@gmail.com	SRM University
Avneesh Mishra	Male	555	bbbb555@gmail.com	Amity University
Monika Singh	Female	777	cccc666@gmail.com	Anna University
Aaliya Khan	Female	888	dddd888@gmail.com	Hindustan University
Aaliya Khan	Female	101	eeee101@gmail.com	Hindustan University
Aaliya Khan	Female	121	ffff121@gmail.com	Hindustan University
Sunil Kumar	Male	131	gggg121@gmail.com	Hindustan University
Mamta Gupta	Female	141	iiii121@gmail.com	Hindustan University
Rapson Jani	Male	151	jjjj151@gmail.com	SRM University
Kundan Bharti	Male	0	null	SRM University
Manmohan Singh	Male	0	null	Hindustan University
Manisha Chaudhry	Female	0	null	SRM University

*/