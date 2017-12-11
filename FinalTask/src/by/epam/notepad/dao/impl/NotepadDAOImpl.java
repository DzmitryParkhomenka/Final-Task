//реализация интерфейса NotepadDAO
package by.epam.notepad.dao.impl;

import by.epam.notepad.dao.NotepadDAO;
import by.epam.notepad.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NotepadDAOImpl implements NotepadDAO{
	//реализация возможности создания только 1 обьекта класса NotepadDAOImpl через паттерн singleton
	private static List<Note> notepad = new ArrayList<Note>();
	
	private static NotepadDAOImpl notepadData = null;
		
	private NotepadDAOImpl() {
	}
		
	public static NotepadDAOImpl getNotepad() {
		if (notepadData == null) {
			notepadData = new NotepadDAOImpl();
		}
		return notepadData;
	}

	public List<Note> getNotepadList(){
		return notepad;
	}
	
	//реализация добавления записи в блокнот
	@Override
	public void addNoteToNotepad(Note note) {
		notepad.add(note);
	}

	//реализация удаления записи из блокнота
	@Override
	public boolean deleteNoteFromNotepad(Note note) {
		return notepad.remove(note);
	}

	
}
