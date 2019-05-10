public class Tour extends Piece {

    public Tour(int x, int y, String couleur, Echiquier e)
    {
        super(x,y,couleur,e);
        maxDeplacement = new Piece[4];
        this.refreshMax();
    }

    public void bouger(int x, int y) 
    {
        if (verificationCoup(x,y)) 
        {
            this.setPosition(x,y); // Si la vérification est correcte, le pion va bouger
            this.refreshMax();
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return true;
    }

    public void refreshMax()
    {
        boolean pieceNonPresente = true;
        int iColonne = this.Y;
        int iLigne = this.X;
        // Nord
       while (pieceNonPresente && iColonne<8) 
       {
           if(echiquierCourant.getCase(this.X, iColonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[0] = echiquierCourant.getCase(this.X, iColonne);
           }
           if(iColonne == 7 && pieceNonPresente) this.maxDeplacement[0] = null; // si pas de piece trouver
           iColonne++;
       }

       // Est
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<8) 
       {
           if(echiquierCourant.getCase(this.X, iLigne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[1] = echiquierCourant.getCase(this.X, iLigne);
           }
           if(iLigne == 7 && pieceNonPresente) this.maxDeplacement[1] = null; // si pas de piece trouver
           iLigne++;
       }

        iColonne = this.Y;
        iLigne = this.X;

       // Sud
       pieceNonPresente = true;
       while (pieceNonPresente && iColonne<-1) 
       {
           if(echiquierCourant.getCase(this.X, iColonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[2] = echiquierCourant.getCase(this.X, iColonne);
           }
           if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[2] = null; // si pas de piece trouver
           iColonne--;
       }

       // Ouest
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<-1) 
       {
           if(echiquierCourant.getCase(this.X, iLigne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[3] = echiquierCourant.getCase(this.X, iLigne);
           }
           if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[3] = null; // si pas de piece trouver
           iLigne--;
       }
    }

}
