package database;

import java.sql.*;

public class DBConnect {
	
	private Connection conn;
	
	public DBConnect(String url, String username, String password) {
		conn = DatabaseConnection(url, username, password);
	}
	
	private Connection DatabaseConnection (String url, String username, String password) {
		System.out.println("Connecting...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			if (this.conn != null) {
				System.out.println("Connected!");
				System.out.println(conn);
				return conn;
			} 
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
		return null;
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	public ResultSet getResultSet(String sqlQuery) throws SQLException {
		Statement statement = conn.createStatement();
		return statement.executeQuery(sqlQuery);
	}
	
	public int displayResults(ResultSet result) throws SQLException {
        ResultSetMetaData meta = result.getMetaData();
        int columnsNumber = meta.getColumnCount();
        System.out.println("columns: "+columnsNumber);
        while(result.next()){
            for (int i = 0; i <= columnsNumber; i++){
                System.out.println(result.getString(i) + " ");
            }
            System.out.println();
        }
        return 0;
    }
	
	public void close() {
		try {
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	
	public static void main(String[] args) throws SQLException {
		DBConnect con = new DBConnect(
             "jdbc:mysql://127.0.0.1:3306/treningsdagbok",
             "root",
             "6756");
		String query = "SELECT * from apparat";
		ResultSet rs = con.getResultSet(query);
		con.displayResults(rs);
		con.close();
	}
	
	
}
