//реализация интерфейса NotepadService
package by.epam.notepad.services.impl;

import by.epam.notepad.services.NotepadService;
import java.util.List;

import by.epam.notepad.dao.DAOFactory;
import by.epam.notepad.entity.Note;

public class NotepadServiceImpl implements NotepadService {
	// создание конструктора
	private static NotepadServiceImpl notepadService = null;

	public static NotepadServiceImpl getNotepadServiceImpl() {
		if (notepadService == null) {
			notepadService = new NotepadServiceImpl();
		}
		return notepadService;
	}

	// создание обьекта класса DAOFactory для получения его методов
	DAOFactory factory = DAOFactory.getInstance();

	// реализация метода поска по дате
	@Override
	public String findNoteByDate(String date, List<Note> notepad) {
		String result = "Date has not been found";
		for (Note note : notepad) {
			if (note.getNoteDate().equals(date)) {
				return result = note.getNoteDate() + " " + note.getNoteContent();
			}
		}
		return result;
	}

	// реализация метода поиска по содержимому
	@Override
	public String findNoteByContent(String content, List<Note> notepad) {
		String result = "Content has not been found";
		for (Note note : notepad) {
			if (note.getNoteContent().equals(content)) {
				return result = note.getNoteDate() + " " + note.getNoteContent();
			}
		}
		return result;
	}
}
