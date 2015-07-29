import com.typesafe.config.ConfigFactory
import scala.collection.JavaConverters._
import scala.util.Try

class Resource(resource: String) {

  val config = ConfigFactory.load(resource)

  def apply(key: String): Option[String] = Try(config.getString(key)).toOption

  def dump(): Unit = {
    val entries = config.entrySet.asScala.toList.sortBy(_.getKey)
    val longestKeySize = entries.maxBy(_.getKey.size).getKey.size

    config.entrySet.asScala.toList.sortBy(_.getKey).foreach(entry => {
      val key = entry.getKey
      val keyString = key + " " + "." * (longestKeySize - key.size - 1)
      val value = entry.getValue.render()
      println(s"${keyString} ${value}")
    })
  }

}