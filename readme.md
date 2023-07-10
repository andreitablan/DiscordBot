# Proiect Java - Discord bot 

Bot pentru Discord care sa ofere raspunsuri la intrebari legate de grafuri/algoritmi, mesaje preluate prin RSS(utilizand ROME).

## Functionalitati

Functia **help** afiseaza functionalitatile robotului.

```bash
!help
```
Functia **rss** afiseaza titlul si descrierea unui rss feed dat ca argument printr-un link.

```bash
rss:<url>
```
Functia **!question** va afisa definitiile urmatoarelor notiuni: isomorphic, digraph, k-clique, bipartite graph, planar graph, connected graph, connected component, tree, bridge, Eurelian, Hamiltonian. 

```bash
!<question>
```
Functia **dfs** afiseaza parcurgerea dfs a unui graf dat ca parametru.

```bash
dfs: <number of nodes> <starting node> <edges>
```
Functia **bfs** afiseaza parcurgerea dfs a unui graf dat ca parametru.

```bash
bfs: <number of nodes> <starting node> <edges>
```
Functia **connected** afiseaza daca un graf dat ca parametru este conex sau nu.

```bash
connected: <number of nodes> <edges>
```
Functia **draw** returneaza o imagine **.png** reprezentand graful desenat.

```bash
draw: <number of nodes> <edges>
```
Functia **!seconds** returneaza numarul de secunde de cand a fost pornit botul.

```bash
!seconds
```
Functia **!milliseconds** returneaza numarul de milisecunde de cand a fost pornit botul.

```bash
!miliseconds
```

## Notiuni folosite pentru implementarea codului

* *Laboratoarele 1 si 2* - Proiectul este construit intr-o maniera **OOP**. 
* *Laboratorul 3* - Am folosit **generics** pentru construirea clasei abstracte.**AbstractRepository**. Am folosit **Interfaces** pentru implementarea celor doua clase timekeeper.
* *Laboratorul 4* - Am folosit in diverse clase **Lists**, **HashMaps** si **Streams**.
* *Laboratorul 5* - Am folosit lucrul cu fisiere in clasa **DrawGraph**, pentru salvearea unui fisier **.png**. 
* *Laboratorul 6* - Am folosit **Java Swing** in clasa **DrawGraph** in vederea desenarii unui graf dat ca input. Am folosit **Exceptii** pentru tratarea cazului in case nu exista in baza de date o intrebare data ca input.
* *Laboratorul 7* - Am implementat doua threaduri **daemon** caren umara in fundal secundele si milisecundele de cand a inceput functionarea botului.
* *Laboratoarele 8 si 9* - Am stabilit conexiunea cu baza de date printr-un **singleton**, numit **Manager**. Am implementat clase de tipul **Repository**, **Entity**.


## Autori
Leagan Dan-Adrian <br />
Tablan Andrei-Razvan
