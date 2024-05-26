## Collaborateurs
- [<img src="https://avatars.githubusercontent.com/u/165828868?s=64&v=4" width="16" height="16"> Wu Mei-ling (@Mei-lingWu)](https://github.com/GGassiat)
- [<img src="https://avatars.githubusercontent.com/u/100547995?s=64&v=4" width="16" height="16"> Graindorge Adam (@Issuko-Adam)](https://github.com/Issuko-Adam)
- [<img src="https://avatars.githubusercontent.com/u/166369044?s=64&v=4" width="16" height="16"> Grajezyk Nathan (@NathanGRK)](https://github.com/NathanGRK)
- [<img src="https://avatars.githubusercontent.com/u/166443149?s=64&v=4" width="16" height="16"> Boutebakh Elias (@Elias951)](https://github.com/elias951)
## Chargé de TP
- [<img src="https://avatars.githubusercontent.com/u/128971727?v=4" width="16" height="16"> MR. Foughali(@kf-iut)](https://github.com/kf-iut)


# Partie I

- [x] **LArc**
  - On représente un graphe en stockant une liste d'arcs qui contiennent leurs sources, destinations et valuations.
  
- [x] **LAdj**
  - Chaque sommet est associé à une liste de ses successeurs. Donc pour tout sommet ou il y a un arc sortant.
  
- [x] **HHAdj**
  - On représente un graphe grâce à une hashmap d'hashmaps. Chaque sommet possède une map contenant les successeurs du sommet et leurs valuations.


# Partie II

Nous avons implémenté et validé les tests suivants pour l'algorithme Djikstra, en fonction des différents types de graphes :

### Dossier "Autres"

- **MAdj**
- **HHAdj**
- **LAdj**
- **LArc**

### Dossier "Orig" (en entier)

- **HHAdj**
- **LAdj**

### Dossier "Orig" (taille < 10 000)

- **MAdj** : Trop long

### Dossier "Orig" (taille < 100 000)

- **LArc** : Trop long

### Dossier "Barabasi" (en entier)

- **HHAdj**
- **LAdj**

### Dossier "Barabasi" (taille < 10 002)

- **MAdj**

### Dossier "Barabasi" (taille < 100 002)

- **LArcs**

### Dossier "Full"

- **LAdj**
- **HHAdj**
- **MAdj**

### Dossier "Full" (taille < 501)

- **LArc**

# Architecture

![architecture](https://github.com/Issuko-Adam/SAE-GRAPH/assets/100547995/9eb6e497-49ec-4eac-b7c4-b33634ba4925)

## Performances

- [performance.pdf](https://github.com/Issuko-Adam/SAE-GRAPH/files/15448207/performance.pdf)

