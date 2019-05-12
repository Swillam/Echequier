public class Pion extends Piece 
{
    private Piece[] maxDeplacement;
    private boolean promotion;

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
        if(couleur == "Blanc" && X == 8)// si le pion est au bout il pourra etre promu
        {
            promotion = true;
        }
        if(couleur == "Noir" && X == 0)// meme chose mais s'il est noir
        {
            promotion = true;
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return true;
    }

    public void refreshMax() 
    {
        // Colonne = this.X;
        // Ligne = this.Y;
        boolean horsMapNNoir = this.Y == 0;
        boolean horsMapNBlanc = this.Y == 7;
        boolean horsMapN = horsMapNBlanc;
        boolean horsMapE = this.X == 7;
        boolean horsMapO = this.X == 0;
        int mouvementNord = this.Y + 1; // pour les blancs
        int mouvementEst = this.X+1;
        int mouvementOuest = this.X-1;
        if (this.couleur == "Noir") //mouvement et hors map noir
        {   
            horsMapN = horsMapNNoir;
            mouvementNord = this.Y-1; // pour les blancs
            mouvementEst = this.X-1;
            mouvementOuest = this.X+1;
        }
        // Nord
       
        if(!(horsMapN))
        {
            if(echiquierCourant.siPiecePresente(this.X, mouvementNord)) 
            {
                this.maxDeplacement[0] = echiquierCourant.getCase(this.X, mouvementNord);
                
                // Nord-Est
                if(!(horsMapE))
                {
                    if(echiquierCourant.siPiecePresente(mouvementEst, mouvementNord))
                    {
                            this.maxDeplacement[1] = echiquierCourant.getCase(mouvementEst, mouvementNord);
                    }
                    else this.maxDeplacement[1] = null; // si pas de piece trouver
                }
                
                // Nord-Ouest
                if(!(horsMapO))
                {
                    if(echiquierCourant.siPiecePresente(mouvementOuest, mouvementNord))
                    {
                        this.maxDeplacement[2] = echiquierCourant.getCase(mouvementOuest, mouvementNord);
                    }
                    else this.maxDeplacement[2] = null; // si pas de piece trouver
                }
            }
        }
           
        else 
        {
            this.maxDeplacement[0] = null; // si pas de piece trouver Nord
            this.maxDeplacement[1] = null; // si pas de piece trouver Nord-Est
            this.maxDeplacement[2] = null; // si pas de piece trouver Nord-Ouest
        }
    }

    public boolean getPromotion()
    {
        return this.promotion;
    }

}
