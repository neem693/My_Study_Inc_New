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
	
	
	public List<SungVo> selectList(){
		
		List<SungVo> list = new ArrayList<SungVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungtb_view";
		
		
		try {
			//Ä¿³Ø¼Ç È¹µæ
			conn = DBService.getInstance().getConnection();
			//¸í·ÉÃ³¸® °´Ã¼ È¹µæ
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//°á°úÇà Ã³¸®(ResultSet)°´Ã¼ È¹µæ
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				String avg = rs.getString("avg");
				int rank = rs.getInt("rank");
				
				//SungVo¿¡ Æ÷Àå
				SungVo vo = new SungVo(idx,name,kor,eng,mat,tot,avg,rank);
				list.add(vo);
				
				
				
			}
			
			
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return list;
		
	}

}

