package com.osckorea.springcloudfunctionexample.config;

import java.util.function.Function;

public class ToLowerCase implements Function<String, String>{

    @Override
    public String apply(String s) {
        return new StringBuilder(s).toString().toLowerCase();
    }
}
