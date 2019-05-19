package de.schmoll.familyserver.services

import de.schmoll.familyserver.models.Member
import org.springframework.data.mongodb.repository.MongoRepository

interface DAOLayer:MongoRepository<Member,String>