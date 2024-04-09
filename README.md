Требуется создать простейший движок форума/доски объявлений (только backend). 
Суть задачи: 
Есть топики (темы), в каждом топике может быть одно или более сообщений. 
Движок должен обеспечивать хранение в БД (IMDB) и CRUD операции с топиками (темами) и сообщениями в топиках.
Топик должен содержать заголовок (название темы). Топик не может быть пустым, т.е. должен содержать как минимум одно сообщение.
Сообщение должно содержать имя (ник) автора, текст сообщения, дату создания. 
Сообщение обязательно должно относиться к одному из топиков.
Необходимо реализовать клиентский REST-API позволяющий пользователю:
·   получать список топиков
·   получать сообщения в указанном топике
·   создать топик (с первым сообщением в нем)
·   создать сообщение в указанном топике
·   отредактировать свое сообщение
·   удалить свое сообщение

Язык – Java (Spring или Spring Boot - по желанию)
Автоматизация сборки – Maven (Gradle)
Хранилище – in-memory DB (скрипт по наполнению тестовыми данными приветствуется)
