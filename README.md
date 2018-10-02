# [8INF956] - TP1

Ce rapport est écrit au format markdown. Pour un meilleur rendu, il est conseillé de l'ouvrir dans un éditeur
qui supporte ce format. Il est disponible déja parsé sur la page [GitHub](https://github.com/irindul/aspect-oriented-programming).

## Dépendances 
Les dépendances sont disponibles dans le dossier `lib/`.  
Le projet à comme dépendances Spring 4.3.18 et AspectJ 

## Compilation

Afin de compiler la deuxième partie du code, il faut configurer l'environnement de travail 
pour utiliser le compilateur d'AspectJ [asc](https://www.eclipse.org/downloads/download.php?file=/tools/aspectj/dev/aspectj-DEVELOPMENT-20180312080830.jar).

## Éxécution
Dans un terminal, éxécuter les commandes suivantes pour éxécuter chacune des questions :   
- Pour la question 1 : `$ java -jar ./builds/question1.jar`.
- Pour la question 2 : `$ java -jar ./builds/question2.jar`.

> Le programme de la question 2 tourne à l'infini, il faut l'arrêter avec un SIGINT (Ctrl+C dans le terminal).


## Description 

### Question 1 

Le code concernant la question 1 est situé dans le package `devoir2.question1`.   
Ici, deux implémentations ont été faite, une qui utilise l'injection de dépendances 
sur le constructeur, et une qui l'utilise sur les setters. 
La définition des beans est faite dans le fichier `devoir2/question1/quiz.xml`. Il suffit de changer la valeur du bean dans 
`ref` pour changer la valeur instanciée.  
La classe `QuizzProgram` contient la méthode main et instancie deux fois `QuizMasterService`.
Une seule instance est lancé mais il suffit de commenter 
`quizWithConstructor.run();` et décomenter `quizWithSetter.run();` pour lancer l'autre. 
 

### Question 2

Le code est disponible dans le package `devoir2.question2`.  
Ici, nous avons mis en place un système de banque. La banque possède un taux d'intérêt. 
Ce taux d'intêret est sujet aux modifications et sera mis à jour de manière aléatoire grâce à la classe `Trader`.

Les clients souhaitent être notifiés lorsque le taux d'interrêt change. 
Pour cela, le pattron architectural Publisher/Subscriber est mis en place, grâce à l'implémentation 
Observer/Observable.   
Pour réduire le couplage, la classe banque ne s'occupe pas de prévenir les clients lors d'un changement. 
La classe banque ne possède aucun lien avec les clients. 

Un aspect `ClientNotifierAspect` est crée et possède une liste d'`Observer`. On capture dans l'aspect l'instanciation 
de Clients et on les ajoute à la liste d'observer.
Il se sert de notifier les clients après l'appel de la méthode `Bank.setInterest()`.

### Question 3

Les logiciels utilisés en entreprise doivent évoluer pour : 
- Corriger les bugs : 
  - Exemple : On livre une application au client, et celui ci se rend compte que la fonction de gestion des 
   meetings est buggé. La date que l'on rentre n'est pas celle affichée une fois le meeting enregistré.
   Le logiciel doit être modifié pour corriger cela, et prendre en compte, par exemple, les timezones lorsque l'on 
   enregistre la date. 
   
- Ajout de fonctionalités : 
  - Si un client est satisfait du logiciel livré, il est possible qu'il demande des améliorations. Si on reprend l'exemple de meetings, 
 il peut être demandé de rajouter par exemple un envoi de mail à tous les participants du meeting pour 
 les prévenir. 
 Le code doit par conséquent être modifié pour ajouter cette fonctionalité. 
 
 - Amélioration de l'érgonomie : 
    - Un logiciel peut être amené à évoluer si les utilisateurs ont du mal a le comprendre. Dans ce cas, on peut rajouter 
    des explications visuelles, simplifier l'interface ou autres changements.   
    Pour garder le même logiciel, si notre logiciel de meeting possède énormément d'options, que l'utilisateur doit 
    tout remplir à la main, écrire les noms des participants un à un, écrire la date manuellement au bon format, etc, l'utilisateur 
    ne sera pas satisfait du produit. Il faudra donc le modifier pour par exemple proposer 
    un calendrier ou on clique sur la date pour la sélectioner, un carnet d'adresse ou on rentre juste les premières letters du nom, pour qu'il nous propose
    des participants et qu'on clique simplement. 