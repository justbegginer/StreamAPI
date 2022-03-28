import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//import java.*;
import java.util.*;
import java.util.stream.Collectors;

class FunctionsTest {

    @Test
    void isSentenceRight() {
        ArrayList<String> sentences = new ArrayList<>(5);
        sentences.add("Hello");
        sentences.add("hello.");
        sentences.add("Hello world.");
        sentences.add("Hello world!");
        sentences.add("Hello world?");
        List<String> results = Functions.isSentenceRight(sentences);
        Assertions.assertEquals(results.get(0), "Hello world.");
        Assertions.assertEquals(results.get(1), "Hello world!");
        Assertions.assertEquals(results.get(2), "Hello world?");
    }

    @Test
    void sortByBiggestAbsoluteValue() {
        List<Integer> initialList = new ArrayList<>(7);
        initialList.add(-1032);
        initialList.add(0);
        initialList.add(100);
        initialList.add(-100);
        initialList.add(-1);
        initialList.add(-3);
        initialList.add(2);
        List<Integer> controlList = new ArrayList<>(7);
        controlList.add(0);
        controlList.add(-1);
        controlList.add(2);
        controlList.add(-3);
        controlList.add(100);
        controlList.add(-100);
        controlList.add(-1032);
        List<Integer> resultList = Functions.sortByBiggestAbsoluteValue(initialList);
        assertEquals(resultList, controlList);
    }

    @Test
    void sortByName() {
        List<List<String>> namesList = new ArrayList<>(4);
        List<String> currentName = new ArrayList<>(2);
        currentName.add("John");
        currentName.add("Snow");
        namesList.add(currentName);
        currentName = new ArrayList<>(2);
        currentName.add("Dean");
        currentName.add("Winchester");
        namesList.add(currentName);
        currentName = new ArrayList<>(2);
        currentName.add("John");
        currentName.add("Doe");
        namesList.add(currentName);
        currentName = new ArrayList<>(2);
        currentName.add("Dean");
        currentName.add("Winchesters");
        namesList.add(currentName);
        currentName = new ArrayList<>(2);
        currentName.add("Dean");
        currentName.add("Winchester");
        namesList.add(currentName);
        List<List<String>> resultList = Functions.sortByName(namesList);
        assertEquals(resultList.get(0).get(0), "Dean");
        assertEquals(resultList.get(0).get(1), "Winchesters");
        assertEquals(resultList.get(1).get(0), "Dean");
        assertEquals(resultList.get(1).get(1), "Winchester");
        assertEquals(resultList.get(2).get(0), "Dean");
        assertEquals(resultList.get(2).get(1), "Winchester");
        assertEquals(resultList.get(3).get(0), "John");
        assertEquals(resultList.get(3).get(1), "Doe");
        assertEquals(resultList.get(4).get(0), "John");
        assertEquals(resultList.get(4).get(1), "Snow");
    }

    @Test
    void getAverage(){
        List<Double> array = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            array.add((double) i);
        }
        assertEquals(Functions.getAverage(array), 5.5);
        for (int i = 11; i <= 100; i++) {
            array.add((double) i);
        }
        assertEquals(Functions.getAverage(array), 50.5);
        array = new ArrayList<>();
        assertEquals(Functions.getAverage(array), 0);
    }

    @Test
    void toUpperString(){
        List<String> list = new ArrayList<>(5);
        list.add("dere");
        list.add("soft");
        list.add("skills");
        list.add("rules");
        List<String> upper = Functions.toUpperString(list);
        assertEquals("DERE", upper.get(0));
        assertEquals("SOFT", upper.get(1));
        assertEquals("SKILLS", upper.get(2));
        assertEquals("RULES", upper.get(3));
    }

    @Test
    void toLowerString(){
        List<String> list = new ArrayList<>(5);
        list.add("DERE");
        list.add("SOFT");
        list.add("SKILLS");
        list.add("RULES");
        List<String> upper = Functions.toLowerString(list);
        assertEquals("dere", upper.get(0));
        assertEquals("soft", upper.get(1));
        assertEquals("skills", upper.get(2));
        assertEquals("rules", upper.get(3));
    }

    @Test
    void allStringsStartingWithCharacter(){
        List<String> list = new ArrayList<>(6);
        list.add("DERE");
        list.add("SOFT");
        list.add("SKILLS");
        list.add("RULES");
        list.add("soft");
        list.add("skills");
        list = Functions.allStringsStartingWithCharacter(list, 's');
        assertEquals(list.get(0), "SOFT");
        assertEquals(list.get(1), "SKILLS");
        assertEquals(list.get(2), "soft");
        assertEquals(list.get(3), "skills");
    }

    @Test
    void sumOfAllEvenAndOdd(){
        List<Integer> list = new ArrayList<>(7);
        list.add(34);
        list.add(99);
        list.add(100);
        list.add(3);
        list.add(11);
        list.add(1000);
        list.add(66);
        assertEquals(Functions.sumOfAllEven(list), 1200);
        assertEquals(Functions.sumOfAllOdd(list), 113);
        list = new ArrayList<>();
        assertEquals(Functions.sumOfAllOdd(list), 0);
        assertEquals(Functions.sumOfAllEven(list), 0);
    }

    @Test
    void forEveryUniqueMakeSquare(){
        List<Integer> list = Arrays.asList(1 , 2, 3, 3, 4, 5, 6, 5, 6, 7, 8, 9, 10);
        List<Integer> controlList = Arrays.asList(1, 4, 16, 49, 64, 81, 100);
        list = Functions.forEveryUniqueMakeSquare(list);
        assertEquals(list, controlList);
    }

    @Test
    void returnAllMoreThanNumber(){
        List<Integer> list = Arrays.asList(1, 4, 16, 49, 64, 81, 100);
        assertEquals(Functions.returnAllMoreThanNumber(list,25), Arrays.asList(49, 64, 81, 100));
    }
    @Test
    void returnAllLessThanNumber(){
        List<Integer> list = Arrays.asList(1, 4, 16, 49, 64, 81, 100);
        assertEquals(Functions.returnAllLessThanNumber(list,50), Arrays.asList(1, 4, 16, 49));
    }
    @Test
    void returnAllInRange(){
        List<Integer> list = Arrays.asList(1, 4, 16, 49, 64, 81, 100);
        assertEquals(Functions.returnAllInRange(list,10,70), Arrays.asList(16, 49, 64));
    }
    @Test
    void RandomEven(){
        List<Integer> list = Functions.randomEven(100);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i)%2 == 0);
        }
    }
    @Test
    void RandomOdd(){
        List<Integer> list = Functions.randomOdd(100);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i)%2 == 1);
        }
    }
    @Test
    void listOfBiggest(){
        List<Integer> list = Arrays.asList(1, 2, 3, -100, -200, 298, 198, 1000, 1001, 11, 22, 123, 1234);
        assertEquals(Functions.listOfBiggest(list, 4), Arrays.asList(1234, 1001, 1000, 298));
        assertEquals(Functions.listOfBiggest(list, 14),
                Arrays.asList(1, 2, 3, -100, -200, 298, 198, 1000, 1001, 11, 22, 123, 1234)
                        .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
    @Test
    void getWordByCharacter(){
        List<String> list = Arrays.asList("Adam", "john", "james", "andrey", "vasya", "matvei", "nikita");
        Map<Character, String> map = Functions.getWordsByCharacter(list);
        assertEquals(map.get('a'), "Adam andrey");
        assertEquals(map.get('j'), "john james");
        assertEquals(map.get('v'), "vasya");
        assertEquals(map.get('m'), "matvei");
        assertEquals(map.get('n'), "nikita");
    }

    @Test
    void getCountOfWords(){
        List<String> list = Arrays.asList("d", "stream", "stream", "d", "java", "stream", "regex", "regex", "stream");
        Map<String, Integer> map = Functions.getCountOfWords(list);
        assertEquals(map.get("d"), 2);
        assertEquals(map.get("java"), 1);
        assertEquals(map.get("regex"), 2);
        assertEquals(map.get("stream"), 4);
    }

    @Test
    void countOfLetters(){
        List<String> list = Arrays.asList("hello", "world", "pal", "nice", "to meet", "you");
        assertEquals(Functions.countOfLetters(list), 27);
        list = new ArrayList<>();
        assertEquals(Functions.countOfLetters(list), 0);
    }

    @Test
    void listOfSquareOfNumbers(){
        List<Long> list = Functions.listOfSquareOfNumbers(1, 10000000);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), (long) (i + 1) *(i+1));
        }
    }

    @Test
    void join(){
        List<String> list = Arrays.asList("hello", "world", "pal", "nice", "to meet", "you");
        assertEquals(Functions.join(list, " "), "hello world pal nice to meet you");
        list = new ArrayList<>();
        assertEquals(Functions.join(list, " "), "");
    }

    @Test
    void getNumberFromListByOperation(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(Functions.getNumberFromListByOperation(list, Integer::sum), 55);
        assertEquals(Functions.getNumberFromListByOperation(list, (first, second) -> first*second), 3628800);
        assertEquals(Functions.getNumberFromListByOperation(new ArrayList<>(), Integer::sum), 0);
    }

    @Test
    void generateNSymbols(){
        assertEquals(Functions.generateNSymbols("?", 5), "?????");
        assertEquals(Functions.generateNSymbols("ab", 3), "ababab");
        assertEquals(Functions.generateNSymbols("", 10), "");
        assertEquals(Functions.generateNSymbols("a", 0), "");
    }

    @Test
    void listOfStringToInt(){
        assertEquals(Functions.listOfStringToInt(Arrays.asList("1", "2", "10")), Arrays.asList(1, 2, 10));
        assertEquals(Functions.listOfStringToInt(Arrays.asList("123", "234a", "a")), Arrays.asList(123));
    }
}