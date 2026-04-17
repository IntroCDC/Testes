package br.com.introcdc.tests.social;
/*
 * Written by IntroCDC, Bruno Coelho at 08/07/2024 - 19:14
 */

public enum SocialRegister {
    E0(0, "Conhecendo Ela",
            new SocialDay[]{
                    new SocialDay("15/07/2023", "-Casa", "-Casa Rafael", "Casa Eduarda", "Casa (*)", "Apartamento (*)", "Praia de Iracema (*)"),
                    new SocialDay("16/07/2023", "-Praia de Iracema (*)", "Apartamento (*)", "Mucuripe (*)", "McDonald's (Dom Luiz)", "Apartamento", "Casa Christian", "Casa Eduarda", "-Casa")
            }),
    E1(1, "O Primeiro Encontro",
            new SocialDay[]{
                    new SocialDay("19/08/2023", "-Casa", "Casa Eduarda", "Casa", "RioMar", "Pague Menos", "Apartamento", "Casa"),
                    new SocialDay("20/08/2023", "-Casa", "Apartamento", "Iguatemi", "Casa", "Casa Eduarda", "-Apartamento")
            }),
    E2(2, "Guaramiranga",
            new SocialDay[]{
                    new SocialDay("01/09/2023", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi"),
                    new SocialDay("02/09/2023", "-Iguatemi", "Apartamento", "Casa", "Guaramiranga", "Mirante 360", "Pague Menos", "Casa", "Iguatemi", "Apartamento"),
                    new SocialDay("03/09/2023", "-Apartamento", "Casa", "Órbita Blue", "Casa", "Apartamento", "Iguatemi", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E3(3, "Palhano",
            new SocialDay[]{
                    new SocialDay("08/09/2023", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("09/09/2023", "-Apartamento", "Casa", "Palhano", "Majorlandia", "Palhano"),
                    new SocialDay("10/09/2023", "-Palhano", "Casa", "Casa Eduarda", "-Casa")
            }),
    E4(4, "O McDonald's",
            new SocialDay[]{
                    new SocialDay("23/09/2023", "-Casa", "Casa Eduarda", "Taíba", "Apartamento", "Iguatemi", "McDonald's (Dom Luiz)", "Apartamento", "Spa Urbano"),
                    new SocialDay("24/09/2023", "-Spa Urbano", "Apartamento", "Iguatemi", "Apartamento", "Praia de Iracema", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa Christian/Valdiane", "-Casa")
            }),
    E5(5, "A Saída Escondida",
            new SocialDay[]{
                    new SocialDay("28/09/2023", "-Casa", "-North Shopping", "Casa Eduarda", "Apartamento"),
                    new SocialDay("29/09/2023", "-Apartamento", "Monsenhor Tabosa", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E6(6, "O Primeiro Jogo",
            new SocialDay[]{
                    new SocialDay("06/10/2023", "-Casa", "Casa Eduarda", "Apartamento", "São Luiz", "Iguatemi"),
                    new SocialDay("07/10/2023", "-Iguatemi", "Apartamento", "Krone", "Smart Fit", "Iguatemi", "Apartamento", "Casa", "Apartamento"),
                    new SocialDay("08/10/2023", "-Apartamento", "Krone", "Apartamento", "Castelão (América MG)", "Tio Lanches", "Apartamento", "-Casa"),
                    new SocialDay("09/10/2023", "-Casa", "Krone", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E7(7, "IMAX",
            new SocialDay[]{
                    new SocialDay("14/10/2023", "-Casa", "Casa Eduarda", "Smart Fit", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("15/10/2023", "-Apartamento", "Krone", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E8(8, "Cangaracers",
            new SocialDay[]{
                    new SocialDay("19/10/2023", "-Casa", "Casa Eduarda", "Taíba", "Pecém"),
                    new SocialDay("20/10/2023", "-Pecém", "Casa Eduarda", "-Casa")
            }),
    E9(9, "Pré-Uruguai",
            new SocialDay[]{
                    new SocialDay("25/10/2023", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "McDonald's", "Apartamento"),
                    new SocialDay("26/10/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("27/10/2023", "-Apartamento", "Casa", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E10(10, "Uma Derrota no Castelão",
            new SocialDay[]{
                    new SocialDay("03/11/2023", "-Casa", "-Iguatemi (Fábio)", "Casa Eduarda", "Casa"),
                    new SocialDay("04/11/2023", "-Casa", "Super Gentilândia", "Casa", "Apartamento", "Krone", "Apartamento", "Monsenhor Tabosa", "Smart Fit", "Iguatemi", "Apartamento", "Casa"),
                    new SocialDay("05/11/2023", "-Casa", "Apartamento", "Krone", "Apartamento", "Castelão (Flamengo)", "Iguatemi", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E11(11, "Universal Park",
            new SocialDay[]{
                    new SocialDay("15/11/2023", "-Casa", "Casa Eduarda", "Apartamento"),
                    new SocialDay("16/11/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento", "Krone", "Apartamento"),
                    new SocialDay("17/11/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento", "Universal Park", "Apartamento"),
                    new SocialDay("18/11/2023", "-Apartamento", "Smart Fit", "Apartamento", "Praia de Iracema", "São Luiz", "Apartamento"),
                    new SocialDay("19/11/2023", "-Apartamento", "Krone", "Mucuripe", "São Luiz", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E12(12, "Beach Park",
            new SocialDay[]{
                    new SocialDay("24/11/2023", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("25/11/2023", "-Apartamento", "Smart Fit", "Pague Menos", "Apartamento", "Casa", "Iguatemi", "Apartamento", "Casa"),
                    new SocialDay("26/11/2023", "-Apartamento", "São Luiz", "Beach Park", "São Luiz", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E13(13, "Kosmica Bar",
            new SocialDay[]{
                    new SocialDay("08/12/2023", "-Casa", "Casa Eduarda", "Apartamento", "São Luiz", "Smart Fit", "São Luiz", "Apartamento"),
                    new SocialDay("09/12/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento", "Praia de Iracema", "Apartamento", "Kosmica"),
                    new SocialDay("10/12/2023", "-Kosmica", "Pague Menos", "Apartamento", "Krone", "Apartamento", "Mucuripe", "Krone", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E14(14, "Pré-Reveillon",
            new SocialDay[]{
                    new SocialDay("15/12/2023", "-Casa", "Casa Eduarda", "Apartamento"),
                    new SocialDay("16/12/2023", "-Apartamento", "São Luiz", "Smart Fit", "Loja de Roupa", "RioMar", "São Luiz", "Apartamento", "Kosmica"),
                    new SocialDay("17/12/2023", "-Kosmica", "Apartamento", "Unimed", "Apartamento"),
                    new SocialDay("18/12/2023", "-Apartamento", "Krone", "Apartamento", "Shopping Benfica", "Casa", "Apartamento", "Smart Fit", "Pague Menos", "Casa Tia Eduarda", "Apartamento"),
                    new SocialDay("19/12/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Mercado Pinheiro", "Apartamento", "Pague Menos", "Apartamento", "Mucuripe", "Apartamento"),
                    new SocialDay("20/12/2023", "-Apartamento", "São Luiz", "Apartamento", "Smart Fit", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E15(15, "Réveillon com Eduarda, Gabriel e Lucas",
            new SocialDay[]{
                    new SocialDay("30/12/2023", "-Casa", "-Apartamento", "Casa Eduarda", "Atacadão", "Apartamento", "Casa", "Iguatemi", "Apartamento", "Kosmica"),
                    new SocialDay("31/12/2023", "-Kosmica", "Y'all", "Apartamento", "São Luiz", "Apartamento", "Praia de Iracema"),
                    new SocialDay("01/01/2024", "-Praia de Iracema", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E16(16, "Quebrando Tabus no Primeiro de 2024",
            new SocialDay[]{
                    new SocialDay("12/01/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento", "Smart Fit", "Apartamento", "El Chancho"),
                    new SocialDay("13/01/2024", "-El Chancho", "Apartamento", "Iguatemi", "Smart Fit", "Iguatemi", "Kosmica"),
                    new SocialDay("14/01/2024", "-Kosmica", "Route", "Apartamento", "Casa Eduarda", "Pecém", "Casa Eduarda", "-Apartamento")
            }),
    E17(17, "UPA, Lanterna de Choque e Relógios",
            new SocialDay[]{
                    new SocialDay("19/01/2024", "-Casa", "-Apartamento", "-Smart Fit", "-Shopping Benfica", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("20/01/2024", "-Apartamento", "São Luiz", "Smart Fit", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("21/01/2024", "-Apartamento", "Iguatemi", "UPA", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E18(18, "Os 10 Dias",
            new SocialDay[]{
                    new SocialDay("24/01/2024", "-Casa", "-Smart Fit", "Casa Eduarda", "Sitio Pai Croatá", "Apartamento", "Dentista", "Apartamento", "Mucuripe", "Apartamento"),
                    new SocialDay("25/01/2024", "-Apartamento", "Pherboyre", "Carneiro do Ordones", "Pherboyre", "Dr David Sucupira", "Unimed", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("26/01/2024", "-Apartamento", "Krone", "Praia de Iracema", "São Luiz", "Apartamento", "Smart Fit", "Iguatemi", "Casa"),
                    new SocialDay("27/01/2024", "-Casa", "Smart Fit", "Iguatemi", "Apartamento", "Route"),
                    new SocialDay("28/01/2024", "-Route", "Level", "Apartamento", "Del Passeo (Uv Action)", "Casa Luciano", "Iguatemi", "Casa", "Apartamento"),
                    new SocialDay("29/01/2024", "-Apartamento", "Pherboyre", "Apartamento", "Iguatemi", "Apartamento", "Mucuripe", "Casa"),
                    new SocialDay("30/01/2024", "-Casa", "Apartamento", "Iguatemi", "Karlla Sobrancelhas", "Apartamento", "Smart Fit", "Casa"),
                    new SocialDay("31/01/2024", "-Casa", "Apartamento", "Smart Fit", "Apartamento", "Iguatemi", "Castelão (Ceará)", "Mucuripe", "Praia de Iracema", "Apartamento"),
                    new SocialDay("01/02/2024", "-Apartamento", "Dentista", "Pague Menos", "São Luiz", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("02/02/2024", "-Apartamento", "Pherboyre", "Dentista", "Apartamento", "RioMar", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E19(19, "O Pós-Cirurgia",
            new SocialDay[]{
                    new SocialDay("17/02/2024", "Casa", "Castelão (Ceará)", "Casa"),
                    new SocialDay("18/02/2024", "-Casa")
            }),
    E20(20, "O Pré-Aniversário",
            new SocialDay[]{
                    new SocialDay("24/02/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("25/02/2024", "-Apartamento", "São Luiz", "Apartamento", "Casa", "Apartamento", "Casa Eduarda", "-Apartamento", "-McDonald's", "-Casa")
            }),
    E21(21, "A Semana do Aniversário",
            new SocialDay[]{
                    new SocialDay("29/02/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "-Uninassau", "Apartamento", "São Luiz", "Apartamento", "Smart Fit", "-Uninassau", "Smart Fit", "Apartamento"),
                    new SocialDay("01/03/2024", "-Apartamento", "Câmara Municipal", "Iguatemi", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("02/03/2024", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("03/03/2024", "-Apartamento", "Krone", "Praia de Iracema", "Mucuripe", "Praia de Iracema", "Apartamento", "Praia de Iracema", "Apartamento", "Coco Bambu", "Apartamento"),
                    new SocialDay("04/03/2024", "-Apartamento", "-Uninassau", "-Apartamento", "Gráu Técnico", "Conceito Auto Shopping", "Iguatemi", "Apartamento", "Smart Fit", "Pague Menos", "Apartamento"),
                    new SocialDay("05/03/2024", "-Apartamento", "-Uninassau", "Apartamento", "Smart Fit", "Shopping Benfica", "Apartamento", "Praia de Iracema", "Mucuripe"),
                    new SocialDay("06/03/2024", "-Mucuripe", "Apartamento", "-Uninassau", "Apartamento", "Yakichina Sul", "Apartamento", "Mucuripe", "ILLA MARE", "Apartamento", "Coco Bambu"),
                    new SocialDay("07/03/2024", "-Coco Bambu", "Apartamento", "Smart Fit", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E22(22, "Primeira Vez Dormindo Na Casa Dela",
            new SocialDay[]{
                    new SocialDay("15/03/2024", "-Casa", "-Mundo Verde", "Casa Eduarda", "Dois Estilos", "Mercado Mãe Rainha", "Casa Eduarda"),
                    new SocialDay("16/03/2024", "-Casa Eduarda", "Oceânica", "Pague Menos", "Restaurante Bom Paladar", "Casa Eduarda", "Paracuru", "Casa Eduarda"),
                    new SocialDay("17/03/2024", "-Casa Eduarda", "-Casa")
            }),
    E23(23, "Uma Noite em um Hotel",
            new SocialDay[]{
                    new SocialDay("22/03/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "Iguatemi", "Loja", "Apartamento", "Mucuripe", "Pague Menos", "Apartamento", "Algarve Praia Hotel"),
                    new SocialDay("23/03/2024", "-Algarve Praia Hotel", "Apartamento", "Praia de Iracema", "Apartamento", "Castelão (Vitória)", "Apartamento"),
                    new SocialDay("24/03/2024", "-Apartamento", "Barraca Terra Brasilis", "Apartamento", "Mucuripe", "Krone", "Apartamento"),
                    new SocialDay("25/03/2024", "-Apartamento", "Krone", "Apartamento", "Casa Eduarda"),
                    new SocialDay("26/03/2024", "-Casa Eduarda", "-Apartamento", "-Uninassau", "-Apartamento", "-Casa")
            }),
    E24(24, "Campeonato Cearense e Tatuagem",
            new SocialDay[]{
                    new SocialDay("04/04/2024", "-Casa", "-Apartamento", "-Uninassau", "-Apartamento", "Casa Eduarda", "Krone", "Apartamento", "Smart Fit", "Pague Menos", "Apartamento"),
                    new SocialDay("05/04/2024", "-Apartamento", "Mucuripe", "Apartamento", "Câmara Municipal", "Iguatemi", "Apartamento", "Smart Fit", "Apartamento", "Iguatemi"),
                    new SocialDay("06/04/2024", "-Iguatemi", "Apartamento", "Castelão (Ceará)", "Apartamento", "Tatuagem"),
                    new SocialDay("07/04/2024", "-Tatuagem", "Apartamento", "Praia de Iracema", "Apartamento", "Irmã Eduarda"),
                    new SocialDay("08/04/2024", "-Irmã Eduarda", "Apartamento", "Dentista", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E25(25, "Pré-Curso",
            new SocialDay[]{
                    new SocialDay("14/04/2024", "-Casa", "-Apartamento", "Casa Eduarda", "São Luiz", "Apartamento", "Iguatemi", "RioMar", "São Luiz", "Apartamento", "Praia de Iracema", "Krone", "Apartamento"),
                    new SocialDay("15/04/2024", "-Apartamento", "Câmara Municipal", "Pague Menos", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E26(26, "Pós Curso e Rolê com Mariana e Greice",
            new SocialDay[]{
                    new SocialDay("19/04/2024", "-Casa", "-Pague Menos", "Grau Técnico", "Apartamento", "Iguatemi", "Banco do Nordeste", "Câmara Municipal", "Pague Menos", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("20/04/2024", "-Apartamento", "Teresa & Jorge", "Apartamento"),
                    new SocialDay("21/04/2024", "-Apartamento", "Praia de Iracema", "Apartamento", "Castelão (Altos)", "Krone", "Apartamento"),
                    new SocialDay("22/04/2024", "-Apartamento", "Grau Técnico", "-Uninassau", "-Apartamento", "-Casa")
            }),
    E27(27, "O Pai da Eduarda",
            new SocialDay[]{
                    new SocialDay("23/04/2024", "-Casa", "IML", "São Luiz", "IML", "-Casa")
            }),
    E28(28, "Mercado Central",
            new SocialDay[]{
                    new SocialDay("29/04/2024", "-Casa", "-Pague Menos", "-Super Gentilândia", "Grau Técnico", "Casa", "Grau Técnico", "Mercado Central", "IML", "Casa Eduarda", "-Casa")
            }),
    E29(29, "Lucas e Eduarda",
            new SocialDay[]{
                    new SocialDay("30/04/2024", "-Casa", "IML", "Mercado Central", "Apartamento", "Praia de Iracema", "Apartamento", "-Casa")
            }),
    E30(30, "O Dia 100",
            new SocialDay[]{
                    new SocialDay("10/05/2024", "-Casa", "Casa Eduarda", "Apartamento", "Krone", "São Luiz", "Casas Girão", "Apartamento", "Iguatemi", "Apartamento", "Tatuagem", "Coco Bambu", "Pague Menos", "Apartamento"),
                    new SocialDay("11/05/2024", "-Apartamento", "Praia de Iracema", "Apartamento", "São Luiz", "Teresa & Jorge", "Praia de Iracema", "Apartamento", "Praia de Iracema"),
                    new SocialDay("12/05/2024", "-Praia de Iracema", "Apartamento", "Casa", "Apartamento", "Hotel Ibis", "Casa Lucas", "Taíba", "Casa Lucas", "Casa Eduarda", "-Casa Dona Maria", "-Castelão (Botafogo)", "-Cabana", "-Casa")
            }),
    E31(31, "Dia no Apartamento",
            new SocialDay[]{
                    new SocialDay("13/05/2024", "-Casa", "-Apartamento", "-Casas Girão", "-Fortaleza Esporte Clube", "-Apartamento", "Grau Técnico", "Apartamento", "Krone", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E32(32, "Kosmica com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("17/05/2024", "-Casa", "-Apartamento", "-Mercado Pinheiro", "Apartamento", "Kosmica"),
                    new SocialDay("18/05/2024", "-Kosmica", "Y'all", "Apartamento", "Praia de Iracema", "Mucuripe", "Rua São Luiz (Evento)", "Apartamento", "Rua São Luiz (Evento)", "Apartamento", "Kosmica", "Apartamento", "Kosmica"),
                    new SocialDay("19/05/2024", "-Kosmica", "Apartamento", "-Casa")
            }),
    E33(33, "Dias de Refúgio",
            new SocialDay[]{
                    new SocialDay("28/05/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Krone", "Apartamento"),
                    new SocialDay("29/05/2024", "-Apartamento", "São Luiz", "Grau Técnico", "Casa", "Grau Técnico", "Apartamento", "Smart Fit", "Apartamento", "Castelão (Sportivo Trinidense)", "Coco Bambu"),
                    new SocialDay("30/05/2024", "-Coco Bambu", "Apartamento", "São Luiz", "Apartamento", "Krone", "Praia de Iracema", "Apartamento", "Kosmica", "Apartamento", "Castello"),
                    new SocialDay("31/05/2024", "-Castello", "Kosmica", "Apartamento", "Praia de Iracema", "Apartamento", "North Shopping Jóquei", "Apartamento"),
                    new SocialDay("01/06/2024", "-Apartamento", "Iguatemi"),
                    new SocialDay("02/06/2024", "-Iguatemi", "Casa", "Super Gentilândia", "Casa", "Apartamento", "Coco Bambu Coffee", "Casa", "Arena PV", "Casa", "Apartamento", "Praia de Iracema", "Brazão", "Apartamento"),
                    new SocialDay("03/06/2024", "-Apartamento", "Shopping Benfica", "Dentista", "Fortaleza Esporte Clube", "Pague Menos", "Apartamento", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E34(34, "Espera de um Ônibus",
            new SocialDay[]{
                    new SocialDay("05/06/2024", "-Casa", "-Apartamento", "Grau Técnico", "-Casa")
            }),
    E35(35, "Um Almoço no Ordones",
            new SocialDay[]{
                    new SocialDay("07/06/2024", "-Casa", "Grau Técnico", "Ordones", "Terminal Antônio Bezerra", "-Casa")
            }),
    E36(36, "Buscando para Aula",
            new SocialDay[]{
                    new SocialDay("14/06/2024", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "Centro", "Conserto Celular", "Coco Bambu", "Apartamento", "Casa", "Terminal Antônio Bezerra", "-Casa")
            }),
    E37(37, "Laje com Eduarda e Gabriel",
            new SocialDay[]{
                    new SocialDay("15/06/2024", "Casa", "Laje"),
                    new SocialDay("16/06/2024", "-Laje", "Casa", "Apartamento", "Praia de Iracema", "Apartamento", "-Casa")
            }),
    E38(38, "Pós Apresentação",
            new SocialDay[]{
                    new SocialDay("17/06/2024", "-Casa", "Grau Técnico", "-Casa")
            }),
    E39(39, "Pegando o Celular",
            new SocialDay[]{
                    new SocialDay("19/06/2024", "-Casa", "Grau Técnico", "Casa", "Grau Técnico", "Conserto Celular", "Terminal Antônio Bezerra", "-Casa")
            }),
    E40(40, "São João e Beach Park",
            new SocialDay[]{
                    new SocialDay("21/06/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Grau Técnico", "Casa", "Grau Técnico", "Apartamento", "Sobrancelha", "Smart Fit", "Iguatemi", "Apartamento"),
                    new SocialDay("22/06/2024", "-Apartamento", "Iguatemi", "Apartamento", "ACMP"),
                    new SocialDay("23/06/2024", "-ACMP", "Apartamento", "Praia de Iracema", "Apartamento", "Beach Park", "Cometa", "Apartamento")
            }),
    E41(41, "Bolo de Milho",
            new SocialDay[]{
                    new SocialDay("24/06/2024", "-Apartamento", "-São Luiz", "Grau Técnico", "Apartamento", "Grau Técnico", "Terminal Antônio Bezerra", "-Casa")
            }),
    E42(42, "Encontro Pós Mudanças",
            new SocialDay[]{
                    new SocialDay("03/07/2024", "-Casa", "Casa Eduarda", "Ibis", "Grau Técnico", "-Casa", "-VRT Race Team", "-Apartamento", "Grau Técnico", "Centro", "Centro Fashion", "Fortaleza Esporte Clube", "Câmara Municipal", "Iguatemi", "Terminal Antônio Bezerra", "Ibis", "-Casa")
            }),
    E43(43, "Evento Pixar",
            new SocialDay[]{
                    new SocialDay("06/07/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Shopping Benfica", "Apartamento", "Praia de Iracema", "Mercado Pinheiro", "Praia de Iracema", "Apartamento", "Iguatemi", "Apartamento", "Praia de Iracema"),
                    new SocialDay("07/07/2024", "-Praia de Iracema", "Apartamento", "Terminal Antônio Bezerra", "-Castelão (Fluminense)", "-Apartamento")
            }),
    E44(44, "UPA e Tintas",
            new SocialDay[]{
                    new SocialDay("08/07/2024", "-Apartamento", "Grau Técnico", "Casa", "Grau Técnico", "UPA (UPA C)", "Shopping Benfica", "Fortaleza Tintas", "Terminal Antônio Bezerra", "-Casa")
            }),
    E45(45, "Boombox e Tintas",
            new SocialDay[]{
                    new SocialDay("10/07/2024", "-Casa", "Grau Técnico", "Shopping Benfica", "Casa", "Fortaleza Tintas", "Terminal Antônio Bezerra", "-Casa")
            }),
    E46(46, "Um Café da Manhã no MonteCarlo",
            new SocialDay[]{
                    new SocialDay("12/07/2024", "-Casa", "Grau Técnico", "MonteCarlo", "Terminal Antônio Bezerra", "-Casa")
            }),
    E47(47, "Ida ao Neurologista",
            new SocialDay[]{
                    new SocialDay("14/07/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "Centro de Eventos", "MonteCarlo", "Apartamento"),
                    new SocialDay("15/07/2024", "-Apartamento", "Iguatemi", "Neurologista", "Smart Fit", "Iguatemi", "Apartamento"),
                    new SocialDay("16/07/2024", "-Apartamento", "Iguatemi", "Smart Fit", "MonteCarlo", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("17/07/2024", "-Apartamento", "Galo Cego", "Centro", "Shopping Benfica", "Centro", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E48(48, "O Halleluya",
            new SocialDay[]{
                    new SocialDay("18/07/2024", "-Casa", "Halleluya"),
                    new SocialDay("19/07/2024", "-Halleluya", "-Casa")
            }),
    E49(49, "Ressonância, Exames e Aniversário",
            new SocialDay[]{
                    new SocialDay("29/07/2024", "-Casa", "-Apartamento", "Oceânica", "Mangiare", "Casa Eduarda", "Apartamento", "Praia de Iracema", "Pague Menos", "Apartamento"),
                    new SocialDay("30/07/2024", "-Apartamento", "Boghos", "Apartamento", "Boghos", "Centro Fashion", "Apartamento", "Smart Fit", "MonteCarlo", "Apartamento"),
                    new SocialDay("31/07/2024", "-Apartamento", "North Shopping Jóquei", "Iguatemi", "Centro Fashion", "Apartamento", "Smart Fit", "Iguatemi", "Apartamento"),
                    new SocialDay("01/08/2024", "-Apartamento", "Krone", "Praia de Iracema", "Mucuripe", "Apartamento", "Smart Fit", "Iguatemi", "Apartamento", "Praia de Iracema", "Mucuripe", "Praia de Iracema"),
                    new SocialDay("02/08/2024", "-Praia de Iracema", "Iguatemi", "Boghos", "Centro", "Apartamento", "Iguatemi", "Apartamento", "-Posto", "Apartamento"),
                    new SocialDay("03/08/2024", "-Apartamento", "Neurologista", "Apartamento", "Krone", "Apartamento", "Casa", "Shopping Benfica", "Casa", "Apartamento", "Mercado Pinheiro", "Apartamento", "Laje"),
                    new SocialDay("04/08/2024", "-Laje", "Apartamento", "Praia de Iracema", "Apartamento", "UPA", "IJF", "Apartamento", "Iguatemi", "Apartamento", "Picanha do Jonas", "Casa", "Apartamento"),
                    new SocialDay("05/08/2024", "-Apartamento", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E50(50, "Presente Dia dos Pais e Camisas",
            new SocialDay[]{
                    new SocialDay("07/08/2024", "-Casa", "Grau Técnico", "Iguatemi", "Terminal Antônio Bezerra", "-Casa")
            }),
    E51(51, "Intervalo e Ajeitar Calça",
            new SocialDay[]{
                    new SocialDay("09/08/2024", "-Casa", "Grau Técnico", "-Shopping Benfica", "-Casa", "-Shopping Benfica", "Grau Técnico", "-Casa")
            }),
    E52(52, "Filme no North Shopping",
            new SocialDay[]{
                    new SocialDay("10/08/2024", "-Casa", "North Shopping", "-Castelão (Criciúma)", "-Casa")
            }),
    E53(53, "Follow The Sun",
            new SocialDay[]{
                    new SocialDay("14/08/2024", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "Smart Fit", "-Apartamento", "-Casa", "MonteCarlo", "Apartamento", "Follow The Sun"),
                    new SocialDay("15/08/2024", "-Follow The Sun", "Apartamento", "Iguatemi", "Apartamento", "Pague Menos"),
                    new SocialDay("16/08/2024", "-Pague Menos", "Apartamento", "Terminal Antônio Bezerra", "-Apartamento", "-Casa")
            }),
    E54(54, "Curso Pós Grandes Mudanças",
            new SocialDay[]{
                    new SocialDay("21/08/2024", "-Casa", "Grau Técnico", "-Casa")
            }),
    E55(55, "Fim de Semana de UP",
            new SocialDay[]{
                    new SocialDay("31/08/2024", "-Casa", "Casa Eduarda", "Centro Fashion", "Mercado Pinheiro", "Apartamento", "Pague Menos", "Apartamento", "Laje", "Benfica"),
                    new SocialDay("01/09/2024", "-Benfica", "Casa", "Benfica", "-Casa", "-Benfica", "Apartamento", "Taíba", "Casa Eduarda", "-Casa")
            }),
    E56(56, "Ida Surpresa no Curso",
            new SocialDay[]{
                    new SocialDay("02/09/2024", "-Casa", "Grau Técnico", "-Casa")
            }),
    E57(57, "Almoço no Dom Espeto",
            new SocialDay[]{
                    new SocialDay("04/09/2024", "-Casa", "Grau Técnico", "Dom Espeto", "Apartamento", "Salão de Beleza", "Terminal Antônio Bezerra", "-Casa")
            }),
    E58(58, "Ultrassom das Pernas",
            new SocialDay[]{
                    new SocialDay("06/09/2024", "-Casa", "-Santa Branca", "Grau Técnico", "Boghos", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E59(59, "DJ com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("07/09/2024", "-Casa", "Casa Eduarda", "Casa Lucas", "Apartamento", "Casa", "Shopping Benfica", "Apartamento", "Shopping Benfica", "Apartamento", "Praia de Iracema", "Pinheiro", "Apartamento", "Benfica", "-Casa", "-Benfica"),
                    new SocialDay("08/09/2024", "-Benfica", "Mucuripe", "Apartamento", "Casa", "Apartamento", "-Casa", "-Apartamento", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E60(60, "Almoço e Descanso no AP",
            new SocialDay[]{
                    new SocialDay("11/09/2024", "-Casa", "Grau Técnico", "Dom Espeto", "Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E61(61, "Era pra ser a Última Volta na z1000",
            new SocialDay[]{
                    new SocialDay("18/09/2024", "-Casa", "Grau Técnico", "Iguatemi", "Terminal Antônio Bezerra", "-Casa")
            }),
    E62(62, "Tatuagem e Castelão Sem Ela",
            new SocialDay[]{
                    new SocialDay("21/09/2024", "-Casa", "Casa Eduarda", "Apartamento", "Casa", "Pague Menos", "Apartamento", "Iguatemi", "Tatuagem", "-Casa", "-Castelão (Bahia)", "-Casa"),
                    new SocialDay("22/09/2024", "-Casa", "-Apartamento", "-Tatuagem", "Pague Menos", "Apartamento", "Terminal Antônio Bezerra", "-Apartamento", "-Casa")
            }),
    E63(63, "Primeira Volta na s1000",
            new SocialDay[]{
                    new SocialDay("27/09/2024", "-Casa", "Grau Técnico", "Pague Menos", "Grau Técnico", "-Casa", "Grau Técnico", "North Shopping Jóquei", "Terminal Antônio Bezerra", "-Casa Lenon", "-Casa")
            }),
    E64(64, "s1000 na Rodovia e Route",
            new SocialDay[]{
                    new SocialDay("28/09/2024", "-Casa", "Casa Eduarda", "São Gonçalo do Amarante", "Iguatemi", "Apartamento", "Route"),
                    new SocialDay("29/09/2024", "-Route", "Apartamento", "-Casa")
            }),
    E65(65, "Um Almoço no North Shopping",
            new SocialDay[]{
                    new SocialDay("30/09/2024", "-Casa", "Grau Técnico", "Shopping Benfica", "North Shopping", "Terminal Antônio Bezerra", "-Casa")
            }),
    E66(66, "Um Almoço no Apartamento e Roupas",
            new SocialDay[]{
                    new SocialDay("02/10/2024", "-Casa", "-Shopping Benfica", "Grau Técnico", "Apartamento", "Benfica", "Terminal Antônio Bezerra", "-Casa")
            }),
    E67(67, "Cardiologista e Açaí",
            new SocialDay[]{
                    new SocialDay("04/10/2024", "-Casa", "Casa Eduarda", "Apartamento", "-Grau Técnico", "-Apartamento", "Pague Menos", "North Shopping Jóquei", "Apartamento"),
                    new SocialDay("05/10/2024", "-Apartamento", "Veleiro Piatã", "Praia de Iracema", "Mucuripe", "Pague Menos", "Praia de Iracema", "Apartamento", "Lugarzinho", "Praia de Iracema", "Mucuripe", "Casa", "Apartamento"),
                    new SocialDay("06/10/2024", "-Apartamento", "Casa Eduarda", "São Gonçalo do Amarante", "-Casa")
            }),
    E68(68, "Presente pro Lucas",
            new SocialDay[]{
                    new SocialDay("11/10/2024", "-Casa", "Grau Técnico", "Clarindo de Queiroz", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E69(69, "Aniversário do Lucas na Route",
            new SocialDay[]{
                    new SocialDay("12/10/2024", "-Casa", "Casa Eduarda", "São Gonçalo do Amarante", "Casa Lucas", "Ibis", "Mercado Pinheiro", "Apartamento", "-Casa", "-Apartamento", "Praia de Iracema", "Apartamento", "Route"),
                    new SocialDay("13/10/2024", "-Route", "Apartamento", "Praia de Iracema", "Apartamento", "-Casa")
            }),
    E70(70, "Reforma da Tatuagem",
            new SocialDay[]{
                    new SocialDay("17/10/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Monsenhor Tabosa", "Apartamento", "Tatuagem", "Pague Menos", "Apartamento"),
                    new SocialDay("18/10/2024", "-Apartamento", "Mercado Pinheiro", "Grau Técnico", "-Apartamento", "-Conceito Auto Shopping", "-Grau Técnico", "Terminal Antônio Bezerra", "-Casa")
            }),
    E71(71, "Almoço Rápido no Dom Espeto",
            new SocialDay[]{
                    new SocialDay("21/10/2024", "-Casa", "Grau Técnico", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E72(72, "Entrega de Papel e Almoço",
            new SocialDay[]{
                    new SocialDay("25/10/2024", "-Casa", "Grau Técnico", "-Casa", "Grau Técnico", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E73(73, "Tênis e Raquete Nova",
            new SocialDay[]{
                    new SocialDay("28/10/2024", "-Casa", "-Detran", "Grau Técnico", "North Shopping", "Terminal Antônio Bezerra", "-Casa")
            }),
    E74(74, "Planejamento para Aniversário José Renan",
            new SocialDay[]{
                    new SocialDay("30/10/2024", "-Casa", "Grau Técnico", "Terminal Antônio Bezerra", "-Casa")
            }),
    E75(75, "Um Halloween com Maquiagem",
            new SocialDay[]{
                    new SocialDay("01/11/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Apartamento", "Dentista", "Pague Menos", "Apartamento", "Iguatemi", "Apartamento", "-Casa", "-Apartamento", "Route", "Apartamento"),
                    new SocialDay("02/11/2024", "-Apartamento"),
                    new SocialDay("03/11/2024", "-Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E76(76, "Entrega de Camisa Jovem Dinâmico",
            new SocialDay[]{
                    new SocialDay("08/11/2024", "-Casa", "Grau Técnico", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E77(77, "Um Almoço de Niver da minha Mãe",
            new SocialDay[]{
                    new SocialDay("11/11/2024", "-Casa", "Grau Técnico", "Centro", "Grau Técnico", "-Casa", "-Prontoclinica", "-Casa", "Grau Técnico", "Suplementos", "Casa", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E78(78, "Presente para Mãe 2024",
            new SocialDay[]{
                    new SocialDay("13/11/2024", "-Casa", "Centro", "Iguatemi", "Terminal Antônio Bezerra", "-Casa")
            }),
    E79(79, "Universal Park com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("16/11/2024", "-Casa", "North Shopping", "Apartamento", "Abolição", "Apartamento", "Universal Park", "Apartamento"),
                    new SocialDay("17/11/2024", "-Apartamento", "Casa", "-Apartamento", "Pague Menos", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E80(80, "Benfica com Irmã da Eduarda",
            new SocialDay[]{
                    new SocialDay("23/11/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Apartamento", "Salão de Beleza", "Apartamento", "Benfica", "Praia de Iracema"),
                    new SocialDay("24/11/2024", "-Praia de Iracema", "-Apartamento", "Praia de Iracema", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E81(81, "Café da Manhã no MonteCarlo e Dentista",
            new SocialDay[]{
                    new SocialDay("25/11/2024", "-Casa", "Grau Técnico", "MonteCarlo", "Apartamento", "Dentista", "Terminal Antônio Bezerra", "-Casa")
            }),
    E82(82, "Continuação da Tatuagem",
            new SocialDay[]{
                    new SocialDay("27/11/2024", "-Casa", "Grau Técnico", "MonteCarlo", "Apartamento", "Tatuagem", "Terminal Antônio Bezerra", "-Casa")
            }),
    E83(83, "Continuação do Dentista",
            new SocialDay[]{
                    new SocialDay("29/11/2024", "-Casa", "Grau Técnico", "MonteCarlo", "Apartamento", "Dentista", "Terminal Antônio Bezerra", "-Casa")
            }),
    E84(84, "Virada de Noite no Apartamento Pré Beach Park",
            new SocialDay[]{
                    new SocialDay("31/11/2024", "-Casa", "Casa Lucas", "Apartamento"),
                    new SocialDay("01/12/2024", "-Apartamento", "Mucuripe", "Casa Lucas", "-Casa")
            }),
    E85(85, "Entrega de Declaração e Almoço",
            new SocialDay[]{
                    new SocialDay("02/12/2024", "-Casa", "Dentista", "Grau Técnico", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E86(86, "Café da Manhã em Casa",
            new SocialDay[]{
                    new SocialDay("04/12/2024", "-Casa", "Grau Técnico", "Aldeota", "Casa", "Super Gentilândia", "Terminal Antônio Bezerra", "-Grau Técnico", "-Casa")
            }),
    E87(87, "Porto das Dunas com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("08/12/2024", "-Casa", "Casa Lucas", "Apartamento", "São Luiz", "Porto das Dunas", "Apartamento", "Casa", "Casa Lucas", "-Casa")
            }),
    E88(88, "Almoço Pré João Pessoa",
            new SocialDay[]{
                    new SocialDay("11/12/2024", "-Casa", "Grau Técnico", "Dom Espeto", "Terminal Antônio Bezerra", "-Casa")
            }),
    E89(89, "Virada do Ano de 2025 com 7 Pessoas",
            new SocialDay[]{
                    new SocialDay("29/12/2024", "-Casa", "Casa Eduarda", "Apartamento", "Pão de Açúcar", "Apartamento", "Iguatemi", "Casa", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("30/12/2024", "-Apartamento", "Casa Lucas", "Apartamento", "Mercado Pinheiro", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("31/12/2024", "-Apartamento", "Praia de Iracema", "Apartamento", "Praia de Iracema"),
                    new SocialDay("01/01/2025", "-Praia de Iracema", "Apartamento", "Casa Lucas", "Apartamento", "Mucuripe", "Apartamento"),
                    new SocialDay("02/01/2025", "-Apartamento", "Casa Eduarda", "-Casa")
            }),
    E90(90, "Espera de Ônibus pós Deixar Moto",
            new SocialDay[]{
                    new SocialDay("06/01/2025", "-Casa", "Grau Técnico", "-Casa")
            }),
    E91(91, "Dentista Pós Conversa",
            new SocialDay[]{
                    new SocialDay("08/01/2025", "-Casa", "Grau Técnico", "-Casa", "Grau Técnico", "Dentista", "Terminal Antônio Bezerra", "-Casa")
            }),
    E92(92, "Espera de Ônibus no dia 10",
            new SocialDay[]{
                    new SocialDay("10/01/2025", "-Casa", "Grau Técnico", "-Casa")
            }),
    E93(93, "Saída com Eduarda e Lucas e Ida para Prova",
            new SocialDay[]{
                    new SocialDay("11/01/2025", "-Casa", "Casa Lucas", "Apartamento"),
                    new SocialDay("12/01/2025", "-Apartamento", "Casa Eduarda", "Taíba", "Casa Lucas", "Apartamento"),
                    new SocialDay("13/01/2025", "-Apartamento", "Grau Técnico", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E94(94, "Ida no Krone Pós Curso",
            new SocialDay[]{
                    new SocialDay("17/01/2025", "-Casa", "Grau Técnico", "Apartamento", "Krone", "Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E95(95, "Pós Formatura de Prima e 4 Idas",
            new SocialDay[]{
                    new SocialDay("19/01/2025", "-Casa", "São Gonçalo do Amarante", "Apartamento", "Casa Brena", "Casa Eduarda", "Casa Lucas", "Taíba", "Apartamento"),
                    new SocialDay("20/01/2025", "-Apartamento", "Casa Lucas", "Casa Eduarda", "Casa Lucas", "Apartamento", "-Casa", "-Apartamento", "-Casa", "-Apartamento", "Pague Menos", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E96(96, "Ida Rápida na Pague Menos Pós Curso",
            new SocialDay[]{
                    new SocialDay("22/01/2025", "-Casa", "Grau Técnico", "-Casa")
            }),
    E97(97, "Entrega de Documentos na Grau",
            new SocialDay[]{
                    new SocialDay("24/01/2025", "-Casa", "Grau Técnico", "-Casa", "Grau Técnico", "-Casa")
            }),
    E98(98, "Entrega de Camisa, Máscara e Compra de Capacete",
            new SocialDay[]{
                    new SocialDay("29/01/2025", "-Casa", "Grau Técnico", "-Clarindo de Queiroz", "-Casa")
            }),
    E99(99, "Pós Pintura da Moto e Curso",
            new SocialDay[]{
                    new SocialDay("01/02/2025", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "Centro", "Apartamento", "Iguatemi"),
                    new SocialDay("02/02/2025", "-Iguatemi", "Apartamento", "Órbita Blue", "Apartamento", "Casa Eduarda", "Mãe Rainha", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "Mãe Rainha", "Casa Lucas"),
                    new SocialDay("03/02/2025", "-Casa Lucas", "Casa Eduarda", "Apartamento", "-Casa", "-Apartamento", "Grau Técnico", "-Casa")
            }),
    E100(100, "Saída Pós Quase Afastamento",
            new SocialDay[]{
                    new SocialDay("15/02/2025", "-Casa", "Casa Eduarda", "Ibis", "Casa Tia Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("16/02/2025", "-Apartamento", "Praia de Iracema", "Mucuripe", "Praia de Iracema", "Apartamento", "Casa Eduarda", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E101(101, "Duas Idas a Praia, Interações e Lucas",
            new SocialDay[]{
                    new SocialDay("21/02/2025", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "Smart Fit", "Brazão", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("22/02/2025", "-Apartamento", "Praia de Iracema", "Apartamento", "-Casa", "-Apartamento", "Casa Lucas", "Apartamento"),
                    new SocialDay("23/02/2025", "-Apartamento", "Praia de Iracema", "Apartamento", "-Casa", "-Apartamento", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E102(102, "Cancelamento do Curso e Greenish",
            new SocialDay[]{
                    new SocialDay("27/02/2025", "-Casa", "Grau Técnico", "Shopping Benfica", "Praia de Iracema", "Terminal Antônio Bezerra", "-Casa")
            }),
    E103(103, "Meu Aniversário de 2025",
            new SocialDay[]{
                    new SocialDay("06/03/2025", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "-Casa", "-Apartamento", "-Iguatemi", "-Apartamento", "Coco Bambu", "Apartamento"),
                    new SocialDay("07/03/2025", "-Apartamento", "-Casa", "-Apartamento", "Casa Eduarda", "-Casa")
            }),
    E104(104, "Barragem e Pousada em São Gonçalo",
            new SocialDay[]{
                    new SocialDay("29/03/2025", "-Casa", "Bar da Tripa"),
                    new SocialDay("30/03/2025", "-Bar da Tripa", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "Barragem do Catolé", "Casa Lucas", "Farmácia Ultra Popular", "Casa Lucas", "Pousada Boro", "Casa Eduarda", "Pousada Boro"),
                    new SocialDay("31/03/2025", "-Pousada Boro", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E105(105, "Almoço antes de Filme do Minecraft no North Shopping",
            new SocialDay[]{
                    new SocialDay("02/04/2025", "-Casa", "North Shopping", "-Casa")
            }),
    E106(106, "Ida para Entrevista de Emprego",
            new SocialDay[]{
                    new SocialDay("03/04/2025", "-Casa", "Casa Tia Eduarda", "Escola Caucaia", "Casa Tia Eduarda", "-Casa")
            }),
    E107(107, "Ida Rápida no North Shopping",
            new SocialDay[]{
                    new SocialDay("06/04/2025", "-Casa", "North Shopping", "-Iguatemi", "-Casa")
            }),
    E108(108, "Ida para Piercing",
            new SocialDay[]{
                    new SocialDay("11/04/2025", "-Casa", "Casa Eduarda", "RioMar Kennedy", "MonteCarlo", "Centro", "Pague Menos", "Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E109(109, "Um Fim de Semana com Umbanda",
            new SocialDay[]{
                    new SocialDay("26/04/2025", "-Casa", "Apartamento", "São Luiz", "Apartamento", "Umbanda", "Apartamento", "Boêmias"),
                    new SocialDay("27/04/2025", "-Boêmias", "Vibe 085", "Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E110(110, "Show da Lady Gaga no Vibe 085",
            new SocialDay[]{
                    new SocialDay("02/05/2025", "-Casa", "Apartamento", "Laje"),
                    new SocialDay("03/05/2025", "-Laje", "Apartamento", "Vibe 085"),
                    new SocialDay("04/05/2025", "-Vibe 085", "Apartamento", "Praia de Iracema", "Apartamento", "Terminal Antônio Bezerra", "Casa")
            }),
    E111(111, "Saída no Dia das Mães",
            new SocialDay[]{
                    new SocialDay("10/05/2025", "-Casa", "Iguatemi"),
                    new SocialDay("11/05/2025", "-Iguatemi", "Apartamento", "Terminal Antônio Bezerra", "-Casa Tia Bruna", "-Casa")
            }),
    E112(112, "Ida para Novo Dentista",
            new SocialDay[]{
                    new SocialDay("14/05/2025", "-Casa", "North Shopping", "Torre Dentista", "Shopping Benfica", "-Casa")
            }),
    E113(113, "Fim de Semana e Laje com ida em Casa",
            new SocialDay[]{
                    new SocialDay("17/05/2025", "-Casa", "Apartamento", "Benfica", "Laje"),
                    new SocialDay("18/05/2025", "-Laje", "-Casa", "Benfica", "Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E114(114, "Shopping Benfica e Ida no Vibe",
            new SocialDay[]{
                    new SocialDay("24/05/2025", "-Casa", "Apartamento", "-Shopping Benfica", "-Casa", "-São Luiz", "-Apartamento", "Vibe 085"),
                    new SocialDay("25/05/2025", "-Vibe 085", "Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E115(115, "Ida para Psicoanalista na Semana",
            new SocialDay[]{
                    new SocialDay("03/06/2025", "-Casa", "-Apartamento", "Lavanderia", "São Luiz", "Lavanderia", "Apartamento"),
                    new SocialDay("04/06/2025", "-Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E116(116, "Segunda Ida para Palhano",
            new SocialDay[]{
                    new SocialDay("13/06/2025", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "-Casa", "-Apartamento", "-Centro", "Apartamento", "Palhano"),
                    new SocialDay("14/06/2025", "-Palhano", "Centro Palhano", "Palhano", "Restaurante La Familia", "Palhano"),
                    new SocialDay("15/06/2025", "-Palhano", "Apartamento", "-Iguatemi", "-Casa")
            }),
    E117(117, "Uma Ida a Ponte dos Ingleses",
            new SocialDay[]{
                    new SocialDay("20/06/2025", "-Casa", "North Shopping", "Apartamento"),
                    new SocialDay("21/06/2025", "-Apartamento", "Ponte dos Ingleses", "-Apartamento", "Ponte dos Ingleses", "Apartamento"),
                    new SocialDay("22/06/2025", "-Apartamento", "-Casa")
            }),
    E118(118, "Endoscopia e Dias no Apartamento",
            new SocialDay[]{
                    new SocialDay("06/07/2025", "-Casa", "Casa Eduarda", "Apartamento", "Casa"),
                    new SocialDay("07/07/2025", "-Casa", "Apartamento", "Psiquiatra", "Apartamento"),
                    new SocialDay("08/07/2025", "-Apartamento", "Prontoclinica", "Apartamento", "Smart Fit", "-Apartamento", "-Smart Fit", "Apartamento"),
                    new SocialDay("09/07/2025", "-Apartamento", "Smart Fit", "Apartamento", "Casa"),
                    new SocialDay("10/07/2025", "-Casa", "Apartamento", "-Psiquiatra", "-Unimed", "-Apartamento"),
                    new SocialDay("11/07/2025", "-Apartamento", "Casa Eduarda", "-Casa")
            }),
    E119(119, "Uma Ida Surpresa",
            new SocialDay[]{
                    new SocialDay("20/07/2025", "-Casa", "-Casa Lucas", "São Gonçalo do Amarante"),
                    new SocialDay("21/07/2025", "-São Gonçalo do Amarante", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "-Casa")
            }),
    E120(120, "As 2 Semanas do Aniversário",
            new SocialDay[]{
                    new SocialDay("23/07/2025", "-Casa", "Apartamento"),
                    new SocialDay("24/07/2025", "-Apartamento", "São Luiz", "-Conserto Carro", "-Casa", "Smart Fit", "Apartamento", "-Casa", "-Apartamento"),
                    new SocialDay("25/07/2025", "-Apartamento"),
                    new SocialDay("26/07/2025", "-Apartamento", "-Casa", "-Castelão", "-Casa", "-Apartamento"),
                    new SocialDay("27/07/2025", "-Apartamento", "-Casa"),
                    new SocialDay("28/07/2025", "-Casa", "Apartamento"),
                    new SocialDay("29/07/2025", "-Apartamento", "-Casa", "-Prontoclinica", "-Casa", "-Apartamento"),
                    new SocialDay("30/07/2025", "-Apartamento", "Shopping Benfica", "Centro", "Apartamento"),
                    new SocialDay("31/07/2025", "-Apartamento"),
                    new SocialDay("01/08/2025", "-Apartamento", "São Luiz", "Apartamento", "-Casa", "-Apartamento", "Iguatemi"),
                    new SocialDay("02/08/2025", "-Iguatemi", "Apartamento", "Mucuripe", "Apartamento"),
                    new SocialDay("03/08/2025", "-Apartamento", "-Shopping Benfica", "-Casa", "-Apartamento"),
                    new SocialDay("04/08/2025", "-Apartamento", "-Psiquiatra", "-Iguatemi", "-Apartamento", "-Mercado Pinheiro", "-São Luiz", "-Apartamento", "Vasto Restaurante", "Apartamento", "-Casa", "-Apartamento"),
                    new SocialDay("05/08/2025", "-Apartamento", "Ibis", "Casa Eduarda", "-Casa")
            }),
    E121(121, "Cancelamento da Smart Fit",
            new SocialDay[]{
                    new SocialDay("18/08/2025", "-Casa", "-CEATD", "Apartamento"),
                    new SocialDay("19/08/2025", "-Apartamento", "-Casa")
            }),
    E122(122, "Taíba de Madrugada",
            new SocialDay[]{
                    new SocialDay("25/08/2025", "-Casa", "Pecém", "Taíba"),
                    new SocialDay("26/08/2025", "-Taíba", "Casa Eduarda", "-Casa")
            }),
    E123(123, "Pós Não Dia de Curso",
            new SocialDay[]{
                    new SocialDay("30/08/2025", "-Casa", "Apartamento"),
                    new SocialDay("31/08/2025", "-Apartamento", "Praia de Iracema", "Apartamento", "Terminal Antônio Bezerra", "-Casa")
            }),
    E124(124, "Saída Pós Jogo Vitória",
            new SocialDay[]{
                    new SocialDay("13/09/2025", "-Casa", "Benfica", "-Casa", "-Castelão", "-Casa", "Apartamento"),
                    new SocialDay("14/09/2025", "-Apartamento", "-São Luiz", "-Apartamento", "-Casa")
            }),
    E125(125, "Fim de Semana com Jogo do Vitória",
            new SocialDay[]{
                    new SocialDay("25/09/2025", "-Casa", "Casa Eduarda", "Ibis"),
                    new SocialDay("26/09/2025", "-Ibis", "Apartamento", "Praia de Iracema", "Apartamento", "Fuzue Bar", "Apartamento"),
                    new SocialDay("27/09/2025", "-Apartamento", "-Casa", "-Castelão (Sport)", "-Casa", "-Apartamento", "Ibis", "Casa Eduarda", "-Casa")
            }),
    E126(126, "Um Planejamento de Cinema",
            new SocialDay[]{
                    new SocialDay("08/10/2025", "-Casa", "Apartamento", "Praia de Iracema", "Mucuripe", "Praia de Iracema", "Apartamento"),
                    new SocialDay("09/10/2025", "-Apartamento", "-Casa")
            }),
    E127(127, "Saída no Aniversário do Lucas e Isolamento",
            new SocialDay[]{
                    new SocialDay("11/10/2025", "-Casa", "Apartamento"),
                    new SocialDay("12/10/2025", "-Apartamento", "-Casa")
            }),
    E128(128, "Um Quase Halloween",
            new SocialDay[]{
                    new SocialDay("22/10/2025", "-Casa", "Casa Eduarda", "Apartamento"),
                    new SocialDay("23/10/2025", "-Apartamento", "Casa", "Iguatemi", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("24/10/2025", "-Apartamento", "-Clinica Unimed", "-Casa", "Apartamento", "Mercado Pinheiro", "Apartamento"),
                    new SocialDay("25/10/2025", "-Apartamento", "Praia de Iracema", "Apartamento", "-Casa", "-Castelão (Flamengo)", "-Casa", "Apartamento"),
                    new SocialDay("26/10/2025", "-Apartamento", "-Casa", "-Apartamento"),
                    new SocialDay("27/10/2025", "-Apartamento", "Casa Eduarda", "-Casa")
            }),
    E129(129, "Um Picnic no Porto das Dunas",
            new SocialDay[]{
                    new SocialDay("07/11/2025", "-Casa", "Ibis", "Apartamento", "São Luiz", "Apartamento"),
                    new SocialDay("08/11/2025", "-Apartamento"),
                    new SocialDay("09/11/2025", "-Apartamento", "Porto das Dunas", "Apartamento", "-Casa", "-Castelão (Grêmio)", "-Casa"),
                    new SocialDay("10/11/2025", "-Casa", "Apartamento"),
                    new SocialDay("11/11/2025", "-Apartamento", "Praia de Iracema", "Apartamento", "-Casa Luciano", "-Casa", "Apartamento"),
                    new SocialDay("12/11/2025", "-Apartamento", "Casa", "Casa Eduarda", "-Casa")
            }),
    E130(130, "Um Universal Park em 2025",
            new SocialDay[]{
                    new SocialDay("21/11/2025", "Casa"),
                    new SocialDay("22/11/2025", "-Casa", "Super Gentilândia", "Casa", "Iron Jungle", "-Casa", "Iron Jungle", "Shopping Benfica", "Casa", "Iguatemi"),
                    new SocialDay("23/11/2025", "-Iguatemi", "Casa", "Universal Park", "Casa", "Ibis"),
                    new SocialDay("24/11/2025", "-Ibis", "Casa Eduarda", "-Casa")
            }),
    E131(131, "Ida para o North Shopping para Entrega",
            new SocialDay[]{
                    new SocialDay("28/11/2025", "-Casa", "North Shopping", "-Casa")
            }),
    E132(132, "Show do Gabriel e Jogo Brasileirão",
            new SocialDay[]{
                    new SocialDay("06/12/2025", "-Casa", "-Pague Menos", "Casa Eduarda", "Ibis", "Casa"),
                    new SocialDay("07/12/2025", "-Casa", "Órbita Blue", "Casa", "Benfica", "Casa", "-RioMar Kennedy", "Casa Eduarda", "-Casa")
            }),
    E133(133, "Almoço no RioMar",
            new SocialDay[]{
                    new SocialDay("17/12/2025", "-Casa", "RioMar Kennedy", "-Casa")
            }),
    E134(134, "Natal de 2025",
            new SocialDay[]{
                    new SocialDay("23/12/2025", "-Casa", "Casa Eduarda"),
                    new SocialDay("24/12/2025", "-Casa Eduarda", "Apartamento", "-Casa", "-Apartamento", "RioMar", "Apartamento", "Casa", "Casa Luciano"),
                    new SocialDay("25/12/2025", "-Casa Luciano", "Casa", "Apartamento", "Casa Eduarda", "Casa Lucas", "Taíba"),
                    new SocialDay("26/12/2025", "-Taíba", "Pecém", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "São Gonçalo do Amarante", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E135(135, "Primeiro de 2026",
            new SocialDay[]{
                    new SocialDay("04/01/2026", "-Casa", "Apartamento", "Praia de Iracema", "Apartamento", "-Casa")
            }),
    E136(136, "Conhecendo o Lenon",
            new SocialDay[]{
                    new SocialDay("24/01/2026", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "-Casa", "-Apartamento", "Praia de Iracema", "São Luiz", "Apartamento", "Casa Tia Elenilda", "Apartamento", "Sitio Amigo Lenon"),
                    new SocialDay("25/01/2026", "-Sitio Amigo Lenon", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E137(137, "Um Clássico Rei", new SocialDay[]{
            new SocialDay("06/02/2026", "-Casa", "Casa Eduarda", "Shopping Benfica", "Apartamento"),
            new SocialDay("07/02/2026", "-Apartamento", "-Casa", "Apartamento"),
            new SocialDay("08/02/2026", "-Apartamento", "Casa", "Castelão (Ceará)", "Casa", "Apartamento"),
            new SocialDay("09/02/2026", "-Apartamento", "Shopping Benfica", "Casa Eduarda", "-Casa")
    }),
    E138(138, "Antes de um Possível Trabalho Dela", new SocialDay[]{
            new SocialDay("19/02/2026", "-Casa", "Apartamento", "São Luiz", "Apartamento"),
            new SocialDay("20/02/2026", "-Apartamento", "-Casa Luciano", "-Casa")
    }),
    E139(139, "Pós Aniversário 27 Anos", new SocialDay[]{
            new SocialDay("07/03/2026", "-Casa", "Trabalho Eduarda", "Casa Eduarda", "Taíba", "Ibis", "Apartamento", "Tatuagem Damas", "-Casa", "-Tatuagem Damas", "Apartamento", "-Casa", "-Apartamento"),
            new SocialDay("08/03/2026", "-Apartamento", "Casa Eduarda", "-Casa")
    }),
    E140(140, "Falta no Trabalho", new SocialDay[]{
            new SocialDay("10/04/2026", "-Casa", "Trabalho Eduarda", "Casa Eduarda"),
            new SocialDay("11/04/2026", "-Casa Eduarda", "Ibis", "Apartamento", "RioMar", "Apartamento", "Praia de Iracema"),
            new SocialDay("12/04/2026", "-Praia de Iracema", "Apartamento", "Praia de Iracema", "Apartamento", "Praia de Iracema", "Apartamento"),
            new SocialDay("13/04/2026", "-Apartamento"),
            new SocialDay("14/04/2026", "-Apartamento", "Hospital São Gonçalo", "Casa Eduarda", "-Casa"),
    });

    public static SocialRegister byNumber(int number) {
        for (SocialRegister register : values()) {
            if (register.getNumber() == number) {
                return register;
            }
        }
        return null;
    }

    private final int number;
    private final String title;
    private final SocialDay[] days;
    private int totalDistance;

    SocialRegister(int number, String title, SocialDay[] days) {
        this.number = number;
        this.title = title;
        this.days = days;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public SocialDay[] getDays() {
        return days;
    }

    public SocialDay getFirstDay() {
        return getDays()[0];
    }

    public SocialDay getLastDay() {
        return getDays()[getDays().length - 1];
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void addTotalDistance(int totalDistance) {
        this.totalDistance += totalDistance;
    }

    public void print() {
        if (this != E0) {
            String lastDay = byNumber(getNumber() - 1).getLastDay().getDay();
            String firstDay = getFirstDay().getDay();
            int daysFromLast = SocialCalculator.calculateDaysBetween(lastDay, firstDay);
            SocialCalculator.print(" - Dias Separados (" + lastDay + " -> " + firstDay + "): " + daysFromLast + " " + (daysFromLast == 1 ? "Dia" : "Dias"));
            SocialCalculator.print();

            SocialCalculator.DAYS_AWAY += (daysFromLast - 1);
            SocialCalculator.DAYS_BETWEEN += daysFromLast;
            SocialCalculator.add(SocialCalculator.DAYS_BETWEEN_TIMES, daysFromLast);
        }

        SocialCalculator.add(SocialCalculator.DAYS_TOGETHER_TIMES, getDays().length);

        SocialCalculator.print(getNumber() + "º - " + getTitle() + " - " + getDays().length + " " + (getDays().length == 1 ? "Dia" : "Dias"));

        boolean firstDay = true;
        for (SocialDay day : getDays()) {
            if (SocialCalculator.FIRST_DAY == null) {
                SocialCalculator.FIRST_DAY = day.getDay();
            }
            SocialCalculator.LAST_DAY = day.getDay();
            day.print(this);

            SocialCalculator.add(SocialCalculator.PER_YEAR, day.getDay().substring(6));
            SocialCalculator.add(SocialCalculator.PER_MONTH, SocialCalculator.dayToMonth(day.getDay()));
            SocialCalculator.add(SocialCalculator.PER_DAY, day.getDay().substring(0, 2));

            for (int i = 0; i < day.getPlaces().length; i++) {
                String place = day.getPlaces()[i];

                String key = place.split(" \\(")[0];

                if (!key.startsWith("-")) {
                    SocialCalculator.add(SocialCalculator.PLACES_TIMES, key);
                }
                if (!firstDay && i == 0) {
                    SocialCalculator.add(SocialCalculator.PLACES_NIGHT_TIMES, key.substring(1));
                }
            }

            if (firstDay) {
                firstDay = false;
            }
        }
        SocialCalculator.print("Distância: " + (getTotalDistance() / 1000) + " KM");
    }

}
