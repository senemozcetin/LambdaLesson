import java.util.stream.IntStream;

public class Tekrar04 {
    public static void main(String[] args) {

        topla(10);
        ciftTopla(20);
        ilkXTop(5);
        ilkXTopTek(5);
        kuvvetiYazdir(3,5);
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
    // tamsayilari toplayan bir program create ediniz.
    public static void topla(int x) {
        System.out.println(IntStream.range(1, x + 1).sum());
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static void ciftTopla(int x) {
        System.out.println(IntStream.range(2, x + 1).filter(Tekrar01::ciftBul).sum());
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static void ilkXTop(int x) {
        System.out.println(IntStream.iterate(2, t -> t + 2).limit(x).sum());
    }

    //TASK 04 --> Ilk x pozitif tek sayiyi toplayan program  create ediniz.
    public static void ilkXTopTek(int x) {
        System.out.println(IntStream.iterate(1, t -> t + 2).limit(x).sum());
    }
    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void kuvvetTop(int x){
        IntStream.iterate(2,t->t*2).limit(x).forEach(Tekrar01::print);
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void kuvvetiYazdir(int x, int y){
        IntStream.iterate(y,t->t*y).limit(x).forEach(Tekrar01::print);
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz
    public static void faktoriyelYazdir(int x){
        System.out.println(IntStream.range(1, x + 1).reduce(Math::multiplyExact));

    }

}
