package com.jonas.demo;

import java.time.Instant;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeSetsTest {

    @Test
    void testMerge() {
        Instant now = Instant.now();
        Set<Thing> left = Set.of(
                new Thing("a", "1", Instant.parse("2025-01-01T12:35:00Z")),
                new Thing("b", "2", Instant.parse("2025-01-01T12:35:00Z")),
                new Thing("c", "3", Instant.parse("2025-01-01T13:35:00Z")));
        Set<Thing> right = Set.of(
                new Thing("a", "one", now),
                new Thing("b", "2", now));

        Set<Thing> merged = merge(left, right);
        assertEquals(2, merged.size());
        assertTrue(merged.contains(new Thing("a", "one", now)));
    }

    @Data
    @AllArgsConstructor
    class Thing {
        String key;
        String val;
        Instant lastModified;
    }

    Set<Thing> merge(Set<Thing> left, Set<Thing> right) {
        // merge left and right
        if(left.contains("a")){

        }
        return null; // TODO
        /**
         * Expected output:
         * [
         *     {a, one, Instant.now()}
         *     {b, 2, 2025-01-01T12:35:00Z}
         * ]
         */
    }

}
