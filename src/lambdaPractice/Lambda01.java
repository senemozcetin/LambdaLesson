package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        hepsiniYazdir(list);
        System.out.println("\n========");
        negatifleriYazdir(list);
        System.out.println("\n========");
        pozitifYazdir(list);
        System.out.println("\n========");
        pozitifVeCiftOlanlariYazdir(list);
        System.out.println("\n========");
        pozitifVeyaCiftOlanlariYazdir(list);
        System.out.println("\n========");
        elemanlarinKareleriniYazdir(list);
        System.out.println("\n========");
        ciftElemanlarinKupleriniAyniSatirdaBirBoslukBirakarakYazdir(list);
        System.out.println("\n========");
        elemlarinKarelerindenTekrarsizOlanlariBirBoslukBirakarakAyniSatiraYazdir(list);
        System.out.println("\n========");
        kucuktenBuyugeSirala(list);
        System.out.println("\n========");
        buyuktenKucugeSirala(list);
        System.out.println("\n========");
        System.out.println(pozKup5List(list));
        System.out.println("========");
        pozKup5List2(list);
        System.out.println("========");
        System.out.println(pozKareSon5DegilList(list));
        System.out.println("========");
        System.out.println(toplamiYazdir1(list));
        System.out.println(toplamiYazdir2(list));
        System.out.println(toplamiYazdir3(list));
        toplamiYazdir4(list);
        System.out.println("========");
        pozElTop(list);


    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz
    public static void hepsiniYazdir(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));
    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifleriYazdir(List<Integer> list) {
        list.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));
    }

    //S3: pozitif olanlardan yeni bir liste olustur
    public static void pozitifYazdir(List<Integer> list) {
        list.stream().filter(t -> t > 0).forEach(t -> System.out.print(t + " "));
    }

    //S4:pozitif ve çift olanları yazdırın
    public static void pozitifVeCiftOlanlariYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));
    }

    //S5:pozitif veya çift olanları yazdırın
    public static void pozitifVeyaCiftOlanlariYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0 || t > 0).forEach(t -> System.out.print(t + " "));
    }

    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    //map():stream den gelen elemanları baska tıplere donusturmek veya uzerlerınde
    //ıslem yapmak ıcın (update) kullanılır
    public static void elemanlarinKareleriniYazdir(List<Integer> list) {
        list.stream().map(t -> t * t).forEach(t -> System.out.print(t + " "));
    }

    //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
    public static void ciftElemanlarinKupleriniAyniSatirdaBirBoslukBirakarakYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }


    //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
    // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
    // Sıralı akışlar için, farklı elemanın seçimi sabittir
    // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım
    public static void elemlarinKarelerindenTekrarsizOlanlariBirBoslukBirakarakAyniSatiraYazdir(List<Integer> list) {
        list.stream().map(t -> t * t).distinct().forEach(t -> System.out.print(t + " "));
    }

    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void kucuktenBuyugeSirala(List<Integer> list) {
        list.stream().sorted().forEach(t -> System.out.print(t + " "));
    }

    //S10: listin elemanlarini buyukten kucuge siralayalim
    //sorted(Comparator.reverseOrder()) ==> Doğal sıralamanın tersini uygulayan bir karşılaştırıcı
    public static void buyuktenKucugeSirala(List<Integer> list) {
        list.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    //Collect metodu Stream türündeki nesneleri başka biçimdeki nesneye, veri yapısına dönüştürmek için kullanılır.
    //.collect(Collectors.toList()); akıştan gelen elemanları yeni bir listenin içerisine yerleştirir.
    // collect(Collectors.toList()) terminal methoddur bu yuzden foreach.sout kullanilmaz
    public static List<Integer> pozKup5List(List<Integer> list) {
        List<Integer> newList = list.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());
        return newList;
    }

    public static void pozKup5List2(List<Integer> l) {
        List<Integer> list = l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());
        System.out.println(list);
    }

    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKareSon5DegilList(List<Integer> list) {
        List<Integer> a = list.stream().filter(t -> t > 0).map(t -> t * t).filter(t -> t % 10 != 5).collect(Collectors.toList());
        return a;
    }

    // S13 :list elemanlarini toplamini bulalim
    /*
    reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
    kullanımı yaygındır pratiktir.
    Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
    bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
    reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
    reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
    İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
    */
    public static int toplamiYazdir1(List<Integer> list) {
        int i = list.stream().reduce(0, (a, b) -> a + b);//1.Yol
        return i;
    }

    public static int toplamiYazdir2(List<Integer> list) {
        int i = list.stream().reduce(0, Math::addExact);//2.Yol
        return i;
    }

    public static int toplamiYazdir3(List<Integer> list) {
        int i = list.stream().reduce(0, Integer::sum);//2.Yol
        return i;
    }

    public static void toplamiYazdir4(List<Integer> list) {
        System.out.println(list.stream().reduce(Integer::sum));
    }
    //s14: listin pozitif elemanlari toplamini bulalim
    public static void pozElTop(List<Integer>l){
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));
    }


}