package com.horux.social.data.model.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

const val passwordTable = "password"
const val hashColumn = "hash"
const val saltColumn = "salt"
const val tokenColumn = "token"

@Entity
@Table(name = passwordTable)
class Password(
    @Id @Column(name = idColumn) override val id: String = UUID.randomUUID().toString(),

    @Column(name = createdAtColumn) override val createdAt: Date = Date(System.currentTimeMillis()),

    @Column(name = updatedAtColumn) override var updatedAt: Date = Date(System.currentTimeMillis()),

    @Column(name = isDeletedColumn) override val isDeleted: Boolean = false,

    @Column(name = hashColumn, nullable = false) val hash: String = "",

    @Column(name = saltColumn, nullable = false) val salt: String = "",

    @Column(name = tokenColumn, nullable = false) val token: String = "",

    ) : RequiredFields(id, createdAt, updatedAt, isDeleted)
