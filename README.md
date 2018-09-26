# [8INF956] - TP1

## Dépendances 
Les dépendances sont disponibles dans le dossier `lib/`.  
Le projet à comme dépendances Spring  4.3.18 et AspectJ

## Compilation

Afin de compiler la deuxième partie du code, il faut configurer l'environnement de travail 
pour utiliser le compilateur d'aspect [asc](https://www.eclipse.org/downloads/download.php?file=/tools/aspectj/dev/aspectj-DEVELOPMENT-20180312080830.jar)

## Éxécution
TODO jar + path to jar
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

