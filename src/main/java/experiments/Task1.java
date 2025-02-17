package experiments;

/*1. Разворот строки

Задание:
Напишите метод, который на вход принимает строку и возвращает её «развернутую» (символы в обратном порядке).

Пример:
	•	Вход: "Hello World".
	•	Выход: "dlroW olleH".

Подсказки и детали реализации:
	•	Можно использовать разные подходы: вручную через цикл, используя StringBuilder или рекурсию.
	•	Обратите внимание на пограничные случаи: пустая строка, строка из одного символа, не-ASCII символы.

 */

public class Task1 {
    private static StringBuilder text = new StringBuilder("Hello World");
    private static String word = "Hello World";

    public static void main(String[] args) {
        String result = "";

        System.out.println(text);
        for (int i = word.length()-1; i>=0; i--){
            result = result + word.charAt(i);
        }
        System.out.println(result);
    }

}
