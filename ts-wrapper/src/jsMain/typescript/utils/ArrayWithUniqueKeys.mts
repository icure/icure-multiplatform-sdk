/**
 * `ArrayWithUniqueKeys<T, K>` defines an array of objects of type `T` where no two elements share the same combination
 *  of values for the specified keys `K`.
 *
 * This type is intended for documentation purposes and does not enforce uniqueness at the type level.
 * When this type is used by CardinalSDK methods it is guaranteed that all outputs respect the constraint and all inputs
 * will be validated against the constraint, throwing a runtime exception if invalid.
 *
 * ### Example
 * ```ts
 * type Item = { a: number; b: string; c: boolean };
 * type UniqueAB = ArrayWithUniqueKeys<Item, 'a' | 'b'>;
 *
 * const valid: UniqueAB = [
 *   { a: 1, b: '1', c: true },
 *   { a: 1, b: '2', c: true }, // OK: Unique combination of 'a' and 'b'
 * ];
 *
 * const invalid: UniqueAB = [
 *   { a: 1, b: '1', c: true },
 *   { a: 1, b: '1', c: false }, // BAD: Duplicate combination of 'a' and 'b'
 * ];
 * ```
 *
 * @param T The object type of array elements.
 * @param K A union of keys from `T` that must be unique across all elements in the array.
 */
type ArrayWithUniqueKeys<T, K extends keyof T> = Array<T>
