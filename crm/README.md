Folder naszego projektu to "crm"

Wersja Javy
jdk1.8.0_201

Wersja Spring Boot 1.5.20

Pamiętamy o bazie danych (na razie Xampp, nazwa bazy crm)

tabela znajduje się w pliku klienci.sql

Pliki, które nas najbardziej interesują znajdują się w folderze src/main

FRONT-END

katalog resources/templates - tutaj znajdują się pliki html do wystylizowania

O tym jak je połączyć ze Spring Boot w html-ach

BACK-END

katalog oby_na_trzy/crm

plik CrmApplication - tutaj uruchamia się nasza aplikacja - NIE RUSZAĆ!

katalog controller - tutaj zwracane są nazwy plików html, które mają się załadować po wpisaniu danego adresu

katalog model - tutaj znajdują się pliki z klasami naszych rekordów w tabelach lub formularzach

katalog repository - tutaj znajdują się interfejsy do klas tabel

katalog resource - tutaj tworzymy metody CRUD-a do danej tabeli

Szczegóły w poszczególnych plikach

Proszę o niemodyfikowanie bez potrzeby plików application.properties, application.yml oraz pom.xml

Gdyby jakieś importy nie wczytały się automatycznie to na elemencie zaznaczonym na czerwono klikamy alt + enter

Po odpaleniu aplikacji trzeba się zalogować:
login: user
hasło: pokaże się w konsoli np.:

Using default security password: 60cfa1d3-cfbe-4070-b922-8c5154ab8823