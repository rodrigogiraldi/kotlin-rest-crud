package com.rodrigo.kotlinrestcrud.repositories

import com.rodrigo.kotlinrestcrud.entities.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {
}