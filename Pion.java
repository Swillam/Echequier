import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("eb68b4c2-c482-4023-b2a7-8481194f6797")
public class Pion extends Piece {
    @objid ("c6684f9a-f09b-4518-b17b-8801822c615f")
    public void Promotion() {
    }

    @objid ("b1278758-735c-4213-a867-379170afc33d")
    public void bouger() {
         if (verificationCoup(x,y)) {
            this.setPosition(x,y) // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return True;
    }

}
