package action;

import java.io.File;
/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String webPath = "/upload/";//�����
		ServletContext application = request.getServletContext();
		//�� ���=> ������ ���ϱ�
		String saveDir = application.getRealPath(webPath);
		int maxSize = 1024 * 1024 * 100;// 100M
		

		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());

		String title1 = request.getParameter("title");// ���޴´�.
		String title = mr.getParameter("title");// �޴´�.

		System.out.println(title1 + " " + title);
		System.out.println(saveDir);

		String filename = "no_file";
		File f = mr.getFile("photo");
		if (f != null) {// ���ε�� ȭ���� �����ϸ�
			filename = f.getName();
		}
		System.out.println(filename);

		request.setAttribute("title", title);
		request.setAttribute("filename", filename);

		String forward_page = "upload_result.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}