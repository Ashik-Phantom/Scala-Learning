package GeoDataProject.Data

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

private object CurrencyData{
    val egp = mutable.Map("name" -> "Egyptian Pound", "code" -> "EGP")
    val eur = mutable.Map("name" -> "Euro", "code" -> "EUR")
    val cny = mutable.Map("name" -> "Chinese Yuan", "code" -> "CNY")
    val brl = mutable.Map("name" -> "Brazilian Real", "code" -> "BRL")
    val ars = mutable.Map("name" -> "Argentine Peso", "code" -> "ARS")
    val mxn = mutable.Map("name" -> "Mexican Peso", "code" -> "MXN")
    val cad = mutable.Map("name" -> "Canadian Dollar", "code" -> "CAD")
    val krw = mutable.Map("name" -> "South Korean Won", "code" -> "KRW")
    val inr = mutable.Map("code" -> "INR", "name" -> "Indian Rupee")
    val usd = mutable.Map("code" -> "USD", "name" -> "United States Dollar")
    val yen = mutable.Map("code" -> "JPY", "name" -> "Japanese Yen")
}
