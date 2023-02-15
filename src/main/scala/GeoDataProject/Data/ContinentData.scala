package GeoDataProject.Data

import GeoDataProject.Entity.Continent

object ContinentData {

    val africa = Continent("Africa", 1356499854L, 30370000.0)
    val europe = Continent("Europe", 747636026L, 10180000.0)
    val asia = Continent("Asia", 4641054787L, 44579090.5)
    val southAmerica = Continent("South America", 429191380L, 17840000.0)
    val northAmerica = Continent("North America", 589747378L, 24410657.0)
    val australia = Continent("Australia", 42446971L, 8600000.0)

    var continents: Map[String, Continent] = Map("AF" -> africa, "EU" -> europe, "AS" -> asia, "SA" -> southAmerica, "NA" -> northAmerica, "AU" -> australia)
}
