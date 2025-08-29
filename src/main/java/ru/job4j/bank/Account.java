package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель банковского счёта пользователя.
 * Каждый счёт идентифицируется по уникальным реквизитам {@code requisite}.
 * Баланс хранится в виде числа с плавающей точкой.
 *
 * <p>Эквивалентность счетов определяется только по полю {@link #requisite}.</p>
 *
 * @author Kulsinbai
 * @version 1.0
 * @since 2025-08-30
 */
public class Account {

    /**
     * Уникальные реквизиты счёта (например, номер счёта).
      */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счёта.
     *
     * @return строка с реквизитами
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты счёта.
     *
     * @param requisite новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает текущий баланс.
     *
     * @return значение баланса
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс.
     *
     * @param balance новое значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Два счёта равны, если совпадают их реквизиты.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Хэш-код основан только на реквизитах счёта.
     *
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}