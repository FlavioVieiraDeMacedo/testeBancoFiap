package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		
		try {
			   
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		} 
		catch (ClassNotFoundException ex){ }
		
				
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String user = "RM74083";
		String senha = "120697";
		Connection conn = DriverManager.getConnection(url, user, senha);

		return conn;
	}
}
