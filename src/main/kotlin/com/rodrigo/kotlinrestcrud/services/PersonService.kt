package com.rodrigo.kotlinrestcrud.services

import com.rodrigo.kotlinrestcrud.entities.Person
import com.rodrigo.kotlinrestcrud.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    lateinit var personRepository: PersonRepository

    fun listAll(): List<Person> {
        return personRepository.findAll()
    }

    fun get(id: Long): Person {
        return personRepository.getOne(id)
    }

    fun create(person: Person): Person{
        return personRepository.save(person)
    }

    fun update(id: Long, person: Person): Person {
        var personDb = personRepository.getOne(id)

        personDb.name = person.name
        personDb.age = person.age

        return personRepository.save(personDb)
    }

    fun delete(id: Long) {
        return personRepository.deleteById(id)
    }
}