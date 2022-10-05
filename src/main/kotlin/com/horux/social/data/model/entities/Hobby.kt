package com.horux.social.data.model.entities


import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

const val hobbiesTable = "hobbies"
const val hobbyColumn = "hobby"

@Entity
@Table(name = hobbiesTable)
class Hobby(

    @Id @Column(name = idColumn, nullable = false) override val id: String = UUID.randomUUID().toString(),

    @Column(name = createdAtColumn, nullable = false) override val createdAt: Date = Date(System.currentTimeMillis()),

    @Column(name = updatedAtColumn, nullable = false) override var updatedAt: Date = Date(System.currentTimeMillis()),

    @Column(name = isDeletedColumn, nullable = false) override val isDeleted: Boolean = false,

    @Column(name = hobbyColumn, nullable = false) val hobby: String = "",

) : RequiredFields(id, createdAt, updatedAt, isDeleted)