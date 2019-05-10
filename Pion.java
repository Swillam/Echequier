public class Pion extends Piece {
    public void Promotion() {
    }

    public void bouger(int x, int y) 
    {
        if (verificationCoup(x,y)) 
        {
            this.setPosition(x,y); // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return true;
    }

}
