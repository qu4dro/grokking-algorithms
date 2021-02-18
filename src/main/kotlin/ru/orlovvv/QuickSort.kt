package ru.orlovvv

import kotlin.random.Random

/* БЫСТРАЯ СОРТИРОВКА

    Сложность в общем случае O(n*log(n))
    Сложность в лучшем случае O(n)
    Сложность в худшем случае O(n^2)
    (Зависит от правильности выбора опорного элемента)

    Быстрая сортировка основана на стратегии "Разделяй и властвуй"

    За базовый случай берутся пустые массивы и массивы, содержащие всего один элемент

    Суть сортировки заключается в разделении массива на:
    1) опорный элемент
    2) подмассив элементов, меньших опорного
    3) подмассив элементов, больших опорного
    Затем рекурсивно применяется быстрая сортировка к этим двум подмассивам,
    а результаты складываются

 */

fun quickSort(list: List<Int>): List<Int> {
    if (list.count() < 2)   // базовый случай: массивы с 0 и 1 элементом
        return list         // уже отсортированы

                            // рекурсивный случай
    val pivot = list[list.count() / 2]      // выбор опорного элемента
    val less = list.filter { it < pivot }   // подмассив меньших элементов
    val greater = list.filter { it > pivot} // подмассив больших элементов
    val equal = list.filter { it == pivot}  // элементы, равные опорному

    return quickSort(less) + equal + quickSort(greater) // рекурсивный вызов
}

fun main() {
    val testList: List<Int> = List (100) {it + (0..555).random()}
    println(testList)
    println(quickSort(testList))
}