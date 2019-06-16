public class Roi extends Piece 
{
    
    private static final long serialVersionUID = 4105674986452191219L;
    private boolean echec =false;


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
    public boolean detectionRoi(String couleur) 
    {
        boolean roiAdverseTrouver =false;
        // Nord
        if(verifHorsMap(this.ligne+1, this.colonne))
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne))
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }



       //Nord-Est
        if(verifHorsMap(this.ligne+1, this.colonne+1))
        if( echiquierCourant.siPiecePresente(this.ligne+1, this.colonne+1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne+1);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }

       // Est
        if(verifHorsMap(this.ligne, this.colonne+1))
        if(echiquierCourant.siPiecePresente(this.ligne, this.colonne+1))
        {
            Piece p = echiquierCourant.getCase(this.ligne, this.colonne+1);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }
        //Sud-Est
        if(verifHorsMap(this.ligne-1, this.colonne+1)) 
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne+1))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne+1);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }
       // Sud
        if(verifHorsMap(this.ligne-1, this.colonne))
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }
       //Sud-Ouest
        if(verifHorsMap(this.ligne-1, this.colonne-1))
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne-1))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne-1);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }
       // Ouest
        if(verifHorsMap(this.ligne, this.colonne-1))
        if(echiquierCourant.siPiecePresente(this.ligne, this.colonne-1))
        {
            Piece p = echiquierCourant.getCase(this.ligne, this.colonne-1);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }
       // Nord-Ouest
        if(verifHorsMap(this.ligne+1, this.colonne-1)) 
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne-1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne-1);
            if(p.siRoi()&& !(p.getCouleur().equals(this.couleur))) 
            {
                Roi r = (Roi)p;
                r.setEchec(!(r.getCouleur().equals(couleur)));
                return true;
            }
        }    
        return roiAdverseTrouver;
    }


    public void setEchec(boolean b)
    {
        echec = b;
        if(echec)   echiquierCourant.setEnEchec(this);
        else echiquierCourant.setEnEchec(null);
    }


	/*public boolean deplacePos() {
        // Nord
        echiquierCourant.setPieceJouer(this);
        if(verifHorsMap(this.ligne+1, this.colonne))
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne))
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne+1, this.colonne);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne+1, this.colonne);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne+1, this.colonne);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne+1, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne+1, this.colonne);
            }
        }



       //Nord-Est
        if(verifHorsMap(this.ligne+1, this.colonne+1))
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne+1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne+1);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne+1, this.colonne+1);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne+1, this.colonne+1);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne+1, this.colonne+1);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne+1, this.colonne+1);
            }
        }

       // Est
        if(verifHorsMap(this.ligne, this.colonne+1))
        if(echiquierCourant.siPiecePresente(this.ligne, this.colonne+1))
        {
            Piece p = echiquierCourant.getCase(this.ligne, this.colonne+1);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne, this.colonne+1);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne, this.colonne+1);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne, this.colonne+1);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne, this.colonne+1);
            }
        }

        //Sud-Est
        if(verifHorsMap(this.ligne-1, this.colonne+1))
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne+1))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne+1);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne-1, this.colonne+1);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne-1, this.colonne+1);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne-1, this.colonne+1);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne-1, this.colonne+1);
            }
        }

       // Sud
        if(verifHorsMap(this.ligne-1, this.colonne))
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne-1, this.colonne);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne-1, this.colonne);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne-1, this.colonne);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne-1, this.colonne);
            }
        }

       //Sud-Ouest
        if(verifHorsMap(this.ligne-1, this.colonne-1))
        if(echiquierCourant.siPiecePresente(this.ligne-1, this.colonne-1))
        {
            Piece p = echiquierCourant.getCase(this.ligne-1, this.colonne-1);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne-1, this.colonne-1);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne-1, this.colonne-1);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne-1, this.colonne-1);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne-1, this.colonne-1);
            }
        }

       // Ouest
        if(verifHorsMap(this.ligne, this.colonne-1))
        if(echiquierCourant.siPiecePresente(this.ligne, this.colonne-1))
        {
            Piece p = echiquierCourant.getCase(this.ligne, this.colonne-1);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne, this.colonne-1);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne, this.colonne-1);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne, this.colonne-1);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne, this.colonne-1);
            }
        }

       // Nord-Ouest
        if(verifHorsMap(this.ligne+1, this.colonne-1))
        if(echiquierCourant.siPiecePresente(this.ligne+1, this.colonne-1)) 
        {
            Piece p = echiquierCourant.getCase(this.ligne+1, this.colonne-1);
            echiquierCourant.manger(this,p);
            echiquierCourant.setCase(null, this.ligne, this.colonne);
            echiquierCourant.setCase(this, this.ligne+1, this.colonne-1);
            if(!(p.getCouleur().equals(couleur))) if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne+1, this.colonne-1);
            }
        }
        else 
        {
            echiquierCourant.setCase(this, this.ligne+1, this.colonne-1);
            if(!(echiquierCourant.echec(1)))
            {
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                return true;
            }
            else
            { 
                echiquierCourant.annuleMouv(this.ligne, this.colonne);
                echiquierCourant.setCase(null, this.ligne+1, this.colonne-1);
            }
        }
        echiquierCourant.annuleMouv(this.ligne, this.colonne);
        
        return false;
	}*/



    
}
