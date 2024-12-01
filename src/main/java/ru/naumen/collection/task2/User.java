package ru.naumen.collection.task2;
import java.util.Arrays;
import java.util.Objects;

/**
 * Пользователь
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class User {
    private String username;
    private String email;
    private byte[] passwordHash;

    /**
     * Переопределение метода сравнения, т к нам нужны одинаковые поля у объектов, а не одинаковые объекты
     * @param o передаваемый объект для сравнения
     * @return true если объект одного класса и поля совпадают
     */
    @Override
    public boolean equals(Object o) {
        //вдруг не только поля одинаковые, но и объекты
        if (this == o) return true;
        // т к стандартный equals должен принимать Object
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        //а тут уже сравниваем поля
        return username.equals(user.username) && email.equals(user.email) && Arrays.equals(passwordHash, user.passwordHash);
    }
    /**
     * Переопределение hash функции, для переопределения equals
     * @return hash для объекта
     */
    @Override
    public int hashCode() {
        //теперь hash функция тоже будет зависеть от полей
        // так что при сравнении equals, hash тоже будет одинаковый
        int hash = Objects.hash(username, email);
        hash = 31 * hash + Arrays.hashCode(passwordHash);
        return hash;
    }

}
