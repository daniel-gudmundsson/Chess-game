
package is.hi.view;

import is.hi.view.ChessPieces.Piece;

/**
 * Class that oversees the position and size of a tile
 * 
 * @author Daníel Þór Guðmundsson dthg7@hi.is
 * Chess
 * Viðmótsforritun HBV201G 2018
 * Professor Ebba Þóra Hvannberg
 * Háskóli Íslands
 * 
 */
public class Tile {

    private final int xPos; //X position of the tile
    private final int yPos; //Y position of the tile
    private final int width; //Width
    private final int height; //Height
    private int available; //0 if available, 1 if there is a white piece, 2 if
    //there is a black piece
    private Piece piece;
    
    private final int centerX; //Center of the tile
    private final int centerY; //Center of the tile
    

    /**
     * Builder creates a tile with position x and y and width and height
     *
     * @param x
     * @param y
     * @param w width
     * @param h height
     * @param cx centerX
     * @param cy centerY
     */
    public Tile(int x, int y, int w, int h, int cx, int cy) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        available=0;
        piece=null;
        centerX=cx;
        centerY=cy;
    }

    /**
     * Checks if coordinates(x,y) are inside the tile
     * 
     *
     * @param x x-position that is checked
     * @param y y-position that is checked
     * @return true if inside the tile, else false
     */
    public boolean isInside(double x, double y) {
        //System.out.println(x+" "+y);
        return (x >= xPos && x <= (xPos + width)
                && y >= yPos && y <= (yPos + height));
    }

    /**
     * 
     * @return 0 if available, 1 if white, 2 if black
     */
    public int getAvailable() {
        return available;
    }

    /**
     * Sets what is on the tile
     * @param color 
     */
    public void setAvailable(int color) {
        available=color;
    }

    /**
     * Sets the piece the tile contains
     * @param i 
     */
    public void setPiece(Piece i) {
        piece=i;
    }

    /**
     * 
     * @return the piece that is on the tile
     */
    public Piece getPiece() {
        return piece;
    }
    /**
     * 
     * @return The x coordinates of the center of the tile
     */
    public int getCenterX(){
        return centerX;
    }
  
    /**
     * 
     * @return The y coordinates of the center of the tile 
     */
     public int getCenterY(){
        return centerY;
    }
}
