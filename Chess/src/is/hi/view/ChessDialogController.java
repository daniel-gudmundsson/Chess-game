/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.view;

import is.hi.function.Players;
import is.hi.function.TimeModel;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class for the dialog where names, color and time limit is 
 * chosen
 *
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 */
public class ChessDialogController implements Initializable {

    @FXML
    private AnchorPane chessDialog;
    @FXML
    private TextField whiteText; //Name of the white player
    @FXML
    private TextField blackText;//Name of the black player
    private MainController mainController;
    private ObservableList<String> times; //Available time limits
    @FXML
    private ChoiceBox<String> time;//Available time limits in a ChoiceBox
    @FXML
    private Label namesLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label wLabel;
    @FXML
    private Label bLabel;
    
    private ResourceBundle strings; //Language package
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * Runs a dialog which creates the players according to information given
     * @return new Players
     */
    public Players ChessDialog(){
        DialogPane p = new DialogPane();
        chessDialog.setVisible(true);
        
        p.setContent(chessDialog);
        
        Dialog d = new Dialog();
        
        d.setDialogPane(p);
        
            d.setHeaderText(strings.getString("dialogHeader"));
            d.setTitle(strings.getString("dialogID"));
            wLabel.setText(strings.getString("dialogWhite"));
            bLabel.setText(strings.getString("dialogBlack"));
            namesLabel.setText(strings.getString("dialogNameColor"));
            timeLabel.setText(strings.getString("dialogTime"));
    
        ButtonType ok = new ButtonType(strings.getString("dialogOK"), 
                ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(ok);
        ButtonType cancel = new ButtonType(strings.getString("dialogCancel"), 
                ButtonBar.ButtonData.CANCEL_CLOSE);
        d.getDialogPane().getButtonTypes().add(cancel);
        
        final Node confirmation = p.lookupButton(ok);
        confirmation.disableProperty()
                .bind(whiteText.textProperty().isEmpty()
                        .or(blackText.textProperty().isEmpty()));
        
        
 Optional<ButtonType> outcome = d.showAndWait();
 if (outcome.isPresent() && (outcome.get()
 .getButtonData() == ButtonBar.ButtonData.OK_DONE)) {
 return new Players(whiteText.getText(),
 blackText.getText());
 
    }
    return null;
}
    /**
     * Initializes the MainController
     * @param aThis 
     */
    void setMain(MainController aThis) {
        mainController=aThis;
    }
    /**
     * Sets the time limits
     */
    public void setTimes(){
        TimeModel timeModel=new TimeModel(strings);
        
        time.setItems(timeModel.getItems());
        time.setValue(strings.getString("dialogUnlimited"));
    }
    /**
     * Returns the chosen time limit
     * @return 
     */
    String getTime() {
        return time.getValue();
    }
    /**
     * Sets the language
     * @param s language package
     */
    public void setLanguage(ResourceBundle s){
        strings=s;
    }
    
}
