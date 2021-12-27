// решение без Wait() и Notify()

package com.pb.khantimerov.hw13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NewYearPresents {
    static volatile int childrenGifts = 0; // общее кол-во полученных подарков
    static volatile int personsGifts = 0; // общее кол-во подаренных подарков
//    static volatile List<Children> Childrennn = new ArrayList<>();

    static class Children implements Runnable {
        private final List<String> buffer;
        private final String name;
        private final List<String> receivedGifts = new ArrayList<>();

        public Children(List<String> buffer, String name) {
            this.buffer = buffer;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized int fromSack (List<String> sack, String child) {
            int p = 0;  // кол-во подарков каждого ребенка
            int s = sack.size();
            String gift; // = null;
                try {
                    gift = sack.get(0);
                    if (s > 0) {
                        sack.remove(0);
                        System.out.println("-- " + name + " взял(а) " + gift + " из мешка :)");
                        p = 1;
                        receivedGifts.add(gift);
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(":( " + child + " :( Мешок пустой, нет подарков.");
                }
                return p;
        }

        public void run() {
            int i = 0, p = 0;
            while (i < 5) { // ребенок может проверить и получить подарок не больше 5 раз
                try {
                    int seconds = new Random().nextInt(5000);
                    Thread.sleep(seconds);
                    p += fromSack(buffer, name);
                } catch (InterruptedException e) {
                    e.printStackTrace(); }
                i++;
            }
            System.out.println("\n***** " + name + " ушел(а), он(а) получил(а) подарки: \n" + receivedGifts +
                    ", всего " + p + " штук(и) *****\n");
            childrenGifts += p;
            }
    }

    static class Person implements Runnable {
        private final List<String> buffer;
        private final String present;

        public Person(List<String> buffer, String present) {
            this.buffer = buffer;
            this.present = present;
        }

        public synchronized int toSack (List<String> sack, String gift, String person) {
            int s = sack.size(), p = 0;
            if (s < 5) {
                sack.add(gift);
                p = 1;
                System.out.println("++ " + person + " положил(а) " + gift + " в мешок :)");
            } else {
                System.out.println(person + ":( Мешок полон. Нельзя положить новый подарок :(");
            }
            return p;
        }

        public void run() {
            int i = 0, p = 0;
            String threadName = Thread.currentThread().getName();
            while (i < 10) {
                int seconds = new Random().nextInt(3000);
                try {
                    Thread.sleep(seconds);
                    p += toSack(buffer, present, threadName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            System.out.println("\n===== " + threadName + " всего положил(а) " + p + " подарков и ушел(а) =====\n");
            personsGifts += p;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<String> sack = Collections.synchronizedList(new ArrayList<>());

        Thread ded = new Thread(new Person(sack, "конфеты"));
        Thread snegurochka = new Thread(new Person( sack, "печенье"));
        Thread santa = new Thread(new Person(sack, "тортик"));
        Thread baba = new Thread(new Person(sack, "жвачка"));
        Thread niko = new Thread(new Person(sack, "шоколадка"));
        ded.setName("Дед Мороз");
        snegurochka.setName("Снегрочка");
        santa.setName("Санта Клаус");
        baba.setName("Баба яга");
        niko.setName("Святой Николай");


        Thread child1 = new Thread(new Children(sack, "Вовочка"));
        Thread child2 = new Thread(new Children(sack, "Петя"));
        Thread child3 = new Thread(new Children(sack, "Юля"));
        Thread child4 = new Thread(new Children(sack, "Филя"));
        Thread child5 = new Thread(new Children(sack, "Женя"));
        Thread child6 = new Thread(new Children(sack, "Саша"));
        Thread child7 = new Thread(new Children(sack, "Коля"));
        Thread child8 = new Thread(new Children(sack, "Герхард"));
        Thread child9 = new Thread(new Children(sack, "Олег"));
        Thread child10 = new Thread(new Children(sack, "Леша"));

        ded.start();
        snegurochka.start();
        child1.start();
        child2.start();
        child3.start();
        santa.start();
        child4.start();
        child5.start();
        baba.start();
        niko.start();
        child6.start();
        child7.start();
        child8.start();
        child9.start();
        child10.start();

        ded.join();
        snegurochka.join();
        santa.join();
        baba.join();
        niko.join();
        child1.join();
        child2.join();
        child3.join();
        child4.join();
        child5.join();
        child6.join();
        child7.join();
        child8.join();
        child9.join();
        child10.join();

        boolean isChilrenLive = ded.isAlive() ||
            snegurochka.isAlive() ||
            santa.isAlive() ||
            baba.isAlive() ||
            niko.isAlive() ||
            child1.isAlive() ||
            child2.isAlive() ||
            child3.isAlive() ||
            child4.isAlive() ||
            child5.isAlive() ||
            child6.isAlive() ||
            child7.isAlive() ||
            child8.isAlive() ||
            child9.isAlive() ||
            child10.isAlive();

        while (isChilrenLive) {}

        System.out.println("\n\n------------------------------------------------ " +
                "\nПерсонажи подарили " + personsGifts + " подарков."
        + "\nДети получили " + childrenGifts + " подарков." +
                "\n------------------------------------------------\n");

        if (sack.size() > 0) {
            System.out.println("В мешке осталось: " + sack);
        } else {
            System.out.println("В мешке ничего не осталось :(");
        }

    }
}

/*  Результат

"C:\Program Files\Java\jdk1.8.0_301\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\lib\idea_rt.jar=64772:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_301\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\rt.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\out\production\JavaHomeWork;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-annotations-2.13.0.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-core-2.13.0.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-databind-2.13.0.jar" com.pb.khantimerov.hw13.NewYearPresents
++ Дед Мороз положил(а) конфеты в мешок :)
++ Баба яга положил(а) жвачка в мешок :)
-- Леша взял(а) конфеты из мешка :)
++ Святой Николай положил(а) шоколадка в мешок :)
++ Баба яга положил(а) жвачка в мешок :)
++ Снегрочка положил(а) печенье в мешок :)
-- Олег взял(а) жвачка из мешка :)
-- Олег взял(а) шоколадка из мешка :)
++ Санта Клаус положил(а) тортик в мешок :)
++ Снегрочка положил(а) печенье в мешок :)
++ Дед Мороз положил(а) конфеты в мешок :)
-- Женя взял(а) жвачка из мешка :)
-- Саша взял(а) печенье из мешка :)
-- Юля взял(а) тортик из мешка :)
++ Санта Клаус положил(а) тортик в мешок :)
-- Леша взял(а) печенье из мешка :)
-- Вовочка взял(а) конфеты из мешка :)
++ Святой Николай положил(а) шоколадка в мешок :)
-- Саша взял(а) тортик из мешка :)
-- Леша взял(а) шоколадка из мешка :)
:( Коля :( Мешок пустой, нет подарков.
:( Филя :( Мешок пустой, нет подарков.
++ Снегрочка положил(а) печенье в мешок :)
-- Петя взял(а) печенье из мешка :)
++ Баба яга положил(а) жвачка в мешок :)
-- Коля взял(а) жвачка из мешка :)
:( Олег :( Мешок пустой, нет подарков.
:( Олег :( Мешок пустой, нет подарков.
++ Санта Клаус положил(а) тортик в мешок :)
-- Саша взял(а) тортик из мешка :)
++ Баба яга положил(а) жвачка в мешок :)
++ Санта Клаус положил(а) тортик в мешок :)
-- Герхард взял(а) жвачка из мешка :)
-- Саша взял(а) тортик из мешка :)
++ Дед Мороз положил(а) конфеты в мешок :)
++ Снегрочка положил(а) печенье в мешок :)
-- Вовочка взял(а) конфеты из мешка :)
++ Санта Клаус положил(а) тортик в мешок :)
++ Святой Николай положил(а) шоколадка в мешок :)
-- Вовочка взял(а) печенье из мешка :)
-- Юля взял(а) тортик из мешка :)
-- Петя взял(а) шоколадка из мешка :)
:( Петя :( Мешок пустой, нет подарков.
++ Баба яга положил(а) жвачка в мешок :)
-- Герхард взял(а) жвачка из мешка :)
:( Леша :( Мешок пустой, нет подарков.
:( Женя :( Мешок пустой, нет подарков.
++ Дед Мороз положил(а) конфеты в мешок :)
++ Снегрочка положил(а) печенье в мешок :)
++ Дед Мороз положил(а) конфеты в мешок :)
++ Санта Клаус положил(а) тортик в мешок :)
-- Коля взял(а) конфеты из мешка :)
-- Саша взял(а) печенье из мешка :)

***** Саша ушел(а), он(а) получил(а) подарки:
[печенье, тортик, тортик, тортик, печенье], всего 5 штук(и) *****

++ Снегрочка положил(а) печенье в мешок :)
-- Леша взял(а) конфеты из мешка :)

***** Леша ушел(а), он(а) получил(а) подарки:
[конфеты, печенье, шоколадка, конфеты], всего 4 штук(и) *****

-- Юля взял(а) тортик из мешка :)
++ Снегрочка положил(а) печенье в мешок :)
++ Святой Николай положил(а) шоколадка в мешок :)
++ Святой Николай положил(а) шоколадка в мешок :)
-- Юля взял(а) печенье из мешка :)
-- Филя взял(а) печенье из мешка :)
++ Санта Клаус положил(а) тортик в мешок :)
-- Олег взял(а) шоколадка из мешка :)

***** Олег ушел(а), он(а) получил(а) подарки:
[жвачка, шоколадка, шоколадка], всего 3 штук(и) *****

++ Баба яга положил(а) жвачка в мешок :)
++ Дед Мороз положил(а) конфеты в мешок :)
++ Снегрочка положил(а) печенье в мешок :)
Санта Клаус:( Мешок полон. Нельзя положить новый подарок :(
Санта Клаус:( Мешок полон. Нельзя положить новый подарок :(
-- Вовочка взял(а) шоколадка из мешка :)
-- Филя взял(а) тортик из мешка :)
-- Герхард взял(а) жвачка из мешка :)
++ Санта Клаус положил(а) тортик в мешок :)

===== Санта Клаус всего положил(а) 8 подарков и ушел(а) =====

-- Петя взял(а) конфеты из мешка :)
++ Баба яга положил(а) жвачка в мешок :)
-- Филя взял(а) печенье из мешка :)
++ Снегрочка положил(а) печенье в мешок :)
++ Святой Николай положил(а) шоколадка в мешок :)
-- Женя взял(а) тортик из мешка :)
++ Баба яга положил(а) жвачка в мешок :)
-- Коля взял(а) жвачка из мешка :)
++ Дед Мороз положил(а) конфеты в мешок :)
-- Филя взял(а) печенье из мешка :)

***** Филя ушел(а), он(а) получил(а) подарки:
[печенье, тортик, печенье, печенье], всего 4 штук(и) *****

++ Баба яга положил(а) жвачка в мешок :)
-- Герхард взял(а) шоколадка из мешка :)
-- Петя взял(а) жвачка из мешка :)

***** Петя ушел(а), он(а) получил(а) подарки:
[печенье, шоколадка, конфеты, жвачка], всего 4 штук(и) *****

++ Снегрочка положил(а) печенье в мешок :)

===== Снегрочка всего положил(а) 10 подарков и ушел(а) =====

-- Юля взял(а) конфеты из мешка :)

***** Юля ушел(а), он(а) получил(а) подарки:
[тортик, тортик, тортик, печенье, конфеты], всего 5 штук(и) *****

-- Герхард взял(а) жвачка из мешка :)

***** Герхард ушел(а), он(а) получил(а) подарки:
[жвачка, жвачка, жвачка, шоколадка, жвачка], всего 5 штук(и) *****

++ Святой Николай положил(а) шоколадка в мешок :)
++ Баба яга положил(а) жвачка в мешок :)

===== Баба яга всего положил(а) 10 подарков и ушел(а) =====

++ Дед Мороз положил(а) конфеты в мешок :)
-- Женя взял(а) печенье из мешка :)
-- Вовочка взял(а) шоколадка из мешка :)

***** Вовочка ушел(а), он(а) получил(а) подарки:
[конфеты, конфеты, печенье, шоколадка, шоколадка], всего 5 штук(и) *****

++ Дед Мороз положил(а) конфеты в мешок :)
-- Коля взял(а) жвачка из мешка :)

***** Коля ушел(а), он(а) получил(а) подарки:
[жвачка, конфеты, жвачка, жвачка], всего 4 штук(и) *****

++ Святой Николай положил(а) шоколадка в мешок :)
++ Святой Николай положил(а) шоколадка в мешок :)
-- Женя взял(а) конфеты из мешка :)

***** Женя ушел(а), он(а) получил(а) подарки:
[жвачка, тортик, печенье, конфеты], всего 4 штук(и) *****

++ Дед Мороз положил(а) конфеты в мешок :)

===== Дед Мороз всего положил(а) 10 подарков и ушел(а) =====

++ Святой Николай положил(а) шоколадка в мешок :)

===== Святой Николай всего положил(а) 10 подарков и ушел(а) =====



------------------------------------------------
Персонажи подарили 48 подарков.
Дети получили 43 подарков.
------------------------------------------------

В мешке осталось: [конфеты, шоколадка, шоколадка, конфеты, шоколадка]

Process finished with exit code 0


 */