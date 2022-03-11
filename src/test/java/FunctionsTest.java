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

}