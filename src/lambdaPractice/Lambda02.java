package lambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {

        List<String> list= new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println(ilkHarfBykSirala(list));
        System.out.println();
        System.out.println(ilkHarfiEveColanSirala(list));
        System.out.println();
        basaveSonaYildizEkle(list);
        System.out.println();
        System.out.println(icindeEolanList(list));
        System.out.println();
        lleriSil(list);
        System.out.println();
        ikinciHarfeGoreSiralaChEnBykElPrint(list);

    }

    //S1: list elemanlarini ilk harf buyuk gerisi kucuk sekilde siralayalim

    public static List<String> ilkHarfBykSirala( List<String> list ){
      return   list.stream().
                map(t->t.substring(0,1).toUpperCase()+ t.substring(1).toLowerCase()).
                collect(Collectors.toList());
    }

    //S2: ilk harfi e ve c olanlari listeleyelim
    public static List<String> ilkHarfiEveColanSirala(List<String> list){
       return list.
               stream().
               filter(t->t.toLowerCase().startsWith("e")|| t.toLowerCase().startsWith("c")).
               collect(Collectors.toList());
    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basaveSonaYildizEkle(List<String> list){
        list.
                stream().
                map(t->"*"+t+"*").
                forEach(Utils::yazString);
    }

    //S4: icinde e olanlardan yeni bir list olusturunuz
    public static List<String> icindeEolanList(List<String> list){
     return    list.
             stream().
             filter(t->t.toLowerCase().contains("e")).
             collect(Collectors.toList());
    }
    //S5: tum "l" leri silelim yazdiralim
    public static void lleriSil(List<String> list){
        list.stream().
                map(t->t.replaceAll("l","")).
                forEach(Utils::yazString);
    }

    //S6: list elemanlarini 2.harfe gore siralayip
    // ilk 5 elemandan char sayisi en buyuk elemani print et
    public static void ikinciHarfeGoreSiralaChEnBykElPrint(List<String> list){
        System.out.println(list.
                stream().
                sorted(Comparator.comparing(t -> t.charAt(1))).// list elemanlarini 2.harfe gore siraladim
                limit(5).// bu siralamadan ilk 5 elemani aldim
                sorted(Comparator.comparing(String::length).reversed()).// ilk 5 elemani uzunluklarina gore ters siraladim
                findFirst());//akistan gelen ilk elemani aldim Optional[String]
    }




}
