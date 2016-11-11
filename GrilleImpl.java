/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grille;

/**
 * @author Ayrakou
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrilleImpl implements grille.Grille{

    public static final int N=9;
    private int[][] grille;

    public GrilleImpl() {
       this.grille = new int [N][N];
    }
    /**
    * Methode pour lire la grille a partir d'un fichier
    * @param fichier
    **/
    public void readGrille(String Fichier) {
       int[][] input=new int [N][N];
    try
    {
        File f = new File (Fichier);
        FileReader fr = new FileReader (f);
        BufferedReader br = new BufferedReader (fr);

        try
        {
            String line = br.readLine();
            int i=0;
            System.out.println();
            System.out.println ("AFFICHAGE DE LA GRILLE BRUTE FOURNIE");
            System.out.println();
            while (line != null)
            {
            	/*Dans cette boucle, nous n'allons traiter que les lignes dont le nombre de caractère
            	dépasse au moins 2; ceci pour éviter les lignes qui ne contiennent que "{" ou "}"
            	*/
            	if(line.trim().length()>2){
            		System.out.println (line);
            		/*
            		 * Boucle de parcours des colonnes suivant la ligne de boucle
            		 * La fonction split() retourne un tableau d'éléments obtenus grace au séparateur du split
            		 * Si un quelconque élément du la ligne a une longueur > 1, cela voudra dire que cet élément
            		 * se trouve à une extrémité; et donc associé d'au moins un { ou } et éventuellement un ; qu'on
            		 * doit enlever
            		 */
                    for (int j=0;j<line.trim().split(",").length;j++){
                		String elem =line.trim().split(",")[j];
                		if(j==0 && elem.length()>1) elem = elem.trim().substring(elem.length()-1);
                		if(j==(line.trim().split(",").length-1) && elem.length()>1) elem = elem.trim().substring(0,1);
                		input[i][j]=Integer.parseInt(elem);
                		//System.out.println (i+" et "+j+" = "+input[i][j]);
                	}
                    i++;
            	}
                line = br.readLine();

            }
            grille=input;
            br.close();
            fr.close();
            System.out.println();
            System.out.println ("ATTENTE D'AFFICHAGE DU RESULTAT DE LA GRILLE BRUTE FOURNIE . . .");
            System.out.println();

        }
        catch (IOException exception)
        {
            System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
        }
    }
    catch (FileNotFoundException exception)
    {
        System.out.println ("Le fichier n'a pas été trouvé");
    	//System.out.println ("CHARGEMENT D'UNE GRILLE VIDE REMPLIE DE 0");
    	System.out.println ();
        affiche(grille, "CHARGEMENT D'UNE GRILLE VIDE REMPLIE DE 0");
        verificateurValide(grille, 0);
    	System.out.println ();
        //System.out.println ("VOICI UNE POSSIBILITE D'AFFICHAGE DU SOLVEUR DE SUDOKU");
        affiche(grille, "VOICI UNE POSSIBILITE D'AFFICHAGE DU SOLVEUR DE SUDOKU");
    }

	}

	/**
	* Vérifie si la grille donnée est valide pour le jeu du sudoku, i.e ne content pas de doublons sur les lignes.
	* @param grille
	**/
    public void checkligne(int n, int[][] grille, int i) { // verifie si il n'y pas de repétition sur la ligne i pour le chiffre n
        int doublon = 0;
        int col = 0;
    	for (int j = 0; j < 9; j++) {
            if (grille[i][j] == n) {
                //return false;
                doublon++;
                col = j;
            }
        }
        //return true;
    	if(doublon >1){
    		System.out.println ("Doublon retrouvé sur la ligne "+(i+1)+" Colonne "+(col+1)+" : Nombre "+n+" chargé "+doublon+" fois");
    	}
    }

    /**
    * Vérifie si la grille donnée est valide pour le jeu du sudoku, i.e ne content pas de doublons sur les colonnes.
    * @param grille
    **/
    public void checkcol(int n, int[][] grille, int j) { // verifie si il n'a pas de doublon sur la colonne j pour le chiffre n
        int doublonCol = 0;
        int li = 0;
        for (int i = 0; i < 9; i++) {
            if (grille[i][j] == n) {
                doublonCol++;
                li = i;
            }
        }
        //return true;
    	if(doublonCol >1){
    		System.out.println ("Valeur dupliquée sur la Colonne "+(j+1)+" à la ligne "+(li+1)+" : Le nombre "+n+" retrouvé "+doublonCol+" fois");
    	}
    }

	/**
	* verifie s'il n'existe pas de doublon dans la zone délimitée par i et j pour le chiffre n.
	* @param grille
	* @param n
	* @param i
	* @param j
	**/
    public void checkzone(int n, int[][] grille, int i, int j) {
        int w = i - (i % 3), z = j - (j % 3);
        int doublonZone = 0;
        for (i = w; i < w + 3; i++) {
            for (j = z; j < z + 3; j++) {
                if (grille[i][j] == n) {
                	doublonZone++;
                }
            }
        }
    	if(doublonZone >1){
    		System.out.println ("Données de Zone dupliquées -> Colonne "+(z+1)+" -> ligne "+(w+1)+" : Le nombre "+n+" retrouvé "+doublonZone+" fois dans la zone");
    	}
    }

	/**
	* verifie si la grille est valide en parcourant lignes, colonnes et zones.
	* @param grille
	**/
    @Override
    public void grilleValide(int[][] grille, int position) {
        int i,j;
        System.err.println("");
        System.err.println("");
    	boolean consigne = true;
        for (i = 0; i < 9; i++) {
            for (j = 1; j <= 9; j++) {
            	checkligne(j, grille, i);
            	checkcol(j, grille, i);
            	checkzone(j, grille, i, j-1);
            	if(verificateurZoneBol(j, grille, i, j-1)==false)
            		consigne = false;
            }
        }
        if(consigne) System.err.println ("Félicitation ! Vous avez réussi le solveur de sudoku");

    }

	/**
	* @param grille
	* @param titre, le titre d'un affichage
	*/
    public void affiche( int [][] grille, String titre) {
        int k = 0;
        System.err.println("");
        System.err.println("");
    	System.err.println (titre);
    	System.out.println ();
        for (int i = 0; i < 9; i++) {
            int n = 0;
            if (k % 3 == 0) {
                System.err.print("\n");
            }
            k++;
            for (int j = 0; j < 9; j++) {
                n++;
                System.err.print(" " + grille[i][j]);
                if (n % 3 == 0) {
                    System.err.print(" ");
                }
                if (n == 9) {
                    System.err.println("");
                }
            }
        }
        System.err.print("--------------------");
    }

    /**
	* LES FONCTIONS BOOLEENNES DE VERIFICATION
	*
	* Fonction booleene de verication de ligne.
	* @param grille
	* @param n, le nombre dont on verifie la répétition
	* @param i, la ligne sur laquelle on verifie la repetition du nombre n
	*/
    public boolean verificateurLigne(int n, int[][] grille, int i) { // verifie si il n'y pas de repétition sur la ligne i pour le chiffre n
        for (int j = 0; j < 9; j++) {
            if (grille[i][j] == n) {
                return false;
            }
        }
        return true;
    }

    /**
	* Fonction booleene de verication de colonne.
	* @param grille
	* @param n, le nombre dont on verifie la répétition
	* @param j, la colonne sur laquelle on verifie la repetition du nombre n
	*/
    public boolean verificateurColonne(int n, int[][] grille, int j) { // verifie si il n'a pas de doublon sur la colonne j pour le chiffre n
        for (int i = 0; i < 9; i++) {

            if (grille[i][j] == n) {
                return false;
            }
        }
        return true;
    }

    /**
	* Fonction booleene de verication de zone.
	* @param grille
	* @param n, le nombre dont on verifie la répétition
	* @param i, la ligne sur laquelle on verifie la repetition du nombre n
	* @param j, la colonne sur laquelle on verifie la repetition du nombre n
	*/

    public boolean verificateurZone(int n, int[][] grille, int i, int j) { // verifie si il n' a pas de doublon dans la zone délimité par i et j pour le chiffre n.
        int w = i - (i % 3), z = j - (j % 3);

        for (i = w; i < w + 3; i++) {
            for (j = z; j < z + 3; j++) {
                if (grille[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
	* Fonction booleene de verication de zone.
	* @param grille
	* @param n, le nombre dont on verifie la répétition
	* @param i, la ligne sur laquelle on verifie la repetition du nombre n
	* @param j, la colonne sur laquelle on verifie la repetition du nombre n
	*/
    public boolean verificateurZoneBol(int n, int[][] grille, int i, int j) { // verifie si il n' a pas de doublon dans la zone délimité par i et j pour le chiffre n.
        int w = i - (i % 3), z = j - (j % 3);
        int doublonZone = 0;
        for (i = w; i < w + 3; i++) {
            for (j = z; j < z + 3; j++) {
                if (grille[i][j] == n) {
                	doublonZone++;
                }
            }
        }
    	if(doublonZone >1){
    		return false;
    	}
        else {
        	return true;
        }
    }

    /**
	* Fonction booleene de verication de la validation de la grille.
	* @param grille
	*/
    public boolean verificateurValide(int[][] grille, int position) {

        if (position == 9 * 9) {        // si on est à la position 81 il renvoie vraie (on fini de remplir le sudoku)
            return true;
        }

        int i = position / 9, j = position % 9;    // i la ligne = partie entière de la division & j la colonne = le reste de la division ( position [0 .....81]

        if (grille[i][j] != 0) {             // si il existe déjà un nombre à cette position on passe à la position suivante
            return verificateurValide(grille, position + 1);
        }

        for (int k = 1; k <= 9; k++) {

        	// le nombre choisi (k) n'exite pas sur la colonne ni sur la ligne ni dans la zone ont peut l'inserer à la position i j
            if (verificateurLigne(k, grille, i) && verificateurColonne(k, grille, j) && verificateurZone(k, grille, i, j)) {

                grille[i][j] = k;

                if (verificateurValide(grille, position + 1)) {
                    return true;
                }
            }

        }
        // Tous les chiffres ont été testés, aucun n'est bon, on réinitialise la case et on retourne false
        grille[i][j] = 0;
        return false;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrilleImpl grilleimpl = new GrilleImpl();
        grilleimpl.readGrille("C:/fichier_sudoku.txt");
        grilleimpl.grilleValide(grilleimpl.grille, 0);
        grilleimpl.verificateurValide(grilleimpl.grille, 0);
        grilleimpl.affiche(grilleimpl.grille,"GRILLE FOURNIE FORMATEE");
    }

    @Override
    public int getDimension() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValue(int x, int y, char value) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public char getValue(int x, int y) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean complete() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean possible(int x, int y, char value) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
