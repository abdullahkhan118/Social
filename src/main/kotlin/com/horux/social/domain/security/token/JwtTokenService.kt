package com.horux.social.domain.security.token

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.horux.security.token.TokenClaim
import com.horux.security.token.TokenConfig
import com.horux.security.token.TokenService
import java.util.*

class JwtTokenService : TokenService {

    override fun generateToken(config: TokenConfig, vararg claims: TokenClaim): String {
        var token =  JWT.create().withAudience(config.audience).withIssuer(config.issuer)
            .withExpiresAt(Date(System.currentTimeMillis() + config.expiresIn))

        claims.forEach { claim ->
            token = token.withClaim(claim.name,claim.value)
        }

        return token.sign(Algorithm.HMAC256(config.secret))

    }

}