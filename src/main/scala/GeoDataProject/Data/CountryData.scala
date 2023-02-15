package GeoDataProject.Data

import GeoDataProject.Entity.Country
import scala.collection.mutable

object CountryData{

    val egypt = Country("Egypt", 102334404L, 1001449.0, 354.972, 73.5, ContinentData.africa, CurrencyData.egp, mutable.Map("Arabic" -> 99.6, "Nobiin" -> 0.1, "Beja" -> 0.1, "Domari" -> 0.1))
    val france = Country("France", 67012883L, 640679.0, 2659.643, 83.1, ContinentData.europe, CurrencyData.eur, mutable.Map("French" -> 99, "German" -> 0.4, "Alsatian" -> 0.2, "Breton" -> 0.2, "Catalan" -> 0.2, "Corsican" -> 0.2, "Flemish" -> 0.1, "Occitan" -> 0.1, "Arabic" -> 1.2, "Portuguese" -> 1.0, "Spanish" -> 0.7, "Italian" -> 0.5, "Turkish" -> 0.3, "English" -> 0.3, "Polish" -> 0.2, "Russian" -> 0.1, "Dutch" -> 0.1))
    val germany = Country("Germany", 83190556L, 348672.0, 4222.807, 81.2, ContinentData.europe, CurrencyData.eur, mutable.Map("German" -> 95, "Turkish" -> 1.1, "Polish" -> 0.6, "Russian" -> 0.5, "Arabic" -> 0.5, "Italian" -> 0.4, "Romanian" -> 0.3, "Croatian" -> 0.2, "Greek" -> 0.2, "Serbian" -> 0.2, "English" -> 0.2, "Dutch" -> 0.2, "Spanish" -> 0.1, "Portuguese" -> 0.1, "Ukrainian" -> 0.1, "French" -> 0.1))
    val china = Country("China", 1444216106L, 9388211.0, 16308.572, 76.7, ContinentData.asia, CurrencyData.cny, mutable.Map("Mandarin" -> 898, "Wu" -> 80, "Min Nan" -> 48, "Cantonese" -> 66, "Jin" -> 63, "Xiang" -> 36, "Hakka" -> 34, "Gan" -> 32, "Huizhou" -> 30, "Ping" -> 20, "Ganqing" -> 16, "Minnan" -> 14, "Jinyu" -> 13, "Shaojiang" -> 10, "Xibe" -> 5))
    val brazil = Country("Brazil", 213993437L, 8358140.0, 2068.232, 75.9, ContinentData.southAmerica, CurrencyData.brl, mutable.Map("Portuguese" -> 98.5, "Spanish" -> 0.5, "English" -> 0.5, "German" -> 0.1, "Italian" -> 0.1, "Japanese" -> 0.1, "Libras" -> 0.7))
    val argentina = Country("Argentina", 45604529L, 2780400.0, 416.608, 76.8, ContinentData.southAmerica, CurrencyData.ars, mutable.Map("Spanish" -> 98.1, "Italian" -> 1.2, "Quechua" -> 0.4, "Guarani" -> 0.2, "Mapudungun" -> 0.1, "German" -> 0.1, "English" -> 0.1))
    val india = Country("India", 1380004385, 2973190.0, 3.202044E12, 69.7, ContinentData.asia, CurrencyData.inr, mutable.Map("Hindi" -> 41, "Bengali" -> 8, "Telugu" -> 7, "Marathi" -> 7, "Tamil" -> 6, "Gujarati" -> 4, "Urdu" -> 4, "Kannada" -> 3, "Odia" -> 3, "Punjabi" -> 3, "Malayalam" -> 3, "Assamese" -> 1, "Kashmiri" -> 1, "Sindhi" -> 0.7, "Sanskrit" -> 0.01))
    val usa = Country("United States of America", 331002651, 9525067.0, 21.439453E12, 78.9, ContinentData.northAmerica, CurrencyData.usd, mutable.Map("English" -> 95.4, "Spanish" -> 4.1))
    val japan = Country("Japan", 126476461, 377972.28, 5.152582E12, 84.6, ContinentData.asia, CurrencyData.yen, mutable.Map("Japanese" -> 99.1))

    var countries: Map[String, Country] = Map("EGY" -> egypt,"FRA" -> france, "GER" -> germany, "CHN" -> china, "BRA" -> brazil,"ARG" -> argentina, "IND" -> india, "USA" -> usa, "JPA" -> japan)
}
