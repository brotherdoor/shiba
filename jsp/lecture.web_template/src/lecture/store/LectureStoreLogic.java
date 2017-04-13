package lecture.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecture.domain.Lecture;
import lecture.store.util.ConnectionFactory;
import lecture.store.util.JdbcUtils;

public class LectureStoreLogic implements LectureStore {
	
	ConnectionFactory factory;
	private static Map<String, Lecture> lectureRepository = new HashMap<String, Lecture>();
	
	public LectureStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public boolean create(Lecture lecture) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resCount = 0;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"insert into lecture_tb values(lec_seq.nextval,?,?,?)");
			pstmt.setString(1, lecture.getLectureName());
			pstmt.setString(2, lecture.getInstructor());
			pstmt.setString(3, lecture.getIntroduce());
			resCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
		return resCount > 0;
		//lectureRepository.put(lecture.getId(), lecture);
	}

	@Override
	public Lecture read(String lectureId) {
		Lecture lec = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"select id, lecturename, instructor, introduce from lecture_tb where id =?");
			pstmt.setString(1, lectureId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				lec = new Lecture();
				lec.setId(rs.getString("id"));
				lec.setLectureName(rs.getString("lecturename"));
				lec.setInstructor(rs.getString("instructor"));
				lec.setIntroduce(rs.getString("introduce"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
		return lec;
	}

	@Override
	public void update(Lecture lecture) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"update lecture_tb set lecturename=?, instructor=?, introduce=? where id=?");
			pstmt.setString(1, lecture.getLectureName());
			pstmt.setString(2, lecture.getInstructor());
			pstmt.setString(3, lecture.getIntroduce());
			pstmt.setString(4, lecture.getId());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
	}

	@Override
	public boolean delete(String lectureId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resCount = 0;
		try {
			conn = factory.createConnetion();
			pstmt = conn.prepareStatement(
					"delete from lecture_tb where id = ?");
			pstmt.setString(1, lectureId);
			resCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, pstmt);
		}
		return resCount > 0;
		//lectureRepository.remove(lectureId);
	}

	@Override
	public List<Lecture> readAll() {
		List<Lecture> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select id, lecturename, instructor, introduce from lecture_tb");
			while(rs.next()){
				Lecture lec = new Lecture();
				lec.setId(rs.getString("id"));
				lec.setLectureName(rs.getString("lecturename"));
				lec.setInstructor(rs.getString("instructor"));
				lec.setIntroduce(rs.getString("introduce"));
				list.add(lec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn, stmt, rs);
		}
		return list;
	}

}







