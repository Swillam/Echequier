public class Echiquier 
{
    private Piece[][] Case = new Piece[8][8];
    private Piece pieceJouer;
    private Piece pieceManger;


    public Echiquier()
    {

    }

    public void manger(Piece pJouer,Piece pManger) 
    {
        pieceJouer = pJouer;
        pieceManger = pManger;
    }

    public Piece getCase(int x, int y) {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Case[x][y];
    }

    public void setCase(Piece p, int x, int y) 
    {
        if(siPiecePresente(x, y)) manger(p, this.Case[x][y]);
        this.Case[x][y] = p;
    }

    public boolean siPiecePresente(int x, int y) 
    {
        return this.Case[x][y] != null ;
    }

    /**
     * @return the pieceJouer
     */
    public Piece getPieceJouer() {
        return pieceJouer;
    }

    /**
     * @return the pieceManger
     */
    public Piece getPieceManger() {
        return pieceManger;
    }

}