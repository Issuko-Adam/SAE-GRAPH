package main.java.graphe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrapheLArcs extends Graphe{
    private ArrayList<Arc> LArcs; //liste des arcs
    private ArrayList<String> LSommet; //liste des sommets
    
    public GrapheLArcs(){
        LArcs=new ArrayList<>();
        LSommet=new ArrayList<>();
    }

    @Override
    public void ajouterSommet(String noeud) {
        if (!LSommet.contains(noeud)) {
            LSommet.add(noeud);
        }
    }

    public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur < 0){
            throw new IllegalArgumentException("La valeur ne doit pas être négatives : " + valeur);
        }

        if (contientArc(source, destination)){
            throw new IllegalArgumentException("L'arc (" + source + "," + destination + ") existe déjà entre les deux sommets");
        }

        LArcs.add(new Arc(source, destination, valeur));
    }

    @Override
    public void oterSommet(String noeud) {
        if (contientSommet(noeud)) {
            //Liste des arcs a supprimer
            List<Arc> arcsASupprimer = new ArrayList<>();

            //Trouve et stocke les arcs à supprimer
            for (Arc a : LArcs) {
                if (noeud.equals(a.getSource()) || noeud.equals(a.getDestination())) {
                    arcsASupprimer.add(a);
                }
            }

            //Supprime les arcs stockés
            LArcs.removeAll(arcsASupprimer);
            //Supprime le sommet dans la liste
            LSommet.remove(noeud);
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        boolean arcTrouve = false;

        if (contientArc(source, destination)) {
            for (Arc a : LArcs) {
                if (a.getSource().equals(source) && a.getDestination().equals(destination)) {
                    LArcs.remove(a);
                    arcTrouve = true;
                    break;
                }
            }

            // Si aucun arc n'est trouvé après avoir parcouru tous les arcs
            if (!arcTrouve) {
                throw new IllegalArgumentException("Aucun arc existe entre les sommets : " + source + " et " + destination);
            }
        }

        else {
            throw new IllegalArgumentException("Sommet source et/ou sommet de destination introuvable : (" + source + ", " + destination + ")");
        }
    }

    @Override
    public List<String> getSommets() {
        for (Arc a : LArcs) {
            String source = a.getSource();
            String destination = a.getDestination();

            //Ajoute les sommets s'ils ne sont pas déjà présents dans la liste
            if (!LSommet.contains(source)) {
                LSommet.add(source);
            }
            if (!LSommet.contains(destination)) {
                LSommet.add(destination);
            }
        }
        return LSommet;
    }

    @Override
    public List<String> getSucc(String sommet) {
        List<String> Succ = new ArrayList<>();

        for (Arc a : LArcs){
            if (a.getSource().equals((sommet))){
                Succ.add(a.getDestination());
            }
        }
        return Succ;
    }

    @Override
    public int getValuation(String src, String dest) {
        for (Arc a : LArcs) {
            if (a.getSource().equals(src) && a.getDestination().equals(dest)) {
                return a.getValuation();
            }
        }
        return -1; //pas d'arc entre les deux
    }

    @Override
    public boolean contientSommet(String sommet) {
        for (String s : LSommet){
            if(s.equals(sommet)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest) {
        for(Arc a : LArcs){
            if (a.getSource().equals(src) && a.getDestination().equals(dest)){
                return true;
            }
        }
        return false;
    }
}
