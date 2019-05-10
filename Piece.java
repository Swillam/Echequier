import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3f29eb94-95c0-474b-87c5-0c467f676825")
public class Piece {
    @objid ("b4c1f336-ce5a-4b1c-852f-eeb61b77b03a")
    private String Couleur;

    @objid ("0d81adf4-0776-4729-8b22-e0b03cbd411b")
    private int X;

    @objid ("60450595-40cf-4ccb-964b-622279a0effa")
    private int Y;

    @objid ("674cb1a3-c51a-47c0-895e-6a2d2810309f")
    public void setPosition(int x, int y) {
        setX(x);
        ŝetY(y);
    }

    @objid ("1217b07f-23f8-401a-949a-da4d25d0d11b")
    int getX() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.X;
    }

    @objid ("f7c0b078-6746-4d59-baea-c961c1cafe6e")
    void setX(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.X = value;
    }

    @objid ("c088520d-265c-4871-a8a8-5b94028953fe")
    int getY() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Y;
    }

    @objid ("c1a4c35f-43c9-4bdd-bdf5-9d250ab6d1c1")
    void setY(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Y = value;
    }

}
