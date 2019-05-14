public class Piece 
{
    protected String couleur;

    protected String forme;

    protected Piece[] maxDeplacement;

	protected int ligne;

	protected int colonne;

    protected Echiquier echiquierCourant;

    public Piece(int ligne, int colonne, String couleur, Echiquier e) 
    {
        this.ligne = ligne;
        this.colonne = colonne;
        this.couleur = couleur;
        this.echiquierCourant = e;
	}

    public void setPosition(Piece p,int ligne, int colonne) 
    {
        echiquierCourant.setPosition(p,ligne,colonne);
        setligne(ligne);
        setcolonne(colonne);
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

}
