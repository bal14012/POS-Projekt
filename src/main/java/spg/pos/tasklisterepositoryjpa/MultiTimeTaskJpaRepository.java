package spg.pos.tasklisterepositoryjpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spg.pos.taskliste.model.MultiTimeTask;
import spg.pos.taskliste.model.Task;

@Transactional
@Repository
public class MultiTimeTaskJpaRepository extends AbstractJpaRepository<MultiTimeTask>
{
  @Override
  public MultiTimeTask findById(Long id)
  {
    return (MultiTimeTask)entityManager().find(Task.class, id);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<MultiTimeTask> findAll()
  {
    TypedQuery<Task> query = entityManager().createQuery("SELECT e FROM tasks e WHERE type = 'M'", Task.class);

    return (List)query.getResultList();
  }

  public void removeById(Long id)
  {
    entityManager().remove(findById(id));
  }
}
