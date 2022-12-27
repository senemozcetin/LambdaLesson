package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tekrar02 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec",
                "küşleme","arabAşı","waffle","künefe"));
        alfabetikTekrarsizYzdr(menu);

    }
    public static void print(String str){
        System.out.print(str+" ");
    }
    public static void print(int i){
        System.out.print(i+" ");
    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikTekrarsizYzdr( List<String> list){
        list.
                stream().
                sorted().
                map(String::toUpperCase).
                distinct().
                forEach(Tekrar02::print);
    }
    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void tersSiralaTekrarsiz(List<String> list){
        list.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Tekrar02::print);
    }

    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..
    public static void charSayisinaGoreKcktnByge(List<String> list){
        list.stream().sorted(Comparator.comparing(String::length)).forEach(Tekrar02::print);
    }

    // Task-4 : List elemanlarinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void karktrSysYedidenAz(List<String> list){
        System.out.println(list.stream().
                allMatch(t -> t.length() <= 7)
                ? "Elemanin karakter sayisi 7'den kucuk"
                : "Elemanin karakter sayisi 7'den buyuk");
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayan(List<String> list){
        System.out.println(list.
                stream().
                noneMatch(t -> t.startsWith("w"))
                ? "W ile baslamiyoor"
                : "W ile basliyoor");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenEl(List<String> list){
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x"))
                ? "x ile bitiyooor"
                : "x ile bitmiyorr");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiEnBykEl(List<String> list){
        System.out.println(list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                limit(1));
    }
}
