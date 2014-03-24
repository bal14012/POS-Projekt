package spg.pos.taskliste.repository;

import java.util.List;

import spg.pos.taskliste.model.MultiTimeTask;
import spg.pos.taskliste.model.SingleTimeTask;

/**
 * Erweiterungsinterface für TaskRepo.
 * 
 * @author Michael
 */
public interface TaskRepositoryCustom
{
  List<SingleTimeTask> findAllSingleTimeTasks();
  SingleTimeTask findSingleTaskByName(String name);
  
  List<MultiTimeTask> findAllMultiTimeTasks();
  MultiTimeTask findMultiTaskByName(String name);
}
