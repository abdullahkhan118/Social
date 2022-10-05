package com.horux.social.domain.mappers

import com.horux.social.data.interfaces.RequestMapper
import com.horux.social.data.model.entities.Password
import com.horux.social.data.model.entities.User
import com.horux.social.data.model.requests.RegisterRequest
import com.horux.social.domain.security.hashing.HashingService
import com.horux.social.domain.security.hashing.SHA256HashingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean

class RegisterMapper(
    private val hashingService: HashingService
) : RequestMapper<RegisterRequest, User> {

    override fun fromRequest(request: RegisterRequest): User {
        val saltedHash = hashingService.generateSaltedHash(request.password)
        val password = Password(hash = saltedHash.hash, salt = saltedHash.salt)
//        val password = Password()
        return User(
            email = request.email,
            fullName = request.fullName,
            password = password,
            phoneNumber = request.phoneNumber,
            profilePicture = request.profilePicture
        )
    }
}