package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import store.PlayerStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class PlayerStoreLogic implements PlayerStore{
	
	private ConnectionFactory factory;
	
	public PlayerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public void update(Player player) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement("update player_tb set teamid=? where id=?");
			pstmt.setString(1, player.getTeamId());
			pstmt.setString(2, player.getPlayerId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
	}
	
	@Override
	public Player retrieve(String playerId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Player player = null;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select id, teamid, name, backnumber, position, hitting, throw from player_tb where id=?");
			pstmt.setString(1, playerId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				player = new Player();
				player.setPlayerId(rs.getString("id"));
				player.setTeamId(rs.getString("teamid"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backnumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt, rs);
		}
		return player;
	}

	@Override
	public List<Player> retrieveByTeam(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Player> list = new ArrayList<>();
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select id, teamid, name, backnumber, position, hitting, throw from player_tb where teamid=?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Player player = new Player();
				player.setPlayerId(rs.getString("id"));
				player.setTeamId(rs.getString("teamid"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backnumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));
				list.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt, rs);
		}
		return list;
	}

}
