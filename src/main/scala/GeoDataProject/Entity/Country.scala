package GeoDataProject.Entity

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class Country(var name : String,
                   var population : Long,
                   var landArea: Double,
                   gdp: Double,
                   lifeExpectancy: Double,
                   continent: Continent,
                   currency: mutable.Map[String, String],
                   languageSpoken : mutable.Map[String,Double]
                  ) extends Land {

    continent.addCountry(this)

    val getMostSpokenLanguage: String =
        languageSpoken.maxBy{case (key, value) => value}._1

    val getLeaseSpokenLanguage: String =
        languageSpoken.minBy{case (key, value) => value}._1

    val getCurrencyName: String = currency("name")

    val getCurrencyCode: String = currency("code")

}
