package org.justinhoang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.justinhoang.entity.User;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
public class UserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Session session;
    Transaction transaction = null;

    GenericDao<? extends User> gDao;

    @BeforeEach
    void setUp() {
        gDao = new GenericDao<>(User.class);
    }

    @Test
    void create() {
    }

    @Test
    void readId() {
        User targetUser = (User)gDao.readId(1);
        assertNotNull(targetUser);
        assertEquals("Justin", targetUser.firstName());
    }

    @Test
    void readAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getByPropertyLike() {
    }

    @Test
    void findByPropertyEqual() {
    }
}
