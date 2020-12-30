# Application : The Simpson App
Projet de 4ème année application mobile Android

Nous avons dû cette année apprendre à utiliser Kotlin. Ce langage se rapproche beaucoup de Java et en est très inspiré, pour preuve ces 2 langages peuvent
fonctionner de paire.
Ce fut très interessant, Kotlin étant un langage agréable, même s'il faut toujours chercher à droite et à gauche des informations/bibliothèques.

Plusieurs consignes ont été respectés en réalisant ce projet:

* Clean Architecture et Architecture MVVM
* Gitflow
* Effort dans le design
* Création d'une base de données
* Possibilité de créer un compte puis de s'identifier
* Récupération de données via une ApiREST (url : https://www.simpsonsoptimizer.com/)
* Affichage d'une liste

Les technologies suivantes ont été utisées :
  * Koin
  * Coroutines
  * Room
  * Retrofit2
  * Recyclerview
  * Firebase
  * LiveData
  * Material Components
  

Voici l'architecture du projet :

<p align="center">
<image src ="images/clean_architecture_mvvm.png" width = "300">
</p><br/>

  
Faisons maintenant une explication du fonctionnement de l'application !
Tout d'abord le logo, il s'adapte en fonction de la forme générale des autres icones.

<p align="center">
<image src ="images/logo_app.png" width = "300">
</p><br/>

Voilà maintenant le menu sur lequel nous arrivons en lançant l'application. On comprend qu'il faut insérer son identifiant et mot de passe pour pouvoir
accéder à la suite<br/>

<p align="center">
<image src ="images/menu.png" width = "300">
</p><br/>

Mince ! Voilà le message d'erreur qui s'affiche lorsque l'on essai de s'identifier ou de créer un compte alors qu'au moins l'un des deux champs est vide.<br/>

<p align="center">
<image src ="images/box_erreur_vide.png" width = "300">
</p><br/>

Essayons cette fois avec des champs remplis. Ca ne passe toujours pas ! Il faut d'abord créer un compte avant d'essayer de se log.<br/>

<p align="center">
<image src ="images/compte_non_enregistré.png" width = "300">
</p><br/>

Cette fois-ci on appui alors sur "sign up" pour créer un compte puis "login" pour pouvoir passer à la suite.<br/>

<p align="center">
<image src ="images/menu_avec_id.png" width = "300">
</p><br/>

Voilà la page sur laquelle nous arrivons ensuite. On comprend qu'il faut rentrer un numéro de saison pour pouvoir avoir des informations<br/>

<p align="center">
<image src ="images/rechercher_saison.png" width = "300">
</p><br/>

Mince ! Il faut taper un nombre de saison valable, entre 1 et 30 comme indiqué dans le message d'erreur.<br/>

<p align="center">
<image src ="images/erreur_pas_entre_1_et_30.png" width = "300">
</p><br/>

Voici quelques exemples des informations retournées.<br/>

<p align="center">
<image src ="images/liste_saison_1.png" width = "300">
<image src ="images/liste_saison_10.png" width = "300">
<image src ="images/liste_saison_30.png" width = "300">
</p><br/>

Et pour finir un petit exemple de notification push envoyée grâce à l'implementation de firebase dans le projet<br/>

<p align="center">
<image src ="images/notif_firebase.png" width = "300">
</p><br/>

Merci d'avoir pris le temps de lire ! En espérant avoir eveillé un peu d'intérêt :)
