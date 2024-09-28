package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CreateResourcePojo {
    private String title;
    private String content;
    private String slug;
    private String picture;
    private int user;
}
