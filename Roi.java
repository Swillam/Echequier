import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7b09a642-e9ea-4373-943e-a44f980c49fd")

public class Roi extends Piece {
    
    @objid ("e3169dec-43ac-446e-a16a-55c2f901909c")
    
    public void bouger() {
         if verificationCoup(x,y) {
            this.setPosition(x,y) // Si la vérification est correcte, le pion va bouger
         }
    }

}
