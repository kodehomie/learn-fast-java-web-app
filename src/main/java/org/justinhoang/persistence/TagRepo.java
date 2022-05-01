package org.justinhoang.persistence;

import org.justinhoang.entity.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepo extends CrudRepository<Tag, Long>
{

}
