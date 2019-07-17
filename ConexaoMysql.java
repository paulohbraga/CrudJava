package CrudJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {


	public static Connection getConnection() throws SQLException{
		 
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Conectando ao banco");
			 return DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "root");
			 
		 }catch(ClassNotFoundException e) {
			 System.out.println("Não conectado");
			 throw new SQLException(e.getMessage());
		 }
	 }
	
}

