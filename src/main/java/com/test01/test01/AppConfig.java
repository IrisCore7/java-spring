package com.test01.test01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    
    @Bean("lista1")
    @Primary
    public List<String> lista1(){
        List<String> lista = new ArrayList<String>();
        lista.add("text1");
        lista.add("text2");
        lista.add("text3");
        return lista;
    }

    @Bean("lista2")
    public List<String> lista2(){
        List<String> lista = new ArrayList<String>();
        lista.add("text1v2");
        lista.add("text2v2");
        lista.add("text3v2");
        return lista;
    }
}
