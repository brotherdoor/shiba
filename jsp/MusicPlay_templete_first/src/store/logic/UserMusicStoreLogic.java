package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Music;
import store.UserMusicStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class UserMusicStoreLogic implements UserMusicStore{
	
	ConnectionFactory factory;
	
	public UserMusicStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean create(String userId, int musicId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resCount = 0;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"insert into user_music_tb values(?, ?)");
			pstmt.setInt(1, musicId);
			pstmt.setString(2, userId);
			resCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
		return resCount > 0;
	}

	@Override
	public boolean delete(String userId, int musicId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rsCount = 0;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"delete from user_music_tb where user_Id=? and music_Id=?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, musicId);
			rsCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
		return rsCount > 0;
	}

	@Override
	public boolean existUserMusic(String userId, int musicId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select music_id, user_id from user_music_tb where user_Id=? && music_Id=?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, musicId);
			rs = pstmt.executeQuery();
			if(rs.next()) result = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt, rs);
		}
		return result;
	}

	@Override
	public List<Music> readMusicsByUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> list = new ArrayList<>();
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select m.id, m.name, m.artist_name, m.album_title, m.image, m.agent_name "
					+ "from music_tb m, user_music_tb u "
					+ "where m.id = u.music_id and u.user_id =?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Music music = new Music();
				music.setId(rs.getInt("id"));
				music.setName(rs.getString("name"));
				music.setArtist(rs.getString("artist_name"));
				music.setAlbum(rs.getString("album_title"));
				music.setImage(rs.getString("image"));
				music.setAgent(rs.getString("agent_name"));
				list.add(music);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt, rs);
		}
		return list;
	}

}

















