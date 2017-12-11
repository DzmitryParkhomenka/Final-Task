//интерфейс для слоя Services
package by.epam.notepad.services;

import java.util.List;

import by.epam.notepad.entity.Note;

public interface NotepadService {
	String findNoteByDate(String date, List<Note> notepad); //метод поиска по дате

	String findNoteByContent(String date, List<Note> notepad); //метод поиска по содержимому
}
