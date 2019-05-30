public class VerificationCoup {

  private int colonne; //colonne du l'échiquier
  private int ligne; //ligne de l'echiquier
  private String couleur; //couleur des pions blanc ou noir
  private int tourDeJeu; //compteur du tour de jeu

  public boolean verifHorsMap (int ligne, int colonne) {
    return ( ligne > 8 || colonne > 8 || ligne < 0 || colonne < 0);
  }

  public boolean verifColonne(int colonne) {
    return (ligne == this.ligne);
  }

  public boolean verifLigne(int ligne) {
    return (colonne == this.colonne);
  }

  public boolean verifTour(int ligne, int colonne) {
    if (verifHorsMap(ligne,colonne) == false) return false;
    if (verifColonne(colonne) || verifLigne(ligne) == true) return true;
    else return false;
  } //Fin methode

  public boolean VerifPion(int ligne, int colonne) {
    if (verifHorsMap(ligne,colonne) == false) return false;

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
    return false;
  } // Fin méthode

  public boolean verifCavalier(int ligne,int colonne){
    if (verifHorsMap(ligne,colonne) == false) return false;

    if (this.ligne == Math.abs(ligne - 1) && this.colonne == Math.abs(colonne - 2)) return true;
    if (this.ligne == Math.abs(ligne + 1) && this.colonne == Math.abs(colonne + 2)) return true;

    return false;
  }

  public boolean verificationFou(int ligne, int colonne) {
      if (Math.abs(ligne) == Math.abs(colonne)) return true;
      if (verifColonne() || verifLigne() == true) return true;
  }

}

