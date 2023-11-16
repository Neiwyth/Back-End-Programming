package sof03.music.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserNameIgnoreCase(String userName);

    User findByUserName(String userName);

}
