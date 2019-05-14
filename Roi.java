public class Roi extends Piece 
{
    
    public Roi(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        if(couleur == "Blanc") forme = "\u2654";
        else forme = "\u265A";
    }
    
    public void bouger(int ligne, int colonne) 
    {
        if (verificationCoup(ligne,colonne))
        {
            this.setPosition(this,ligne,colonne); // Si la vérification est correcte, le pion va bouger
        }
    }

    public boolean verificationCoup(int ligne, int colonne) 
    {
        return true;
    }
    public void refreshMax()
    {}

}
