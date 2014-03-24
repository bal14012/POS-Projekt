package spg.pos.tasklisterepositoryjpa;

public interface PersistenceFactory
{
  SingleTimeTaskJpaRepository singleTimeTaskRepository();

  MultiTimeTaskJpaRepository multiTimeTaskRepository();

  UserJpaRepository userRepository();
}
