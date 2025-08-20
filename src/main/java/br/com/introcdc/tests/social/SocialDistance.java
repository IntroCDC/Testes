package br.com.introcdc.tests.social;
/*
 * Written by IntroCDC, Bruno Coelho at 14/01/2025 - 02:05
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum SocialDistance {
    CASA_CASARAFAEL("Casa", "Casa Rafael", 2100),
    CASARAFAEL_CASAEDUARDA("Casa Rafael", "Casa Eduarda", 67000),
    CASAEDUARDA_CASA("Casa Eduarda", "Casa", 64000),
    CASA_APARTAMENTO("Casa", "Apartamento", 5400),
    APARTAMENTO_PRAIADEIRACEMA("Apartamento", "Praia de Iracema", 1000),
    APARTAMENTO_MUCURIPE("Apartamento", "Mucuripe", 5000),
    MUCURIPE_MCDONALDS("Mucuripe", "McDonald's", 2500),
    MCDONALDS_APARTAMENTO("McDonald's", "Apartamento", 5000),
    APARTAMENTO_CASACHRISTIAN("Apartamento", "Casa Christian", 11400),
    CASACHRISTIAN_CASAEDUARDA("Casa Christian", "Casa Eduarda", 63000),
    CASA_RIOMAR("Casa", "RioMar", 10400),
    RIOMAR_PAGUEMENOS("RioMar", "Pague Menos", 6000),
    PAGUEMENOS_APARTAMENTO("Pague Menos", "Apartamento", 1500),
    APARTAMENTO_IGUATEMI("Apartamento", "Iguatemi", 7200),
    IGUATEMI_CASA("Iguatemi", "Casa", 8200),
    CASAEDUARDA_APARTAMENTO("Casa Eduarda", "Apartamento", 65800),
    CASA_GUARAMIRANGA("Casa", "Guaramiranga", 106000),
    GUARAMIRANGA_MIRANTE360("Guaramiranga", "Mirante 360", 11700),
    MIRANTE360_PAGUEMENOS("Mirante 360", "Pague Menos", 102000),
    PAGUEMENOS_CASA("Pague Menos", "Casa", 6600),
    CASA_ORBITABLUE("Casa", "Órbita Blue", 13100),
    CASA_PALHANO("Casa", "Palhano", 188000),
    PALHANO_MAJORLANDIA("Palhano", "Majorlandia", 53000),
    CASAEDUARDA_TAIBA("Casa Eduarda", "Taíba", 27300),
    TAIBA_APARTAMENTO("Taíba", "Apartamento", 72000),
    IGUATEMI_MCDONALDS("Iguatemi", "McDonald's", 4000),
    APARTAMENTO_SPAURBANO("Apartamento", "Spa Urbano", 7000),
    APARTAMENTO_CASACHRISTIANVALDIANE("Apartamento", "Casa Christian/Valdiane", 7800),
    CASACHRISTIANVALDIANE_CASA("Casa Christian/Valdiane", "Casa", 2100),
    CASA_NORTHSHOPPING("Casa", "North Shopping", 4700),
    NORTHSHOPPING_CASAEDUARDA("North Shopping", "Casa Eduarda", 60100),
    APARTAMENTO_MONSENHORTABOSA("Apartamento", "Monsenhor Tabosa", 1000),
    APARTAMENTO_SAOLUIZ("Apartamento", "São Luiz", 300),
    SAOLUIZ_IGUATEMI("São Luiz", "Iguatemi", 7500),
    APARTAMENTO_KRONE("Apartamento", "Krone", 300),
    KRONE_SMARTFIT("Krone", "Smart Fit", 1100),
    SMARTFIT_IGUATEMI("Smart Fit", "Iguatemi", 5900),
    APARTAMENTO_CASTELAO("Apartamento", "Castelão", 12500),
    CASTELAO_TIOLANCHES("Castelão", "Tio Lanches", 4400),
    TIOLANCHES_APARTAMENTO("Tio Lanches", "Apartamento", 10700),
    CASA_KRONE("Casa", "Krone", 7000),
    CASAEDUARDA_SMARTFIT("Casa Eduarda", "Smart Fit", 66200),
    SMARTFIT_APARTAMENTO("Smart Fit", "Apartamento", 1100),
    TAIBA_PECEM("Taíba", "Pecém", 20000),
    PECEM_CASAEDUARDA("Pecém", "Casa Eduarda", 22500),
    IGUATEMI_CASAEDUARDA("Iguatemi", "Casa Eduarda", 70500),
    CASA_GENTILANDIA("Casa", "Gentilandia", 700),
    MONSENHORTABOSA_SMARTFIT("Monsenhor Tabosa", "Smart Fit", 1000),
    CASTELAO_IGUATEMI("Castelão", "Iguatemi", 9000),
    APARTAMENTO_UNIVERSALPARK("Apartamento", "Universal Park", 12100),
    PRAIADEIRACEMA_SAOLUIZ("Praia de Iracema", "São Luiz", 1000),
    KRONE_MUCURIPE("Krone", "Mucuripe", 5000),
    MUCURIPE_SAOLUIZ("Mucuripe", "São Luiz", 5000),
    SMARTFIT_PAGUEMENOS("Smart Fit", "Pague Menos", 500),
    SAOLUIZ_BEACHPARK("São Luiz", "Beach Park", 27700),
    SAOLUIZ_SMARTFIT("São Luiz", "Smart Fit", 1000),
    APARTAMENTO_KOSMICA("Apartamento", "Kosmica", 750),
    KOSMICA_PAGUEMENOS("Kosmica", "Pague Menos", 1000),
    SMARTFIT_LOJADEROUPA("Smart Fit", "Loja de Roupa", 5000),
    LOJADEROUPA_RIOMAR("Loja de Roupa", "RioMar", 5000),
    RIOMAR_SAOLUIZ("RioMar", "São Luiz", 6800),
    APARTAMENTO_UNIMED("Apartamento", "Unimed", 5900),
    APARTAMENTO_SHOPPINGBENFICA("Apartamento", "Shopping Benfica", 6000),
    SHOPPINGBENFICA_CASA("Shopping Benfica", "Casa", 1500),
    PAGUEMENOS_CASATIAEDUARDA("Pague Menos", "Casa Tia Eduarda", 18000),
    CASATIAEDUARDA_APARTAMENTO("Casa Tia Eduarda", "Apartamento", 18000),
    SMARTFIT_MERCADOPINHEIRO("Smart Fit", "Mercado Pinheiro", 2500),
    MERCADOPINHEIRO_APARTAMENTO("Mercado Pinheiro", "Apartamento", 500),
    CASAEDUARDA_ATACADAO("Casa Eduarda", "Atacadão", 65000),
    ATACADAO_APARTAMENTO("Atacadão", "Apartamento", 12000),
    KOSMICA_YALL("Kosmica", "Y'all", 10),
    YALL_APARTAMENTO("Y'all", "Apartamento", 750),
    APARTAMENTO_ELCHANCHO("Apartamento", "El Chancho", 3000),
    IGUATEMI_KOSMICA("Iguatemi", "Kosmica", 7200),
    KOSMICA_ROUTE("Kosmica", "Route", 50),
    ROUTE_APARTAMENTO("Route", "Apartamento", 750),
    SMARTFIT_SHOPPINGBENFICA("Smart Fit", "Shopping Benfica", 5500),
    SHOPPINGBENFICA_CASAEDUARDA("Shopping Benfica", "Casa Eduarda", 64000),
    IGUATEMI_UPA("Iguatemi", "UPA", 5000),
    UPA_APARTAMENTO("UPA", "Apartamento", 7000),
    CASA_SMARTFIT("Casa", "Smart Fit", 6000),
    CASAEDUARDA_SITIOPAICROATA("Casa Eduarda", "Sitio Pai Croatá", 19600),
    SITIOPAICROATA_APARTAMENTO("Sitio Pai Croatá", "Apartamento", 70000),
    APARTAMENTO_DENTISTA("Apartamento", "Dentista", 6000),
    APARTAMENTO_PHERBOYRE("Apartamento", "Pherboyre", 5000),
    PHERBOYRE_CARNEIRODOORDONES("Pherboyre", "Carneiro do Ordones", 300),
    PHERBOYRE_DRDAVIDSUCUPIRA("Pherboyre", "Dr David Sucupira", 2700),
    DRDAVIDSUCUPIRA_UNIMED("Dr David Sucupira", "Unimed", 1500),
    KRONE_PRAIADEIRACEMA("Krone", "Praia de Iracema", 1000),
    ROUTE_LEVEL("Route", "Level", 50),
    LEVEL_APARTAMENTO("Level", "Apartamento", 750),
    APARTAMENTO_DELPASSEO("Apartamento", "Del Passeo", 3700),
    DELPASSEO_CASALUCIANO("Del Passeo", "Casa Luciano", 22500),
    CASALUCIANO_IGUATEMI("Casa Luciano", "Iguatemi", 20000),
    MUCURIPE_CASA("Mucuripe", "Casa", 10000),
    IGUATEMI_KARLLASOBRANCELHAS("Iguatemi", "Karlla Sobrancelhas", 5200),
    KARLLASOBRANCELHAS_APARTAMENTO("Karlla Sobrancelhas", "Apartamento", 3000),
    CASTELAO_MUCURIPE("Castelão", "Mucuripe", 11000),
    MUCURIPE_PRAIADEIRACEMA("Mucuripe", "Praia de Iracema", 5000),
    DENTISTA_PAGUEMENOS("Dentista", "Pague Menos", 5000),
    PAGUEMENOS_SAOLUIZ("Pague Menos", "São Luiz", 1000),
    PHERBOYRE_DENTISTA("Pherboyre", "Dentista", 4200),
    APARTAMENTO_RIOMAR("Apartamento", "RioMar", 6400),
    CASA_CASTELAO("Casa", "Castelão", 10000),
    MCDONALDS_CASA("McDonald's", "Casa", 7000),
    APARTAMENTO_UNINASSAU("Apartamento", "Uninassau", 3600),
    SMARTFIT_UNINASSAU("Smart Fit", "Uninassau", 4000),
    APARTAMENTO_CAMARAMUNICIPAL("Apartamento", "Câmara Municipal", 8400),
    CAMARAMUNICIPAL_IGUATEMI("Câmara Municipal", "Iguatemi", 2300),
    APARTAMENTO_COCOBAMBU("Apartamento", "Coco Bambu", 2200),
    APARTAMENTO_GRAUTECNICO("Apartamento", "Gráu Técnico", 3300),
    GRAUTECNICO_CONCEITOAUTOSHOPPING("Gráu Técnico", "Conceito Auto Shopping", 7700),
    CONCEITOAUTOSHOPPING_IGUATEMI("Conceito Auto Shopping", "Iguatemi", 1000),
    APARTAMENTO_YAKICHINASUL("Apartamento", "Yakichina Sul", 14400),
    MUCURIPE_ILLAMARE("Mucuripe", "ILLA MARE", 1000),
    ILLAMARE_APARTAMENTO("ILLA MARE", "Apartamento", 4000),
    CASA_MUNDOVERDE("Casa", "Mundo Verde", 2400),
    MUNDOVERDE_CASAEDUARDA("Mundo Verde", "Casa Eduarda", 64600),
    CASAEDUARDA_DOISESTILOS("Casa Eduarda", "Dois Estilos", 1000),
    DOISESTILOS_MERCADOMAERAINHA("Dois Estilos", "Mercado Mãe Rainha", 450),
    MERCADOMAERAINHA_CASAEDUARDA("Mercado Mãe Rainha", "Casa Eduarda", 1000),
    CASAEDUARDA_OCEANICA("Casa Eduarda", "Oceânica", 1000),
    OCEANICA_PAGUEMENOS("Oceânica", "Pague Menos", 1000),
    PAGUEMENOS_RESTAURANTEBOMPALADAR("Pague Menos", "Restaurante Bom Paladar", 1000),
    RESTAURANTEBOMPALADAR_CASAEDUARDA("Restaurante Bom Paladar", "Casa Eduarda", 700),
    CASAEDUARDA_PARACURU("Casa Eduarda", "Paracuru", 30000),
    IGUATEMI_LOJA("Iguatemi", "Loja", 1000),
    LOJA_APARTAMENTO("Loja", "Apartamento", 6000),
    MUCURIPE_PAGUEMENOS("Mucuripe", "Pague Menos", 4000),
    APARTAMENTO_ALGARVEPRAIAHOTEL("Apartamento", "Algarve Praia Hotel", 300),
    APARTAMENTO_BARRACATERRABRASILIS("Apartamento", "Barraca Terra Brasilis", 28200),
    CASAEDUARDA_KRONE("Casa Eduarda", "Krone", 66000),
    APARTAMENTO_TATUAGEM("Apartamento", "Tatuagem", 5000),
    APARTAMENTO_IRMAEDUARDA("Apartamento", "Irmã Eduarda", 14000),
    DENTISTA_CASAEDUARDA("Dentista", "Casa Eduarda", 64000),
    CASAEDUARDA_SAOLUIZ("Casa Eduarda", "São Luiz", 65800),
    IGUATEMI_RIOMAR("Iguatemi", "RioMar", 5000),
    CAMARAMUNICIPAL_PAGUEMENOS("Câmara Municipal", "Pague Menos", 9000),
    PAGUEMENOS_GRAUTECNICO("Pague Menos", "Grau Técnico", 3500),
    GRAUTECNICO_APARTAMENTO("Grau Técnico", "Apartamento", 3300),
    IGUATEMI_BANCODONORDESTE("Iguatemi", "Banco do Nordeste", 3000),
    BANCODONORDESTE_CAMARAMUNICIPAL("Banco do Nordeste", "Câmara Municipal", 1000),
    APARTAMENTO_TERESAJORGE("Apartamento", "Teresa & Jorge", 1500),
    CASTELAO_KRONE("Castelão", "Krone", 12500),
    GRAUTECNICO_UNINASSAU("Grau Técnico", "Uninassau", 2700),
    CASA_IML("Casa", "IML", 5000),
    IML_SAOLUIZ("IML", "São Luiz", 3200),
    PAGUEMENOS_SUPERGENTILANDIA("Pague Menos", "Super Gentilândia", 1000),
    SUPERGENTILANDIA_GRAUTECNICO("Super Gentilândia", "Grau Técnico", 2700),
    GRAUTECNICO_CASA("Grau Técnico", "Casa", 3600),
    GRAUTECNICO_MERCADOCENTRAL("Grau Técnico", "Mercado Central", 1700),
    MERCADOCENTRAL_IML("Mercado Central", "IML", 2300),
    IML_CASAEDUARDA("IML", "Casa Eduarda", 64800),
    MERCADOCENTRAL_APARTAMENTO("Mercado Central", "Apartamento", 1400),
    KRONE_SAOLUIZ("Krone", "São Luiz", 10),
    SAOLUIZ_CASASGIRAO("São Luiz", "Casas Girão", 2700),
    CASASGIRAO_APARTAMENTO("Casas Girão", "Apartamento", 2300),
    TATUAGEM_COCOBAMBU("Tatuagem", "Coco Bambu", 2000),
    COCOBAMBU_PAGUEMENOS("Coco Bambu", "Pague Menos", 1500),
    SAOLUIZ_TERESAJORGE("São Luiz", "Teresa & Jorge", 1000),
    TERESAJORGE_PRAIADEIRACEMA("Teresa & Jorge", "Praia de Iracema", 1000),
    APARTAMENTO_HOTELIBIS("Apartamento", "Hotel Ibis", 40600),
    HOTELIBIS_CASALUCAS("Hotel Ibis", "Casa Lucas", 25000),
    CASALUCAS_TAIBA("Casa Lucas", "Taíba", 26500),
    CASALUCAS_CASAEDUARDA("Casa Lucas", "Casa Eduarda", 1500),
    CASAEDUARDA_CASADONAMARIA("Casa Eduarda", "Casa Dona Maria", 64000),
    CASADONAMARIA_CASTELAO("Casa Dona Maria", "Castelão", 5000),
    CASTELAO_CABANA("Castelão", "Cabana", 18000),
    CABANA_CASA("Cabana", "Casa", 24500),
    CASASGIRAO_FORTALEZAESPORTECLUBE("Casas Girão", "Fortaleza Esporte Clube", 7600),
    FORTALEZAESPORTECLUBE_APARTAMENTO("Fortaleza Esporte Clube", "Apartamento", 10700),
    MUCURIPE_RUASAOLUIZ("Mucuripe", "Rua São Luiz", 5000),
    RUASAOLUIZ_APARTAMENTO("Rua São Luiz", "Apartamento", 100),
    SAOLUIZ_GRAUTECNICO("São Luiz", "Grau Técnico", 3300),
    CASTELAO_COCOBAMBU("Castelão", "Coco Bambu", 10300),
    APARTAMENTO_CASTELLO("Apartamento", "Castello", 700),
    CASTELLO_KOSMICA("Castello", "Kosmica", 100),
    APARTAMENTO_NORTHSHOPPINGJOQUEI("Apartamento", "North Shopping Jóquei", 10400),
    CASA_SUPERGENTILANDIA("Casa", "Super Gentilândia", 100),
    APARTAMENTO_COCOBAMBUCOFFEE("Apartamento", "Coco Bambu Coffee", 2200),
    COCOBAMBUCOFFEE_CASA("Coco Bambu Coffee", "Casa", 5900),
    CASA_ARENAPV("Casa", "Arena PV", 750),
    PRAIADEIRACEMA_BRAZAO("Praia de Iracema", "Brazão", 1000),
    BRAZAO_APARTAMENTO("Brazão", "Apartamento", 1000),
    SHOPPINGBENFICA_DENTISTA("Shopping Benfica", "Dentista", 1000),
    DENTISTA_FORTALEZAESPORTECLUBE("Dentista", "Fortaleza Esporte Clube", 5800),
    FORTALEZAESPORTECLUBE_PAGUEMENOS("Fortaleza Esporte Clube", "Pague Menos", 11500),
    APARTAMENTO_APARTAMENTO("Apartamento", "Apartamento", 1000),
    GRAUTECNICO_ORDONES("Grau Técnico", "Ordones", 3000),
    ORDONES_TERMINALANTONIOBEZERRA("Ordones", "Terminal Antônio Bezerra", 4200),
    TERMINALANTONIOBEZERRA_CASA("Terminal Antônio Bezerra", "Casa", 7600),
    CASAEDUARDA_IBIS("Casa Eduarda", "Ibis", 25300),
    IBIS_APARTAMENTO("Ibis", "Apartamento", 40900),
    APARTAMENTO_CENTRO("Apartamento", "Centro", 2700),
    CENTRO_CONSERTOCELULAR("Centro", "Conserto Celular", 1000),
    CONSERTOCELULAR_COCOBAMBU("Conserto Celular", "Coco Bambu", 2000),
    CASA_LAJE("Casa", "Laje", 700),
    GRAUTECNICO_CONSERTOCELULAR("Grau Técnico", "Conserto Celular", 2000),
    CONSERTOCELULAR_TERMINALANTONIOBEZERRA("Conserto Celular", "Terminal Antônio Bezerra", 5000),
    IBIS_GRAUTECNICO("Ibis", "Grau Técnico", 38300),
    APARTAMENTO_SOBRANCELHA("Apartamento", "Sobrancelha", 5000),
    SOBRANCELHA_SMARTFIT("Sobrancelha", "Smart Fit", 3000),
    APARTAMENTO_ACMP("Apartamento", "ACMP", 20000),
    APARTAMENTO_BEACHPARK("Apartamento", "Beach Park", 26300),
    BEACHPARK_COMETA("Beach Park", "Cometa", 23400),
    COMETA_APARTAMENTO("Cometa", "Apartamento", 2000),
    GRAUTECNICO_TERMINALANTONIOBEZERRA("Grau Técnico", "Terminal Antônio Bezerra", 6300),
    CASA_VRTRACETEAM("Casa", "VRT Race Team", 3200),
    VRTRACETEAM_APARTAMENTO("VRT Race Team", "Apartamento", 3100),
    GRAUTECNICO_CENTRO("Grau Técnico", "Centro", 300),
    CENTRO_CENTROFASHION("Centro", "Centro Fashion", 3100),
    CENTROFASHION_FORTALEZAESPORTECLUBE("Centro Fashion", "Fortaleza Esporte Clube", 8300),
    FORTALEZAESPORTECLUBE_CAMARAMUNICIPAL("Fortaleza Esporte Clube", "Câmara Municipal", 12100),
    IGUATEMI_TERMINALANTONIOBEZERRA("Iguatemi", "Terminal Antônio Bezerra", 12700),
    TERMINALANTONIOBEZERRA_IBIS("Terminal Antônio Bezerra", "Ibis", 31500),
    IBIS_CASA("Ibis", "Casa", 38900),
    IBIS_SHOPPINGBENFICA("Ibis", "Shopping Benfica", 37900),
    PRAIADEIRACEMA_MERCADOPINHEIRO("Praia de Iracema", "Mercado Pinheiro", 1000),
    APARTAMENTO_TERMINALANTONIOBEZERRA("Apartamento", "Terminal Antônio Bezerra", 10500),
    TERMINALANTONIOBEZERRA_CASTELAO("Terminal Antônio Bezerra", "Castelão", 12200),
    GRAUTECNICO_UPA("Grau Técnico", "UPA", 5000),
    UPA_SHOPPINGBENFICA("UPA", "Shopping Benfica", 5000),
    SHOPPINGBENFICA_FORTALEZATINTAS("Shopping Benfica", "Fortaleza Tintas", 2700),
    FORTALEZATINTAS_TERMINALANTONIOBEZERRA("Fortaleza Tintas", "Terminal Antônio Bezerra", 6400),
    GRAUTECNICO_SHOPPINGBENFICA("Grau Técnico", "Shopping Benfica", 1800),
    CASA_FORTALEZATINTAS("Casa", "Fortaleza Tintas", 2900),
    GRAUTECNICO_MONTECARLO("Grau Técnico", "MonteCarlo", 5800),
    MONTECARLO_TERMINALANTONIOBEZERRA("MonteCarlo", "Terminal Antônio Bezerra", 11900),
    APARTAMENTO_CENTRODEEVENTOS("Apartamento", "Centro de Eventos", 9300),
    CENTRODEEVENTOS_MONTECARLO("Centro de Eventos", "MonteCarlo", 5500),
    MONTECARLO_APARTAMENTO("MonteCarlo", "Apartamento", 4200),
    IGUATEMI_NEUROLOGISTA("Iguatemi", "Neurologista", 3400),
    NEUROLOGISTA_SMARTFIT("Neurologista", "Smart Fit", 5000),
    SMARTFIT_MONTECARLO("Smart Fit", "MonteCarlo", 2600),
    APARTAMENTO_GALOCEGO("Apartamento", "Galo Cego", 3000),
    GALOCEGO_CENTRO("Galo Cego", "Centro", 1000),
    CENTRO_SHOPPINGBENFICA("Centro", "Shopping Benfica", 1000),
    CASA_HALLELUYA("Casa", "Halleluya", 8800),
    APARTAMENTO_OCEANICA("Apartamento", "Oceânica", 64700),
    OCEANICA_MANGIARE("Oceânica", "Mangiare", 2000),
    MANGIARE_CASAEDUARDA("Mangiare", "Casa Eduarda", 2000),
    PRAIADEIRACEMA_PAGUEMENOS("Praia de Iracema", "Pague Menos", 1000),
    APARTAMENTO_BOGHOS("Apartamento", "Boghos", 2900),
    BOGHOS_CENTROFASHION("Boghos", "Centro Fashion", 2700),
    CENTROFASHION_APARTAMENTO("Centro Fashion", "Apartamento", 3800),
    NORTHSHOPPINGJOQUEI_IGUATEMI("North Shopping Jóquei", "Iguatemi", 14000),
    IGUATEMI_CENTROFASHION("Iguatemi", "Centro Fashion", 10100),
    PRAIADEIRACEMA_IGUATEMI("Praia de Iracema", "Iguatemi", 6000),
    IGUATEMI_BOGHOS("Iguatemi", "Boghos", 7000),
    BOGHOS_CENTRO("Boghos", "Centro", 100),
    APARTAMENTO_POSTO("Apartamento", "Posto", 1000),
    APARTAMENTO_NEUROLOGISTA("Apartamento", "Neurologista", 6200),
    APARTAMENTO_LAJE("Apartamento", "Laje", 5300),
    UPA_IJF("UPA", "IJF", 6600),
    IJF_APARTAMENTO("IJF", "Apartamento", 4200),
    APARTAMENTO_PICANHADOJONAS("Apartamento", "Picanha do Jonas", 5400),
    PICANHADOJONAS_CASA("Picanha do Jonas", "Casa", 2000),
    APARTAMENTO_CASALUCAS("Apartamento", "Casa Lucas", 65500),
    GRAUTECNICO_IGUATEMI("Grau Técnico", "Iguatemi", 7200),
    NORTHSHOPPING_CASTELAO("North Shopping", "Castelão", 13700),
    CASA_MONTECARLO("Casa", "MonteCarlo", 8200),
    APARTAMENTO_FOLLOWTHESUN("Apartamento", "Follow The Sun", 2000),
    CASAEDUARDA_CENTROFASHION("Casa Eduarda", "Centro Fashion", 62600),
    CENTROFASHION_MERCADOPINHEIRO("Centro Fashion", "Mercado Pinheiro", 3700),
    LAJE_BENFICA("Laje", "Benfica", 100),
    BENFICA_CASA("Benfica", "Casa", 500),
    BENFICA_APARTAMENTO("Benfica", "Apartamento", 5000),
    GRAUTECNICO_DOMESPETO("Grau Técnico", "Dom Espeto", 2600),
    DOMESPETO_APARTAMENTO("Dom Espeto", "Apartamento", 7000),
    APARTAMENTO_SALAODEBELEZA("Apartamento", "Salão de Beleza", 3000),
    SALAODEBELEZA_TERMINALANTONIOBEZERRA("Salão de Beleza", "Terminal Antônio Bezerra", 7000),
    CASA_SANTABRANCA("Casa", "Santa Branca", 1000),
    SANTABRANCA_GRAUTECNICO("Santa Branca", "Grau Técnico", 2100),
    GRAUTECNICO_BOGHOS("Grau Técnico", "Boghos", 100),
    BOGHOS_DOMESPETO("Boghos", "Dom Espeto", 2600),
    DOMESPETO_TERMINALANTONIOBEZERRA("Dom Espeto", "Terminal Antônio Bezerra", 5000),
    PRAIADEIRACEMA_PINHEIRO("Praia de Iracema", "Pinheiro", 1000),
    PINHEIRO_APARTAMENTO("Pinheiro", "Apartamento", 700),
    BENFICA_MUCURIPE("Benfica", "Mucuripe", 8000),
    IGUATEMI_TATUAGEM("Iguatemi", "Tatuagem", 5000),
    TATUAGEM_CASA("Tatuagem", "Casa", 3000),
    TATUAGEM_PAGUEMENOS("Tatuagem", "Pague Menos", 2500),
    GRAUTECNICO_NORTHSHOPPINGJOQUEI("Grau Técnico", "North Shopping Jóquei", 7400),
    NORTHSHOPPINGJOQUEI_TERMINALANTONIOBEZERRA("North Shopping Jóquei", "Terminal Antônio Bezerra", 5000),
    TERMINALANTONIOBEZERRA_CASALENON("Terminal Antônio Bezerra", "Casa Lenon", 8700),
    CASALENON_CASA("Casa Lenon", "Casa", 17500),
    CASAEDUARDA_SAOGONCALODOAMARANTE("Casa Eduarda", "São Gonçalo do Amarante", 500),
    SAOGONCALODOAMARANTE_IGUATEMI("São Gonçalo do Amarante", "Iguatemi", 68500),
    SHOPPINGBENFICA_NORTHSHOPPING("Shopping Benfica", "North Shopping", 3500),
    NORTHSHOPPING_TERMINALANTONIOBEZERRA("North Shopping", "Terminal Antônio Bezerra", 2300),
    BENFICA_TERMINALANTONIOBEZERRA("Benfica", "Terminal Antônio Bezerra", 6300),
    PAGUEMENOS_NORTHSHOPPINGJOQUEI("Pague Menos", "North Shopping Jóquei", 6300),
    APARTAMENTO_VELEIROPIATA("Apartamento", "Veleiro Piatã", 500),
    VELEIROPIATA_PRAIADEIRACEMA("Veleiro Piatã", "Praia de Iracema", 500),
    APARTAMENTO_LUGARZINHO("Apartamento", "Lugarzinho", 250),
    LUGARZINHO_PRAIADEIRACEMA("Lugarzinho", "Praia de Iracema", 100),
    SAOGONCALODOAMARANTE_CASA("São Gonçalo do Amarante", "Casa", 64000),
    GRAUTECNICO_CLARINDODEQUEIROZ("Grau Técnico", "Clarindo de Queiroz", 1000),
    CLARINDODEQUEIROZ_DOMESPETO("Clarindo de Queiroz", "Dom Espeto", 2700),
    SAOGONCALODOAMARANTE_CASALUCAS("São Gonçalo do Amarante", "Casa Lucas", 500),
    CASALUCAS_IBIS("Casa Lucas", "Ibis", 25300),
    IBIS_MERCADOPINHEIRO("Ibis", "Mercado Pinheiro", 41000),
    IBIS_MONSENHORTABOSA("Ibis", "Monsenhor Tabosa", 41000),
    MERCADOPINHEIRO_GRAUTECNICO("Mercado Pinheiro", "Grau Técnico", 3300),
    APARTAMENTO_CONCEITOAUTOSHOPPING("Apartamento", "Conceito Auto Shopping", 7600),
    CONCEITOAUTOSHOPPING_GRAUTECNICO("Conceito Auto Shopping", "Grau Técnico", 7900),
    CASA_DETRAN("Casa", "Detran", 3500),
    DETRAN_GRAUTECNICO("Detran", "Grau Técnico", 3500),
    GRAUTECNICO_NORTHSHOPPING("Grau Técnico", "North Shopping", 4200),
    CASA_PRONTOCLINICA("Casa", "Prontoclinica", 2200),
    GRAUTECNICO_SUPLEMENTOS("Grau Técnico", "Suplementos", 1000),
    SUPLEMENTOS_CASA("Suplementos", "Casa", 3300),
    CASA_DOMESPETO("Casa", "Dom Espeto", 1800),
    CASA_CENTRO("Casa", "Centro", 3000),
    CENTRO_IGUATEMI("Centro", "Iguatemi", 6300),
    NORTHSHOPPING_APARTAMENTO("North Shopping", "Apartamento", 8200),
    APARTAMENTO_ABOLICAO("Apartamento", "Abolição", 500),
    PAGUEMENOS_CASALUCAS("Pague Menos", "Casa Lucas", 66000),
    BENFICA_PRAIADEIRACEMA("Benfica", "Praia de Iracema", 5000),
    DENTISTA_TERMINALANTONIOBEZERRA("Dentista", "Terminal Antônio Bezerra", 7000),
    TATUAGEM_TERMINALANTONIOBEZERRA("Tatuagem", "Terminal Antônio Bezerra", 5000),
    CASA_CASALUCAS("Casa", "Casa Lucas", 64000),
    MUCURIPE_CASALUCAS("Mucuripe", "Casa Lucas", 70000),
    CASA_DENTISTA("Casa", "Dentista", 1000),
    DENTISTA_GRAUTECNICO("Dentista", "Grau Técnico", 2200),
    GRAUTECNICO_ALDEOTA("Grau Técnico", "Aldeota", 4300),
    ALDEOTA_CASA("Aldeota", "Casa", 4000),
    GENTILANDIA_TERMINALANTONIOBEZERRA("Gentilandia", "Terminal Antônio Bezerra", 7000),
    SAOLUIZ_PORTODASDUNAS("São Luiz", "Porto das Dunas", 29000),
    PORTODASDUNAS_APARTAMENTO("Porto das Dunas", "Apartamento", 29000),
    APARTAMENTO_PAODEACUCAR("Apartamento", "Pão de Açúcar", 2800),
    SAOGONCALODOAMARANTE_APARTAMENTO("São Gonçalo do Amarante", "Apartamento", 65000),
    APARTAMENTO_CASABRENA("Apartamento", "Casa Brena", 62200),
    CASABRENA_CASAEDUARDA("Casa Brena", "Casa Eduarda", 16300),
    CLARINDODEQUEIROZ_CASA("Clarindo de Queiroz", "Casa", 2800),
    APARTAMENTO_ORBITABLUE("Apartamento", "Órbita Blue", 9000),
    CASAEDUARDA_MAERAINHA("Casa Eduarda", "Mãe Rainha", 1200),
    MAERAINHA_CASALUCAS("Mãe Rainha", "Casa Lucas", 500),
    IBIS_CASATIAEDUARDA("Ibis", "Casa Tia Eduarda", 27900),
    SMARTFIT_BRAZAO("Smart Fit", "Brazão", 1000),
    SHOPPINGBENFICA_PRAIADEIRACEMA("Shopping Benfica", "Praia de Iracema", 6300),
    PRAIADEIRACEMA_TERMINALANTONIOBEZERRA("Praia de Iracema", "Terminal Antônio Bezerra", 10600),
    CASA_BARDATRIPA("Casa", "Bar da Tripa", 64000),
    BARDATRIPA_CASALUCAS("Bar da Tripa", "Casa Lucas", 500),
    CASALUCAS_BARRAGEMDOCATOLE("Casa Lucas", "Barragem do Catolé", 5600),
    CASALUCAS_FARMACIAULTRAPOPULAR("Casa Lucas", "Farmácia Ultra Popular", 1000),
    CASALUCAS_POUSADABORO("Casa Lucas", "Pousada Boro", 500),
    POUSADABORO_CASAEDUARDA("Pousada Boro", "Casa Eduarda", 1300),
    CASA_CASATIAEDUARDA("Casa", "Casa Tia Eduarda", 13900),
    CASATIAEDUARDA_ESCOLACAUCAIA("Casa Tia Eduarda", "Escola Caucaia", 7400),
    NORTHSHOPPING_IGUATEMI("North Shopping", "Iguatemi", 12200),
    CASAEDUARDA_RIOMARKENNEDY("Casa Eduarda", "RioMar Kennedy", 60200),
    RIOMARKENNEDY_MONTECARLO("RioMar Kennedy", "MonteCarlo", 11100),
    MONTECARLO_CENTRO("MonteCarlo", "Centro", 6000),
    CENTRO_PAGUEMENOS("Centro", "Pague Menos", 3500),
    APARTAMENTO_UMBANDA("Apartamento", "Umbanda", 6000),
    APARTAMENTO_BOEMIAS("Apartamento", "Boêmias", 100),
    BOEMIAS_VIBE085("Boêmias", "Vibe 085", 200),
    VIBE085_APARTAMENTO("Vibe 085", "Apartamento", 100),
    TERMINALANTONIOBEZERRA_CASATIABRUNA("Terminal Antônio Bezerra", "Casa Tia Bruna", 14800),
    CASATIABRUNA_CASA("Casa Tia Bruna", "Casa", 12100),
    NORTHSHOPPING_TORREDENTISTA("North Shopping", "Torre Dentista", 8800),
    TORREDENTISTA_SHOPPINGBENFICA("Torre Dentista", "Shopping Benfica", 6000),
    CASA_SAOLUIZ("Casa", "São Luiz", 6000),
    APARTAMENTO_LAVANDERIA("Apartamento", "Lavanderia", 250),
    LAVANDERIA_SAOLUIZ("Lavanderia", "São Luiz", 100),
    APARTAMENTO_PALHANO("Apartamento", "Palhano", 192000),
    PALHANO_CENTROPALHANO("Palhano", "Centro Palhano", 2200),
    PALHANO_RESTAURANTELAFAMILIA("Palhano", "Restaurante La Familia", 2200),
    APARTAMENTO_PONTEDOSINGLESES("Apartamento", "Ponte dos Ingleses", 350),
    APARTAMENTO_PSIQUIATRA("Apartamento", "Psiquiatra", 3400),
    APARTAMENTO_PRONTOCLINICA("Apartamento", "Prontoclinica", 7500),
    PSIQUIATRA_UNIMED("Psiquiatra", "Unimed", 2500),
    SAOLUIZ_CONSERTOCARRO("São Luiz", "Conserto Carro", 5500),
    CONSERTOCARRO_CASA("Conserto Carro", "Casa", 4800),
    PSIQUIATRA_IGUATEMI("Psiquiatra", "Iguatemi", 2400),
    MERCADOPINHEIRO_SAOLUIZ("Mercado Pinheiro", "São Luiz", 750),
    APARTAMENTO_VASTORESTAURANTE("Apartamento", "Vasto Restaurante", 3900),
    CASA_CEATD("Casa", "CEATD", 8500),
    CEATD_APARTAMENTO("CEATD", "Apartamento", 8800),
    ;

    private final String locationOne;
    private final String locationTwo;
    private final int distance;

    SocialDistance(String locationOne, String locationTwo, int distance) {
        this.locationOne = locationOne;
        this.locationTwo = locationTwo;
        this.distance = distance;
    }

    public String getLocationOne() {
        return locationOne;
    }

    public String getLocationTwo() {
        return locationTwo;
    }

    public int getDistance() {
        return distance;
    }

    public static int distance(String posOne, String posTwo) {
        posOne = posOne.startsWith("-") ? posOne.substring(1).split(" \\(")[0] : posOne.split(" \\(")[0];
        posTwo = posTwo.startsWith("-") ? posTwo.substring(1).split(" \\(")[0] : posTwo.split(" \\(")[0];
        for (SocialDistance socialDistance : values()) {
            if ((socialDistance.getLocationOne().equalsIgnoreCase(posOne) && socialDistance.getLocationTwo().equalsIgnoreCase(posTwo)) ||
                    (socialDistance.getLocationTwo().equalsIgnoreCase(posOne) && socialDistance.getLocationOne().equalsIgnoreCase(posTwo))) {
                return socialDistance.getDistance();
            }
        }
        for (Info info : TEMP) {
            if ((info.getLocationOne().equalsIgnoreCase(posOne) && info.getLocationTwo().equalsIgnoreCase(posTwo)) ||
                    (info.getLocationTwo().equalsIgnoreCase(posOne) && info.getLocationOne().equalsIgnoreCase(posTwo))) {
                return info.getDistance();
            }
        }
        return -1;
    }

    public static List<Info> TEMP = new ArrayList<>();

    public static void main(String[] args) {
        int total = 0;
        int days = 0;
        int calc = 0;
        Scanner scanner = new Scanner(System.in);
        for (SocialRegister socialRegister : SocialRegister.values()) {
            for (SocialDay day : socialRegister.getDays()) {
                days++;
                for (int i = 0; i < (day.getPlaces().length - 1); i++) {
                    String locOne = day.getPlaces()[i].startsWith("-") ? day.getPlaces()[i].substring(1).split(" \\(")[0] : day.getPlaces()[i].split(" \\(")[0];
                    String locTwo = day.getPlaces()[i + 1].startsWith("-") ? day.getPlaces()[i + 1].substring(1).split(" \\(")[0] : day.getPlaces()[i + 1].split(" \\(")[0];
                    int dist = distance(locOne, locTwo);
                    if (dist == -1) {
                        System.out.println("#" + socialRegister.getNumber() + " / " + days + " " + socialRegister.getTitle() + " - " + day.getDay());
                        System.out.print("Distância: " + locOne + " -> " + locTwo + ": ");
                        try {
                            int distance = scanner.nextInt();
                            TEMP.add(new Info(locOne, locTwo, distance));
                            total += distance;
                            calc++;
                        } catch (Exception ignored) {
                            System.out.println();
                            for (Info info : TEMP) {
                                System.out.println(info.getLocationOne().toUpperCase().replace(" ", "").replace("'", "").replace("/", "").replace("&", "")
                                        + "_" +
                                        info.getLocationTwo().toUpperCase().replace(" ", "").replace("'", "").replace("/", "").replace("&", "")
                                        + "(\"" + info.getLocationOne() + "\", \"" + info.getLocationTwo() + "\", " + info.getDistance() + "),");
                            }
                            System.out.println("Distância até agora: " + total + " (Cálculos: " + calc + ")");
                            return;
                        }
                    } else {
                        total += dist;
                        calc++;
                    }
                }
            }
        }
        for (Info info : TEMP) {
            System.out.println(info.getLocationOne().toUpperCase().replace(" ", "").replace("'", "").replace("/", "").replace("&", "")
                    + "_" +
                    info.getLocationTwo().toUpperCase().replace(" ", "").replace("'", "").replace("/", "").replace("&", "")
                    + "(\"" + info.getLocationOne() + "\", \"" + info.getLocationTwo() + "\", " + info.getDistance() + "),");
        }
        System.out.println("Distância até agora: " + total + " (Cálculos: " + calc + ")");
    }

    public static class Info {

        private final String locationOne;
        private final String locationTwo;
        private final int distance;

        public Info(String locationOne, String locationTwo, int distance) {
            this.locationOne = locationOne;
            this.locationTwo = locationTwo;
            this.distance = distance;
        }

        public String getLocationOne() {
            return locationOne;
        }

        public String getLocationTwo() {
            return locationTwo;
        }

        public int getDistance() {
            return distance;
        }

    }

}
