package de.schmoll.familyserver

import de.schmoll.familyserver.models.Member
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
@RunWith(SpringRunner::class)
@SpringBootTest
class MemberTests {
    private val testMember = Member("1", "Max", "Mustermann", "max@musterman.de")

    @Test
    fun testInit() {
        assertEquals("1", testMember.id)
        assertEquals("Max", testMember.name)
        assertEquals("Mustermann", testMember.surname)
        assertEquals("max@musterman.de", testMember.email)
    }
}

