package com.skcc.cnaps.menu.context.domain.menugroup.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenuGroup is a Querydsl query type for MenuGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenuGroup extends EntityPathBase<MenuGroup> {

    private static final long serialVersionUID = 1658300403L;

    public static final QMenuGroup menuGroup = new QMenuGroup("menuGroup");

    public final com.skcc.cnaps.shared.share.base.domain.QAbstractEntity _super = new com.skcc.cnaps.shared.share.base.domain.QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath menuGroupName = createString("menuGroupName");

    public final BooleanPath menuGroupUsage = createBoolean("menuGroupUsage");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public QMenuGroup(String variable) {
        super(MenuGroup.class, forVariable(variable));
    }

    public QMenuGroup(Path<? extends MenuGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenuGroup(PathMetadata metadata) {
        super(MenuGroup.class, metadata);
    }

}

