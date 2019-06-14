import java.io.Serializable;
import java.util.Scanner;

public class Echiquier implements Serializable
{
    private static final long serialVersionUID = 2221342764427401605L;
    private Piece[][] casePieces;
    private Piece pieceJouer;
    private Piece pieceManger;
    private String couleurAJouer;
    Scanner s = new Scanner(System.in);

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

    public Echiquier(int i)
    {
        casePieces = new Piece[8][8];
        int ligne = 6;
        String couleur = "Blanc";
        couleurAJouer = "Blanc";
        casePieces[ligne][1] = new Pion(ligne, 1, couleur, this);
        casePieces[5][1] = new Reine(5, 1, "Noir", this);

    }
    public void manger(Piece pJouer,Piece pManger) 
    {
        pieceJouer = pJouer;
        pieceManger = pManger;
    }
    
    public void promotion(Pion p) 
    {
        System.out.println(true);
        String str = "";
        while(str.isEmpty())
        {
            System.out.println("Pion à promouvoir, choisir entre R: \"Reine\", C: \"Cavalier\", T: \"Tour\", F: \"Fou\"" );
            str = s.nextLine().toUpperCase();
        }
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
        Piece p = getCase(ligne, colonne);
        //if(siPiecePresente(nligne, ncolonne)) manger(p, this.casePieces[nligne][ncolonne]);
        if(p.bouger(nligne, ncolonne))
        {
            if (couleurAJouer.equals("Noir")) couleurAJouer = "Blanc";
            else couleurAJouer = "Noir";
            setCase(null, ligne, colonne);
            return true;
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

    public boolean echec()
    {
        
        return false;
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

}
