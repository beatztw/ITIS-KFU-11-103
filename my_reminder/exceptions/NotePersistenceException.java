package my_reminder.exceptions;

public class NotePersistenceException extends RuntimeException {
    public NotePersistenceException(String message) {
        super(message);
    }
}