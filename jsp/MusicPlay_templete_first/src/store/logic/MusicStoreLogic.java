package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Music;
import store.MusicStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class MusicStoreLogic implements MusicStore{
	ConnectionFactory factory;
	
	public MusicStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public Music read(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Music music = null;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select id, name, artist_name, album_title, image, agent_name from music_tb where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				music = new Music();
				music.setId(rs.getInt("id"));
				music.setName(rs.getString("name"));
				music.setArtist(rs.getString("artist_name"));
				music.setAlbum(rs.getString("album_title"));
				music.setImage(rs.getString("image"));
				music.setAgent(rs.getString("agent_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt, rs);
		}
		return music;
	}

	@Override
	public List<Music> readByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> list = new ArrayList<>();
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select id, name, artist_name, album_title, image, agent_name from music_tb where name like? ");
			pstmt.setString(1, "%" + name + "%");
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

	@Override
	public List<Music> readAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> list = new ArrayList<>();
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select id, name, artist_name, album_title, image, agent_name from music_tb");
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
