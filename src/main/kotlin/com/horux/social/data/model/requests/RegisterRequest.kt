package com.horux.social.data.model.requests

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.horux.social.data.model.entities.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

data class RegisterRequest(
    val email: String,
    val password: String,
    val fullName: String,
    val profilePicture: String,
    val phoneNumber: String,
)
