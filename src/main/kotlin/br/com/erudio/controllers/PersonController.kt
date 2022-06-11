package br.com.erudio.controllers

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.services.PersonService
import br.com.erudio.utils.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import br.com.erudio.data.vo.v2.PersonVO as PersonVOV2

@RestController
@RequestMapping("/api/person/v1")
class PersonController {



    //lateinit quer dizer que os valores serao setados posteriormente e precisa ser do tipo var
    @Autowired
    private lateinit var service: PersonService
    //var service: PersonService = PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML])
    fun findAll(): List<PersonVO>{
        return service.findAll()
    }

    @GetMapping(value = ["{id}"], produces = [MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findById(@PathVariable(value = "id") id: Long
    ): PersonVO{
        return service.findById(id)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
    )
    fun create(@RequestBody person: PersonVO): PersonVO{
        return service.create(person)
    }

    @PostMapping(value = ["/v2"],
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
    )
    fun createV2(@RequestBody person: PersonVOV2): PersonVOV2{
        return service.createV2(person)
    }


    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
    )
    fun update(@RequestBody person: PersonVO): PersonVO{
        return service.update(person)
    }

    @DeleteMapping(value = ["{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML])
    fun delete(@PathVariable(value = "id") id: Long) : ResponseEntity<*>{
         service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}