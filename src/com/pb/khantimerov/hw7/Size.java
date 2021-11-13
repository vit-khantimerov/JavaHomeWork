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
 * +Создать конструктор принимающий на вход description и euroSize.
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

    String getEuroSize(){ return num;}

    String getDescription(Size size) {
        if (size == XXS) {
            return "детский размер";
        }
        return "взрослый размер";
    }
}
