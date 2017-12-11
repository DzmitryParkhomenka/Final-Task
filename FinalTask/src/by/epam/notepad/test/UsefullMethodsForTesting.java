//класс дополнительных методов для тестирования
package by.epam.notepad.test;

import java.util.List;

import by.epam.notepad.entity.Note;

public class UsefullMethodsForTesting {
	public void showSingleNote(String note) {
		System.out.println(note);
	}
	
	public void showNotepadToConsole(List<Note> notepad) {
		for (int i=0; i<notepad.size();i++) {
			System.out.println(notepad.get(i));
		}
	}
	
	public void showDivisionalLine() {
		System.out.println("---------------------------------------------------------------------");
	}
	
	
}
