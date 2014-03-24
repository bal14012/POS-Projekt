package spg.pos.tasklisterepositoryjpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spg.pos.taskliste.model.SingleTimeTask;
import spg.pos.taskliste.model.Task;

@Transactional
@Repository
public class SingleTimeTaskJpaRepository extends AbstractJpaRepository<SingleTimeTask>
{
  @Override
  public SingleTimeTask findById(Long id)
  {
    return (SingleTimeTask)entityManager().find(Task.class, id);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<SingleTimeTask> findAll()
  {
    TypedQuery<Task> query = entityManager().createQuery("SELECT e FROM tasks e where type = 'S'", Task.class);
    return (List)query.getResultList();
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<Task> yolo()
  {
    TypedQuery<Task> query = entityManager().createQuery("SELECT e FROM tasks e", Task.class);
    return (List)query.getResultList();
  }

  public void removeById(Long id)
  {
    entityManager().remove(findById(id));
  }
}
