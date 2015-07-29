import com.typesafe.config.ConfigFactory
import scala.collection.JavaConverters._

object VARSQueryApp extends App {

  val conf = ConfigFactory.load("vars/vars-query")
  println("vars.query.column.groups = \n" + conf.getObject("vars.query.column.groups"))
  println("vars.query.column.groups.Dive = \n" + conf.getStringList("vars.query.column.groups.Dive"))

  val groups = conf.getObject("vars.query.column.groups")
  val groupNames = groups.keySet.asScala
  val groupsConf = groups.toConfig
  for (name <- groupNames) {
    val columns = groupsConf.getStringList(name).asScala
    println(s"\t$name -> ${columns.mkString(", ")}")
  }

}
