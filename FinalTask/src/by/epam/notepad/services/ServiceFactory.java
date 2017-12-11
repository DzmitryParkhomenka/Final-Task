//класс для доступа к слою Service из слоя Test
package by.epam.notepad.services;

import by.epam.notepad.dao.DAOFactory;
import by.epam.notepad.services.impl.NotepadServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final NotepadServiceImpl notepadServiceImpl = NotepadServiceImpl.getNotepadServiceImpl();
	
	private ServiceFactory() {}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public NotepadServiceImpl getNotepadImpl() {
		return notepadServiceImpl;
	}
	
	//доступ к слою DAO через слой Service
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public DAOFactory getDAOFactory() {
		return daoFactory;
	}
}
