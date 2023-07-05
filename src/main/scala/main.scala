object main extends App {
  //Основной класс. Определены константы для количество учётных записей по типу.
  //Вызваны методы заполнения базы данных соответствующим количеством учетых записей и заполнения кэша.
  // Вызван метод кэша для создания постов.


  val NUMBER_TIKTOK_BLOGGERS: Int = 5
  val NUMBER_INSTA_BLOGGERS: Int = 5
  val NUMBER_MIXED_BLOGGERS: Int = 5


  ServiceFunc.createAccounts("instagram", NUMBER_INSTA_BLOGGERS)
  ServiceFunc.createAccounts("tiktok", NUMBER_TIKTOK_BLOGGERS)
  ServiceFunc.createAccounts("mix", NUMBER_MIXED_BLOGGERS)
  ServiceFunc.fillCash()
  Cash.postToInstagram()
}
