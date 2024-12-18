package com.example.tobyspringboot

interface HelloRepository {

    fun findOneByName(name: String): Hello?

    fun increaseCount(name: String)

    fun countOf(name: String): Int {
        val hello = findOneByName(name)
        return hello?.count ?: 0
    }

}
