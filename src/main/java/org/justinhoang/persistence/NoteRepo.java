package org.justinhoang.persistence;

import org.justinhoang.entity.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<Note, Long>
{

}
