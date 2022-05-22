# TP 1 - Jeu de Poker (Fiche de réponses)

  - Auteur : Vincent, Bray (`BRAV20069009`)
  - Date de remise : 29/05/2022
  - Estimation du temps de travail passé sur le projet : X heures.

## Réponses aux questions  
 
Les tailles de réponses sont données à titre indicatif, mais il est clair qu'une question sur quinze (15) points attends plus de matière dans la réponse qu'une question sur cinq (5). Ne faites pas un roman, soyez direct et allez droit au but dans votre argumentation.
 
### Question 1: Évolution du code légataire

1. Pour implémenter de nouvelles combinaisons dans le code, je commencerais par créer une classe *Combinaison*. Ensuite pour ajouter de nouvelles combinaisons, je peux créer de nouvelles classes qui héritent de celle-ci et qui contiennent la logique d'affaire de la combinaison représentée par la classe. Par exemple, la classe *Brelan* hériterait de la classe *Combinaison*. Une classe *Verificateur* pourrait contenir un tableau contenant de multiples objets *Combinaison* et vérifier si les combinaisons se retrouvent dans une main.
---
2. Pour pouvoir arbitrer des parties à plus de deux joueurs, je commencerais par créer une classe *Joueur* et une classe *Main*. Chaque objet *Joueur* contiendrait donc un objet *Main*. Cette main contiendrait quant à elle de multiples objets *Carte*. Dépendant de l'entrée donner au programme, le bon nombre de joueur seront créés lors de l'invocation de celui-ci, à la suite de quoi, la logique d'affaire sera appliquée sur la main de chaque joueur.

### Question 2: Analyse des défauts du code légataire

1. Obsession des primitives: La majorité des concepts de la logique d'affaires sont exprimés dans le code sous forme de primitives. Par exemple, la main du joueur n'est pas un objet *Main* mais simplement un tableau de *String*.
---
2. Mauvaise nomenclature: Le nom de plusieurs variables et fonctions n'exprime pas correctement ce qu'elles représentent ou ce qu'elles font. Par exemple, les variables *p1* et *p2* qui représentent les mains du premier joueur et du deuxième joueur.
---
3. Peu ou pas d'encapsulation: La majorité des concepts de la logique d'affaire ne sont pas encapsulés dans des classes. Ils sont simplement représentés dans le code de manière obscure sous forme de primitives. Par exemple, il serait mieux de créer une classe *Carte* pour encapsuler le concept de carte que de représenter les cartes sous forme de simple *String*. 
---
4. Mauvaise utilisation du retour de fonction: Le retour d'une fonction devrait idéalement toujours se trouver à la fin de celle-ci, ce qui n'est pas le cas dans le code fourni. De plus, il devrait n'y avoir qu'un seul retour par fonction. Par exemple, dans la fonction *findComb* il y a plusieurs retours de fonctions.
---
5. Logique d'affaire obscure: Les multiples étapes et concepts de la logique d'affaire ne sont pas immédiatement apparent lors de la lecture du code. Par exemple, dans la fonction *findComb* le vocabulaire utilisé ne permet pas directement de comprendre ce qui se passe en termes de logique d'affaire. Les seuls éléments qui nous aide à ces fins sont les commentaires à l'intérieur de la fonction, ce qui est aussi une mauvaise pratique.
---
6. Utilisation de valeurs *magiques*: Il y a plusieurs valeurs distinctes dans le code qui sont utilisés comme des valeurs *magiques* alors qu'il serait fort simple d'en faire des constantes. Par exemple, les multiples *String* écrits directement dans les arguments de la majorité des fonctions *System.out.println* du code. 

### Question 3: Justification des choix de conception

_Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum._

_Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum._

_Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum._

### Question 4: Évolution du code objet

_Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum._

## Auto-évaluation (optionnelle)

Vous êtes libre de faire l'exercice de vous auto-évaluer en remplissant la grille d'évaluation du projet ci-dessous.

| Élement         | Critère d'évaluation                       | Note  |
| :---:           | :---                                       | :---: |
|  _Questions_    | (#1) Évolution du code légataire           |  5/5  |
|                 | (#2) Analyse des défauts du code légataire | 10/10 |
|                 | (#3) Justification des choix de conception | /15   |
|                 | (#4) Évolution du code objet               | /5    |
|  _Modèles_      | Justesse & Pertinence de la conception     | /15   |
|                 | Cohérence inter-modèles                    | /5    |
|                 | Respect des principes de conception        | /15   |
|  _Code_         | Qualité du code Java et du dépôt Git       | /10   |
|                 | Cohérence du code avec les modèles         | /10   | 
|                 | Qualité des tests                          | /10   |  
| **Note Finale** |                                            | /100  | 

_Cette auto-évaluation permet au correcteur de vous donner une rétro-action plus personnalisée en pointant les critères sur lesquels vous vous sur-évaluez et ceux sur lesquels au contraire vous vous sous-évaluez._
