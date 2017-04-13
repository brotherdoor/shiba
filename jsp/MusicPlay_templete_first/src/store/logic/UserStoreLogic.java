package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;
import store.UserStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class UserStoreLogic implements UserStore{
	
	ConnectionFactory factory;
	
	public UserStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean create(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCount = 0;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"insert into user_tb values(?,?,?)");
			pstmt.setString(1, user.getLoginId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			resultCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
		return resultCount > 0;
	}

	@Override
	public User read(String id) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select loginid, password, name from user_tb where loginid =?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setLoginId(rs.getString("loginid"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt, rs);
		}
		return user;
	}

}











