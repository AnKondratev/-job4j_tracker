package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, представляющий банковский счет,
 * содержит информацию о реквизите аккаунта и балансе.
 *
 * @author ANDREY KONDRATEV
 * @version 1.0
 */

public class Account {
    /**
     * Реквизит (requisite) является уникальным
     * идентификатором для каждого банковского счета.
     */
    private String requisite;
    /**
     * Баланс (balance) представляет собой текущую сумму денег на счете.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Класс предоставляет геттеры и сеттеры для доступа к реквизиту и балансу.
     */

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * В классе переопределены методы equals() и hashCode()
     * для сравнения объектов Account на основе их реквизита.
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

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}