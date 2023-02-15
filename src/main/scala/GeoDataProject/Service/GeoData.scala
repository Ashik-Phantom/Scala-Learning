package GeoDataProject.Service

import GeoDataProject.Data.{ContinentData, CountryData}
import GeoDataProject.Entity.{Continent, Country, Land}

import scala.collection.mutable.ListBuffer

case class GeoData(){
        val countries : Map[String, Country] = CountryData.countries
        val continents : Map[String, Continent] = ContinentData.continents

        def searchCountryByIsoCode(isoCode : String): Country =
                countries(isoCode)
        def searchContinentByIsoCode(isoCode : String): Continent =
                continents(isoCode)

        def getLargestCountry: Land = maxByLandArea(countries)
        def getSmallestCountry: Land = minxByLandArea(countries)

        def getLargestContinent: Land = maxByLandArea(continents)
        def getSmallestContinent: Land = minxByLandArea(continents)

        private def maxByLandArea(list: Map[String, Land]) = list.maxBy(_._2.landArea)._2
        private def minxByLandArea(list: Map[String, Land]) = list.minBy(_._2.landArea)._2



}
