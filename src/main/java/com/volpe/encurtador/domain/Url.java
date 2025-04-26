package com.volpe.encurtador.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    @Id
    private String objectId;

    private Long id;

    private String url;

    public Url(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}
