package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import java.util.ArrayList;

import model.Student;

/**
 * DAO class for accessing students. It separates the business logic, and
 * therefore there is no user input/output. This class can be used in a
 * stand-alone Java application or as a part of the server-side implementation
 * of a web application. This code works as it is with all major RDBMS and
 * SQLite, Excel etc.
 */
public class StudentDAO {

	public StudentDAO() {
		// The JDBC driver is explicitly loaded for the Tomcat 8 environment.
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	/**
	 * Opens a new database connection
	 * 
	 * @throws SQLException
	 */
	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	/**
	 * Retrieves all students from the database
	 * 
	 * @return List<Student>
	 * @throws SQLException
	 */
	public List<Student> getStudents() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> studentList = new ArrayList<Student>();

		try {
			connection = openConnection();
			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice "
					+ "FROM Student ORDER BY lastname, firstname";
			preparedStatement = connection.prepareStatement(sqlText);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudents() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return studentList;
	}

	/**
	 * Retrieves a student by id
	 * 
	 * @param givenId - the id to be used as the filter in the query
	 * @return List<Student>
	 * @throws SQLException
	 */
	public Student getStudentById(int givenId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = new Student();

		try {
			connection = openConnection();
			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice "
					+ "FROM Student WHERE id = ? ORDER BY lastname";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, givenId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				student = (new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			} else {
				student = null;
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudentsById() failed. " + sqle.getMessage() + "\n");
			student = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return student;
	}

	/**
	 * Converts a list of students to JSON
	 * 
	 * @throws Exception
	 */

	public String getAllStudentsJSON() {
		String jsonString = null;
		
		try {
			List<Student> studentList = new StudentDAO().getStudents();
			Gson gson = new Gson();
			jsonString = gson.toJson(studentList);
			
		} catch (Exception jex){
			System.out.println("'n[ERROR] Student DAO: getAllStudentsJSON() failed. " + jex.getMessage() + "\n");
		}
		
		return jsonString;
	}

	/**
	 * Inserts a student into the database
	 * 
	 * @return 0 = Ok | 1 = Duplicate id | -1 = Other error
	 * @throws SQLException
	 */
	public int insertStudent(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int errorCode = -1;

		try {
			connection = openConnection();
			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) "
					+ "VALUES (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setString(4, student.getStreetAddress());
			preparedStatement.setString(5, student.getPostcode());
			preparedStatement.setString(6, student.getPostOffice());
			preparedStatement.executeUpdate();

			errorCode = 0;

		} catch (SQLException sqle) {
			int sqlState = Integer.parseInt(sqle.getSQLState());
			
			if (sqlState == ConnectionParameters.PK_VIOLATION_ERROR) {
				errorCode = 1;
			} else {
				System.out.println("\n[ERROR] StudentDAO: insertStudent() failed. " + sqle.getMessage() + "\n");
				errorCode = -1;
			}
		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

		return errorCode;
	}

	/**
	 * Deletes a student from the database
	 * 
	 * @return 0 = Ok | 1 = Not found | -1 = Invalid ID format
	 * @throws SQLException
	 */
	public int deleteStudent(int studentId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int errorCode = -1;

		try {
			connection = openConnection();
			String sqlText = "DELETE FROM Student WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, studentId);
			int deleted = preparedStatement.executeUpdate();

			if (deleted == 1) {
				errorCode = 0;
			} else if (deleted == 0) {
				errorCode = 1;
			}
			
		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: deleteStudent() failed. " + sqle.getMessage() + "\n");

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

		return errorCode;
	}

	/**
	 * Updates student data to the database
	 * 
	 * @return 0 = Ok | 1 = Not found | -1 = Invalid ID format
	 * @throws SQLException
	 */
	public int updateStudent(Student student) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int errorCode = -1;

		try {
			connection = openConnection();
			String sqlText = "UPDATE Student SET firstname=?, lastname=?, streetaddress=?, postcode=?, postoffice=? "
					+ "WHERE id=?";
			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getStreetAddress());
			preparedStatement.setString(4, student.getPostcode());
			preparedStatement.setString(5, student.getPostOffice());
			preparedStatement.setInt(6, student.getId());
			preparedStatement.executeUpdate();

			errorCode = 0;

		} catch (SQLException sqle) {
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				errorCode = 1;
			} else {
				System.out.println("\n[ERROR] StudentDAO: updateStudent() failed. " + sqle.getMessage() + "\n");
				errorCode = -1;
			}

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

		return errorCode;
	}
}
// End