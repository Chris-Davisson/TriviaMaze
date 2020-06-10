public class Room {

    //SQL Interactions
    String Question;
    String A1, A2,A3,A4;
    int CorrectAnswer;
    //Room Variables
    Boolean isLocked;
    Boolean exit;
    int x,y;

    public Room(int x,int y){
        this.x=x;
        this.y=y;
        this.isLocked = false;
        this.exit = false;
    }

    public boolean setQuestion (String Question,String A1,String A2,String A3,String A4,int CorrectAnswer){

        this.Question=Question;
        this.A1=A1;
        this.A2=A2;
        this.A3=A3;
        this.A4=A4;
        this.CorrectAnswer=CorrectAnswer;

        return true;
    }
    public boolean checkAnswer(int answer) {
        if(this.CorrectAnswer == answer) {
            return true;
        }
        this.isLocked = true;
        return false;
    }

    public String[] getQuestion() {
        String[] result={this.Question,this.A1,this.A2,this.A3,this.A4};

        if(isLocked==false){
            return result;
        }
        result[0]="This Room is Locked";
        result[1]="";
        result[2]="";
        result[3]="";
        result[4]="";
        return result;
    }
    public void setExit() {
        this.exit = true;
    }
}
