import com.typesafe.config.ConfigFactory
import scala.util.Try

class Resource(resource: String) {

  val config = ConfigFactory.load(resource)

  def apply(key: String): Option[String] = Try(config.getString(key)).toOption

}