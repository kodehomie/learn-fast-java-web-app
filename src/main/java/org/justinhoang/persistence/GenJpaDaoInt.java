package org.justinhoang.persistence;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenJpaDaoInt<T extends Serializable> extends AbsJpaDao<T>
        implements GenDaoInt<T>
{

}
