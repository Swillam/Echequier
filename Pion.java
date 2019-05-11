public class Pion extends Piece 
{
    private Piece[] maxDeplacement;

    public Pion(int x, int y, String couleur, Echiquier e)
    {
        super(x,y,couleur,e);
        maxDeplacement = new Piece[1];
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
    
    public boolean verificationCoup(int x, int y) {
        return true;
    }

    public void refreshMax() {
    
    boolean pieceNonPresente = true;
        int iColonne = this.X;
        int iLigne = this.Y;

        // Nord
       while (pieceNonPresente && iLigne<1) {
       
           if(echiquierCourant.siPiecePresente(this.X, iLigne)) {
                pieceNonPresente = false;
                this.maxDeplacement[0] = echiquierCourant.getCase(this.X, iLigne);
           }
           
           if(iLigne == 1 && pieceNonPresente) this.maxDeplacement[0] = null; // si pas de piece trouver
           iLigne++;
       }
    }

}
