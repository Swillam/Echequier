import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("04e9782a-7f5c-445c-8bbc-b224956bbf14")

public class Reine extends Piece {
    
    @objid ("13cfb459-74e1-4faa-b3d3-8d2bcf61c180")
    
    public void bouger() {
        if verificationCoup(x,y) {
            this.setPosition(x,y)
        }
    }

}
