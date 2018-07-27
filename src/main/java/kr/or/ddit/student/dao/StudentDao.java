package kr.or.ddit.student.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * Method : studentVo
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 입력받은 ID값으로 StudentVo값을 가져온다.
	 */
	@Override
	public StudentVo getStudentVoById(String userId) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.selectOneStudentVoById", userId);
		session.close();
		
		return studentVo;
	}

}
