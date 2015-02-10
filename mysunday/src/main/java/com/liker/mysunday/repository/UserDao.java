package com.liker.mysunday.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.liker.mysunday.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
