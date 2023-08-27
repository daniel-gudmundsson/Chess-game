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
 * This class creates the king
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */
public class King extends Piece{

    private final int color;
    private boolean yourTurn=false;
    
    public King(ChessTable c, int i,double x, double y) {
        super(c, i,x,y);
        color=i;
        if(i==2)
        { 
        piece=new Image(getClass().getResourceAsStream("Images/blackKing.png"));
        }
        else
        {
            piece=new Image(getClass().getResourceAsStream("Images/whiteKing.png"));
            yourTurn=true;
        }
         pieceView=new ImageView(piece);
        xPos=x;
        yPos=y;
        oldXPos=x;
        oldYPos=y;
        pieceView.setX(x);
        pieceView.setY(y);
        pieceView.setFitHeight(65);
        pieceView.setFitWidth(65);
        
        
        
        
        
        pieceView.setOnMouseDragged((MouseEvent event) -> {
            if(yourTurn)
                {
                     movePiece(pieceView, event);
                }
        });
        pieceView.setOnMouseReleased((MouseEvent event) -> {
            System.out.println("Mouse released");
            chessTable.setOnTable(this,i,event.getX()+37.5,event.getY()+37.5);
        });
    }
    
    

    @Override
    protected void movePiece(ImageView s, MouseEvent event) {
        s.setX(event.getX());
        s.setY(event.getY());
    }

    @Override
    public String getType() {
        if(color==1) return "whiteKing";
        else return "blackKing";
    }

    @Override
    public boolean moveSet(Tile[][] tiles,int i, int j) {
        if(tileX==i+1 || tileX==i-1 || tileY==j+1 || tileY==j-1)
            return true;
        return false;
    }

    

    @Override
    public void setYourTurn(boolean i) {
        yourTurn=i;
    }

    @Override
    public boolean yourTurn() {
        return yourTurn;
    }

    /**
     * In this case this method is not used because the king can only move
     * one tile at a time
     * @param tiles
     * @param i
     * @param j
     * @return 
     */
    @Override
    public boolean isWayClear(Tile[][] tiles, int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
