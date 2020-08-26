package localhost.mvc_with_db_hybernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notes", schema = "note_schema", catalog = "")
public class Note {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "message")
  private String message;

  @Column(name = "date")
  private Date date;

  @Column(name = "isdone")
  private Boolean isDone;

  public Note () {
  }

  public Note (String message) {
    this.message = message;
    this.date = new Date();
    this.isDone = false;
  }

  @Override
  public String toString() {
    return "Message: " + message + "\n"
        + "Date: " + date;
  }
}
