package ua.com.alevel.records;

public record PublicRecord(
        String id,
        String name,
        String email,
        int age) {
    /*
     * - can only be public
     */

    /*
     * - Record class replaces immutable classes in Java
     * - it is immutable DATA class
     *   that require only the type and name of fields.
     */

    /* When we should use records:
     * - Records are ideal candidate when modeling things
     *   like domain model classes (potentially to be persisted via ORM),
     *   or data transfer objects (DTOs).
     *
     * - The records are useful when storing data temporarily.
     *   As example can be during JSON deserialization.
     *   Generally during deserialization, we do not expect
     *   the program to mutate data read from JSON.
     *   We just read the data and pass it to data processor or validator.
     *
     * - Records are not replacement for mutable Java beans because a record, by design, is immutable.
     *
     * - When a class is intended to hold the data for some time,
     *   and we want to avoid writing lots of boilerplate code.
     *
     * - To hold multiple return values from a method, stream joins,
     *   compound keys and in data-structure such as tree nodes.
     */
}
