package de.schmoll.familyserver.repository;

import de.schmoll.familyserver.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Member, Long> {
}
