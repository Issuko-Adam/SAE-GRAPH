package main.java.graphe;

import java.util.*;

public class Dijkstra {
    public static void dijkstra(IGraphe g, String source, Map<String, Integer> dist, Map<String, String> prev) {
        // initialise les structures de donnees
        PriorityQueue<String> queue = new PriorityQueue<>();
        Set<String> visite = new HashSet<>();

        // initialise les distances et la file
        for (String sommet : g.getSommets()) {
            dist.put(sommet, Integer.MAX_VALUE);
            prev.put(sommet, null);
        }
        dist.put(source, 0);
        queue.add(source);

        while (!queue.isEmpty()) {
            String u = queue.poll();
            if (!visite.add(u)) {
                continue; // nœud a déjà visite passe au suivant
            }

            // met a jour les distances des sommets voisins
            for (String v : g.getSommets()) {
                if (g.contientArc(u, v)) {
                    int valuation = g.getValuation(u, v);
                    int distsommet = dist.get(u) + valuation;
                    if (distsommet < dist.get(v)) {
                        dist.put(v, distsommet);
                        prev.put(v, u);
                        queue.add(v);
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
