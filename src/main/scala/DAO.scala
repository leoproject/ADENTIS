import java.time.{LocalDateTime, Month}
import scala.collection.mutable.ArrayDeque
class DAO {

	val Ipad: String = "iPad Air APPLE "
	val Laptop: String = "LENOVO Yoga Slim 7"
	val Sport: String = "MOMA BIKES"
	
	def createProducts() : List[Product] = {
	  val recentDate = LocalDateTime.of(2018, Month.JANUARY, 29, 10, 30, 40)
	  val middleDate = LocalDateTime.of(2019, Month.NOVEMBER, 15, 9, 30, 40)
	  
	  val ipad = new Product(Ipad, "electronic", recentDate, BigDecimal("709.99"))
	  val laptop = new Product(Laptop, "computer", middleDate, BigDecimal("1299.00"))
	  
	  List(ipad, laptop)
	}
	
	private def createItems() : ArrayDeque[Item] = {
	  val products = createProducts();
	  var items = ArrayDeque[Item]()
		products.foreach(prod => {
      val item: Item = new Item(prod.price, BigDecimal("50.0"), BigDecimal("75"), 1,prod)
      items += item
	  })
	  items
	}
	
	private def createOrdersIpad(item: Item) : List[Order] = {
	  val date1 = LocalDateTime.of(2018, Month.FEBRUARY, 10, 10, 33, 50)
	  val order1 = new Order("Leonardo", "937161348", "Braga", BigDecimal("2500"), date1, Set(item))
	  
	  val date2 = LocalDateTime.of(2018, Month.MARCH, 20, 15, 33, 50)
	  val order2 = new Order("Jesus", "937161348", "Braga", BigDecimal("2700"), date2, Set(item))
	  
	  val date3 = LocalDateTime.of(2018, Month.JANUARY, 10, 10, 33, 50)
	  val order3 = new Order("Silva", "937161348", "Braga", BigDecimal("2233"), date3, Set(item))

	  
	  val date4 = LocalDateTime.of(2018, Month.OCTOBER, 20, 15, 33, 50)
	  val order4 = new Order("Jessica", "937161348", "Braga", BigDecimal("1900.12"), date4, Set(item))
	  
	  val date5 = LocalDateTime.of(2018, Month.DECEMBER, 20, 5, 31, 40)
	  val order5 = new Order("Rodrigo", "937161348", "Braga", BigDecimal("2600"), date5, Set(item))

		val date6 = LocalDateTime.of(2018, Month.DECEMBER, 20, 5, 31, 40)
		val order6 = new Order("Rodrigo", "937161348", "Braga", BigDecimal("2600"), date6, Set(item))
	  
	  List(order1, order2, order3, order4, order5)
	}
	

	
	private def createOrderSport(item: Item) : List[Order] = {
	  val date1 = LocalDateTime.of(2020, Month.APRIL, 15, 15, 30, 40)
	  val order1 = new Order("Juliana", "8934672231", "", BigDecimal("200"), date1, Set(item))
	  
	  val date2 = LocalDateTime.of(2019, Month.DECEMBER, 18, 14, 30, 40)
	  val order2 = new Order("Juliana", "8934672231", "", BigDecimal("250"), date2, Set(item))

		val date3 = LocalDateTime.of(2021, Month.OCTOBER, 18, 14, 30, 40)
		val order3 = new Order("Juliana", "8934672231", "", BigDecimal("250"), date3, Set(item))

		val date4 = LocalDateTime.of(2020, Month.APRIL, 15, 14, 30, 40)
		val order4 = new Order("Juliana", "8934672231", "", BigDecimal("250"), date4, Set(item))
	  
	  List(order1, order2, order3, order4)
	}
	
	def loadData() : List[Order] = {
	  val items = createItems()
	  var orders = List[Order]()
	  items.foreach(item => {
	    if (item.product.name.equals(Ipad)) {
	    	orders ++= this.createOrdersIpad(item)
	    }
	    else {
	      orders ++= this.createOrderSport(item)
	    }
	  
	  })
	 orders
	}

}