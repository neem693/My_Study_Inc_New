package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {
	// single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static DeptDao single = null;

	SqlSessionFactory factory;

	public static DeptDao getInstance() {
		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<DeptVo> selectList() {
		List<DeptVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("dept.dept_list");
		session.close();
		return list;
	}

}
