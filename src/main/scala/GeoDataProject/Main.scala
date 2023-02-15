package GeoDataProject

import GeoDataProject.Data.CountryData
import GeoDataProject.Service.GeoData

import scala.collection.mutable.ListBuffer

object Main extends App {

    var geoApp  = GeoData()

    val ind = geoApp.searchCountryByIsoCode("IND")
    val bra = geoApp.searchCountryByIsoCode("BRA")
    val usa = geoApp.searchCountryByIsoCode("USA")
    val chn = geoApp.searchCountryByIsoCode("CHN")

    val asia = geoApp.searchContinentByIsoCode("AS")
    val eur = geoApp.searchContinentByIsoCode("EU")
    val sa = geoApp.searchContinentByIsoCode("SA")

    asia.printAllCountries
    println(asia.getAllCountryNames)

    /*println(ind.getMostSpokenLanguage)
    println(ind.languageSpoken)

    println(usa.getMostSpokenLanguage)
    println(usa.languageSpoken)

    println(bra.getMostSpokenLanguage)
    println(bra.languageSpoken)*/

    println(ind.getCurrencyCode)
    println(ind.getCurrencyName)

    println(sa.getLargestCountry)
    println(sa.printLargestCountry)
    println(sa.printSmallestCountry)

    println(geoApp.getLargestCountry)
    println(geoApp.getSmallestCountry)

    println(geoApp.getLargestContinent)
    println(geoApp.getSmallestContinent)

}
