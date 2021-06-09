package org.javaboy.webflux_router.handler;

import org.javaboy.webflux_router.bean.Person;
import org.javaboy.webflux_router.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
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
@Component
public class PersonHandler {
    @Autowired
    PersonRepository personRepository;

    public Mono<ServerResponse> addPerson(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(personRepository.saveAll(serverRequest.bodyToMono(Person.class)), Person.class);
    }

    public Mono<ServerResponse> deletePerson(ServerRequest serverRequest) {
        return personRepository.findById(Long.parseLong(serverRequest.pathVariable("id")))
                .flatMap(p -> personRepository.delete(p).then(ServerResponse.ok().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> getAllPerson(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(personRepository.findAll(), Person.class);
    }
}
