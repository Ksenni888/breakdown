# breakdown
# Описание.
-----------------------------------------------------------------------------------------
Утилита записывает разные типы данных в разные файлы. Целые числа в один выходной файл, вещественные в другой, строки в третий.

## Функции приложения: 
При запуске утилиты в командной строке подается несколько файлов, содержащих в перемешку целые числа, строки и вещественные числа. В качестве разделителя
используется перевод строки. Строки из файлов читаются по очереди в соответствии с их перечислением в командной строке.
По умолчанию файлы с результатами располагаются в текущей папке с именами integers.txt, floats.txt, strings.txt.

Дополнительно с помощью опции -o нужно уметь задавать путь для результатов. 
Опция -p задает префикс имен выходных файлов. 
Например -o /some/path -p result_ задают вывод в файлы /some/path/result_integers.txt, /some/path/result_strings.txt и тд.

По умолчанию файлы результатов перезаписываются. 
С помощью опции -a можно задать режим добавления в существующие файлы.
Если какого-то типа данных во входящих файлах нет, то исходящий файл не создается.

В процессе фильтрации собирается статистика по каждому типу данных.
Статистика двух видов: краткая и полная. 
Выбор статистики производится опциями -s и -f соответственно. 
Краткая статистика содержит только количество элементов записанных в исходящие файлы. 
Полная статистика для чисел дополнительно содержит минимальное и максимальное значения, сумма и среднее.
Полная статистика для строк, помимо их количества, содержит также размер самой короткой строки и самой длинной.
Статистику по каждому типу отфильтрованных данных утилита выводит в консоль.

# Развертывание.
-----------------------------------------------------------------------------------------
Клонируйте репозиторий ( ссылка для клонирования: (https://github.com/Ksenni888/breakdown) и запустите приложение в IntelliJ IDEA. 
Также можно скачать jar файл: https://github.com/Ksenni888/breakdown/tree/main/out/artifacts/un_jar.
По умолчанию искомые файлы и создаваемые находятся по адресу: C:/some/path/. Если такой папки нет, нужно создать.

# Версии. 
-----------------------------------------------------------------------------------------
![Static Badge](https://img.shields.io/badge/11.0.18%20-%20green?label=java%20version)
![Static Badge](https://img.shields.io/badge/2.7.14%20-%20green?label=org.springframework.boot)
![Static Badge](https://img.shields.io/badge/1.18.20%20-%20green?label=lombok)


# Как работает приложение.
-----------------------------------------------------------------------------------------
После того, как приложение запущено в IntelliJ IDEA, откройте Postman или Insomnia.
Чтобы отправить запрос, сначала найдите HTTP-метод (например: GET) и введите путь для операции (например: http://localhost:8080/films/).

# API 
-----------------------------------------------------------------------------------------
|*Фильм*         | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Добавление фильма | POST | /films |
| Получение всех фильмов | GET | /films |
| Обновление фильма | PUT | /films |
| Список из первых count фильмов по количеству лайков. Если значение параметра count не задано, верните первые 10 | GET | /films/popular?count={count} |


|*Жанры*| *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список всех жанров | GET | /genres |
| Получение жанра по идентификатору | GET | /genres/{id} |

```
 // Пример возвращаемого значения
 {
   “id”: 1,
   “name”: “Комедия”
 }
```

|*Рейтинг*         | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список всех рейтингов | GET | /mpa |
| Получение рейтинга по идентификатору | GET | /mpa/{id} |

```
// Пример возвращаемого значения
 {
   “id”: 1,
   “name”: “G”
 }
```

|*Пользователь*           | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Cоздание пользователя | POST | /users |
| Обновление пользователя | PUT | /users |
| Получение списка всех пользователей | GET | /users |
| Добавление в друзья | PUT | /users/{id}/friends/{friendId} |
| Удаление из друзей | DELETE | /users/{id}/friends/{friendId} |
| Список пользователей, являющихся его друзьями | GET | /users/{id}/friends |
| Список друзей, общих с другим пользователем | GET | /users/{id}/friends/common/{otherId} |
| Пользователь ставит лайк фильму | PUT | /films/{id}/like/{userId} |
| Пользователь удаляет лайк | DELETE | /films/{id}/like/{userId} |




MIRO: https://miro.com/app/board/uXjVMlUbaOM=/?share_link_id=291461665058  
SQL trainer: http://sqlfiddle.com/#!17/9b6a67/1  
Template repository for Filmorate project.  
![Screenshot of a scheme filmorate.](https://raw.githubusercontent.com/Ksenni888/java-filmorate/main/scheme(2).jpg)

Examples of request:
```
SELECT *
FROM film;
```
```
SELECT *
FROM users;
```
```
SELECT *
FROM genre;
```
```
SELECT *
FROM friendship;
```
```
SELECT *
FROM likeIds;
```
```
SELECT 
film_id,
COUNT(user_id)
FROM likeIds
GROUP BY film_id;
```
```
SELECT 
film.name,
genre_name
FROM film
LEFT OUTER JOIN genre ON genre.film_id = film.film_id
GROUP BY genre.genre_name, film.name
ORDER BY film.name;
```
```
SELECT
users.user_id,
friendship.friend_id,
friendship.status
FROM users
LEFT JOIN friendship ON users.user_id = friendship.user_id;
```

![Static Badge](https://img.shields.io/badge/IntegelIdea-blue)
![Static Badge](https://img.shields.io/badge/H2-green)
![Static Badge](https://img.shields.io/badge/Postman-orange)



