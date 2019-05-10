import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class Tour extends Piece {
    
    public void bouger() {
         if (verificationCoup(x,y)) {
            this.setPosition(x,y) // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return True;
    }

}
