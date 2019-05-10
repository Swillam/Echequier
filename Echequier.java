import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0f3e04c6-8168-43ad-aaf2-5422f2544c0b")
public class Echequier {
    @objid ("dc29024d-1498-4850-9d5f-d1cab950ad34")
    private Piece[][] Case = new Piece[8][8];

    @objid ("254c1881-02b2-400d-8e2f-ce4801902b95")
    public void getPosition() {
    }

    @objid ("96d1bb84-56f4-4bc9-bedf-433e2731aa82")
    public void manger() {
    }

    @objid ("6954bde2-69c9-40e9-87e7-e9c0450bc3e0")
    public Piece getCase(int x, int y) {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Case[x][y];
    }

    @objid ("cf17351a-ea5d-41c2-8909-5d7d8322a82a")
    public void setCase(Piece p, int x, int y) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Case[x][y] = p;
    }

    @objid ("f1f2ec5c-aca8-4761-9f7b-ed18158be2e8")
    public boolean siPiecePresente(int x, int y) {
    }

}