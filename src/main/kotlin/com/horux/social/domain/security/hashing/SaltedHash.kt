package com.horux.social.domain.security.hashing

data class SaltedHash(
    val salt: String,
    val hash: String
)
