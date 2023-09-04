package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void print() {
        System.out.println("Error status: " + "\n"
                + "active: " + active
                + ", status: " + status
                + ", message: '" + message + "'" + "\n");
    }

    public static void main(String[] args) {
        Error errorEmpty = new Error();
        Error error400 = new Error(true, 404, "Not Found");
        Error error200 = new Error(true, 203, "Non-Authoritative Information");
        Error error500 = new Error(true, 501, "Not Implemented");
        errorEmpty.print();
        error400.print();
        error200.print();
        error500.print();
    }
}
