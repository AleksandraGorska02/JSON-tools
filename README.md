# JSON-tools
![Java CI](https://github.com/AleksandraGorska02/JSON-tools/actions/workflows/ci.yml/badge.svg)

Aplikacja dla programistów, którzy potrzebują przeformatować lub filtrować struktury danych zapisane w formacie JSON a także porównać ze soba struktury. JSON tools pozwala zarówno na zminifikowanie niezminifikowanej reprezentacji JSON, a także na operację odwrotną (z dodaniem wszelkich odstępów i nowych linii). Aplikacja jest dostębna jako zdalne API, dzieki czemu można ją zintegrować z istniejącymi narzędziami.

Po włączeniu aplikacji, uruchomi się ona na porcie 8080 na localhost.
Natępnie należy wysłać rządanie do strony ze strukturą danych zapisaną w formacie JSON. Po ukośniku wpisać nazwę funkcji (do wyboru: expand, remove, mini). Jeśli nie wpisze się żadnej nazwy funkcji to zwrócone zostaną niezmienione dane wejściowe.
