package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.Service_DB;
import vo.GogekVo;
import vo.SawonVo;

public class DBDao {

	// single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static DBDao single = null;

	public static DBDao getInstance() {
		if (single == null)
			single = new DBDao();
		return single;
	}

	public DBDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<GogekVo> gogekSelect() {

		List<GogekVo> list = new ArrayList<GogekVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from gogek";

		try {
			//1.Connectionȹ��
			conn = Service_DB.getInstance().getConnection();

			//2.���ó��(PreparedStatement)��ü ȹ��
			pstmt = conn.prepareStatement(sql);

			//3.�����ó��(ResultSet)��ü ȹ��
			rs = pstmt.executeQuery();

			//��ü�� ó��
			while (rs.next()) {

				//rs�� ���� ���ڵ��� ���� �о����
				//GogekVo�� ����
				GogekVo vo = new GogekVo();
				
				vo.setGobun(rs.getInt("gobun"));
				vo.setGoname(rs.getString("goname"));
				vo.setGoaddr(rs.getString("goaddr"));
				vo.setGojumin(rs.getString("gojumin"));
				vo.setGodam(rs.getInt("godam"));

				//ArrayList��´�
				list.add(vo);
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
		return list;
	}

	public List<SawonVo> sawonSelect() {

		List<SawonVo> list = new ArrayList<SawonVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";

		try {
			// 1.Connectionȹ��
			conn = Service_DB.getInstance().getConnection();

			// 2.���ó��(PreparedStatement)��ü ȹ��
			pstmt = conn.prepareStatement(sql);

			// 3.�����ó��(ResultSet)��ü ȹ��
			rs = pstmt.executeQuery();

			// ��ü�� ó��
			while (rs.next()) {

				// rs�� ���� ���ڵ��� ���� �о����
				// SawonVo�� ����
				SawonVo vo = new SawonVo();
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getString("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));

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

}
