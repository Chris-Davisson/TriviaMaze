import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class QuestionDatabase {
	
	FileReader tableIn;
	BufferedReader tableReader;
	
	public QuestionDatabase(String tableName) {
		
		convertDatabase(tableName);
	}
	
	
	//Called by the constructor. Will convert the .csv file into a sql compatible database.
	private void convertDatabase(String tableName) {
		
	}
}
