### REST API

## Short summary

    1. POST /user
    2. PUT /user
    3. DELETE /user
    4. POST /user/auth
    5. POST /user/{userId}/chat/new
    6. PUT /chat
    7. DELETE /chat/{chatId}
    8. GET /user/{userId}/chats
    9. POST /user/{userId}/chat/{chatId}
    10. POST /chat/{chatId}/member/{memberId}
    11. DELETE /chat/{chatId}/member/{memberId}
    12. GET /users?name=''
    13. SEND* /chat/{chatId}/message/new 
    14. SUBSCRIBE* /chat/{chatId}/message
    15. SEND* /chat/{chatId}/note/new
    16. SUBSCRIBE* /chat/{chatId}/note
    
## Full Specification

    1. POST /user - создание пользовательского аккаунта
    2. PUT /user - обновление данных о пользователи
    3. DELETE /user - удаление пользователя
    4. POST /user/auth - аутентификация пользователя
    5.1 GET /user/{userId} - поиск пользователя
    5.2 POST /user/{userId}/chat/new - создание нового чата
    6. PUT /chat - обновление данных о чате
    7. DELETE /chat/{chatId} - удаление чата
    8. GET /user/{userId}/chats - получения списка чатов пользователя - добавление пользователя в чат
    10. POST /chat/{chatId}/member/{memberId} - добавление пользователя в чат
    11. DELETE /chat/{chatId}/member/{memberId} - удаление пользователя из чата
    12. GET /users?name='' - поиск пользователя по имени
    13. SEND* /chat/{chatId}/message/new - отправка сообщения 
    14. SUBSCRIBE* /chat/{chatId}/message - получение сообщения
    15. SEND* /chat/{chatId}/note/new - отправка заметок
    16. SUBSCRIBE* /chat/{chatId}/note - получение заметок