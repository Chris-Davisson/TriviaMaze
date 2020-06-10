public class GamePlayCycle {
    Maze maze;
    TriviaGUI gui;
    int cUp, cLeft, cDown, cRight;  //the possible places to move as a player.
    int charX;
    int charY;
    public GamePlayCycle(QuestionDatabase database) {
        this.maze = new Maze(database);
        this.gui = new TriviaGUI(this);
        this.charX = 0;
        this.charY = 0;
        startGame();
    }
    protected int xGetPlayerLocation() {
       return this.charX;
    }
    protected int yGetPlayerLocation() {
        return this.charY;
    }
    //Used for the cheat
    protected int getCorrectAnswer(int x, int y) {
        return this.maze.Maze[x][y].CorrectAnswer;
    }
    //Called by the GamePlayCycle Constructor.
    //Probably needs more work.
    protected void startGame() {
        this.gui.setQuestion("Your journey begins. Select a room to proceed");
        this.gui.setBunnyLocation(this.charX, this.charY);
    }
    //This is called when a room button is pressed.
    //It will send the data from the maze to the gui to use for that room.
    protected void roomEntry(int x, int y) {
        String[] Question = this.maze.getRoomData(x, y);
        this.gui.setQuestion(Question[0]);
        this.gui.setAnswers(Question[1], Question[2], Question[3], Question[4]);
    }
    //This is called when the submit button is pressed.
    //Checks for if the answer is correct or not. If it is correct, it moves.
    protected void submit(int x, int y, int playerAnswer) {
        if(this.maze.Maze[x][y].checkAnswer(playerAnswer)){
            move(x, y);
        }
        else {
            this.maze.Maze[x][y].isLocked = true;
        }
    }
    //Moves the player and the bunny icon. (for some reason not loading atm)
    protected void move(int x, int y) {
        this.charX = x;
        this.charY = y;
        this.gui.setBunnyLocation(x, y);
    }
}
