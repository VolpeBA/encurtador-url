package com.volpe.encurtador.repository;

import com.volpe.encurtador.domain.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<Url, String> {

    @Query("{'id' : ?0}")
    Optional<Url> findByCustomId(Long id);
}
