public class test {
    public static void main(String[] args) {
        QuestionDatabase database = new QuestionDatabase("Questions.csv");
        new TriviaGUI();
        new GamePlayCycle(database);

        database.dropTable();
    }
}
