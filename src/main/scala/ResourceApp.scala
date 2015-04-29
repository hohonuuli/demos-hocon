object ResourceApp extends App {

  val resource = new Resource("sql/users.sql")
  println("Insert = " + resource("insert").getOrElse("FAILED"))
}