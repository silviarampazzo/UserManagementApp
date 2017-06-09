package hello;

import org.springframework.data.repository.CrudRepository;

import hello.DAO.User;

/**
 * Created by dev on 09/06/17.
 */
public interface UserRepository extends CrudRepository<User, Long>{

}
