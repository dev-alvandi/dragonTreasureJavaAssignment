# Antaganden
### 1. Klasser 
#### Room Property
   * #### Enum används för att skilja mellan olika rum.
   * #### Rummen kan ha olika egenskaper definierade med `RoomProperty`, t.ex., `MONSTER`, `TREASURE`, `START`, och `END`.
   * #### Slutrummet (`END`) avslutar spelet när spelaren når det.

#### Main
* #### Egen main-klass används för att öka läsbarheten i koden genom att skapa en instans av Dungeon-klassen och anropa metoden playGame().


### 2. Felhantering
   * #### Ogiltiga kommandon/riktning resulterar i ett felmeddelande.
   * #### Programmet avslutas kontrollerat när spelaren skriver "q".
