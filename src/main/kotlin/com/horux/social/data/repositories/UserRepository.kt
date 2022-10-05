package com.horux.social.data.repositories

import com.horux.social.data.model.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,String> {



}