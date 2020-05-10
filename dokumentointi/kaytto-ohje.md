# Käyttöohje

Lataa tiedosto [blokkiloppupalautus.jar](https://github.com/glinoen/ot-harjoitustyo2020/releases/download/3/blokkiloppupalautus.jar)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar blokkiloppupalautus.jar
```

## Uuden pelin aloittaminen

Sovellus käynnistyy aloitusnäkymään, missä syötekenttään kirjoitetaan haluttu ruudukon koko.

## Pelin pelaaminen

Ruudukossa olevia ruutuja voidaan liikuttaa nuolinäppäimillä eri suuntiin, samanarvoiset ruudut yhdistyvät kun niiden välissä ei ole muita ruutuja ja niitä liikutetaan siten että ne menevät ikään kuin päällekkäin.

## Pelin häviäminen

Jos ruudukkoon ei enää mahdu uusia ruutuja peli on hävitty, ja avautuneesta ikkunasta voidaan aloittaa uusi peli painamalla _Play Again_ , poistua sovelluksesta painamalla _Exit to Desktop_ tai mennä katsomaan parhaita tuloksia painamalla _View High Scores_.

## Pelin voittaminen

Jos jokin ruutu saavuttaa arvon 2048 peli on voitettu. Nyt avautuvaan ikkunaan voidaan syöttää nimi jolla saatu tulos tallennetaan tietokantaan. Sen jälkeen avautuu ikkuna jossa näkyy parhaimmat tulokset kyseiselle ruudukon koolle. 
Uusi peli voidaan aloittaa painamalla _Play Again_ tai sovelluksesta voidaan poistua painamalla _Exit to Desktop_.

