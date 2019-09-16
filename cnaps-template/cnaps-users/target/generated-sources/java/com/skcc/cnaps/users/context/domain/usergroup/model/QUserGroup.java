package com.skcc.cnaps.users.context.domain.usergroup.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserGroup is a Querydsl query type for UserGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserGroup extends EntityPathBase<UserGroup> {

    private static final long serialVersionUID = 1636755278L;

    public static final QUserGroup userGroup = new QUserGroup("userGroup");

    public final com.skcc.cnaps.shared.share.base.domain.QAbstractEntity _super = new com.skcc.cnaps.shared.share.base.domain.QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath userGroupName = createString("userGroupName");

    public final BooleanPath userGroupUsage = createBoolean("userGroupUsage");

    public QUserGroup(String variable) {
        super(UserGroup.class, forVariable(variable));
    }

    public QUserGroup(Path<? extends UserGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserGroup(PathMetadata metadata) {
        super(UserGroup.class, metadata);
    }

}

