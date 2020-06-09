public class GamePlayCycle {

    final int MAZE_X_DIMENSION = 4;
    final int MAZE_Y_DIMENSION = 4;
    int[] playerPosition;
    Maze gameMaze;

    public GamePlayCycle(QuestionDatabase qdb) {
        this.playerPosition = new int[2];   //stores 2 values. 0 index for x, 1 index for y
        this.playerPosition[0] = 0;
        this.playerPosition[1] = 3;
        this.gameMaze = new Maze(qdb);
        this.gameMaze.setCharLocation(this.playerPosition[0], this.playerPosition[1]);

        roomEnter(this.playerPosition[0], this.playerPosition[1]);
    }
    private void roomEnter(int playerX, int playerY) {
        String[] roomData = this.gameMaze.getQuestion(playerX, playerY);
        //populate question data

        //select
    }
}
