package com.restcourse.umapp.service;

import com.google.common.collect.Lists;
import com.restcourse.umapp.common.UmDto;
import com.restcourse.umapp.common.UmEntity;
import com.restcourse.umapp.common.UmRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class AbstractService<E extends UmEntity, D extends UmDto> implements PagingAndSortingService<D> {

    protected abstract Converter<E, D> getToDtoConverter();
    protected abstract Converter<D, E> getToEntityConverter();

    @Override
    @Transactional(readOnly = true)
    public D findOne(Long id) {
        Optional<E> entity = getDao().findById(id);
        if (entity.isPresent()) {
            return getToDtoConverter().convert(entity.get());
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<D> findAll() {
        return Lists.transform(
                Lists.newArrayList(getDao().findAll()),
                getToDtoConverter()::convert
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<D> findAllSorted(String sortBy, String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        return Lists.transform(
                Lists.newArrayList(getDao().findAll(sortInfo)),
                getToDtoConverter()::convert
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<D> findAllPaginated(int page, int size) {
        final List<E> content = getDao().findAll(new PageRequest(page, size)).getContent();
        if (content == null) {
            return Lists.newArrayList();
        }
        return Lists.transform(content, getToDtoConverter()::convert);
    }

    @Override
    @Transactional(readOnly = true)
    public List<D> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        final List<E> content = getDao().findAll(new PageRequest(page, size, sortInfo)).getContent();
        if (content == null) {
            return Lists.newArrayList();
        }
        return Lists.transform(content, getToDtoConverter()::convert);
    }

    @Override
    public D create(D entity) {
        final E persistedEntity = getDao().save(getToEntityConverter().convert(entity));
        return getToDtoConverter().convert(persistedEntity);
    }

    @Override
    public void update(D entity) {
        getDao().save(getToEntityConverter().convert(entity));
    }

    @Override
    public void delete(Long id) {
        final Optional<E> entity = getDao().findById(id);
        if(entity.isPresent()) {
            getDao().delete(entity.get());
        }
    }

    @Override
    public void deleteAll() {
        getDao().deleteAll();
    }

    @Override
    public long count() {
        return getDao().count();
    }

    protected abstract UmRepository<E> getDao();

    protected final Sort constructSort(final String sortBy, final String sortOrder) {
        Sort sortInfo = null;
        if (sortBy != null) {
            sortInfo = new Sort(Sort.Direction.fromString(sortOrder), sortBy);
        }
        return sortInfo;
    }
}
