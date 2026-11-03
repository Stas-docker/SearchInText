package utils;

public enum UserChoice {
    CONTINUE(1),
    EXIT(2),
    UNKNOWN(0);

    private final int code;

    UserChoice(final int code) {
        this.code = code;
    }

    public static UserChoice fromCode(final int code) {
        return switch (code) {
            case 1 -> CONTINUE;
            case 2 -> EXIT;
            default -> UNKNOWN;
        };
    }
}
