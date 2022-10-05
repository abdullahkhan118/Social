package com.horux.social.data.model.entities

import java.util.*

const val idColumn = "_id"
const val createdAtColumn = "_created_at"
const val updatedAtColumn = "_updated_at"
const val isDeletedColumn = "_is_deleted"

abstract class RequiredFields(
    open val id: String,
    open val createdAt: Date,
    open var updatedAt: Date,
    open val isDeleted: Boolean
)