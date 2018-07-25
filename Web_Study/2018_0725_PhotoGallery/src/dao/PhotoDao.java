package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.PhotoVo;

public class PhotoDao {

	// single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static PhotoDao single = null;

	public static PhotoDao getInstance() {
		if (single == null)
			single = new PhotoDao();
		return single;
	}

	public PhotoDao() {
		// TODO Auto-generated constructor stub
	}

	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from photo order by idx desc";

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
				// PhotoVo�� ����
				PhotoVo vo = new PhotoVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setTitle(rs.getString("title"));
				vo.setFilename(rs.getString("filename"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setPwd(rs.getString("pwd"));

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

	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into photo values(seq_photo_idx.nextVal,?,?,?,?,sysdate)";

		try {
			//1.Connectionȹ��
			conn = DBService.getInstance().getConnection();
			//2.���ó����ü ȹ��
			pstmt = conn.prepareStatement(sql);

			//3.psmt parameter ����
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2,vo.getFilename());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

			//4.DB insert
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

	public boolean check(PhotoVo one) {

		boolean check= true;
		PhotoVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from photo where idx = ? and pwd =?";

		try {
			//1.Connectionȹ��
			conn = DBService.getInstance().getConnection();

			//2.���ó��(PreparedStatement)��ü ȹ��
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, one.getIdx());
			pstmt.setString(2, one.getPwd());

			//3.�����ó��(ResultSet)��ü ȹ��
			rs = pstmt.executeQuery();

			//��ü�� ó��
			if(rs.next()) {

				//rs�� ���� ���ڵ��� ���� �о����
				//PhotoVo�� ����
				
				String filename = rs.getString("filename");
				
				if(filename.equals(null)){
					check= false;
				}
				

				//ArrayList��´�
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//�ݱ�:��������
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
		return check;
	}
	
	public int delete(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;//ó���� ���
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from photo where idx = ? and pwd= ?";

		try {
			//1.Connectionȹ��
			conn = DBService.getInstance().getConnection();
			//2.���ó����ü ȹ��
			pstmt = conn.prepareStatement(sql);

			//3.psmt parameter ����
			pstmt.setInt(1, vo.getIdx());
			pstmt.setString(2, vo.getPwd());

			//4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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

public PhotoVo selectOne(PhotoVo one) {

	PhotoVo vo = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from photo where idx = ? and pwd = ?";

	try {
		//1.Connectionȹ��
		conn = DBService.getInstance().getConnection();

		//2.���ó��(PreparedStatement)��ü ȹ��
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, one.getIdx());
		pstmt.setString(2, one.getPwd());

		//3.�����ó��(ResultSet)��ü ȹ��
		rs = pstmt.executeQuery();

		//��ü�� ó��
		while (rs.next()) {

			//rs�� ���� ���ڵ��� ���� �о����
			//PhotoVo�� ����
			vo = new PhotoVo();
			vo.setIdx(rs.getInt("idx"));
			vo.setTitle(rs.getString("title"));
			vo.setFilename(rs.getString("filename"));
			vo.setIp(rs.getString("ip"));
			vo.setRegdate(rs.getString("regdate"));
			vo.setPwd(rs.getString("pwd"));

			//ArrayList��´�
		}

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		try {
			//�ݱ�:��������
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

}
