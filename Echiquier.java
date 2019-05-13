public class Echiquier 
{
    private Piece[][] casePieces = new Piece[8][8];
    private Piece pieceJouer;
    private Piece pieceManger;


    public Echiquier()
    {
        int x = 0;
        int y = 0;
        String couleur = "Blanc";
        for (int i = 0; i < 2; i++) 
        {
            //tour, cavalier, fou, roi, reine, fou, cavalier, tour
            casePieces[x][y] = new Tour(x, y, couleur, this);
            casePieces[x+2][y] = new Fou(x+2, y, couleur, this);
            casePieces[x+3][y] = new Roi(x+3, y, couleur, this);
            casePieces[x+4][y] = new Reine(x+4, y, couleur, this);
            casePieces[x+5][y] = new Fou(x+5, y, couleur, this);
            casePieces[x+6][y] = new Cavalier(x+6, y, couleur, this);
            casePieces[x+7][y] = new Tour(x+7, y, couleur, this);
            y++;
            if (i == 1) y--; // pour les noir
            //rangée de pion
            for (int i1 = 0; i < 7; i++) 
            {
                casePieces[i1][y] = new Pion(i, y, couleur, this);
            }
            couleur = "Noir";
            y = 7;
            }

    }

    public void manger(Piece pJouer,Piece pManger) 
    {
        pieceJouer = pJouer;
        pieceManger = pManger;
    }
    
    public void siPromotionPion() 
    {
        int x = 0;
        while (x<8)
        {
            int y = 0;
            while (y<8) 
            {
                Piece p = getCase(x, y);
                if(p instanceof Pion)
                {
                    Pion pion = (Pion)p;
                    if( pion.getPromotion())
                    {
                        // choix pour la promotion
                    }
                }
                y++;
            }  
            x++;
        }
    }

    public Piece getCase(int x, int y) {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.casePieces[x][y];
    }

    public void setCase(Piece p, int x, int y) 
    {
        if(siPiecePresente(x, y)) manger(p, this.casePieces[x][y]);
        this.casePieces[x][y] = p;
    }

    public boolean siPiecePresente(int x, int y) 
    {
        return this.casePieces[x][y] != null ;
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
