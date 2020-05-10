## Ohjelmistotekniikka harjoitustyö 2020

2048 pelin hengessä tehty peli.


## Dokumentaatio

[Vaatimusmäärittely](dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](dokumentointi/arkkitehtuuri.md)

[Käyttöohje](dokumentointi/kaytto-ohje.md)

[Tuntikirjanpito](dokumentointi/tuntikirjanpito.md)

## Komentorivi (komennot suoritetaan kansiossa blokki)

### Projektin ajaminen

komennolla

```
mvn compile exec:java -Dexec.mainClass=blokkiapp.Main
```

tai luomalla jar-tiedosto
```
mvn package
```
ja avaamalla se kansiossa blokki/target/
```
java -jar blokki-1.0-SNAPSHOT.jar
```


### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Checkstyle raportti luodaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```