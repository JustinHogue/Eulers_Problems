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
            return 2 * (longueur * largeur + largeur * hauteur + longueur * hauteur); // Calcul de la première couche
        }
        else {
            // On trouve de manière récursive le nombre de cubes pour une couche avec la ligne suivante
            return nombreDeCubes(longueur, largeur, hauteur, numeroDeCouche - 1) + 4 * (longueur + largeur + hauteur) + 8 * (numeroDeCouche - 2);
        }
    }

    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> C = new HashMap<Integer, Integer>(); // On se crée notre map contenant 50000 nombres de cubes différents
        for (int i = 0; i < 50000; i++) {
            C.put(i, 0);
        }
        for (int longueur = 1; longueur <= 5000; longueur++) {
            for (int largeur = 1; largeur <= longueur; largeur++) {
                for (int hauteur = 1; hauteur <= largeur; hauteur++) {
                    for (int n = 1; nombreDeCubes(longueur, largeur, hauteur, n) < C.size(); n++) {
                        int key = nombreDeCubes(longueur, largeur, hauteur, n); // La clé correspond au nombre de cubes
                        int value = C.get(key) + 1; // On incrémente de 1 le nombre de cas où le nombre de cubes est égal à celui vérifié
                        C.put(key, value); // On place le nouveau nombre de possibilités à l'emplacement du nombre de cubes trouvé
                    }
                }
            }
        }
        // On va maintenant chercher le premier cas où nous avons 1000 possibilités pour un nombre de cubes donné.
        for (int j = 0; j < C.size(); j++) {
            if (C.get(j) == 1000) {
                System.out.println(j);
                return;
            }
        }
    }
}
