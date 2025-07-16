package ui

import model.Note

class NoteViewer(private val note: Note) {
    fun show() {
        println("\n=== ${note.title} ===")
        println(note.content)
        println("\nНажмите Enter для возврата...")
        readlnOrNull()
    }
}