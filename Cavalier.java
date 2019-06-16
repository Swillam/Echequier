public class Cavalier extends Piece 
{
    private static final long serialVersionUID = -7595190401490983388L;

    public Cavalier(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        if(couleur.equals("Blanc")) forme = "\u2658";
        else forme = "\u265E";
    }

    public boolean verificationCoup(int ligne, int colonne) 
    {
        boolean etat = false;
        if (Math.abs(ligne -this.ligne) == 2  && Math.abs(colonne - this.colonne) == 1) etat = true;
        if (Math.abs(ligne -this.ligne) == 1  && Math.abs(colonne - this.colonne) == 2) etat = true;
        if (echiquierCourant.siPiecePresente(ligne,colonne)) etat = verifCouleur(ligne,colonne);
        return etat;
    }
    public boolean detectionRoi(String couleur)  
    {
        boolean roiAdverseTrouver = false;
        
        if(verifHorsMap(this.ligne+2, this.colonne+1))
        if(echiquierCourant.siPiecePresente(this.ligne+2, this.colonne+1))
        {
            Piece p = echiquierCourant.getCase(this.ligne+2, this.colonne+1);
           if(p.siRoi()) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }

        if(verifHorsMap(this.ligne+2, this.colonne-1))
        if(echiquierCourant.siPiecePresente(this.ligne+2, this.colonne-1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne+2, this.colonne-1);
           if(p.siRoi()) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }
        if(verifHorsMap(this.ligne-2, this.colonne+1))
        if( echiquierCourant.siPiecePresente(this.ligne-2, this.colonne+1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne-2, this.colonne+1);
           if(p.siRoi()) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }

        if(verifHorsMap(this.ligne-2, this.colonne-1))
        if(echiquierCourant.siPiecePresente(this.ligne-2, this.colonne-1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne-2, this.colonne-1);
            if(p.siRoi()) 
            {
                Roi r = (Roi)p;
                System.out.println(p);
                System.out.println(r.getCouleur().equals(couleur));
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }        
        }
        return roiAdverseTrouver;


    }
}
