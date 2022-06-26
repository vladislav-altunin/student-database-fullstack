package data_access;

/**
 * ConnectionParameters.java 
 * 
 * - Reusable DBMS connection configuration parameter settings for
 * Dynamic Web Projects
 * 
 * Here are set the connection string, user name, and password to connect the
 * desired database. In addition, the vendor-specific error code for primary key
 * violation is defined here.
 */

public class ConnectionParameters {
	// The user name and password are optional.
	public static final String username = "postgres";	// Not needed with SQLite
	public static final String password = "1234";	// Not needed with SQLite

	// Postgresql driver name, database name etc.
	public static final String jdbcDriver = "org.postgresql.Driver";
	public static final String projectName = "WebAppExercises"; // <= Name of the Web Application
	public static final String databaseFolder = "databases";
	public static final String databaseName = "student-database"; // <= Name of the DB file in case with SQLite
	public static final String databaseLocation2 = getDatabaseLocation(); // For SQLite
	public static final String databaseLocation = "//localhost:5432/";
	public static final String connectionString = "jdbc:postgresql:" + databaseLocation + databaseName;

	// PK violation: The error code in SQLite is 19
	// OR unique_violation in Postgresql: The error code is 23505
	public static final int PK_VIOLATION_ERROR = 23505;
	

	// This method finds the absolute path to the database file
	// For SQLite
	public static String getDatabaseLocation() {
		String path = System.getProperty("catalina.base");
		
		path = path.substring(0, path.indexOf(".metadata"));
		path += "/" + projectName + "/" + databaseFolder + "/";
		
		return path;
	}
	
}
// End