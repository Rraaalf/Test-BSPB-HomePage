# language: ru
Функция: проверка отображения кнопок на главной странице сайта БСПБ


  @success
  Сценарий: при входе на главную страницу сайта БСПБ вверху страницы отображаются все необходимые кнопки

    Дано пользователь находится на главной странице БСПБ
    И отображаются кнопки
      | Частным клиентам |
      | Бизнесу          |
      | ВЭД              |
      | Финансовые рынки |
      | Private Banking  |
      | Инвесторам       |
      | Войти            |