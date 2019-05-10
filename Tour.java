import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("deb9fa6d-5bd4-411a-a4d7-6e2510740714")

public class Tour extends Piece {

    @objid ("152c37bc-12ab-4845-8087-7d16d9bc5ab1")
    public void bouger(int x, int y) {
         if (verificationCoup(x,y)) {
            this.setPosition(x,y); // Si la vérification est correcte, le pion va bouger
        }
    }
    
    public boolean verificationCoup(int x, int y) {
        return True;
    }

    public void refreshMax(Echequier e)
    {
        boolean pieceNonPresente = true;
        int iColonne = this.Y;
        int iLigne = this.X;
        // Nord
       while (pieceNonPresente && iColonne<8) 
       {
           if(e.getCase(this.X, iColonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[0] = e.getCase(this.X, iColonne);
           }
           if(iColonne == 7 && pieceNonPresente) this.maxDeplacement[0] = null; // si pas de piece trouver
           iColonne++;
       }

       // Est
       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<8) 
       {
           if(e.getCase(this.X, iLigne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[1] = e.getCase(this.X, iLigne);
           }
           if(iLigne == 7 && pieceNonPresente) this.maxDeplacement[1] = null; // si pas de piece trouver
           iLigne++;
       }

        iColonne = this.Y;
        iLigne = this.X;

       // Sud
       pieceNonPresente = true;
       while (pieceNonPresente && iColonne<-1) 
       {
           if(e.getCase(this.X, iColonne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[2] = e.getCase(this.X, iColonne);
           }
           if(iColonne == 0 && pieceNonPresente) this.maxDeplacement[2] = null; // si pas de piece trouver
           iColonne--;
       }

       pieceNonPresente = true;
       while (pieceNonPresente && iLigne<-1) 
       {
           if(e.getCase(this.X, iLigne) != null)
           {
                pieceNonPresente = false;
                this.maxDeplacement[3] = e.getCase(this.X, iLigne);
           }
           if(iLigne == 0 && pieceNonPresente) this.maxDeplacement[3] = null; // si pas de piece trouver
           iLigne--;
       }
    }

}
