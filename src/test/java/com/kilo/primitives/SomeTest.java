package com.kilo.primitives;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeTest {

    private static final Logger LOG = LoggerFactory.getLogger(SomeTest.class);

    @Test
    public void test() {
        LOG.info("Tested something correctly!");
    }
}
