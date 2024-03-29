# Планирование автоматизации

## Перечень автоматизируемых сценариев

### 1. UI тесты
#### Позитивные сценарии:
- Покупка тура за собственные средства (вводим валидные данные)
- Покупка тура в кредит (вводим валидные данные)

#### Негативные сценарии:

- Покупка тура за собственные средства (вводим невалидные данные)
- Покупка тура в кредит (вводим невалидные данные)
### 2. Проверка поддержки заявленных СУБД
- MySQL
- Postgres
  ##Перечень используемых инструментов
  **1. Intellij IDEA 2022.2 (Community Edition):**
    - Позволяет вести разработку на **Java 11**
    - обнаруживает ошибки и предоставляет предложения по улучшению кода;
    - автоматически дополняет код, учитывая контекст;
    - Предоставялет возможность без проблем подключать различные модули:
        - инструменты для проведения автоматических тестов и формирования аналитики, **используемые для реализации проекта по автоматизации**:
            - junit-jupiter
            - mysql
            - postgreSQL
            - commons-dbutils
            - lombok
            - selenide
            - allure
            - report portal

**2. Gradle:**

- предоставляет набор методов управления зависимостями, которые совместимы с Maven и Ivy.

**3. Docker**

- это программная платформа для быстрой разработки, тестирования и развертывания приложений
- Docker-compose позволяет развернуть и настроить все приложения одной командой

**4. GitHub**

- Крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки

**1. Google Chrome**

- Google Chrome имеет большое количество расширений для улучшения функциональных возможностей браузера для особых нужд
- Наличие мощной консоли разработчика

# Перечень и описание возможных рисков при автоматизации

- проблема совместимости Docker с Windows
- несовместимость SUT с MySQL/Postgres
- отсутствие доступа с заявленными входными данными при запуске SUT
- заявленный функционал не работает
- Так как отсутсвуют явные требования к работе приложения, возможна избыточность автоматизированных сценариев
- Используются изолированные входные данные для тестов что сужает возможности выявления багов

# Интервальная оценка с учётом рисков (в часах)

- Создание проекта и настройка тестового окружения: 8ч
- Написание автотестов: 24ч
- Формирование и анализ отчетов: 8ч

# План сдачи работ

- Подготовка тестового окружения, запуск приложения: 12.12.2022
- Написание автотестов,тестирование: 26.12.2022
- Формирование reports + отчетные документы автоматизации/тестирования: 30.12.2022
