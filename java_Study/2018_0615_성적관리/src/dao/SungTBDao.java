package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class SungTBDao {
	static SungTBDao single = null;

	public static SungTBDao getInstance() {
		if (single == null)
			single = new SungTBDao();
		return single;
	}

	public SungTBDao() {
		// TODO Auto-generated constructor stub

	}

	public List<SungVo> selectList() {

		List<SungVo> list = new ArrayList<SungVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view";

		try {
			// Ŀ�ؼ� ȹ��
			conn = DBService.getInstance().getConnection();
			// ���ó�� ��ü ȹ��
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// ����� ó��(ResultSet)��ü ȹ��
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				String avg = rs.getString("avg");
				int rank = rs.getInt("rank");

				// SungVo�� ����
				SungVo vo = new SungVo(idx, name, kor, eng, mat, tot, avg, rank);
				list.add(vo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
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

	public int insert(SungVo vo) {
		// TODO Auto-generated method stub

		int res = 0;// ó���� �����ŭ ���ϵǴ°� ������ ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into sungtb values(seq_sungtb_idx.nextVal,?,?,?,?)";

		try {
			// 1.Ŀ�ؼ� ȹ��
			conn = DBService.getInstance().getConnection();
			// 2.���ó����ü ȹ��
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());

			// 4.DB insert
			res = pstmt.executeUpdate();

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

	public int update(SungVo vo) {
		// TODO Auto-generated method stub

		int res = 0;// ó���� �����ŭ ���ϵǴ°� ������ ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update sungtb set name = ?,kor=?,eng=?, mat=? where idx =?";

		try {
			// 1.Ŀ�ؼ� ȹ��
			conn = DBService.getInstance().getConnection();
			// 2.���ó����ü ȹ��
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter ����
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());

			// 4.DB insert
			res = pstmt.executeUpdate();

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
	
	public int delete(SungVo vo) {
		// TODO Auto-generated method stub
		
		int res =0;//ó���� �����ŭ ���ϵǴ°� ������ ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from sungtb where idx=?";
		
		try {
			//1.Ŀ�ؼ� ȹ��
			conn = DBService.getInstance().getConnection();
			//2.���ó����ü ȹ��
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setInt(1, vo.getIdx());
			
			//4.DB insert
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return res;
	}
	
	
	
	
	
	

}
