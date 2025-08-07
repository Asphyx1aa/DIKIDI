# 📱 Проект по автоматизации тестирования DIKIDI

Этот репозиторий содержит автотесты для двух мобильных приложений компании DIKIDI:
- **DIKIDI Business** — приложение для специалистов и компаний
- **DIKIDI Online** — приложение для клиентов, осуществляющих онлайн-запись

## 🗂 Структура проекта

<details>
<summary>Нажми, чтобы развернуть дерево</summary>

```
src
└── test
    └── java
        └── ru.dikidi
            ├── business         # Тесты и страницы для DIKIDI Business
            │   ├── pages        # Page Object классы
            │   └── tests        # UI и API тесты
            │       └── api      # API тесты для business
            ├── online           # Тесты и страницы для DIKIDI Online  
            │   ├── pages        # Page Object классы
            │   └── tests        # UI тесты
            └── common           # Общие модули и утилиты
                ├── annotations  # Кастомные аннотации
                ├── api          # Steps для взаимодействия с API
                ├── base         # Базовые TestBase классы
                │   ├── BaseTestBase.java    # Общий базовый класс
                │   ├── WebTestBase.java     # Для UI тестов
                │   └── ApiTestBase.java     # Для API тестов
                ├── config       # Конфигурации (Owner library)
                ├── context      # Контекст
                ├── data         # Тестовые данные 
                ├── extensions   # JUnit 5 расширения
                ├── helpers      # Утилиты и Allure attachments
                ├── models       # DTO/POJO модели для API
                ├── specs        # RestAssured спецификации
                └── utils        # Общие утилиты
```

</details>

## 📦 Описание папок

| Папка            | Назначение                                                                 |
|------------------|---------------------------------------------------------------------------|
| `business/`      | Логика и тесты, относящиеся к приложению **DIKIDI Business**              |
| `online/`        | Логика и тесты, относящиеся к приложению **DIKIDI Online**                |
| `common/`        | Общие модули: конфигурации, утилиты, модели, контекст и т.д.              |

## ✅ Как запускать тесты

Убедитесь, что установлены все зависимости и настроено окружение.

Пример запуска всех тестов:

```bash
# Запуск всех тестов
./gradlew clean test

# Запуск с отчетом Allure
./gradlew clean test allureReport

# Запуск по тегам
./gradlew appointments_test    # Тесты записи
./gradlew auth_tests          # Тесты авторизации

# Переопределение конфигурации
./gradlew test -DbrowserSize=1920x1080 -Dbrowser=firefox -DbaseUrl=https://dikidi.tech/ru/
```

## 🔧 Используемый стек

- Java 21
- JUnit 5
- Gradle
- Appium (мобильные тесты)
- Selenide (Web)
- Rest-Assured (API)
- Allure (отчёты)