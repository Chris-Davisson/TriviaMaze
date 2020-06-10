public class test {
    public static void main(String[] args) {
        QuestionDatabase database = new QuestionDatabase("triviaGUI2\\resources\\Questions.csv");
        GamePlayCycle gamePlay = new GamePlayCycle(database);
        database.dropTable();
    }
}
