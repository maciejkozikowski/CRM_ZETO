Folder naszego projektu to "crm"

Wersja Javy
jdk1.8.0_201

Wersja Spring Boot 1.5.20

Pamiętamy o bazie danych (na razie Xampp, nazwa bazy crm)

tabela znajduje się w pliku klienci.sql

Pliki, które nas najbardziej interesują znajdują się w folderze src/main

Aby odpalić aplikację, należy:
1. Odpalić bazę w Xamppie
2. Odpalić backend w Spring-Boot
3. Odpalić frontend w Angularze (sprawdzić wcześniej czy istnieje katalog node_modules
	jeżeli nie, wpisać w terminalu npm install)
4. W przeglądarce wybrać localhost:4200/clients (poczekać, aż się wszystko uruchomi)

Co robi FRONT-END?
Zajmuje się wyglądem strony oraz zapytaniami do BACK-ENDu i wyświetlanie ich

Co robi BACK-END?
Zajmuje się połączeniem z bazą danych oraz obsługą zapytań do FRONT-ENDu (w postaci JSON)

FRONT-END

katalog CRM_ZETO/Front/crm/src/app

Pisane w Angularze (nie AngularzeJS)

Components - komponenty danego CRUDA (lub części)
Models - potrzebne klasy odpowiadające tabeli
Services - tu tworzymy odpowiednie linki
app-routing.module.ts - tu wpisujemy ścieżki odpowiadające danym komponentom

BACK-END

katalog CRM_ZETO/crm/src/main/java/oby_na_trzy/crm

plik CrmApplication - tutaj uruchamia się nasza aplikacja - NIE RUSZAĆ!
katalog controller - tutaj zwracane są nazwy plików html, które mają się załadować po wpisaniu danego adresu
katalog model - tutaj znajdują się pliki z klasami naszych rekordów w tabelach lub formularzach
katalog repository - tutaj znajdują się interfejsy do klas tabel
katalog resource - tutaj tworzymy metody CRUD-a do danej tabeli
Szczegóły w poszczególnych plikach
Proszę o niemodyfikowanie bez potrzeby plików application.properties, application.yml oraz pom.xml
Gdyby jakieś importy nie wczytały się automatycznie to na elemencie zaznaczonym na czerwono klikamy alt + enter