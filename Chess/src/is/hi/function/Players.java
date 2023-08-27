/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.hi.function;

/**
 * This class creates the players
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */
public class Players {
    
    private String white; //Name of the white player
    private String black; //Name of the black player
    
    /**
     * Initializes the players
     * @param w Name of the white player
     * @param b Name of the black player
     */
    public Players(String w, String b) {
        white=w;
        black=b;
    }
    
    /**
     * returns the name of the white player
     * @return white
     */
    public String getWhite() {
        return white;
    }
    /**
     * returns the name of the black player
     * @return black
     */
    public String getBlack() {
        return black;
    }
    /**
     * Sets the name of the white player
     * @param white 
     */
    public void setWhite(String white) {
        this.white = white;
    }
    /**
     * Sets the name of the black player
     * @param black 
     */
    public void setBlack(String black) {
        this.black = black;
    }

}
