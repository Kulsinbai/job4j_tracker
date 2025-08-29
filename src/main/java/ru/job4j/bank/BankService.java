package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сервис для управления пользователями и их банковскими счетами,
 * а также для выполнения переводов между счетами.
 *
 * <p>Внутри хранит отображение {@code User -> List<Account>}.</p>
 *
 * <p><b>Важно:</b> данный класс не потокобезопасен.</p>
 *
 * @author Kulsinbai
 * @version 1.0
 * @since 2025-08-30
 */
public class BankService {

    /**
     * Хранилище пользователей и их счетов.
     * Ключ — пользователь, значение — список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя, если его ещё нет в системе.
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя по номеру паспорта.
     * Если пользователь с таким паспортом отсутствует — ничего не делает.
     *
     * @param passport паспорт пользователя для удаления
     */
    public void deleteUser(String passport) {
            users.remove(new User(passport, ""));
    }

    /**
     * Добавляет счёт пользователю по его паспорту.
     * Счёт не будет добавлен повторно, если счёт с такими реквизитами уже есть.
     *
     * @param passport паспорт пользователя
     * @param account  счёт для добавления
     */
    public void addAccount(String passport, Account account) {
        User u = findByPassport(passport);
        if (u != null) {
            List<Account> accounts = users.get(u);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по номеру паспорта.
     *
     * @param passport номер паспорта
     * @return найденный пользователь или {@code null}, если не найден
     */
    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Находит счёт пользователя по паспорту и реквизитам.
     *
     * @param passport  номер паспорта
     * @param requisite реквизиты счёта
     * @return найденный счёт или {@code null}, если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User u = findByPassport(passport);
        if (u == null) {
            return null;
        }
        for (Account acc : users.get(u)) {
            if (acc.getRequisite().equals(requisite)) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Переводит деньги между счетами.
     *
     * <p>Условия успешного перевода:</p>
     * <ul>
     *   <li>Оба счёта существуют;</li>
     *   <li>На исходном счёте достаточно средств;</li>
     *   <li>Сумма {@code amount} неотрицательна (предполагается корректный ввод).</li>
     * </ul>
     *
     * @param sourcePassport      паспорт отправителя
     * @param sourceRequisite     реквизиты счёта отправителя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизиты счёта получателя
     * @param amount              сумма перевода
     * @return {@code true}, если перевод выполнен; иначе {@code false}
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);

        if (source == null || destination == null || source.getBalance() < amount) {
            return false;
        }

        source.setBalance(source.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
        return true;
    }

    /**
     * Возвращает список счетов для указанного пользователя.
     *
     * @param user пользователь
     * @return список его счетов или {@code null}, если пользователя нет в хранилище
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}