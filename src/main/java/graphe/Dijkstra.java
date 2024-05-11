package main.java.graphe;

import java.util.Map;

public class Dijkstra {
    public static void dijkstra(IGraphe g, String source, Map<String, Integer> dist, Map<String, String> prev) {
        // Initialisation des distances et des précédents
        for (String sommet : g.getSommets()) {
            dist.put(sommet, Integer.MAX_VALUE);
            prev.put(sommet, null);
        }
        dist.put(source, 0);

        // Initialisation de l'ensemble des sommets non traités
        while (!tousTraites(g, dist)) {
            // Recherche du sommet non traité avec la plus petite distance
            String u = sommetNonTraiteAuPlusPetitDist(g, dist);

            // Pour chaque voisin v du sommet sélectionné
            for (String v : g.getSucc(u)) {
                int alt = dist.get(u) + g.getValuation(u, v);
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                }
            }
        }
    }

    // Vérifie si tous les sommets ont été traités
    private static boolean tousTraites(IGraphe g, Map<String, Integer> dist) {
        for (String sommet : g.getSommets()) {
            if (dist.get(sommet) == Integer.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    // Trouve le sommet non traité avec la plus petite distance
    private static String sommetNonTraiteAuPlusPetitDist(IGraphe g, Map<String, Integer> dist) {
        String minSommet = null;
        int minDist = Integer.MAX_VALUE;
        for (String sommet : g.getSommets()) {
            if (dist.get(sommet) < minDist) {
                minDist = dist.get(sommet);
                minSommet = sommet;
            }
        }
        return minSommet;
    }
}
