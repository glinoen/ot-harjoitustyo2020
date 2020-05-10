# Vaatimusmäärittely

## Sovelluksen tarkoitus

2048-pelin hengessä tehty peli missä yhdistetään numeroita sisältäviä neliöitä ruudukossa ja yritetään saavuttaa tietty numero. Pelin alussa voidaan valita ruudukon koko.

## Käyttäjät

Yksi käyttäjärooli, eli pelin pelaaja

## Käyttöliittymäluonnos

Sovelluksessa on aloitusnäkymä missä valitaan pelin asetukset. Toinen näkymä on itse pelinäkymä. Pelin häviäminen avaa ikkunan mistä voi pelata uuden pelin, poistua pelistä tai mennä katsomaan parhaita tuloksia. Pelin voittaessa avautuu näkymä missä tallennetaan pisteet tietokantaan ja sen jälkeen näytetään parhaat tulokset.

## Toteutuneet ominaisuudet


- graafinen käyttöliittymä
- ruudukon koko voidaan valita
- pisteitä saadaan ruutujen yhdistyessä
- peli loppuu kun ruudukkoon ei voi enää lisätä uutta ruutua
- pelin voittaminen kun jonkun ruudun arvo on 2048
- tietokantaan tallentaminen ja sieltä tiedon lukeminen

## Perusversion tarjoama toiminnallisuus

- käyttäjä voi valita pelin asetukset

- käyttäjä voi pelata peliä

- voittaessaan pelin käyttäjä voi tallentaa tuloksen tietokantaan valitsemallaan nimellä ja sen jälkeen aloittaa uuden pelin 

- hävitessään pelin käyttäjä voi aloittaa uuden pelin tai mennä katsomaan tuloksia tietokannasta

## Jatkokehitysideoita

- uusi ominaisuus esim undo mahdollisuus
- täysin vapaasti valittava ruudukon koko
