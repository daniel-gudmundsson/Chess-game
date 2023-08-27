/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.view;

import is.hi.function.Chess;
import is.hi.view.ChessPieces.Bishup;
import is.hi.view.ChessPieces.King;
import is.hi.view.ChessPieces.Knight;
import is.hi.view.ChessPieces.Pawn;
import is.hi.view.ChessPieces.Piece;
import is.hi.view.ChessPieces.Queen;
import is.hi.view.ChessPieces.Rook;
import java.util.ResourceBundle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * This class is the chess table itself. Most of the games function takes place
 * here
 *
 * @author Daníel Þór Guðmundsson - dthg7@hi.is
 * @date Háskóli Íslands
 */
public class ChessTable extends Pane {

    private MainController mainController; //Connection to the MainController
    private Chess chess; //The chess game
    private Tile[][] tiles = new Tile[8][8]; //The tiles on the chessboard

    private String[] piecesImages = {"blackBishup", "blackKing", "blackKnight", "blackPawn",
        "blackQueen", "blackRook", "whiteBishup", "whiteKing", "whiteKnight", "whitePawn",
        "whiteQueen", "whiteRook"}; //Images of the pieces
    
    private ResourceBundle strings; //Language package

    /**
     * Initializes a new chess table
     */
    public ChessTable() {
    }

    /**
     * Connection to MainController
     *
     * @param mainController
     */
    void setMain(MainController main) {
        mainController = main;
    }

    /**
     * Initializes the chess game
     *
     * @param c
     */
    public void setChess(Chess c) {
        chess = c;
    }

    /**
     * Draws the chess table on the screen
     *
     * @param g
     */
    public void drawTable(GraphicsContext g) {
        g.setStroke(Color.BLACK);
        g.strokeRect(50, 50, 600, 600);
        int c = 8;
        for (int i = 0; i < 8; i++) {
            if (c % 2 == 0) {
                for (int j = 1; j < 8; j += 2) {
                    g.setFill(Color.SADDLEBROWN);
                    g.fillRect(50 + 75 * j, 50 + 75 * i, 75, 75);
                }
                for (int j = 0; j < 8; j += 2) {
                    g.setFill(Color.KHAKI);
                    g.fillRect(50 + 75 * j, 50 + 75 * i, 75, 75);
                }
            } else {
                for (int j = 0; j < 8; j += 2) {
                    g.setFill(Color.SADDLEBROWN);
                    g.fillRect(50 + 75 * j, 50 + 75 * i, 75, 75);
                }
                for (int j = 1; j < 8; j += 2) {
                    g.setFill(Color.KHAKI);
                    g.fillRect(50 + 75 * j, 50 + 75 * i, 75, 75);
                }
            }
            c--;
        }
        makeTiles();
        drawPieces();
    }

    /**
     * Draws the chess pieces on the table
     */
    public void drawPieces() {
        //Black bishups
        Piece bishup;
        bishup = new Bishup(this, 2, 208, 60);
        this.getChildren().add(bishup.getPieceView());
        tiles[0][2].setPiece(bishup);
        bishup.setTileX(0);
        bishup.setTileY(2);

        bishup = new Bishup(this, 2, 425, 60);
        this.getChildren().add(bishup.getPieceView());
        tiles[0][5].setPiece(bishup);
        bishup.setTileX(0);
        bishup.setTileY(5);
        //Black king
        Piece king;
        king = new King(this, 2, 350, 60);
        this.getChildren().add(king.getPieceView());
        tiles[0][4].setPiece(king);
        king.setTileX(0);
        king.setTileY(4);
        //Black Knights
        Piece knight;
        knight = new Knight(this, 2, 125, 60);
        this.getChildren().add(knight.getPieceView());
        tiles[0][1].setPiece(knight);
        knight.setTileX(0);
        knight.setTileY(1);

        knight = new Knight(this, 2, 500, 60);
        this.getChildren().add(knight.getPieceView());
        tiles[0][6].setPiece(knight);
        knight.setTileX(0);
        knight.setTileY(6);
        //Black Queen
        Piece queen;
        queen = new Queen(this, 2, 275, 60);
        this.getChildren().add(queen.getPieceView());
        tiles[0][3].setPiece(queen);
        queen.setTileX(0);
        queen.setTileY(3);
        //Black rooks
        Piece rook;
        rook = new Rook(this, 2, 54, 60);
        this.getChildren().add(rook.getPieceView());
        tiles[0][0].setPiece(rook);
        rook.setTileX(0);
        rook.setTileY(0);

        rook = new Rook(this, 2, 575, 60);
        this.getChildren().add(rook.getPieceView());
        tiles[0][7].setPiece(rook);
        rook.setTileX(0);
        rook.setTileY(7);
        //Black pawns
        Piece pawn;
        for (int i = 0; i < 8; i++) {
            pawn = new Pawn(this, 2, 50 + i * 75, 135);
            this.getChildren().add(pawn.getPieceView());
            tiles[1][i].setPiece(pawn);
            pawn.setTileX(1);
            pawn.setTileY(i);
        }

        //White bishups
        bishup = new Bishup(this, 1, 208, 575);
        this.getChildren().add(bishup.getPieceView());
        tiles[7][2].setPiece(bishup);
        bishup.setTileX(7);
        bishup.setTileY(2);

        bishup = new Bishup(this, 1, 425, 575);
        this.getChildren().add(bishup.getPieceView());
        tiles[7][5].setPiece(bishup);
        bishup.setTileX(7);
        bishup.setTileY(5);
        //White king
        king = new King(this, 1, 350, 575);
        this.getChildren().add(king.getPieceView());
        tiles[7][4].setPiece(king);
        king.setTileX(7);
        king.setTileY(4);
        //White knights
        knight = new Knight(this, 1, 125, 575);
        this.getChildren().add(knight.getPieceView());
        tiles[7][1].setPiece(knight);
        knight.setTileX(7);
        knight.setTileY(1);

        knight = new Knight(this, 1, 500, 575);
        this.getChildren().add(knight.getPieceView());
        tiles[7][6].setPiece(knight);
        knight.setTileX(7);
        knight.setTileY(6);
        //White Queen
        queen = new Queen(this, 1, 275, 575);
        this.getChildren().add(queen.getPieceView());
        tiles[7][3].setPiece(queen);
        queen.setTileX(7);
        queen.setTileY(3);
        //White rooks
        rook = new Rook(this, 1, 50, 575);
        this.getChildren().add(rook.getPieceView());
        tiles[7][0].setPiece(rook);
        rook.setTileX(7);
        rook.setTileY(0);

        rook = new Rook(this, 1, 575, 575);
        this.getChildren().add(rook.getPieceView());
        tiles[7][7].setPiece(rook);
        rook.setTileX(7);
        rook.setTileY(7);
        //White pawns
        for (int i = 0; i < 8; i++) {
            pawn = new Pawn(this, 1, 50 + i * 75, 500);
            this.getChildren().add(pawn.getPieceView());
            tiles[6][i].setPiece(pawn);
            pawn.setTileX(6);
            pawn.setTileY(i);
        }
    }

    /**
     * Creates the tiles on the chess table
     */
    private void makeTiles() {
        //Create the tiles, for now they are all available
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = new Tile(50 + j * 75, 50 + i * 75, 75, 75, 53 + j*75, 60+i*75);
            }
        }
        //Now the right tiles are made unavailable
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 2; i++) {
                tiles[i][j].setAvailable(2);
            }
            for (int i = 6; i < 8; i++) {
                tiles[i][j].setAvailable(1);
            }
        }
    }

    /**
     * Sets a piece on the table when moved This method is long because there
     * are a lot if things that have to be right so the move can be legal
     *
     * @param piece
     * @param color
     * @param x
     * @param y
     */
    public void setOnTable(Piece piece, int color, double x, double y) {
        //If the piece is outside the table
        if (x < 50 || x > 650 || y < 50 || y > 650) { 
            mainController.displayErrorMessage(strings.getString("outsideTable"));
            putPieceBack(piece);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //If the piece is inside the tile
                if (tiles[i][j].isInside(x, y)) {
                    //If it was the player's turn
                    if (piece.yourTurn()) {
                        //If the move does not break the piece's moveset
                        if (piece.moveSet(tiles, i, j)) {
                            //Is the tile empty
                            if (tiles[i][j].getAvailable() == 0) //empty
                            {    
                                System.out.println(strings.getString("legalMove"));
                                tiles[i][j].setPiece(piece);
                                tiles[i][j].setAvailable(piece.getColor());
                                tiles[piece.getTileX()][piece.getTileY()].setAvailable(0);
                               
                                setPieceOnTile(piece, i, j);
                                mainController.nextRound();
                            } 
                            //Piece of same color on spot
                            else if (tiles[i][j].getPiece().getColor() == piece.getColor()) {
                                
                                mainController.displayErrorMessage(strings.getString("occupied"));

                                putPieceBack(piece);
                            } 
                            //Kill another piece
                            else {
                               
                                System.out.println(strings.getString("legalMove"));
                                Piece p = tiles[i][j].getPiece();
                                if (p.getType().equals("whiteKing")) {
                                    mainController.gameOver(2);
                                }
                                if (p.getType().equals("blackKing")) {
                                    mainController.gameOver(1);
                                }

                                this.getChildren().remove(tiles[i][j].getPiece().getPieceView());
                                tiles[i][j].setPiece(piece);
                                tiles[piece.getTileX()][piece.getTileY()].setAvailable(0);
                                setPieceOnTile(piece, i, j);
                                
                                mainController.nextRound();
                            }
                        }
                        //The move turned out to be illegal
                        else {
                           
                            System.out.println(strings.getString("illegalMove"));
                            putPieceBack(piece);
                        }
                    } else {
                       
                       mainController.displayErrorMessage(strings.getString("notYourTurn"));
                    }
                }

            }
        }
    }
    /**
     * Puts piece on tile nr. i,j
     * @param piece
     * @param i
     * @param j 
     */
    public void setPieceOnTile(Piece piece, int i, int j){
        piece.setTileX(i);
        piece.setTileY(j);
        piece.setOldX(piece.getPieceView().getX());
        piece.setOldY(piece.getPieceView().getY());
        
        piece.getPieceView().setX(tiles[i][j].getCenterX());
        piece.getPieceView().setY(tiles[i][j].getCenterY());
        
    }
    /**
     * Puts piece back on the spot it was previously on
     * @param piece 
     */
    public void putPieceBack(Piece piece){
        piece.getPieceView().setX(piece.getOldX());
        piece.getPieceView().setY(piece.getOldY());
    }
    /**
     * After a move has been made this method updates the tiles with the new
     * information
     * @param piece
     * @param tiles
     * @param i
     * @param j 
     */
    public void updateTiles(Piece piece, Tile[][] tiles, int i, int j) {
        int tileX = piece.getTileX();
        int tileY = piece.getTileY();
        tiles[tileX][tileY].setAvailable(0);
        piece.setTileX(i);
        piece.setTileY(j);
    }

    /**
     * Returns the array of tiles
     * @return 
     */
    public Tile[][] getTiles() {
        return tiles;
    }
    /**
     * Clears the table
     */
    void clearTable() {
        while (this.getChildren().size() > 1) {
            this.getChildren().remove(1);
        }
    }
    /**
     * Sets the language
     * @param s language package
     */
    public void setLanguage(ResourceBundle s) {
        strings = s;
    }

}
