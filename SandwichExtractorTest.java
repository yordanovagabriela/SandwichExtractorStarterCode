import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SandwichExtractorTest {
    @Test
    public void testIfEmptyArrayIsReturnedWhenSandwichIsEmpty() {
        String assertMessage =
                "Did not determine correctly sandwich ingredients, when there are none.";
        String[] expected = new String[] {};
        String[] actual = SandwichExtractor.extractIngredients("");
        assertArrayEquals(assertMessage, expected, actual);
    }

    @Test
    public void testIfEmptyArrayIsReturnedWhenOnlyOneBread() {
        String assertMessage =
                "Did not determine correctly sandwich ingredients, when there is just bread.";
        String[] expected = new String[] {};
        String[] actual = SandwichExtractor.extractIngredients("bread");
        assertArrayEquals(assertMessage, expected, actual);
    }

    @Test
    public void testIfEmptyArrayIsReturnedWhenOnlyOneBread2() {
        String assertMessage =
                "Did not determine correctly sandwich ingredients, when there is just bread and some random stuff.";
        String[] expected = new String[] {};
        String[] actual = SandwichExtractor.extractIngredients("mmbreadmmmm");
        assertArrayEquals(assertMessage, expected, actual);
    }

    @Test
    public void testIfCorrectIngredientsAreReturnedWhenNoOlives() {
        String assertMessage =
                "Did not determine correctly sandwich ingredients, when there are a few of them. Check also the order of ingredients";
        String[] expected = new String[] {"ham", "mayo", "pickels", "tomato"};
        String[] actual = SandwichExtractor.extractIngredients("mmbreadmayo-ham-tomato-pickelsbreadmm");
        assertArrayEquals(assertMessage, expected, actual);
    }

    @Test
    public void testIfCorrectIngredientsAreReturnedWhenMultipleOlives() {
        String assertMessage =
                "Did not determine correctly sandwich ingredients, when there are a few of them. Check also for any olives and the order of ingredients";
        String[] expected = new String[] {"ham", "mayo", "pickels", "tomato"};
        String[] actual = SandwichExtractor.extractIngredients("mmbreadmayo-ham-olives-tomato-olives-pickelsbreadmm");
        assertArrayEquals(assertMessage, expected, actual);
    }

    @Test
    public void testIfCorrectIngredientsAreReturnedWhenMultipleOlivesAtBothEnds() {
        String assertMessage =
                "Did not determine correctly sandwich ingredients, when there are a few of them. Check also for any bread-and-olives and the order of ingredients";
        String sandwich = "mmbreadolives-mayo-ham-olives-tomato-olives-pickels-olivesbreadmm";

        String[] expected = new String[] {"ham", "mayo", "pickels", "tomato"};
        String[] actual = SandwichExtractor.extractIngredients(sandwich);
        assertArrayEquals(assertMessage, expected, actual);
    }

    @Test
    public void testIfCorrectIngredientsAreReturnedWhenFakeOlives() {
        String assertMessage =
                "Did not determine correctly sandwich ingredients, when there are a few of them. Check also for any fake olives.";
        String sandwich = "mmbreadmolives-mayo-ham-olives-tomato-molives-pickels-olivesbreadmm";

        String[] expected = new String[] {"ham", "mayo", "molives", "molives", "pickels", "tomato"};
        String[] actual = SandwichExtractor.extractIngredients(sandwich);
        assertArrayEquals(assertMessage, expected, actual);
    }
}
