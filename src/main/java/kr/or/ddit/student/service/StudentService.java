package kr.or.ddit.student.service;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf {

	private StudentDaoInf studentDao = new StudentDao();
	
	/**
	 * Method : getStudentVoById
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 입력받은 id로 vo값을 반환한다.
	 */
	@Override
	public StudentVo getStudentVoById(String userId) {
		return studentDao.getStudentVoById(userId);
	}

}
