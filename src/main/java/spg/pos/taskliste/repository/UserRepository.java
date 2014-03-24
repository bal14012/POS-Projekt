package spg.pos.taskliste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spg.pos.taskliste.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	
}
