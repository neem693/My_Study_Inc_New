package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// hello.do?gubun=��ħ
		// hello.do?gubun=����
		// hello.do?gubun=����

		// �������ڵ� ����
		request.setCharacterEncoding("utf-8");

		String gubun = request.getParameter("gubun");

		if (gubun == null || gubun == "") {
			gubun = "��ħ";

		}

		String message = "";
		switch (gubun) {
		case "��ħ":
			message = "Good Morning";
			break;
		case "����":
			message = "Good AfterNoon";
			break;
		case "����":
			message = "Good Evening!!";
			break;

		default:
			break;
		}
		
		
		String result_message = String.format("[%s]�λ� : %s", gubun,message);
		
		
		//Servlet�� JSP���� �����͸� �����ϱ� ���ؼ� Binding��Ų��
		request.setAttribute("result_message", result_message);
		
		//���� ����� ��°�ü(JSP)���� �����ؼ� ����ϰԲ� forward��Ų��.
		
		RequestDispatcher disp = request.getRequestDispatcher("hello.jsp");
		disp.forward(request, response);

	}
}
