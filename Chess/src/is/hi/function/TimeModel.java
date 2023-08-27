/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.hi.function;

import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class creates the available time limits in the combo box 
 * in the ChessDialog
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */
public class TimeModel {
    private ObservableList<String> times;
    /**
     * Initializes the available time limits in the choice box 
     */
    public TimeModel(ResourceBundle strings){
        LinkedHashSet<String> time = new LinkedHashSet();
        time.add(strings.getString("dialogUnlimited"));
        
        time.add("1");
        
        time.add("5");
        time.add("10");
        time.add("15");
        time.add("20");
        time.add("30");
       
        times = FXCollections.observableArrayList(); 
        for (String l:time)
            times.add(l.toString());
}
    /**
     * returns the available times
     * @return 
     */
    public ObservableList<String> getItems() {
       return times;
    }
}
