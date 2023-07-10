# Java Project - GraphBot
GraphBot is a discord bot that answers different graph theory or algorithms questions, sending messages using RSS(ROME). It is implemented for the Advanced Programming course at the Faculty of Computer Science Iasi. It uses Java.

## Functionalities

The **help** function displays the functionalities of the robot.

```bash
!help
```
The **rss** function displays the title and description of an RSS feed provided as an argument through a link.

```bash
rss:<url>
```
The **!question** function displays the definitions of the following concepts: isomorphic, digraph, k-clique, bipartite graph, planar graph, connected graph, connected component, tree, bridge, Eulerian, and Hamiltonian.

```bash
!<question>
```
The **dfs** function displays the depth-first search traversal of a given graph as a parameter.

```bash
dfs: <number of nodes> <starting node> <edges>
```
The **bfs** function displays the breadth-first search traversal of a given graph as a parameter.

```bash
bfs: <number of nodes> <starting node> <edges>
```
The **connected** function displays whether a given graph as a parameter is connected or not.

```bash
connected: <number of nodes> <edges>
```
The **draw** function returns a .png image representing the drawn graph.

```bash
draw: <number of nodes> <edges>
```
The **!seconds** function returns the number of seconds since the bot started.

```bash
!seconds
```
The **!miliseconds** function returns the number of milliseconds since the bot started.

```bash
!miliseconds
```

## Concepts used for code implementation

* *Laboratories 1 and 2* - The project is built in an **OOP** manner.
* *Laboratory 3* - **Generics** were used to build the abstract class **AbstractRepository**. **Interfaces** were used to implement the two timekeeper classes.
* *Laboratory 4* - **Lists**, **HashMaps**, and **Streams** were used in various classes.
* *Laboratory 5* - File manipulation was used in the **DrawGraph** class to save a **.png** file.
* *Laboratory 6* - **Java Swing** was used in the **DrawGraph** class for drawing an input graph. **Exceptions** were used to handle the case when a given question does not exist in the database.
* *Laboratory 7* - Two **daemon** threads were implemented to track the seconds and milliseconds since the bot started functioning.
* *Laboratories 8 and 9* - The connection to the database was established through a **singleton** called **Manager**. **Repository** and **Entity** classes were implemented.

#### Relevant links
[Advanced programming - course page](profs.info.uaic.ro/~acf/java/)
## Contributors
###### [Andrei Tablan](https://github.com/andreitablan "Andrei Tablan")
###### [Dan Leagan](https://github.com/leagan-dan)
