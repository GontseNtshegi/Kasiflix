package com.yuqar.kasiflix.auth.repositories;

import com.google.common.base.Optional;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Gntshegi on 2017/07/26.
 */
public interface UserRepository {
  Optional<User> findUserbyUsernameAndPassword(String username, String password);
}
