package spg.pos.taskliste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spg.pos.taskliste.model.Task;

@Repository
public interface TaskRepository extends TaskRepositoryCustom, CrudRepository<Task, Long>
{
  
}
