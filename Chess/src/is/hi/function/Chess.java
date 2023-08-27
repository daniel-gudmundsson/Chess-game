/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.hi.function;

import is.hi.view.ChessPieces.Piece;
import is.hi.view.ChessTable;
import is.hi.view.MainController;
import is.hi.view.Tile;

/**
 * This class oversees which player is active
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */
public class Chess {
    
    private int player; //1 for white, 2 for black
    private MainController mainController;
    private ChessTable chessTable; //The chesstable itself
    
    public Chess(){
        
    }
    /**
     * Initializes the MainController
     * @param aThis 
     */
    public void setMain(MainController aThis) {
        mainController=aThis;
    }
    /**
     * Sets the current player
     * @param p 
     */
    public void setCurrentPlayer(int p){
        player=p;
        if(p==1)
        {
            disableBlack();
        }
        else
        {
            disableWhite();
        }
       
    }
    /**
     * 
     * @return the current player
     */
    public int getCurrentPlayer(){
        return player;
    }

    /**
     * Disables all the black pieces
     */
    public void disableBlack() {
        Tile [][] tiles=chessTable.getTiles();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                Piece piece=tiles[i][j].getPiece();
                if(piece!=null)
                {
                String type=piece.getType();
                String isBlack=type.substring(0,5);
                if(isBlack.equals("black"))
                {
                    piece.setYourTurn(false);
                }
                }
            }
        }
    }

    /**
     * Disables all the white pieces
     */
    public void disableWhite() {
        Tile [][] tiles=chessTable.getTiles();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                Piece piece=tiles[i][j].getPiece();
                if(piece!=null)
                {
                String type=piece.getType();
                String isWhite=type.substring(0,5);
                if(isWhite.equals("white"))
                {
                    piece.setYourTurn(false);
                }
                }
            }
        }
        
    }

    /**
     * Initializes the chesstable
     * @param c 
     */
    public void setChessTable(ChessTable c) {
        chessTable=c;
    }

    /**
     * Enables all the white pieces
     */
    public void enableWhite() {
        Tile [][] tiles=chessTable.getTiles();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                Piece piece=tiles[i][j].getPiece();
                if(piece!=null)
                {
                String type=piece.getType();
                String isWhite=type.substring(0,5);
                if(isWhite.equals("white"))
                {
                    piece.setYourTurn(true);
                }
                }
            }
        }
    }

    /**
     * Enables all the black pieces
     */
    public void enableBlack() {
        Tile [][] tiles=chessTable.getTiles();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                Piece piece=tiles[i][j].getPiece();
                if(piece!=null)
                {
                String type=piece.getType();
                String isBlack=type.substring(0,5);
                if(isBlack.equals("black"))
                {
                    piece.setYourTurn(true);
                }
                }
            }
        }
    }

}
