package com.horux.social.data.interfaces

interface RequestMapper<Rq,E> {

    fun fromRequest(request: Rq): E

}