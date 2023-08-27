/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.view;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class for the language options
 *
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 */
public class LanguageController implements Initializable {

    @FXML
    private AnchorPane languageDialog;
    @FXML
    private RadioButton english;
    @FXML
    private ToggleGroup engIs; //So only one button can be active at a time
    @FXML
    private RadioButton icelandic;

    private MainController mainController; //Connectio to the MainController
    
    private ResourceBundle strings; //Language package
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Handler for the language RadioButton
     * @param event 
     */
    @FXML
    private void languageHandler(ActionEvent event) {
        RadioButton b=(RadioButton)event.getSource();
        if(b.getText().equals("Íslenska"))
        {
            strings=ResourceBundle.getBundle("is.hi.view.Language.text", new Locale("is"));
        }
        else
        {
            strings=ResourceBundle.getBundle("is.hi.view.Language.text", new Locale("en","GB"));
        }
        
        mainController.setLanguage(strings);
        
    }
    /**
     * Dialog for the language
     */
    @FXML
    public void languageDial(){
        DialogPane p = new DialogPane();
        languageDialog.setVisible(true);
        english.setSelected(true);
        
        p.setContent(languageDialog);
   
        Dialog d = new Dialog();
        
        d.setDialogPane(p);
      
        d.setHeaderText("Choose language");
        d.setTitle("Language");
     
        ButtonType ok = new ButtonType("Ok", 
                ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(ok);
        ButtonType cancel = new ButtonType("Cancel", 
                ButtonBar.ButtonData.CANCEL_CLOSE);
        d.getDialogPane().getButtonTypes().add(cancel);
        
        d.showAndWait();   
    }
    /**
     * Initializes the MainController
     * @param mThis 
     */
    public void setMain(MainController mThis){
        mainController=mThis;
    }
    
}
