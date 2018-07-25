package action.photo;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PhotoDao;
import vo.PhotoVo;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/photo/list.do")
public class PhotoListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<PhotoVo> list = PhotoDao.getInstance().selectList();

		request.setAttribute("list", list);

		String forward_page = "photo_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}