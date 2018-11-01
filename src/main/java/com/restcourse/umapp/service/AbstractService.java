package com.restcourse.umapp.service;

import com.google.common.collect.Lists;
import com.restcourse.umapp.common.IdentifiableComponent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class AbstractService<T extends IdentifiableComponent> implements PagingAndSortingService<T> {

    @Override
    @Transactional(readOnly = true)
    public T findOne(Long id) {
        Optional<T> entity = getDao().findById(id);
        return entity.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllSorted(String sortBy, String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        return Lists.newArrayList(getDao().findAll(sortInfo));
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllPaginated(int page, int size) {
        final Page<T> pages = getDao().findAll(new PageRequest(page, size));
        final List<T> content = pages.getContent();
        if (content == null) {
            return Lists.newArrayList();
        }
        return content;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        final List<T> content = getDao().findAll(new PageRequest(page, size, sortInfo)).getContent();
        if (content == null) {
            return Lists.newArrayList();
        }
        return content;
    }

    @Override
    public T create(T entity) {
        final T persistedEntity = getDao().save(entity);
        return persistedEntity;
    }

    @Override
    public void update(T entity) {
        getDao().save(entity);
    }

    @Override
    public void delete(Long id) {
        final Optional<T> entity = getDao().findById(id);
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

    protected abstract PagingAndSortingRepository<T, Long> getDao();

    protected final Sort constructSort(final String sortBy, final String sortOrder) {
        Sort sortInfo = null;
        if (sortBy != null) {
            sortInfo = new Sort(Sort.Direction.fromString(sortOrder), sortBy);
        }
        return sortInfo;
    }
}
