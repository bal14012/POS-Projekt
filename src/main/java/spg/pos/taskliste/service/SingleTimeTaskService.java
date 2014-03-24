package spg.pos.taskliste.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spg.pos.taskliste.model.*;
import spg.pos.taskliste.repository.TaskRepository;

@Service
public class SingleTimeTaskService
{
  @Autowired
  private TaskRepository taskRepository;

  public void createNewUser(User creator, String title)
  {
    SingleTimeTask task = new SingleTimeTask(null, creator, null, title,
        Task.TaskStatus.Open, new Date());
    taskRepository.save(task);
  }
}
