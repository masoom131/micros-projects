package com.mgps.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private String rid;

    private String uid;

    private String hid;

    private int rating;

    private String feedback;

    private Hotel hotel;
}
