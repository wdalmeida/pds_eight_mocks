package fr.eight.mock.generator.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Vyach on 18/01/2018.
 */
@Component
public class Options {

    @Value("${gen.nombre.profile}")
    private int profilsNombre;

    @Value("${gen.file.name}")
    private String fileName;

    @Value("${gen.test_file.name}")
    private String testFileName;

    public int getProfilsNombre() { return this.profilsNombre; }

    public String getFileName() { return this.fileName; }

    public String getTestFileName() { return this.testFileName; }

}
