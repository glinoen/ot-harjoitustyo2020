# Testausdokumentti

Ohjelmaa on testattu JUnitilla toteutetuilla testeillä ja järjestelmätasolla ohjelmaa on testattu manuaalisesti.

## Sovelluslogiikka
Automatisoidut testit testaavat sovelluslogiikasta vastaavaa luokkaa _GameLogic_ testillä _GameLogicTest_ ja sen alaisuudessa toimivaa luokkaa _Board_ testillä _BoardTest_.

## DAO
_DatabaseScoreDaoTest_ testaa tietoa tietokantaan tallentavan luokan _DatabaseScoreDao_ toimintaa luomalla sille testitietokannan.

## Testauskattavuus
![alt text](/dokumentointi/kuvat/testausdokumenttikattavuus.png)

## Järjestelmätestaus
Ohjelma on asennettu käyttöohjeen mukaisesti muutamassa eri Linux-ympäristössä. Toiminnallisuudet ja virheelliset syötteet on kokeiltu.