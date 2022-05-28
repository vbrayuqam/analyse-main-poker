# TP 1 - Jeu de Poker (Fiche de réponses)

  - Auteur : Vincent, Bray (`BRAV20069009`)
  - Date de remise : 29/05/2022
  - Estimation du temps de travail passé sur le projet : 16 heures.

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

1. J'ai créer plusieurs classes différentes pour représenter différents concepts qui me sont apparus en observant le problème. J'ai débuté par déterminer qu'il me fallait une classe *Carte* pour représenter l'élément de base du jeu de poker. Cette classe contient nécessairement deux classes énumératives pour représenter la couleur et la valeur des cartes. De plus, la classe contient un entier pour représenter le concept de force d'une carte lors de l'analyse des mains jouées. Ainsi, j'ai aussi créé une classe *Main* pour contenir les cartes. Ses mains sont détenues par des joueurs, donc j'ai aussi créé une classe *Joueur* qui contient la main et le nom d'un joueur. Cette architecture permet l'implémentation aisée d'un jeu à *n* joueurs. Comme mentionné plus haut j'ai créé une classe *Vérificateur* pour gérer les règles de l'analyse des mains. Nécessairement cela implique une classe *Combinaison*, celle-ci est une classe abstraite, les multiples classes représentant les combinaisons différentes héritent d'elle. J'ai créé une classe similaire nommée *GestionnaireErreur* qui contient la logique d'affaire de gestion des erreurs dans les mains données. Pour simplifier le code, j'ai aussi créé une classe *ÉtatDeJeu* qui représente la validité du jeu et une classe *Language* qui contient mes constantes de texte.
---
2. Mon code respecte le principe de responsabilité unique card chaque concept identifié encapsule la logique d'affaire qui lui est propre. Ainsi, un joueur n'est qu'un joueur et ne faire que ce qu'un joueur peut faire. De même, le vérificateur s'occupe d'analyser et de comparer alors que le gestionnaire d'erreurs lui ne gère que les erreurs. Mon code respecte le principe de substitution de liskov. Chaque méthode appelé par mes sous-classes sont définies par les classes dont elles héritent. De plus, les types statiques utilisé sont ceux de leurs généralisation, par exemple: *Flush* est contenu dans une variable *Combinaison* et mes listes chainées sont contenu dans des variables typées comme étant simplement une liste.
---
3. Mon code pourrait nécessairement être amélioré. Je crois qu'une partie de la logique d'affaire contenu par le vérificateur pourrait être déleguer aux combinaisons elles-mêmes. Je crois que si je m'y attardais plus longtemps je pourrait trouver une solution plus simple et élégante que la notion actuelle de *force* pour comparer les mains. Je crois pouvoir rendre le code plus clair avec encore plus de réusinage.

### Question 4: Évolution du code objet

Pour ajouter le brelan dans ma conception il suffit de créer une sous-classe de *Combinaison* qui représente un brelan. Par contre, avec ma conception actuelle la logique d'affaire pour reconnaitre un brelan devra être implémentée dans la classe *Vérificateur*, donc ma conception ne respecte que partiellement le principe Ouvert/Fermé. Comme cité plus haut, c'est une des facettes sur laquelle ma conception pourrait être retravaillée.

## Auto-évaluation (optionnelle)

Vous êtes libre de faire l'exercice de vous auto-évaluer en remplissant la grille d'évaluation du projet ci-dessous.

| Élement         | Critère d'évaluation                       | Note  |
| :---:           | :---                                       | :---: |
|  _Questions_    | (#1) Évolution du code légataire           |  5/5  |
|                 | (#2) Analyse des défauts du code légataire | 10/10 |
|                 | (#3) Justification des choix de conception | 15/15 |
|                 | (#4) Évolution du code objet               |  5/5  |
|  _Modèles_      | Justesse & Pertinence de la conception     | 11/15 |
|                 | Cohérence inter-modèles                    |  5/5  |
|                 | Respect des principes de conception        | 11/15 |
|  _Code_         | Qualité du code Java et du dépôt Git       |  8/10 |
|                 | Cohérence du code avec les modèles         |  8/10 | 
|                 | Qualité des tests                          |  8/10 |  
| **Note Finale** |                                            | 86/100| 

_Cette auto-évaluation permet au correcteur de vous donner une rétro-action plus personnalisée en pointant les critères sur lesquels vous vous sur-évaluez et ceux sur lesquels au contraire vous vous sous-évaluez._
