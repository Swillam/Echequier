public class Tour extends Piece {

    private static final long serialVersionUID = -3105408735921975403L;

    public Tour(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        if(couleur.equals("Blanc")) forme = "\u2656";
        else forme = "\u265C";
    }

    
    public boolean verificationCoup(int ligne, int colonne) 
    {
        boolean etat = false;
        if(ligne == this.ligne && verifHorsMap(ligne, colonne)) 
        {
            int tour = Math.abs(this.colonne - colonne);
            etat = this.enLigne(ligne,colonne,tour); 
        }
        if(colonne == this.colonne && verifHorsMap(ligne, colonne))  
        {
            int tour = Math.abs(this.ligne - ligne);
            etat = this.enLigne(ligne,colonne,tour); 
        }
        return etat;
    }

    public boolean detectionRoi(String couleur) 
    {
        boolean pieceNonTrouve = true;;
        int iLigne = this.ligne+1;
        int iColonne = this.colonne+1;

        // Nord
        pieceNonTrouve = true;
       while (pieceNonTrouve && iLigne<8) 
       {
            if(echiquierCourant.getCase(iLigne, this.colonne) != null)
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, iColonne);
                if(p.siRoi()) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
            iLigne++;
       }

       // Est
        pieceNonTrouve = true;
        while (pieceNonTrouve && iColonne<8) 
        {
            if(echiquierCourant.getCase(this.ligne, iColonne) != null)
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(this.ligne, iColonne);
                if(p.siRoi()) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
                iColonne++;
        }

        iLigne = this.ligne-1;
        iColonne = this.colonne-1;
        pieceNonTrouve = true;

       // Sud
       while (pieceNonTrouve && iLigne>=0) 
       {
            if(echiquierCourant.getCase(iLigne, this.colonne) != null)
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, iColonne);
                if(p.siRoi())                               
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
            iLigne--;
       }

       // Ouest
       pieceNonTrouve = true;
       while (pieceNonTrouve && iColonne>=0) 
       {
           if(echiquierCourant.getCase(this.ligne, iColonne) != null)
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(this.ligne, iColonne);
                if(p.siRoi())
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
            iColonne--;
       }
        return false;
       
    }

}
