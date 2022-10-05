package com.horux.social.data.model.entities

import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

const val userTable = "users"
const val emailColumn = "email"
const val passwordColumn = "password"
const val fullNameColumn = "fullName"
const val profilePictureColumn = "profile_picture"
const val phoneNumberColumn = "phoneNumber"
const val hobbiesColumn = "hobbies"

@Entity
@Table(name = userTable)
data class User(
    @Id @Column(name = idColumn, nullable = false) override val id: String = UUID.randomUUID().toString(),

    @Column(name = createdAtColumn, nullable = false) override val createdAt: Date = Date(System.currentTimeMillis()),

    @Column(name = updatedAtColumn, nullable = false) override var updatedAt: Date = Date(System.currentTimeMillis()),

    @Column(name = isDeletedColumn, nullable = false) override val isDeleted: Boolean = false,

    @Column(name = emailColumn, nullable = false) val email: String = "",

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = passwordTable + idColumn, nullable = false, referencedColumnName = idColumn) val password: Password = Password(),

    @Column(name = fullNameColumn, nullable = false) val fullName: String = "",

    @Column(name = profilePictureColumn, nullable = false) val profilePicture: String = "",

    @Column(name = phoneNumberColumn, nullable = false) val phoneNumber: String = "",

//    @OneToMany @JoinColumn(name = hobbiesTable + idColumn, nullable = false, referencedColumnName = idColumn) val hobbies: kotlin.collections.List<Hobby> = listOf()

) : RequiredFields(id, createdAt, updatedAt, isDeleted){

//    constructor(email: String,password: Password,fullName: String,profilePicture: String,phoneNumber: String): this(id, createdAt, updatedAt, isDeleted, email, password, fullName, profilePicture, phoneNumber)

}