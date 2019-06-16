public class Reine extends Piece 
{

    private static final long serialVersionUID = -3773151073186006108L;

    public Reine(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        if(couleur.equals("Blanc")) forme = "\u2655";
        else forme = "\u265B";
    }

    
    public boolean verificationCoup(int ligne, int colonne) 
    {
        boolean etat = false;
        if(Math.abs(this.ligne - ligne) == Math.abs(this.colonne - colonne) && verifHorsMap(ligne, colonne))
        {
            int tour = Math.abs(this.ligne - ligne);
            etat = this.diagonal(ligne, colonne, tour);
        }
        if(ligne == this.ligne && verifHorsMap(ligne, colonne)&& !etat) 
        {
            int tour = Math.abs(this.colonne - colonne);
            etat = this.enLigne(ligne,colonne,tour); 
        }
        if(colonne == this.colonne && verifHorsMap(ligne, colonne)&& !etat)  
        {
            int tour = Math.abs(this.ligne - ligne);
            etat = this.enLigne(ligne,colonne,tour); 
        }
        return etat;
    }

    public boolean detectionRoi(String couleur) 
    {
        boolean pieceNonTrouve = true;
        int iLigne = this.ligne+1;
        int iColonne = this.colonne;

        // Nord
       while (pieceNonTrouve && iLigne<8) 
       {
           if(echiquierCourant.siPiecePresente(iLigne, this.colonne))
           {
               pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, this.colonne);
                if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
           }
           iLigne++;
       }

       //Nord-Est
       iLigne = this.ligne+1;
       iColonne = this.colonne+1;
       pieceNonTrouve = true;
       while (pieceNonTrouve && iColonne<8 && iLigne<8) 
       {
        if(echiquierCourant.siPiecePresente(iLigne, iColonne))
        {
            pieceNonTrouve =true;
            Piece p = echiquierCourant.getCase(iLigne, iColonne);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
        iLigne++;
        iColonne++;
       }

       // Est
       iColonne = this.colonne+1;
       pieceNonTrouve = true;
       while (pieceNonTrouve && iColonne<8) 
       {
           if(echiquierCourant.siPiecePresente(this.ligne, iColonne))
           {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(this.ligne, iColonne);
                if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
           }
           iColonne++;
       }

        //Sud-Est
        iLigne = this.ligne-1;
        iColonne = this.colonne+1;
        pieceNonTrouve = true;
        while (pieceNonTrouve && iColonne<8 && iLigne>=0) 
       {
        if(echiquierCourant.siPiecePresente(iLigne, iColonne))
        {
            pieceNonTrouve =true;
             Piece p = echiquierCourant.getCase(iLigne, iColonne);
             if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
        iLigne--;
        iColonne++;
       }

       // Sud
       iLigne = this.ligne-1;
       pieceNonTrouve = true;
       while (pieceNonTrouve && iLigne>=0) 
       {
           if(echiquierCourant.siPiecePresente(iLigne, this.colonne))
           {
               pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, this.colonne);
                if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
           }
           iLigne--;
       }

       //Sud-Ouest
       iLigne = this.ligne-1;
       iColonne = this.colonne-1;
       pieceNonTrouve = true;
       while (pieceNonTrouve && iLigne >= 0 && iColonne >=0) 
      {
       if(echiquierCourant.siPiecePresente(iLigne, iColonne))
       {
           pieceNonTrouve =true;
            Piece p = echiquierCourant.getCase(iLigne, iColonne);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
       }
       iLigne--;
       iColonne--;
      }

       // Ouest
       iColonne = this.colonne-1;
       pieceNonTrouve = true;
       while (pieceNonTrouve && iColonne>=0) 
       {
           if(echiquierCourant.siPiecePresente(this.ligne, iColonne))
           {
               pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(this.ligne, iColonne);
                if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
           }
           iColonne--;
       }

       // Nord-Ouest
       iLigne = this.ligne+1;
       iColonne = this.colonne-1;
       pieceNonTrouve = true;
       while (pieceNonTrouve && iLigne<8&& iColonne>=0) 
      {
       if(echiquierCourant.siPiecePresente(iLigne, iColonne))
       {
            pieceNonTrouve =true;
            Piece p = echiquierCourant.getCase(iLigne, iColonne);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }
       iLigne++;
       iColonne--;
      }
      return false;
    }

}
