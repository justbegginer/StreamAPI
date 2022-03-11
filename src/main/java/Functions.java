import java.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Functions {

    public static List<String> isSentenceRight(ArrayList<String> arrayList){ // the sentence is correct
        // if his first chart is capital, and ends on . ! ?
        Predicate<String> predicate = (str) ->
        {
            return (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z' &&
                    (str.charAt(str.length()-1) == '.' || str.charAt(str.length()-1) == '!' ||
                            str.charAt(str.length()-1) == '?'));
        };
        return arrayList
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static List<Integer> sortByBiggestAbsoluteValue(ArrayList<Integer> arrayList){
        Comparator<Integer> comparator = (left, right) ->
        {
            return Math.abs(right) - Math.abs(left);
        };
        return arrayList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
