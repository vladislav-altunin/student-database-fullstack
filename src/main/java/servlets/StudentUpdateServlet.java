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
import model.Student;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDAO studentDao = new StudentDAO();
		int studentId = Integer.parseInt(request.getParameter("txtId"));
		Student student = studentDao.getStudentById(studentId);
		Gson gson = new Gson();
		String json = gson.toJson(student);

		// Print writer is necessary to write the body
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @throws Exception
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int errorCode = -1;
		
		try {
			response.setContentType("application/x-www-form-urlencoded");
			response.setCharacterEncoding("UTF-8");
			
			int studentId = Integer.parseInt(request.getParameter("txtId"));
			String firstName = request.getParameter("txtFname");
			String lastName = request.getParameter("txtLname");
			String streetAddress = request.getParameter("txtStreetaddress");
			String postCode = request.getParameter("txtPostcode");
			String postOffice = request.getParameter("txtPostoffice");
			
			Student student = new Student(studentId, firstName, lastName, streetAddress, postCode, postOffice);
			StudentDAO studentDao = new StudentDAO();
			
			errorCode = studentDao.updateStudent(student);
			
		} catch (Exception spe) {
			System.out.println("\n [ERROR] StudentUpdateServlet: doPost() failed" + spe.getMessage() + "\n");
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(new Status(errorCode));
		out.print(json);
		
	}

}
