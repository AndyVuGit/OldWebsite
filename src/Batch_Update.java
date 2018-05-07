import java.sql.*; 

public class Batch_Update {
	static String DB_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_CONNECTION = "jdbc:mysql://moviedb";
	static String DB_USER = "root";
	static String DB_PASSWORD = "Ouranromanc1e";

public void batchUpdateUsingPreparedStatement() throws SQLException {
	Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	int[] result = null;
	String SQL = "INSERT INTO customers set firstName=?,lastName=? where id=?";
	try {
		PreparedStatement stmt = connection.prepareStatement(SQL);
		connection.setAutoCommit(false);
		stmt.setString(1, "Abc");
		stmt.setString(2, "Def");
		stmt.setInt(3, 1);
		stmt.addBatch();
		
		stmt.setString(1, "Xyz");
		stmt.setString(2, "Uvw");
		stmt.setInt(3, 2);
		stmt.addBatch();
		result = stmt.executeBatch();
		connection.commit();
	}catch (SQLException e) {
		connection.rollback();
		e.printStackTrace();
	}finally {
		if (connection != null)
			connection.close();
	}
	System.out.println("Number of rows affected: " + result.length);
}}