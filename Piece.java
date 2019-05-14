public class Piece 
{
    protected String couleur;

    protected String forme;

    protected Piece[] maxDeplacement;

	protected int X;

	protected int Y;

    protected Echiquier echiquierCourant;

    public Piece(int x, int y, String couleur, Echiquier e) 
    {
        this.X = x;
        this.Y = y;
        this.couleur = couleur;
        this.echiquierCourant = e;
	}

    public void setPosition(Piece p,int x, int y) 
    {
        echiquierCourant.setCase(p,x,y);
        setX(x);
        setY(y);
    }

    public int getX() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.X;
    }

    public void setX(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.X = value;
    }

    public int getY() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Y;
    }

    public void setY(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Y = value;
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
