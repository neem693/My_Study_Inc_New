package action.board;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board_Dao;
import vo.BoardVo;
import vo.MemberVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/delete.do")
public class BoardDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean is_only_one = true;
		request.setCharacterEncoding("utf-8");
		String page = request.getParameter("page");
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("list.do?fail=empty user");
			return;
		}
		int idx = Integer.parseInt(request.getParameter("idx"));
		String id = request.getParameter("id");

		if (!(user.getId().equals(id))) {
			response.sendRedirect("list.do?fail=empty user");
			return;
		}

		BoardVo vo = Board_Dao.getInstance().selectOne(idx);
		int count = Board_Dao.getInstance().selectOne_IsOnlyOne(vo);
		System.out.println("count: " + count);
		int res = 0;
		if (count > 0)
			is_only_one = false;
		
		
		if (is_only_one)
			res = Board_Dao.getInstance().delete(vo);
		else {
			res = Board_Dao.getInstance().update_del_mod(vo);
		}

		if (res == 0) {
			response.sendRedirect("list.do?fail=empty user");
			return;
		}

		response.sendRedirect("list.do?page="+page);

	}

}