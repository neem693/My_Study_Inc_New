package action;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Member_Dao;
import vo.MemberVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/member/update.do")
public class MembeUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberVo vo = null;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String pwd = request.getParameter("pwd");
		String idx = request.getParameter("idx");
		String addr = request.getParameter("addr");
		String zipcode = request.getParameter("zipcode");
		String name = request.getParameter("name");

		vo = new MemberVo();
		vo.setPwd(pwd);
		vo.setIdx(Integer.parseInt(idx));

		MemberVo res = Member_Dao.getInstance().selectOne(vo);

		if (res == null) {
			send(response);
			return;
		}
		vo.setAddr(addr);
		vo.setZipcode(zipcode);
		vo.setName(name);

		Member_Dao.getInstance().update(vo);

		send(response);

	}

	private void send(HttpServletResponse response) throws IOException {
		response.sendRedirect("list.do");

	}

}