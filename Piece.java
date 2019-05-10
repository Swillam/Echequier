public class Piece 
{
    protected String Couleur;

	protected int X;

	protected int Y;

    protected Piece[] maxDeplacement;

    protected Echiquier echiquierCourant;

    public Piece(int x, int y, String couleur, Echiquier e) 
    {
        this.X = x;
        this.Y = y;
        this.Couleur = couleur;
        this.echiquierCourant = e;
	}

	public void setPosition(int x, int y) {
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
        return this.Couleur;
    }

}
