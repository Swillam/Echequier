public class Roi extends Piece 
{
    
    private static final long serialVersionUID = 4105674986452191219L;

    public Roi(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        if(couleur.equals("Blanc"))forme = "\u2654";
        else forme = "\u265A";
        etreRoi = true;
    }
    

    public boolean verificationCoup(int ligne, int colonne) 
    {
        boolean etat = false;
        if(Math.abs(this.ligne - ligne) ==1 &&  Math.abs(this.colonne - colonne) ==1 && verifHorsMap(ligne, colonne))
        {
            etat = this.diagonal(ligne, colonne, 1);
        }
        if(Math.abs(this.ligne - ligne) ==1 && verifHorsMap(ligne, colonne)&& !etat) 
        {
            etat = this.enLigne(ligne,colonne,1); 
        }
        if(Math.abs(this.colonne - colonne) == 1 && verifHorsMap(ligne, colonne)&& !etat)  
        {
            etat = this.enLigne(ligne,colonne,1); 
        }
        return etat;
    }
    public boolean detectionRoi()
    {
        boolean roiAdverseTrouver =false;
        // Nord
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne))
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }



       //Nord-Est
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne+1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne+1);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }

       // Est
        if(echiquierCourant.siPiecePresente(this.ligne, this.colonne+1))
        {
            Piece p = echiquierCourant.getCase(this.ligne, this.colonne+1);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }
        //Sud-Est
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne+1))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne+1);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }
       // Sud
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }
       //Sud-Ouest
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne-1))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne-1);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }
       // Ouest
        if(echiquierCourant.siPiecePresente(this.ligne, this.colonne-1))
        {
            Piece p = echiquierCourant.getCase(this.ligne, this.colonne-1);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }
       // Nord-Ouest
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne-1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne-1);
            if(p.siRoi())   roiAdverseTrouver = !(p.getCouleur().equals(echiquierCourant.getCouleur()));
        }    
        return roiAdverseTrouver;
    }

    
}
