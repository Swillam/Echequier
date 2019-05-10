import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("deb9fa6d-5bd4-411a-a4d7-6e2510740714")

public class Tour extends Piece {
    
    @objid ("152c37bc-12ab-4845-8087-7d16d9bc5ab1")
    public void bouger() {
         if (verificationCoup(x,y)) {
            this.setPosition(x,y) // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return True;
    }

}
