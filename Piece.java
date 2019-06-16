import java.io.Serializable;

public abstract class Piece implements Serializable
{
    private static final long serialVersionUID = -4134002312500201270L;

    protected String couleur;

    protected String forme;

	protected int ligne;

    protected int colonne;
    
    protected boolean etreRoi = false;



    protected Echiquier echiquierCourant;

    public Piece(){} 

    public Piece(int ligne, int colonne, String couleur, Echiquier e) 
    {
        this.ligne = ligne;
        this.colonne = colonne;
        this.couleur = couleur;
        this.echiquierCourant = e;
	}

    public int getligne() {
        // Automaticallcolonne generated method. Please delete this comment before entering specific code.
        return this.ligne;
    }

    public void setligne(int value) {
        // Automaticallcolonne generated method. Please delete this comment before entering specific code.
        this.ligne = value;
    }

    public int getcolonne() {
        // Automaticallcolonne generated method. Please delete this comment before entering specific code.
        return this.colonne;
    }

    public void setcolonne(int value) {
        // Automaticallcolonne generated method. Please delete this comment before entering specific code.
        this.colonne = value;
    }
    public String getCouleur()
    {
        return this.couleur;
    }

    public String toString()
    {
        return forme;
    }
    public boolean verifHorsMap (int ligne, int colonne) 
    {
        if ( ligne > 7 || colonne > 7 || ligne < 0 || colonne < 0) return false;
        else return true;
    }	
    public int direction(int ligne , int colonne) 
    {
        int cas=-1;
        // Nord
        if(this.ligne<ligne && colonne == this.colonne) cas = 0;

       //Nord-Est
       if(this.ligne<ligne && this.colonne<colonne) cas = 1;

       // Est
       if(this.ligne == ligne && this.colonne<colonne) cas =2;

        //Sud-Est
        if(this.ligne>ligne && this.colonne<colonne) cas = 3;

       // Sud
       if(this.ligne>ligne && colonne == this.colonne) cas = 4;

       //Sud-Ouest
       if(this.ligne>ligne && this.colonne>colonne) cas = 5;

       // Ouest
        if(this.ligne == ligne && this.colonne>colonne) cas =6;

       // Nord-Ouest
        if(this.ligne<ligne && this.colonne>colonne) cas = 7;

        return cas;
    }

    public boolean diagonal(int ligne, int colonne, int tour)
    {
        int i = 1;
        int direction = this.direction(ligne, colonne);
        boolean etat= false;
        switch (direction) 
        {
            case 1:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne+i, this.colonne+i)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne+i, this.colonne+i))
                        etat = verifCouleur(this.ligne+i, this.colonne+i);
                    else  etat = true;
                    i++;
                }
                break;

            case 3:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne-i, this.colonne+i)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne-i, this.colonne+i))
                        etat = verifCouleur(this.ligne-i, this.colonne+i);
                    else  etat = true;
                    i++;
                }
                break;

            case 5:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne-i, this.colonne-i)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne-i, this.colonne-i))
                        etat = verifCouleur(this.ligne-i, this.colonne-i);
                    else  etat = true;
                    i++;
                }
                break;
            
            case 7:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne+i, this.colonne-i)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne+i, this.colonne-i))
                        etat = verifCouleur(this.ligne+i, this.colonne-i);
                    else  etat = true;
                    i++;
                }
                break;
        }
        return etat;

    }
    public boolean enLigne(int ligne, int colonne, int tour) 
    {
        int i = 1;
        int direction = this.direction(ligne, colonne);
        boolean etat= false;
        switch (direction) 
        {
            case 0:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne+i, this.colonne)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne+i, this.colonne))
                        etat = verifCouleur(this.ligne+i, this.colonne);
                    else  etat = true;
                    i++;
                }
                break;

            case 2:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne, this.colonne+i)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne, this.colonne+i))
                        etat = verifCouleur(this.ligne, this.colonne+i);
                    else  etat = true;
                    i++;
                }
                break;

            case 4:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne-i, this.colonne)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne-i, this.colonne))
                        etat = verifCouleur(this.ligne-i, this.colonne);
                    else  etat = true;
                    i++;
                }
                break;
            
            case 6:
                while(i<=tour)
                {
                    if(echiquierCourant.siPiecePresente(this.ligne, this.colonne-i)&& i!=tour) return false;
                    if(i==tour && echiquierCourant.siPiecePresente(this.ligne, this.colonne-i))
                        etat = verifCouleur(this.ligne, this.colonne-i);
                    else  etat = true;
                    i++;
                }
                break;
        }
        return etat;
    }
    public boolean bouger(int ligne, int colonne, String couleur) 
    {
        if (verificationCoup(ligne,colonne)) 
        {
            setligne(ligne);
            setcolonne(colonne);
            echiquierCourant.setCase(this, ligne, colonne); // Si la vérification est correcte, le pion va bouger
            this.detectionRoi(couleur);
            return true;
        }
        else return false;
    }

    public boolean verificationCoup(int ligne, int colonne) 
    {
        return false;
    }

    public boolean verifCouleur(int ligne, int colonne) 
    {
        return !(echiquierCourant.getCase(ligne,colonne).getCouleur().equals(this.couleur));  
    }

    public boolean detectionRoi(String couleurAJouer)
    {
        return false;
    }

    public boolean siRoi()
    {
        return etreRoi;
    }
}
