import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("4151706f-b48b-4ed2-9755-8d54ddca20c1")

public class Fou extends Piece {
    
    @objid ("30e4f7eb-f2bd-4b5a-9252-c0d4f17f2470")
    
    public void bouger() {
        if (verificationCoup(x,y)) {
            this.setPosition(x,y) // Si la vérification est correcte, le pion va bouger
        }
    }

}
