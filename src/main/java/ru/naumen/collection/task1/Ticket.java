package ru.naumen.collection.task1;


/**
 * Билет
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Ticket {
    private long id;
    private String client;

    /**
     * Переопределение метода сравнения для увеличения скорости работы
     * @param o передаваемый объект для сравнения
     * @return true если объект одного класса и поля совпадают
     */
    @Override
    public boolean equals(Object o) {
        //вдруг не только поля одинаковые, но и объекты
        if (this == o) return true;
        // т к стандартный equals должен принимать Object
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        // сравнивать будет по уникальным идентификаторам билета
        return id == ticket.id;
    }
    /**
     * Переопределение hash функции, для переопределения equals
     * @return hash для объекта
     */
    @Override
    public int hashCode() {
        //теперь hash функция тоже будет зависеть от идентификатора
        // так что при сравнении equals, hash у одинатовых объектов тоже будет одинаковый
        return Long.hashCode(id);
    }
}
