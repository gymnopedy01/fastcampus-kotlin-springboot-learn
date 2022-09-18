package com.fastcampus.fastcampusspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class FastcampusSpringbootApplication

fun main(args: Array<String>) {
    runApplication<FastcampusSpringbootApplication>(*args)
}

@RestController
class HelloController {

    @GetMapping("/")
    fun sayHello() = "Hello, World"
}
