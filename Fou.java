public class Fou extends Piece 
{

    private static final long serialVersionUID = 9093020255431294920L;

    public Fou(int ligne, int colonne, String couleur, Echiquier e)
    {
        super(ligne,colonne,couleur,e);
        if(couleur.equals("Blanc")) forme = "\u2657";
        else forme = "\u265D";
    }
    
    
    
    public boolean verificationCoup(int ligne, int colonne) 
    {
        boolean etat = false;
        if(Math.abs(this.ligne - ligne) == Math.abs(this.colonne - colonne) && verifHorsMap(ligne, colonne))
        {
            int tour = Math.abs(this.ligne - ligne);
            etat = this.diagonal(ligne, colonne, tour);
        }
        return etat;
    }

    public boolean detectionRoi(String couleur)  
    {
    
        boolean pieceNonTrouve = true;
        int iLigne = this.ligne+1;
        int iColonne = this.colonne+1;
        
        //Nord-Est
        pieceNonTrouve = true;
        while (pieceNonTrouve && iColonne<8 && iLigne<8) 
       {
            if(echiquierCourant.siPiecePresente(iLigne, iColonne))
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, iColonne);
                if(p.siRoi()) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
            iLigne++;
            iColonne++;
        }
        
        //Sud-Est
        iLigne = this.ligne-1;
        iColonne = this.colonne+1;
        pieceNonTrouve = true;
        while (pieceNonTrouve && iColonne<8 && iLigne>=0) 
        {
            if(echiquierCourant.siPiecePresente(iLigne, iColonne))
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, iColonne);
                if(p.siRoi()) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
            
            iLigne--;
            iColonne++;
        }
       
        //Sud-Ouest
        iLigne = this.ligne-1;
        iColonne = this.colonne-1;
        pieceNonTrouve = true;
        while (pieceNonTrouve && iLigne >= 0 && iColonne >=0) 
        {
            if(echiquierCourant.siPiecePresente(iLigne, iColonne))
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, iColonne);
                if(p.siRoi()) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
           }
            iLigne--;
            iColonne--;
        }
      
       // Nord-Ouest
        iLigne = this.ligne+1;
        iColonne = this.colonne-1;
        pieceNonTrouve = true;
        while (pieceNonTrouve && iLigne<8&& iColonne>=0) 
        {
            if(echiquierCourant.siPiecePresente(iLigne, iColonne))
            {
                pieceNonTrouve =false;
                Piece p = echiquierCourant.getCase(iLigne, iColonne);
                if(p.siRoi()) 
                {
                    Roi r = (Roi)p;
                    r.setEchec(!(r.getCouleur().equals(couleur)));
                    return true;
                }
            }
            iLigne++;
            iColonne--;
        }
        return false;
    }

}
