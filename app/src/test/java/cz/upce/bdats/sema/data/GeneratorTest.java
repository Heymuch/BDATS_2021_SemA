package cz.upce.bdats.sema.data;

import org.junit.Test;
import static org.junit.Assert.*;

public class GeneratorTest {
    @Test
    public void genSPZTest() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Generator.genSPZ());
        }
    }
}