public class Reine extends Piece 
{

    public Reine(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        maxDeplacement = new Piece[8];
        if(couleur == "Blanc") forme = "\u2655";
        else forme = "\u265B";
        this.refreshMax();
    }
    
    public void bouger(int ligne, int colonne) 
    {
        if (verificationCoup(ligne,colonne)) 
        {
            this.setPosition(this,ligne,colonne); // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int ligne, int colonne) 
    {
        return true;
    }

    public void refreshMax()
    {
        boolean pieceNonPresente = true;
        int iLigne = this.ligne;
        int iColonne = this.colonne;

        // Nord
       while (pieceNonPresente && iColonne<8) 
       {
           if(echiquierCourant.siPiecePresente(this.ligne, iColonne))
           {
                pieceNonPresente = false;
                this.maxDeplacement[0] = echiquierCourant.getCase(this.ligne, iColonne);
           }
           if(iColonne == 7 && pieceNonPresente) this.maxDeplacement[0] = null; // si pas de piece trouver
           iColonne++;
       }

       //Nord-Est
       pieceNonPresente = true;
       iColonne = this.colonne;
       while (pieceNonPresente && iColonne<8) 
       {
        if(echiquierCourant.siPiecePresente(iLigne, iColonne))
        {
             pieceNonPresente = false;
             this.maxDeplacement[1] = echiquierCourant.getCase(iLigne, iColonne);
        }
        if(iLigne == 7 && pieceNonPresente) this.maxDeplacement[1] = null; // si pas de piece trouver
        iLigne++;
        iColonne++;
       }

       // Est
       pieceNonPresente = true;
       iLigne = this.ligne;
       while (pieceNonPresente && iColonne<8) 
       {
           if(echiquierCourant.siPiecePresente(iLigne, this.colonne))
           {
                pieceNonPresente = false;
                this.maxDeplacement[2] = echiquierCourant.getCase(iLigne, this.colonne);
           }
           if(iLigne == 7 && pieceNonPresente) this.maxDeplacement[2] = null; // si pas de piece trouver
           iLigne++;
       }

        //Sud-Est
        iLigne = this.ligne;
        iColonne = this.colonne;
        pieceNonPresente = true;
        while (pieceNonPresente && iColonne<-1) 
       {
        if(echiquierCourant.siPiecePresente(iLigne, iColonne))
        {
             pieceNonPresente = false;
             this.maxDeplacement[3] = echiquierCourant.getCase(iLigne, iColonne);
        }
        if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[3] = null; // si pas de piece trouver
        iLigne++;
        iColonne--;
       }

       // Sud
       pieceNonPresente = true;
       iColonne = this.colonne;
       while (pieceNonPresente && iColonne<-1) 
       {
           if(echiquierCourant.siPiecePresente(this.ligne, iColonne))
           {
                pieceNonPresente = false;
                this.maxDeplacement[4] = echiquierCourant.getCase(this.ligne, iColonne);
           }
           if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[4] = null; // si pas de piece trouver
           iColonne--;
       }

       //Sud-Ouest
       iLigne = this.ligne;
       iColonne = this.colonne;
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<-1) 
      {
       if(echiquierCourant.siPiecePresente(iLigne, iColonne))
       {
            pieceNonPresente = false;
            this.maxDeplacement[5] = echiquierCourant.getCase(iLigne, iColonne);
       }
       if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[5] = null; // si pas de piece trouver
       iLigne--;
       iColonne--;
      }

       // Ouest
       iLigne = this.ligne;
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<-1) 
       {
           if(echiquierCourant.siPiecePresente(iLigne, this.colonne))
           {
                pieceNonPresente = false;
                this.maxDeplacement[6] = echiquierCourant.getCase(iLigne, this.colonne);
           }
           if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[6] = null; // si pas de piece trouver
           iLigne--;
       }

       // Nord-Ouest
       iLigne = this.ligne;
       iColonne = this.colonne;
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<-1) 
      {
       if(echiquierCourant.siPiecePresente(iLigne, iColonne))
       {
            pieceNonPresente = false;
            this.maxDeplacement[7] = echiquierCourant.getCase(this.ligne, iColonne);
       }
       if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[7] = null; // si pas de piece trouver
       iLigne--;
       iColonne++;
      }
    }

}
