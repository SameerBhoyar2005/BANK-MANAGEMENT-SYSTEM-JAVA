import java.sql.*;
public class Databasecon {
	
	public Connection connn() {
		Connection con = null;
	try {
		
		final String url="jdbc:mysql://127.0.0.1:3306/bank";
		final String username="root";
		final String password="Entermichael@123";
		con=DriverManager.getConnection(url,username,password);
	}
	catch(Exception e) {
		System.out.println("ERROR :" + e.getMessage());
	}
	
	return con;
}
	}
