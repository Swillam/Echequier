public class Echiquier 
{
    private Piece[][] casePieces = new Piece[8][8];
    private Piece pieceJouer;
    private Piece pieceManger;


    public Echiquier()
    {
        int ligne = 0;
        int colonne = 0;
        String couleur = "Blanc";
        for (int i = 0; i < 2; i++) 
        {
            //tour, cavalier, fou, roi, reine, fou, cavalier, tour
            casePieces[ligne][colonne] = new Tour(ligne, colonne, couleur, this);
            casePieces[ligne+2][colonne] = new Fou(ligne+2, colonne, couleur, this);
            casePieces[ligne+3][colonne] = new Roi(ligne+3, colonne, couleur, this);
            casePieces[ligne+4][colonne] = new Reine(ligne+4, colonne, couleur, this);
            casePieces[ligne+5][colonne] = new Fou(ligne+5, colonne, couleur, this);
            casePieces[ligne+6][colonne] = new Cavalier(ligne+6, colonne, couleur, this);
            casePieces[ligne+7][colonne] = new Tour(ligne+7, colonne, couleur, this);
            colonne++;
            if (i == 1) colonne--; // pour les noir
            //rangée de pion
            for (int i1 = 0; i < 7; i++) 
            {
                casePieces[i1][colonne] = new Pion(i, colonne, couleur, this);
            }
            couleur = "Noir";
            colonne = 7;
            }

    }

    public void manger(Piece pJouer,Piece pManger) 
    {
        pieceJouer = pJouer;
        pieceManger = pManger;
    }
    
    public void siPromotionPion() 
    {
        int ligne = 0;
        while (ligne<8)
        {
            int colonne = 0;
            while (colonne<8) 
            {
                Piece p = getCase(ligne, colonne);
                if(p instanceof Pion)
                {
                    Pion pion = (Pion)p;
                    if( pion.getPromotion())
                    {
                        // choix pour la promotion
                    }
                }
                colonne++;
            }  
            ligne++;
        }
    }

    public Piece getCase(int ligne, int colonne) {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.casePieces[ligne][colonne];
    }

    public void setPosition(Piece p, int ligne, int colonne) 
    {
        if(siPiecePresente(ligne, colonne)) manger(p, this.casePieces[ligne][colonne]);
        this.casePieces[ligne][colonne] = p;
    }

    public boolean siPiecePresente(int ligne, int colonne) 
    {
        return this.casePieces[ligne][colonne] != null ;
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
