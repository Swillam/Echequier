public class Reine extends Piece 
{

    public Reine(int x, int y, String couleur, Echiquier e)
    {
        super(x,y,couleur,e);
        maxDeplacement = new Piece[4];
        this.refreshMax();
    }
    
    public void bouger(int x, int y) 
    {
        if (verificationCoup(x,y)) 
        {
            this.setPosition(x,y); // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int x, int y) 
    {
        return true;
    }

    public void refreshMax()
    {
        
    }

}
