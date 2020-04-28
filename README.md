## Ohjelmistotekniikka harjoitustyö 2020

2048 pelin hengessä tehty peli.


## Dokumentaatio

[Vaatimusmäärittely](dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](dokumentointi/arkkitehtuuri.md)

[Käyttöohje](dokumentointi/kaytto-ohje.md)

[Tuntikirjanpito](dokumentointi/tuntikirjanpito.md)

## Projektin ajaminen

kansiossa blokki, komennolla

```
mvn compile exec:java -Dexec.mainClass=blokkiapp.Main
```

## Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```
