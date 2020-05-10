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

## Toiminnallisuudet

#### ruutujen liikuttaminen

Kun käyttäjä pelaa peliä ja painaa nuolinäppäintä ylös tapahtuu seuraavaa:

![alt text](/dokumentointi/kuvat/sekvenssitile.png)

Tapahtumankäsittelijä joka reagoi näppäimistön painalluksiin kutsuu sovelluslogiikan luokan _GameLogic_ metodia moveTiles, antaen sille parametriksi suunnan. Tämä metodi kutsuu sovelluslogiikan luokan _Board_ metodia moveUp joka käy ruudukon väli vertaillen ruutuja saman luokan metodilla tileMoverOrMerger, jolle parametriksi annetaan vertailtavat ruudut ja algoritmin vaihe _s_. Sitten _GameLogic_ kutsuu omaa metodiaan boardStatus joka tarkastaa ruudukon tilanteen kutsumalla luokan _Board_ metodia gridCountScoreAndResetMerge. Tämän metodin palauttaman arvon perusteella tiedetään onko peli hävitty, jos ei niin lisätään metodin palauttama arvo kokonaispisteisiin pisteet ja tarkastetaan onko peli voitettu kutsumalla _Board_ luokan metodia isGameWon().

## Ohjelman heikkoudet

- Koko käyttöliittymä on toteutettu yhdessä luokassa.

- Ohjelman hidastuminen ruudukon kasvaessa. Tarvitaan optimointia. 