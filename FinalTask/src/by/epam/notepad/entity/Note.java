//сущность Note. нужна для добавления в блокнот
package by.epam.notepad.entity;

public class Note {
	String noteDate;
	String noteContent;
	
	public Note() {
	}
	
	public Note(String noteDate, String noteContent) {
		this.noteDate = noteDate;
		this.noteContent = noteContent;
	}

	public String getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(String noteDate) {
		this.noteDate = noteDate;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	@Override
	public String toString() {
		return "Note [noteDate=" + noteDate + ", noteContent=" + noteContent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noteContent == null) ? 0 : noteContent.hashCode());
		result = prime * result + ((noteDate == null) ? 0 : noteDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (noteContent == null) {
			if (other.noteContent != null)
				return false;
		} else if (!noteContent.equals(other.noteContent))
			return false;
		if (noteDate == null) {
			if (other.noteDate != null)
				return false;
		} else if (!noteDate.equals(other.noteDate))
			return false;
		return true;
	}
	
	
}
