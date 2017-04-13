package store.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory instance;
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER_NAME = "scott";
	private static final String PASSWORD = "tiger";
	
	public ConnectionFactory() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance(){
		if(instance == null){
			instance = new ConnectionFactory();
		}
		return instance;
	}
	
	public Connection createConnetion() throws SQLException{
		return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
	}

}
