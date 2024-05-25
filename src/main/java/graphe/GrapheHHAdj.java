package main.java.graphe;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class GrapheHHAdj extends Graphe {
    private Map<String, Map<String, Integer>> valeurs;

    public GrapheHHAdj() {
        valeurs = new HashMap<>();
    }

    public GrapheHHAdj(String str) {
        this();
        this.peupler(str);
    }

    @Override
    public void ajouterSommet(String noeud) {
        valeurs.putIfAbsent(noeud, new HashMap<>());
    }

    public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur < 0) {
            throw new IllegalArgumentException("Les valuations ne doivent pas être négatives: " + valeur);
        }
        valeurs.putIfAbsent(source, new HashMap<>());
        valeurs.putIfAbsent(destination, new HashMap<>());

        if (valeurs.get(source).containsKey(destination)) {
            throw new IllegalArgumentException("Un arc existe déjà entre les sommets : " + source + " et " + destination);
        }
        valeurs.get(source).put(destination, valeur);
    }

    @Override
    public void oterSommet(String noeud) {
        if (valeurs.containsKey(noeud)) {
            valeurs.remove(noeud);
            for (Map<String, Integer> edges : valeurs.values()) {
                edges.remove(noeud);
            }
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        if (valeurs.containsKey(source) && valeurs.get(source).containsKey(destination)) {
            valeurs.get(source).remove(destination);
        } else {
            throw new IllegalArgumentException("Aucun arc n'existe entre les sommets : " + source + " et " + destination);
        }
    }

    @Override
    public List<String> getSucc(String sommet) {
        List<String> successors = new ArrayList<>();
        if (valeurs.containsKey(sommet)) {
            successors.addAll(valeurs.get(sommet).keySet());
        }
        return successors;
    }

    @Override
    public List<String> getSommets() {
        List<String> vertices = new ArrayList<>(valeurs.keySet());
        Collections.sort(vertices);
        return vertices;
    }

    @Override
    public int getValuation(String src, String dest) {
        if (valeurs.containsKey(src) && valeurs.get(src).containsKey(dest)) {
            return valeurs.get(src).get(dest);
        }
        return 0;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return valeurs.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return valeurs.containsKey(src) && valeurs.get(src).containsKey(dest);
    }
}

