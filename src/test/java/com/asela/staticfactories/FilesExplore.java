package com.asela.staticfactories;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class FilesExplore {

    @Test
    public void testCopy() throws Exception {
       Files.copy(Paths.get("c:\\usr\\a.txt"), System.out); 
    }
}
