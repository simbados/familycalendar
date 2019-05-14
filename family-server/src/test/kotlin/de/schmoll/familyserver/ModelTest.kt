import de.schmoll.familyserver.models.Member

@RunWith(SpringRunner::class)
@SpringBootTest
class MemberTest {
  private val testMember = Member("1", "Max", "Mustermann", "max@musterman.de")

  Assertions.assertEquals(testMember.id, "1")
}