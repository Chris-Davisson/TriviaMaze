public class test {
    public static void main(String[] args) {
        QuestionDatabase database = new QuestionDatabase("Questions.csv");
        Maze maze = new Maze(database);
        database.dropTable();
        new TriviaGUI(maze);
    }
}
