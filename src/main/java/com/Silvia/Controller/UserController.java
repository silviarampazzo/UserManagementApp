package com.Silvia.Controller;

import com.Silvia.DAO.UserDAO;
import com.Silvia.Service.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dev on 09/06/17.
 */
@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name, @RequestParam String password, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UserDAO n = new UserDAO();
        n.setName(name);
        n.setPassword(password);
        n.setUsername(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserDAO> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody UserDAO getUserDAOById(@PathVariable("id") long id){
        return userRepository.findOne(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userRepository.delete(id);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser
            (@RequestBody UserDAO userDAO){
        UserDAO n = userRepository.findOne(userDAO.getId());
        n.setName(userDAO.getName());
        n.setPassword(userDAO.getPassword());
        n.setUsername(userDAO.getUsername());
        userRepository.save(n);
    }

}
