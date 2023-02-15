package GeoDataProject.Entity

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class Continent(var name : String,
                     var population : Long,
                     var landArea : Double,
                     ) extends Land {

    private var countries = ListBuffer[Country]()

    def addCountry(country: Country): mutable.Seq[Country] = countries+=country

    def getAllCountryNames : List[String] = countries.map(_.name).toList
    def printAllCountries : Unit = countries.foreach(i=> println(i.name))

    def getLargestCountry: Country = countries.maxBy(_.landArea)
    def getSmallestCountry: Country = countries.minBy(_.landArea)
    def printLargestCountry: String = getLargestCountry.name
    def printSmallestCountry: String = getSmallestCountry.name

}
