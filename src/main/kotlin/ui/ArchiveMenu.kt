package ui

import model.Archive
import model.Note

class ArchiveMenu(private val archive: Archive) : BaseMenu<Note>("АРХИВ: ${archive.name}") {
    override val items: List<Note> get() = archive.notes
    override val createItemText = "Создать заметку"
    override val exitText = "Назад"

    override fun getItemName(item: Note) = item.title

    override fun onCreateItem() {
        print("Введите название заметки: ")
        val title = readlnOrNull()?.trim() ?: ""
        if (title.isBlank()) {
            println("Название заметки не может быть пустым")
            return
        }

        print("Введите текст заметки: ")
        val content = readlnOrNull()?.trim() ?: ""
        if (content.isBlank()) {
            println("Текст заметки не может быть пустым")
            return
        }

        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана")
    }

    override fun onItemSelected(item: Note) {
        NoteViewer(item).show()
    }
}