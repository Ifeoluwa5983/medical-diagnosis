package com.diagnisis.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
public class Symptoms {

    private String token;

    @ToString.Exclude
    private String symptoms;

    private String gender;
    private int yearOfBirth;
    private String language;
    private String format;
}
