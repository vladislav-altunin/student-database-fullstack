package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data_access.StudentDAO;
import model.Status;

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int errorCode = -1;

		try {
			response.setContentType("application/x-www-form-urlencoded");
			response.setCharacterEncoding("UTF-8");

			int studentId = Integer.parseInt(request.getParameter("studentId"));																			
			StudentDAO studentDao = new StudentDAO();
			errorCode = studentDao.deleteStudent(studentId);

		} catch (Exception ide) {
			System.out.println("\n [ERROR] StudentDeleteServlet: doPost() failed" + ide.getMessage() + "\n");
		}

		Gson gson = new Gson();
		String json = gson.toJson(new Status(errorCode));
		out.print(json);
	}

}
