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
Ici, deux implémentation ont été faite, une qui utilise l'injection de dépendances 
sur le constructeur, et une qui l'utilise sur les setters. 

Une classe abstraite `AbstractQuizzMasterService` à été crée afin de pouvoir utiliser deux 
implémentation différentes pour chaque moyen de faire l'injection de dépendance. Cette classe abstraite 
contient toute la logique d'affichage.  
La class `QuizzMasterServiceWithConstructor` hérite de `AbstractQuizzMasterService` 
et contient le code d'implémentation pour l'injection de dépendances avec le constructeur.
 Le code pour l'injection de dépendances avec les setters est situé dans la classe 
 `QuizzMasterServiceWithSetter` qui hérite également
 
La classe `QuizzProgram` contient la méthode main et possède une définition d'un bean. 
Il suffit de modifier la classe instancié dans ce bean pour modifier la classe injectée.
L'ensemble de la configuration de l'injection de dépendances est faite grâce aux annotations de Spring. 
  
  
Le méthode main instancie les deux services, mais lance uniquement le service concernant l'injection de 
dépendances avec les setters. Il suffit de changer la ligne commenté pour éxécuter l'autre. 


### Question 2
Le code est disponible dans le package `devoir2.question2`.  
Ici, nous avons mis en place un système de banque. La banque possède une liste de clients et un taux d'intérêt. 
Ce taux d'intêret est sujet aux modifications et sera mis à jour de manière aléatoire grâce à la classe `Trader`.

Les clients souhaitent être notifiés lorsque le taux d'interrêt change. 
Pour cela, le pattron architectural Publisher/Subscriber est mis en place, grâce à l'implémentation 
Observer/Observable.   
Pour réduire le couplage, la classe banque ne s'occupe pas de prévenir les clients lors d'un changement. 

Un aspect `ClientNotifierAspect` est crée et se sert de notifier les clients 
après l'appel de la méthode Bank.setInterest().

### Question 3

