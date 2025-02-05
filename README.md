
# REST API Сервис с использованием Spring Boot

Этот проект представляет собой REST API сервис, созданный с использованием Spring Boot, который принимает данные от условного "сенсора". Сенсор будет отправлять HTTP-запросы с измерениями, содержащими информацию о температуре и погодных условиях.

## Содержание

1. [Описание](#описание)
2. [Запуск проекта](#запуск-проекта)
3. [Документация OpenAPI](#документация-openapi)
4. [Настройки](#настройки)
5. [Аутентификация](#аутентификация)

## Описание

Этот проект реализует REST API, который получает данные от сенсора и обрабатывает их. Сервис поддерживает получение измерений, таких как температура и погодные условия, и предоставляет возможность хранения данных в базе данных. Сервис также использует Docker для контейнеризации и упрощения развертывания.

### Основные функции:
- Получение измерений от сенсора через HTTP-запросы.
- Хранение данных в базе данных PostgreSQL.
- Генерация и использование токенов JWT для аутентификации.

## Запуск проекта

### 1. Установите зависимости:
Для успешного запуска проекта убедитесь, что у вас установлены следующие инструменты:
- **Docker**: для контейнеризации приложения и базы данных.
- **Docker Compose**: для управления многоконтейнерными приложениями.

### 2. Соберите Docker-образ приложения:
Перейдите в корневую директорию проекта и выполните команду для сборки Docker-образа:

```bash
docker build .
```

### 3. Запустите контейнеры с помощью Docker Compose:
После успешной сборки образа, используйте Docker Compose для запуска приложения и базы данных:

```bash
docker-compose up --build -d
```

Это создаст и запустит два контейнера:
- Контейнер с приложением Spring Boot (порт 8080).
- Контейнер с базой данных PostgreSQL (порт 5454).

### 4. Проверка работы приложения:
После того как контейнеры запустятся, ваше приложение будет доступно по адресу:

```
http://localhost:8080
```

## Документация OpenAPI

Все описание API (эндпоинты, параметры и схемы) хранится в файле `openapi.yaml`, расположенном в папке:

```
src/main/resources/static/openapi.yaml
```

Вы можете использовать этот файл для интеграции с другими системами или для тестирования с помощью Swagger UI.

## Настройки

Для подключения к базе данных PostgreSQL и настройки приложения используйте следующие переменные окружения:

```yaml
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5454/postgres
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
SPRING_DATASOURCE_DRIVER=org.postgresql.Driver
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```

Эти параметры настроены в Docker Compose и автоматически применяются при запуске контейнеров.

## Технологии

- **Spring Boot**: основная платформа для разработки REST API.
- **PostgreSQL**: база данных для хранения измерений.
- **Docker**: для контейнеризации приложения и базы данных.
- **Docker Compose**: для упрощения управления многоконтейнерными приложениями.
- **JWT**: для аутентификации пользователей.
- **OpenAPI**: для описания API.

## Аутентификация

Перед тем как пользоваться нужно зарегестрировать "сенсор" по эндпойнту

```
http://localhost:8080/sensors/regisrtation
```

После нужно получить токен для работы с другими эндпойнтами по адресу

```
http://localhost:8080/sensors//generateToken
```

Полученный токен нужно отправлять в заголовке вместе с запросом
