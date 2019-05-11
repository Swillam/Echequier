public class Pion extends Piece 
{
    private Piece[] maxDeplacement;

    public Pion(int x, int y, String couleur, Echiquier e)
    {
        super(x,y,couleur,e);
        maxDeplacement = new Piece[1];
        this.refreshMax();
    }

    public void Promotion() 
    {
    }

    public void bouger(int x, int y) 
    {
        if (verificationCoup(x,y)) 
        {
            this.setPosition(this,x,y); // Si la vérification est correcte, le pion va bouger
            this.refreshMax();
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return true;
    }

    public void refreshMax()
    {}

}
