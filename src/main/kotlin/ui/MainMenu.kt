package ui

import model.Archive

class MainMenu(private val archives: MutableList<Archive>) : BaseMenu<Archive>("ГЛАВНОЕ МЕНЮ") {
    override val items: List<Archive> get() = archives
    override val createItemText = "Создать архив"
    override val exitText = "Выход"

    override fun getItemName(item: Archive) = item.name

    override fun onCreateItem() {
        print("Введите название архива: ")
        val name = readlnOrNull()?.trim() ?: ""
        if (name.isBlank()) {
            println("Название архива не может быть пустым")
            return
        }

        archives.add(Archive(name))
        println("Архив '$name' создан")
    }

    override fun onItemSelected(item: Archive) {
        ArchiveMenu(item).show()
    }
}