package localhost.mvc_with_db_hybernate.service;

import localhost.mvc_with_db_hybernate.entity.Note;

import java.util.List;

public interface NoteService {
  Note getNoteById(Integer id);
  void saveNote(Note note);
  void updateNote(Integer id, String message, boolean done);
  void deleteNote(Integer id);
  List<Note> findAll();
}
