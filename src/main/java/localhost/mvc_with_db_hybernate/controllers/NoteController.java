package localhost.mvc_with_db_hybernate.controllers;

import localhost.mvc_with_db_hybernate.entity.Note;
import localhost.mvc_with_db_hybernate.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {
  private NoteService service;

  @Autowired
  public void setNoteService(NoteService service) {
    this.service = service;
  }
  @GetMapping("/")
  public String list(Model model) {
    return "index";
  }

  @GetMapping("/new")
  public String newNote() {
    return "operations/new";
  }

  @PostMapping("/save")
  public String updateNote(@RequestParam String message) {
    service.saveNote(new Note(message));
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    Note note = service.getNoteById(id);
    model.addAttribute("note", note);
    return "operations/edit";
  }

  @PostMapping("/update")
  public String saveNote(@RequestParam Integer id, @RequestParam String message,
                         @RequestParam(value = "done", required = false) boolean done) {
    service.updateNote(id, message, done);
    return "redirect:/";
  }
}
