# Java-oblig-6

Alle oppgavene skal være forsøkt løst etter beste evne (du må ikke løse bonusoppgavene). Hvis du har en oppgave som du har forsøkt på, men ikke fått helt til, er det OK om denne kommenteres ut slik at vi kan se hvordan du har tenkt/hva du har forsøkt på. Resterende kode bør kunne kompileres og kjøres uten at det kræsjer. Oppgaver som er gjennomført og fungerer burde ikke kommenteres ut.

Les: Obligatoriske oppgaver - Informasjon (oppdatert 12.02)

Obligen er strukturert opp i oppgaver, dere skal levere hele IntelliJ prosjektet.

Teorispørsmålene: Ikke .zip denne sammen med programmeringen, men levér som en egen fil. Leveres som docx/pdf/txt navngitt: Oblig6_UNIVERSE_Teori_<DittNavn>.<filtype>
Eks: Oblig6_UNIVERSE_Teori_LarsEmilKnudsen.pdf

Rapport: Ikke .zip denne sammen med programmeringen, men levér som en egen fil. Leveres som docx/pdf/txt navngitt: Oblig6_UNIVERSE_Rapport_<DittNavn>.<filtype>
Eks: Oblig6_UNIVERSE_Rapport_LarsEmilKnudsen.pdf

Programeringsoppgavene: Leveres som en .zip fil av javaprosjektet navngitt: Oblig6_UNIVERSE_<DittNavn>.zip 
Eks: Oblig6_UNIVERSE_LarsEmilKnudsen.zip

 

Det er sjanse for at det kommer endringer på denne obligen. Både i form av rettelser og utdypninger, men også tillegg. Disse endringene vil i så fall bli listet opp her:

31.03 - Ingen enda

01.04 - Tydeliggjort teksten i 1.5
01.04 - Lagt til navn som en del av observasjonen i programmeringsoppgaven
Teori

De fleste av disse oppgavene er repetisjon av tidligere obliger. Det som nå er veldig viktig er at det du leverer er skrevet med egne ord. Alle kilder du har benyttet som utgangspunkt for dine forklaringer SKAL med. Hvis det viser seg at hele eller deler av oppgavene er kopiert fra andre kilder vil du få direkte "ikke godkjent". Det vil altså si at hvis dette er tilfellet fra tidligere obliger, så SKAL disse revideres. Dette inkluderer å oversette engelske kilder. Det vil blir brukt både automatiserte analyser og manuell gjennomgang for å gjøre en plagiatkontroll.


## Oppgave 1 - Ord og begreper

### Oppgave 1.1

Forklar begrepet polymorfisme og eksemplifiser med enkel kode.

### Oppgave 1.2

Forklar hva primitive datatyper er, nevn gjerne noen eksempler.

### Oppgave 1.3

Forklar forskjellen på en klasse og et objekt. Vis gjerne et lite eksempel på hvordan man definerer en klasse, og oppretter et objekt.

### Oppgave 1.4

Forklar programmeringsparadigmene:

* Imperativ programmering
* Funksjonell programmering
* Deklarativ programmering

### Oppgave 1.5

Lag deg en oversikt over hva følgende ord/begreper betyr, med egne ord. Det bør forklares såpass tydelig at det kommer klart frem hva det er for en som ikke kan det fra før, og du får vist din forståelse av det.

* Class
* Object (konseptet, ikke klassen)
* Instance variable
* Overloading
* Overriding
* Extends 
* private,public,(protected) (klasse,variabel,metode)
* this og super
* Refaktorere
* Static (variabel, metode)
* Final (variabel, metode, klasse)
* Abstract (klasse, metode)
* Interface
* Anonymous Inner Class
* MVC (konseptet, og hver enkelt del)
* Exception
* Threads
* Collections Framework
    * List
    * Map
    * Queue
    * Stack

## Oppgave 2.0 - Rapport

Du skal skrive en liten rapport om prosjektet. Dette skal minst ha med:

* UML med forklaring
* En kort overordnet forklaring av hvordan du har løst oppgavene
  * Er det noe spesielle valg du har tatt?
  * Har du laget noen "hjelpemetoder" for å gjøre koden mer oversiktlig? etc.
  * Hvilke deler av applikasjonen har dere fått hjelp til eller funnet informasjon om på nettet eller i forelesningseksemplene 

(NB! det er ikke negativt å klare å benyttes kode fra andre kilder. Det er imidlertid veldig negativt å ikke opplyse om dette). Husk også å skrive opp de større tingene dere har fått hjelp til på øvingstimer/veiledning. Dette inkluderer også de faktiske referansene til kildene.

## Oppgave 3 - Programmering

Du har lov til å samarbeide og få hjelp av studentassistenter, men all kode bør skrives selv. Du SKAL oppgi hvem du eventuelt har samarbeidet med, og hva du har fått hjelp til av studentassistentene/faglærer. All kilder du benytter fra nettet skal oppgis (slik som stackoverflow ol.). 
Oppgaven

Året er 2337, og vi har nå midler for å kunne reise rundt i universet. Det er blitt oppdaget liv på en rekke planeter, og det er ønskelig å starte registrering av disse. Du skal utvikle en prototype for MapOfLife, en applikasjon for registrering av dyreobservasjoner i universet.

MapOfLife skal inneholde en oversikt over observasjoner av dyrearter i universet. Disse dyreartene skal inneholde navn (både vanlig og vitenskapelig). Det er til nå bare oppdaget 3 grupperinger av dyr: virvelløse dyr, amfibier og fugler (du kan eventuelt "finne" opp egne hvis du ønsker). Lag disse som egne klasser og finn passende data å registrere for hver av de (f.eks. om de kan fly, hvor mange ben de har ol.). Videre skal vi også registrere den geografiske lokasjonen for observasjonene. En slik lokasjon skal ha et navn, samt lengde- og breddegrad. Lokasjonen skal være knyttet til planeten den befinner seg på, samt typen biom dette er (f.eks. skog, savanne, tundra etc.). En lokasjon kan være knyttet til flere biomer hvis den er i et grenseområde mellom disse. En observasjon er en kombinasjon av en id, navn, dyr, lokasjon, tidspunkt, antall, bilde og et notatfelt for kommentarer.

Teksten er her beskrevet på norsk, du kan velge om du ønsker å skrive koden på norsk eller engelsk, men det er anbefalt at du skriver den på engelsk.

### Oppgave 3.1 - UML

Basert på beskrivelsen over, lag en UML-skisse som viser de klassene du mener er nødvendig for å lage modellen for systemet. Du skal konsentere deg om det som ligger i beskrivelsen. Du skal heller ikke tenke på brukergrensesnittet i denne omgang. Husk at diagrammet også skal ha med nødvendige metodenavn, parametre og returtyper.

Forklar med dine egne ord de klassene du har identifisert, og relasjonen mellom dem.

### Oppgave 3.2 - Modeller

Lag deg et nytt Gradle-prosjekt i IntelliJ.

1. Lag en implementasjon av de modell-klassene du har skissert i UML'en. 

2. Ha med en fornuftig implementasjon av toString() i alle klasser (lag en egen versjon fremfor den som er automagisk generert av IntelliJ).

3. Legg til en naturlig sortering i et par av klassene du tror det kan være aktuelt å kunne sortere.

### Oppgave 3.3 - Instansiering

Lag en Main.java fil. Benytt denne til å opprette en 5-6 observasjoner med varierende innhold av data.

Skriv så ut disse observasjonene til konsollen.

### Oppgave 3.4 - Filskriving

1. Lag et repository interface med de metodene du kan tenke deg er aktuelle å ha i forbindelse med CRUD (Create, Read, Update, Delete) av observasjoner. 

2. Lag et repository som implementerer dette interfacet. Velg i første omgang ut noen av de "vanligste" metodene og lag en implementasjon av disse. I tillegg skal dette repositoriet kunne skrive og lese data om observasjoner til fil. Du står fritt til å velge hva slags format denne skal benytte (CSV, JSON, XML ,etc.). Velg en passende collection til å holde på denne dataen (List, Map, etc.), og begrunn hvorfor du velger akkurat denne. 

JSON tips:

For parsing av f.eks. LocalDate (som er en klasse vi ikke har "kontroll" over), legg til Gradle-dependency herfra:

Jackson Datatype: JSR310 (Lenker til en ekstern side.)

Og bruk JavaTimeModule():

JavaTimeModule (Lenker til en ekstern side.)

3. Bruk repositoriet du har laget, og skriv de observasjonene du opprettet i Main.java til fil. Test å lese dataene tilbake igjen også.

### Oppgave 3.5 - UI

Som et minimum skal du kunne liste ut alle observasjoner i systemet i en eller annen form for UI. Du står fritt til å benytte enten Javalin eller JavaFX til dette.

Hvis du ønsker å bruke Javalin og Vue, kan du bruke denne .vue fila for liste av observasjoner:

observations-overview.vue

Denne .vue filen forutsetter:

At man får tilbake observasjoner fra api-url: /api/observations
Instansvariabler i observation-klassen:
  id
  name
  animal (animal må også ha instansvariabl "name")


## Oppgave 4 - Bonusoppgaver
### Oppgave 4.1 - Refleksjon og kodeforståelse

Sammenlign med løsningsforslaget fra oblig 5 <kommer...>. Ta for dere forrige oblig og forklar deres implementasjon. 

Hva har dere gjort? Hvorfor har dere gjort det slik? Hva er forskjellig? Skriv et lite avsnitt om refleksjoner og funn.

Hvis dere har lyst til å gjennomføre en slik sammenligning digitalt med en annen person, fremfor løsningsforslaget, vil dette også være OK.

### Oppgave 4.2 - Moar UI

Utvid grensesnittet med så mye du ønsker av UI.

1. Se detaljer for observasjoner

2. Se detaljer for ett dyr

3. Slette observasjon

4. Opprette en ny observasjon

5. Oppdatere en observasjon
