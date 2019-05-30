package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 *
 * @author Jean-Aymeric Diet
 */
 public class DBConnection extends DBQueries{
	/** The instance. */
	private static DBConnection	INSTANCE	= null;

	/** The connection. */
	private Connection					connection;

	/**
	 * Instantiates a new DB connection.
	 */
	public DBConnection(int lvl) {
		super(lvl);
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection(lvl);
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	public void connection() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
			statement = connection.createStatement();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
	
	public char[][] getTab() {
		return tab;
	}
}
