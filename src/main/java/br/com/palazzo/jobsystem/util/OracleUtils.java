package br.com.palazzo.jobsystem.util;
import java.sql.*;  
public class OracleUtils {
	
	public static void executeScript(String script) throws ClassNotFoundException, SQLException {
		

		//step1 load the driver class  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","sys as sysdba","root");  
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		stmt.execute(script);  
		  
		//step5 close the connection object  
		con.close();  
		  
		}  
}

