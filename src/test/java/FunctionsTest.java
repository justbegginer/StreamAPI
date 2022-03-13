import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//import java.*;
import java.util.ArrayList;
import java.util.List;

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
}