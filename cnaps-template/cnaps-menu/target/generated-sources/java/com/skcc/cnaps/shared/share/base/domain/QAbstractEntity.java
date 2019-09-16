package com.skcc.cnaps.shared.share.base.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractEntity is a Querydsl query type for AbstractEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractEntity extends EntityPathBase<AbstractEntity> {

    private static final long serialVersionUID = -600106644L;

    public static final QAbstractEntity abstractEntity = new QAbstractEntity("abstractEntity");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public QAbstractEntity(String variable) {
        super(AbstractEntity.class, forVariable(variable));
    }

    public QAbstractEntity(Path<? extends AbstractEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractEntity(PathMetadata metadata) {
        super(AbstractEntity.class, metadata);
    }

}

