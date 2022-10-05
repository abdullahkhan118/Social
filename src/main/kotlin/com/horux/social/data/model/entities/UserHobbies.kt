package com.horux.social.data.model.entities

import java.util.*
import javax.persistence.*

const val userHobbiesTable = "user_hobbies"

@Entity
@Table(name = userHobbiesTable)
class UserHobbies(

    @Id @Column(name = idColumn, nullable = false) override val id: String = UUID.randomUUID().toString(),

    @Column(name = createdAtColumn, nullable = false) override val createdAt: Date = Date(System.currentTimeMillis()),

    @Column(name = updatedAtColumn, nullable = false) override var updatedAt: Date = Date(System.currentTimeMillis()),

    @Column(name = isDeletedColumn, nullable = false) override val isDeleted: Boolean = false,

    @ManyToOne
    @JoinColumn(name = userTable + idColumn, nullable = false, referencedColumnName = idColumn) val user: User = User(),

    @ManyToOne
    @JoinColumn(
        name = hobbiesTable + idColumn,
        nullable = false,
        referencedColumnName = idColumn
    ) val hobby: Hobby = Hobby(),

    ) : RequiredFields(id, createdAt, updatedAt, isDeleted)
