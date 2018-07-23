package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class Member_Dao {

	// single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static Member_Dao single = null;

	public static Member_Dao getInstance() {
		if (single == null)
			single = new Member_Dao();
		return single;
	}

	public Member_Dao() {
		// TODO Auto-generated constructor stub

	}

	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";

		try {
			// 1.Connectionȹ��
			conn = DBService.getInstance().getConnection();

			// 2.���ó��(PreparedStatement)��ü ȹ��
			pstmt = conn.prepareStatement(sql);

			// 3.�����ó��(ResultSet)��ü ȹ��
			rs = pstmt.executeQuery();

			// ��ü�� ó��
			while (rs.next()) {

				// rs�� ���� ���ڵ��� ���� �о����
				// MemberVo�� ����

				MemberVo vo = new MemberVo();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				// ArrayList��´�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// �ݱ�:��������
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public MemberVo selectOne(int idx) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where idx = ?";

		try {
			// 1.Connectionȹ��
			conn = DBService.getInstance().getConnection();

			// 2.���ó��(PreparedStatement)��ü ȹ��
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			// 3.�����ó��(ResultSet)��ü ȹ��
			rs = pstmt.executeQuery();

			// ��ü�� ó��
			if (rs.next()) {

				// rs�� ���� ���ڵ��� ���� �о����
				// MemberVo�� ����
				vo = new MemberVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				// ArrayList��´�
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// �ݱ�:��������
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	public MemberVo selectOne(String id) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id = ?";

		try {
			// 1.Connectionȹ��
			conn = DBService.getInstance().getConnection();

			// 2.���ó��(PreparedStatement)��ü ȹ��
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			// 3.�����ó��(ResultSet)��ü ȹ��
			rs = pstmt.executeQuery();

			// ��ü�� ó��
			if (rs.next()) {

				// rs�� ���� ���ڵ��� ���� �о����
				// MemberVo�� ����
				vo = new MemberVo();

				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddr(rs.getString("addr"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				// ArrayList��´�
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// �ݱ�:��������
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	// ȸ�� insert

	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// ó���� ���
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(seq_member_idx.nextVal,?,?,?,?,?,?,sysdate)";

		try {
			// 1.Connectionȹ��
			conn = DBService.getInstance().getConnection();
			// 2.���ó����ü ȹ��
			pstmt = conn.prepareStatement(sql);

			// 3.psmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getZipcode());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getIp());

			// 4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}



	public int delete(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// ó���� ���
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where idx = ? and pwd = ?";

		try {
			// 1.Connectionȹ��
			conn = DBService.getInstance().getConnection();
			// 2.���ó����ü ȹ��
			pstmt = conn.prepareStatement(sql);

			// 3.psmt parameter ����
			pstmt.setInt(1, vo.getIdx());
			pstmt.setString(2, vo.getPwd());

			// 4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}
}
