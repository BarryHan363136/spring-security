package com.barry.security.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3166146928556817560L;

    private String username;

    private String password;

}
