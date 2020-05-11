package io.github.hank.java.concurrent;

import java.util.SortedSet;

import org.openjdk.jol.info.ClassData;
import org.openjdk.jol.info.FieldLayout;

public class ClassLayout extends org.openjdk.jol.info.ClassLayout {
    /**
     * Builds the class layout.
     *
     * @param classData    class data
     * @param fields       field layouts
     * @param headerSize   header size
     * @param instanceSize instance size
     * @param check        whether to check important invariants
     */
    public ClassLayout(ClassData classData, SortedSet<FieldLayout> fields, int headerSize, long instanceSize, boolean check) {
        super(classData, fields, headerSize, instanceSize, check);
    }

    public static ClassLayout parseInstance(Object instance) {
        return (ClassLayout) org.openjdk.jol.info.ClassLayout.parseInstance(instance);
    }

    public String toPrintableSimple(boolean enabled) {
        return enabled ? super.toPrintable() : super.toPrintable();
    }

}
