//интерфейс для слоя DAO
package by.epam.notepad.dao;

import by.epam.notepad.entity.Note;

public interface NotepadDAO {
	void addNoteToNotepad(Note note); //метод добавления записи

	boolean deleteNoteFromNotepad(Note note); //метод удаления записи
}
