package br.com.erudio.controllers

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.services.PersonService
import br.com.erudio.utils.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import br.com.erudio.data.vo.v2.PersonVO as PersonVOV2

//@CrossOrigin
@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
class PersonController {



    //lateinit quer dizer que os valores serao setados posteriormente e precisa ser do tipo var
    @Autowired
    private lateinit var service: PersonService
    //var service: PersonService = PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML])
    @Operation(summary = "Finds all people", description = "Finds all people",
    tags = ["People"],
    responses = [
        ApiResponse(description = "Success", responseCode = "200",  content = [
                Content(array = ArraySchema(schema = Schema(implementation = PersonVO::class)))
        ]),
        ApiResponse(description = "No Content", responseCode = "204", content = [
            Content(schema = Schema(implementation = Unit::class))
        ]),
        ApiResponse(description = "Bad Request", responseCode = "400", content = [
            Content(schema = Schema(implementation = Unit::class))
        ]),
        ApiResponse(description = "Unauthorized", responseCode = "401", content = [
            Content(schema = Schema(implementation = Unit::class))
        ]),
        ApiResponse(description = "Not Found", responseCode = "404", content = [
            Content(schema = Schema(implementation = Unit::class))
        ]),
        ApiResponse(description = "Internal Error", responseCode = "500", content = [
            Content(schema = Schema(implementation = Unit::class))
        ]),
    ])
    fun findAll(): List<PersonVO>{
        return service.findAll()
    }

    @CrossOrigin(origins = ["http://localhost:8080"])
    @GetMapping(value = ["{id}"], produces = [MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "Finds a person", description = "Finds a person",
        tags = ["People"],
        responses = [
            ApiResponse(description = "Success", responseCode = "200",  content = [
                Content(schema = Schema(implementation = PersonVO::class))
            ]),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ])
    fun findById(@PathVariable(value = "id") id: Long
    ): PersonVO{
        return service.findById(id)
    }

    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:8081"])
    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML]
    )
    @Operation(summary = "Adds a new person", description = "Adds a new person",
        tags = ["People"],
        responses = [
            ApiResponse(description = "Success", responseCode = "200",  content = [
                Content(schema = Schema(implementation = PersonVO::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ])
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
    @Operation(summary = "Updates a person's information", description = "Updates a person's information",
        tags = ["People"],
        responses = [
            ApiResponse(description = "Success", responseCode = "200",  content = [
                Content(schema = Schema(implementation = PersonVO::class))
            ]),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ])
    fun update(@RequestBody person: PersonVO): PersonVO{
        return service.update(person)
    }

    @DeleteMapping(value = ["{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML])
    @Operation(summary = "Deletes a person", description = "Deletes a person",
        tags = ["People"],
        responses = [
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ])
    fun delete(@PathVariable(value = "id") id: Long) : ResponseEntity<*>{
         service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}