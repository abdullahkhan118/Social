package com.horux.social.data.model.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

const val postTable = "posts"

@Entity
@Table(name = postTable)
class Post(
    @Id @Column(name = idColumn, nullable = false) override val id: String = UUID.randomUUID().toString(),

    @Column(name = createdAtColumn, nullable = false) override val createdAt: Date = Date(System.currentTimeMillis()),

    @Column(name = updatedAtColumn, nullable = false) override var updatedAt: Date = Date(System.currentTimeMillis()),

    @Column(name = isDeletedColumn, nullable = false) override val isDeleted: Boolean = false,

    @ManyToOne @JoinColumn(name = userTable + idColumn, nullable = false, referencedColumnName = idColumn) val user: User = User(),

) : RequiredFields(id, createdAt, updatedAt, isDeleted)