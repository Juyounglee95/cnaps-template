package com.skcc.cnaps.menu.context.domain.menu.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 1526921785L;

    public static final QMenu menu = new QMenu("menu");

    public final com.skcc.cnaps.shared.share.base.domain.QAbstractEntity _super = new com.skcc.cnaps.shared.share.base.domain.QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> menuGroupId = createNumber("menuGroupId", Long.class);

    public final StringPath menuName = createString("menuName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final BooleanPath usage = createBoolean("usage");

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata metadata) {
        super(Menu.class, metadata);
    }

}

