package com.horux.social.controllers

import com.horux.social.data.model.requests.LoginRequest
import com.horux.social.data.model.requests.RegisterRequest
import com.horux.social.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

const val userMapping = "api/user"
const val loginMapping = "/login"
const val registerMapping = "/register"
const val allMapping = "/all"

const val idPathVariable = "id"

@RestController
@RequestMapping(userMapping)
class UserController(
    @Autowired private val service: UserService
) {

    @PostMapping(loginMapping)
    fun login(@RequestBody loginRequest: LoginRequest) = service.login(loginRequest)

    @PostMapping(registerMapping)
    fun register(@RequestBody registerRequest: RegisterRequest) = service.register(registerRequest)

    @GetMapping(allMapping)
    fun getUsers() = service.getUsers()

    @GetMapping(allMapping+"/{$idPathVariable}")
    fun getUserByID(@PathVariable(idPathVariable) id: String) = service.getUserById(id)

}