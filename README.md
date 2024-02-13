# Smart Planner
<p align=center>
<img src="https://github.com/g-foglia/SmartPlannerFIA/assets/145924139/4c6c769f-b89d-4223-a109-42370d2f6baa" width=250 >
</p>

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
- **"src/metaheuristics"** contiene la classe che riceve i parametri e gli operatori, per poi eseguire effettivamente l'algoritmo e restituire i risultati;
- **"src/Runner.java"** è la classe che imposta i parametri, manda in esecuzione l'algoritmo e infine stampa i risultati ottenuti.  
## Come replicare il progetto
Per replicare il progetto è necessario scaricarlo da GitHub e aprirlo con un IDE che supporti il linguaggio Java e lo JDK 17 o successivi.

Gli algoritmi sono inizializzati con 28 impegni di prova, che si trovano nei file "simulated-annealing/src/SimulatedAnnealing.java", "hill-climbing/src/HillClimbing.java" e "genetic-algorithm/src/initializers/RandomInitializer.java". Ogni impegno ha associato un numero che rappresenta la sua priorità ed è usato per il calcolo della bontà di ogni soluzione. Aggiungere o rimuovere impegni in questi file (usando gli stessi metodi già codificati per gli altri) è l'unico modo per modificare i dati su cui gli algoritmi operano. 

Per l'algoritmo genetico sono stati implementati due operatori di selezione e due operatori di mutazione. Per modificare la combinazione di operatori e parametri usata bisogna agire sulle classi "genetic-algorithm/src/metaheuristics/GeneticAlgorithm.java" e "genetic-algorithm/src/Runner.java". In entrambe sono presenti tutte le righe di codice necessarie, con gli operatori inusati racchiusi in commenti. 
In particolare per "GeneticAlgorithm.java" le righe interessate sono:
- 20 e 21 per la dichiarazione dell'oggetto che rappresenta l'operatore di selezione, 30 per la sua dichiarazione nel metodo costruttore, 69 e 70 per la selezione all'interno del ciclo dell'algoritmo;
- 23 e 24 per la dichiarazione dell'oggetto che rappresenta l'operatore di mutazione, 31 per la sua dichiarazione nel metodo costruttore, 77 e 78 per la mutazione all'interno del ciclo dell'algoritmo;

In particolare per "Runner.java" le righe interessate sono:
- 24 e 25 per la dichiarazione dell'oggetto che rappresenta l'operatore di selezione;
- 29 e 30 per la dichiarazione dell'oggetto che rappresenta l'operatore di mutazione;

