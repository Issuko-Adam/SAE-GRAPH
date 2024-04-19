package main.java.graphe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheLAdj extends Graphe {

    private Map<String, List<String>> listeAdjacence;
    private Map<String, Map<String, Integer>> valuations;

    public GrapheLAdj(){
        listeAdjacence=new HashMap<>();
        valuations=new HashMap<>();
    }
    
    @Override
    public void ajouterSommet(String noeud) {
        if (!listeAdjacence.containsKey(noeud)) {
            listeAdjacence.put(noeud, new ArrayList<>());
            valuations.put(noeud, new HashMap<>());
        }
    }

    public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur < 0){
            throw new IllegalArgumentException("La valeur ne doit pas être négatives : " + valeur);
        }

        if (contientArc(source, destination)){
            throw new IllegalArgumentException("L'arc (" + source + "," + destination + ") existe déjà entre les deux sommets");
        }
        
        ajouterSommet(source);
        ajouterSommet(destination);

        listeAdjacence.get(source).add(destination);
        valuations.get(source).put(destination, valeur);
    }

    @Override
    public void oterSommet(String noeud) {
        listeAdjacence.remove(noeud);
        valuations.remove(noeud);
        // Supprimer les arcs sortants de ce sommet
        for (List<String> adj : listeAdjacence.values()) {
            adj.remove(noeud);
        }
    }


    @Override
    public void oterArc(String source, String destination) {
        if(!contientArc(source,destination)){
            throw new IllegalArgumentException("Aucun arc existe entre les sommets : " + source + "et" + destination);
        }
        
        if (listeAdjacence.containsKey(source)) {
            listeAdjacence.get(source).remove(destination);
            valuations.get(source).remove(destination);
        }

        else{
            throw new IllegalArgumentException("Sommet source et/ou sommet de destination introuvable : (" + source + ", " + destination + ")");
        }
    }

    @Override
    public List<String> getSommets() {
        /*keySet() permet de reprendre toutes les clés de notre hashmap
            on fait ensuite une new ArrayList pour pouvoir retourner une liste et pas un set (on convertie)
         */
        return new ArrayList<>(listeAdjacence.keySet());
    }

    @Override
    public List<String> getSucc(String sommet) {
        return listeAdjacence.get(sommet);
    }

    @Override
    public int getValuation(String src, String dest) {
        if (valuations.containsKey(src) && valuations.get(src).containsKey(dest)) {
            return valuations.get(src).get(dest);
        }
        return -1; // Valeur par défaut si l'arc n'existe pas ou si la valuation est absente
    }

    @Override
    public boolean contientSommet(String sommet) {
        return listeAdjacence.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        if (listeAdjacence.containsKey(src)) {
            List<String> successeurs = listeAdjacence.get(src);
            if (successeurs != null && successeurs.contains(dest)) {
                return true;
            }
        }
        return false;
    }
}

