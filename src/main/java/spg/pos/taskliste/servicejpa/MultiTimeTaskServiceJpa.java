package spg.pos.taskliste.servicejpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spg.pos.taskliste.model.*;
import spg.pos.tasklisterepositoryjpa.MultiTimeTaskJpaRepository;

@Service
public class MultiTimeTaskServiceJpa
{
  @Autowired
  private MultiTimeTaskJpaRepository multiTimeTaskJpaRepository;
  
  public void createNewUser(User creator, String title, MultiTimeTask.RepeatType repeat)
  {
    MultiTimeTask task = new MultiTimeTask(null, creator, null, title, Task.TaskStatus.Open, repeat, new Date());
    multiTimeTaskJpaRepository.persist(task);
  }
  
  public void setMultiTimeTaskJpaRepository(MultiTimeTaskJpaRepository multiTimeTaskJpaRepository) {
	  this.multiTimeTaskJpaRepository = multiTimeTaskJpaRepository;
  }
}
