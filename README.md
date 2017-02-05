# EtuNotesAbssences

## Principe de fonctionnement

* `/src/projet/Component`: Elements de base utilisé par l'application
* `/src/projet/Controller`: Regroupe tous les contrôleurs de l'application
* `/src/projet/Entity`: Regroupe toutes les entitées de l'application
* `/src/projet/Entity/DAO`: Regroupe tous les DAOs de l'application
* `/src/projet/Entity/Data`: Regroupe tous les fichiers de données (SQL) de l'application
* `/src/projet/Filter`: Regroupe tous les filtres de l'application

#### Contrôleur
Chaque contrôleur hérite de `BaseController`. Celui-ci regroupe le fonctionnement général et méthodes utilisé par tous les contrôleurs

Chaque entité dispose de son propre contrôleur pour y effectuer ses propres actions

Un contrôleur n'est accessible que si il passe par le `FrontalController`. Il analyse et redirige vers le contrôleur adéquoite.
Le `ControllerAccess` redirige toutes les requêtes vers le `FrontalController`.

#### DAO
Chaque entité dispose de sont propre DAO qui hérite de `BaseDAO` regroupant les taches communes (CRUD) pour une entité

L'utilisation est simple:

* Ajout, Modification et Supression ce font par passage de l'entité elle-même
* La liste des entités présentes s'effectue avec un une requête est une liste de paramètres. L'objet `QueryBuilder` aide à cela.

#### Vues
Chaque entité possède son propre dossier pour les vues la concernant.