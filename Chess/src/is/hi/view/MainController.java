/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.view;

import is.hi.function.Chess;
import is.hi.function.Players;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;


/**
 * This is the main controller
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 */
public class MainController implements Initializable {
    
    @FXML
    private Canvas canvas; //The chesstable is drawn here
    @FXML
    private ChessTable chessTable; //The chesstable it self
    
    private final Chess chess=new Chess(); //The chess game
    @FXML
    private ChessDialogController chessDialogController;
    @FXML
    private MenuController menuController;
    @FXML
    private LanguageController languageController;
    
    @FXML
    private BlackClockController blackClockController;
    @FXML
    private WhiteClockController whiteClockController;
    
    @FXML
    private RadioButton whiteRadio;
    @FXML
    private RadioButton blackRadio;
    @FXML
    private ToggleGroup players; //So only one button can be active at a time
    @FXML
    private ToggleButton musicButton;
    
    private  MediaPlayer mediaPlayer;
    private boolean pause=false; //True is music is off, false if it is on
    
    private String timeValue; //Chosen time limit
    public boolean isTimeLimit; //true if there is a time limit
    
    private ResourceBundle strings; //Language package
    @FXML
    private Label errorMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.newGame();
        music();
        
              
        // TODO
    }    
    /**
     * 
     * @return the canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Handler for when the players press the radiobuttons
     * When pressed by a player then the other player takes his turn
     * @param event 
     */
    @FXML
    private void choosePlayerHandler(ActionEvent event) {
        RadioButton b=(RadioButton)event.getSource();
        String s=(String)b.getId();
        if(s.equals("whiteRadio"))
        {
            chess.setCurrentPlayer(1);
            blackRadio.setDisable(true);
            chess.enableWhite();
            if(isTimeLimit)
            {
                blackClockController.pauseTime();
                whiteClockController.start();
            }
            
            
        }
        else
        {
            chess.setCurrentPlayer(2);
            whiteRadio.setDisable(true);
            chess.enableBlack();
            if(isTimeLimit)
            {
                whiteClockController.pauseTime();
                blackClockController.start();
            }
            
            
        }
       
    }
    /**
     * When a player has made a move all his pieces are disabled and the other
     * player takes his turn
     */
    public void nextRound(){
        if(chess.getCurrentPlayer()==1)
        {
            blackRadio.setDisable(false);
            chess.disableWhite();
            
            //whiteRadio.setDisable(true);
            
            System.out.println("Next Round");
           
        }
        else
        {
            whiteRadio.setDisable(false);
            //blackRadio.setDisable(true);
            chess.disableBlack();
           
            
            
           
            System.out.println("Next Round");
           
        }
    }

    /**
     * Starts a new game
     */
    void newGame() {
        
        strings=ResourceBundle.getBundle("is.hi.view.Language.text", new Locale("en","GB"));
        chessTable.setMain(this);
        chessTable.setChess(chess);
        languageController.setMain(this);
        languageController.languageDial();
        chessTable.setLanguage(strings);
        chessTable.clearTable();
        chessTable.drawTable(canvas.getGraphicsContext2D());
        chess.setMain(this);
        
        chessDialogController.setMain(this);
        menuController.setMain(this);
        menuController.setLanguage(strings);
        chessDialogController.setLanguage(strings);
        chessDialogController.setTimes();
        
        
        blackClockController.setMain(this);
        whiteClockController.setMain(this);
        
        blackClockController.pauseTime();
        whiteClockController.pauseTime();
        
        
        Players players=chessDialogController.ChessDialog();
        
        //System.out.println(timeValue);
        whiteRadio.setText(players.getWhite());
        blackRadio.setText(players.getBlack());
        
        chess.setChessTable(chessTable);
        whiteRadio.setSelected(true);
        blackRadio.setDisable(true);
        chess.setCurrentPlayer(1);
        
        chess.enableWhite();
        
        timeValue=chessDialogController.getTime();
        if(!timeValue.equals(strings.getString("dialogUnlimited")))
        {
            isTimeLimit=true;
            int timeInt=Integer.parseInt(timeValue);
            blackClockController.setTime(timeInt);
            //blackClockController.start();
            whiteClockController.setTime(timeInt);
            whiteClockController.start();
        }
        else
        {
            isTimeLimit=false;
            blackClockController.noClock();
            whiteClockController.noClock();
        }
        musicButton.setText(strings.getString("music"));
        //music();
    }

    /**
     * Ends the game
     * @param i 1 white won, 2 if black won
     */
    void gameOver(int i) {
        String winner;
        if(i==2)
        {
            winner=blackRadio.getText();
            
        }
        else
        {
            winner=whiteRadio.getText();
        }
        displayErrorMessage("");
        chess.disableBlack();
        chess.disableWhite();
        whiteRadio.setDisable(true);
        blackRadio.setDisable(true);
        Alert gameOver = new Alert
        (Alert.AlertType.INFORMATION);
        
        gameOver.setTitle(strings.getString("alertID"));
        gameOver.setHeaderText(strings.getString("alertHeader"));
        gameOver.setContentText(winner +" " + strings.getString("alertText"));
        
        gameOver.setOnHidden(evt -> gameOver.close());
        gameOver.show();
    }
    /**
     * Plays the music
     */
    void music(){    
      
        final URL resource = getClass().getResource("Music/Minuetto.mp3");
        final Media media = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
             
}

    /**
     * Handler for when the music is stopped or started
     * @param event 
     */
    @FXML
    private void musicHandler(ActionEvent event) {
        if(!pause)
        {
            mediaPlayer.pause();
            pause=true;
        }
        else 
        {
            mediaPlayer.play();
            pause=false;
        }
        
    }

    /**
     * Sets the language
     * @param s language package
     */
    void setLanguage(ResourceBundle s) {
        strings=s;
    }
    
    /**
     * Displays an error message
     * @param s the error message
     */
    public void displayErrorMessage(String s){
        errorMessage.setText(s);
    }
}
