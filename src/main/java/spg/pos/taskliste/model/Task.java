package spg.pos.taskliste.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * A base class for tasks.
 * 
 * @author Michael
 */
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@Entity(name = "tasks")
@Table(name = "tasks")
public abstract class Task extends Modelbase
{
  private static final long serialVersionUID = 1L;

  @Column(name = "title", length = 50, nullable = false)
  private String title;

  @Column(name = "status", length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "creator")
  private User creator;

  @ManyToMany(targetEntity = User.class)
  @JoinTable(name = "userHasTask", joinColumns =
  { @JoinColumn(name = "worker", referencedColumnName = "id") }, inverseJoinColumns =
  { @JoinColumn(name = "task", referencedColumnName = "id") })
  private Collection<User> worker;

  public Task()
  {
    status = TaskStatus.Open;
  }

  public Task(Long id, User creator, Collection<User> worker,
      String title, TaskStatus status)
  {
    super(id);
    this.title = title;
    this.status = status;
    this.creator = creator;
    this.worker = worker;
  }

  public abstract Date getDate();

  public String getTitle()
  {
    return title;
  }

  public TaskStatus getStatus()
  {
    return status;
  }

  public User getCreator()
  {
    return creator;
  }

  public Collection<User> getWorker()
  {
    return worker;
  }

  public void setWorker(Collection<User> worker)
  {
    this.worker = worker;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void accomplished()
  {
    status = TaskStatus.Accomplished;
  }

  public void delete()
  {
    status = TaskStatus.Deleted;
  }

  public enum TaskStatus
  {
    Open, Accomplished, Deleted;
  }
}
