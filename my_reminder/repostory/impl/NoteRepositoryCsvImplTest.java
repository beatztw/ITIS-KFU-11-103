package my_reminder.repostory.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import my_reminder.model.Note;
import my_reminder.repostory.NoteRepository;
import my_reminder.repostory.impl.NoteRepositoryCsvImpl;

import java.io.File;
import java.time.Instant;

public class NoteRepositoryCsvImplTest {
    private final NoteRepository repository = new NoteRepositoryCsvImpl("database" + File.separator +"notes_test.csv");

    @Test
    void checkSave() {
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), false));

        Assertions.assertEquals(2, repository.getAll().size());
        repository.deleteAll();
    }

    @Test
    void checkGetId() {
        repository.save(new my_reminder.model.Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new my_reminder.model.Note("Test2", Instant.ofEpochSecond(1648190891), false));
        repository.save(new my_reminder.model.Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new my_reminder.model.Note("Test4", Instant.ofEpochSecond(1648190891), false));

        Assertions.assertEquals("Test2", repository.getById(2).getText());
        repository.deleteAll();
    }
    @Test
    void checkUndonable() {
        repository.save(new my_reminder.model.Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new my_reminder.model.Note("Test2", Instant.ofEpochSecond(1648190891), true));
        repository.save(new my_reminder.model.Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new my_reminder.model.Note("Test4", Instant.ofEpochSecond(1648190891), true));

        Assertions.assertEquals(2, repository.getUndoneByDate(Instant.ofEpochSecond(1648190891)).size());

        repository.deleteAll();
    }

    @Test
    void checkRemoveByID() {
        repository.save(new my_reminder.model.Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new my_reminder.model.Note("Test2", Instant.ofEpochSecond(1648190891), true));
        repository.save(new my_reminder.model.Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new my_reminder.model.Note("Test4", Instant.ofEpochSecond(1648190891), true));

        repository.delete(2);
        Informatics.domachka.Reminder.Exception.NotePersistenceException thrown = Assertions.assertThrows(Informatics.domachka.Reminder.Exception.NotePersistenceException.class, () -> {
            repository.getById(2);
        });

        Assertions.assertEquals("Note with id 2 not found", thrown.getMessage());
        repository.deleteAll();
    }
}
