package action;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Member_Dao;
import vo.MemberVo;



/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���� ���ڵ� ����
		PrintWriter out;
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		//id�� �ش�Ǵ� MemberVo��ü ������
		MemberVo vo = Member_Dao.getInstance().selectOne(id);
		
		//System.out.println(id);
		String result = "no";
		
		if(vo==null) {
			result = "yes";
		}
		
		response.setContentType("text/html charset =utf-8");
		out = response.getWriter();
		String result_json = String.format("[{'answer':'%s'}]", result);
		//�̷��� ���ϸ� �ȳѾ� ����. {}�� �ϸ��� �ȳѾ� ����. �ݵ�� �迭�� �߰������ �Ѵ�.
		out.print(result_json);

	}

}