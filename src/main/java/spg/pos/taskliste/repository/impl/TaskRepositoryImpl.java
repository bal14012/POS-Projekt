package spg.pos.taskliste.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import spg.pos.taskliste.model.MultiTimeTask;
import spg.pos.taskliste.model.SingleTimeTask;
import spg.pos.taskliste.repository.TaskRepositoryCustom;
import spg.pos.todo.model.QMultiTimeTask;
import spg.pos.todo.model.QSingleTimeTask;

public class TaskRepositoryImpl implements TaskRepositoryCustom
{
  @PersistenceContext
  EntityManager entityManager;

  public List<SingleTimeTask> findAllSingleTimeTasks()
  {
    JPAQuery query = new JPAQuery(entityManager);

    QSingleTimeTask task = QSingleTimeTask.singleTimeTask;

    query.from(task).orderBy(task.title.asc());
    return query.list(task);
  }

  public SingleTimeTask findSingleTaskByName(String name)
  {
    JPAQuery query = new JPAQuery(entityManager);

    QSingleTimeTask task = QSingleTimeTask.singleTimeTask;

    query.from(task).where(task.title.eq(name));
    return query.list(task).get(0);
  }

  public List<MultiTimeTask> findAllMultiTimeTasks()
  {
    JPAQuery query = new JPAQuery(entityManager);

    QMultiTimeTask task = QMultiTimeTask.multiTimeTask;

    query.from(task).orderBy(task.title.asc());
    return query.list(task);
  }

  public MultiTimeTask findMultiTaskByName(String name)
  {
    JPAQuery query = new JPAQuery(entityManager);

    QMultiTimeTask task = QMultiTimeTask.multiTimeTask;

    query.from(task).where(task.title.eq(name));
    return query.list(task).get(0);
  }
}
