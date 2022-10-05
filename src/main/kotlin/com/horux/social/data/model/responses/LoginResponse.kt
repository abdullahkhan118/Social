package com.horux.social.data.model.responses

import com.horux.social.data.model.entities.User

data class LoginResponse(
    val token: String,
    val user: User
)