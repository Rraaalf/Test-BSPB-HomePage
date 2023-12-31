# language: ru
Функция: проверка появления сообщения о неправильном вводе пароля на странице авторизации

  @success
  Структура сценария: появление сообщения о неправильном вводе пароля на странице авторизации
    Дано пользователь находится на главной странице БСПБ
    Когда пользователь нажимает на кнопку "Войти"
    Тогда открывается страница "Авторизация"
    Когда пользователь вводит "<Логин>" и "<Пароль>" и нажимает кнопку авторизации
    Тогда появляется сообщение о неправильном вводе пароля

    Примеры:
      | Логин | Пароль   |
      | admin | admin    |
      | login | password |