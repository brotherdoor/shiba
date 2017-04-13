package lecture.service;

import java.util.List;

import lecture.domain.Lecture;
import lecture.store.LectureStore;
import lecture.store.LectureStoreLogic;

/**
 * LectureServiceLogic
 * 
 * @since 2016. 3. 14.
 * @author 김은영 (eykim@nextree.co.kr)
 */
public class LectureServiceLogic implements LectureService {

	private LectureStore lectureStore;

	public LectureServiceLogic() {
		//
		lectureStore = new LectureStoreLogic();
	}

	@Override
	public boolean register(Lecture lecture) {
		//
//		String lectureId = this.nextId();
//		lecture.setId(lectureId);
		return lectureStore.create(lecture);
		
	}

//	private String nextId() {
//		//
//		List<Lecture> allLectures = lectureStore.readAll();
//		if (allLectures.isEmpty()) {
//			return "0";
//		}
//
//		int maxId = Integer.MIN_VALUE;
//		for (Lecture lecture : allLectures) {
//			int lectureId = Integer.parseInt(lecture.getId());
//			if (maxId < lectureId) {
//				maxId = lectureId;
//			}
//		}
//
//		return String.valueOf(maxId + 1);
//	}

	@Override
	public Lecture find(String lectureId) {
		//
		Lecture lecture = lectureStore.read(lectureId);
		if (lecture != null) {
			return lecture;
		}
		throw new RuntimeException("저장된 강좌가 없습니다.");
	}

	@Override
	public void modify(Lecture lecture) {
		//
		lectureStore.update(lecture);
		;
	}

	@Override
	public boolean remove(String lectureId) {
		//
		return lectureStore.delete(lectureId);
	}

	@Override
	public List<Lecture> findAll() {
		//
		return lectureStore.readAll();
	}

}
