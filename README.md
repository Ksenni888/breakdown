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
![Static Badge](https://img.shields.io/badge/1.5.18%20-%20green?label=logback-classic)
![Static Badge](https://img.shields.io/badge/1.5.18%20-%20green?label=logback-core)
![Static Badge](https://img.shields.io/badge/2.0.17%20-%20green?label=slf4j-api)
![Static Badge](https://img.shields.io/badge/4.0.0%20-%20green?label=maven)

# Как работает приложение.
-----------------------------------------------------------------------------------------
После того, как приложение запущено в IntelliJ IDEA или через jar файл, откройте командную строку (win+r в windows -> cmd).
В командной строке введите команду, например:
C:\Users\ПК>java -jar C:\Downloads\un.jar in4.txt -p simpl- -f
При выполнении этой команды из файла in4.txt будут созданы новые файлы с различными переменными, при этом к каждому добавится префикс "simpl-", в командной строке отобразится полная статистика.  

