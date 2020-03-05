CREATE TABLE Person (
   PersonID    	INTEGER NOT NULL UNIQUE,
   Navn  				VARCHAR(30),
   Fodselsdato	DATE,
   Nasjonalitet VARCHAR(30),
   CONSTRAINT Person_PK PRIMARY KEY (PersonID));

CREATE TABLE Rolle (
   RolleID				INTEGER NOT NULL UNIQUE,
   RolleType			VARCHAR(10),
   RolleInfo			VARCHAR(30),
   RolleAvPerson 	INTEGER,
   CONSTRAINT Rolle_PK PRIMARY KEY (RolleID),
   CONSTRAINT Rolle_FK FOREIGN KEY (RolleAvPerson) REFERENCES Person(PersonID)); 


   
CREATE TABLE Sjanger (
   SjangerID    INTEGER NOT NULL UNIQUE,
   Navn  				VARCHAR(30),
   Beskrivelse	VARCHAR(30),
   CONSTRAINT Sjanger_PK PRIMARY KEY (SjangerID));

CREATE TABLE Film (
   FilmID						INTEGER NOT NULL UNIQUE,
   MedieID					INTEGER NOT NULL UNIQUE,
   Tittel						VARCHAR(30),
   Lengde						INTEGER,
   Lanseringsaar		YEAR, 
   Storyline				VARCHAR(200),
   RolleIFilm				INTEGER,
   MediaHarSjanger	INTEGER,
   CONSTRAINT Film_PK PRIMARY KEY (FilmID),
   CONSTRAINT Film_FK FOREIGN KEY (RolleIFilm) REFERENCES Rolle(RolleID),
   CONSTRAINT Film_FK_sjanger FOREIGN KEY (MediaHarSjanger) REFERENCES Sjanger(SjangerID));

CREATE TABLE Serie (
   SerieID					INTEGER NOT NULL UNIQUE,
   Navn							VARCHAR(30),
   StartAar					INTEGER,
   SluttAar					INTEGER,
   Storyline				VARCHAR(200),
   CONSTRAINT				Serie_PK PRIMARY KEY (SerieID));
   

CREATE TABLE Episode (
   MedieID				INTEGER NOT NULL UNIQUE,
   EpisodeNr			INTEGER NOT NULL,
   Navn						VARCHAR(30),
   Spilletid			INTEGER,
   Storyline			VARCHAR(200),
   CONSTRAINT 		Serie_PK PRIMARY KEY (MedieID));

CREATE TABLE Selskap (
   SelskapsID   	INTEGER NOT NULL UNIQUE,
   Adresse				VARCHAR(30),
   Navn						VARCHAR(30),
   Nasjonalitet 	VARCHAR(30),
   SelskapEierMedia		VARCHAR(20),
   FilmID					INTEGER,
   SerieID				INTEGER,
   CONSTRAINT Selskap_FK_1 FOREIGN KEY (FilmID) REFERENCES Film(FilmID),
   CONSTRAINT Selskap_FK_2 FOREIGN KEY (SerieID) REFERENCES Serie(SerieID));

CREATE TABLE Anbefalinger (
   BrukerID    	INTEGER NOT NULL UNIQUE,
   MedieID  	VARCHAR(30) UNIQUE,
   Dato			DATE,
   Rating		INT); 

   CREATE TABLE Kommentarer (
   BrukerID		INTEGER NOT NULL UNIQUE,
   MedieID    	VARCHAR(30) UNIQUE,
   Kommentar  	VARCHAR(500),
   Dato			DATE,
   CONSTRAINT Media_FK_1 FOREIGN KEY (BrukerID) References Film(MedieID),
   CONSTRAINT Media_FK_2E FOREIGN KEY (BrukerID) References Episode(MedieID));
   
CREATE TABLE Brukere (
   BrukerID    	INTEGER NOT NULL UNIQUE,
   Brukernavn  	VARCHAR(30) UNIQUE,
   Score		DATE,
   KommentarID	INTEGER,
   AnbefalingID	INTEGER,
   CONSTRAINT Bruker_PK PRIMARY KEY (BrukerID),
   CONSTRAINT Kommentar_FK FOREIGN KEY (KommentarID) REFERENCES Kommentarer(BrukerID),
   CONSTRAINT Anbefaling_FK FOREIGN KEY (AnbefalingID) REFERENCES Anbefalinger(BrukerID));
