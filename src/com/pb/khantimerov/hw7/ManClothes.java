package com.pb.khantimerov.hw7;
/**
 * интерфейсы
 * - ManClothes (мужская одежда) c методом dressMan (одеть мужчину)
 * - WomenClothes (женская оджеда) с методом dressWomen (одеть женщину).
 * Эти методы не принимают параметров, а только выводят информацию
 * о одежде (название, размер, цену, цвет).
 */

public interface ManClothes {
    default void dressMan () {
        System.out.println("Информация о мужской одежде:");
    }
}
