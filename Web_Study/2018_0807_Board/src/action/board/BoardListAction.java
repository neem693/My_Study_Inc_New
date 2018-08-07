package action.board;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board_Dao;
import vo.BoardVo;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/list.do")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<BoardVo> list = Board_Dao.getInstance().selectList();
		
		//System.out.println(list.size());
		request.setAttribute("list", list);
		
		
		String forward_page = "board_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}