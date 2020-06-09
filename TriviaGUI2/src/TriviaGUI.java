import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class TriviaGUI extends  JFrame {


    private Container c;
    private Maze maze;
    private JLabel title;


    private int playerLocationX  = 0, playerLocationY = 0;
    private int playerAnswer = 0;
    private int correctAnswer;
    private Icon playerIcon = new ImageIcon("Killer_Rabbit.png");
    private Icon room = new ImageIcon("room.jpg");


    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton[] buttonHolder;// = {button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button10,button11,button12,button13,button14,button15,button16};
    private JButton[][] buttHolder = {{button13,button9,button5,button1},{button14,button10,button6,button2},{button15,button11,button7,button3},{button16,button12,button8,button4}};
    private JButton submit;


    private ButtonGroup buttons;

    private JTextArea questionTextArea;
    private JRadioButton answerRadioButton1;
    private JRadioButton answerRadioButton4;
    private JRadioButton answerRadioButton3;
    private JRadioButton answerRadioButton2;


    private JLabel resultsTextArea;
    private JTextArea answerTextArea3;
    private JTextArea answerTextArea1;
    private JTextArea answerTextArea2;
    private JTextArea answerTextArea4;

    private boolean playerAnswerIsCorrect = false;
    private boolean highlightCorrectAnswer = false;



    //Menu
    private JMenuBar menuBar = new JMenuBar();
    private JMenu cheats = new JMenu();
    private JMenu settings = new JMenu();
    private String[] fontsHolder;
    private String font = "Arial";

    public TriviaGUI(Maze maze){
        super("Trivia Maze");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        this.maze = maze;

        //menu stuff
        menuBar.add(getFileMenu());
        menuBar.add(getHelpMenu());
        this.setJMenuBar(menuBar);



        //Making and hardcodding the locations of everything
        makeQuestionAndAnswerPlace(c);
        buttHolder = new JButton[][] {{button13,button9,button5,button1},{button14,button10,button6,button2},{button15,button11,button7,button3},{button16,button12,button8,button4}};
        //Needed for GUI stuff
        setVisible(true);
    }


    //Just making all the btns and stuff

    private void makeQuestionAndAnswerPlace(Container c){


        title = new JLabel("Trivia Maze");
        title.setFont(new Font(font, Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(250, 10);
        c.add(title);

        Font f = new Font(font , Font.PLAIN , 16);

        button1 = new JButton("1");
        button1.setSize(100, 100);
        button1.setLocation(0,425);
        button1.setFont(f);
        button1.addActionListener(this::actionPerformed);
        c.add(button1);

        button2 = new JButton("2");
        button2.setSize(100, 100);
        button2.setLocation(100,425);
        button2.setFont(f);
        button2.addActionListener(this::actionPerformed);
        c.add(button2);

        button3 = new JButton("3");
        button3.setSize(100, 100);
        button3.setLocation(200,425);
        button3.setFont(f);
        button3.addActionListener(this::actionPerformed);
        c.add(button3);

        button4 = new JButton("4");
        button4.setSize(100, 100);
        button4.setLocation(300,425);
        button4.setFont(f);
        button4.addActionListener(this::actionPerformed);
        c.add(button4);

        button5 = new JButton("5");
        button5.setSize(100, 100);
        button5.setLocation(0,325);
        button5.setFont(f);
        button5.addActionListener(this::actionPerformed);
        c.add(button5);

        button6 = new JButton("6");
        button6.setSize(100, 100);
        button6.setLocation(100,325);
        button6.setFont(f);
        button6.addActionListener(this::actionPerformed);
        c.add(button6);

        button7 = new JButton("7");
        button7.setSize(100, 100);
        button7.setLocation(200,325);
        button7.setFont(f);
        button7.addActionListener(this::actionPerformed);
        c.add(button7);

        button8 = new JButton("8");
        button8.setSize(100, 100);
        button8.setLocation(300,325);
        button8.setFont(f);
        button8.addActionListener(this::actionPerformed);
        c.add(button8);

        button9 = new JButton("9");
        button9.setSize(100, 100);
        button9.setLocation(0,225);
        button9.setFont(f);
        button9.addActionListener(this::actionPerformed);
        c.add(button9);

        button10 = new JButton("10");
        button10.setSize(100, 100);
        button10.setLocation(100,225);
        button10.setFont(f);
        button10.addActionListener(this::actionPerformed);
        c.add(button10);

        button11 = new JButton("11");
        button11.setSize(100, 100);
        button11.setLocation(200,225);
        button11.setFont(f);
        button11.addActionListener(this::actionPerformed);
        c.add(button11);

        button12 = new JButton("12");
        button12.setSize(100, 100);
        button12.setLocation(300,225);
        button12.setFont(f);
        button12.addActionListener(this::actionPerformed);
        c.add(button12);

        button13 = new JButton(playerIcon);
        button13.setSize(100, 100);
        button13.setLocation(0,125);
        button13.setFont(f);
        button13.addActionListener(this::actionPerformed);
        c.add(button13);

        button14 = new JButton("14");
        button14.setSize(100, 100);
        button14.setLocation(100,125);
        button14.setFont(f);
        button14.addActionListener(this::actionPerformed);
        c.add(button14);

        button15 = new JButton("15");
        button15.setSize(100, 100);
        button15.setLocation(200,125);
        button15.setFont(f);
        button15.addActionListener(this::actionPerformed);
        c.add(button15);

        button16 = new JButton("16");
        button16.setSize(100, 100);
        button16.setLocation(300,125);
        button16.setFont(f);
        button16.addActionListener(this::actionPerformed);
        c.add(button16);

        submit = new JButton("SUBMIT!!");
        submit.setSize(120,20);
        submit.setLocation(500,500);
        submit.setFont(f);
        submit.addActionListener(this::actionPerformed);
        c.add(submit);


        questionTextArea = new JTextArea("The questions will go here. This is the best text holder I could find for the task.\n But it still allows the person to edit it");
        questionTextArea.setFont(new Font(font , Font.PLAIN , 14));
        questionTextArea.setSize(400 , 150);
        questionTextArea.setLocation(435, 75);
        questionTextArea.setLineWrap(true);

        c.add(questionTextArea);


        //These are the Circle buttons that will be used to choose an answer
        //ButtonGroup makes it so only one can be clicked at a time
        buttons = new ButtonGroup();


        answerRadioButton1 = new JRadioButton();
        answerRadioButton1.setLocation(435,240);
        answerRadioButton1.setSize(20,20);
        answerRadioButton1.setSelected(true);
        c.add(answerRadioButton1);
        buttons.add(answerRadioButton1);

        answerRadioButton2 = new JRadioButton();
        answerRadioButton2.setLocation(435,310);
        answerRadioButton2.setSize(20,20);
        c.add(answerRadioButton2);
        buttons.add(answerRadioButton2);

        answerRadioButton3 = new JRadioButton();
        answerRadioButton3.setLocation(435,380);
        answerRadioButton3.setSize(20,20);
        c.add(answerRadioButton3);
        buttons.add(answerRadioButton3);

        answerRadioButton4 = new JRadioButton();
        answerRadioButton4.setLocation(435,450);
        answerRadioButton4.setSize(20,20);
        c.add(answerRadioButton4);
        buttons.add(answerRadioButton4);

        //Answer TextAreas. They are placed to the right of their corresponding RadioButtons
        answerTextArea1 = new JTextArea("Answer goes here\n.................................................");
        answerTextArea1.setFont(new Font(font , Font.PLAIN , 14));
        answerTextArea1.setSize(350,50);
        answerTextArea1.setLocation(460,230);
        c.add(answerTextArea1);

        answerTextArea2 = new JTextArea("Holder text\n.................................................");
        answerTextArea2.setFont(new Font(font , Font.PLAIN , 14));
        answerTextArea2.setSize(350,50);
        answerTextArea2.setLocation(460,300);
        c.add(answerTextArea2);

        answerTextArea3 = new JTextArea("Holder text\n.................................................");
        answerTextArea3.setFont(new Font(font , Font.PLAIN , 14));
        answerTextArea3.setSize(350,50);
        answerTextArea3.setLocation(460,370);
        c.add(answerTextArea3);

        answerTextArea4 = new JTextArea("Holder text\n.................................................");
        answerTextArea4.setFont(new Font(font , Font.PLAIN , 14));
        answerTextArea4.setSize(350,50);
        answerTextArea4.setLocation(460,440);
        c.add(answerTextArea4);


        resultsTextArea = new JLabel("You are the killer bunny");
        resultsTextArea.setFont(new Font(font , Font.PLAIN , 20));
        resultsTextArea.setSize(300,100);
        resultsTextArea.setLocation(0,0);
        c.add(resultsTextArea);

        setQuestionAndAnswers();
    }

    private void setQuestionAndAnswers(){
        questionTextArea.setText(maze.Maze[playerLocationX][playerLocationY].Question);
        answerTextArea1.setText(maze.Maze[playerLocationX][playerLocationY].A1);
        answerTextArea2.setText(maze.Maze[playerLocationX][playerLocationY].A2);
        answerTextArea3.setText(maze.Maze[playerLocationX][playerLocationY].A3);
        answerTextArea4.setText(maze.Maze[playerLocationX][playerLocationY].A4);

        correctAnswer = maze.Maze[playerLocationX][playerLocationY].CorrectAnswer;
        if(highlightCorrectAnswer == true){
            if(correctAnswer == 0 ) answerTextArea1.setBackground(Color.BLUE);
        }
    }


    //Button Action handlers. Code for when buttons are pressed goes here
    public void actionPerformed(ActionEvent e){
        Object action = e.getSource();


        if(action == button1){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 0;
            playerLocationY = 3;
        }else if(action == button2){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 1;
            playerLocationY = 3;
        }else if(action == button3){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 2;
            playerLocationY = 3;
        }else if(action == button4){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 3;
            playerLocationY = 3;
        }else if(action == button5){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 0;
            playerLocationY = 2;
        }else if(action == button6){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 1;
            playerLocationY = 2;
        }else if(action == button7){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 2;
            playerLocationY = 2;
        }else if(action == button8){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 3;
            playerLocationY = 2;
        }else if(action == button9){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 0;
            playerLocationY = 1;
        }else if(action == button10){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 1;
            playerLocationY = 1;
        }else if(action == button11){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 2;
            playerLocationY = 1;
        }else if(action == button12){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 3;
            playerLocationY = 1;
        }else if(action == button13){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 0;
            playerLocationY = 0;
        }else if(action == button14){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 1;
            playerLocationY = 0;
        }else if(action == button15){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 2;
            playerLocationY = 0;
        }else if(action == button16){
            if(!playerAnswerIsCorrect){
                resultsTextArea.setText("Answer The Question");
                return;
            }
            playerLocationX = 3;
            playerLocationY = 0;
        }else if(action == submit){
            if(playerAnswer == maze.Maze[playerLocationX][playerLocationY].CorrectAnswer){
                playerAnswerIsCorrect = true;
            }


        }else if(action == answerRadioButton1){
            playerAnswer = 1;
        }else if(action == answerRadioButton2){
            playerAnswer = 2;
        }else if(action == answerRadioButton3){
            playerAnswer = 3;
        }else if(action == answerRadioButton4){
            playerAnswer = 4;
        }
        else{
            System.out.println("Error message: Something went wrong, IDK what.");
        }
        setBunnyLocation();

    }

    private boolean isValidLocation(){



        return true;
    }

    private void setBunnyLocation(){
        BufferedImage invisibleIcon = new BufferedImage(button1.getWidth(),button1.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
        ImageIcon invis = new ImageIcon(invisibleIcon);
        button1.setIcon(invis);
        button2.setIcon(invis);
        button3.setIcon(invis);
        button4.setIcon(invis);
        button5.setIcon(invis);
        button6.setIcon(invis);
        button7.setIcon(invis);
        button8.setIcon(invis);
        button9.setIcon(invis);
        button10.setIcon(invis);
        button11.setIcon(invis);
        button12.setIcon(invis);
        button13.setIcon(invis);
        button14.setIcon(invis);
        button15.setIcon(invis);
        button16.setIcon(invis);
        buttHolder[playerLocationX][playerLocationY].setIcon(playerIcon);
    }

    //Menu helper method
    private JMenu getFileMenu(){
        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        //IDK why but I feel like it should have a settings option
        settings = new JMenu("settings");

        //Fonts because I was stuck and used this to take up time
        JMenu fonts = new JMenu("fonts");
        fontsHolder = new String[]{"Arial", "Compic Sans MS" , "Futura" , "Georgia" , "Kai" , "Nadeem" , "Osaka" , "Papyrus"};

        for(String s: fontsHolder){
            JMenuItem m = new JMenuItem(s);
            fonts.add(m);
            m.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    font = s;
                    Font newFont = new Font(s , Font.PLAIN , 14);
                    questionTextArea.setFont(newFont);
                    newFont = new Font(s , Font.PLAIN , 16);
                    button1.setFont(newFont);
                    button2.setFont(newFont);
                    button3.setFont(newFont);
                    button4.setFont(newFont);
                    button5.setFont(newFont);
                    button6.setFont(newFont);
                    button7.setFont(newFont);
                    button8.setFont(newFont);
                    button9.setFont(newFont);
                    button10.setFont(newFont);
                    button11.setFont(newFont);
                    button12.setFont(newFont);
                    button13.setFont(newFont);
                    button14.setFont(newFont);
                    button15.setFont(newFont);
                    button16.setFont(newFont);
                    submit.setFont(newFont);
                    answerTextArea1.setFont(newFont);
                    answerTextArea2.setFont(newFont);
                    answerTextArea3.setFont(newFont);
                    answerTextArea4.setFont(newFont);
                    newFont = new Font(s , Font.PLAIN , 16);
                    resultsTextArea.setFont(newFont);
                    newFont = new Font(s , Font.PLAIN , 30);
                    title.setFont(newFont);

                }
            });
        }

        settings.add(fonts);
        file.add(settings);

        //Adding A cheat menu
        //Ideas for cheats: Correct answer is highlighted
        cheats = new JMenu("cheats");
        JMenuItem cheatOption = new JMenuItem("Highlight Correct Answer");
        cheatOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                highlightCorrectAnswer = true;
                correctAnswer = maze.Maze[playerLocationX][playerLocationY].CorrectAnswer;
                if(highlightCorrectAnswer == true){
                    if(correctAnswer == 0 ) answerTextArea1.setBackground(Color.YELLOW);
                    else if(correctAnswer == 1) answerTextArea2.setBackground(Color.YELLOW);
                    else if(correctAnswer == 2) answerTextArea2.setBackground(Color.YELLOW);
                    else if(correctAnswer == 3) answerTextArea4.setBackground(Color.YELLOW);
                }
            }
        });
        cheats.add(cheatOption);


        settings.add(cheats);
        cheatOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This is where the code for the cheat goes, I can add it better when its running better
            }
        });


        file.addSeparator();
        file.add(quit);
        return file;
    }

    //Menu helper method
    private JMenu getHelpMenu(){
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("about");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( null, "Team: Ryan Cranston , Morgan Combs , Christopher Davisson\n" +
                        "Class: CSCD 350-001: Software Development Principle\n" +
                        "Prof: Tom Capaul");
            }
        });
        help.add(about);
        return help;
    }
}
