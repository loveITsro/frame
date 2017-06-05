package sk.loveit.frame.persist.repository;

import org.springframework.data.repository.CrudRepository;
import sk.loveit.frame.persist.entity.BaseEntity;

public interface BaseEntityRepository<T extends BaseEntity> extends CrudRepository<T, String> {
	
}
