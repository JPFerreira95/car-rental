package com.jferreira95.microservice.commonlib.util.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Pageable search builder.
 */
public class PageableSearchBuilder {

    private Query currentQuery = null;
    private List<Criteria> lCriteria = null;
    private MongoTemplate mongoTemplate = null;
    private Class<?> entityClass = null;
    private Pageable pageable = null;

    /**
     * Instantiates a new Pageable search builder.
     *
     * @param pageable      the pageable
     * @param mongoTemplate the mongo template
     * @param entityClass   the entity class
     */
    public <T> PageableSearchBuilder(Pageable pageable, MongoTemplate mongoTemplate, Class<T> entityClass) {
        this.pageable = pageable;
        this.currentQuery = new Query().with(pageable);
        this.lCriteria = new ArrayList<>();
        this.mongoTemplate = mongoTemplate;
        this.entityClass = entityClass;
    }

    public PageableSearchBuilder addIsCriteria(SearchField queryField, Object value) {
        if (!ObjectUtils.isEmpty(value)) {
            this.lCriteria.add(Criteria.where(queryField.fieldName()).is(value.toString()));
        }

        return this;
    }

    public PageableSearchBuilder addCaseInsensitiveCriteria(SearchField queryField, Object value) {
        if (!ObjectUtils.isEmpty(value)) {
            this.lCriteria.add(Criteria.where(queryField.fieldName()).regex(value.toString(), "i"));
        }

        return this;
    }

    public PageableSearchBuilder addBetweenClosedIntervalCriteria(SearchField queryField, Object minValue, Object maxValue) {
        if (!ObjectUtils.isEmpty(minValue) && !ObjectUtils.isEmpty(maxValue)) {
            this.lCriteria.add(Criteria.where(queryField.fieldName()).gte(minValue).lte(maxValue));
        }

        return this;
    }

    private void applyCriteria() {

        if (!lCriteria.isEmpty()) {
            currentQuery.addCriteria(new Criteria()
                    .andOperator(lCriteria.toArray(new Criteria[0])));
        }

    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public Page<?> getResults() {

        this.applyCriteria();

        Page<?> result = PageableExecutionUtils.getPage(
                mongoTemplate.find(currentQuery, entityClass),
                pageable,
                () -> mongoTemplate.count(currentQuery.skip(0).limit(0), entityClass)
        );

        return result;
    }

}
