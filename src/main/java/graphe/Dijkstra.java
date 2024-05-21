package main.java.graphe;

import java.util.*;

public class Dijkstra {
    public static void dijkstra(IGraphe g, String source, Map<String, Integer> dist, Map<String, String> prev) {
        // initialise les structures de données
        Set<String> visite = new HashSet<>();
        TreeMap<Integer, String> file = new TreeMap<>();

        // initialise les distances et la file
        for (String sommet : g.getSommets()) {
            dist.put(sommet, Integer.MAX_VALUE);
            prev.put(sommet, null);
        }

        dist.put(source, 0);
        file.put(0, source);

        while (!file.isEmpty()) {
            // extrait le sommet avec la plus petite distance
            Map.Entry<Integer, String> entree = file.pollFirstEntry();
            String u = entree.getValue();

            if (!visite.add(u)) {
                continue; // nœud deja visite passe au suivant
            }

            // met a jour les distances des sommets voisins
            for (String v : g.getSommets()) {
                if (g.contientArc(u, v)) {
                    int poids = g.getValuation(u, v);
                    int distsommet = dist.get(u) + poids;
                    if (distsommet < dist.get(v)) {
                        dist.put(v, distsommet);
                        prev.put(v, u);
                        file.put(distsommet, v);
                    }
                }
            }
        }

        for (String noeud : g.getSommets())
            if (dist.get(noeud)==Integer.MAX_VALUE){
                dist.remove(noeud);
            }
    }
}
