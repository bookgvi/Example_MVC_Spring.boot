package localhost.mvc_with_db_hybernate.service;

import localhost.mvc_with_db_hybernate.entity.Note;
import localhost.mvc_with_db_hybernate.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
  private NoteRepository repository;

  @Autowired
  private void setProductRepository(NoteRepository repository) {
    this.repository = repository;
  }

  @Override
  public Note getNoteById (Integer id) {
    return repository.getOne(id);
  }

  @Override
  public void saveNote (Note note) {
    repository.save(note);
  }

  @Override
  public void updateNote (Integer id, String message, boolean done) {
    Note updated = repository.getOne(id);
    repository.save(updated);
  }

  @Override
  public void deleteNote (Integer id) {
    repository.deleteById(id);
  }

  @Override
  public List<Note> findAll () {
    return repository.findAll();
  }
}
