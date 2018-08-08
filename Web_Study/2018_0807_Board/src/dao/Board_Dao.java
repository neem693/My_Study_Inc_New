package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.BoardVo;

public class Board_Dao {

	SqlSessionFactory factory;
	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
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

	public List<BoardVo> selectList() {
		List<BoardVo> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("board.board_list");
		session.close();
		// System.out.println(list.size());

		return list;
	}

	public BoardVo selectOne(int idx) {
		// TODO Auto-generated method stub
		BoardVo vo = null;

		SqlSession session = factory.openSession();
		vo = session.selectOne("board.board_select_one", idx);
		session.close();

		return vo;
	}

	public int update_readhit(int idx) {
		// TODO Auto-generated method stub
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.update("board.board_update_readhit", idx);
		session.close();

		return res;
	}

	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.insert("board.board_insert", vo);
		session.close();

		return res;
	}

	public int selectOne(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		BoardVo check_vo = null;

		SqlSession session = factory.openSession();
		check_vo = session.selectOne("board.board_check_one", vo);
		session.close();

		if (check_vo != null) {
			res = 1;
		}

		return res;
	}

	public int delete(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession session = factory.openSession(true);
		res = session.delete("board.board_delete", vo);
		session.close();

		return res;
	}

	public int update_stepUp(BoardVo base_vo) {
		// TODO Auto-generated method stub
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.update("board.board_update_stepUp", base_vo);
		session.close();

		return res;
	}

	public int insert_reply(BoardVo vo) {
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.insert("board.board_reply", vo);
		session.close();

		return res;
	}

	public BoardVo selectOne_detail(BoardVo vo) {
		// TODO Auto-generated method stub
		BoardVo voo = null;
		
		
		SqlSession session = factory.openSession(true);
		voo = session.selectOne("board.board_select_one_detail", vo);
		session.close();
		
		return voo;
	}

	public int update_all( BoardVo vo) {
		// TODO Auto-generated method stub
		int res =0;
		
		SqlSession session = factory.openSession(true);
		res = session.update("board.board_update_all", vo);
		session.close();
		
		
		return res;
	}

}
