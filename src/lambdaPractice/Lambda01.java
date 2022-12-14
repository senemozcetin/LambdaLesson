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

    //S4:pozitif ve ??ift olanlar?? yazd??r??n
    public static void pozitifVeCiftOlanlariYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));
    }

    //S5:pozitif veya ??ift olanlar?? yazd??r??n
    public static void pozitifVeyaCiftOlanlariYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0 || t > 0).forEach(t -> System.out.print(t + " "));
    }

    // S6: list in elemanlarin karelerini ayn?? sat??rda b??r bosluklu yazd??ral??m
    //map():stream den gelen elemanlar?? baska t??plere donusturmek veya uzerler??nde
    //??slem yapmak ??c??n (update) kullan??l??r
    public static void elemanlarinKareleriniYazdir(List<Integer> list) {
        list.stream().map(t -> t * t).forEach(t -> System.out.print(t + " "));
    }

    //S7: Listin cift elemanlar??n??n kuplerini  ayn?? sat??rda b??r bosluklu yazd??ral??m
    public static void ciftElemanlarinKupleriniAyniSatirdaBirBoslukBirakarakYazdir(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }


    //distinct() => Bu method tekrarl?? elemanlar?? sadece bir kere ak??sa sokar.
    // Bu ak??????n farkl?? elemanlar??ndan (Object.equals (Object) 'e g??re) olu??an bir ak???? d??nd??r??r.
    // S??ral?? ak????lar i??in, farkl?? eleman??n se??imi sabittir
    // (yinelenen ????eler i??in, kar????la??ma s??ras??nda ilk g??r??nen ????e korunur.)
    // S??ras??z ak????lar i??in, herhangi bir kararl??l??k garantisi verilmez. Stream return eder.

    //S8 : list in elemanlarin karelerinden tekrarsiz yazd??ral??m
    public static void elemlarinKarelerindenTekrarsizOlanlariBirBoslukBirakarakAyniSatiraYazdir(List<Integer> list) {
        list.stream().map(t -> t * t).distinct().forEach(t -> System.out.print(t + " "));
    }

    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void kucuktenBuyugeSirala(List<Integer> list) {
        list.stream().sorted().forEach(t -> System.out.print(t + " "));
    }

    //S10: listin elemanlarini buyukten kucuge siralayalim
    //sorted(Comparator.reverseOrder()) ==> Do??al s??ralaman??n tersini uygulayan bir kar????la??t??r??c??
    public static void buyuktenKucugeSirala(List<Integer> list) {
        list.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    //Collect metodu Stream t??r??ndeki nesneleri ba??ka bi??imdeki nesneye, veri yap??s??na d??n????t??rmek i??in kullan??l??r.
    //.collect(Collectors.toList()); ak????tan gelen elemanlar?? yeni bir listenin i??erisine yerle??tirir.
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
    kullan??m?? yayg??nd??r pratiktir.
    Bir Stream i??erisindeki verilerin teker teker i??lenmesidir. Teker teker i??leme s??recinde, bir ??nceki ad??mda elde edilen sonu??
    bir sonraki ad??ma girdi olarak sunulmaktad??r. Bu sayede y??????lml?? bir hesaplama s??reci elde edilmi?? olmaktad??r.
    reduce metodu ilk parametrede identity de??eri, ikinci parametrede ise BinaryOperator t??r??nden bir obj kullan??l??r.
    reduce i??leminde bir ??nceki hesaplanm???? de??er ile s??radaki de??er bir i??leme tabi tutulmaktad??r.
    ????leme ba??larken bir ??nceki de??er olmad?????? i??in bu de??er identity parametresinde tan??mlanmaktad??r.
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