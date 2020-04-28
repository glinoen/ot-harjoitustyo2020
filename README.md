## Ohjelmistotekniikka harjoitustyö 2020

2048 pelin hengessä tehty peli.


## Dokumentaatio

[Vaatimusmäärittely](https://github.com/glinoen/ot-harjoitustyo2020/blob/master/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](dokumentointi/arkkitehtuuri.md)

[Käyttöohje](dokumentointi/kaytto-ohje.md)

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
