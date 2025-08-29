package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель пользователя банковского сервиса.
 * Пользователь идентифицируется по номеру паспорта {@code passport}.
 * Имя пользователя хранится в поле {@code username}.
 *
 * <p>Эквивалентность пользователей определяется по полю {@link #passport}.</p>
 *
 * @author Kulsinbai
 * @version 1.0
 * @since 2025-08-30
 */
public class User {

    /**
     * Номер паспорта (уникальный идентификатор пользователя).
     */
    private String passport;

    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Создаёт нового пользователя.
     *
     * @param passport номер паспорта
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта.
     *
     * @return паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает номер паспорта.
     *
     * @param passport новый паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     *
     * @param username новое имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Два пользователя равны, если у них совпадают паспорта.
     *
     * @param o другой объект
     * @return {@code true}, если объекты равны; иначе {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Хэш-код основан только на паспорте.
     *
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}