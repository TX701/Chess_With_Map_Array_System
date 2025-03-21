import java.util.HashMap;
import java.util.Map;

/*
 * this system uses a map and a 2D array
 * the map holds all possible tiles and maps those tiles to pieces (these pieces can be null)
 * each element in the 2D array is mapped to a key (tile) in the map 
 * this means we can use the 2D array for moving pieces around, and to move pieces we only need to swap values on the map
 * this system may be a bit overencumbered but the map could be useful
 * for example, to check if a location has something on it you just need to check the key with that location and see if its value is null
 */

public class Board {
    String[][] board = new String[8][8];
    Piece piece_manager = new Piece();

    Map<String, Piece> tileMap = new HashMap<String, Piece>(); // stores all possible tiles and maps those tiles to pieces
    
    private String intToString(int val) {
        return String.valueOf((char) (val + 64));
    }

    public Board() {
        piece_manager.createPieces();

        int col = 1;
        int row = 1;

        while (row < 9) {
            tileMap.put((intToString(col) + row).toString(), null);

            if (col == 8) {
                row++;
                col = 0;
            }

            col++;
        }

        for (int i = 0; i < piece_manager.pieces.length; i++) {
            tileMap.put((piece_manager.pieces[i].col + piece_manager.pieces[i].row).toString(),
                    piece_manager.pieces[i]);
        }

        setMapToBoard();
        printBoard();
    }

    private void setMapToBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = intToString(j + 1) + "" + (8 - i); // each 'tile' on the board is set to a location on the map
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < board[i].length; j++) {
                if (tileMap.get(board[i][j]) == null) {
                    System.out.print("   ");
                } else {
                    System.out.print(tileMap.get(board[i][j]).name + " ");
                }

            }
            System.out.println();
        }
        System.out.println("  A  B  C  D  E  F  G  H\n\n");
    }

    // i wanted start to be a piece but i want this method to be accessible without easy access to the map (ie calling from the main class) 
    public String movePiece(String start, String end) {
        Piece piece = tileMap.get(start);

        if (piece == null) {
            return "Invalid move starting position is empty";
        }

        Boolean isOpponent = (tileMap.get(end) == null) ? false : tileMap.get(start).side != tileMap.get(end).side; 

        if (tileMap.get(end) == null || isOpponent) {
            tileMap.put(piece.col + piece.row, null); // the previous location of the piece is now null
            tileMap.put(end, piece); // move piece to the new location

            piece.setCol(end.substring(0, 1)); // updates pieces location
            piece.setRow(Integer.parseInt(end.substring(1))); // updates pieces location
        }

        printBoard(); // show the new board

        return start + "->" + end;
    }

}
