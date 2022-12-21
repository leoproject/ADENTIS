
import scala.collection.Map
import scala.collection.mutable.HashMap
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Application {

  def main(args: Array[String]): Unit = {

    var result: HashMap[String, Integer] = new HashMap[String, Integer]()
    val service: Service = new Service()
    if (args.length == 1) {
      var months: Array[String] = args(0).split("-")
      println(" Group: " + args(0))
      result = filterByMonthsInterval(months(0), months(1))
    } else if (args.length > 1) {
      println("Result")
      result = filterByDateInterval(args(0), args(1))
    }

    if (!result.isEmpty) {
      result.foreach(res => println(res))
    } else {
      println("Not found")
    }
  }

  private def filterByMonthsInterval(init: String, end: String): HashMap[String, Integer] =
    try {
      val initMonth: Integer = int2Integer(Integer.parseInt(init))
      val endMonth: Integer = int2Integer(Integer.parseInt(end))
      if (initMonth > endMonth) {
        null
      }
      val service: Service = new Service()
      service.filterOrdersBySpecificInterval(initMonth, endMonth)
    } catch {
      case e: NumberFormatException => {
        println("error: " + e.getMessage)
        null
      }

    }

  private def filterByDateInterval(dateInitStr: String, dateEndStr: String): HashMap[String, Integer] =
    try {
      val dateInit: LocalDateTime = convertStrToDate(dateInitStr)
      val dateEnd: LocalDateTime = convertStrToDate(dateEndStr)
      val service: Service = new Service()
      service.filterAllOrders(dateInit, dateEnd)
    } catch {
      case e: NumberFormatException => {
        println("*** error: " + e.getMessage)
        null
      }

    }

  def convertStrToDate(dateStr: String): LocalDateTime = {
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    LocalDateTime.parse(dateStr, formatter)
  }

}

