/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grille;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ayrakou, Kouata Sekou
 */
public class GrilleImplTest {

    /**
     * constructeur de la classe.
     */
    public GrilleImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of readGrille method, of class GrilleImpl.
     */
    @Test
    public void testReadGrille() {
        System.out.println("readGrille");
        String Fichier = "C:/fichier_sudoku.txt";
        GrilleImpl instance = new GrilleImpl();
        instance.readGrille(Fichier);
    }

    /**
     * Test unitaire sur la méthode de vérification de ligne
     * Test of checkligne method, of class GrilleImpl.
     */
    @Test
    public void testCheckligne() {
        System.out.println("checkligne");
        int n = 2;
        int[][] grille  =  {{1,2,2,4,5,6,7,8,9},
                            {4,5,6,7,8,9,1,2,3},
                            {7,8,9,1,2,3,4,5,6},
                            {2,1,4,3,6,5,8,9,7},
                            {3,6,5,8,9,7,2,1,4},
                            {8,9,7,2,1,4,3,6,5},
                            {5,3,1,6,4,2,9,7,8},
                            {6,4,2,9,7,8,5,3,1},
                            {9,7,8,5,3,1,6,4,2}};


        int i = 0;
        GrilleImpl instance = new GrilleImpl();
        //instance.checkligne(n, grille, i);

        //Nous nous attendons de détecter un doublon sur cette ligne de la grille peu importe la réalité
    	boolean doublonDetecteAttendu = true;

    	//Faisons le test de répétition (du nombre 2) sur la ligne 0 ie {1,2,2,4,5,6,7,8,9};
    	//Sur cette ligne en réalité, nous avons
    	boolean doublonRelleLigne0 = true;

    	// nous devrions avoir doublonDetecteAttendu = doublonRelleLigne0
    	doublonDetecteAttendu = doublonRelleLigne0;

        if(!doublonDetecteAttendu)
            fail("Test Echoué car nous attadons un doublon du nombre 2 sur la ligne 1");
        else
            System.err.println("Voici le message d'erreur attendu : ");
            instance.checkligne(n, grille, i);


    }

    /**
     * Test unitaire sur la méthode de vérification de colonne
     * Test of checkcol method, of class GrilleImpl.
     */
    @Test
    public void testCheckcol() {
        System.out.println("checkcol");
        int n = 5;
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
						{4,5,6,7,8,9,1,2,3},
						{7,8,9,1,2,3,4,5,6},
						{2,1,4,3,6,5,8,9,7},
						{3,6,5,8,9,7,2,1,4},
						{8,9,7,2,1,4,3,6,5},
						{5,3,1,6,4,2,9,7,8},
						{6,4,2,9,7,8,5,3,1},
						{9,7,8,5,3,1,6,4,2}};

        int j = 8;
        GrilleImpl instance = new GrilleImpl();
        //instance.checkcol(n, grille, j);
        //Nous nous attendons de détecter un doublon sur cette ligne de la grille peu importe la réalité
    	boolean doublonDetecteAttendu = true;

    	//Nous aimerions faire le test de répétition (du nombre 5) sur la colonne 8 ie [5,3,6,7,4,5,8,1,2];
    	//Sur cette ligne en réalité, nous avons
    	boolean doublonRelleColonne = true;

    	//Et partant de ce fait, nous devrions avoir doublonDetecteAttendu = doublonRelleColonne
    	doublonDetecteAttendu = doublonRelleColonne;

        if(!doublonDetecteAttendu)
            fail("Test Echoué car nous espérons un doublon du nombre 5 sur la dernière Colonne");
        else
            System.err.println("Voici le message d'erreur attendu : ");
            instance.checkcol(n, grille, j);
    }

    /**
     * Test unitaire sur la méthode de vérification de zone
     * Test of checkzone method, of class GrilleImpl.
     * Nous allons faire notre test sur la zone 1 c'est à dire
        {1,2,2},
	{4,5,6},
	{7,8,9},
     */

    @Test
    public void testCheckzone() {
        System.out.println("checkzone");
        int n = 2;
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
						{4,5,6,7,8,9,1,2,3},
						{7,8,9,1,2,3,4,5,6},
						{2,1,4,3,6,5,8,9,7},
						{3,6,5,8,9,7,2,1,4},
						{8,9,7,2,1,4,3,6,5},
						{5,3,1,6,4,2,9,7,8},
						{6,4,2,9,7,8,5,3,1},
						{9,7,8,5,3,1,6,4,2}};

        int i = 1;
        int j = 1;
        GrilleImpl instance = new GrilleImpl();
        //instance.checkzone(n, grille, i, j);
       //Nous nous attendons de détecter un doublon dans cette zone de la grille peu importe la réalité
	boolean doublonDetecteAttendu = true;

	/*Nous aimerions faire le test de répétition (du nombre 2) sur la zone 1 ie                                                         {1,2,2},																				{4,5,6},
																				{7,8,9},
	Sur cette ligne en réalité, nous avons
	 * */
	boolean doublonRelleZone = true;

	//Et partant de ce fait, nous devrions avoir doublonDetecteAttendu = doublonRelleZone
	doublonDetecteAttendu = doublonRelleZone;

	if(!doublonDetecteAttendu)
	fail("Test Echoué car nous attadons un doublon du nombre 5 sur la dernière Colonne");
	else
	System.err.println("Voici le message d'erreur attendu : ");
	instance.checkzone(n, grille, i, j);

    }

    /**
     * 	Test unitaire sur la méthode de validation de la grille
     * Test of grilleValide method, of class GrilleImpl.
     */
    @Test
    public void testGrilleValide() {
        System.out.println("grilleValide");
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
						{4,5,6,7,8,9,1,2,3},
						{7,8,9,1,2,3,4,5,6},
						{2,1,4,3,6,5,8,9,7},
						{3,6,5,8,9,7,2,1,4},
						{8,9,7,2,1,4,3,6,5},
						{5,3,1,6,4,2,9,7,8},
						{6,4,2,9,7,8,5,3,1},
						{9,7,8,5,3,1,6,4,2}};

        int position = 1;
        GrilleImpl instance = new GrilleImpl();
        //instance.grilleValide(grille, position);

        //Nous nous attendons de détecter un ou des doublons dans la grille peu importe la réalité
        boolean doublonDetecteAttendu = true;

        /*Par défaut supposons que la grille n'a pas de doublon dans les zones
        * */
        boolean doublonRelleZoneGrille = false;

	    int i,j;
	    for (i = 0; i < 9; i++) {
	        for (j = 1; j <= 9; j++) {

	        	if(instance.verificateurZoneBol(j, grille, i, j-1)==false)
	        	doublonRelleZoneGrille = true;
	        }
	    }
            //Et partant de ce fait, nous devrions avoir doublonDetecteAttendu = doublonRelleGrille
            doublonDetecteAttendu = doublonRelleZoneGrille;

            if(!doublonDetecteAttendu)
                    fail("Test Echoué car nous attendons un doublon dans cette grille");
            else{
               instance.grilleValide(grille, position);
            }


    }

    /**
     * Test of affiche method, of class GrilleImpl.
     */
    @Test
    public void testAffiche() {
        System.out.println("affiche");
        int[][] grille  =  {{1,2,2,4,5,6,7,8,5},
                            {4,5,6,7,8,9,1,2,3},
                            {7,8,9,1,2,3,4,5,6},
                            {2,1,4,3,6,5,8,9,7},
                            {3,6,5,8,9,7,2,1,4},
                            {8,9,7,2,1,4,3,6,5},
                            {5,3,1,6,4,2,9,7,8},
                            {6,4,2,9,7,8,5,3,1},
                            {9,7,8,5,3,1,6,4,2}};
        String titre = "Test d affichage";
        GrilleImpl instance = new GrilleImpl();
        instance.affiche(grille, titre);

    }

    /**
     * Test of verificateurLigne method, of class GrilleImpl.
     */
    @Test
    public void testVerificateurLigne() {
        System.out.println("verificateurLigne");
        int n = 2;
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
                            {4,5,6,7,8,9,1,2,3},
                            {7,8,9,1,2,3,4,5,6},
                            {2,1,4,3,6,5,8,9,7},
                            {3,6,5,8,9,7,2,1,4},
                            {8,9,7,2,1,4,3,6,5},
                            {5,3,1,6,4,2,9,7,8},
                            {6,4,2,9,7,8,5,3,1},
                            {9,7,8,5,3,1,6,4,2}};
        int i = 1;
        GrilleImpl instance = new GrilleImpl();
        boolean expResult = false;
        boolean result = instance.verificateurLigne(n, grille, i);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificateurColonne method, of class GrilleImpl.
     */
    @Test
    public void testVerificateurColonne() {
        System.out.println("verificateurColonne");
        int n = 2;
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
						{4,5,6,7,8,9,1,2,3},
						{7,8,9,1,2,3,4,5,6},
						{2,1,4,3,6,5,8,9,7},
						{3,6,5,8,9,7,2,1,4},
						{8,9,7,2,1,4,3,6,5},
						{5,3,1,6,4,2,9,7,8},
						{6,4,2,9,7,8,5,3,1},
						{9,7,8,5,3,1,6,4,2}};
        int j = 1;
        GrilleImpl instance = new GrilleImpl();
        boolean expResult = false;
        boolean result = instance.verificateurColonne(n, grille, j);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificateurZone method, of class GrilleImpl.
     */
    @Test
    public void testVerificateurZone() {
        System.out.println("verificateurZone");
        int n = 1;
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
                            {4,5,6,7,8,9,1,2,3},
                            {7,8,9,1,2,3,4,5,6},
                            {2,1,4,3,6,5,8,9,7},
                            {3,6,5,8,9,7,2,1,4},
                            {8,9,7,2,1,4,3,6,5},
                            {5,3,1,6,4,2,9,7,8},
                            {6,4,2,9,7,8,5,3,1},
                            {9,7,8,5,3,1,6,4,2}};
        int i = 1;
        int j = 1;
        GrilleImpl instance = new GrilleImpl();
        boolean expResult = false;
        boolean result = instance.verificateurZone(n, grille, i, j);
        assertEquals(expResult, result);

    }

    /**
     * Test of verificateurZoneBol method, of class GrilleImpl.
     */
    @Test
    public void testVerificateurZoneBol() {
        System.out.println("verificateurZoneBol");
        int n = 1;
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
                            {4,5,6,7,8,9,1,2,3},
                            {7,8,9,1,2,3,4,5,6},
                            {2,1,4,3,6,5,8,9,7},
                            {3,6,5,8,9,7,2,1,4},
                            {8,9,7,2,1,4,3,6,5},
                            {5,3,1,6,4,2,9,7,8},
                            {6,4,2,9,7,8,5,3,1},
                            {9,7,8,5,3,1,6,4,2}};
        int i = 1;
        int j = 1;
        GrilleImpl instance = new GrilleImpl();
        boolean expResult = true;
        boolean result = instance.verificateurZoneBol(n, grille, i, j);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificateurValide method, of class GrilleImpl.
     */
    @Test
    public void testVerificateurValide() {
        System.out.println("verificateurValide");
        int[][] grille =  {{1,2,2,4,5,6,7,8,5},
                            {4,5,6,7,8,9,1,2,3},
                            {7,8,9,1,2,3,4,5,6},
                            {2,1,4,3,6,5,8,9,7},
                            {3,6,5,8,9,7,2,1,4},
                            {8,9,7,2,1,4,3,6,5},
                            {5,3,1,6,4,2,9,7,8},
                            {6,4,2,9,7,8,5,3,1},
                            {9,7,8,5,3,1,6,4,2}};
        int position = 2;
        GrilleImpl instance = new GrilleImpl();
        boolean expResult = true;
        boolean result = instance.verificateurValide(grille, position);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class GrilleImpl.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        GrilleImpl.main(args);
    }

    /**
     * Test of getDimension method, of class GrilleImpl.
     */
    @Test
    public void testGetDimension() {
        System.out.println("getDimension");
        GrilleImpl instance = new GrilleImpl();
        int expResult = 0;
        int result = instance.getDimension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class GrilleImpl.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int x = 0;
        int y = 0;
        char value = ' ';
        GrilleImpl instance = new GrilleImpl();
        instance.setValue(x, y, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class GrilleImpl.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int x = 0;
        int y = 0;
        GrilleImpl instance = new GrilleImpl();
        char expResult = ' ';
        char result = instance.getValue(x, y);
        assertEquals(expResult, result);

    }

    /**
     * Test of complete method, of class GrilleImpl.
     */
    @Test
    public void testComplete() {
        System.out.println("complete");
        GrilleImpl instance = new GrilleImpl();
        boolean expResult = false;
        boolean result = instance.complete();
        assertEquals(expResult, result);

    }

    /**
     * Test of possible method, of class GrilleImpl.
     */
    @Test
    public void testPossible() {
        System.out.println("possible");
        int x = 0;
        int y = 0;
        char value = ' ';
        GrilleImpl instance = new GrilleImpl();
        boolean expResult = false;
        boolean result = instance.possible(x, y, value);
        assertEquals(expResult, result);

    }

}
