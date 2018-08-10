package action.board;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board_Dao;
import jdk.nashorn.internal.parser.JSONParser;
import myconst.MyConst;
import util.Paging;
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
		
		request.setCharacterEncoding("utf-8");
		
		
		int nowPage = 1;
		String strPage = request.getParameter("page");
		if(strPage!=null && !strPage.isEmpty())
			nowPage = Integer.parseInt(strPage);
		
		//결정된 page에 따라서 start,end 계산
		int start = (nowPage -1) * MyConst.Board.BLOCK_LIST + 1;
		int end = start + MyConst.Board.BLOCK_LIST -1;
		
		//mybatis mapper에 전달하기 위해서 Map으로 포장
		Map map = new HashMap();
		
		map.put("start", start);
		map.put("end", end);
		
		
		
		List<BoardVo> list = Board_Dao.getInstance().selectList(map);
		int count = Board_Dao.getInstance().selectCount();
		//System.out.println(count);
		String pageMenu= Paging.getPaging("list.do", nowPage, count, MyConst.Board.BLOCK_LIST, MyConst.Board.BLOCK_PAGE);
		//System.out.println(pageMenu);
		//System.out.println("실행");
		
		//System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("pageMenu", pageMenu);
		request.getSession().removeAttribute("show");
		
		
		
		String forward_page = "board_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
		
	}

}