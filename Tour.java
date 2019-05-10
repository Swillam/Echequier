import com.modeliosoft.modelio.javadesigner.annotations.objid;

public class Tour extends Piece {
    
    public void bouger() {
        if verificationCoup(x,y) {
            this.setPosition(x,y)
        }
    }

}
