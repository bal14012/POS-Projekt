package spg.pos.tasklisterepositoryjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import spg.pos.taskliste.model.Modelbase;

/**
 * Basis-Klasse für alle weiteren, die spezielle Models persistieren wollen.
 * 
 * @author Michael
 * @param <T>
 */
@Transactional
public abstract class AbstractJpaRepository<T extends Modelbase> implements JpaRepository
{
  protected final Logger logger = LoggerFactory.getLogger(getClass());

  @PersistenceContext
  private EntityManager entityManager;

  public AbstractJpaRepository()
  {
  }

  protected EntityManager entityManager()
  {
    return entityManager;
  }

  public void setEntityManager(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }

  public abstract List<T> findAll();

  public abstract T findById(Long id);

  @Transactional
  public void persist(T entity)
  {
    entityManager.getTransaction().begin();
    entityManager.persist(entity);
    entityManager.getTransaction().commit();
  }
}
