package ru.job4j.bank;

import java.util.*;

/**
 * Класс представляет собой банковскую систему,
 * с возможностью добавления, поиска и удаления пользователей, добавления и поиска счета пользователей
 * по реквизитам и переводом средств с одного счета на другой.
 *
 * @author ANDREY KONDRATEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя.
     * Если пользователь уже существует, то метод ничего не делает.
     *
     * @param user новый пользователь
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспортные данные и удаляет пользователя.
     *
     * @param passport паспорт пользователя, которого нужно удалить
     */

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход паспорт и счет, и добавляет новый счет пользователю.
     * Если пользователь не существует, метод ничего не делает.
     * Если счет уже существует у данного пользователя, метод также ничего не делает.
     *
     * @param passport паспорт пользователя
     * @param account  новый счет пользователя
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по паспорту.
     *
     * @param passport паспорт пользователя, которого нужно найти
     * @return возвращает найденного пользователя или null, если пользователь не найден
     */

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск счета пользователя по реквизитам.
     *
     * @param passport  паспорт пользователя
     * @param requisite реквизиты счета, который нужно найти
     * @return возвращает найденный счет или null, если счет не найден
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : getAccounts(user)) {
                if (requisite.equals(acc.getRequisite())) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег с одного счета на другой.
     * Если счета или не хватает денег на счете, метод возвращает false, иначе - true.
     *
     * @param srcPassport   паспорт пользователя, с которого списываются деньги
     * @param srcRequisite  реквизиты счета, с которого списываются деньги
     * @param destPassport  паспорт пользователя, на который переводятся деньги
     * @param destRequisite реквизиты счета, на который переводятся деньги
     * @param amount        сумма для перевода
     * @return возвращает true, если перевод выполнен успешно, иначе - false
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод для получения списка счетов пользователя.
     *
     * @param user пользователь, чьи счета нужно получить
     * @return возвращает список счетов пользователя
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}