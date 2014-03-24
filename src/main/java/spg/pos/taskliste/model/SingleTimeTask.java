package spg.pos.taskliste.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * A task that occurrs a single time and is removed after then.
 * 
 * @author Michael
 */
@Entity
@DiscriminatorValue("S")
public class SingleTimeTask extends Task
{
  private static final long serialVersionUID = 1L;

  @Column(name = "date", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  public SingleTimeTask()
  {
    date = new Date();
  }

  public SingleTimeTask(Long id, User creator,
      Collection<User> worker, String title, TaskStatus status, Date date)
  {
    super(id, creator, worker, title, status);
    this.date = date;
  }

  @Override
  public Date getDate()
  {
    return date;
  }
}
