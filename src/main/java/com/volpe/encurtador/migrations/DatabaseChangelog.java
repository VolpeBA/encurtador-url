package com.volpe.encurtador.migrations;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

import java.util.HashMap;
import java.util.Map;

@ChangeLog(order = "001")
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "createUrlCollection", author = "brunoVolpe")
    public void createUrlCollection(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists("urls")) {
            mongoTemplate.createCollection("urls");
        }

        mongoTemplate.indexOps("urls").ensureIndex(new Index().on("id", Sort.Direction.ASC).unique());

    }

    @ChangeSet(order = "002", id = "createCounterCollection", author = "brunoVolpe")
    public void createCounterCollection(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists("counters")) {
            mongoTemplate.createCollection("counters");
        }

        Map<String, Object> counter = new HashMap<>();
        counter.put("_id", "urlid");
        counter.put("seq", 0);

        mongoTemplate.save(counter, "counters");
    }
}
