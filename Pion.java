public class Pion extends Piece 
{
    private boolean promotion;

    public Pion(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        maxDeplacement = new Piece[3];
        if(couleur == "Blanc") forme = "\u2659";
        else forme = "\u265F";
        this.refreshMax();
    }

    public void bouger(int ligne, int colonne) 
    {
        if (verificationCoup(ligne,colonne)) 
        {
            this.setPosition(this,ligne,colonne); // Si la vérification est correcte, le pion va bouger
            this.refreshMax();
        }
        if(couleur == "Blanc" && ligne == 8)// si le pion est au bout il pourra etre promu
        {
            promotion = true;
        }
        if(couleur == "Noir" && ligne == 0)// meme chose mais s'il est noir
        {
            promotion = true;
        }
    }
    
    public boolean verificationCoup(int ligne, int colonne) {
        return true;
    }

    public void refreshMax() 
    {
        // Colonne = this.ligne;
        // Ligne = this.colonne;
        boolean horsMapNNoir = this.colonne == 0;
        boolean horsMapNBlanc = this.colonne == 7;
        boolean horsMapN = horsMapNBlanc;
        boolean horsMapE = this.ligne == 7;
        boolean horsMapO = this.ligne == 0;

        // pour les blancs
        int mouvementNord = this.colonne + 1; 
        int mouvementEst = this.ligne+1;
        int mouvementOuest = this.ligne-1;

        //mouvement et hors map noir
        if (this.couleur == "Noir") 
        {   
            horsMapN = horsMapNNoir;
            mouvementNord = this.colonne-1; // pour les blancs
            mouvementEst = this.ligne-1;
            mouvementOuest = this.ligne+1;
        }
        
        // Nord
       
        if(!(horsMapN))
        {
            if(echiquierCourant.siPiecePresente(this.ligne, mouvementNord)) 
            {
                this.maxDeplacement[0] = echiquierCourant.getCase(this.ligne, mouvementNord);
                
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
