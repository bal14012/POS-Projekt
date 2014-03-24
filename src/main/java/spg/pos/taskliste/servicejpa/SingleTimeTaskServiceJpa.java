package spg.pos.taskliste.servicejpa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spg.pos.taskliste.model.*;
import spg.pos.tasklisterepositoryjpa.SingleTimeTaskJpaRepository;

@Service
public class SingleTimeTaskServiceJpa
{
  @Autowired
  private SingleTimeTaskJpaRepository singleTimeTaskJpaRepository;

  public void createNewUser(User creator, String title)
  {
    SingleTimeTask task = new SingleTimeTask(null, creator, null, title,
        Task.TaskStatus.Open, new Date());
    singleTimeTaskJpaRepository.persist(task);
  }
  
  public void setSingleTimeTaskJpaRepository(SingleTimeTaskJpaRepository singleTimeTaskJpaRepository) {
	  this.singleTimeTaskJpaRepository = singleTimeTaskJpaRepository;
  }
}
