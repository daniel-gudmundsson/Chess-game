/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.hi.view.ChessPieces;

import is.hi.view.ChessTable;
import is.hi.view.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * This is an abstract class. All chess pieces inherit from this class
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */
public abstract class Piece {

    public static void disableMouse(int p) {
        
    }
    protected Image piece; //Image of the piece
    protected ImageView pieceView; //ImageView of the piece
    protected ChessTable chessTable; //The chess table
    protected int color; //1=white, 2=black
    protected double xPos; //Current X position on the canvas
    protected double yPos; //Current Y position on the canvas
    protected double oldXPos; //Old X position on the canvas
    protected double oldYPos; //Old Y position on the canvas
    //The piece is on tile nr tileX, tileY
    protected int tileX; 
    protected int tileY;
    private boolean yourTurn=false; //Determines if the peace is allowed to be
    //moved
    
    /**
     * Builder for a Piece
     * @param c
     * @param i
     * @param x
     * @param y 
     */
    public Piece(ChessTable c, int i, double x, double y) {
        chessTable=c;
        color=i;
    }
    /**
     * 
     * @return the piece Image
     */
    public Image getPiece() {
        return piece;
    }
    /**
     * 
     * @return the piece ImageView
     */
    public ImageView getPieceView() {
        return pieceView;
    }
    /**
     * 
     * @return xPos
     */
    public double getX(){
        return xPos;
    }
    /**
     * 
     * @return yPos
     */
    public double getY() {
        return yPos;
    }
    /**
     * 
     * @return oldXPos
     */
    public double getOldX(){
        return oldXPos;
    }
    /**
     * 
     * @return oldYPos
     */
    public double getOldY(){
        return oldYPos;
    }
    /**
     * Sets the oldX
     * @param x 
     */
    public void setOldX(double x){
        oldXPos=x;
    }
    /**
     * Sets the oldY
     * @param y 
     */
    public void setOldY(double y){
        oldYPos=y;
    }
    /**
     * Sets the tileX
     * @param i 
     */
    public void setTileX(int i){
        tileX=i;
    }
    /**
     * Sets the tileY
     * @param i 
     */
    public void setTileY(int i){
        tileY=i;
    }
    /**
     * 
     * @return tileX
     */
    public int getTileX(){
        return tileX;
    }
    /**
     * 
     * @return tileY
     */
    public int getTileY(){
        return tileY;
    }
    /**
     * Returns the color of the piece
     * @return color
     */
    public int getColor() {
        return color;
    }
    /**
     * Moves the piece
     * @param s
     * @param event 
     */
    protected abstract void movePiece(ImageView s, MouseEvent event);
    /**
     * The moveset of a given piece
     * @param tiles
     * @param i
     * @param j
     * @return 
     */
    public abstract boolean moveSet(Tile[][] tiles,int i, int j);
    /**
     * Checks if the way is clear
     * @param tiles
     * @param i
     * @param j
     * @return 
     */
    public abstract boolean isWayClear(Tile[][] tiles, int i, int j);
    /**
     * 
     * @return what kind of piece it is
     */
    public abstract String getType();
    /**
     * Sets YourTurn to given value
     * @param i 
     */
    public abstract void setYourTurn(boolean i);
    /**
     * 
     * @return yourTurn
     */
    public abstract boolean yourTurn();

    //public abstract void setCenter(int centerX, int centerY);
  
    

}

