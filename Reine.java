public class Reine extends Piece 
{

    public Reine(int x, int y, String couleur, Echiquier e)
    {
        super(x,y,couleur,e);
        maxDeplacement = new Piece[8];
        if(couleur == "Blanc") forme = "\u2655";
        else forme = "\u265B";
        this.refreshMax();
    }
    
    public void bouger(int x, int y) 
    {
        if (verificationCoup(x,y)) 
        {
            this.setPosition(this,x,y); // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int x, int y) 
    {
        return true;
    }

    public void refreshMax()
    {
        boolean pieceNonPresente = true;
        int iColonne = this.X;
        int iLigne = this.Y;

        // Nord
       while (pieceNonPresente && iLigne<8) 
       {
           if(echiquierCourant.siPiecePresente(this.X, iLigne))
           {
                pieceNonPresente = false;
                this.maxDeplacement[0] = echiquierCourant.getCase(this.X, iLigne);
           }
           if(iLigne == 7 && pieceNonPresente) this.maxDeplacement[0] = null; // si pas de piece trouver
           iLigne++;
       }

       //Nord-Est
       pieceNonPresente = true;
       iLigne = this.Y;
       while (pieceNonPresente && iLigne<8) 
       {
        if(echiquierCourant.siPiecePresente(iColonne, iLigne))
        {
             pieceNonPresente = false;
             this.maxDeplacement[1] = echiquierCourant.getCase(iColonne, iLigne);
        }
        if(iColonne == 7 && pieceNonPresente) this.maxDeplacement[1] = null; // si pas de piece trouver
        iColonne++;
        iLigne++;
       }

       // Est
       pieceNonPresente = true;
       iColonne = this.X;
       while (pieceNonPresente && iLigne<8) 
       {
           if(echiquierCourant.siPiecePresente(iColonne, this.Y))
           {
                pieceNonPresente = false;
                this.maxDeplacement[2] = echiquierCourant.getCase(iColonne, this.Y);
           }
           if(iColonne == 7 && pieceNonPresente) this.maxDeplacement[2] = null; // si pas de piece trouver
           iColonne++;
       }

        //Sud-Est
        iColonne = this.X;
        iLigne = this.Y;
        pieceNonPresente = true;
        while (pieceNonPresente && iLigne<-1) 
       {
        if(echiquierCourant.siPiecePresente(iColonne, iLigne))
        {
             pieceNonPresente = false;
             this.maxDeplacement[3] = echiquierCourant.getCase(iColonne, iLigne);
        }
        if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[3] = null; // si pas de piece trouver
        iColonne++;
        iLigne--;
       }

       // Sud
       pieceNonPresente = true;
       iLigne = this.Y;
       while (pieceNonPresente && iLigne<-1) 
       {
           if(echiquierCourant.siPiecePresente(this.X, iLigne))
           {
                pieceNonPresente = false;
                this.maxDeplacement[4] = echiquierCourant.getCase(this.X, iLigne);
           }
           if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[4] = null; // si pas de piece trouver
           iLigne--;
       }

       //Sud-Ouest
       iColonne = this.X;
       iLigne = this.Y;
       pieceNonPresente = true;
       while (pieceNonPresente && iColonne<-1) 
      {
       if(echiquierCourant.siPiecePresente(iColonne, iLigne))
       {
            pieceNonPresente = false;
            this.maxDeplacement[5] = echiquierCourant.getCase(iColonne, iLigne);
       }
       if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[5] = null; // si pas de piece trouver
       iColonne--;
       iLigne--;
      }

       // Ouest
       iColonne = this.X;
       pieceNonPresente = true;
       while (pieceNonPresente && iColonne<-1) 
       {
           if(echiquierCourant.siPiecePresente(iColonne, this.Y))
           {
                pieceNonPresente = false;
                this.maxDeplacement[6] = echiquierCourant.getCase(iColonne, this.Y);
           }
           if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[6] = null; // si pas de piece trouver
           iColonne--;
       }

       // Nord-Ouest
       iColonne = this.X;
       iLigne = this.Y;
       pieceNonPresente = true;
       while (pieceNonPresente && iColonne<-1) 
      {
       if(echiquierCourant.siPiecePresente(iColonne, iLigne))
       {
            pieceNonPresente = false;
            this.maxDeplacement[7] = echiquierCourant.getCase(this.X, iLigne);
       }
       if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[7] = null; // si pas de piece trouver
       iColonne--;
       iLigne++;
      }
    }

}
