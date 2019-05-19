package de.schmoll.familyserver.services

import de.schmoll.familyserver.models.Member
import de.schmoll.familyserver.util.BasicCrud
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service

class MemberService(val DAOLayer: DAOLayer):BasicCrud<String,Member> {

    override fun getAll(pageable: Pageable): Page<Member> = DAOLayer.findAll(pageable)

    override fun getById(id: String): Optional<Member> = DAOLayer.findById(id)

    override fun insert(obj: Member): Member = DAOLayer.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Member): Member {
      return if(DAOLayer.existsById(obj.id)){
        DAOLayer.save(obj)
        } else {
          throw object: Exception("Member not found"){}
        }
      }
    
    override fun deleteById(id: String): Optional<Member> {
      return DAOLayer.findById(id).apply {
        this.ifPresent{ DAOLayer.delete(it)}
      }
    }
}