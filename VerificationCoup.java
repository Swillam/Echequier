public class VerificationCoup {

  private int colonne;
  private int ligne;
  private String couleur;

  public boolean verifHorsMap (int ligne, int colonne) {
    if ( ligne > 8 || colonne > 8 ) return false;
  }

  public boolean verifColonne(int colonne) {
    if (ligne == this.ligne) return true;
  }

  public boolean verifLigne(int ligne) {
    if (colonne == this.colonne) return true;
  }

  public boolean verifTour(int ligne, int colonne) {
    if (verifHorsMap() == false) return false;
    if (verifColonne() || verifLigne() == true) return true;
    else return false;
  } //Fin methode

  public boolean VerifPion(int ligne, int colonne) {
    if (verifHorsMap() == false) return false;

    if (tourDeJeu == 1 && couleur == "Blanc") {
      if (colonne == (this.colonne + 2)) {
        return true;
      } // Deuxième if
    } // Premier if

    else {
      if (colonne == (this.colonne - 2) ) {
        return true;
      } //Pour le pion noir
    } //Fin else

    if (couleur == "Blanc") {
      if (colonne == (this.colonne + 1) ) {
         return true;
      } //Deuxième if
    } //Premier if

    else {
      if (colonne == (this.colonne - 1)) {
        return true;
      } // Pion noir
    }//Fin else

  } // Fin méthode

  public boolean verifCavalier(int ligne,int colonne){
    if (verifHorsMap() == false) return false;

    if (colonne ==(this.colonne + 2) && ligne == (this.ligne + 1)) return true;
    if (colonne ==(this.colonne + 2) && ligne == (this.ligne - 1)) return true;
    if (colonne ==(this.colonne - 2) && ligne == (this.ligne + 1)) return true;
    if (colonne ==(this.colonne - 2) && ligne == (this.ligne - 1)) return true;
  }
  
  public boolean verificationFou(int ligne, int colonne) {
        if (Math.abs(ligne) == Math.abs(colonne)) return true;
        if (verifColonne() || verifLigne() == true) return true;
    }

}
