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
}