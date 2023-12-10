# TaskManager (Workshop 1)

# Wstęp
Celem warsztatu jest wytworzenie programu konsolowego do zarządzania zadaniami: Tasks.

Dane do zasilenia naszego programu będziemy przechowywać w pliku tekstowym w formacie CSV.

Będą one w następującym formacie:

> - Simple task - very important, 2020-03-09, true,
> - Second task not so important, 2020-05-10, false,
> - Throw away trash, 2020-03-09, false.

Aplikacja musi posiadać możliwość wpisywania komend i wykonywania odpowiednich operacji w zależności od komendy, która została wpisana.

Aplikacja musi posiadać następujące funkcje:

> - wyświetlanie wszystkich dostępnych zadań,
> - wyjście z aplikacji,
> - dodanie zadania,
> - usuwanie zadania,
> - wczytywanie danych z pliku przy starcie aplikacji,
> - zapis danych do pliku,
> - sprawdzanie poprawność wartości liczbowej podczas usuwania.

W projekcie tym użyto praktycznie wszystkie rzeczy o których mówiliśmy podczas tego modułu takie jak:

> - metody,
> - wczytywanie danych,
> - tablice wielowymiarowe,
> - czytanie plików,
> - zapis danych do plików,
> - import oraz wykorzystanie zewnętrznych bibliotek.

# Kolejność pracy

## Jak zacząć pracę z tym projektem?

### Repozytorium
Na początek stwórz nowe repozytorium! Szczegółowy opis tego, jak to zrobić, znajduje się w temacie Przygotowanie repozytorium. Po wykonaniu opisanych tam czynności, wróć do tego artykułu.

Utwórz projekt **Maven** wybierając w IntelliJ: **File->New->Project** następnie z lewego panelu wybieramy opcję **New Project**:
Określamy nazwę projektu oraz jego lokalizację.

W pozycji **Build system** wybieramy **Maven**.

Opcjonalnie rozwijamy opcję **Advanced Settings** i wypełniamy:

* GroupId : **pl.coderslab**,
* ArtifactId : **TaskManager**.

W projekcie utwórz pakiet pl.coderslab. W pakiecie utwórz klasę **TaskManager** w niej umieść cały kod programu.

Połącz kod projektu z utworzonym repozytorium, wykonując poniższe komendy:

> - git init
> - git add *
> - git commit -m "first commit"
> - git branch -M main

**git init** - jest to polecenie, które zainicjuje repozytorium gita w katalogu, w którym aktualnie się znajdujemy. Po jej wykonaniu zostanie utworzony podkatalog o nazwie .git, zawierający wszystkie niezbędne pliki — szkielet repozytorium.

**git add** * - dodaje pliki do repozytorium,

**git commit -m "first commit"** - utworzy pierwszy commit dla projektu,

**git branch -M main**- zmienia domyślną nazwę głównego brancha master na zalecaną main.

Ostatnim etapem jest połączenie lokalnego repozytorium z utworzonym na github.com. Operację tą umożliwia polecenie: **git remote add origin repository_address**. W poleceniu tym musisz zamienić **repozotiry_address** własnym adresem repozytorium, analogicznie jak w poniższym przykładzie:

> - git remote add origin https://github.com/arek-jozwiak-coderslab/TaskManagerSample.git

Jeżeli korzystasz z ssh, polecenie może wyglądać następująco:

> - git remote add origin git@github.com:arek-jozwiak-coderslab/TaskManagerSample.git

Następnie wyślij zmiany za pomocą polecenia:

> - git push -u origin main

W pliku **pom.xml** dodaj zaleźność do **Apache Commons Lang**:

    <dependencies>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.9</version>
        </dependency>
    </dependencies>

### Zasoby
Do tego tematu, została przygotowana paczka z wszystkimi zasobami potrzebnymi do stworzenia projektu Tasks:

* dodatkowa klasa zawierająca zdefiniowane kolory **ConsoleColors**,
* plik **tasks.csv** - zawiera przykładowe zadania,
* biblioteka **Apache Commons Lang** (jeżeli dodasz zależność w pliku **pom.xml** - nie ma potrzeby dołączać tego pliku),
* plik **.gitignore (pamiętaj w Ubuntu plik, którego nazwa rozpoczyna się od kropki, jest plikiem domyślnie ukrytym)**.

Rozpoczynając pracę nad projektem, wykonaj następujące kroki:

1. Pobierz plik "Zasoby do projektu.zip",
2. Następnie rozpakuj archiwum używając dowolnego narzędzia,
3. Skopiuj do projektu klasę **ConsoleColors**,
4. Załącz do projektu bibliotekę **Apache Commons Lang**.

Twoje repozytorium powinno zawierać teraz tylko folder **src** ze wszystkimi plikami projektu.

### Testuj na bieżąco
Dodając każdą z nowych funkcjonalności testuj działanie programu. Nie staraj się zrobić całego warsztatu od razu. Jeżeli masz z czymś problem używaj debugera aby krok po kroku śledzić działanie programu.

### Metody
Rozpocznij pracę od dodania metody **main** w klasie **TaskManager**.

Początkowo całość kodu możesz zawrzeć w tej metodzie a dopiero później sukcesywnie wydzielać go do oddzielnych metod. W pierwszym kroku dodaj wczytywanie i wyświetlanie danych z pliku.
