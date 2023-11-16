package com.test01.test01;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// MUY SIMPLE, ESTE COMPONENTE TIENE UN CICLO DE VIDA POR EL @RequestScope, cada vez que se llame

@Component // declara este clase como un bean o componente en el contexto de spring
@RequestScope // anotacion que declara el componente cada vez que se llame, ciclo de vida corto
public class Component01 {

    public String texto = "null";
    
    // anotacion para metodo que se ejecuta cuando se inicializa el componente por primera vez
    @PostConstruct
    public void inicializar(){
        texto = "Hola Mundo";
    }

    // ESTE METODO GENERAR UN ERROR O BUG, POR FAVOR VERIFICAR
    // anotacion para metodo que se ejecuta cuando se apaga o se detiene la aplicacion de spring
    @PreDestroy
    public void Destruir(){
        System.out.println("Se apago o se detenio la aplicacion de spring");
    }

}
