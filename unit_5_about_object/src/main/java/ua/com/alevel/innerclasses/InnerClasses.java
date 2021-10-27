package ua.com.alevel.innerclasses;

public class InnerClasses {

    // public Inner class:
    public class InnerClass {
        /*
         * - Non-static nested class is called Inner class.
         * - have access to other members of the enclosing class.
         */
    }

    // private Nested class:
    private static class NestedClass {
        /*
         * - static inner class is called Nested class.
         * - It is a way of logically grouping classes
         *   that are only used in one place.
         *
         * - Static nested classes do not have access
         *   to other members of the enclosing class.
         */
    }

    // protected final nested class
    protected final static class protectedFinStatNestedClass {
        /*
         * - visible only inside package;
         * - can't be extended;
         *
         * - Also methods could be declared as final
         *   to indicate that cannot be overridden
         *   by subclasses.
         */
    }

    // abstract inner class
    abstract class abstractInnerClass {
        /*
         * - ??? can't get idea of this class ???
         */
    }

    sealed class SealedInnerClass permits ExtendedSealedInnerClass {}

    final class ExtendedSealedInnerClass extends SealedInnerClass {}

}
