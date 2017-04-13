package lecture.store;

import java.util.List;

import lecture.domain.Lecture;

/**
 * LectureStore
 * 
 * @since 2016. 3. 14.
 * @author 김은영 (eykim@nextree.co.kr)
 */
public interface LectureStore {
	//
	boolean create(Lecture lecture);
	Lecture read(String lectureId);
	void update(Lecture lecture);
	boolean delete(String lectureId);
	List<Lecture> readAll();
}
