package programs;
public class Main {
    public static void main(String[] args) {
        ChessPiece piece = new ChessPiece("black", "A1");
        Knight knight = new Knight("white", "B1");
        Bishop bishop = new Bishop("white", "C1");

        piece.move();
        knight.move();
        bishop.move();
    }
}
