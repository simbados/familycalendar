package de.schmoll.familyserver.controller
import de.schmoll.familyserver.services.MemberService
import de.schmoll.familyserver.models.Member
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController //declare this class as rest controller able to catch http request
@RequestMapping("api/member")//controller root path
class MemberController(private val memberService: MemberService){//injects bookService by constructor

    @GetMapping fun getAll(pageable: Pageable): Page<Member> = memberService.getAll(pageable)

    @GetMapping("{id}")  fun getById(@PathVariable id:String): Optional<Member> = memberService.getById(id)

    @PostMapping fun insert(@RequestBody member: Member): Member = memberService.insert(member)

    @PutMapping fun update(@RequestBody member: Member): Member = memberService.update(member)

    @DeleteMapping("{id}")  fun deleteById(@PathVariable id: String): Optional<Member>  = memberService.deleteById(id)
}