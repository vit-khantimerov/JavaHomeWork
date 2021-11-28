package com.pb.khantimerov.hw10;

public class Main {
    public static void main(String[] args) {
        int intSize = 4, floatSize = 5;

        NumBox<Integer> integers = new NumBox<>(intSize);
        integers.add( 100,0);
        integers.add( 0,1);
        //integers.add( 200,2);
        integers.add( -100,3);
        integers.add( -1,3);
        integers.add( 1000,4);

        System.out.println();

        for (int i = 0; i < intSize + 2; i++) {
            if (integers.get(i) != null) {
                System.out.println("integers(" + i + ")  = " + integers.get(i).intValue());
            } else {
                if (i < intSize) {
                    System.out.println("integers(" + i + ")  = " + integers.get(i));
                }
            }
        }

        System.out.println();
        integers.length();
        integers.average();
        integers.sum();
        integers.max();

        System.out.println();

        NumBox<Float> floats = new NumBox<>(floatSize);
        floats.add( 10.0f,0);
        floats.add( 500.0f,1);
        //floats.add(50.0f,2);
        floats.add(-10.0f,3);
        floats.add(99.0f, 4);
        floats.add( 99.0f,5);

        System.out.println();

        floats.length();
        floats.average();
        floats.sum();
        floats.max();

        System.out.println();
        for (int i = 0; i < floatSize + 2; i++) {
            if (floats.get(i) != null) {
                System.out.println("floats(" + i + ")  = " + floats.get(i).floatValue());
            } else if (i < floatSize) {
                System.out.println("floats(" + i + ")  = " + floats.get(i));
            }
        }
    }
}
/* Резудьтат.

"C:\Program Files\Java\jdk1.8.0_301\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\lib\idea_rt.jar=54400:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_301\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\rt.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\out\production\JavaHomeWork" com.pb.khantimerov.hw10.Main
Добавлен Integer[0] = 100.0
Добавлен Integer[1] = 0.0
Добавлен Integer[3] = -100.0
Добавлен Integer[3] = -1.0
Integer[4] не добален. Превышена длина массива.

integers(0)  = 100
integers(1)  = 0
integers(2)  = null
integers(3)  = -1
Number[][4]  Не существует (индекс за пределами массива).
Number[][5]  Не существует (индекс за пределами массива).

Длина массива  = 3
Среднее = 33.0
Сумма = 99.0
Максимум = 100.0

Добавлен Float[0] = 10.0
Добавлен Float[1] = 500.0
Добавлен Float[3] = -10.0
Добавлен Float[4] = 99.0
Float[5] не добален. Превышена длина массива.

Длина массива  = 4
Среднее = 149.75
Сумма = 599.0
Максимум = 500.0

floats(0)  = 10.0
floats(1)  = 500.0
floats(2)  = null
floats(3)  = -10.0
floats(4)  = 99.0
Number[][5]  Не существует (индекс за пределами массива).
Number[][6]  Не существует (индекс за пределами массива).

Process finished with exit code 0

 */