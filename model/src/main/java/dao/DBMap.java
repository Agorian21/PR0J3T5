package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * The class DBMap which return an array with the selected map inside
 * @author Jerome
 *
 */
public class DBMap extends DBConnection{
	
	public DBMap(int lvl) {
		super(lvl);
	}
	/**
	 * Call a procedure to get the map
	 * @param result
	 * @param statement
	 * @return
	 */
	public ResultSet getMap(ResultSet result, Statement statement) {
		try {
			switch(lvl) {
			case 1:
				result = statement.executeQuery("call lvl(0)");
				setDiamondRequired(18);
				break;
			case 2:
				result = statement.executeQuery("call lvl(1)");
				setDiamondRequired(13);
				break;	
			case 3:
				result = statement.executeQuery("call lvl(2)");
				setDiamondRequired(8);
				break;
			case 4:
				result = statement.executeQuery("call lvl(3)");
				setDiamondRequired(12);
				break;
			case 5:
				result = statement.executeQuery("call lvl(4)");
				setDiamondRequired(22);
				break;				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Turns the result into an array of character which is used to generate the Matrix
	 * @param result
	 * @param tab
	 */
	public void setMapQueryIntoArray(ResultSet result, char[][] tab) {
		try {
			while (result.next()) {
				int x = result.getInt("x");
				int y = result.getInt("y");
				String element = result.getString("elements");
				
				tab[y][x]=element.charAt(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
