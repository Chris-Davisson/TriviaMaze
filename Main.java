public class Main {

    public static void main(String[] args) {
	// write your code here
        QuestionDatabase database = new QuestionDatabase("Questions.csv");
        Maze maze = new Maze(database);
        
        database.dropTable();//make sure this line is called when closing the program.
    }
}
