CONFIGURAZIONE PROGETTO CEREPRO REALIZZATO DALLA 3° Academy.
1)Checkout di IVAcaMi/cerepro.persistence.spring
Cos'è cerepro.persistence.spring? Il progetto contenente solo la parte di persistenza realizzata con spring data.
2) configurarsi un task runner che faccia l'install del progetto(maven goal: install)
3) eseguire il task runner il quale eseguirà, prima dell'install, il goal test. Il goal test consiste nell'esecuzione dei tests di cui le classi sotto src/test/java che grazie alle proprietà(di connessione) inserite nell'application.properties eseguiranno i test sul database predefinito di "test"
4) configurarsi un database in locale(scripts all'interno della directory resources/sql)
cambiare application.properties ed eseguire i test.

Obiettivi:
1) fare l'install puntando al database di test
2) fare l'install puntando al database di sviluppo in locale
