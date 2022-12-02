import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaCalisma {
    public static void main(String[] args) {
        /*
                            <========= No Test Today ==========>
        WARM UP (10 Minutes)
        1) Create a package name it as "LambdaPractice"
        2) Create a class name it as "P01"
        3) Create a String list which has 5 String elements.
        4) 3 of them will start with the letter "A"// 3 tanesi buyuk A ile baslayacak
        5) If the elements are starting with the letter "A" and the length of the elements //eger elementler buyuk A ile basliyorsa ve
           is less than 5, print them in upper case in a list on the console.//elementlerin uzunlugu 5ten az ise buyuk harfe cevir
   */
        List<String> list = new ArrayList<>();
        list.add("Angie");
        list.add("Andy");
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");

        System.out.println(list.stream()
                .filter(t -> t.startsWith("A"))
                .filter(t -> t.length() < 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));
    }
}
