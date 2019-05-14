package de.schmoll.familyserver.services

import de.schmoll.familyserver.models.Member
import de.schmoll.familyserver.util.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
/*injects DAO objects by constructor & implements BasicCrud interface*/
class MemberService(val memberDAO: MemberDAO):BasicCrud<String,Member> {

    override fun getAll(pageable: Pageable): Page<Member> = memberDAO.findAll(pageable)

    override fun getById(id: String): Optional<Member> = memberDAO.findById(id)

    override fun insert(obj: Member): Member = memberDAO.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Member): Member {
      return if(memberDAO.existsById(obj.id)){
        memberDAO.save(obj)
        } else {
          throw object: Exception("Member not found"){}
        }
      }
    
    override fun deleteById(id: String): Optional<Member> {
      return memberDAO.findById(id).apply {
        this.ifPresent{ memberDAO.delete(it)}
      }
    }
}