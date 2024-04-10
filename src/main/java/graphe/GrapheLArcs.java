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
        if (contientSommet(noeud)){
            throw new IllegalArgumentException("Le sommet est déjà présent dans le graphe : " + noeud);
        }

        LSommet.add(noeud);
    }

    public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur < 0){
            throw new IllegalArgumentException("La valeur ne doit pas être négative : " + valeur);
        }

        if (contientArc(source, destination)){
            throw new IllegalArgumentException("L'arc (" + source + "," + destination + ") existe déjà entre les deux sommets");
        }

        LArcs.add(new Arc(source, destination, valeur));
    }

    @Override
    public void oterSommet(String noeud) {
        if (!contientSommet(noeud)){
            throw new IllegalArgumentException("Le sommet " + noeud + "n'existe pas");
        }

        else {
            for (String s : LSommet){
                //retire tous les arc predecesseurs/successeurs de noeud
                oterArc(noeud,s);
                oterArc(s,noeud);
            }

            LSommet.remove(noeud);
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        if(!contientArc(source,destination)){
            throw new IllegalArgumentException("L'arc (" + source + "," + destination +") n'existe pas");
        }

        else {
            for(Arc a : LArcs){
                if (a.getSource().equals(source) && a.getDestination().equals(destination)){
                    LArcs.remove(a);
                }
            }

            throw new IllegalArgumentException("Sommet source et/ou sommet de destination introuvable : (" + source + ", " + destination + ")");
        }
    }

    @Override
    public List<String> getSommets() {
        return LSommet;
    }

    @Override
    public List<String> getSucc(String sommet) {
        if(!contientSommet(sommet)){
            throw new IllegalArgumentException("Le sommet " + sommet + "n'existe pas");
        }

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
        if (!contientArc(src, dest)){
            throw new IllegalArgumentException("L'arc (" + src + "," + dest + ") n'existe pas");
        }

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
