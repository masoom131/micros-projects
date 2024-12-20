package com.mgps.rating.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document("ratings")
public class Rating {

    @Id
    private String rid;

    private String uid;

    private String hid;

    private int rating;

    private String feedback;
}
