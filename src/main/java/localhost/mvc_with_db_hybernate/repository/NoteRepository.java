package localhost.mvc_with_db_hybernate.repository;

import localhost.mvc_with_db_hybernate.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
