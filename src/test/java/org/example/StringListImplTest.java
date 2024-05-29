package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private final StringList stringList = new StringListImpl();

//    public static Stream<Arguments> add() {
//        return Stream.of(Arguments.of(11, 11),
//                Arguments.of(21, 21),
//                Arguments.of(50, 50));
//    }

//@BeforeEach
//public void setUp() {
//    String[] storage = new String[]{
//            "0 - zero",
//            "1 - one",
//            "2 - two",
//            "3 - three",
//            "4 - four",
//            "5 - five",
//            "6 - six",
//            "7 - seven",
//            "8 - eight",
//            "9 - nine"};
//}

//    @ParameterizedTest
//    @MethodSource("add")
//    void addedVerify(String actual, String expected) {
//        assertEquals(expected, stringList.add(actual));
//    }

    @Test
    void testAddedUp() {
        String expected = "one";
        assertEquals(expected, stringList.add(1,"one"));
    }
    @Test
    void testAddedInRange() {
        String expected = "two";
        assertEquals(expected, stringList.add(9, "two"));
    }
    @Test
    void testAddedInLastIndexInRange() {
        String expected = "two";
        assertEquals(expected, stringList.add(10, "two"));
    }
    @Test
    void set() {
        String expected = "three";
        assertEquals(expected, stringList.add(8, "three"));
    }

    @Test
    void remove() {

    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}