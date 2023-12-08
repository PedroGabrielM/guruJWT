package br.com.project.usecases.port;

import java.util.List;

public interface RestService<T> {

    List<T> get(final String resource);

    List<T> get(final String resource, final String Token);

    int post(final String resource, final T entity);

    int post(final String resource, final T entity, final String Token);

    boolean put(final String resource, final T entity);

    boolean put(final String resource, final T entity, final String Token);

    boolean delete(final String resource);

    boolean delete(final String resource, final String Token);

    T getById(final String resource, Class<T> clazz);

    T getById(final String resource, Class<T> clazz, final String Token);

}
