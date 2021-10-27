package ua.com.alevel.classes;
// class or interface:
// - restricts which other classes or interfaces may extend it.
public sealed class PublicSealedClass permits ExtendsPublicSealedClass {
    /*
     * 1. Public Sealed class:
     * - visible for all;
     * - package visible;
     * - can't be final;
     * - can't be static;
     */

    /*
     * - like enums, capture alternatives in domain models,
     *   allowing programmers and compilers to reason about exhaustiveness.
     *
     * - also useful for creating secure hierarchies
     *   by decoupling accessibility from extensibility,
     *   allowing library developers to expose interfaces
     *   while still controlling all the implementations.
     *
     * - work together with records and pattern matching
     *   to support a more data-centric form of programming.
     */
}
