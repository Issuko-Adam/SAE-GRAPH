package main.java.graphe;

import java.util.*;

public class Dijkstra {
    public static void dijkstra(IGraphe g, String source, Map<String, Integer> dist, Map<String, String> prev) {
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        // initialise les distances et la file
        for (String noeud : g.getSommets()) {
            dist.put(noeud, Integer.MAX_VALUE);
            prev.put(noeud, null);
        }
        dist.put(source, 0);
        queue.add(source);

        while (!queue.isEmpty()) {
            String noeudactuel = queue.poll();
            int currentDistance = dist.get(noeudactuel);

            // sdistance actuelle est infinie, sort de la boucle
            if (currentDistance == Integer.MAX_VALUE) {
                break;
            }

            // parcourir les successeurs du noeud actuel
            for (String successeur : g.getSucc(noeudactuel)) {
                int newDistance = currentDistance + g.getValuation(noeudactuel, successeur);
                if (newDistance < dist.get(successeur)) {
                    dist.put(successeur, newDistance);
                    prev.put(successeur, noeudactuel);
                    queue.add(successeur);
                }
            }
        }

        // Supprimer les nœuds inaccessibles (distances infinies)
        dist.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);
    }
}
