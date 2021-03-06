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

public enum Size_2 {
    XXS("32", 32, "детский размер"),
    XS ("34", 34, "взрослый размер"),
    S  ("36", 36, "взрослый размер"),
    M  ("38", 38, "взрослый размер"),
    L  ("40", 40, "взрослый размер");

    private String num, legend;
    private int nrEur;

    Size_2(String num, int nrEur, String legend) {
        this.num = num;
        this.nrEur = nrEur;
        this.legend = legend;
    }

    String getEuroSize()
        {
            return num;
        }

    String getDescription() {
            return legend;
        }

    int getNrEur() {
            return nrEur;
        }
}
