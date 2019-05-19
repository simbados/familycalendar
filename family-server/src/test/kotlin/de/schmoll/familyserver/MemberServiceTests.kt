package de.schmoll.familyserver

import com.github.fakemongo.junit.FongoRule
import com.mongodb.BasicDBObject
import de.schmoll.familyserver.models.Member
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@SpringBootTest
@RunWith(SpringRunner::class)
class MemberServiceTests {

    @Rule
    var fongoRule = FongoRule()

    @Before
    fun setUp() {
        val testMemberMax = Member("1", "Max", "Mustermann", "max@musterman.de")
        val db = fongoRule.getDB("familydb")
        val collection = db.getCollection("mycollection")
        collection.insert(BasicDBObject("name", "jon"))
    }

    @Test
    fun getAllTest() {

    }
}
