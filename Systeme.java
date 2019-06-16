import java.io.*;
import java.util.Scanner;

public class Systeme {
    private int lignePieceABouger;
    private int colonnePieceABouger;
    private int lignePiece;
    private int colonnePiece;
    private Echiquier e;
    private Scanner s = new Scanner(System.in);

    public Systeme() 
    {
        System.out.println("Voulez-vous charger une partie ?");
        String reponse = s.nextLine().toUpperCase();
        if (reponse.equals("OUI") || reponse.equals("O")) charger();
        else e = new Echiquier();
    }
    public Systeme(boolean b) {}

    public void demandeJoueur() 
    {
        boolean positionNonValide = true;
        s = new Scanner(System.in);
        while(positionNonValide)
        {
            System.out.println("Quel est la position de la pièce à jouer ? (si vous voulez quitter écrivez \"q\")");
            String str = s.nextLine().toUpperCase();
            if (!(str.isEmpty()))
            {
                char pc = str.charAt(0);
                if (Character.toString(pc).equals("Q"))  quitter();
                if(str.length()>1)
                {
                    this.lignePieceABouger = Character.getNumericValue(str.charAt(1))-1;
                    this.colonnePieceABouger = pc-65;
                    if(e.siPiecePresente(lignePieceABouger, colonnePieceABouger) && e.verifCouleur(lignePieceABouger, colonnePieceABouger)) 
                    {
                        System.out.println("Ou voulez-vous déplacer la pièce ?");
                        String strd = s.nextLine().toUpperCase();
                        if (!(strd.isEmpty())&& strd.length()>1)
                        {
                            char pcd = strd.charAt(0);
                            this.lignePiece = Character.getNumericValue(strd.charAt(1))-1;
                            this.colonnePiece = pcd-65;
                        }
                        if(lignePieceABouger==lignePiece && colonnePieceABouger==colonnePiece) System.out.println("Déplacement sur la même case \n");
                        else {
                            positionNonValide = !(bouger());
                        }
                    }
                }
            }
        }
    }

    public static String Pro()
    {
        String str = "";
        Scanner sc = new Scanner(System.in);
        while(str.isEmpty())
        {
            System.out.println("Pion à promouvoir, choisir entre R: \"Reine\", C: \"Cavalier\", T: \"Tour\", F: \"Fou\"" );
            str = sc.nextLine().toUpperCase();
        }
        return str;
    }

    public boolean bouger()
    {
        return e.bouger(lignePieceABouger,colonnePieceABouger,lignePiece,colonnePiece);
    }

    public void rafraichir()
    {
        System.out.println(e.affichage());
    }

    public void quitter() 
    {
        System.out.println("Voulez-vous sauvegarder votre partie ? (Quitter sans sauvegarder signifierai un abandon)");
        String reponse = s.nextLine().toUpperCase();
        if (reponse.equals("OUI") || reponse.equals("O")) sauver();
        s.close();
        System.out.println("Fin du programme...");
        System.exit(0);
    }
    public void sauver() 
    {
        try 
        {
            File fichier =  new File("echeq.ser") ;
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
            oos.writeObject(this.e);
            System.out.println("Sauvegarde partie...");
            oos.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

    public void charger() 
    {
    try 
    {
        File fichier =  new File("echeq.ser") ;
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
        Echiquier m = (Echiquier)ois.readObject();
        this.e = m;
        System.out.println("Chargement partie...");
        ois.close();
    } 
    catch (Exception e) 
    {
        System.out.println("Sauvegarde non trouvé ou corrompu, création d'une nouvelle partie..");
        this.e = new Echiquier();
    }
    }
    public void couleur()
    {
    System.out.println("Au tour du joueur de pièces "+ e.getCouleur() + " de jouer");
    }

    public boolean echec()
    {
        return e.getEnEchec();
    }
    /*public boolean mat()
    {
        return e.verifMAT();
    }

    public boolean pat()
    {
        return e.verifPAT();
    }*/

    public static void main(String[] args)
    {
        Systeme s = new Systeme();
        s.rafraichir();
        while(true)
        {
            s.couleur();
            //if(s.echec()) s.mat();
            //if(s.pat()) s.quitter();
            s.demandeJoueur();
            s.rafraichir();
        }
    }
    
}