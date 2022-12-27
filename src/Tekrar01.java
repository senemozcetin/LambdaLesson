import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Tekrar01 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        //tek tek eleman eklemek yerine aslist yaptik. fakat bu sekilde eleman ekleme cikarma yapamam

//        printListStructural(sayi);
//        printListFunctional2(sayi);
//        printListFunctional3(sayi);
//        printListFunctional4(sayi);
//        printListFunctional5(sayi);
//        printListFunctional6(sayi);
//        printListFunctional7(sayi);
//        printListFunctional8(sayi);
//        printListFunctional9(sayi);
        elemanlariCarp(sayi);
    }
    public static void printListStructural(List<Integer>list){
        for (Integer w:list){
            System.out.println(w+ " ");
        }
    }
    public static void printListFunctional(List<Integer>list){
        list.stream().forEach(t-> System.out.print(t+" "));
    }
    public static void print(int i){
        System.out.print(i+" ");
    }
    public static void printListFunctional2(List<Integer>list){
        list.stream().filter(t->t%2==0).forEach(Tekrar01::print);
    }
    public static boolean ciftBul(int i){
        return i%2==0;
    }
    public static void printListFunctional3(List<Integer>list){
        list.
                stream().
                filter(Tekrar01::ciftBul).
                forEach(Tekrar01::print);
    }
    public static void printListFunctional4(List<Integer>list){
        list.
                stream().
                filter(Tekrar01::ciftBul).
                filter(t->t<34).
                forEach(Tekrar01::print);
    }
    public static void printListFunctional5(List<Integer>list){
        list.
                stream().
                filter(t->t%2==0 || t>34).
                forEach(Tekrar01::print);
    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz
    public static void printListFunctional6(List<Integer>list){
        list.
                stream().
                filter(Tekrar01::ciftBul).
                map(t->t*t).
                forEach(Tekrar01::print);
    }

    // Task 2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print ediniz

    public static void printListFunctional7(List<Integer>list){
        list.stream().filter(t->t%2!=0).map(t->t*t*t +1).forEach(Tekrar01::print);
    }
    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printListFunctional8(List<Integer>list){
        list.stream().filter(Tekrar01::ciftBul).map(Math::sqrt).forEach(t-> System.out.println(t+" "));
    }
    // Task-4: list in en buyuk elemanini yazdiriniz
    public static void printListFunctional9(List<Integer>list){
        Optional<Integer>maxSayi=  list.
                stream().
                reduce(Math::max);
        System.out.println(maxSayi);
    }
    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void printListFunctional10(List<Integer>list){
        System.out.println(list.
                stream().
                filter(Tekrar01::ciftBul).
                map(t -> t * t).
                reduce(Math::max));
    }
    // List'teki tum elemanlarin toplamini yazdiriniz
    public static void elemanlariTopla(List<Integer>list){
        int toplam= list.
                stream().
                //reduce(Integer::sum)
        reduce(0,(x,y)->x+y);
        System.out.println(toplam);
    }
    //Task-7: List teki cift elemanlarin carpimini yazdiriniz

    public static void elemanlariCarp(List<Integer>list){
        System.out.println(list.stream().filter(Tekrar01::ciftBul).reduce(Math::multiplyExact));
    }
}
