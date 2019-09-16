package com.skcc.cnaps.users.context.domain.users.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserCompany is a Querydsl query type for UserCompany
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QUserCompany extends BeanPath<UserCompany> {

    private static final long serialVersionUID = -486829696L;

    public static final QUserCompany userCompany = new QUserCompany("userCompany");

    public final StringPath companyName = createString("companyName");

    public QUserCompany(String variable) {
        super(UserCompany.class, forVariable(variable));
    }

    public QUserCompany(Path<? extends UserCompany> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserCompany(PathMetadata metadata) {
        super(UserCompany.class, metadata);
    }

}

