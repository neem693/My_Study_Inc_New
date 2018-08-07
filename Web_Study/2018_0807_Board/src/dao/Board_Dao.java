package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.BoardVo;

public class Board_Dao {
	
	SqlSessionFactory factory;
	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static Board_Dao single = null;

	public static Board_Dao getInstance() {
		if (single == null)
			single = new Board_Dao();
		return single;
	}

	public Board_Dao() {
		// TODO Auto-generated constructor stub
		
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();	
		
		
	}
	public List<BoardVo> selectList(){
		List<BoardVo> list = null;
		
		SqlSession session = factory.openSession();
		list = session.selectList("board.board_list");
		session.close();
		//System.out.println(list.size());
		
		
		return list;
	}

	public BoardVo selectOne(int idx) {
		// TODO Auto-generated method stub
		BoardVo vo = null;
		
		SqlSession session = factory.openSession();
		vo = session.selectOne("board.board_select_one",idx);
		session.close();
		
		
		return vo;
	}

}
