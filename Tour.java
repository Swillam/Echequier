public class Tour extends Piece {

    public Tour(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        maxDeplacement = new Piece[4];
        if(couleur == "Blanc") forme = "\u2656";
        else forme = "\u265C";
        this.refreshMax();
    }

    public void bouger(int ligne, int colonne) 
    {
        if (verificationCoup(ligne,colonne)) 
        {
            this.setPosition(this,ligne,colonne); // Si la vérification est correcte, le pion va bouger
            this.refreshMax();
        }
    }
    
    public boolean verificationCoup(int ligne, int colonne) {
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
           if(echiquierCourant.getCase(this.ligne, iColonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[0] = echiquierCourant.getCase(this.ligne, iColonne);
           }
           if(iColonne == 7 && pieceNonPresente) this.maxDeplacement[0] = null; // si pas de piece trouver
           iColonne++;
       }

       // Est
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<8) 
       {
           if(echiquierCourant.getCase(iLigne, this.colonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[1] = echiquierCourant.getCase(iLigne, this.colonne);
           }
           if(iLigne == 7 && pieceNonPresente) this.maxDeplacement[1] = null; // si pas de piece trouver
           iLigne++;
       }

       // Sud
       pieceNonPresente = true;
       iColonne = this.colonne;
       while (pieceNonPresente && iColonne<-1) 
       {
           if(echiquierCourant.getCase(this.ligne, iColonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[2] = echiquierCourant.getCase(this.ligne, iColonne);
           }
           if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[2] = null; // si pas de piece trouver
           iColonne--;
       }

       // Ouest
       iLigne = this.ligne;
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<-1) 
       {
           if(echiquierCourant.getCase(iLigne, this.colonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[3] = echiquierCourant.getCase(iLigne, this.colonne);
           }
           if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[3] = null; // si pas de piece trouver
           iLigne--;
       }
    }

}
