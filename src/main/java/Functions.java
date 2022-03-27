import java.time.temporal.ChronoField;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functions {

    public static List<String> isSentenceRight(List<String> arrayList){ // the sentence is correct
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

    public static List<Integer> sortByBiggestAbsoluteValue(List<Integer> arrayList){
        Comparator<Integer> comparator = (left, right) ->
                Math.abs(left) - Math.abs(right);
        return arrayList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public static List<List<String>> sortByName(List<List<String>> arrayList){//lexicographic sorting of names by first name and
        //after this second
        Comparator<List<String>> comparator = (left, right) ->
        {
            for (int i = 0; i < left.get(0).length() && i < right.get(0).length(); i++){
                if (left.get(0).charAt(i) > right.get(0).charAt(i)){
                    return 1;
                }
                else if(left.get(0).charAt(i) < right.get(0).charAt(i)){
                    return -1;
                }
            }
            if (left.get(0).length() > right.get(0).length()){
                return -1;
            }
            else if(left.get(0).length() < right.get(0).length()){
                return 1;
            }
            for (int i = 0; i < left.get(1).length() && i < right.get(1).length(); i++){
                if (left.get(1).charAt(i) > right.get(1).charAt(i)){
                    return 1;
                }
                else if(left.get(1).charAt(i) < right.get(1).charAt(i)){
                    return -1;
                }
            }
            if (left.get(1).length() > right.get(1).length()){
                return -1;
            }
            else if(left.get(1).length() < right.get(1).length()){
                return 1;
            }
            return 0;
        };
        return arrayList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }


    public static Double getAverage(List<Double> array){
        return array
                .stream()
                .reduce((first, second) -> first + second)
                .get()
                /array.size();
    }

    public static List<String> toUpperString(List<String> array){
        return array
                .stream()
                .map((str) -> str.toUpperCase())
                .collect(Collectors.toList());

    }

    public static List<String> toLowerString(List<String> array){
        return array
                .stream()
                .map((str) -> str.toLowerCase())
                .collect(Collectors.toList());
    }

    public static List<String> allStringsStartingWithCharacter(List<String> array, Character character){
        //return array with all Strings starting with character
        Predicate<String> func = (str) -> Character.toString(str.charAt(0)).toUpperCase().
                equals(Character.toString(character).toUpperCase());
        return array
                .stream()
                .filter(func)
                .collect(Collectors.toList());
    }

    public static Integer sumOfAllEven(List<Integer> array){
        List<Integer> listOfEven = array
                .stream()
                .filter(integer -> (integer%2==0))
                .collect(Collectors.toList());
        if (array.size() == 0){
            return 0;
        }
        else{
            return listOfEven
                    .stream()
                    .reduce(Integer::sum)
                    .get();
        }
    }

    public static Integer sumOfAllOdd(List<Integer> array){
        List<Integer> listOfOdd = array
                .stream()
                .filter(integer -> (integer%2==1))
                .collect(Collectors.toList());
        if (array.size() == 0){
            return 0;
        }
        else{
            return listOfOdd
                    .stream()
                    .reduce(Integer::sum)
                    .get();
        }
    }

    public static  List<Integer> forEveryUniqueMakeSquare(List<Integer> ints){
        return ints.stream()
                .filter(n -> Collections.frequency(ints, n) == 1)
                .map(n -> n*n)
                .collect(Collectors.toList());
    }

    public static  List<Integer> returnAllMoreThanNumber(List<Integer> array, Integer number){
         return array.stream()
                 .filter(n -> n>number )
                 .collect(Collectors.toList());
    }
    public static List<Integer> returnAllLessThanNumber(List<Integer> array, Integer number){
        return array.stream()
                .filter(n -> n<number)
                .collect(Collectors.toList());
    }
    public static List<Integer> returnAllInRange(List<Integer> array, Integer min, Integer max){
        return returnAllMoreThanNumber(returnAllLessThanNumber(array, max), min);
    }

    public static List<Integer> randomEven(int count){
        return Stream.
                generate(new Random()::nextInt)
                .filter((number) -> number%2 == 0)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static List<Integer> randomOdd(int count){
        return Stream.
                generate(new Random()::nextInt)
                .filter((number) -> number%2 == 1)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static List<Integer> listOfBiggest(List<Integer> array, int count){
        return array
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(count)
                .collect(Collectors.toList());
    }

    public static Map<Character, String> getWordsByCharacter(List<String> array){ // get Map <first letter of word,
        // words starting with this letter divides by whitespaces>
        return array
                .stream()
                .collect(Collectors.toMap(key -> Character.toString(key.charAt(0)).
                        toLowerCase().charAt(0), value -> value, (first,second) -> first+ " " + second));
    }

    public static  Map<String,Integer> getCountOfWords(List<String> words){
        //return Map<Word, count of his repeating>
        return words
                .stream()
                .collect(Collectors.toMap(key -> key, value -> 1, (first, second) -> first + 1 ));
    }
}
