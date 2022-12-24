package com.kosharovskiy.ddd.businesslogic.domainmodel.common;

import java.util.regex.Pattern;

public record Email(String email) {
    static Email parse(String email) {
        boolean isValid = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
                .matcher(email)
                .matches();

        if (!isValid) {
            throw new IllegalArgumentException("Invalid e-mail");
        }

        return new Email(email);
    }
}
