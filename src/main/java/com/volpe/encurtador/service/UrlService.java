package com.volpe.encurtador.service;

import com.volpe.encurtador.domain.Counter;
import com.volpe.encurtador.domain.Url;
import com.volpe.encurtador.repository.UrlRepository;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UrlRepository urlRepository;

    public Long getNextSequence(@Nonnull final String counterName) {
        Query query = new Query(Criteria.where("_id").is(counterName));
        Update update = new Update().inc("seq", 1);
        FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true).upsert(true);

        Counter counter = mongoTemplate.findAndModify(query, update, options, Counter.class, "counters");

        return counter != null ? counter.getSeq() : 1L;
    }

    public Url saveUrl(@Nonnull final String url) {
        Long id = getNextSequence("urlid");

        Url urlEntity = new Url(id, url);
        return mongoTemplate.save(urlEntity);
    }

    public List<Url> getAll() {
        return urlRepository.findAll();
    }

    public Optional<Url> getUrlById(@Nonnull final Long id) {
        return urlRepository.findByCustomId(id);
    }

}
