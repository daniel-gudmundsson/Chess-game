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
 * This class creates the Bishup
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date
 * Háskóli Íslands
 */
public class Bishup extends Piece{

    private final int color;
    private boolean yourTurn=false;
    public Bishup(ChessTable c, int i,double x, double y) {
        super(c, i,x,y);
        color=i;
        if(i==2)
        {
        piece=new Image(getClass().getResourceAsStream("Images/blackBishup.png"));
        }
        else
        {
            piece=new Image(getClass().getResourceAsStream("Images/whiteBishup.png"));
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
            chessTable.setOnTable(this,i,event.getX()+37.5,event.getY()+37.5);        });
         
    }
    
    @Override
    protected void movePiece(ImageView s, MouseEvent event) {
        s.setX(event.getX());
        s.setY(event.getY());
    }

   

    @Override
    public String getType() {
        if(color==1) return "whiteBishup";
        else return "blackBishup";
    }

    @Override
    public boolean moveSet(Tile[][] tiles,int i, int j) {
        double hx=tileX-i;
        double hy=tileY-j;
        if(hx==-2 && hy==0) return false; //No idea why
        if(hy==0) //So we don't divide by zero
        {
            hx+=1;
            hy+=1;
        }
        if(((hx)/(hy))==1 || ((hx)/(hy))==-1)
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
        double hx=tileX-i;
        double hy=tileY-j;
        int x=tileX;
        int y=tileY;
        if(hx>0 && hy<0) //Up to the right
        {
            x--;
            y++;
            while(x>i && y<j)
            {
                if((tiles[x][y].getAvailable()!=0)) 
                {
                    return false; //The way wasn't clear
                }
                x--;
                y++;
            }
        }
        else if(hx<0 && hy <0) //Down to the right
        {
            x++;
            y++;
             while(x<i && y<j)
            {
                if((tiles[x][y].getAvailable()!=0)) 
                {
                    System.out.println("The way is not clear");
                    return false; //The way wasn't clear
                }
                x++;
                y++;
            }
        }
        else if(hx<0 && hy>0) //Down to the left
        {
            x++;
            y--;
            while(x<i && y>j)
            {
            if((tiles[x][y].getAvailable()!=0)) 
                {
                    System.out.println("The way is not clear");
                    return false; //The way wasn't clear
                }
                x++;
                y--;
            }
        }
        else if(hx>0 && hy>0) //Up to the left
        {
            x--;
            y--;
            while(x>i && y>j)
            {
            if((tiles[x][y].getAvailable()!=0)) 
                {
                    System.out.println("The way is not clear");
                    return false; //The way wasn't clear
                }
                x--;
                y--;
            }
        }
        return true;
    }
    
}
