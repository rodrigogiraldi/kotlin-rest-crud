package com.rodrigo.kotlinrestcrud.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person (var name: String, var age: Int){
    @Id
    @GeneratedValue
    var id: Long = 0L
}