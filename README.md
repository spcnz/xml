# xml

## setup
### Tomcat + ExistDB + Jena Fuseki
Potrebno je pokrenuti jedan tomcat server na portu 8089, dodati exist.war i existVlast.war fajlove u webapps folder u tomcat direktorijumu.
Isto tako, dodati i fuseki.war i kreirati dataset koji se zove *Tim21Dataset*.
Skinuti fuseki jena server i pokrenuti komandom `fuseki-server --port "8093" --mem /Tim21DatasetVlast`

Linkovi do front-end aplikacije
[Portal organa vlasti](https://github.com/dovlaper/xml-fe-react-offical-)
[Portal poverenika](https://github.com/dovlaper/xml-fe-react)


Kreirati korisnike na portalu poverenika iz postmana slanjem requesta create user (iz exportovane postman kolekcije) sa role ROLE_CITIZEN za obicnog korisnika, ROLE_COMMISSIONER za poverenika.


Kreirati korisnike na portalu poverenika iz postmana slanjem requesta create user vlast (iz exportovane postman kolekcije, port je 8083) sa role ROLE_CITIZEN za obicnog korisnika, ROLE_OFFICIAL za sluzbenilka.

Sifra za logovanje je 123 (kesirana je prilikom registracije)
