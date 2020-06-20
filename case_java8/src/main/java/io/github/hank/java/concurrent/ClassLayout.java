package io.github.hank.java.concurrent;

public class ClassLayout {

    private final org.openjdk.jol.info.ClassLayout classLayout;

    public ClassLayout(org.openjdk.jol.info.ClassLayout classLayout) {
        this.classLayout = classLayout;
    }

    public static ClassLayout parseInstance(Object instance) {
        return new ClassLayout(org.openjdk.jol.info.ClassLayout.parseInstance(instance));
    }

    /**
     * Builds the class layout.
    public ClassLayout(ClassData classData, SortedSet<FieldLayout> fields, int headerSize, long instanceSize, boolean check) {
        super(classData, fields, headerSize, instanceSize, check);
    }

    public static ClassLayout parseInstance(Object instance) {
        return (ClassLayout) org.openjdk.jol.info.ClassLayout.parseInstance(instance);
    }*/

    public String toPrintableSimple(boolean enabled) {
        return enabled ? printSimpleLayout() : classLayout.toPrintable();
    }

    private String printSimpleLayout() {
        String output = classLayout.toPrintable();
        String[] splitOutput = output.split("\\(");
        return splitOutput[2].substring(0,8);
    }

}
