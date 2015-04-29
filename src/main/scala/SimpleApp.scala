import com.typesafe.config.ConfigFactory

object SimpleApp extends App {

  val conf = ConfigFactory.load()
  println("org.mbari.test = " + conf.getString("org.mbari.test"))
}