public class Pion extends Piece 
{
    private static final long serialVersionUID = 9206150100327249163L;
    private boolean promotion;
    private boolean premierTour = true;

    public Pion(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        if(couleur.equals("Blanc")) forme = "\u2659";
        else forme = "\u265F";
    }

    public boolean bouger(int ligne, int colonne, String couleur) 
    {
        if (verificationCoup(ligne,colonne)) 
        {
            setligne(ligne);
            setcolonne(colonne);
            echiquierCourant.setCase(this, ligne, colonne); // Si la vérification est correcte, le pion va bouger
            if(couleur.equals("Blanc") && ligne == 7 || couleur.equals("Noir") && ligne == 0)// si le pion est au bout il pourra etre promu
            {
                echiquierCourant.promotion(this);
            }
            this.detectionRoi(couleur);
            return true;
        }
       
        return false;
    }
    
    public boolean verificationCoup(int ligne, int colonne) 
    {
        boolean etat = false;
        if(this.couleur.equals("Noir") && verifHorsMap(ligne, colonne) )
        {
            if(!(echiquierCourant.siPiecePresente(ligne,colonne))) etat = ligne == this.ligne-1;
            if(premierTour && !(etat))
            {
                etat = ligne == this.ligne-2 && colonne == this.colonne;
            }
            if(ligne == this.ligne-1 && Math.abs(colonne-this.colonne) == 1)
            { 
                etat = false;
                if(echiquierCourant.siPiecePresente(ligne,colonne))etat = verifCouleur(ligne,colonne);
            }
        }
        if(this.couleur.equals("Blanc") && verifHorsMap(ligne, colonne) )
        {
            if(!(echiquierCourant.siPiecePresente(ligne,colonne))) etat = ligne == this.ligne+1 ; // si personne devant on verifie s'il avance
            if(premierTour && !(etat)) // au premier tour il peut faire 2 case en avant
            {
                etat = ligne == this.ligne+2 && colonne == this.colonne;
            }   
            if(ligne == this.ligne+1 && Math.abs(colonne-this.colonne) == 1)
            {
                etat = false;
                if(echiquierCourant.siPiecePresente(ligne,colonne)) etat = verifCouleur(ligne,colonne);
            }
        }
        if(etat) premierTour = false;
        return etat;
    }

    public boolean detectionRoi(String couleur)  
    {
        boolean roiAdverseTrouver = false;

        boolean horsMapE = this.colonne == 7;
        boolean horsMapO = this.colonne == 0;

        // pour les blancs
        int mouvementNord = this.ligne+1; 
        int mouvementEst = this.colonne+1;
        int mouvementOuest = this.colonne-1;

        //mouvement et hors map noir
        if (this.couleur.equals("Noir")) 
        {  
            horsMapE = this.colonne == 0;
            horsMapO = this.colonne == 7;    
            mouvementNord = this.ligne-1; 
            mouvementEst = this.colonne-1;
            mouvementOuest = this.colonne+1;
        }


        // Nord-Est
        if(!(horsMapE))
        {
            if(echiquierCourant.siPiecePresente(mouvementNord,mouvementEst))
            {
                Piece p = echiquierCourant.getCase(mouvementNord,mouvementEst);
                if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }            
            }
        }
        // Nord-Ouest
        if(!(horsMapO))
        {
            if(echiquierCourant.siPiecePresente(mouvementNord,mouvementOuest))
            {
                Piece p = echiquierCourant.getCase(mouvementNord,mouvementOuest);
                if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }            
            }
        }
        return roiAdverseTrouver;
    }

    public boolean getPromotion()
    {
        return this.promotion;
    }
}

        