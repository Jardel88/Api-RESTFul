package br.com.erudio.model
/*
* Nao e possivel utilizar variaveis do tipo val em data class
*/
data class Person (

    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""

)