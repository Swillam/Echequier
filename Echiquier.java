public class Echiquier 
{
    private Piece[][] casePieces = new Piece[8][8];
    private Piece pieceJouer;
    private Piece pieceManger;


    public Echiquier()
    {
        int ligne = 7;
        String couleur = "Noir";
        for (int i = 0; i < 2; i++) 
        {
            //tour, cavalier, fou, roi, reine, fou, cavalier, tour
            casePieces[ligne][0] = new Tour(ligne, 0, couleur, this);
            casePieces[ligne][1] = new Cavalier(ligne, 1, couleur, this);
            casePieces[ligne][2] = new Fou(ligne, 2, couleur, this);
            casePieces[ligne][3] = new Roi(ligne, 3, couleur, this);
            casePieces[ligne][4] = new Reine(ligne, 4, couleur, this);
            casePieces[ligne][5] = new Fou(ligne, 5, couleur, this);
            casePieces[ligne][6] = new Cavalier(ligne, 6, couleur, this);
            casePieces[ligne][7] = new Tour(ligne, 7, couleur, this);
            if (i == 1) ligne++; // pour les blancs
            else ligne--;
            //rangée de pion
            for (int i1 = 0; i1 < 8; i1++) 
            {
                casePieces[ligne][i1] = new Pion(ligne, i1, couleur, this);
            }
            couleur = "Blanc";
            ligne = 0;
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

    public String affichage()
    {
        String ligne = "\n---------------------------------\n";
        String echiquier = ligne;
        for (int x = 0; x < 8; x++) 
        {
            echiquier += "| ";
            for (int y = 0; y < 8; y++) 
            {
                if(siPiecePresente(x, y)) echiquier += casePieces[x][y] + " | ";
                else echiquier += "  | ";
            }
            echiquier+= ligne;
        }
        return echiquier;
    }
}
