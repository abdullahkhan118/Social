package com.horux.social.services

import com.horux.social.data.model.entities.User
import com.horux.social.data.model.requests.LoginRequest
import com.horux.social.data.model.requests.RegisterRequest
import com.horux.social.data.repositories.UserRepository
import com.horux.social.domain.mappers.RegisterMapper
import com.horux.social.domain.security.hashing.HashingService
import com.horux.social.domain.security.hashing.SHA256HashingService
import com.horux.social.domain.security.hashing.SaltedHash
import com.horux.social.domain.security.hashing.di.RegisterMapperQualifier
import com.horux.social.domain.security.hashing.di.SHA256HashingServiceQualifier
import com.linecorp.kotlinjdsl.QueryFactory
import com.linecorp.kotlinjdsl.QueryFactoryImpl
import com.linecorp.kotlinjdsl.listQuery
import com.linecorp.kotlinjdsl.query.creator.CriteriaQueryCreatorImpl
import com.linecorp.kotlinjdsl.query.creator.SubqueryCreatorImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Service
@Import(RegisterMapper::class)
class UserService(
    @Autowired private val repository: UserRepository,
    @PersistenceContext
    private val entityManager: EntityManager,
    @Autowired @SHA256HashingServiceQualifier
    private val hashingService: HashingService
//    = SHA256HashingService()
    ,
    @Autowired
//    @RegisterMapperQualifier
    private val mapper: RegisterMapper
//    = RegisterMapper(hashingService)
) {

    val queryFactory: QueryFactory = QueryFactoryImpl(
        criteriaQueryCreator = CriteriaQueryCreatorImpl(entityManager),
        subqueryCreator = SubqueryCreatorImpl()
    )


    fun getUserById(id: String) = repository.findById(id)

    fun getUserByEmail(email: String) = queryFactory.listQuery<User> {
        select(entity(User::class))
        from(entity(User::class))
        where(column(entity(User::class), User::email).equal(email))
    }

    fun getUsers(): List<User> = repository.findAll()

    fun register(request: RegisterRequest): String {
        if (getUserByEmail(request.email).isNotEmpty()) return "Email already exists"
        val user = mapper.fromRequest(request)
        println(user.toString())
        val hasSaved = kotlin.runCatching { repository.save(user) }.getOrNull() != null
        return if (hasSaved) "User registered successfully" else "Unexpected error occurred"
    }

    fun login(request: LoginRequest): String {
        if (getUserByEmail(request.email).isEmpty()) return "Email does not exists"
        val user = getUserByEmail(request.email).first()
        return if (!hashingService.verifyHash(request.password)) "Incorrect password"
        else user.toString()
    }

}