# Smart Planner 
## Team
I membri del team sono: 
- [Silvana Cafaro](https://github.com/zzzzilv)
- [Isabella Maria Sessa](https://github.com/isaboutoftown)
- [Gennaro Foglia](https://github.com/g-foglia)
## Overview
Smart Planner è un progetto che propone tre diverse soluzioni di un problema di scheduling delle attività. Le attività, denominate anche impegni,
vengono distribuite dall'algoritmo sul periodo di una settimana e in fasce orarie di un'ora dalle 8 alle 20. L'obiettivo è fornire un supporto inteligente all'organizzazione
delle giornate per le persone meno pratiche nel trovarne una adatta a loro.

Il problema è stato affrontato in tutti e tre i casi con algoritmi di ricerca locale implementati in linguaggio Java, nello specifico:
- Simulated Annealing
- Hill Climbing
- Genetic Algorithm
## Struttura dei file
La repostory è suddivisa in una cartella per ogni algoritmo, il cui contenuto è suddiviso a sua volta in altre sottocarelle in modo da tenere separate le componenti che si occupano di svolgere compiti diversi. 

Per quanto riguarda le cartelle "hill-climbing" e "simulated-annealing" la struttura è la stessa:
- **"src/entities"** contiene le classi che modellano le entità del problema;
- **"src/HillClimbing.java" e "src/SimulatedAnnealing.java"** sono le classi che consentono di eseguire gli algoritmi.

La cartella "genetic-algorithm" ha una struttura più complessa:
- **"src/fitness"** contiene la classe che valuta ogni individuo secondo la funzione di fitness;
- **"src/individuals"** contiene le classi che modellano le entità del problema;
- **"src/initializers"** contiene la classe che inizializza la popolazione;
- **"src/operators"** contiene tre ulteriori sotto cartelle che ospitano le classi che realizzano gli operatori genetici di selezione, crossover e mutazione;
- **"src/results"** contiene la classe che formatta i risultati dell'esecuzione dell'algoritmo;
- **"src/metaheuristics"** contiene la classe che riceve i parametri e gli operatori, per poi eeguire effettivamente l'algoritmo e restituire i risultati;
- **"src/Runner.java"** è la classe che imposta i parametri, manda in esecuzione l'algoritmo e infine stampa i risultati ottenuti.  
