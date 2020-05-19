import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QuestionDatabase {

      //This is the Middle man for all database interactions. All queries to the database will go through here
     //because this class optimally will handle exceptions and null pointer exceptions to keep that nonsense from cluttering
    //up the main code.


    //Functions Quick Access--------------------

    //dropTable()
        //clears the current working table. Currently required upon application close (still working on it)
        //CREATE TABLE IF NOT EXISTS for some reason just creates a table regardless if the database exists or not.

    //getTable()
        //Returns the entire working table.

    FileReader fileIn;
    BufferedReader fileReader;
    Connection dbCon;
    Statement stmt;          //DDL (really only used for database creation
    PreparedStatement dml;  //data management (insert, update, select)

    final String DATABASE_FILE = "jdbc:sqlite:QuestionDatabase.db";
    final String TABLE_DROP = "DROP TABLE questions";
    final String TABLE_CREATE = "CREATE TABLE IF NOT EXISTS questions (\n"
            + "Question varchar(255), \n"
            + "Answer1 varchar(255), \n"
            + "Answer2 varchar(255), \n"
            + "Answer3 varchar(255), \n"
            + "Answer4 varchar(255), \n"
            + "Correct int \n"
            +");";

    public QuestionDatabase(String fileName) {
        setFile(fileName);
    }
    //-----------------------------------------------
    //Setters
    //-----------------------------------------------

    //main purpose for this method is so that constructing a QuestionDatabase object
    //doesn't require a try catch block. It's public in case we want to be able to switch files at runtime.
    public void setFile(String fileName) {

        try {
            this.fileIn = new FileReader(fileName);
        }
        catch(FileNotFoundException e) {
            this.fileIn = null;
            System.out.println(e);
        }

        convertDatabase(fileIn);
    }
    //-----------------------------------------------
    //Getters
    //-----------------------------------------------
    public void getTable() {
        try {
            this.dml = this.dbCon.prepareStatement("SELECT * from questions");
            ResultSet r = this.dml.executeQuery();

            while(r.next()) {
                System.out.println(r.getString("Question")
                                                                      + "\t" + r.getString("Answer1")
                                                                      + "\t" + r.getString("Answer2")
                                                                      + "\t" + r.getString("Answer3")
                                                                      + "\t" + r.getString("Answer4")
                                                                      + "\t" + r.getInt("Correct"));
            }
        }
        catch(Exception e) {
            e.getMessage();
            System.out.println(e);
        }

    }

    //-----------------------------------------------
    //Other Methods
    //-----------------------------------------------
    public void dropTable() {

        try {
            this.stmt.execute(TABLE_DROP);

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }

    }

    //Called by the setFile. Will convert the .csv file into a sql compatible database.
    //This is called by setFile instead of the constructor so that if the file for questions is switched at run time
    //the questiondatabase object will automatically convert to sql.
    private void convertDatabase(FileReader fileIn) {


        //This try catch block will build the .db (database) file
        //and then create a table for the questions/answers.
        try {
            this.dbCon = DriverManager.getConnection(DATABASE_FILE);

            if(dbCon != null) {
                DatabaseMetaData mData = this.dbCon.getMetaData();
                this.stmt = this.dbCon.createStatement();
                this.stmt.execute(TABLE_CREATE);
            }
        }
        catch(SQLException e) {
            e.getMessage();
            System.out.println(e);
        }


        //This try catch block will read the information from the csv file
        //and then convert to sql.
        try {

            fileReader = new BufferedReader(fileIn);
            String line = "";
            int lineId;

            while((line = fileReader.readLine()) != null) {

                    //Some of the data is a quote with a comma in it, so it needs to be split manually.

                if(line.contains("\"")) {
                    int commaPosition1 = 0;
                    int commaPosition2 = 0;
                    String splitString;
                    this.dml = this.dbCon.prepareStatement("INSERT INTO questions(Question, Answer1, Answer2, Answer3, Answer4, Correct) VALUES(?, ?, ?, ?, ?, ?)");

                    for(int i = 1; i < 6; i++) {

                        if(line.charAt(0) == '"') {
                            commaPosition2 = line.indexOf("\"", 1) + 1;
                            splitString = line.substring(commaPosition1, commaPosition2);
                            this.dml.setString(i, splitString);
                            line = line.substring(commaPosition2 + 1);
                        }
                        else {
                            commaPosition2 = line.indexOf(",");
                            splitString = line.substring(commaPosition1, commaPosition2);
                            this.dml.setString(i, splitString);
                            line = line.substring(commaPosition2 + 1);
                        }
                    }
                    this.dml.setInt(6, Integer.parseInt(line));
                    this.dml.executeUpdate();
                }
                //If there is no quote in the current entry, this can be safely split and added automatically.
                else {
                    String[] fileValues = line.split(",");
                    this.dml = this.dbCon.prepareStatement("INSERT INTO questions(Question, Answer1, Answer2, Answer3, Answer4, Correct) VALUES(?, ?, ?, ?, ?, ?)");
                    this.dml.setString(1, fileValues[0]);
                    this.dml.setString(2, fileValues[1]);
                    this.dml.setString(3, fileValues[2]);
                    this.dml.setString(4, fileValues[3]);
                    this.dml.setString(5, fileValues[4]);
                    this.dml.setInt(6, Integer.parseInt(fileValues[5]));
                    this.dml.executeUpdate();
                }
            }
        }
        catch(Exception e) {

        }

    }
}
