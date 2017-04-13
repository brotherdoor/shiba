package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class BaseballTeamStoreLogic implements BaseballTeamStore{
	
	private ConnectionFactory factory;
	
	public BaseballTeamStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public BaseballTeam retrieve(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseballTeam team = null;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select id, name, region, manager, stadium, logo from team_tb where id = ?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				team = new BaseballTeam();
				team.setTeamId(rs.getString("id"));		// �ǳ�?
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt, rs);
		}
		return team;
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BaseballTeam> list = new ArrayList<>();
		try {
			conn = factory.createConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select id, name, region, manager, stadium, logo from team_tb");
			while(rs.next()){
				BaseballTeam team = new BaseballTeam();
				team.setTeamId(rs.getString("id"));		// �ǳ�?
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
				list.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, stmt, rs);
		}
		return list;
	}

}
