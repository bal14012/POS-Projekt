package spg.pos.taskliste.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spg.pos.taskliste.model.DomainConfiguration;
import spg.pos.taskliste.service.ServiceConfiguration;
import spg.pos.tasklisterepositoryjpa.RepositoryJpaConfiguration;

/**
 * Configuration for testing.
 * 
 * @author michi
 */
@Configuration
@Import({DomainConfiguration.class, RepositoryJpaConfiguration.class, ServiceConfiguration.class})
public class ServiceTestConfiguration {

}
