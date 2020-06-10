public class test {
    public static void main(String[] args) {
        QuestionDatabase database = new QuestionDatabase("Questions.csv");
        GamePlayCycle gamePlay = new GamePlayCycle(database);
        database.dropTable();
    }
}
