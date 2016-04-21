package io.techery.janet.compiler.utils;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.processing.Filer;

public abstract class Generator<T> {

    private final Filer filer;

    protected Generator(Filer filer) {
        this.filer = filer;
    }

    public abstract void generate(ArrayList<T> actionClasses);

    protected void saveClass(String packageName, TypeSpec typeSpec) {
        try {
            JavaFile.builder(packageName, typeSpec).build().writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
