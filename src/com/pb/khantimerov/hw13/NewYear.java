// решение с Wait() и Notify()

package com.pb.khantimerov.hw13;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NewYear {
    static volatile int childrenGifts_ = 0; // общее кол-во полученных подарков
    static volatile int personsGifts_ = 0; // общее кол-во подаренных подарков

    public static class Sack {
        private final List<String> sack;
        String name;

        public Sack(List<String> sack, String name) {
            this.sack = sack;
            this.name = name;
        }

        public synchronized int get(List<String> gifts) {
            if (sack.size() < 1) {
                System.out.println(":( Пришел " + name + ", а мешок пустой :(");
            }
            while (sack.size() < 1) {
                try {
                    wait(30000);
                }
                catch (InterruptedException e) {
                }
            }
            System.out.println("-- " + name + " забрал из мешка " + sack.get(0) + " :)");
            gifts.add(sack.get(0));
            sack.remove(0);
            notify();
            return 1;
        }

        public synchronized int put(String gift) {
            if (sack.size() > 10) {
                System.out.println(":( Мешок переполнен :) В нем " + sack.size() + " подарков.");
            }
            while (sack.size() > 10) {
                try {
                    wait(30000);
                }
                catch (InterruptedException e) {
                }
            }
            sack.add(gift);
            System.out.println("++ " + name + " положил в мешок " + gift + " :)");
            notify();
            return 1;
        }
    }

    static class Children_ implements Runnable {
        private final List<String> buffer_;
        private final String name_;
        private final List<String> receivedGifts_ = new ArrayList<>();

        public Children_(List<String> buffer_, String name_) {
            this.buffer_ = buffer_;
            this.name_ = name_;
        }
        public String getName() {
            return name_;
        }

        public void run() {
            Sack sack = new Sack(buffer_, name_);
            int i = 0, p = 0;
            while (i < 5) { // ребенок может проверить и получить подарок не больше 5 раз
                try {
                    int seconds = new Random().nextInt(500);
                    Thread.sleep(seconds);
                    p += sack.get(receivedGifts_);
                } catch (InterruptedException e) {
                    e.printStackTrace(); }
                i++;
            }
            System.out.println("\n***** " + name_ + " ушел(а), он(а) получил(а) подарки: \n" + receivedGifts_ +
                    ", всего " + p + " штук(и) *****\n");
            childrenGifts_ += p;
        }
    }

    static class Person_ implements Runnable {
        private final List<String> buffer_;
        private final String present_;

        public Person_(List<String> buffer_, String present_) {
            this.buffer_ = buffer_;
            this.present_ = present_;
        }

        public void run() {
            int i = 0, p = 0;
            String threadName = Thread.currentThread().getName();
            Sack sack = new Sack(buffer_, threadName);

            while (i < 10) { // попытки положить подарок в мешок
                int seconds = new Random().nextInt(300);
                try {
                    Thread.sleep(seconds);
                    p += sack.put(present_);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            System.out.println("\n===== " + threadName + " всего положил(а) " + p + " подарков и ушел(а) =====\n");
            personsGifts_ += p;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        List<String> sack_ = Collections.synchronizedList(new ArrayList<>());

        Thread ded = new Thread(new Person_(sack_, "конфеты"));
        Thread snegurochka = new Thread(new Person_( sack_, "печенье"));
        Thread santa = new Thread(new Person_(sack_, "тортик"));
        Thread baba = new Thread(new Person_(sack_, "жвачка"));
        Thread niko = new Thread(new Person_(sack_, "шоколадка"));
        ded.setName("Дед Мороз");
        snegurochka.setName("Снегрочка");
        santa.setName("Санта Клаус");
        baba.setName("Баба яга");
        niko.setName("Святой Николай");


        Thread child1 = new Thread(new Children_(sack_, "Вовочка"));
        Thread child2 = new Thread(new Children_(sack_, "Петя"));
        Thread child3 = new Thread(new Children_(sack_, "Юля"));
        Thread child4 = new Thread(new Children_(sack_, "Филя"));
        Thread child5 = new Thread(new Children_(sack_, "Женя"));
        Thread child6 = new Thread(new Children_(sack_, "Саша"));
        Thread child7 = new Thread(new Children_(sack_, "Коля"));
        Thread child8 = new Thread(new Children_(sack_, "Герхард"));
        Thread child9 = new Thread(new Children_(sack_, "Олег"));
        Thread child10 = new Thread(new Children_(sack_, "Леша"));


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

//        boolean isChilrenLive = ded.isAlive() ||
//                snegurochka.isAlive() ||
//                santa.isAlive() ||
//                baba.isAlive() ||
//                niko.isAlive() ||
//                child1.isAlive() ||
//                child2.isAlive() ||
//                child3.isAlive() ||
//                child4.isAlive() ||
//                child5.isAlive() ||
//                child6.isAlive() ||
//                child7.isAlive() ||
//                child8.isAlive() ||
//                child9.isAlive() ||
//                child10.isAlive();


        System.out.println("\n\n------------------------------------------------" +
//                             "\n-----Предварительный итог за 30 секунд----------" +
                "\nПерсонажи подарили " + personsGifts_ + " подарков."
                + "\nДети получили " + childrenGifts_ + " подарков." +
                "\n------------------------------------------------\n");
//        if (isChilrenLive) System.out.println("---Раздача подарков продолжается---");

        if (sack_.size() > 0) {
            System.out.println("В мешке осталось: " + sack_ + "\n");
        } else {
            System.out.println("В мешке ничего не осталось :(\n");
        }

        System.out.println("\nВремя выполнения " + (System.currentTimeMillis() - startTime)/1000 + " секунд.");

    }
}

/* Результат

"C:\Program Files\Java\jdk1.8.0_301\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\lib\idea_rt.jar=50285:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_301\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_301\jre\lib\rt.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\out\production\JavaHomeWork;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-annotations-2.13.0.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-core-2.13.0.jar;C:\Users\HP\IdeaProjects\JavaHomeWork\lib\jackson-databind-2.13.0.jar" com.pb.khantimerov.hw13.NewYear

:( Пришел Олег, а мешок пустой :(
++ Санта Клаус положил в мешок тортик :)
-- Олег забрал из мешка тортик :)
++ Дед Мороз положил в мешок конфеты :)
-- Вовочка забрал из мешка конфеты :)
++ Дед Мороз положил в мешок конфеты :)
++ Святой Николай положил в мешок шоколадка :)
++ Снегрочка положил в мешок печенье :)
++ Санта Клаус положил в мешок тортик :)
++ Снегрочка положил в мешок печенье :)
++ Санта Клаус положил в мешок тортик :)
++ Баба яга положил в мешок жвачка :)
++ Дед Мороз положил в мешок конфеты :)
++ Баба яга положил в мешок жвачка :)
-- Герхард забрал из мешка конфеты :)
-- Леша забрал из мешка шоколадка :)
++ Санта Клаус положил в мешок тортик :)
++ Снегрочка положил в мешок печенье :)
-- Коля забрал из мешка печенье :)
-- Филя забрал из мешка тортик :)
++ Святой Николай положил в мешок шоколадка :)
-- Саша забрал из мешка печенье :)
++ Баба яга положил в мешок жвачка :)
++ Санта Клаус положил в мешок тортик :)
-- Олег забрал из мешка тортик :)
++ Дед Мороз положил в мешок конфеты :)
-- Женя забрал из мешка жвачка :)
-- Юля забрал из мешка конфеты :)
-- Олег забрал из мешка жвачка :)
-- Петя забрал из мешка тортик :)
-- Олег забрал из мешка печенье :)
++ Дед Мороз положил в мешок конфеты :)
++ Снегрочка положил в мешок печенье :)
-- Петя забрал из мешка шоколадка :)
++ Святой Николай положил в мешок шоколадка :)
++ Дед Мороз положил в мешок конфеты :)
++ Баба яга положил в мешок жвачка :)
++ Санта Клаус положил в мешок тортик :)
-- Вовочка забрал из мешка жвачка :)
-- Саша забрал из мешка тортик :)
-- Герхард забрал из мешка конфеты :)
-- Вовочка забрал из мешка конфеты :)
-- Коля забрал из мешка печенье :)
++ Санта Клаус положил в мешок тортик :)
-- Филя забрал из мешка шоколадка :)
-- Вовочка забрал из мешка конфеты :)
-- Петя забрал из мешка жвачка :)
++ Баба яга положил в мешок жвачка :)
-- Юля забрал из мешка тортик :)
-- Леша забрал из мешка тортик :)
++ Святой Николай положил в мешок шоколадка :)
-- Леша забрал из мешка жвачка :)
++ Снегрочка положил в мешок печенье :)
++ Дед Мороз положил в мешок конфеты :)
++ Баба яга положил в мешок жвачка :)
-- Герхард забрал из мешка шоколадка :)
-- Коля забрал из мешка печенье :)
-- Коля забрал из мешка конфеты :)
-- Саша забрал из мешка жвачка :)
++ Снегрочка положил в мешок печенье :)
-- Герхард забрал из мешка печенье :)
:( Пришел Олег, а мешок пустой :(
++ Санта Клаус положил в мешок тортик :)
-- Женя забрал из мешка тортик :)
:( Пришел Петя, а мешок пустой :(
:( Пришел Герхард, а мешок пустой :(
++ Санта Клаус положил в мешок тортик :)
++ Баба яга положил в мешок жвачка :)
++ Дед Мороз положил в мешок конфеты :)
++ Дед Мороз положил в мешок конфеты :)
-- Женя забрал из мешка тортик :)
++ Святой Николай положил в мешок шоколадка :)
-- Юля забрал из мешка жвачка :)
-- Филя забрал из мешка конфеты :)
-- Женя забрал из мешка конфеты :)
++ Снегрочка положил в мешок печенье :)
++ Дед Мороз положил в мешок конфеты :)

===== Дед Мороз всего положил(а) 10 подарков и ушел(а) =====

-- Женя забрал из мешка шоколадка :)

***** Женя ушел(а), он(а) получил(а) подарки:
[жвачка, тортик, тортик, конфеты, шоколадка], всего 5 штук(и) *****

-- Вовочка забрал из мешка печенье :)

***** Вовочка ушел(а), он(а) получил(а) подарки:
[конфеты, жвачка, конфеты, конфеты, печенье], всего 5 штук(и) *****

-- Леша забрал из мешка конфеты :)
++ Баба яга положил в мешок жвачка :)
++ Санта Клаус положил в мешок тортик :)

===== Санта Клаус всего положил(а) 10 подарков и ушел(а) =====

++ Святой Николай положил в мешок шоколадка :)
-- Коля забрал из мешка жвачка :)
-- Саша забрал из мешка жвачка :)

***** Коля ушел(а), он(а) получил(а) подарки:
[печенье, печенье, печенье, конфеты, жвачка], всего 5 штук(и) *****

++ Святой Николай положил в мешок шоколадка :)
-- Юля забрал из мешка шоколадка :)
++ Снегрочка положил в мешок печенье :)
++ Баба яга положил в мешок жвачка :)
-- Леша забрал из мешка шоколадка :)

***** Леша ушел(а), он(а) получил(а) подарки:
[шоколадка, тортик, жвачка, конфеты, шоколадка], всего 5 штук(и) *****

-- Саша забрал из мешка печенье :)

***** Саша ушел(а), он(а) получил(а) подарки:
[печенье, тортик, жвачка, тортик, печенье], всего 5 штук(и) *****

-- Филя забрал из мешка жвачка :)
++ Снегрочка положил в мешок печенье :)
-- Юля забрал из мешка печенье :)

***** Юля ушел(а), он(а) получил(а) подарки:
[конфеты, тортик, жвачка, шоколадка, печенье], всего 5 штук(и) *****

++ Святой Николай положил в мешок шоколадка :)
++ Баба яга положил в мешок жвачка :)

===== Баба яга всего положил(а) 10 подарков и ушел(а) =====

++ Святой Николай положил в мешок шоколадка :)
-- Филя забрал из мешка шоколадка :)

***** Филя ушел(а), он(а) получил(а) подарки:
[тортик, шоколадка, конфеты, жвачка, шоколадка], всего 5 штук(и) *****

++ Снегрочка положил в мешок печенье :)

===== Снегрочка всего положил(а) 10 подарков и ушел(а) =====

++ Святой Николай положил в мешок шоколадка :)

===== Святой Николай всего положил(а) 10 подарков и ушел(а) =====

-- Олег забрал из мешка жвачка :)

***** Олег ушел(а), он(а) получил(а) подарки:
[тортик, тортик, жвачка, печенье, жвачка], всего 5 штук(и) *****

-- Петя забрал из мешка шоколадка :)
-- Герхард забрал из мешка печенье :)

***** Герхард ушел(а), он(а) получил(а) подарки:
[конфеты, конфеты, шоколадка, печенье, печенье], всего 5 штук(и) *****

-- Петя забрал из мешка шоколадка :)

***** Петя ушел(а), он(а) получил(а) подарки:
[тортик, шоколадка, жвачка, шоколадка, шоколадка], всего 5 штук(и) *****



------------------------------------------------
Персонажи подарили 50 подарков.
Дети получили 50 подарков.
------------------------------------------------

В мешке ничего не осталось :(


Время выполнения 61 секунд.


Process finished with exit code 0

 */