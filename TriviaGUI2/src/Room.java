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
        this.Question = "Your journey begins! Select a room to proceed"; //default text for empty rooms
        this.A1 = " "; this.A2 = " "; this.A3 = " "; this.A4 = " ";
    }
    public void setLocked() {
        this.isLocked = true;
        this.Question = "This room is locked!";
        this.A1 = " "; this.A2 = " "; this.A3 = " "; this.A4 = " "; this.CorrectAnswer = 5; //5 to guarantee no one can accidentally reenter the right value
    }
    public boolean setQuestionData (String Question,String A1,String A2,String A3,String A4,int CorrectAnswer){

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
//
//        if(isLocked==false){
//            return result;
//        }
//        result[0]="This Room is Locked";
//        result[1]="";
//        result[2]="";
//        result[3]="";
//        result[4]="";
//        return result;
        return result;
    }
    public void setExit() {
        this.exit = true;
    }
}
