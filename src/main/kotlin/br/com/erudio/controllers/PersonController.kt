package br.com.erudio.controllers

import br.com.erudio.converters.NumberConverter
import br.com.erudio.exceptions.UnsuppertedMathOperationException
import br.com.erudio.math.SimpleMath
import br.com.erudio.model.Person
import br.com.erudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/person")
class PersonController {



    //lateinit quer dizer que os valores serao setados posteriormente e precisa ser do tipo var
    @Autowired
    private lateinit var service: PersonService
    //var service: PersonService = PersonService

    @RequestMapping(value = ["{id}"], method = [RequestMethod.GET],
    produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value = "id") id: Long
    ): Person{
        return service.findById(id)
    }

    @RequestMapping(method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person>{
        return service.findAll()
    }


}