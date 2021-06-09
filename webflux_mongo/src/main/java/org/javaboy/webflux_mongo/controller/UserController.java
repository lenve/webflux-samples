package org.javaboy.webflux_mongo.controller;

import org.javaboy.webflux_mongo.bean.User;
import org.javaboy.webflux_mongo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @PostMapping("/")
    public Mono<User> addUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping("/")
    public Flux<User> getAll() {
        return userDao.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(String id) {
        return userDao.findById(id);
    }

    @GetMapping(value = "/stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamGetAll() {
        return userDao.findAll();
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id) {
        return userDao.findById(id)
                .flatMap(user -> userDao.delete(user).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/")
    public Mono<ResponseEntity<User>> updateUser(@RequestBody User user) {
        return userDao.findById(user.getId())
                .flatMap(u -> userDao.save(user))
                .map(u->new ResponseEntity<User>(u,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byname")
    public Flux<User> getUserByName(String name) {
        return userDao.findUserByUsernameContaining(name);
    }
}
