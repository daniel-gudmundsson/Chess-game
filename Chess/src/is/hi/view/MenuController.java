/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class for the menubar
 *
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 */
public class MenuController implements Initializable {

    @FXML
    private MenuBar menu;
    private MainController mainController; //Connection to the MainController
    
    @FXML
    private Menu file;
    @FXML
    private MenuItem newGame;
    @FXML
    private MenuItem close;
    @FXML
    private Menu help;
    @FXML
    private MenuItem about;
    
    private ResourceBundle strings;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * Initializes the MainController
     * @param mThis 
     */
    public void setMain(MainController mThis) {
        mainController=mThis;
        
    }
    /**
     * Handler to start a new game
     * @param event 
     */
    @FXML
    private void newGameHandler(ActionEvent event) {
        mainController.newGame();
    }

    /**
     * Handler to quit the game
     * @param event 
     */
    @FXML
    private void closeHandler(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Handler for information about the game and author
     * @param event 
     */
    @FXML
    private void aboutHandler(ActionEvent event) {
        Alert about = new Alert
        (Alert.AlertType.INFORMATION);
        about.setTitle(strings.getString("aboutID"));
        about.setHeaderText(strings.getString("aboutHeader"));
        about.setContentText(strings.getString("aboutText"));
        
        about.showAndWait();
    }
    /**
     * Sets the language
     * @param s language package
     */
    public void setLanguage(ResourceBundle s){
        strings=s;
        file.setText(strings.getString("file"));
            newGame.setText(strings.getString("newGame"));
            close.setText(strings.getString("close"));
            help.setText(strings.getString("help"));
            about.setText(strings.getString("about"));
    }
}
