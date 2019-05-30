package dao;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Class DBConnection.
 *
 * @author Jean-Aymeric Diet
 */
 public class DBQueries {

	protected static int lvl=0;
	protected static int diamondRequired=5;
	protected static char tab[][] = new char[25][25];	
	protected static DBConnection connectionBDD;
	protected static DBMap map;
	protected static ResultSet result;
	protected static Statement statement = null;
	/**
	 * Instantiates a new DB connection.
	 */
	public DBQueries(int lvl) {
		DBQueries.lvl=lvl;
	}

	
	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	public void queries() {
		connectionBDD = new DBConnection(lvl);
		connectionBDD.connection();
		
		map = new DBMap(lvl);
		result= map.getMap(result, statement);
		map.setMapQueryIntoTable(result, tab);
		
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	
	public char[][] getTab() {
		return tab;
	}

	public static int getDiamondRequired() {
		return diamondRequired;
	}

	public static void setDiamondRequired(int diamondRequired) {
		DBConnection.diamondRequired = diamondRequired;
	}

}
