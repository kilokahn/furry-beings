package com.kilo;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TierPrinterTest {

    @Test
    public void testSimple() {
        Map<String, List<String>> inputs = Map.of("A", Collections.emptyList(),
                "B", Collections.singletonList("A"),
                "C", Collections.singletonList("A"),
                "D", Collections.singletonList("B"),
                "E", Arrays.asList("C", "A"));
        Map<String, List<String>> specificInputs = new LinkedHashMap<>();
        specificInputs.put("B",Collections.singletonList("A"));
        specificInputs.put("C",Collections.singletonList("A"));
        specificInputs.put("A",Collections.emptyList());
        specificInputs.put("D",Collections.singletonList("B"));
        specificInputs.put("E",Arrays.asList("C","A"));
        testForInputMap(specificInputs);
    }

    @Test
    public void testJumbledInput() {
        Map<String, List<String>> inputs = Map.of(
                "B", Collections.singletonList("A"), "A", Collections.emptyList(),
                "C", Collections.singletonList("A"),
                "D", Collections.singletonList("B"),
                "E", Arrays.asList("C", "A"));
        testForInputMap(inputs);
    }

    @Test
    @Ignore
    public void testCycle() {
        Map<String, List<String>> inputs = Map.of(
                "B", Collections.singletonList("A"), "A", Collections.singletonList("C"),
                "C", Collections.singletonList("A"),
                "D", Collections.singletonList("B"),
                "E", Arrays.asList("C", "A"));
        testForInputMap(inputs);
    }

    private void testForInputMap(Map<String, List<String>> inputMap) {
        TierPrinter tierPrinter = new TierPrinter();
        List<List<String>> tiers = tierPrinter.getTiers(inputMap);
        assertNotNull("Null tiers obtained", tiers);
        List<List<String>> expectedTiers = Arrays.asList(Collections.singletonList("A"), Arrays.asList("B", "C"), Arrays.asList("D", "E"));
        assertEquals("Tiers mismatch for input: " + inputMap, expectedTiers, tiers);
    }
}
