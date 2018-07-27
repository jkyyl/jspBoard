package kr.or.ddit.student.service;

import kr.or.ddit.student.model.StudentVo;

public interface StudentServiceInf {

	/**
	 * Method : getStudentVoById
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 입력받은 id로 vo값을 반환한다.
	 */
	public StudentVo getStudentVoById(String userId);
	
}
