package org.justinhoang.persistence;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * The type Gen hibernate dao.
 *
 * @param <T>
 *         the type parameter
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenHibernateDao<T extends Serializable> extends AbsHibernateDao<T>
        implements GenDaoInt<T>
{

}
