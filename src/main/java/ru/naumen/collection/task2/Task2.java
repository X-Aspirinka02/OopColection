package ru.naumen.collection.task2;
import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно реализовать метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task2
{

    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        //Используем HashSet для быстрого поиска
        Set<User> setB = new HashSet<>(collB); // создание O(m) m - длинна B

        List<User> duplicates = new LinkedList<>(); // добавление элемента за O(1)
        for (User user : collA) { // цикл O(n) n - длинна A
            if (setB.contains(user)) { //проверяем за O(1) за счет переопределенных методов сравнения объектов
                duplicates.add(user);
            }
        }
        return duplicates;
    }
    //средняя сложность O(m+n), где m и n - длины коллекций A и B
}

