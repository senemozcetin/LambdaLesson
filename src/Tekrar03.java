import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tekrar03 {
    public static void main(String[] args) {

            Universite u01 = new Universite("bogazici","matematik",571,93);
            Universite u02 = new Universite("istanbul tk","matematik",600,81);
            Universite u03 = new Universite("istanbul","hukuk",1400,71);
            Universite u04 = new Universite("marmara","bilg muh",1080,77);
            Universite u05 = new Universite("odtu","gemi mh",333,74);

            List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));
    }
    public static void print(int i){
        System.out.print(i+" ");
    }
    public static void print(String str){
        System.out.print(str+" ");
    }
    public static boolean ciftBul(int i){
        return i%2==0;
    }
    //task 01-->butun universitelerin notOrt'larinin 74' den buyuk olup olmadigini kontrol eden pr create ediniz.
    public static void notOrtByk74(List<Universite> unv){
        System.out.println(unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74)
                ? "tum not ort 74'den buyuk"
                : "74'den buyuk olmayan en az bir not ort var");
    }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static void bolumAdiMat(List<Universite> unv){
        System.out.println(unv.
                stream().
                anyMatch(t -> t.getBolum().equalsIgnoreCase("matematik"))
                ? "Mat bolumu varmis"
                : "mat bolumu yokmus");
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayilarinaGoreSirala(List<Universite> unv){
        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                collect(Collectors.toList());
    }
    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static void matBolumSayisi(List<Universite> unv){
        System.out.println(unv.
                stream().
                filter(t -> t.getBolum().equalsIgnoreCase("matematik")).
                count());
    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static void enBykNotOrt(List<Universite> unv){
        System.out.println(unv.
                stream().
                filter(t -> t.getOgrSayisi() > 550).
                map(t -> t.getNotOrt()).
                reduce(Integer::max));
    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static void enKckNotOrt(List<Universite> unv){
        System.out.println(unv.
                stream().
                filter(t -> t.getOgrSayisi()< 1050).
                mapToInt(Universite::getNotOrt).min());
    }

}
