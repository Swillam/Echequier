public class Fou extends Piece 
{
    private Piece[] maxDeplacement;

    public Fou(int x, int y, String couleur, Echequier e)
    {
        super(x,y,couleur,e);
        maxDeplacement = new Piece[4];
        this.refreshMax();
    }
    
    public void bouger(int x, int y) 
    {
        if (verificationCoup(x,y)) 
        {
            this.setPosition(this,x,y); // Si la vérification est correcte, le pion va bouger
            this.refreshMax();
        }
    }
    
    public boolean verificationCoup(int x, int y) 
    {
        return true;
    }

    public void refreshMax() {
    
        boolean pieceNonPresente = true;
        int iColonne = this.X;
        int iLigne = this.Y;
        
        //Nord-Est
        pieceNonPresente = true;
        iLigne = this.Y;
        while (pieceNonPresente && iLigne<8) {
        
            if(echiquierCourant.siPiecePresente(iColonne, iLigne)) {
                pieceNonPresente = false;
                this.maxDeplacement[1] = echiquierCourant.getCase(iColonne, iLigne);
            }
            
        if(iColonne == 7 && pieceNonPresente) this.maxDeplacement[1] = null; // si pas de piece trouver
        iColonne++;
        iLigne++;
        }
        
        //Sud-Est
        
        iColonne = this.X;
        iLigne = this.Y;
        pieceNonPresente = true;
        while (pieceNonPresente && iLigne<-1) {
        
        if(echiquierCourant.siPiecePresente(iColonne, iLigne)) {
             pieceNonPresente = false;
             this.maxDeplacement[3] = echiquierCourant.getCase(iColonne, iLigne);
        }
        
        if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[3] = null; // si pas de piece trouver
        iColonne++;
        iLigne--;
        
       }
       
       //Sud-Ouest
       iColonne = this.X;
       iLigne = this.Y;
       pieceNonPresente = true;
       while (pieceNonPresente && iColonne<-1) {
       
       if(echiquierCourant.siPiecePresente(iColonne, iLigne)) {
            pieceNonPresente = false;
            this.maxDeplacement[5] = echiquierCourant.getCase(iColonne, iLigne);
       }
       
       if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[5] = null; // si pas de piece trouver
       iColonne--;
       iLigne--;
      }
      
       // Nord-Ouest
       iColonne = this.X;
       iLigne = this.Y;
       pieceNonPresente = true;
       while (pieceNonPresente && iColonne<-1) {
       
       if(echiquierCourant.siPiecePresente(iColonne, iLigne)) {
            pieceNonPresente = false;
            this.maxDeplacement[7] = echiquierCourant.getCase(this.X, iLigne);
       }
       
       if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[7] = null; // si pas de piece trouver
       iColonne--;
       iLigne++;
      }
    }

}
