package spg.pos.taskliste.app;

import java.util.HashMap;

import javax.persistence.EntityManager;

import spg.pos.tasklisterepositoryjpa.*;

/**
 * The factory for all repositories...
 */
public class PersistenceFactoryImpl implements PersistenceFactory {

    private final HashMap<Class<?>, JpaRepository> repositories = new HashMap<>();

    public PersistenceFactoryImpl(EntityManager entityManager) {
        MultiTimeTaskJpaRepository multiTimeTaskRepository = new MultiTimeTaskJpaRepository();
        multiTimeTaskRepository.setEntityManager(entityManager);
        repositories.put(MultiTimeTaskJpaRepository.class, multiTimeTaskRepository);
        
        SingleTimeTaskJpaRepository singleTimeTaskRepository = new SingleTimeTaskJpaRepository();
        singleTimeTaskRepository.setEntityManager(entityManager);
        repositories.put(SingleTimeTaskJpaRepository.class, singleTimeTaskRepository);
    	
        UserJpaRepository userRepository = new UserJpaRepository();
        userRepository.setEntityManager(entityManager);
        repositories.put(UserJpaRepository.class, userRepository);
    }

    @Override
    public SingleTimeTaskJpaRepository singleTimeTaskRepository() {
    	return (SingleTimeTaskJpaRepository) repositories.get(SingleTimeTaskJpaRepository.class);
    }
    
    @Override
    public MultiTimeTaskJpaRepository multiTimeTaskRepository() {
    	return (MultiTimeTaskJpaRepository) repositories.get(MultiTimeTaskJpaRepository.class);
    }
    
    @Override
    public UserJpaRepository userRepository() {
    	return (UserJpaRepository) repositories.get(UserJpaRepository.class);
    }
}
