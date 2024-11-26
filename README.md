# Antaganden
### 1. Spelmekanik
   * #### Spelaren navigerar genom att skriva riktningar: n, s, ö, v.
   * #### Dörrar kan vara låsta och kräver nycklar för att låsas upp.
### 2. Rums-egenskaper
   * #### Rummen kan ha olika egenskaper definierade med `RoomProperty`, t.ex., `MONSTER`, `TREASURE`, `START`, och `END`.
   * #### Slutrummet (`END`) avslutar spelet när spelaren når det.
### 3. Narrativ
   * #### All information ges via konsolen, inklusive rummets beskrivning och möjliga riktningar.
### 4. Felhantering
   * #### Ogiltiga kommandon resulterar i ett felmeddelande.
   * #### Programmet avslutas kontrollerat när spelaren skriver "q".
### 5. Spelets struktur
   * #### Rummen och dörrarna är fördefinierade i `setupGame()` metoden.
   * #### Spelet har ett start-rum och ett slutrum.