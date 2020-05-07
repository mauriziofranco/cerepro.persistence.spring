CONFIGURAZIONE PROGETTO cerepro.persistence.spring

1) Dopo aver fatto il clone del progetto da https://github.com/MaurizioFranco/cerepro.persistence.spring
2) Portarsi nella directory home del progetto ed eseguire il goal "install" di maven(mvn install). In alternativa configurare un maven task runner  dall'IDE si utilizza.
3) eseguire il task runner il quale eseguirà, prima dell'install, il goal test. Il goal test consiste nell'esecuzione dei tests di cui le classi sotto src/test/java che grazie alle proprietà(di connessione) inserite nell'application.properties(contenute all'interno di src/test/resources) verranno eseguiti i test sul database di riferimento.
4) configurarsi un database in locale(scripts all'interno della directory resources/sql)
5) cambiare application.properties ed eseguire i test sul database in locale

Obiettivi:
1) fare l'install puntando al database di test(originariamente contenuto nel file application.properties)
2) fare l'install puntando al database di sviluppo in locale(andando a cambiare il contenuto nel file application.properties)


After clone provides to:
- get file 01_schema_&_db_users.sql from resources/sql folder and execute it into local database.  