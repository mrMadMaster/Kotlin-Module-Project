package ui

import java.util.Scanner

abstract class BaseMenu<T>(private val title: String) {
    private val scanner = Scanner(System.`in`)
    protected abstract val items: List<T>
    protected abstract val createItemText: String
    protected abstract val exitText: String
    protected abstract fun onCreateItem()
    protected abstract fun onItemSelected(item: T)
    protected abstract fun getItemName(item: T): String

    fun show() {
        while (true) {
            printMenu()
            when (val input = scanner.nextLine().trim()) {
                "0" -> onCreateItem()
                "${items.size + 1}" -> return
                else -> handleSelection(input)
            }
        }
    }

    private fun printMenu() {
        println("\n=== $title ===")
        println("0. $createItemText")
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${getItemName(item)}")
        }
        println("${items.size + 1}. $exitText")
        println("Выберите номер пункта")
    }

    private fun handleSelection(input: String) {
        input.toIntOrNull()?.let { choice ->
            when {
                choice in 1..items.size -> onItemSelected(items[choice - 1])
                else -> println("Неверный номер пункта")
            }
        } ?: println("Введите число")
    }
}