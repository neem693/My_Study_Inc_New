package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ip = request.getRemoteAddr();
		System.out.println(ip + "�� �ȳ��ϼ��� ȣȣȣȣȣȣ���Pȣ��ȣȣȣȣȣȣȣȣȣȣȣȣȣȣȣ");
		
		request.setCharacterEncoding("utf-8");
		String color = request.getParameter("color");
		if(color == null)
			color = "red";
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>�ȳ�</title></head>");
		response.getWriter().println("<body bgcolor = "+ color + ">");
		
		
		response.getWriter().println("<h1>"+ip + "[��]�ȳ��ϼ���. ��������<br>ȣ��ȣ��ȣȣȣȣȣȣ�P</h1>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		
		
	}

}
