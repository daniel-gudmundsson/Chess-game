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
 * This class creates the pawn
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */

public class Pawn extends Piece {

    private final int color;
    private boolean firstMove; //True if the pawn hasn't made a move
     private boolean yourTurn=false;
    
    public Pawn(ChessTable c, int i, double x, double y) {
        super(c, i, x, y);
        color=i;
        if(i==2)
        {
        piece=new Image(getClass().getResourceAsStream("Images/blackPawn.png"));
        }
        else
        {
            piece=new Image(getClass().getResourceAsStream("Images/whitePawn.png"));
            yourTurn=true;
        }
        xPos=x;
        yPos=y;
        oldXPos=x;
        oldYPos=y;
        pieceView=new ImageView(piece);
        pieceView.setX(x);
        pieceView.setY(y);
        pieceView.setFitHeight(65);
        pieceView.setFitWidth(65);
        
        firstMove=true;
        
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
        if(color==1) return "whitePawn";
        else return "blackPawn";
    }

    @Override
    public boolean moveSet(Tile[][] tiles,int i, int j) {
        String type=this.getType();
        if(type.equals("blackPawn"))
        {
            //The pawn is going for a kill
            if(tileX==i-1 && (tileY==j-1 || tileY==j+1))
            {
                boolean kill=this.isGoingForTheKill(tiles,i,j);
                if(kill) firstMove=false;
                return kill;
            }
            
            //If the pawn hasn't made a move yet it can 1 or 2 tiles forward
            if(firstMove)
            {
                if(tileX==i-2 && (tileY==j) && tiles[i][j].getAvailable()==0 && tiles[i-1][j].getAvailable()==0)
                {
                    firstMove=false;
                    return true;
                }
                else if(tileX==i-1 && (tileY==j)  && tiles[i][j].getAvailable()==0)
                {
                    firstMove=false;
                    return true;
                }
              
                else return false;
            }
            //Normal movement, that is one tile forward
            if((tileX==i-1) && (tileY==j) && tiles[i][j].getAvailable()==0){firstMove=false; return true;}
            else return false;
        }
        else
        {
            if(tileX==i+1 && (tileY==j-1 || tileY==j+1))
            {
                boolean kill=this.isGoingForTheKill(tiles,i,j);
                if(kill) firstMove=false;
                return kill;
            }
            if(firstMove)
            {
                if(tileX==i+2 && (tileY==j)  && tiles[i][j].getAvailable()==0 && tiles[i+1][j].getAvailable()==0)
                {
                    firstMove=false;
                    return true;
                }
                else if(tileX==i+1 && (tileY==j) && tiles[i][j].getAvailable()==0)
                {
                    firstMove=false;
                    return true;
                }
                else return false;
            }
            if(tileX==i+1 && (tileY==j) && tiles[i][j].getAvailable()==0) {firstMove=false; return true;}
            else return false;
        }
    }
    /**
     * 
     * @return true if the pawn hasn't made a move yet, false otherwise
     */
    public boolean isFirstMove(){
        return firstMove;
    }

    /**
     * The pawn can go one tile diagonal if it is going for a kill
     * This method checks if it is trying to kill another piece
     * @param tiles
     * @param i
     * @param j
     * @return 
     */
    private boolean isGoingForTheKill(Tile [][] tiles,int i, int j) {
        if(tiles[i][j].getAvailable()==0) return false;
        else return true;  
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
     * In this case this method is not used. This problem is solved in lines
     * 119-132
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
