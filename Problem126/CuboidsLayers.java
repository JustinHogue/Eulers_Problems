/**
 * \file CuboidsLayers.java
 * \brief Implantation d'un algo pour résoudre le problème de Euler #126.
 * \author Justin Hogue
 */

import java.util.*;

 /**
 * La classe CuboidsLayers fournit deux fonctions, la fonction main pour exécuter le programme et
 * une fonction pour calculer le nombre de cubes d'une certaine couche.
 */

public class CuboidsLayers {
    public static int nombreDeCubes(int longueur, int largeur, int hauteur, int numeroDeCouche){
        if (numeroDeCouche == 1) {
            return 2 * (longueur * largeur + largeur * hauteur + longueur * hauteur);
        }
        else {
            return nombreDeCubes(longueur, largeur, hauteur, numeroDeCouche - 1) + 4 * (longueur + largeur + hauteur) + 8 * (numeroDeCouche - 2);
        }
    }

    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> C = new HashMap<Integer, Integer>();
        for (int i = 0; i < 50000; i++) {
            C.put(i, 0);
        }
        for (int longueur = 1; longueur <= 5000; longueur++) {
            for (int largeur = longueur; largeur <= 5000; largeur++) {
                for (int hauteur = largeur; hauteur <= 5000; hauteur++) {
                    for (int n = 1; nombreDeCubes(longueur, largeur, hauteur, n) < C.size(); n++) {
                        int key = nombreDeCubes(longueur, largeur, hauteur, n);
                        int value = C.get(key) + 1;
                        C.put(key, value);
                    }
                }
            }
        }
        for (int j = 0; j < C.size(); j++) {
            if (C.get(j) == 1000) {
                System.out.println(j);
                return;
            }
        }
    }
}
