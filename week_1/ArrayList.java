package week_1;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;
public class ArrayList {
    public static void main(String args[]){
        List<Integer> nums = Arrays.asList(13,52,23,40,50);
        Stream<Integer> s = nums.stream();
        Stream<Integer> s1 = s.filter( n -> n%2 == 0);
        s1.forEach(a -> System.out.println(a));
    }
}
