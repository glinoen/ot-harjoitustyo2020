# Arkkitehtuurikuvaus

## Rakenne
Ohjelman pakkausrakenne on seuraavanlainen:

![alt text](/dokumentointi/kuvat/blokkipakkausrakenne.png)

Pakkaus blokkiapp.ui sisältää JavaFX:llä toteutetun graafisen käyttöliittymän, pakkaus blokkiapp.domain sovelluslogiikan ja pakkaus blokkiapp.dao tiedon tallennukseen liittyvän toiminnallisuuden.

## Käyttöliittymä

Käyttöliittymä sisältää neljä erillistä näkymää
- asetusruutu
- peliruutu
- pisteiden tallennusruutu
- parhaiden pisteiden tutkimusruutu

Käyttöliittymä on rakennettu luokassa [blokkiapp.ui.BlokkiUi.java](https://github.com/glinoen/ot-harjoitustyo2020/blob/master/blokki/src/main/java/blokkiapp/ui/BlokkiUi.java)

## Sovelluslogiikka

Luokka GameLogic vastaa pelin toiminnasta ja käyttöliittymä käyttää sen seuraavia metodeja:
- public void newGame(int size)
- public void moveTiles(String direction)
- public boolean isGameWon()
- public boolean isGameOver() 

Luokka ScoreService tarjoaa käyttöliittymälle tiedon tallennukseen ja lukemiseen liittyvät toiminnot metodeilla:
- public boolean createScore(Score score)
- public ArrayList<Score> getScores(int gridSize)

![alt text](https://github.com/glinoen/ot-harjoitustyo2020/blob/master/dokumentointi/kuvat/pakkauskaavio.png)

## Tietojen pysyväistallennus

Luokka _DatabaseScoreDao_ pakkauksessa _blokkiapp.dao_ huolehtii tietojen tallennuksesta tietokantaan. Se noudattaa DAO-mallia ja on eristetty rajapinnan _ScoreDao_ taakse jota sovelluslogiikka käyttää luokassa _ScoreService_.

### Tietokanta

Jokainen pelin voittanut tulos tallennetaan tietokantaan joka on toteutettu _SQLitellä_

### Toiminnallisuudet

#### ruutujen liikuttaminen

Kun käyttäjä pelaa peliä ja painaa nuolinäppäintä ylös tapahtuu seuraavaa:

![alt text](/dokumentointi/kuvat/sekvenssitile.png)