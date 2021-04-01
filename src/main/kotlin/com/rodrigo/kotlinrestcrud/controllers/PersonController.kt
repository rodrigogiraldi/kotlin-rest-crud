package com.rodrigo.kotlinrestcrud.controllers

import com.rodrigo.kotlinrestcrud.entities.Person
import com.rodrigo.kotlinrestcrud.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var personService: PersonService

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    fun listAll(): List<Person> {
        return personService.listAll()
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Person? {
        return personService.get(id)
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    fun create(@RequestBody person: Person): Person {
        return personService.create(person)
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody person: Person) {
        personService.update(id, person)
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        personService.delete(id)
    }
}