package br.com.introcdc.tests.java;
/*
 * Written by IntroCDC, Bruno Coelho at 24/04/2025 - 13:14
 */

import io.javalin.Javalin;

import java.util.Map;

public class JavalinClass {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
        }).start(7000);

        app.get("/", ctx -> ctx.result("Bem-vindo ao servidor Javalin!"));

        app.get("/hello/{name}", ctx -> {
            String name = ctx.pathParam("name");
            ctx.result("Olá, " + name + "!");
        });

        app.post("/echo", ctx -> {
            String message = ctx.body();
            ctx.result("Você disse: " + message);
        });

        app.get("/json", ctx -> {
            ctx.json(Map.of(
                    "mensagem", "Este é um JSON de exemplo",
                    "status", "sucesso"
            ));
        });

        System.out.println("Servidor rodando em http://localhost:7000");
    }

}
