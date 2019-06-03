package dao;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Class DBQuerries.
 *
 * @author Jerome
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
	 * It creates a new connection, gets the map and then transforms it in an Array of char
	 *
	 * @return the boolean
	 */
	public void queries() {
		connectionBDD = new DBConnection(lvl);
		connectionBDD.connection();
		
		map = new DBMap(lvl);
		result= map.getMap(result, statement);
		map.setMapQueryIntoArray(result, tab);
		
	}

/**
 * Getter of Tab
 * @return Tab
 */
	public char[][] getTab() {
		return tab;
	}

	/**
	 * Getter of DiamondRequired
	 * @return DiamondRequired
	 */
	public static int getDiamondRequired() {
		return diamondRequired;
	}

	/**
	 * Setter of DiamondRequired
	 * @param diamondRequired
	 */
	public static void setDiamondRequired(int diamondRequired) {
		DBConnection.diamondRequired = diamondRequired;
	}

}
