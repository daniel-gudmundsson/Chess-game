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
 * This class creates the rook
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */

public class Rook extends Piece {

    private final int color;
    private boolean yourTurn;
    
    public Rook(ChessTable c, int i, double x, double y) {
        super(c, i, x, y);
        color=i;
        if(i==2)
        {
        piece=new Image(getClass().getResourceAsStream("Images/blackRook.png"));
        }
        else
        {
            piece=new Image(getClass().getResourceAsStream("Images/whiteRook.png"));
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
        pieceView.setX(event.getX());
        pieceView.setY(event.getY());
    }

    @Override
    public String getType() {
        if(color==1) return "whiteRook";
        else return "blackRook";
    }

    @Override
    public boolean moveSet(Tile[][] tiles,int i, int j) {
        if(tileY==j || tileX==i)
        {
            if(isWayClear(tiles,i,j))
            {
                return true;
            }
            
        }
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

    @Override
    public boolean isWayClear(Tile[][] tiles, int i, int j) {
        int x=tileX;
        int y=tileY;
        if(i>tileX) //Down the table
        {
            x++;
            while(x<i)
            {
                if(tiles[x][y].getAvailable()!=0)
                {
                    System.out.println("Way is not clear");
                    return false;
                }
                x++;
            }
        }
        else if(i<tileX) //Up the table
        {
            x--;
            while(x>i)
            {
                if(tiles[x][y].getAvailable()!=0)
                {
                    System.out.println("Way is not clear");
                    return false;
                }
                x--;
            }
        }
        else if(j>tileY) //To the right
        {
            y++;
            while(y<j)
            {
                if(tiles[x][y].getAvailable()!=0)
                {
                    System.out.println("Way is not clear");
                    return false;
                }
                y++;
            }
        }
        else if(j<tileY) //To the left
        {
            y--;
            while(y>j)
            {
                if(tiles[x][y].getAvailable()!=0)
                {
                    System.out.println("Way is not clear");
                    return false;
                }
                y--;
            }
        }
        return true;
    }

}
