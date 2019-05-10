public class Echequier {
    private Piece[][] Case = new Piece[8][8];

    public void getPosition() {
    }

    public void manger() {
    }

    public Piece getCase(int x, int y) {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Case[x][y];
    }

    public void setCase(Piece p, int x, int y) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Case[x][y] = p;
    }

    public boolean siPiecePresente(int x, int y) 
    {
        return true;
    }

}