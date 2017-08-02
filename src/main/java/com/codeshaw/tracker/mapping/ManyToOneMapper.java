package com.codeshaw.tracker.mapping;

import java.util.List;

/**
 * Defines mapper methods when many inputs result in one output.
 *
 * <p>
 *     Expected usage is returning a single wrapping DTO element from a list of entity classes.
 * </p>
 *
 * @param <T> Entity class
 * @param <U> DTO class
 */
public interface ManyToOneMapper<T, U>  {

  T getMappedList(List<U> entity);
}
