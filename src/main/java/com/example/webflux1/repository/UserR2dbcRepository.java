package com.example.webflux1.repository;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserR2dbcRepository extends ReactiveCrudRepository<User,Long> {
    Flux<User> findByName(String name);
    Flux<User> findByNameOrderByIdDesc(String name);

    //특정 조건으로 여러 다수의 삭제 조건을 거는 기능이 없기 때문에 @Query 애노테이션을 활용한 커스텀 구현
    @Modifying
    @Query("DELETE FROM users WHERE name = :name")
    Mono<Void> deleteByName(String name);
}
