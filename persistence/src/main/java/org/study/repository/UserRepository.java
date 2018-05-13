package org.study.repository;

import org.springframework.stereotype.Repository;
import org.study.domain.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 用户的仓储
 **/
@Repository
public class UserRepository {

    private final ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();

    public Boolean save(User user) {
        // ID 从 1 开始
        long id = idGenerator.incrementAndGet();
        user.setId(id);
        // 1 -> user
        // 1 -> user1 -> user return
        return repository.put(id, user) == null;
    }

    // Effective Java II
    public Collection<User> findAll() {
        return repository.values();
    }

}
