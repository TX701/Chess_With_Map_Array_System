class Chess {
    public static void main(String[] args) { 
        Board board_manager = new Board();

        board_manager.movePiece("A7", "B1"); // a piece can be placed on the same tile as an enemy (to take it)
        board_manager.movePiece("B7", "C7"); // a piece cannot be placed on a tile if there is a piece already on that tile and if these two pieces share a color (so this does nothing)
        board_manager.movePiece("A8", "A4"); // normal movement
        board_manager.movePiece("A8", "A7"); // if nothing is on a starting tile nothing will be moved
    }
}