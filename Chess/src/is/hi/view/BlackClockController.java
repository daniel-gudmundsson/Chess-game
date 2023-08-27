/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * FXML Controller class for the Black player's clock
 *
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 */
public class BlackClockController implements Initializable {

   
    private Timeline clock; //The clock
    private int i=0; //I use this variable to count down
    private int time; //Time limit chosen in seconds
    @FXML
    private Label chessClock;
    @FXML
    private MainController mainController; //Connection to the MainController

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       int t = 1; // Time between actions
        int howManyTimes = 100000000; //Number of actions
         clock = new Timeline(new KeyFrame(Duration.seconds(t), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                time--;
                String min;
                String sec;
                if(time/60<10) min="0"+time/60;
                else min=""+time/60;
                if(time%60<10) sec="0"+time%60;
                else sec=""+time%60;
                
                chessClock.setText(min+":"+sec);
                if(time==0)
                {
                   clock.pause();
                   mainController.gameOver(1); 
                }
                    
                i++;
            }
        }));
        
        clock.setCycleCount(howManyTimes);
       
    }

    /**
     * Returns the clock
     * @return clock
     */
    public Timeline getClock(){
    return clock;
}    
    /**
     * Initializes the MainController
     * @param aThis 
     */
    void setMain(MainController aThis) {
        mainController=aThis;
    }
    /**
     * Starts the clock
     */
    void start() {
        clock.play(); 
    }
    /**
     * Sets the time
     * @param minutes 
     */
    void setTime(int minutes){
        time=minutes*60;
        chessClock.setText(time/60+":"+time%60+"0");
    }
    /**
     * Pauses the clock
     */
    void pauseTime() {
        clock.pause();
    }

    /**
     * If there is not time limit
     */
    void noClock() {
        chessClock.setText("");
    }
    
}
