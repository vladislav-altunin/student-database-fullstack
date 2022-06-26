package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Status;
import data_access.StudentDAO;
import model.Student;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int errorCode = -1;
		
		try {
			response.setContentType("application/x-www-form-urlencoded");
			response.setCharacterEncoding("UTF-8");
			
			int studentId = Integer.parseInt(request.getParameter("studentId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String streetAddress = request.getParameter("streetAddress");
			String postCode = request.getParameter("postCode");
			String postOffice = request.getParameter("postOffice");
			
			Student student = new Student(studentId, firstName, lastName, streetAddress, postCode, postOffice);
			StudentDAO studentDao = new StudentDAO();
			
			errorCode = studentDao.insertStudent(student);
			System.out.println(errorCode);
		} catch (Exception nfe) {
			System.out.println("\n [ERROR] StudentAddServlet: doPost() failed" + nfe.getMessage() + "\n");
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(new Status(errorCode));
		out.print(json);
	}

}
