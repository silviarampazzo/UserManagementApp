package com.Silvia.Service;

import com.Silvia.DAO.UserDAO;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by dev on 09/06/17.
 */
public interface UserRepository extends CrudRepository<UserDAO, Long>{

}
