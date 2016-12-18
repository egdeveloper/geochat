### Geo Application Control HW

## 1. Требования

## 2. Распределение задач
        
    2.1 Ирина
    
        2.2.1 Разработка интерфейса главной страницы
        2.1.2 Разработка интерфейса страницы регистрации и аутентификации
        2.1.3 Создание чата с возможностью шаринга
        2.1.4 Визуализация аналитики 
        2.1.5 Декодирования местоположения, поиск по тегам и ключевым словам
        
    2.2 Павел
        
        2.2.1 Написать логику регистрации пользователя
        2.2.2 Написать логику аутентификации пользователя
        2.2.3 Разработать личную страницу пользователя с возможностью
              редактирования личных данных
        2.2.4 Добавление собеседников в чат (по ссылке и на самом сайте)
        2.2.5 Получение аналитики с сервера
        
### 3. Подробная инструкция работы

        Ирина:
        1. Выполнить в консоле git clone https://github.com/vespera128bit/geochw
        2. В Idea открыть папку с загруженным проектом
        3. Если появится сообщение "Maven: Enable Auto-Import", нажимайте на него
        4. Попробовать запустить. Если не получится, то пишите мне. Предварительно отправьте скриншот
        5. В папке /src/main/resources открыть файл для редактирования index.html 
        6. Файл index.html служит главной страницей 
        7. В нем нужно будет выполнить задачи 2.2.1, 2.2.2
        
        Павел:
        1. Выполнить в консоле git clone https://github.com/vespera128bit/geochw
        2. В Idea открыть папку с загруженным проектом
        3. Если появится сообщение "Maven: Enable Auto-Import", нажимайте на него
        4. Попробовать запустить. Если не получится, то пишите мне. Предварительно отправьте скриншот
        5. Добавить код регистрации и аутентификации пользователя в index.html, 
        привязать логику к интерфейсу, разработанному Ириной в п. 7
        
### 4. Технологии

    1. PostgreSQL
    2. Postgis
    3. Leaflet
    4. Leaflet Draw, Drag
    5. Terraformer WKT reader
    6. Geohash
    7. Spring MVC, JDBC, WebSocket
    8. Google Protobuffers
    9. JSTS
    10. Plotly
    11. CartoDB (optional)
    
### 5. REST API

    1. POST /user
    2. PUT /user
    3. DELETE /user
    4. POST /user/auth
    5. POST /user/{userId}/chat/new
    6. PUT /chat
    7. DELETE /chat
    8. GET /user/{userId}/chats
    9. POST /user/{userId}/chat/{chatId}
    10. SEND* /chat/{chatId}/message/new 
    11. SUBSCRIBE* /chat/{chatId}/message/broacast
    12. SEND* /chat/{chatId}/note/new
    13. SUBSCRIBE* /chat/{chatId}/note/broadcast
    
    * STOMP 