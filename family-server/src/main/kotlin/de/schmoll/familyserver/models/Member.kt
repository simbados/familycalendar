package de.schmoll.familyserver.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate


@Document data class Member(@Id val id:String, val name:String, val surname:String, val email:String)

// @Document data class Book(@Id val isbn:String, val name:String, var author: Author, val publishedYear:Int)