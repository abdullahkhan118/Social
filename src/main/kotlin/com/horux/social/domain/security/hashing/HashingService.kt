package com.horux.social.domain.security.hashing

interface HashingService {

    fun generateSaltedHash(rawPassword: String, saltLength: Int = 32): SaltedHash

    fun verifyHash(rawPassword: String, saltLength: Int = 32): Boolean

    fun verifyHash(rawPassword: String, saltedHash: SaltedHash): Boolean

}