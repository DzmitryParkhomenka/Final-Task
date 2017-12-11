//тестовый класс для проверки функциональности приложения
package by.epam.notepad.test;

import by.epam.notepad.dao.DAOFactory;
import by.epam.notepad.dao.impl.NotepadDAOImpl;
import by.epam.notepad.entity.Note;
import by.epam.notepad.services.ServiceFactory;
import by.epam.notepad.services.impl.NotepadServiceImpl;

public class Test {

	public static void main(String[] args) {
		UsefullMethodsForTesting testMethod = new UsefullMethodsForTesting();
		//создание обьекта класса ServiceFactory для доступа к слою сервисов
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		
		//создание обьекта класса NotepadServiceImpl для доступа к методам поиска(по дате и по содержимому)
		NotepadServiceImpl serviceImpl = serviceFactory.getNotepadImpl();
		
		//создание обьекта класса DAOFactory через слой Service для доступа к методам создания блокнота, добавления/удаления записи из него
		DAOFactory daoFactory = serviceFactory.getDAOFactory();

		//содзание обьекта класса NotepadDAOImpl через слой DAO для добавления/удаления записей из блокнота
		NotepadDAOImpl notepad = daoFactory.getNotepadDAO();
		
		//проверка возможности добавления записей в блокнот
		notepad.addNoteToNotepad(new Note("01.01.2018", "New Plans"));
		notepad.addNoteToNotepad(new Note("29.11.1990", "My Birthday"));
		notepad.addNoteToNotepad(new Note("02.08.2014", "Son's Birthday"));
		notepad.addNoteToNotepad(new Note("04.04.2018", "Automation"));
		
		testMethod.showNotepadToConsole(notepad.getNotepadList()); //вывод блокнота в консоль с созданными записями
		testMethod.showDivisionalLine(); //разделительная полоса для наглядности
		
		//поиск записи по дате
		testMethod.showSingleNote(serviceImpl.findNoteByDate("01.01.2018", notepad.getNotepadList())); //поиск даты 01.01.2018
		testMethod.showSingleNote(serviceImpl.findNoteByDate("04.04.2018", notepad.getNotepadList())); //поиск даты 04.04.2018
		testMethod.showSingleNote(serviceImpl.findNoteByDate("33.33.2555", notepad.getNotepadList())); //поиск даты 33.33.2555 - ее не существует в записях блокноте
		testMethod.showDivisionalLine(); //разделительная полоса для наглядности
		
		//поиск записи по содержимому
		testMethod.showSingleNote(serviceImpl.findNoteByContent("My Birthday", notepad.getNotepadList())); //поиск записи по содержимому My Birthday
		testMethod.showSingleNote(serviceImpl.findNoteByContent("Son's Birthday", notepad.getNotepadList())); //поиск записи по содержимому Son's Birthday
		testMethod.showSingleNote(serviceImpl.findNoteByContent("Java book - is my precious", notepad.getNotepadList())); //поиск записи по содержимому Java book - is my precious - его не существует в записях в блокноте
		testMethod.showDivisionalLine(); //разделительная полоса для наглядности
		
		//удаление записи
		notepad.deleteNoteFromNotepad(notepad.getNotepadList().get(0)); //удаление записи под индексом 0
		testMethod.showNotepadToConsole(notepad.getNotepadList()); //вывод блокнота в консоль с созданными записями
		testMethod.showDivisionalLine(); //разделительная полоса для наглядности
		
		notepad.deleteNoteFromNotepad(notepad.getNotepadList().get(2)); //удаление записи под индексом 2
		testMethod.showNotepadToConsole(notepad.getNotepadList()); //вывод блокнота в консоль с созданными записями
		testMethod.showDivisionalLine(); //разделительная полоса для наглядности
		
		//попытка удаления записи под индексом 2 (мой блокнот уже имеет только 2 записи под индексами 0 и 1)
		try {
			notepad.deleteNoteFromNotepad(notepad.getNotepadList().get(2)); //удаление записи под индексом 2
			testMethod.showNotepadToConsole(notepad.getNotepadList()); //вывод блокнота в консоль с созданными записями
			testMethod.showDivisionalLine(); //разделительная полоса для наглядности
		} catch (IndexOutOfBoundsException e) {
			System.out.println("There is no Note under index 2");
		}
		
	}

}
