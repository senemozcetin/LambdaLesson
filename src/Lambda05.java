import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(toplaCift(4));
        System.out.println(toplaIlkxCift(4));
        System.out.println(toplaIlkxTek(3));
        ikininIlkxKuvvetPrint(3);
        System.out.println();
        istenenSayiIlkxKuvvetPrint(3,2);
        System.out.println();
        System.out.println(istenenSayininFaktoriyeli(5));

    }

        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
        // tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x) {
        int toplam =0;
        for(int i=0 ; i<=x ; i++ ) {
            toplam = toplam + i ;
        }
        return toplam;
    }

    // Functional
    public static int toplaCincix(int x) {  // List<Integer> x ---> x.stream().
        return IntStream. // int değerlerde bir akış sağlar
                range(1,x+1). // range(a,b) --> a dan b'ye kadar ( b dahil değil) int değerler akısa alındı
                sum();// akışdan gelen değerler toplandı
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1,x).
                filter(Lambda01::ciftBul).
                sum();
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaCiftIlk(int x){

        return IntStream.
                rangeClosed(1,x*2).
                filter(Lambda01::ciftBul).
                sum();
    }

    public static int toplaIlkxCift(int x){
      return   IntStream.
              iterate(2,t->t+2).//2 den sonsuza kadar elemanlari 2 artirarak akisa alir --> 2,4,6,8
              limit(x).// x ile sinirliyorum/ ilk x degeri bize getirir
              sum();// akistan gelen degerleri topluyorum
    }
    //TASK 04 --> Ilk x pozitif tek sayiyi toplayan program  create ediniz.
    public static int toplaIlkxTek(int x){
        return IntStream.
                iterate(1,t->t+2). //1den basla 2 artir yani tek sayilari aldik. 1,3,5,7,9......
                limit(x). //sonsuza kadar giden iterate i limit ile sinirlandirdik durdurduk
                sum();  //akistan gelen butun tek sayilari topladik
    }
    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkxKuvvetPrint(int x){   // 2,4,8,16,32
        IntStream.
                iterate(2,t->t*2). //iterasyon(yineleme) icin sartimizi yazdik
                limit(x).  // x degeri ile sinirladik
                forEach(Lambda01::yazdir);// Lambda01 den yazdir methoduyla ekrana yazdirdik
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenenSayiIlkxKuvvetPrint(int istenenSayi, int x){
        IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz
    public static int istenenSayininFaktoriyeli(int x){
      return   IntStream. //int akis basladi
              rangeClosed(1,x). // rangeClosed(1,5) -->1,2,3,4,5
              reduce(1,(t,u)->t*u);
    }
}