package com.horux.social.domain.security.hashing

import org.apache.commons.codec.digest.MessageDigestAlgorithms
import java.security.MessageDigest
import java.security.SecureRandom

//@SHA256HashingServiceQualifier
class SHA256HashingService : HashingService {

    override fun generateSaltedHash(rawPassword: String, saltLength: Int): SaltedHash {
        val salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLength)
        val saltAsHex = salt.decodeToString()
        val hash = MessageDigest.getInstance(MessageDigestAlgorithms.SHA3_256).digest((saltAsHex + rawPassword).toByteArray())
            .decodeToString()
        return SaltedHash(saltAsHex, hash)
    }

    override fun verifyHash(rawPassword: String, saltLength: Int): Boolean {
        val saltedHash = generateSaltedHash(rawPassword)
        return MessageDigest.getInstance(MessageDigestAlgorithms.SHA3_256)
            .digest((saltedHash.salt + rawPassword).toByteArray()).decodeToString() == saltedHash.hash
    }

    override fun verifyHash(rawPassword: String, saltedHash: SaltedHash): Boolean {
        val hash = MessageDigest.getInstance(MessageDigestAlgorithms.SHA3_256).digest((saltedHash.salt + rawPassword).toByteArray())
            .decodeToString()
        return hash == saltedHash.hash
    }
}