//класс для доступа к слою DAO из слоя сервисов
package by.epam.notepad.dao;

import by.epam.notepad.dao.impl.NotepadDAOImpl;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final NotepadDAOImpl notepadDAOImpl = NotepadDAOImpl.getNotepad();
	
	private DAOFactory() {}
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public NotepadDAOImpl getNotepadDAO() {
		return notepadDAOImpl;
	}
}
