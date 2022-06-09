package br.com.erudio.converters

/*
* Object permite o uso como se fosse um metodo estatico ou algo parecido
*/
object NumberConverter {

    fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrEmpty()) return 0.0
        //BR 10,20 US 10.20
        //convertendo de BR para US
        val number = strNumber.replace(",".toRegex(), ".")
        return if(isNumeric(number)) number.toDouble() else 0.0
    }

    fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrEmpty()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}