package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hi
 */
@WebServlet("/hi.do")
public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String greet_msg = "안녕하세요";
		request.setCharacterEncoding("utf-8");
		String nation = request.getParameter("nation");
		if(nation ==null) {
			nation = "kor";
		}
		if(nation.equals("일본")) {
			greet_msg = "오겡끼데스까";
		}else if(nation.equals("중국")) {
			greet_msg = "니하오(마)";
		}else if(nation.equals("미국")) {
			greet_msg = "Hi funcking good day ya ha!";
		}
		response.setContentType("text/html; charset = utf-8");
		response.getWriter().println(greet_msg);
			
		
		
		
	}

}
