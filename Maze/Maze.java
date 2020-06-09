import java.util.Random;

public class Maze {

    Room[][] Maze;
    int CharX, CharY;
    int dimX; int dimY; //dimensions
    QuestionDatabase database;
    Random r;

    public Maze(QuestionDatabase qdb) {
        this.database = qdb;
        r = new Random();
        //Might not hard code this in the future.
        this.Maze = new Room[4][4];
        this.dimX = 2;  //x dimension (0 based indexing)
        this.dimY = 2;  //y dimension (0 based indexing)
        //Character Location
        this.CharX = 0; this.CharY = 0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.Maze[i][j] = new Room(i, j);
                int tempid = r.nextInt(this.database.maxQuestions);     //random number for random question id.
                Object[] tempQuestion = this.database.getEntry(tempid); //Acquire the random question.

                this.Maze[i][j].setQuestion((String)tempQuestion[0], (String)tempQuestion[1], (String)tempQuestion[2],
                                            (String)tempQuestion[3], (String)tempQuestion[4], (int)tempQuestion[5]);
            }
        }
        this.Maze[2][2].exit = true;
    }
    public String[] getQuestion(int x, int y) {
        return this.Maze[x][y].getQuestion();
    }
    //Returns true if the game is still winnable
    public boolean isWinnable(int x, int y) {
        //------------------------
            //BASE CASE (successful)
        //------------------------
        if(this.Maze[x][y].exit) {
            return true;
        }

        if(x + 1 <= dimX) {
            if(!this.Maze[x + 1][y].isLocked) {
                x++;
                return isWinnable(x, y);
            }
        }
        if(y + 1 <= dimY) {
            if(!this.Maze[x][y + 1].isLocked) {
                y++;
                return isWinnable(x, y);
            }
        }
        if(x + 1 <= dimX && y + 1 <= dimY) {
            if(!this.Maze[x + 1][y + 1].isLocked) {
                x++;
                y++;
                return isWinnable(x, y);
            }
        }
        if(x - 1 >= 0) {
            if(!this.Maze[x - 1][y].isLocked) {
                x--;
                return isWinnable(x, y);
            }
        }
        if(y - 1 >= 0) {
            if(!this.Maze[x][y - 1].isLocked) {
                y--;
                return isWinnable(x, y);
            }
        }
        if(x - 1 >= 0 && y - 1 >= 0) {
            if(!this.Maze[x - 1][y - 1].isLocked) {
                x--;
                y--;
                return isWinnable(x, y);
            }
        }
        if(x - 1 >= 0 && y + 1 <= dimY) {
            if(!this.Maze[x - 1][y + 1].isLocked) {
                x--;
                y++;
                return isWinnable(x, y);
            }
        }
        if(x + 1 <= dimX && y - 1 >= 0) {
            if(!this.Maze[x + 1][y - 1].isLocked) {
                x++;
                y--;
                return isWinnable(x, y);
            }
        }
        //This return statement will only be reached once all other options fail.
        //Consider it a 2nd base case, but for failure.
        return false;
    }
    public void setDatabase(QuestionDatabase qdb) {
        this.database = qdb;
    }
    public void setCharLocation(int x, int y) {
        this.CharX = x;
        this.CharY = y;
    }
}
