package com.line;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import org.postgresql.jdbc.PgStatement;

import com.java.training.Employee3;


public class Dbclass 
{
	
	final static String DB_DRIVER_CLASS="org.POSTGRESQL.DRIVER";

	private static final Statement EmployeeDatabase = null;

	private static final String INSERT = null;
	
	  public static String DB_URL="jdbc.postgres://localhost:5432/vastpro ";
	
    public static String Db_user="postgres";
	public static String DB_PASSWORD="postgres";
	private static String CREATE ="insert into employee3(empid,name,age,Designation,phonenumber,salary);VALUES"+"(?,?,?,?,?,?);";
    private static String UPDATE ="update employee3 set salary=? Designation=? where empid=?";
    private static String DELETE ="delete from employee3where empid=?";
    
     public static Connection getConnection() throws ReflectiveOperationException, SQLException {
    	
 Class.forName(DB_DRIVER_CLASS);

System.out.println("success");
 Connection con = null;
try {
	con = DriverManager.getConnection(DB_URL,Db_user,DB_PASSWORD);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return con;
}
     public static int insert(Employee3 e)
     {int res=0;
	
     try
     {
    	 Connection con=Dbclass.getConnection();
    			 PreparedStatement ps=con.prepareStatement(INSERT);
    			 
    		     Employee3 e3=new Employee3();
    		     ps.setInt(1, e.getEmp_id());
    			 ps.setString(2, e.getName());
    			 ps.setString(3, e.getAge());
    			 ps.setString(4,e.getDisignation());
    			 ps.setString(5,e.getPhonenumber());
    			 ps.setLong(6,e.getSalary());
    			 res=ps.executeUpdate();
    			 ps.close();
     }
     
   catch(Exception ex) {
	  
	   ex.printStackTrace();
     }
     System.out.println("result "+res);
	return res;
     }
}