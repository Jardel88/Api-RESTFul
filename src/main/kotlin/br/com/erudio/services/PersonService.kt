package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person>{
        logger.info("Finding all people.")
        return repository.findAll()
    }

    fun findById(id: Long): Person{
        logger.info("Finding one person.")
        return repository.findById(id)
            .orElseThrow {ResourceNotFoundException("Id not found.")}
    }

    fun create(person: Person) : Person {
        logger.info("Creating one person with name ${person.firstName}.")
        return repository.save(person)
    }

    fun update(person: Person) {
        logger.info("Updating one person with name ${person.id}.")
        val entity = repository.findById(person.id)
            .orElseThrow {ResourceNotFoundException("Id not found.")}

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id.")
        val entity = repository.findById(id)
            .orElseThrow {ResourceNotFoundException("Id not found.")}
        repository.delete(entity)
    }




}