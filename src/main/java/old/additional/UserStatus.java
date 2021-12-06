package old.additional;

public enum UserStatus {

    AVAILABLE("available"),
    UNAVAILABLE("unavailable");

    private String name;

    UserStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
