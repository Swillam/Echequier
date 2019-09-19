import java.io.Serializable;

public class Echiquier implements Serializable
{
    private static final long serialVersionUID = 2221342764427401605L;
    private Piece[][] casePieces;
    private Piece pieceJouer;
    private Piece pieceManger;
    private String couleurAJouer;
    private Roi enEchec = null;

    public Echiquier()
    {
        casePieces = new Piece[8][8];
        int ligne = 7;
        String couleur = "Noir";
        couleurAJouer = "Blanc";
        for (int i = 0; i < 2; i++) 
        {
            //tour, cavalier, fou, roi, reine, fou, cavalier, tour
            casePieces[ligne][0] = new Tour(ligne, 0, couleur, this);
            casePieces[ligne][1] = new Cavalier(ligne, 1, couleur, this);
            casePieces[ligne][2] = new Fou(ligne, 2, couleur, this);
            casePieces[ligne][3] = new Reine(ligne, 3, couleur, this);
            casePieces[ligne][4] = new Roi(ligne, 4, couleur, this);
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
    
    public void promotion(Pion p) 
    {
        String str = Systeme.Pro() ;
        if (str.equals("R")) 
        {
            setCase(new Reine(p.getligne(), p.getcolonne(), p.getCouleur(), this), p.getligne(), p.getcolonne());
        }
        else if (str.equals("C")) 
        {
            setCase(new Cavalier(p.getligne(), p.getcolonne(), p.getCouleur(), this), p.getligne(), p.getcolonne());
        }
        else if (str.equals("T")) {
            setCase(new Tour(p.getligne(), p.getcolonne(), p.getCouleur(), this), p.getligne(), p.getcolonne());
        }
        else if (str.equals("F")) {
            setCase(new Fou(p.getligne(), p.getcolonne(), p.getCouleur(), this), p.getligne(), p.getcolonne());
        }
        else promotion(p);
    }

    public Piece getCase(int ligne, int colonne) {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.casePieces[ligne][colonne];
    }
    public void setCase(Piece p, int ligne ,int colonne) 
    {
        this.casePieces[ligne][colonne] = p;
    }

    public boolean bouger(int ligne, int colonne, int nligne ,int ncolonne) 
    {
        pieceJouer =null;
        pieceManger = null;
        enEchec =null;
        Piece p = getCase(ligne, colonne);
        pieceJouer = p;
        if(siPiecePresente(nligne, ncolonne)) manger(p,this.casePieces[nligne][ncolonne]);
        if(p.bouger(nligne, ncolonne,couleurAJouer))
        {
            setCase(null, ligne, colonne);
            if(echec(0))
            {
                annuleMouv(ligne, colonne);
                setCase(null, nligne, ncolonne);
                System.out.println("Vous ne pouvez pas mettre votre roi en echec");
                System.out.println(affichage());
                return false;
            }
            else 
            {
                couleurAJouer = switchCouleur();
                setCase(null, ligne, colonne);
                if(enEchec != null)   System.out.println("Echec au roi");
                return true;
            }
        }
        
        else return false;
    }

    public boolean siPiecePresente(int ligne, int colonne) 
    {
        if((ligne<8 && ligne>=0) && (colonne<8 && colonne>=0)) return this.casePieces[ligne][colonne] != null ;
        else return false;
    }
    public boolean verifCouleur(int l, int c) 
    {
        if(getCase(l, c).getCouleur().equals(couleurAJouer)) return true;
        else
        {
            System.out.println("La pièce saisie n'est pas de votre couleur \n");
            return false;
        }
    }

    public Piece[][] getEchiquier()
    {
        Piece[][] echiquier = new Piece[8][8];
        for (int ligne = 0; ligne < 8; ligne++) 
        {
            for (int colonne = 0; colonne < 8; colonne++) 
            {
                echiquier[ligne][colonne] = casePieces[ligne][colonne];
            }   
        }
        return echiquier;
    }

    public boolean echec(int i )
    {
        String couleur;
        if (i==0) couleur = couleurAJouer;
        else couleur = switchCouleur() ;
        for (int ligne = 0; ligne < 8; ligne++) 
        {
            for (int colonne = 0; colonne < 8; colonne++) 
            {
                if(siPiecePresente(ligne, colonne))
                {
                    Piece p =casePieces[ligne][colonne];
                    if(!(p.getCouleur().equals(couleur)))
                    {
                        if(p.detectionRoi(couleur)) return true;
                    }
                }   
            }
        }
        return false;
    }

    /*public boolean verifMAT()
    {
        return (verifPAT() && getEnEchec());
    }

    public boolean verifPAT()
    {
        Piece p = null;
        for (int ligne = 0; ligne < 8; ligne++) 
        {
            for (int colonne = 0; colonne < 8; colonne++) 
            {
                if(siPiecePresente(ligne, colonne))
                {
                    p =casePieces[ligne][colonne];
                    if(p.siRoi() & p.getCouleur().equals(couleurAJouer)) break;
                }
            }
        }
        Roi r = (Roi)p;
        return !(r.deplacePos());
    }*/


    public Piece getPieceJouer() {
        return pieceJouer;
    }


    public Piece getPieceManger() {
        return pieceManger;
    }
    public String affichage()
    {
        String lettre = "     A   B   C   D   E   F   G   H   ";
        String ligne = "\n   ---------------------------------\n";
        String echiquier = lettre + ligne;
        for (int x = 7; x > -1; x--) 
        {
            echiquier += " " + (x+1) + " | ";
            for (int y = 0; y < 8; y++) 
            {
                if(siPiecePresente(x, y)) echiquier += casePieces[x][y] + " | ";
                else echiquier += "  | ";
            }
            echiquier+= (x+1) + ligne ;
        }
        echiquier+= lettre+ "\n \n";
        return echiquier;
    }
    public String getCouleur()
    {
        return this.couleurAJouer;
    }
    public void setEnEchec(Roi b)
    {
        this.enEchec = b;
    }

    public void annuleMouv(int ligne, int colonne)
    {
        setCase(pieceJouer, ligne, colonne);
        if(pieceManger!=null)setCase(pieceManger, pieceManger.getligne(), pieceManger.getcolonne());
    }

    public boolean getEnEchec()
    {
        return (this.enEchec!= null);
    }

    public String switchCouleur()
    {
        String couleur;
        if (couleurAJouer.equals("Noir")) couleur = "Blanc";
        else couleur = "Noir";
        return couleur;
    }

    public void setPieceJouer(Piece p)
    {
        this.pieceJouer = p;
    }

}
