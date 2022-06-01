package my_reminder;

import my_reminder.exceptions.NotePersistenceException;
import my_reminder.model.Note;
import my_reminder.repostory.NoteRepository;
import my_reminder.repostory.impl.NoteRepositoryCsvImpl;
import my_reminder.repostory.impl.NoteRepositorySerializableImpl;

import java.io.File;
import java.time.Instant;

public class Main {
    // Добавлять заметки на определенное время
    // Отмечать заметки как выполнено
    // Удалять заметки
    // Получать список всех заметок на день
    // Получать список всех выполненных заметок на день
    public static void main(String[] args) {
        try {
            NoteRepository repository = new NoteRepositorySerializableImpl("C:\\Users\\alex1\\IdeaProjects\\untitled\\src\\database\\notes_database");
            repository.save(new Note("Test1", Instant.now(), false));
            repository.save(new Note("Test2", Instant.now(), false));
            System.out.println(repository.getUndoneByDate(Instant.now()).size());
        } catch (NotePersistenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
