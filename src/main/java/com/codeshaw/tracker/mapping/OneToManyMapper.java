package com.codeshaw.tracker.mapping;

import java.util.List;

/**
 *
 * @param <T> DTO class
 * @param <U> Entity class
 */
public interface OneToManyMapper<T, U>  {

  List<U> getMappedList(T dto);
}
