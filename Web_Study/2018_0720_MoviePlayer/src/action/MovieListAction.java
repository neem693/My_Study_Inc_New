package action;

import java.io.File;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/movie_list.do")
public class MovieListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// web ->절대경로
		ServletContext application = request.getServletContext(); // 이건 즉 어플리케이션 콘텍스트이다.
		String web_path = "/mp4/";
		String abs_path = application.getRealPath(web_path);

		System.out.println(abs_path);

		File f = new File(abs_path);
		File[] file_array = f.listFiles();

		StringBuffer sb = new StringBuffer("[");
		for (int i =0; i<file_array.length;i++) {
			File ff = file_array[i];
			String filename = ff.getName();
			System.out.println(filename);
			String[] im_array = filename.split("_");
			String player = im_array[1];
			String title = im_array[1].concat(" 응원가");
			String dir = String.format("mp4/%s", filename);

			sb.append(String.format("{'player':'%s','title':'%s','dir':'%s'}", player, title, dir));
			if(!(i==(file_array.length-1))) {
				System.out.println(i);
				sb.append(",");
			}

		}
		sb.append("]");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());

	}

}