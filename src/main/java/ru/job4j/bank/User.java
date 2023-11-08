package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, представляющий пользователя банка,
 * содержит геттеры и сеттеры для доступа к полям класса
 * и конструктор дял создагия объекта с необходимыми данными
 *
 * @author ANDREY KONDRATEV
 * @version 1.0
 */

public class User {
    /**
     * номер паспорта пользователя
     */
    private String passport;
    /**
     * имя пользователя
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * В классе переопределены методы equals() и hashCode()
     * для сравнения объектов User на основе их паспортных данных.
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

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}