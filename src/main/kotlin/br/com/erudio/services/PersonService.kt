package br.com.erudio.services

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO>{
        logger.info("Finding all people.")
        val people = repository.findAll()
        return DozerMapper.parseListObjects(people, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO{
        logger.info("Finding one person.")
        var person = repository.findById(id)
            .orElseThrow {ResourceNotFoundException("Id not found.")}
        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO) : PersonVO {
        logger.info("Creating one person with name ${person.firstName}.")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun update(person: PersonVO) : PersonVO {
        logger.info("Updating one person with name ${person.id}.")
        val entity = repository.findById(person.id)
            .orElseThrow {ResourceNotFoundException("Id not found.")}

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id.")
        val entity = repository.findById(id)
            .orElseThrow {ResourceNotFoundException("Id not found.")}
        repository.delete(entity)
    }




}