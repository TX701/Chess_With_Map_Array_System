class Piece {
    String type;
    String name;
    int side; // 0 for white (bottom) 1 black (top)
    String col;
    int row;

    Piece[] pieces = new Piece[32];

    public Piece() {}

    public Piece(String type, String name, int side, String col, int row) {
        this.type = type;
        this.name = name; // i wanted this to be the symbols but they dont print to my editors terminal- sorry
        this.side = side;
        this.col = col;
        this.row = row;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void createPieces() {
        pieces[0] = new Piece("Rook", "Ro", 1, "A", 8);
        pieces[1] = new Piece("Knight", "Kn", 1, "B", 8);
        pieces[2] = new Piece("Bishop", "Bi", 1, "C", 8);
        pieces[3] = new Piece("Queen", "Qu", 1, "D", 8);
        pieces[4] = new Piece("King", "Ki", 1, "E", 8);
        pieces[5] = new Piece("Bishop", "Bi", 1, "F", 8);
        pieces[6] = new Piece("Knight", "Kn", 1, "G", 8);
        pieces[7] = new Piece("Rook", "Ro", 1, "H", 8);

        for (int i = 8; i < 16; i++) {
            pieces[i] = new Piece("Pawn", "Pa", 1, String.valueOf((char)((i - 8) + 65)), 7);
            pieces[i + 8] = new Piece("Pawn", "Pa", 0, String.valueOf((char) ((i - 8) + 65)), 2);
        }

        pieces[24] = new Piece("Rook", "Ro", 0, "A", 1);
        pieces[25] = new Piece("Knight", "Kn", 0, "B", 1);
        pieces[26] = new Piece("Bishop", "Bi", 0, "C", 1);
        pieces[27] = new Piece("Queen", "Qu", 0, "D", 1);
        pieces[28] = new Piece("King", "Ki", 0, "E", 1);
        pieces[29] = new Piece("Bishop","Bi", 0, "F", 1);
        pieces[30] = new Piece("Knight", "Kn", 0,"G", 1);
        pieces[31] = new Piece("Rook", "Ro", 0, "H", 1);
    }

    public Piece getPiece(String col, int row) {
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i].col == col && pieces[i].row == row) {
                return pieces[i];
            }
        }

        return null;
    }

    public void moveManager(Piece piece, Board board) {
        switch (piece.type) {
            case "Rook":
                break;
            case "knight":
                break;
            case "Bishop":
                break;
            case "Queen":
                break;
            case "King":
                break;
            case "Pawn":
                break;
            default:
                break;
        }
    }
}