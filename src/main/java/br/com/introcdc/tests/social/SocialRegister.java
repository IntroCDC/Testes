package br.com.introcdc.tests.social;
/*
 * Written by IntroCDC, Bruno Co�lho at 08/07/2024 - 19:14
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
                    new SocialDay("03/09/2023", "-Apartamento", "Casa", "�rbita Blue", "Casa", "Apartamento", "Iguatemi", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E3(3, "Palhano",
            new SocialDay[]{
                    new SocialDay("08/09/2023", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("09/09/2023", "-Apartamento", "Casa", "Palhano", "Majorlandia", "Palhano"),
                    new SocialDay("10/09/2023", "-Palhano", "Casa", "Casa Eduarda", "-Casa")
            }),
    E4(4, "O McDonald's",
            new SocialDay[]{
                    new SocialDay("23/09/2023", "-Casa", "Casa Eduarda", "Ta�ba", "Apartamento", "Iguatemi", "McDonald's (Dom Luiz)", "Apartamento", "Spa Urbano"),
                    new SocialDay("24/09/2023", "-Spa Urbano", "Apartamento", "Iguatemi", "Apartamento", "Praia de Iracema", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa Christian/Valdiane", "-Casa")
            }),
    E5(5, "A Sa�da Escondida",
            new SocialDay[]{
                    new SocialDay("28/09/2023", "-Casa", "-North Shopping", "Casa Eduarda", "Apartamento"),
                    new SocialDay("29/09/2023", "-Apartamento", "Monsenhor Tabosa", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E6(6, "O Primeiro Jogo",
            new SocialDay[]{
                    new SocialDay("06/10/2023", "-Casa", "Casa Eduarda", "Apartamento", "S�o Luiz", "Iguatemi"),
                    new SocialDay("07/10/2023", "-Iguatemi", "Apartamento", "Krone", "Smart Fit", "Iguatemi", "Apartamento", "Casa", "Apartamento"),
                    new SocialDay("08/10/2023", "-Apartamento", "Krone", "Apartamento", "Castel�o (Am�rica MG)", "Tio Lanches", "Apartamento", "-Casa"),
                    new SocialDay("09/10/2023", "-Casa", "Krone", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E7(7, "IMAX",
            new SocialDay[]{
                    new SocialDay("14/10/2023", "-Casa", "Casa Eduarda", "Smart Fit", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("15/10/2023", "-Apartamento", "Krone", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E8(8, "Cangaracers",
            new SocialDay[]{
                    new SocialDay("19/10/2023", "-Casa", "Casa Eduarda", "Ta�ba", "Pec�m"),
                    new SocialDay("20/10/2023", "-Pec�m", "Casa Eduarda", "-Casa")
            }),
    E9(9, "Pr�-Uruguai",
            new SocialDay[]{
                    new SocialDay("25/10/2023", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "McDonald's", "Apartamento"),
                    new SocialDay("26/10/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("27/10/2023", "-Apartamento", "Casa", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E10(10, "Uma Derrota no Castel�o",
            new SocialDay[]{
                    new SocialDay("03/11/2023", "-Casa", "-Iguatemi (F�bio)", "Casa Eduarda", "Casa"),
                    new SocialDay("04/11/2023", "-Casa", "Gentilandia", "Casa", "Apartamento", "Krone", "Apartamento", "Monsenhor Tabosa", "Smart Fit", "Iguatemi", "Apartamento", "Casa"),
                    new SocialDay("05/11/2023", "-Casa", "Apartamento", "Krone", "Apartamento", "Castel�o (Flamengo)", "Iguatemi", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E11(11, "Universal Park",
            new SocialDay[]{
                    new SocialDay("15/11/2023", "-Casa", "Casa Eduarda", "Apartamento"),
                    new SocialDay("16/11/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento", "Krone", "Apartamento"),
                    new SocialDay("17/11/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento", "Universal Park", "Apartamento"),
                    new SocialDay("18/11/2023", "-Apartamento", "Smart Fit", "Apartamento", "Praia de Iracema", "S�o Luiz", "Apartamento"),
                    new SocialDay("19/11/2023", "-Apartamento", "Krone", "Mucuripe", "S�o Luiz", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E12(12, "Beach Park",
            new SocialDay[]{
                    new SocialDay("24/11/2023", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("25/11/2023", "-Apartamento", "Smart Fit", "Pague Menos", "Apartamento", "Casa", "Iguatemi", "Apartamento", "Casa"),
                    new SocialDay("26/11/2023", "-Apartamento", "S�o Luiz", "Beach Park", "S�o Luiz", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E13(13, "Kosmica Bar",
            new SocialDay[]{
                    new SocialDay("08/12/2023", "-Casa", "Casa Eduarda", "Apartamento", "S�o Luiz", "Smart Fit", "S�o Luiz", "Apartamento"),
                    new SocialDay("09/12/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento", "Praia de Iracema", "Apartamento", "Kosmica"),
                    new SocialDay("10/12/2023", "-Kosmica", "Pague Menos", "Apartamento", "Krone", "Apartamento", "Mucuripe", "Krone", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E14(14, "Pr�-Reveillon",
            new SocialDay[]{
                    new SocialDay("15/12/2023", "-Casa", "Casa Eduarda", "Apartamento"),
                    new SocialDay("16/12/2023", "-Apartamento", "S�o Luiz", "Smart Fit", "Loja de Roupa", "RioMar", "S�o Luiz", "Apartamento", "Kosmica"),
                    new SocialDay("17/12/2023", "-Kosmica", "Apartamento", "Unimed", "Apartamento"),
                    new SocialDay("18/12/2023", "-Apartamento", "Krone", "Apartamento", "Shopping Benfica", "Casa", "Apartamento", "Smart Fit", "Pague Menos", "Casa Tia Eduarda", "Apartamento"),
                    new SocialDay("19/12/2023", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Mercado Pinheiro", "Apartamento", "Pague Menos", "Apartamento", "Mucuripe", "Apartamento"),
                    new SocialDay("20/12/2023", "-Apartamento", "S�o Luiz", "Apartamento", "Smart Fit", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E15(15, "R�veillon com Eduarda, Gabriel e Lucas",
            new SocialDay[]{
                    new SocialDay("30/12/2023", "-Casa", "-Apartamento", "Casa Eduarda", "Atacad�o", "Apartamento", "Casa", "Iguatemi", "Apartamento", "Kosmica"),
                    new SocialDay("31/12/2023", "-Kosmica", "Y'all", "Apartamento", "S�o Luiz", "Apartamento", "Praia de Iracema"),
                    new SocialDay("01/01/2024", "-Praia de Iracema", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E16(16, "Quebrando Tabus no Primeiro de 2024",
            new SocialDay[]{
                    new SocialDay("12/01/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento", "Smart Fit", "Apartamento", "El Chancho"),
                    new SocialDay("13/01/2024", "-El Chancho", "Apartamento", "Iguatemi", "Smart Fit", "Iguatemi", "Kosmica"),
                    new SocialDay("14/01/2024", "-Kosmica", "Route", "Apartamento", "Casa Eduarda", "Pec�m", "Casa Eduarda", "-Apartamento")
            }),
    E17(17, "UPA, Lanterna de Choque e Rel�gios",
            new SocialDay[]{
                    new SocialDay("19/01/2024", "-Casa", "-Apartamento", "-Smart Fit", "-Shopping Benfica", "Casa Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("20/01/2024", "-Apartamento", "S�o Luiz", "Smart Fit", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("21/01/2024", "-Apartamento", "Iguatemi", "UPA", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E18(18, "Os 10 Dias",
            new SocialDay[]{
                    new SocialDay("24/01/2024", "-Casa", "-Smart Fit", "Casa Eduarda", "Sitio Pai Croat�", "Apartamento", "Dentista", "Apartamento", "Mucuripe", "Apartamento"),
                    new SocialDay("25/01/2024", "-Apartamento", "Pherboyre", "Carneiro do Ordones", "Pherboyre", "Dr David Sucupira", "Unimed", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("26/01/2024", "-Apartamento", "Krone", "Praia de Iracema", "S�o Luiz", "Apartamento", "Smart Fit", "Iguatemi", "Casa"),
                    new SocialDay("27/01/2024", "-Casa", "Smart Fit", "Iguatemi", "Apartamento", "Route"),
                    new SocialDay("28/01/2024", "-Route", "Level", "Apartamento", "Del Passeo (Uv Action)", "Casa Luciano", "Iguatemi", "Casa", "Apartamento"),
                    new SocialDay("29/01/2024", "-Apartamento", "Pherboyre", "Apartamento", "Iguatemi", "Apartamento", "Mucuripe", "Casa"),
                    new SocialDay("30/01/2024", "-Casa", "Apartamento", "Iguatemi", "Karlla Sobrancelhas", "Apartamento", "Smart Fit", "Casa"),
                    new SocialDay("31/01/2024", "-Casa", "Apartamento", "Smart Fit", "Apartamento", "Iguatemi", "Castel�o (Cear�)", "Mucuripe", "Praia de Iracema", "Apartamento"),
                    new SocialDay("01/02/2024", "-Apartamento", "Dentista", "Pague Menos", "S�o Luiz", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("02/02/2024", "-Apartamento", "Pherboyre", "Dentista", "Apartamento", "RioMar", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E19(19, "O P�s-Cirurgia",
            new SocialDay[]{
                    new SocialDay("17/02/2024", "Casa", "Castel�o (Cear�)", "Casa"),
                    new SocialDay("18/02/2024", "-Casa")
            }),
    E20(20, "O Pr�-Anivers�rio",
            new SocialDay[]{
                    new SocialDay("24/02/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("25/02/2024", "-Apartamento", "S�o Luiz", "Apartamento", "Casa", "Apartamento", "Casa Eduarda", "-Apartamento", "-McDonald's", "-Casa")
            }),
    E21(21, "A Semana do Anivers�rio",
            new SocialDay[]{
                    new SocialDay("29/02/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "-Uninassau", "Apartamento", "S�o Luiz", "Apartamento", "Smart Fit", "-Uninassau", "Smart Fit", "Apartamento"),
                    new SocialDay("01/03/2024", "-Apartamento", "C�mara Municipal", "Iguatemi", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("02/03/2024", "-Apartamento", "Krone", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("03/03/2024", "-Apartamento", "Krone", "Praia de Iracema", "Mucuripe", "Praia de Iracema", "Apartamento", "Praia de Iracema", "Apartamento", "Coco Bambu", "Apartamento"),
                    new SocialDay("04/03/2024", "-Apartamento", "-Uninassau", "-Apartamento", "Gr�u T�cnico", "Conceito Auto Shopping", "Iguatemi", "Apartamento", "Smart Fit", "Pague Menos", "Apartamento"),
                    new SocialDay("05/03/2024", "-Apartamento", "-Uninassau", "Apartamento", "Smart Fit", "Shopping Benfica", "Apartamento", "Praia de Iracema", "Mucuripe"),
                    new SocialDay("06/03/2024", "-Mucuripe", "Apartamento", "-Uninassau", "Apartamento", "Yakichina Sul", "Apartamento", "Mucuripe", "ILLA MARE", "Apartamento", "Coco Bambu"),
                    new SocialDay("07/03/2024", "-Coco Bambu", "Apartamento", "Smart Fit", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E22(22, "Primeira Vez Dormindo Na Casa Dela",
            new SocialDay[]{
                    new SocialDay("15/03/2024", "-Casa", "-Mundo Verde", "Casa Eduarda", "Dois Estilos", "Mercado M�e Rainha", "Casa Eduarda"),
                    new SocialDay("16/03/2024", "-Casa Eduarda", "Oce�nica", "Pague Menos", "Restaurante Bom Paladar", "Casa Eduarda", "Paracuru", "Casa Eduarda"),
                    new SocialDay("17/03/2024", "-Casa Eduarda", "-Casa")
            }),
    E23(23, "Uma Noite em um Hotel",
            new SocialDay[]{
                    new SocialDay("22/03/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Apartamento", "Iguatemi", "Loja", "Apartamento", "Mucuripe", "Pague Menos", "Apartamento", "Algarve Praia Hotel"),
                    new SocialDay("23/03/2024", "-Algarve Praia Hotel", "Apartamento", "Praia de Iracema", "Apartamento", "Castel�o (Vit�ria)", "Apartamento"),
                    new SocialDay("24/03/2024", "-Apartamento", "Barraca Terra Brasilis", "Apartamento", "Mucuripe", "Krone", "Apartamento"),
                    new SocialDay("25/03/2024", "-Apartamento", "Krone", "Apartamento", "Casa Eduarda"),
                    new SocialDay("26/03/2024", "-Casa Eduarda", "-Apartamento", "-Uninassau", "-Apartamento", "-Casa")
            }),
    E24(24, "Campeonato Cearense e Tatuagem",
            new SocialDay[]{
                    new SocialDay("04/04/2024", "-Casa", "-Apartamento", "-Uninassau", "-Apartamento", "Casa Eduarda", "Krone", "Apartamento", "Smart Fit", "Pague Menos", "Apartamento"),
                    new SocialDay("05/04/2024", "-Apartamento", "Mucuripe", "Apartamento", "C�mara Municipal", "Iguatemi", "Apartamento", "Smart Fit", "Apartamento", "Iguatemi"),
                    new SocialDay("06/04/2024", "-Iguatemi", "Apartamento", "Castel�o (Cear�)", "Apartamento", "Tatuagem"),
                    new SocialDay("07/04/2024", "-Tatuagem", "Apartamento", "Praia de Iracema", "Apartamento", "Irm� Eduarda"),
                    new SocialDay("08/04/2024", "-Irm� Eduarda", "Apartamento", "Dentista", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E25(25, "Pr�-Curso",
            new SocialDay[]{
                    new SocialDay("14/04/2024", "-Casa", "-Apartamento", "Casa Eduarda", "S�o Luiz", "Apartamento", "Iguatemi", "RioMar", "S�o Luiz", "Apartamento", "Praia de Iracema", "Krone", "Apartamento"),
                    new SocialDay("15/04/2024", "-Apartamento", "C�mara Municipal", "Pague Menos", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E26(26, "P�s Curso e Rol� com Mariana e Greice",
            new SocialDay[]{
                    new SocialDay("19/04/2024", "-Casa", "-Pague Menos", "Grau T�cnico", "Apartamento", "Iguatemi", "Banco do Nordeste", "C�mara Municipal", "Pague Menos", "Apartamento", "Smart Fit", "Apartamento"),
                    new SocialDay("20/04/2024", "-Apartamento", "Teresa & Jorge", "Apartamento"),
                    new SocialDay("21/04/2024", "-Apartamento", "Praia de Iracema", "Apartamento", "Castel�o (Altos)", "Krone", "Apartamento"),
                    new SocialDay("22/04/2024", "-Apartamento", "Grau T�cnico", "-Uninassau", "-Apartamento", "-Casa")
            }),
    E27(27, "O Pai da Eduarda",
            new SocialDay[]{
                    new SocialDay("23/04/2024", "-Casa", "IML", "S�o Luiz", "IML", "-Casa")
            }),
    E28(28, "Mercado Central",
            new SocialDay[]{
                    new SocialDay("29/04/2024", "-Casa", "-Pague Menos", "-Super Gentil�ndia", "Grau T�cnico", "Casa", "Grau T�cnico", "Mercado Central", "IML", "Casa Eduarda", "-Casa")
            }),
    E29(29, "Lucas e Eduarda",
            new SocialDay[]{
                    new SocialDay("30/04/2024", "-Casa", "IML", "Mercado Central", "Apartamento", "Praia de Iracema", "Apartamento", "-Casa")
            }),
    E30(30, "O Dia 100",
            new SocialDay[]{
                    new SocialDay("10/05/2024", "-Casa", "Casa Eduarda", "Apartamento", "Krone", "S�o Luiz", "Casas Gir�o", "Apartamento", "Iguatemi", "Apartamento", "Tatuagem", "Coco Bambu", "Pague Menos", "Apartamento"),
                    new SocialDay("11/05/2024", "-Apartamento", "Praia de Iracema", "Apartamento", "S�o Luiz", "Teresa & Jorge", "Praia de Iracema", "Apartamento", "Praia de Iracema"),
                    new SocialDay("12/05/2024", "-Praia de Iracema", "Apartamento", "Casa", "Apartamento", "Hotel Ibis", "Casa Lucas", "Ta�ba", "Casa Lucas", "Casa Eduarda", "-Casa Dona Maria", "-Castel�o (Botafogo)", "-Cabana", "-Casa")
            }),
    E31(31, "Dia no Apartamento",
            new SocialDay[]{
                    new SocialDay("13/05/2024", "-Casa", "-Apartamento", "-Casas Gir�o", "-Fortaleza Esporte Clube", "-Apartamento", "Grau T�cnico", "Apartamento", "Krone", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E32(32, "Kosmica com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("17/05/2024", "-Casa", "-Apartamento", "-Mercado Pinheiro", "Apartamento", "Kosmica"),
                    new SocialDay("18/05/2024", "-Kosmica", "Y'all", "Apartamento", "Praia de Iracema", "Mucuripe", "Rua S�o Luiz (Evento)", "Apartamento", "Rua S�o Luiz (Evento)", "Apartamento", "Kosmica", "Apartamento", "Kosmica"),
                    new SocialDay("19/05/2024", "-Kosmica", "Apartamento", "-Casa")
            }),
    E33(33, "Dias de Ref�gio",
            new SocialDay[]{
                    new SocialDay("28/05/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Krone", "Apartamento"),
                    new SocialDay("29/05/2024", "-Apartamento", "S�o Luiz", "Grau T�cnico", "Casa", "Grau T�cnico", "Apartamento", "Smart Fit", "Apartamento", "Castel�o (Sportivo Trinidense)", "Coco Bambu"),
                    new SocialDay("30/05/2024", "-Coco Bambu", "Apartamento", "S�o Luiz", "Apartamento", "Krone", "Praia de Iracema", "Apartamento", "Kosmica", "Apartamento", "Castello"),
                    new SocialDay("31/05/2024", "-Castello", "Kosmica", "Apartamento", "Praia de Iracema", "Apartamento", "North Shopping J�quei", "Apartamento"),
                    new SocialDay("01/06/2024", "-Apartamento", "Iguatemi"),
                    new SocialDay("02/06/2024", "-Iguatemi", "Casa", "Super Gentil�ndia", "Casa", "Apartamento", "Coco Bambu Coffee", "Casa", "Arena PV", "Casa", "Apartamento", "Praia de Iracema", "Braz�o", "Apartamento"),
                    new SocialDay("03/06/2024", "-Apartamento", "Shopping Benfica", "Dentista", "Fortaleza Esporte Clube", "Pague Menos", "Apartamento", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E34(34, "Espera de um �nibus",
            new SocialDay[]{
                    new SocialDay("05/06/2024", "-Casa", "-Apartamento", "Grau T�cnico", "-Casa")
            }),
    E35(35, "Um Almo�o no Ordones",
            new SocialDay[]{
                    new SocialDay("07/06/2024", "-Casa", "Grau T�cnico", "Ordones", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E36(36, "Buscando para Aula",
            new SocialDay[]{
                    new SocialDay("14/06/2024", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "Centro", "Conserto Celular", "Coco Bambu", "Apartamento", "Casa", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E37(37, "Laje com Eduarda e Gabriel",
            new SocialDay[]{
                    new SocialDay("15/06/2024", "Casa", "Laje"),
                    new SocialDay("16/06/2024", "-Laje", "Casa", "Apartamento", "Praia de Iracema", "Apartamento", "-Casa")
            }),
    E38(38, "P�s Apresenta��o",
            new SocialDay[]{
                    new SocialDay("17/06/2024", "-Casa", "Grau T�cnico", "-Casa")
            }),
    E39(39, "Pegando o Celular",
            new SocialDay[]{
                    new SocialDay("19/06/2024", "-Casa", "Grau T�cnico", "Casa", "Grau T�cnico", "Conserto Celular", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E40(40, "S�o Jo�o e Beach Park",
            new SocialDay[]{
                    new SocialDay("21/06/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Grau T�cnico", "Casa", "Grau T�cnico", "Apartamento", "Sobrancelha", "Smart Fit", "Iguatemi", "Apartamento"),
                    new SocialDay("22/06/2024", "-Apartamento", "Iguatemi", "Apartamento", "ACMP"),
                    new SocialDay("23/06/2024", "-ACMP", "Apartamento", "Praia de Iracema", "Apartamento", "Beach Park", "Cometa", "Apartamento")
            }),
    E41(41, "Bolo de Milho",
            new SocialDay[]{
                    new SocialDay("24/06/2024", "-Apartamento", "-S�o Luiz", "Grau T�cnico", "Apartamento", "Grau T�cnico", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E42(42, "Encontro P�s Mudan�as",
            new SocialDay[]{
                    new SocialDay("03/07/2024", "-Casa", "Casa Eduarda", "Ibis", "Grau T�cnico", "-Casa", "-VRT Race Team", "-Apartamento", "Grau T�cnico", "Centro", "Centro Fashion", "Fortaleza Esporte Clube", "C�mara Municipal", "Iguatemi", "Terminal Ant�nio Bezerra", "Ibis", "-Casa")
            }),
    E43(43, "Evento Pixar",
            new SocialDay[]{
                    new SocialDay("06/07/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Shopping Benfica", "Apartamento", "Praia de Iracema", "Mercado Pinheiro", "Praia de Iracema", "Apartamento", "Iguatemi", "Apartamento", "Praia de Iracema"),
                    new SocialDay("07/07/2024", "-Praia de Iracema", "Apartamento", "Terminal Ant�nio Bezerra", "-Castel�o (Fluminense)", "-Apartamento")
            }),
    E44(44, "UPA e Tintas",
            new SocialDay[]{
                    new SocialDay("08/07/2024", "-Apartamento", "Grau T�cnico", "Casa", "Grau T�cnico", "UPA (UPA C)", "Shopping Benfica", "Fortaleza Tintas", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E45(45, "Boombox e Tintas",
            new SocialDay[]{
                    new SocialDay("10/07/2024", "-Casa", "Grau T�cnico", "Shopping Benfica", "Casa", "Fortaleza Tintas", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E46(46, "Um Caf� da Manh� no MonteCarlo",
            new SocialDay[]{
                    new SocialDay("12/07/2024", "-Casa", "Grau T�cnico", "MonteCarlo", "Terminal Ant�nio Bezerra", "-Casa")
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
    E49(49, "Resson�ncia, Exames e Anivers�rio",
            new SocialDay[]{
                    new SocialDay("29/07/2024", "-Casa", "-Apartamento", "Oce�nica", "Mangiare", "Casa Eduarda", "Apartamento", "Praia de Iracema", "Pague Menos", "Apartamento"),
                    new SocialDay("30/07/2024", "-Apartamento", "Boghos", "Apartamento", "Boghos", "Centro Fashion", "Apartamento", "Smart Fit", "MonteCarlo", "Apartamento"),
                    new SocialDay("31/07/2024", "-Apartamento", "North Shopping J�quei", "Iguatemi", "Centro Fashion", "Apartamento", "Smart Fit", "Iguatemi", "Apartamento"),
                    new SocialDay("01/08/2024", "-Apartamento", "Krone", "Praia de Iracema", "Mucuripe", "Apartamento", "Smart Fit", "Iguatemi", "Apartamento", "Praia de Iracema", "Mucuripe", "Praia de Iracema"),
                    new SocialDay("02/08/2024", "-Praia de Iracema", "Iguatemi", "Boghos", "Centro", "Apartamento", "Iguatemi", "Apartamento", "-Posto", "Apartamento"),
                    new SocialDay("03/08/2024", "-Apartamento", "Neurologista", "Apartamento", "Krone", "Apartamento", "Casa", "Shopping Benfica", "Casa", "Apartamento", "Mercado Pinheiro", "Apartamento", "Laje"),
                    new SocialDay("04/08/2024", "-Laje", "Apartamento", "Praia de Iracema", "Apartamento", "UPA", "IJF", "Apartamento", "Iguatemi", "Apartamento", "Picanha do Jonas", "Casa", "Apartamento"),
                    new SocialDay("05/08/2024", "-Apartamento", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E50(50, "Presente Dia dos Pais e Camisas",
            new SocialDay[]{
                    new SocialDay("07/08/2024", "-Casa", "Grau T�cnico", "Iguatemi", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E51(51, "Intervalo e Ajeitar Cal�a",
            new SocialDay[]{
                    new SocialDay("09/08/2024", "-Casa", "Grau T�cnico", "-Shopping Benfica", "-Casa", "-Shopping Benfica", "Grau T�cnico", "-Casa")
            }),
    E52(52, "Filme no North Shopping",
            new SocialDay[]{
                    new SocialDay("10/08/2024", "-Casa", "North Shopping", "-Castel�o (Crici�ma)", "-Casa")
            }),
    E53(53, "Follow The Sun",
            new SocialDay[]{
                    new SocialDay("14/08/2024", "-Casa", "Casa Eduarda", "Apartamento", "Iguatemi", "Smart Fit", "-Apartamento", "-Casa", "MonteCarlo", "Apartamento", "Follow The Sun"),
                    new SocialDay("15/08/2024", "-Follow The Sun", "Apartamento", "Iguatemi", "Apartamento", "Pague Menos"),
                    new SocialDay("16/08/2024", "-Pague Menos", "Apartamento", "Terminal Ant�nio Bezerra", "-Apartamento", "-Casa")
            }),
    E54(54, "Curso P�s Grandes Mudan�as",
            new SocialDay[]{
                    new SocialDay("21/08/2024", "-Casa", "Grau T�cnico", "-Casa")
            }),
    E55(55, "Fim de Semana de UP",
            new SocialDay[]{
                    new SocialDay("31/08/2024", "-Casa", "Casa Eduarda", "Centro Fashion", "Mercado Pinheiro", "Apartamento", "Pague Menos", "Apartamento", "Laje", "Benfica"),
                    new SocialDay("01/09/2024", "-Benfica", "Casa", "Benfica", "-Casa", "-Benfica", "Apartamento", "Ta�ba", "Casa Eduarda", "-Casa")
            }),
    E56(56, "Ida Surpresa no Curso",
            new SocialDay[]{
                    new SocialDay("02/09/2024", "-Casa", "Grau T�cnico", "-Casa")
            }),
    E57(57, "Almo�o no Dom Espeto",
            new SocialDay[]{
                    new SocialDay("04/09/2024", "-Casa", "Grau T�cnico", "Dom Espeto", "Apartamento", "Sal�o de Beleza", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E58(58, "Ultrassom das Pernas",
            new SocialDay[]{
                    new SocialDay("06/09/2024", "-Casa", "-Santa Branca", "Grau T�cnico", "Boghos", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E59(59, "DJ com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("07/09/2024", "-Casa", "Casa Eduarda", "Casa Lucas", "Apartamento", "Casa", "Shopping Benfica", "Apartamento", "Shopping Benfica", "Apartamento", "Praia de Iracema", "Pinheiro", "Apartamento", "Benfica", "-Casa", "-Benfica"),
                    new SocialDay("08/09/2024", "-Benfica", "Mucuripe", "Apartamento", "Casa", "Apartamento", "-Casa", "-Apartamento", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E60(60, "Almo�o e Descanso no AP",
            new SocialDay[]{
                    new SocialDay("11/09/2024", "-Casa", "Grau T�cnico", "Dom Espeto", "Apartamento", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E61(61, "Era pra ser a �ltima Volta na z1000",
            new SocialDay[]{
                    new SocialDay("18/09/2024", "-Casa", "Grau T�cnico", "Iguatemi", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E62(62, "Tatuagem e Castel�o Sem Ela",
            new SocialDay[]{
                    new SocialDay("21/09/2024", "-Casa", "Casa Eduarda", "Apartamento", "Casa", "Pague Menos", "Apartamento", "Iguatemi", "Tatuagem", "-Casa", "-Castel�o (Bahia)", "-Casa"),
                    new SocialDay("22/09/2024", "-Casa", "-Apartamento", "-Tatuagem", "Pague Menos", "Apartamento", "Terminal Ant�nio Bezerra", "-Apartamento", "-Casa")
            }),
    E63(63, "Primeira Volta na s1000",
            new SocialDay[]{
                    new SocialDay("27/09/2024", "-Casa", "Grau T�cnico", "Pague Menos", "Grau T�cnico", "-Casa", "Grau T�cnico", "North Shopping J�quei", "Terminal Ant�nio Bezerra", "-Casa Lenon", "-Casa")
            }),
    E64(64, "s1000 na Rodovia e Route",
            new SocialDay[]{
                    new SocialDay("28/09/2024", "-Casa", "Casa Eduarda", "S�o Gon�alo do Amarante", "Iguatemi", "Apartamento", "Route"),
                    new SocialDay("29/09/2024", "-Route", "Apartamento", "-Casa")
            }),
    E65(65, "Um Almo�o no North Shopping",
            new SocialDay[]{
                    new SocialDay("30/09/2024", "-Casa", "Grau T�cnico", "Shopping Benfica", "North Shopping", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E66(66, "Um Almo�o no Apartamento e Roupas",
            new SocialDay[]{
                    new SocialDay("02/10/2024", "-Casa", "-Shopping Benfica", "Grau T�cnico", "Apartamento", "Benfica", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E67(67, "Cardiologista e A�a�",
            new SocialDay[]{
                    new SocialDay("04/10/2024", "-Casa", "Casa Eduarda", "Apartamento", "-Grau T�cnico", "-Apartamento", "Pague Menos", "North Shopping J�quei", "Apartamento"),
                    new SocialDay("05/10/2024", "-Apartamento", "Veleiro Piat�", "Praia de Iracema", "Mucuripe", "Pague Menos", "Praia de Iracema", "Apartamento", "Lugarzinho", "Praia de Iracema", "Mucuripe", "Casa", "Apartamento"),
                    new SocialDay("06/10/2024", "-Apartamento", "Casa Eduarda", "S�o Gon�alo do Amarante", "-Casa")
            }),
    E68(68, "Presente pro Lucas",
            new SocialDay[]{
                    new SocialDay("11/10/2024", "-Casa", "Grau T�cnico", "Clarindo de Queiroz", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E69(69, "Anivers�rio do Lucas na Route",
            new SocialDay[]{
                    new SocialDay("12/10/2024", "-Casa", "Casa Eduarda", "S�o Gon�alo do Amarante", "Casa Lucas", "Ibis", "Mercado Pinheiro", "Apartamento", "-Casa", "-Apartamento", "Praia de Iracema", "Apartamento", "Route"),
                    new SocialDay("13/10/2024", "-Route", "Apartamento", "Praia de Iracema", "Apartamento", "-Casa")
            }),
    E70(70, "Reforma da Tatuagem",
            new SocialDay[]{
                    new SocialDay("17/10/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Monsenhor Tabosa", "Apartamento", "Tatuagem", "Pague Menos", "Apartamento"),
                    new SocialDay("18/10/2024", "-Apartamento", "Mercado Pinheiro", "Grau T�cnico", "-Apartamento", "-Conceito Auto Shopping", "-Grau T�cnico", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E71(71, "Almo�o R�pido no Dom Espeto",
            new SocialDay[]{
                    new SocialDay("21/10/2024", "-Casa", "Grau T�cnico", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E72(72, "Entrega de Papel e Almo�o",
            new SocialDay[]{
                    new SocialDay("25/10/2024", "-Casa", "Grau T�cnico", "-Casa", "Grau T�cnico", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E73(73, "T�nis e Raquete Nova",
            new SocialDay[]{
                    new SocialDay("28/10/2024", "-Casa", "-Detran", "Grau T�cnico", "North Shopping", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E74(74, "Planejamento para Anivers�rio Jos� Renan",
            new SocialDay[]{
                    new SocialDay("30/10/2024", "-Casa", "Grau T�cnico", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E75(75, "Um Halloween com Maquiagem",
            new SocialDay[]{
                    new SocialDay("01/11/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Apartamento", "Dentista", "Pague Menos", "Apartamento", "Iguatemi", "Apartamento", "-Casa", "-Apartamento", "Route", "Apartamento"),
                    new SocialDay("02/11/2024", "-Apartamento"),
                    new SocialDay("03/11/2024", "-Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E76(76, "Entrega de Camisa Jovem Din�mico",
            new SocialDay[]{
                    new SocialDay("08/11/2024", "-Casa", "Grau T�cnico", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E77(77, "Um Almo�o de Niver da minha M�e",
            new SocialDay[]{
                    new SocialDay("11/11/2024", "-Casa", "Grau T�cnico", "Centro", "Grau T�cnico", "-Casa", "-Gastro", "-Casa", "Grau T�cnico", "Suplementos", "Casa", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E78(78, "Presente para M�e 2024",
            new SocialDay[]{
                    new SocialDay("13/11/2024", "-Casa", "Centro", "Iguatemi", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E79(79, "Universal Park com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("16/11/2024", "-Casa", "North Shopping", "Apartamento", "Aboli��o", "Apartamento", "Universal Park", "Apartamento"),
                    new SocialDay("17/11/2024", "-Apartamento", "Casa", "-Apartamento", "Pague Menos", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E80(80, "Benfica com Irm� da Eduarda",
            new SocialDay[]{
                    new SocialDay("23/11/2024", "-Casa", "-Apartamento", "Casa Eduarda", "Ibis", "Apartamento", "Sal�o de Beleza", "Apartamento", "Benfica", "Praia de Iracema"),
                    new SocialDay("24/11/2024", "-Praia de Iracema", "-Apartamento", "Praia de Iracema", "Apartamento", "Casa Eduarda", "-Apartamento", "-Casa")
            }),
    E81(81, "Caf� da Manh� no MonteCarlo e Dentista",
            new SocialDay[]{
                    new SocialDay("25/11/2024", "-Casa", "Grau T�cnico", "MonteCarlo", "Apartamento", "Dentista", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E82(82, "Continua��o da Tatuagem",
            new SocialDay[]{
                    new SocialDay("27/11/2024", "-Casa", "Grau T�cnico", "MonteCarlo", "Apartamento", "Tatuagem", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E83(83, "Continua��o do Dentista",
            new SocialDay[]{
                    new SocialDay("29/11/2024", "-Casa", "Grau T�cnico", "MonteCarlo", "Apartamento", "Dentista", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E84(84, "Virada de Noite no Apartamento Pr� Beach Park",
            new SocialDay[]{
                    new SocialDay("31/11/2024", "-Casa", "Casa Lucas", "Apartamento"),
                    new SocialDay("01/12/2024", "-Apartamento", "Mucuripe", "Casa Lucas", "-Casa")
            }),
    E85(85, "Entrega de Declara��o e Almo�o",
            new SocialDay[]{
                    new SocialDay("02/12/2024", "-Casa", "Dentista", "Grau T�cnico", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E86(86, "Caf� da Manh� em Casa",
            new SocialDay[]{
                    new SocialDay("04/12/2024", "-Casa", "Grau T�cnico", "Aldeota", "Casa", "Gentilandia", "Terminal Ant�nio Bezerra", "-Grau T�cnico", "-Casa")
            }),
    E87(87, "Porto das Dunas com Eduarda e Lucas",
            new SocialDay[]{
                    new SocialDay("08/12/2024", "-Casa", "Casa Lucas", "Apartamento", "S�o Luiz", "Porto das Dunas", "Apartamento", "Casa", "Casa Lucas", "-Casa")
            }),
    E88(88, "Almo�o Pr� Jo�o Pessoa",
            new SocialDay[]{
                    new SocialDay("11/12/2024", "-Casa", "Grau T�cnico", "Dom Espeto", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E89(89, "Virada do Ano de 2025 com 7 Pessoas",
            new SocialDay[]{
                    new SocialDay("29/12/2024", "-Casa", "Casa Eduarda", "Apartamento", "P�o de A��car", "Apartamento", "Iguatemi", "Casa", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("30/12/2024", "-Apartamento", "Casa Lucas", "Apartamento", "Pinheiro", "Apartamento", "Praia de Iracema", "Apartamento"),
                    new SocialDay("31/12/2024", "-Apartamento", "Praia de Iracema", "Apartamento", "Praia de Iracema"),
                    new SocialDay("01/01/2025", "-Praia de Iracema", "Apartamento", "Casa Lucas", "Apartamento", "Mucuripe", "Apartamento"),
                    new SocialDay("02/01/2025", "-Apartamento", "Casa Eduarda", "-Casa")
            }),
    E90(90, "Espera de �nibus p�s Deixar Moto",
            new SocialDay[]{
                    new SocialDay("06/01/2025", "-Casa", "Grau T�cnico", "-Casa")
            }),
    E91(91, "Dentista P�s Conversa",
            new SocialDay[]{
                    new SocialDay("08/01/2025", "-Casa", "Grau T�cnico", "-Casa", "Grau T�cnico", "Dentista", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E92(92, "Espera de �nibus no dia 10",
            new SocialDay[]{
                    new SocialDay("10/01/2025", "-Casa", "Grau T�cnico", "-Casa")
            }),
    E93(93, "Sa�da com Eduarda e Lucas e Ida para Prova",
            new SocialDay[]{
                    new SocialDay("11/01/2025", "-Casa", "Casa Lucas", "Apartamento"),
                    new SocialDay("12/01/2025", "-Apartamento", "Casa Eduarda", "Ta�ba", "Casa Lucas", "Apartamento"),
                    new SocialDay("13/01/2025", "-Apartamento", "Grau T�cnico", "Apartamento", "Casa Eduarda", "-Casa")
            }),
    E94(94, "Ida no Krone P�s Curso",
            new SocialDay[]{
                    new SocialDay("17/01/2025", "-Casa", "Grau T�cnico", "Apartamento", "Krone", "Apartamento", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E95(95, "P�s Formatura de Prima e 4 Idas",
            new SocialDay[]{
                    new SocialDay("19/01/2025", "-Casa", "S�o Gon�alo do Amarante", "Apartamento", "Casa Brena", "Casa Eduarda", "Casa Lucas", "Ta�ba", "Apartamento"),
                    new SocialDay("20/01/2025", "-Apartamento", "Casa Lucas", "Casa Eduarda", "Casa Lucas", "Apartamento", "-Casa", "-Apartamento", "-Casa", "-Apartamento", "Pague Menos", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E96(96, "Ida R�pida na Pague Menos P�s Curso",
            new SocialDay[]{
                    new SocialDay("22/01/2025", "-Casa", "Grau T�cnico", "-Casa")
            }),
    E97(97, "Entrega de Documentos na Grau",
            new SocialDay[]{
                    new SocialDay("24/01/2025", "-Casa", "Grau T�cnico", "-Casa", "Grau T�cnico", "-Casa")
            }),
    E98(98, "Entrega de Camisa, M�scara e Compra de Capacete",
            new SocialDay[]{
                    new SocialDay("29/01/2025", "-Casa", "Grau T�cnico", "-Clarindo de Queiroz", "-Casa")
            }),
    E99(99, "P�s Pintura da Moto e Curso",
            new SocialDay[]{
                    new SocialDay("01/02/2025", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "Centro", "Apartamento", "Iguatemi"),
                    new SocialDay("02/02/2025", "-Iguatemi", "Apartamento", "�rbita Blue", "Apartamento", "Casa Eduarda", "M�e Rainha", "Casa Lucas", "S�o Gon�alo do Amarante", "Casa Lucas", "M�e Rainha", "Casa Lucas"),
                    new SocialDay("03/02/2025", "-Casa Lucas", "Casa Eduarda", "Apartamento", "-Casa", "-Apartamento", "Grau T�cnico", "-Casa")
            }),
    E100(100, "Sa�da P�s Quase Afastamento",
            new SocialDay[]{
                    new SocialDay("15/02/2025", "-Casa", "Casa Eduarda", "Ibis", "Casa Tia Eduarda", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("16/02/2025", "-Apartamento", "Praia de Iracema", "Mucuripe", "Praia de Iracema", "Apartamento", "Casa Eduarda", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E101(101, "Duas Idas a Praia, Intera��es e Lucas",
            new SocialDay[]{
                    new SocialDay("21/02/2025", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "Smart Fit", "Braz�o", "Apartamento", "Iguatemi", "Apartamento"),
                    new SocialDay("22/02/2025", "-Apartamento", "Praia de Iracema", "Apartamento", "-Casa", "-Apartamento", "Casa Lucas", "Apartamento"),
                    new SocialDay("23/02/2025", "-Apartamento", "Praia de Iracema", "Apartamento", "-Casa", "-Apartamento", "Casa Lucas", "Casa Eduarda", "-Casa")
            }),
    E102(102, "Cancelamento do Curso e Greenish",
            new SocialDay[]{
                    new SocialDay("27/02/2025", "-Casa", "Grau T�cnico", "Shopping Benfica", "Praia de Iracema", "Terminal Ant�nio Bezerra", "-Casa")
            }),
    E103(103, "Meu Anivers�rio de 2025",
            new SocialDay[]{
                    new SocialDay("06/03/2025", "-Casa", "Casa Eduarda", "Ibis", "Apartamento", "-Casa", "-Apartamento", "-Iguatemi", "-Apartamento", "Coco Bambu", "Apartamento"),
                    new SocialDay("07/03/2025", "-Apartamento", "-Casa", "-Apartamento", "Casa Eduarda", "-Casa")
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

        SocialCalculator.print(getNumber() + "� - " + getTitle() + " - " + getDays().length + " " + (getDays().length == 1 ? "Dia" : "Dias"));

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
        SocialCalculator.print("Dist�ncia: " + (getTotalDistance() / 1000) + " KM");
    }

}
