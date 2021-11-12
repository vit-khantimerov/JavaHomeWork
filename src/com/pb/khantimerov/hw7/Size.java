package com.pb.khantimerov.hw7;
/**
 * +перечисление (enum) Size со значениями XXS, XS, S, M, L.
 * +Перечисление содержит метод getDescription(),
 * +возвращающий строку для XXS "Детский размер",
 * +для остальных "Взрослый размер".
 *
 * +Так же перечисление должно иметь метод getEuroSize()
 * +возвращающий числовое значение (32, 34, 36, 38, 40)
 * +соответствующее каждому размеру.
 * Создать конструктор принимающий на вход description и euroSize.
 */

public enum Size {
    XXS("32"),
    XS("34"),
    S("36"),
    M("38"),
    L("40");

    private String num;
    Size(String num) {
        this.num = num;
    }

    public String getDescription(Size sizeCode) {
        switch (sizeCode) {
            case XXS:
                return "Детский размер";
            default:
                return "Взрослый размер";
        }
    }

    public String getEuroSize(Size sizeCode) {
        switch (sizeCode) {
            case XXS:
                return "32";
            case XS:
                return "34";
            case S:
                return "36";
            case M:
                return "38";
            case L:
                return "40";
            default:
                return "0";
        }
    }
}

/*
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private String name;

    GameLevel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
 */
