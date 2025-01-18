package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Coêlho at 10/04/2024 - 15:55
 */

import java.util.ArrayList;
import java.util.List;

public class GameRegister {

    public static void registerTeams() {
        // Brasil
        // Acre
        new GameTeam("Náuas", "NAU", "NEC", "Náuas Esporte Clube",
                "Abutre do Norte", "Estádio Municipal de Cruzeiro do Sul", 5000,
                "Acre", "Norte", "Brasil", "América do Sul", 4);
        new GameTeam("Senador Guiomard", "SGU", "SESC", "Senador Guiomard Esporte Clube",
                "Tigrão da Floresta", "Estádio Municipal de Senador Guiomard", 5000,
                "Acre", "Norte", "Brasil", "América do Sul", 5);
        new GameTeam("Plácido de Castro", "PLC", "PFC", "Plácido de Castro Futebol Clube",
                "Tigre do Abunã", "Estádio José de Melo", 5000,
                "Acre", "Norte", "Brasil", "América do Sul", 6);
        new GameTeam("Juventus", "JUV", "JAC", "Juventus Atlético Clube",
                "Moleque Travesso", "Estádio Adauto de Moraes", 5000,
                "Acre", "Norte", "Brasil", "América do Sul", 7);
        new GameTeam("Independência", "IND", "IFC", "Independência Futebol Clube",
                "Tricolor de Aço", "Estádio Florestão", 10000,
                "Acre", "Norte", "Brasil", "América do Sul", 8);
        new GameTeam("Galvez", "GAL", "GEC", "Galvez Esporte Clube",
                "Império do Galvez", "Arena da Floresta", 13000,
                "Acre", "Norte", "Brasil", "América do Sul", 9);
        new GameTeam("Rio Branco", "RIO", "RBFC", "Rio Branco Futebol Clube",
                "Estrelão do Acre", "Estádio Arena da Floresta", 13000,
                "Acre", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("Atlético Acreano", "AAC", "ACA", "Atlético Acreano Futebol Clube",
                "Galvezão", "Estádio Antônio Aquino", 20000,
                "Acre", "Norte", "Brasil", "América do Sul", 11);

        // Alagoas
        new GameTeam("CRB", "CRB", "CRB", "Clube de Regatas Brasil",
                "Galo", "Estádio Rei Pelé", 45000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 2);
        new GameTeam("CSA", "CSA", "CSA", "Centro Sportivo Alagoano",
                "Azulão", "Estádio Rei Pelé", 45000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("Coruripe", "COR", "CFC", "Coruripe Futebol Clube",
                "Hulk Praiano", "Estádio Gerson Amaral", 3000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 4);
        new GameTeam("Desportivo Aliança", "DAL", "DA", "Desportivo Aliança",
                "Fantasma", "Estádio Municipal de Arapiraca", 5000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("ASA", "ASA", "ASA", "Agremiação Sportiva Arapiraquense",
                "Fantasma", "Estádio Municipal de Arapiraca", 5000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 6);
        new GameTeam("Sete de Setembro", "SET", "SSC", "Sete de Setembro Esporte Clube",
                "Alviverde", "Estádio Municipal de Penedo", 5000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 7);
        new GameTeam("Jaciobá", "JAC", "JAC", "Jaciobá Atlético Clube",
                "Calango do Sertão", "Estádio Municipal de Palmeira dos Índios", 3000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Murici", "MUR", "CAM", "Clube Atlético Murici",
                "Verdão", "Estádio José Gomes da Costa", 3000,
                "Alagoas", "Nordeste", "Brasil", "América do Sul", 9);

        // Amapá
        new GameTeam("São José", "SJO", "SJEC", "São José Esporte Clube",
                "Águia do Norte", "Estádio Municipal de Macapá", 4000,
                "Amapá", "Norte", "Brasil", "América do Sul", 4);
        new GameTeam("Independente", "IND", "CAI", "Clube Atlético Independente",
                "Gavião Carajás", "Zerão", 13680,
                "Amapá", "Norte", "Brasil", "América do Sul", 5);
        new GameTeam("Macapá", "MAC", "CEM", "Clube Esportivo Macapá",
                "Leão do Norte", "Zerão", 13680,
                "Amapá", "Norte", "Brasil", "América do Sul", 6);
        new GameTeam("Ypiranga", "YPI", "YC", "Ypiranga Clube",
                "Clube da Torre", "Zerão", 13680,
                "Amapá", "Norte", "Brasil", "América do Sul", 7);
        new GameTeam("Santana", "SAN", "SEC", "Santana Esporte Clube",
                "Canário do Norte", "Estádio Municipal de Santana", 5000,
                "Amapá", "Norte", "Brasil", "América do Sul", 8);
        new GameTeam("Trem", "TRE", "TDC", "Trem Desportivo Clube",
                "Locomotiva Vermelha", "Zerão", 13680,
                "Amapá", "Norte", "Brasil", "América do Sul", 9);
        new GameTeam("Guarany", "GUA", "GEC", "Guarany Esporte Clube",
                "Bugre do Amapá", "Zerão", 13680,
                "Amapá", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("Oratório", "ORA", "OEC", "Oratório Esporte Clube",
                "Dragão do Laguinho", "Estádio Municipal de Santana", 5000,
                "Amapá", "Norte", "Brasil", "América do Sul", 10);

        // Amazonas
        new GameTeam("Amazonas Futebol Clube", "AMA", "AFC", "Amazonas Futebol Clube",
                "Torcida Coral", "Arena da Amazônia", 44500,
                "Amazonas", "Norte", "Brasil", "América do Sul", 2);
        new GameTeam("Nacional", "NAC", "NFC", "Nacional Futebol Clube",
                "Leão da Vila Municipal", "Estádio Municipal Carlos Zamith", 5000,
                "Amazonas", "Norte", "Brasil", "América do Sul", 4);
        new GameTeam("São Raimundo", "SRA", "SREC", "São Raimundo Esporte Clube",
                "Tucumã", "Estádio Vivaldão", 35000,
                "Amazonas", "Norte", "Brasil", "América do Sul", 7);
        new GameTeam("Manaus", "MAN", "MFC", "Manaus Futebol Clube",
                "Gavião do Norte", "Arena da Amazônia", 44000,
                "Amazonas", "Norte", "Brasil", "América do Sul", 9);
        new GameTeam("Princesa do Solimões", "PRI", "PSC", "Princesa do Solimões Esporte Clube",
                "Tubarão do Norte", "Estádio Municipal Gilberto Mestrinho", 3000,
                "Amazonas", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("Fast", "FAS", "FC", "Fast Clube",
                "Rolo Compressor", "Estádio Municipal Carlos Zamith", 5000,
                "Amazonas", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("Penarol", "PEN", "PAC", "Penarol Atlético Clube",
                "Leão da Velha Serpa", "Estádio Municipal de Manacapuru", 5000,
                "Amazonas", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("Rio Negro", "RIO", "RNC", "Rio Negro Clube",
                "Barriga Preta", "Estádio Vivaldão", 35000,
                "Amazonas", "Norte", "Brasil", "América do Sul", 11);

        // Bahia
        new GameTeam("Bahia", "BAH", "ECB", "Esporte Clube Bahia",
                "Tricolor de Aço", "Arena Fonte Nova", 48000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 1);
        new GameTeam("Vitória", "VIT", "ECV", "Esporte Clube Vitória",
                "Leão da Barra", "Barradão", 35000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 1);
        new GameTeam("Atlético de Alagoinhas", "ATL", "AA", "Atlético de Alagoinhas",
                "Carcará", "Estádio Antônio de Figueiredo Carneiro", 10000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 4);
        new GameTeam("Jacuipense", "JAC", "ECJ", "Esporte Clube Jacuipense",
                "Leão do Sisal", "Estádio Eliel Martins", 6000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("Bahia de Feira", "BDF", "ECBF", "Esporte Clube Bahia de Feira",
                "Tremendão", "Estádio Municipal de Feira de Santana", 16000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 6);
        new GameTeam("Atlético de Itabuna", "ATI", "CAM", "Clube Atlético Mineiro",
                "Dragão do Sul", "Estádio Luiz Viana Filho", 5000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Juazeiro", "JUA", "JEC", "Juazeiro Social Clube",
                "Tricolor do Sertão", "Estádio Adauto Moraes", 5000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 9);
        new GameTeam("Jacobina", "JAC", "JAC", "Jacobina Esporte Clube",
                "Jegue de Ouro", "Estádio José Rocha", 5000,
                "Bahia", "Nordeste", "Brasil", "América do Sul", 10);

        // Ceará
        new GameTeam("Fortaleza", "FOR", "FEC", "Fortaleza Esporte Clube",
                "Leão do Pici", "Arena Castelão", 63903,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 1);
        new GameTeam("Ceará", "CEA", "CSC", "Ceará Sporting Club",
                "Vozão", "Arena Castelão", 63903,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 1);
        new GameTeam("Ferroviário", "FER", "FAC", "Ferroviário Atlético Clube",
                "Falange Coral", "Estádio Presidente Vargas", 20300,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 4);
        new GameTeam("Floresta", "FLO", "FEC", "Floresta Esporte Clube",
                "Verdão da Vila", "Estádio Augusto Olímpio", 12000,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("Maracanã", "MAR", "MEC", "Maracanã Esporte Clube",
                "Fúria Tricolor", "Estádio Prefeito Almir Dutra", 18000,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("Icasa", "ICA", "ICEC", "Icasa Esporte Clube",
                "Verdão do Cariri", "Estádio Romeirão", 10000,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 6);
        new GameTeam("Guarany de Sobral", "GUA", "GSC", "Guarany Esporte Clube",
                "Bugre do Ceará", "Estádio Junco", 7000,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 7);
        new GameTeam("Tiradentes", "TIR", "TEC", "Tiradentes Esporte Clube",
                "Tigre da Polícia Militar", "Estádio Presidente Vargas", 20300,
                "Ceará", "Nordeste", "Brasil", "América do Sul", 8);

        // Distrito Federal
        new GameTeam("Brasiliense", "BRA", "FCF", "Brasiliense Futebol Clube",
                "Jacaré", "Estádio Elmo Serejo Farias", 16000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 7);
        new GameTeam("Gama", "GAM", "GDF", "Gama Futebol Clube",
                "Alviverde do Gama", "Estádio Bezerrão", 20000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 8);
        new GameTeam("Ceilândia", "CEI", "CEC", "Ceilândia Esporte Clube",
                "Gavião do Cerrado", "Estádio Abrahão Cândido de Moraes", 10000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 9);
        new GameTeam("Luziânia", "LUZ", "LEC", "Luziânia Esporte Clube",
                "Azulão do Entorno", "Estádio JK", 12000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 10);
        new GameTeam("Real Brasília", "RBR", "RBC", "Real Brasília Futebol Clube",
                "Leão do Planalto", "Estádio Defelê", 15000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 11);
        new GameTeam("Taguatinga", "TAG", "TEC", "Taguatinga Esporte Clube",
                "TEC", "Estádio Elmo Serejo Farias", 16000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 11);
        new GameTeam("Capital", "CAP", "CFC", "Capital Futebol Clube",
                "Leão do Gama", "Estádio Serejão", 15000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 11);
        new GameTeam("Paranoá", "PAR", "PEC", "Paranoá Esporte Clube",
                "Cacique do Cerrado", "Estádio Elmo Serejo Farias", 16000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "América do Sul", 11);

        // Espírito Santos
        new GameTeam("Desportiva Ferroviária", "DES", "DFC", "Desportiva Ferroviária Esporte Clube",
                "Grená", "Estádio Engenheiro Araripe", 21000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 4);
        new GameTeam("Vitória", "VIT", "ECV", "Esporte Clube Vitória",
                "Alvianil de Bento Ferreira", "Estádio Salvador Costa", 3000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 5);
        new GameTeam("Rio Branco", "RIO", "RBC", "Rio Branco Atlético Clube",
                "Capa Preta", "Estádio Kleber Andrade", 21000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 6);
        new GameTeam("Real Noroeste", "RNO", "RNC", "Real Noroeste Capixaba Futebol Clube",
                "Merengue", "Estádio José Olímpio de Lima", 5000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 8);
        new GameTeam("São Mateus", "SMA", "SMC", "São Mateus Esporte Clube",
                "Falcão do Norte", "Estádio Municipal de São Mateus", 8000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 9);
        new GameTeam("Tupy", "TUP", "TEC", "Tupy Futebol Clube",
                "Alvinegro da Vila", "Estádio José de Azeredo Coutinho", 5000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 10);
        new GameTeam("Linhares", "LIN", "LEC", "Linhares Esporte Clube",
                "Leão do Norte", "Estádio Municipal de Linhares", 10000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 11);
        new GameTeam("Serra", "SER", "SES", "Serra Futebol Clube",
                "Cobra Coral", "Estádio Robertão", 5000,
                "Espírito Santo", "Sudeste", "Brasil", "América do Sul", 11);

        // Goias
        new GameTeam("Atlético Goianiense", "ATG", "CAC", "Clube Atlético Goianiense",
                "Dragão", "Estádio Antônio Accioly", 40000,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 2);
        new GameTeam("Goiás", "GOI", "SEC", "Goiás Esporte Clube",
                "Esmeraldino", "Estádio Hailé Pinheiro", 60000,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 2);
        new GameTeam("Vila Nova", "VIL", "VNV", "Vila Nova Futebol Clube",
                "Tigre", "Estádio OBA", 10000,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 2);
        new GameTeam("Aparecidense", "APE", "EC", "Aparecida Esporte Clube",
                "Galo da Aparecidinha", "Estádio Municipal Annibal Batista de Toledo", 4800,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 4);
        new GameTeam("Anápolis", "ANA", "AAC", "Anapolina Esporte Clube",
                "Xata", "Estádio Jonas Duarte", 11000,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 3);
        new GameTeam("Goiatuba", "GOI", "GAC", "Goiatuba Esporte Clube",
                "Azulão do Vale", "Estádio Valdeir José de Oliveira", 8000,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 5);
        new GameTeam("Iporá", "IPO", "IEC", "Iporá Esporte Clube",
                "Lobão do Cerrado", "Estádio Ferreirão", 5000,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 7);
        new GameTeam("Morrinhos", "MOR", "MFC", "Morrinhos Futebol Clube",
                "Boi Verde", "Estádio João Vilela", 4000,
                "Goiás", "Centro-Oeste", "Brasil", "América do Sul", 8);

        // Maranhão
        new GameTeam("Sampaio Corrêa", "SAM", "SBC", "Sampaio Corrêa Futebol Clube",
                "Bolívia Querida", "Estádio Castelão", 40000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 4);
        new GameTeam("Moto Club", "MOT", "MCM", "Moto Club de São Luís",
                "Papão do Norte", "Estádio Castelão", 40000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 4);
        new GameTeam("Imperatriz", "IMP", "ECI", "Imperatriz Futebol Clube",
                "Cavalo de Aço", "Estádio Frei Epifânio D'Abadia", 10000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("Cordino", "COR", "AEC", "Associação Esportiva Cordino",
                "Onça do Vale", "Estádio Leozão", 8000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 6);
        new GameTeam("Juazeiro", "JUA", "JEC", "Juazeiro Social Clube",
                "Tricolor do Sertão", "Estádio Municipal de Juazeiro", 5000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 7);
        new GameTeam("Bacabal", "BAC", "BAC", "Bacabal Esporte Clube",
                "Leão do Mearim", "Estádio José Luís de Oliveira", 5000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 9);
        new GameTeam("Maranhão", "MAR", "MAC", "Maranhão Atlético Clube",
                "MAc", "Estádio Castelão", 40000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 10);
        new GameTeam("Tuntum", "TUN", "TEC", "Tuntum Esporte Clube",
                "Touro do Sertão", "Estádio Rafael Seabra", 5000,
                "Maranhão", "Nordeste", "Brasil", "América do Sul", 11);

        // Mato Grosso
        new GameTeam("Cuiabá", "CUI", "CEC", "Cuiabá Esporte Clube",
                "Dourado", "Arena Pantanal", 44000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 2);
        new GameTeam("Luverdense", "LUV", "LEC", "Luverdense Esporte Clube",
                "Verdão do Norte", "Estádio Municipal Passo das Emas", 10000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 4);
        new GameTeam("União Rondonópolis", "UNI", "URC", "União Esportiva Rondonópolis",
                "Verdão do Sul", "Estádio Municipal Luthero Lopes", 5000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 6);
        new GameTeam("Dom Bosco", "DBO", "DBC", "Dom Bosco Esporte Clube",
                "Salesiano", "Estádio Cinezão", 5000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 8);
        new GameTeam("Nova Mutum", "NMT", "NMC", "Nova Mutum Esporte Clube",
                "Tigre do Norte", "Estádio Valdir Doilho Wons", 5000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 9);
        new GameTeam("Sinop", "SIN", "SEC", "Sinop Futebol Clube",
                "Carcará do Norte", "Estádio Gigante do Norte", 13000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 10);
        new GameTeam("Mixto", "MIX", "ECMT", "Esporte Clube Mixto",
                "Tigre da várzea", "Estádio Dutrinha", 30000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 11);
        new GameTeam("Cacerense", "CAC", "CEC", "Cacerense Esporte Clube",
                "Fera da Fronteira", "Estádio Luiz de Carvalho", 10000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "América do Sul", 11);

        // Mato Grosso do Sul
        new GameTeam("Corumbaense", "COR", "CEC", "Corumbaense Futebol Clube",
                "Pantera do Pantanal", "Estádio Major José Lance Celestino", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 5);
        new GameTeam("Águia Negra", "AGN", "AAC", "Águia Negra Esporte Clube",
                "Auri-verde", "Estádio Ninho da Águia", 4000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 7);
        new GameTeam("Naviraiense", "NAV", "NAC", "Naviraiense Esporte Clube",
                "Jacaré do Pantanal", "Estádio Viroteirão", 4000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 8);
        new GameTeam("Dourados", "DOU", "DEC", "Dourados Atlético Clube",
                "Verdão da Fronteira", "Estádio Douradão", 20000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 9);
        new GameTeam("Sete de Setembro", "SET", "SSC", "Sete de Setembro Esporte Clube",
                "Alviverde", "Estádio Morenão", 44000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 10);
        new GameTeam("Ivinhema", "IVI", "IEC", "Ivinhema Esporte Clube",
                "Gavião do Sul", "Estádio Municipal de Ivinhema", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 11);
        new GameTeam("Chapadão do Sul", "CHS", "CEC", "Chapadão do Sul Esporte Clube",
                "Galo do Norte", "Estádio Municipal de Chapadão do Sul", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 11);
        new GameTeam("Maracaju", "MAC", "SEMC", "Sociedade Esportiva Maracaju",
                "Azulão do Maracaju", "Estádio Municipal Luiz Soares de Andrade", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "América do Sul", 11);

        // Minas Gerais
        new GameTeam("Cruzeiro", "CRU", "ECP", "Cruzeiro Esporte Clube",
                "Celeste", "Estádio Mineirão", 62170,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Atlético Mineiro", "CAM", "CAC", "Clube Atlético Mineiro",
                "Galo", "Estádio Mineirão", 62170,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("América", "AME", "AFC", "América Futebol Clube",
                "Coelho", "Independência", 23018,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 2);
        new GameTeam("Tombense", "TOM", "TEC", "Tombense Futebol Clube",
                "Gavião Carajás", "Estádio Municipal Soares de Azevedo", 3000,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 3);
        new GameTeam("Ipatinga", "IPA", "EICI", "Ipatinga Futebol Clube",
                "Tigre do Vale", "Estádio Municipal Ipatingão", 18000,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 4);
        new GameTeam("Athletic Club", "CAL", "AEC", "Caldense Esporte Clube",
                "Verdão da Mata", "Estádio Ronaldão", 7000,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 2);
        new GameTeam("Villa Nova", "VIL", "VNV", "Villa Nova Atlético Clube",
                "Leão do Bonfim", "Estádio Castor Cifuentes", 15000,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 6);
        new GameTeam("Uberlândia", "UBE", "ECUB", "Uberlândia Esporte Clube",
                "Verdão do Triângulo", "Estádio Municipal Parque do Sabiá", 53350,
                "Minas Gerais", "Sudeste", "Brasil", "América do Sul", 7);

        // Pará
        new GameTeam("Paysandu", "PAY", "SC", "Paysandu Sport Club",
                "Papão da Curuzu", "Estádio Leônidas de Castro", 20000,
                "Pará", "Norte", "Brasil", "América do Sul", 2);
        new GameTeam("Clube do Remo", "REM", "C", "Clube do Remo",
                "Leão Azul", "Estádio Baenão", 17826,
                "Pará", "Norte", "Brasil", "América do Sul", 2);
        new GameTeam("Tuna Luso Brasileira", "TUN", "SC", "Tuna Luso Brasileira",
                "A Brilhante", "Estádio Francisco Vasques", 5000,
                "Pará", "Norte", "Brasil", "América do Sul", 5);
        new GameTeam("Castanhal", "CAS", "EC", "Castanhal Esporte Clube",
                "Japiim da Amazônia", "Estádio Modelão", 8000,
                "Pará", "Norte", "Brasil", "América do Sul", 6);
        new GameTeam("Bragantino-PA", "BRA", "Clube", "Bragantino Clube do Pará",
                "Tubarão do Caeté", "Estádio Diogão", 10000,
                "Pará", "Norte", "Brasil", "América do Sul", 7);
        new GameTeam("Independente-PA", "IND", "EC", "Independente Esporte Clube",
                "Galo Elétrico", "Estádio Baenão", 17826,
                "Pará", "Norte", "Brasil", "América do Sul", 8);
        new GameTeam("Parauapebas", "PAR", "FC", "Parauapebas Futebol Clube",
                "Peixe Dourado", "Estádio Rosenão", 5000,
                "Pará", "Norte", "Brasil", "América do Sul", 9);
        new GameTeam("São Francisco", "SFP", "FC", "São Francisco Futebol Clube",
                "Furacão do Tapajós", "Estádio Municipal Colosso do Tapajós", 5000,
                "Pará", "Norte", "Brasil", "América do Sul", 10);

        // Paraíba
        new GameTeam("Botafogo-PB", "BOT", "EC", "Esporte Clube Botafogo",
                "Belo", "Estádio Almeidão", 25770,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("Treze", "TRE", "FC", "Treze Futebol Clube",
                "Galo da Vila", "Estádio Presidente Vargas", 6000,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 4);
        new GameTeam("Campinense", "CAM", "CLB", "Campinense Clube",
                "Raposa", "Estádio Renatão", 23000,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("Sousa", "SOU", "EC", "Sousa Esporte Clube",
                "Dinossauro do Sertão", "Estádio Marizão", 5000,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Nacional de Patos", "NAC", "EC", "Nacional Atlético Clube",
                "Canário do Sertão", "Estádio José Cavalcanti", 4000,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 9);
        new GameTeam("Auto Esporte", "AUT", "CE", "Auto Esporte Clube",
                "Macacão", "Estádio Mangabeira", 7000,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 10);
        new GameTeam("CSP", "CSP", "FC", "Clube Atlético do Sport Pernambucano",
                "Tigre do Sertão", "Estádio Arthur Marinho", 4000,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 11);
        new GameTeam("Queimadense", "QUE", "EC", "Queimadense Esporte Clube",
                "Carcará do Sertão", "Estádio Amigão", 4000,
                "Paraíba", "Nordeste", "Brasil", "América do Sul", 11);

        // Paraná
        new GameTeam("Athletico Paranaense", "CAP", "CAP", "Clube Atlético Paranaense",
                "Furacão", "Arena da Baixada", 42372,
                "Paraná", "Sul", "Brasil", "América do Sul", 2);
        new GameTeam("Coritiba", "CFC", "CFC", "Coritiba Foot Ball Club",
                "Coxa", "Estádio Couto Pereira", 40500,
                "Paraná", "Sul", "Brasil", "América do Sul", 2);
        new GameTeam("Operário Ferroviário", "OPE", "OFEC", "Operário Ferroviário Esporte Clube",
                "Fantasma", "Estádio Germano Krüger", 10000,
                "Paraná", "Sul", "Brasil", "América do Sul", 2);
        new GameTeam("Londrina", "LON", "LEC", "Londrina Esporte Clube",
                "Tubarão", "Estádio do Café", 30000,
                "Paraná", "Sul", "Brasil", "América do Sul", 3);
        new GameTeam("Paraná", "PAR", "PCC", "Paraná Clube",
                "Tricolor da Vila Capanema", "Estádio Durival Britto e Silva", 19000,
                "Paraná", "Sul", "Brasil", "América do Sul", 6);
        new GameTeam("Cascavel", "CAS", "CFC", "Cascavel Clube Recreativo",
                "Serpente Aurinegra", "Estádio Olímpico Regional Arnaldo Busatto", 28000,
                "Paraná", "Sul", "Brasil", "América do Sul", 7);
        new GameTeam("Maringá", "MAR", "MFC", "Maringá Futebol Clube",
                "Tricolor do Ingá", "Estádio Willie Davids", 21000,
                "Paraná", "Sul", "Brasil", "América do Sul", 3);
        new GameTeam("Rio Branco", "RIO", "RBC", "Rio Branco Sport Club",
                "Leão do Norte", "Estádio Gigante do Norte", 13000,
                "Paraná", "Sul", "Brasil", "América do Sul", 9);

        // Pernambuco
        new GameTeam("Sport", "SPO", "SCP", "Sport Club Recife",
                "Leão da Ilha", "Estádio Ilha do Retiro", 32775,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 1);
        new GameTeam("Náutico", "NAU", "CAC", "Clube Náutico Capibaribe",
                "Timbu", "Estádio dos Aflitos", 22850,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("Santa Cruz", "STC", "SCFC", "Santa Cruz Futebol Clube",
                "Tricolor do Arruda", "Estádio do Arruda", 60044,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Salgueiro", "SAL", "ASC", "Salgueiro Atlético Clube",
                "Carcará do Sertão", "Estádio Cornélio de Barros", 12000,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("Central", "CEN", "CEC", "Central Sport Club",
                "Patativa", "Estádio Luiz José de Lacerda", 12000,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 6);
        new GameTeam("Afogados da Ingazeira", "AFI", "AAFI", "Associação Atlética Afogados da Ingazeira",
                "Coruja", "Estádio Vianey de Sá", 5000,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 7);
        new GameTeam("Retrô", "RET", "FC", "Retrô Futebol Clube",
                "Fênix do Nordeste", "Estádio Arena de Pernambuco", 44184,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("Petrolina", "PET", "PFC", "Petrolina Social Futebol Clube",
                "Fera Sertaneja", "Estádio Paulo Coelho", 5000,
                "Pernambuco", "Nordeste", "Brasil", "América do Sul", 9);

        // Piauí
        new GameTeam("Corisabbá", "COR", "AC", "Associação Cori-Sabbá Futebol Clube",
                "Tubarão do Piauí", "Estádio Municipal Lindolfo Monteiro", 5000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Fluminense-PI", "FLU", "FCF", "Fluminense Futebol Clube do Piauí",
                "Vaqueiro do Poti", "Estádio Albertão", 44000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("River-PI", "RIV", "RCE", "River Atlético Clube",
                "Galo do Piauí", "Estádio Albertão", 44000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 7);
        new GameTeam("4 de Julho", "JUL", "EC", "Esporte Clube 4 de Julho",
                "Colorado", "Estádio Municipal de Piripiri", 8000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Parnahyba", "PAR", "SCP", "Sociedade Esportiva Parnahyba",
                "Azulino", "Estádio Pedro Alelaf", 5000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 9);
        new GameTeam("Altos", "ALT", "AAC", "Altos Esporte Clube",
                "Jacaré do Piauí", "Estádio Municipal Felipe Raulino", 5000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 10);
        new GameTeam("Picos", "PIC", "PFC", "Picos Futebol Clube",
                "Gavião do Piauí", "Estádio Municipal Lindolfo Monteiro", 5000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 11);
        new GameTeam("Cori-Sabbá", "COR", "AC", "Associação Cori-Sabbá Futebol Clube",
                "Tubarão do Piauí", "Estádio Municipal Lindolfo Monteiro", 5000,
                "Piauí", "Nordeste", "Brasil", "América do Sul", 11);

        // Rio de Janeiro
        new GameTeam("Flamengo", "FLA", "CR", "Clube de Regatas do Flamengo",
                "Mengão", "Estádio do Maracanã", 78838,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Fluminense", "FLU", "FCF", "Fluminense Football Club",
                "Tricolor das Laranjeiras", "Estádio do Maracanã", 78838,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Vasco da Gama", "VAS", "CRVG", "Club de Regatas Vasco da Gama",
                "Cruzmaltino", "Estádio São Januário", 21880,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Botafogo", "BOT", "FR", "Botafogo de Futebol e Regatas",
                "Alvinegro", "Estádio Nilton Santos", 46931,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Volta Redonda", "VOL", "FCVR", "Volta Redonda Futebol Clube",
                "Esquadrão de Aço", "Estádio Raulino de Oliveira", 20000,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 2);
        new GameTeam("Madureira", "MAD", "EC", "Madureira Esporte Clube",
                "Tricolor Suburbano", "Estádio Conselheiro Galvão", 5000,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 4);
        new GameTeam("Bangu", "BAN", "AAC", "Bangu Atlético Clube",
                "Alvirrubro", "Estádio Moça Bonita", 9000,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 5);
        new GameTeam("Portuguesa", "POR", "CA", "Portuguesa da Ilha Futebol Clube",
                "Lusa Insulana", "Estádio Luso Brasileiro", 18000,
                "Rio de Janeiro", "Sudeste", "Brasil", "América do Sul", 6);

        // Rio Grande do Norte
        new GameTeam("ABC", "ABC", "FC", "Associação Brasileira de Clubes",
                "Alvinegro", "Estádio Frasqueirão", 15000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("América de Natal", "AME", "AEC", "América Futebol Clube",
                "Mecão", "Estádio Arena das Dunas", 31655,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 6);
        new GameTeam("Globo FC", "GLO", "FEC", "Globo Futebol Clube",
                "Xavante", "Estádio Barrettão", 10000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 7);
        new GameTeam("Potiguar", "POT", "EC", "Potiguar Esporte Clube",
                "Alvinegro de Mossoró", "Estádio Nogueirão", 10000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Santa Cruz de Natal", "STC", "AC", "Santa Cruz Futebol Clube",
                "Tricolor do Arruda", "Estádio Iberezão", 5000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 9);
        new GameTeam("Assu", "ASS", "AC", "Associação Cultural Esportiva Assu",
                "Camaleão do Vale", "Estádio Edgarzão", 4000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 10);
        new GameTeam("Força e Luz", "FOR", "AC", "Associação Atlética Força e Luz",
                "Lampião do Poti", "Estádio Barretão", 10000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 11);
        new GameTeam("Nova Cruz", "NOV", "CEC", "Nova Cruz Esporte Clube",
                "Mecão do Agreste", "Estádio José Nazareno", 5000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "América do Sul", 11);

        // Rio Grande do Sul
        new GameTeam("Grêmio", "GRE", "FBPA", "Grêmio Foot-Ball Porto Alegrense",
                "Tricolor Gaúcho", "Arena do Grêmio", 55662,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 1);
        new GameTeam("Internacional", "INT", "SCIA", "Sport Club Internacional",
                "Colorado", "Estádio Beira-Rio", 50128,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 1);
        new GameTeam("Juventude", "JUV", "EC", "Esporte Clube Juventude",
                "Papo", "Estádio Alfredo Jaconi", 23734,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 1);
        new GameTeam("Ypiranga", "YPI", "EC", "Ypiranga Futebol Clube",
                "Canarinho", "Estádio Colosso da Lagoa", 19000,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 3);
        new GameTeam("Caxias", "CAX", "EC", "Clube Esportivo Caxias",
                "Grená", "Estádio Centenário", 22132,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 3);
        new GameTeam("Brasil de Pelotas", "BRA", "EP", "Esporte Clube Brasil",
                "Xavante", "Estádio Bento Freitas", 18000,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 4);
        new GameTeam("São José", "SJO", "EPCS", "Esporte Clube São José",
                "Zequinha", "Estádio Passo D'Areia", 10000,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 5);
        new GameTeam("Pelotas", "PEL", "EC", "Esporte Clube Pelotas",
                "Lobisomem", "Estádio Boca do Lobo", 18000,
                "Rio Grande do Sul", "Sul", "Brasil", "América do Sul", 7);

        // Rondônia
        new GameTeam("Real Ariquemes", "REA", "EC", "Real Ariquemes Esporte Clube",
                "Furacão do Vale do Jamari", "Estádio Gentil Valério", 3000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 4);
        new GameTeam("Porto Velho", "POR", "EC", "Porto Velho Esporte Clube",
                "Locomotiva", "Estádio Aluízio Ferreira", 7000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 5);
        new GameTeam("Rondoniense", "RON", "SC", "Sociedade Esportiva Rondoniense",
                "Verdão de Rondônia", "Estádio Aluízio Ferreira", 7000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 6);
        new GameTeam("Genus", "GEN", "FC", "Genus Futebol Clube",
                "Aurigrená", "Estádio Aluízio Ferreira", 7000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 7);
        new GameTeam("Vilhena", "VIL", "EC", "Vilhena Esporte Clube",
                "Tigre da Fronteira", "Estádio Municipal de Vilhena", 5000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 8);
        new GameTeam("Guajará", "GUA", "EC", "Guajará Esporte Clube",
                "Guaçu", "Estádio Municipal de Guajará-Mirim", 5000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 9);
        new GameTeam("União Cacoalense", "UCA", "FC", "União Cacoalense Futebol Clube",
                "União", "Estádio Aglair Tonelli", 5000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("Pimentense", "PIM", "EC", "Pimentense Esporte Clube",
                "Galo do Norte", "Estádio Luiz Alves de Oliveira", 5000,
                "Rondônia", "Norte", "Brasil", "América do Sul", 11);

        // Roraima
        new GameTeam("São Raimundo-RR", "SRR", "EC", "São Raimundo Esporte Clube",
                "Mundão", "Estádio Ribeirão", 3000,
                "Roraima", "Norte", "Brasil", "América do Sul", 4);
        new GameTeam("Baré", "BAR", "EC", "Baré Esporte Clube",
                "Colorado", "Estádio Canarinho", 4000,
                "Roraima", "Norte", "Brasil", "América do Sul", 6);
        new GameTeam("Náutico-RR", "NAU", "EC", "Náutico Futebol Clube",
                "Alvirrubro", "Estádio Flamarion Vasconcelos", 5000,
                "Roraima", "Norte", "Brasil", "América do Sul", 7);
        new GameTeam("Rio Negro-RR", "RNR", "EC", "Rio Negro Futebol Clube",
                "Galoucura", "Estádio Canarinho", 4000,
                "Roraima", "Norte", "Brasil", "América do Sul", 8);
        new GameTeam("Atlético Roraima", "ATR", "EC", "Atlético Roraima Clube",
                "Berço dos Craques", "Estádio Flamarion Vasconcelos", 5000,
                "Roraima", "Norte", "Brasil", "América do Sul", 9);
        new GameTeam("Grêmio Atlético Sampaio", "GAS", "EC", "Grêmio Atlético Sampaio",
                "Galo Carijó", "Estádio Ribeirão", 3000,
                "Roraima", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("São Paulo-RR", "SPR", "FC", "São Paulo Futebol Clube",
                "Tricolor da Fronteira", "Estádio Canarinho", 4000,
                "Roraima", "Norte", "Brasil", "América do Sul", 11);
        new GameTeam("Independente-RR", "IND", "EC", "Independente Esporte Clube",
                "Leão do Norte", "Estádio Flamarion Vasconcelos", 5000,
                "Roraima", "Norte", "Brasil", "América do Sul", 11);

        // Santa Catarina
        new GameTeam("Criciúma", "CRI", "EC", "Criciúma Esporte Clube",
                "Tigre do Sul", "Estádio Heriberto Hülse", 19900,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 2);
        new GameTeam("Avaí", "AVA", "FC", "Avaí Futebol Clube",
                "Leão da Ilha", "Estádio Ressacada", 17826,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 2);
        new GameTeam("Chapecoense", "CHA", "ACF", "Associação Chapecoense de Futebol",
                "Verdão do Oeste", "Arena Condá", 20089,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 2);
        new GameTeam("Brusque", "BRU", "FCF", "Brusque Futebol Clube",
                "Quadricolor do Vale", "Estádio Augusto Bauer", 10000,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 3);
        new GameTeam("Figueirense", "FIG", "FCF", "Figueirense Futebol Clube",
                "Furacão do Estreito", "Estádio Orlando Scarpelli", 19000,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 3);
        new GameTeam("Joinville", "JOI", "ECJ", "Joinville Esporte Clube",
                "JEC", "Estádio Arena Joinville", 22400,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 4);
        new GameTeam("Marcílio Dias", "MAR", "ACD", "Marcílio Dias Futebol Clube",
                "Marinheiro", "Estádio Dr. Hercílio Luz", 7000,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 5);
        new GameTeam("Concórdia", "CON", "SCC", "Sociedade Esportiva Concórdia",
                " Galo do Oeste", "Estádio Domingos Machado de Lima", 5000,
                "Santa Catarina", "Sul", "Brasil", "América do Sul", 6);

        // São Paulo
        new GameTeam("Corinthians", "COR", "SC", "Sport Club Corinthians Paulista",
                "Timão", "Estádio Neo Química Arena", 47605,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Palmeiras", "PAL", "SE", "Sociedade Esportiva Palmeiras",
                "Verdão", "Allianz Parque", 43713,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("São Paulo", "SPO", "FC", "São Paulo Futebol Clube",
                "Tricolor", "Estádio Cícero Pompeu de Toledo (Morumbi)", 72030,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Red Bull Bragantino", "RBB", "SA", "Red Bull Bragantino Sociedade Anônima",
                "Massa Bruta", "Estádio Nabi Abi Chedid", 17128,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Santos", "SAN", "FC", "Santos Futebol Clube",
                "Peixe", "Estádio Urbano Caldeira (Vila Belmiro)", 16068,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Ponte Preta", "PON", "EA", "Associação Atlética Ponte Preta",
                "Macaca", "Estádio Moisés Lucarelli (Majestoso)", 19728,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 3);
        new GameTeam("Mirassol", "MIR", "FC", "Mirassol Futebol Clube",
                "Leão", "Estádio Municipal José Maria de Campos Maia", 15000,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 1);
        new GameTeam("Novorizontino", "NOV", "EC", "Novorizontino Esporte Clube",
                "Tigre do Vale", "Estádio Jorge Ismael de Biasi", 16000,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 2);
        new GameTeam("Ituano", "ITU", "FC", "Ituano Futebol Clube",
                "Galo de Itu", "Estádio Novelli Júnior", 18000,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 3);
        new GameTeam("São Bernardo FC", "SBC", "FC", "São Bernardo Futebol Clube",
                "Bernô", "Estádio Primeiro de Maio", 15000,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 3);
        new GameTeam("Botafogo-SP", "BOT", "SA", "Botafogo Futebol Clube Sociedade Anônima do Futebol",
                "Pantera", "Estádio Santa Cruz", 28778,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 2);
        new GameTeam("Guarani", "GUA", "FC", "Guarani Futebol Clube",
                "Bugre", "Estádio Brinco de Ouro da Princesa", 29130,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 3);
        new GameTeam("Ferroviária", "FER", "SA", "Associação Ferroviária de Esportes",
                "Ferrinha", "Estádio Fonte Luminosa", 20000,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 2);
        new GameTeam("Portuguesa", "POR", "TE", "Associação Portuguesa de Desportos",
                "Lusa", "Estádio Canindé", 70000,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 4);
        new GameTeam("América-SP", "AME", "SP", "América Futebol Clube (SP)",
                "Coelho", "Estádio Independência", 20000,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 5);
        new GameTeam("Santo André", "SAN", "EA", "Esporte Clube Santo André",
                "Ramalhão", "Estádio Bruno José Daniel", 14400,
                "São Paulo", "Sudeste", "Brasil", "América do Sul", 6);

        // Sergipe
        new GameTeam("Confiança", "CON", "SCFC", "Sociedade Esportiva Confiança",
                "Dragão do Bairro Industrial", "Estádio Batistão", 15500,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("Sergipe", "SER", "CSE", "Club Sportivo Sergipe",
                "Vermelhinho", "Estádio João Hora de Oliveira", 16000,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 5);
        new GameTeam("Itabaiana", "ITA", "FC", "Itabaiana Futebol Clube",
                "Tremendão", "Estádio Etelvino Mendonça", 10000,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 3);
        new GameTeam("Lagarto", "LAG", "FC", "Lagarto Futebol Clube",
                "Vermelhinho do Agreste", "Estádio Olímpico de Lagarto", 8000,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 6);
        new GameTeam("América de Propriá", "AME", "CEAD", "Centro Esportivo e Atlético de Propriá",
                "Mecão do Sertão", "Estádio Municipal João Alves Filho", 5000,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 7);
        new GameTeam("Freipaulistano", "FRE", "FCF", "Freipaulistano Futebol Clube",
                "Touro do Sertão", "Estádio Municipal de Frei Paulo", 5000,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 8);
        new GameTeam("Guarany de Porto da Folha", "GUA", "ADC", "Associação Desportiva Guarany",
                "Periquito do Sertão", "Estádio Municipal de Porto da Folha", 5000,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 9);
        new GameTeam("Dorense", "DOR", "SE", "Dorense Sociedade Esportiva",
                "Leão do Sertão", "Estádio Ariston Azevedo", 5000,
                "Sergipe", "Nordeste", "Brasil", "América do Sul", 10);

        // Tocantins
        new GameTeam("Palmas", "PAL", "SE", "Sociedade Esportiva Palmas",
                "Verdão do Norte", "Estádio Nilton Santos", 12000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 4);
        new GameTeam("Tocantinópolis", "TOC", "EC", "Tocantinópolis Esporte Clube",
                "Tigre do Norte", "Estádio Ribeirão", 8000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 4);
        new GameTeam("Interporto", "INT", "FC", "Interporto Futebol Clube",
                "Porto", "Estádio General Sampaio", 7000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 6);
        new GameTeam("Gurupi", "GUR", "EC", "Gurupi Esporte Clube",
                "Gavião do Norte", "Estádio Resendão", 2000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 7);
        new GameTeam("Araguaína", "ARA", "FAC", "Araguaína Futebol Clube",
                "Leão do Norte", "Estádio Leônidas de Castro", 8000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 8);
        new GameTeam("Jataiense", "JAT", "GE", "Jataiense Esporte Clube",
                "Canarinho do Araguaia", "Estádio Municipal de Jataí", 5000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 9);
        new GameTeam("Tocantins de Miracema", "TOM", "EC", "Tocantins Esporte Clube de Miracema",
                "Tigre do Tocantins", "Estádio Castanheirão", 5000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 10);
        new GameTeam("Colinas", "COL", "FEC", "Colinas Esporte Clube",
                "Cachorrão do Sul", "Estádio Bigolão", 5000,
                "Tocantins", "Norte", "Brasil", "América do Sul", 11);

        // Argentina
        new GameTeam("Boca Juniors", "BOC", "CABJ", "Club Atlético Boca Juniors",
                "Xeneizes", "Estadio Alberto J. Armando (La Bombonera)", 54000,
                "Buenos Aires", "Buenos Aires", "Argentina", "América do Sul", 0);
        new GameTeam("River Plate", "RIV", "CARP", "Club Atlético River Plate",
                "Millonarios", "Estadio Monumental", 70074,
                "Buenos Aires", "Buenos Aires", "Argentina", "América do Sul", 0);
        new GameTeam("Independiente", "IND", "CAI", "Club Atlético Independiente",
                "Rey de Copas", "Estadio Libertadores de América", 48314,
                "Avellaneda", "Buenos Aires", "Argentina", "América do Sul", 0);
        new GameTeam("Racing Club", "RAC", "RC", "Racing Club",
                "La Academia", "Estadio Presidente Perón", 51389,
                "Avellaneda", "Buenos Aires", "Argentina", "América do Sul", 0);
        new GameTeam("San Lorenzo", "SLO", "CASLA", "Club Atlético San Lorenzo de Almagro",
                "El Ciclón", "Estadio Pedro Bidegain", 47357,
                "Buenos Aires", "Buenos Aires", "Argentina", "América do Sul", 0);
        new GameTeam("Vélez Sarsfield", "VEL", "CAVS", "Club Atlético Vélez Sarsfield",
                "El Fortín", "Estadio José Amalfitani", 49540,
                "Buenos Aires", "Buenos Aires", "Argentina", "América do Sul", 0);
        new GameTeam("Estudiantes", "EST", "CGE", "Club Estudiantes de La Plata",
                "Los Pincharratas", "Estadio Jorge Luis Hirschi", 35000,
                "La Plata", "Buenos Aires", "Argentina", "América do Sul", 0);
        new GameTeam("Newell's Old Boys", "NOB", "CANOB", "Club Atlético Newell's Old Boys",
                "La Lepra", "Estadio Marcelo Bielsa", 38095,
                "Rosario", "Santa Fe", "Argentina", "América do Sul", 0);

        // Bolívia
        new GameTeam("Bolívar", "BOL", "CBB", "Club Bolívar",
                "La Academia", "Estadio Hernando Siles", 41943,
                "La Paz", "La Paz", "Bolívia", "América do Sul", 0);
        new GameTeam("The Strongest", "STR", "CTS", "Club The Strongest",
                "El Tigre", "Estadio Hernando Siles", 41943,
                "La Paz", "La Paz", "Bolívia", "América do Sul", 0);
        new GameTeam("Wilstermann", "WIL", "JAW", "Club Jorge Wilstermann",
                "Aviadores", "Estadio Félix Capriles", 32000,
                "Cochabamba", "Cochabamba", "Bolívia", "América do Sul", 0);
        new GameTeam("Oriente Petrolero", "ORI", "OP", "Club Deportivo Oriente Petrolero",
                "Albiverdes", "Estadio Ramón Tahuichi Aguilera", 35000,
                "Santa Cruz de la Sierra", "Santa Cruz", "Bolívia", "América do Sul", 0);
        new GameTeam("Blooming", "BLO", "CB", "Club Blooming",
                "La Academia Cruceña", "Estadio Ramón Tahuichi Aguilera", 35000,
                "Santa Cruz de la Sierra", "Santa Cruz", "Bolívia", "América do Sul", 0);
        new GameTeam("Always Ready", "ALW", "CAR", "Club Always Ready",
                "Millonario", "Estadio Municipal de El Alto", 25000,
                "El Alto", "La Paz", "Bolívia", "América do Sul", 0);
        new GameTeam("Real Potosí", "RPO", "CRP", "Club Real Potosí",
                "Los Lilas", "Estadio Víctor Agustín Ugarte", 32000,
                "Potosí", "Potosí", "Bolívia", "América do Sul", 0);
        new GameTeam("Nacional Potosí", "NPO", "CNP", "Club Atlético Nacional Potosí",
                "Rancho Guitarra", "Estadio Víctor Agustín Ugarte", 32000,
                "Potosí", "Potosí", "Bolívia", "América do Sul", 0);

        // Chile
        new GameTeam("Colo-Colo", "COL", "CSDCC", "Club Social y Deportivo Colo-Colo",
                "Los Albos", "Estadio Monumental David Arellano", 47347,
                "Santiago", "Região Metropolitana", "Chile", "América do Sul", 0);
        new GameTeam("Universidad de Chile", "UCH", "CFUCH", "Club de Fútbol Universidad de Chile",
                "La U", "Estadio Nacional Julio Martínez Prádanos", 48665,
                "Santiago", "Região Metropolitana", "Chile", "América do Sul", 0);
        new GameTeam("Universidad Católica", "UCA", "CDUC", "Club Deportivo Universidad Católica",
                "Los Cruzados", "Estadio San Carlos de Apoquindo", 14000,
                "Santiago", "Região Metropolitana", "Chile", "América do Sul", 0);
        new GameTeam("Cobreloa", "COB", "CDC", "Club de Deportes Cobreloa",
                "Los Zorros del Desierto", "Estadio Zorros del Desierto", 12000,
                "Calama", "Antofagasta", "Chile", "América do Sul", 2);
        new GameTeam("Unión Española", "UES", "CUE", "Club Unión Española",
                "Los Hispanos", "Estadio Santa Laura", 22000,
                "Santiago", "Região Metropolitana", "Chile", "América do Sul", 0);
        new GameTeam("Audax Italiano", "AUD", "AIFC", "Audax Italiano La Florida",
                "Los Tanos", "Estadio Bicentenario de La Florida", 12000,
                "Santiago", "Região Metropolitana", "Chile", "América do Sul", 0);
        new GameTeam("Huachipato", "HUA", "CDH", "Club Deportivo Huachipato",
                "Acereros", "Estadio CAP", 10500,
                "Talcahuano", "Biobío", "Chile", "América do Sul", 0);
        new GameTeam("Palestino", "PAL", "CDP", "Club Deportivo Palestino",
                "Árabes", "Estadio Municipal de La Cisterna", 12000,
                "Santiago", "Região Metropolitana", "Chile", "América do Sul", 0);
        new GameTeam("O'Higgins", "OHI", "CDOH", "Club Deportivo O'Higgins",
                "Los Celestes", "Estadio El Teniente", 14450,
                "Rancagua", "O'Higgins", "Chile", "América do Sul", 0);

        // Colômbia
        new GameTeam("Atlético Nacional", "ATN", "AN", "Club Atlético Nacional S.A.",
                "Verdolagas", "Estadio Atanasio Girardot", 40043,
                "Medellín", "Antioquia", "Colômbia", "América do Sul", 0);
        new GameTeam("Millonarios", "MIL", "MFC", "Millonarios Fútbol Club",
                "Los Embajadores", "Estadio El Campín", 36000,
                "Bogotá", "Distrito Capital", "Colômbia", "América do Sul", 0);
        new GameTeam("América de Cali", "AME", "ADC", "América de Cali S.A.",
                "Los Diablos Rojos", "Estadio Pascual Guerrero", 35405,
                "Cali", "Valle del Cauca", "Colômbia", "América do Sul", 0);
        new GameTeam("Deportivo Cali", "CAL", "DC", "Asociación Deportivo Cali",
                "Los Azucareros", "Estadio Deportivo Cali", 52000,
                "Cali", "Valle del Cauca", "Colômbia", "América do Sul", 0);
        new GameTeam("Independiente Santa Fe", "ISF", "ISF", "Independiente Santa Fe S.A.",
                "Los Cardenales", "Estadio El Campín", 36000,
                "Bogotá", "Distrito Capital", "Colômbia", "América do Sul", 0);
        new GameTeam("Junior", "JUN", "CDPJ", "Club Deportivo Popular Junior F.C. S.A.",
                "Los Tiburones", "Estadio Metropolitano Roberto Meléndez", 46692,
                "Barranquilla", "Atlántico", "Colômbia", "América do Sul", 0);
        new GameTeam("Independiente Medellín", "DIM", "DIM", "Deportivo Independiente Medellín S.A.",
                "El Poderoso de la Montaña", "Estadio Atanasio Girardot", 40043,
                "Medellín", "Antioquia", "Colômbia", "América do Sul", 0);
        new GameTeam("Once Caldas", "ONC", "OC", "Corporación Deportiva Once Caldas",
                "El Blanco Blanco", "Estadio Palogrande", 36553,
                "Manizales", "Caldas", "Colômbia", "América do Sul", 0);

        // Equador
        new GameTeam("Barcelona SC", "BAR", "BSC", "Barcelona Sporting Club",
                "Ídolo del Ecuador", "Estadio Monumental Isidro Romero Carbo", 59354,
                "Guayaquil", "Guayas", "Equador", "América do Sul", 0);
        new GameTeam("Emelec", "EME", "CSE", "Club Sport Emelec",
                "El Bombillo", "Estadio George Capwell", 40000,
                "Guayaquil", "Guayas", "Equador", "América do Sul", 0);
        new GameTeam("LDU Quito", "LDU", "LDUQ", "Liga Deportiva Universitaria de Quito",
                "Los Albos", "Estadio Rodrigo Paz Delgado", 41575,
                "Quito", "Pichincha", "Equador", "América do Sul", 0);
        new GameTeam("Independiente del Valle", "IDV", "IDV", "Club de Alto Rendimiento Especializado Independiente del Valle",
                "Los Negriazules", "Estadio Banco Guayaquil", 12000,
                "Sangolquí", "Pichincha", "Equador", "América do Sul", 0);
        new GameTeam("El Nacional", "NAC", "CDN", "Club Deportivo El Nacional",
                "Los Puros Criollos", "Estadio Olímpico Atahualpa", 35000,
                "Quito", "Pichincha", "Equador", "América do Sul", 0);
        new GameTeam("Deportivo Cuenca", "DCU", "DC", "Club Deportivo Cuenca",
                "Los Morlacos", "Estadio Alejandro Serrano Aguilar", 16540,
                "Cuenca", "Azuay", "Equador", "América do Sul", 0);
        new GameTeam("Aucas", "AUC", "SDA", "Sociedad Deportiva Aucas",
                "Los Orientales", "Estadio Gonzalo Pozo Ripalda", 18240,
                "Quito", "Pichincha", "Equador", "América do Sul", 0);
        new GameTeam("Mushuc Runa", "MUS", "MRSC", "Mushuc Runa Sporting Club",
                "El Ponchito", "Estadio Cooperativa Mushuc Runa", 8000,
                "Ambato", "Tungurahua", "Equador", "América do Sul", 0);

        // Paraguai
        new GameTeam("Olimpia", "OLI", "CAO", "Club Olimpia",
                "El Decano", "Estadio Manuel Ferreira", 22000,
                "Asunción", "Asunción", "Paraguai", "América do Sul", 0);
        new GameTeam("Cerro Porteño", "CER", "CCP", "Club Cerro Porteño",
                "El Ciclón", "Estadio General Pablo Rojas", 45000,
                "Asunción", "Asunción", "Paraguai", "América do Sul", 0);
        new GameTeam("Libertad", "LIB", "CL", "Club Libertad",
                "Gumarelo", "Estadio Dr. Nicolás Leoz", 10000,
                "Asunción", "Asunción", "Paraguai", "América do Sul", 0);
        new GameTeam("Guaraní", "GUA", "CAG", "Club Guaraní",
                "El Legendario", "Estadio Rogelio Livieres", 8000,
                "Asunción", "Asunción", "Paraguai", "América do Sul", 0);
        new GameTeam("Nacional", "NAC", "CN", "Club Nacional",
                "La Academia", "Estadio Arsenio Erico", 5000,
                "Asunción", "Asunción", "Paraguai", "América do Sul", 0);
        new GameTeam("Sol de América", "SOL", "CSDA", "Club Sol de América",
                "Los Danzarines", "Estadio Luis Alfonso Giagni", 5000,
                "Villa Elisa", "Central", "Paraguai", "América do Sul", 0);
        new GameTeam("Sportivo Luqueño", "SLU", "CSL", "Club Sportivo Luqueño",
                "Chanchón", "Estadio Feliciano Cáceres", 25000,
                "Luque", "Central", "Paraguai", "América do Sul", 0);
        new GameTeam("General Díaz", "GDI", "CGD", "Club General Díaz",
                "Águias", "Estadio General Adrián Jara", 8000,
                "Luque", "Central", "Paraguai", "América do Sul", 0);

        // Peru
        new GameTeam("Alianza Lima", "ALI", "CAA", "Club Alianza Lima",
                "Los Íntimos", "Estadio Alejandro Villanueva", 35000,
                "Lima", "Lima", "Peru", "América do Sul", 0);
        new GameTeam("Universitario", "UNI", "CUF", "Club Universitario de Deportes",
                "La U", "Estadio Monumental", 80093,
                "Lima", "Lima", "Peru", "América do Sul", 0);
        new GameTeam("Sporting Cristal", "SCR", "CSC", "Club Sporting Cristal",
                "Los Cerveceros", "Estadio Alberto Gallardo", 20000,
                "Lima", "Lima", "Peru", "América do Sul", 0);
        new GameTeam("FBC Melgar", "MEL", "FBCM", "Foot Ball Club Melgar",
                "Los Rojinegros", "Estadio Monumental Virgen de Chapi", 60000,
                "Arequipa", "Arequipa", "Peru", "América do Sul", 0);
        new GameTeam("Cienciano", "CIE", "CC", "Club Cienciano",
                "Los Imperiales", "Estadio Inca Garcilaso de la Vega", 42056,
                "Cusco", "Cusco", "Peru", "América do Sul", 0);
        new GameTeam("Deportivo Municipal", "DEM", "CDM", "Club Centro Deportivo Municipal",
                "La Academia", "Estadio Iván Elías Moreno", 10000,
                "Lima", "Lima", "Peru", "América do Sul", 0);
        new GameTeam("Sport Boys", "SPB", "SBA", "Sport Boys Association",
                "La Misilera", "Estadio Miguel Grau", 17000,
                "Callao", "Callao", "Peru", "América do Sul", 0);
        new GameTeam("UTC", "UTC", "UTC", "Universidad Técnica de Cajamarca",
                "El Gavilán del Norte", "Estadio Héroes de San Ramón", 18000,
                "Cajamarca", "Cajamarca", "Peru", "América do Sul", 0);

        // Uruguai
        new GameTeam("Nacional", "NAC", "CNdeF", "Club Nacional de Football",
                "El Bolso", "Estadio Gran Parque Central", 34000,
                "Montevidéu", "Montevidéu", "Uruguai", "América do Sul", 0);
        new GameTeam("Peñarol", "PEN", "CAP", "Club Atlético Peñarol",
                "Los Carboneros", "Estadio Campeón del Siglo", 40000,
                "Montevidéu", "Montevidéu", "Uruguai", "América do Sul", 0);
        new GameTeam("Defensor Sporting", "DEF", "DSC", "Defensor Sporting Club",
                "Los Violetas", "Estadio Luis Franzini", 18000,
                "Montevidéu", "Montevidéu", "Uruguai", "América do Sul", 0);
        new GameTeam("Danubio", "DAN", "DFC", "Danubio Fútbol Club",
                "La Franja", "Estadio Jardines del Hipódromo", 18000,
                "Montevidéu", "Montevidéu", "Uruguai", "América do Sul", 0);
        new GameTeam("Liverpool", "LIV", "LFC", "Liverpool Fútbol Club",
                "Los Negriazules", "Estadio Belvedere", 8500,
                "Montevidéu", "Montevidéu", "Uruguai", "América do Sul", 0);
        new GameTeam("River Plate", "RIV", "CARP", "Club Atlético River Plate",
                "Darseneros", "Estadio Saroldi", 6000,
                "Montevidéu", "Montevidéu", "Uruguai", "América do Sul", 0);
        new GameTeam("Montevideo Wanderers", "MW", "MWFC", "Montevideo Wanderers Fútbol Club",
                "Bohemios", "Parque Alfredo Víctor Viera", 10000,
                "Montevidéu", "Montevidéu", "Uruguai", "América do Sul", 0);
        new GameTeam("Plaza Colonia", "PLC", "PCC", "Club Plaza Colonia de Deportes",
                "Los Patas Blancas", "Estadio Juan Prandi", 12000,
                "Colonia del Sacramento", "Colonia", "Uruguai", "América do Sul", 0);

        // Venezuela
        new GameTeam("Caracas FC", "CAR", "CFC", "Caracas Fútbol Club",
                "Los Rojos del Ávila", "Estadio Olímpico de la UCV", 24000,
                "Caracas", "Distrito Capital", "Venezuela", "América do Sul", 0);
        new GameTeam("Deportivo Táchira", "TAC", "DTFC", "Deportivo Táchira Fútbol Club",
                "Aurinegros", "Estadio Polideportivo de Pueblo Nuevo", 38000,
                "San Cristóbal", "Táchira", "Venezuela", "América do Sul", 0);
        new GameTeam("Deportivo La Guaira", "DLG", "DLGFC", "Deportivo La Guaira Fútbol Club",
                "Naranjas", "Estadio Olímpico de la UCV", 24000,
                "Caracas", "Distrito Capital", "Venezuela", "América do Sul", 0);
        new GameTeam("Zamora FC", "ZAM", "ZFC", "Zamora Fútbol Club",
                "Blanquinegros", "Estadio Agustín Tovar", 30000,
                "Barinas", "Barinas", "Venezuela", "América do Sul", 0);
        new GameTeam("Mineros de Guayana", "MIN", "MDGFC", "Mineros de Guayana Fútbol Club",
                "Negriazules", "Estadio CTE Cachamay", 41600,
                "Puerto Ordaz", "Bolívar", "Venezuela", "América do Sul", 0);
        new GameTeam("Estudiantes de Mérida", "EST", "EMFC", "Estudiantes de Mérida Fútbol Club",
                "Académicos", "Estadio Metropolitano de Mérida", 42000,
                "Mérida", "Mérida", "Venezuela", "América do Sul", 0);
        new GameTeam("Aragua FC", "ARA", "AFC", "Aragua Fútbol Club",
                "Aurirrojos", "Estadio Olímpico Hermanos Ghersi Páez", 14500,
                "Maracay", "Aragua", "Venezuela", "América do Sul", 0);
        new GameTeam("Carabobo FC", "CAR", "CFC", "Carabobo Fútbol Club",
                "Granates", "Estadio Misael Delgado", 10000,
                "Valencia", "Carabobo", "Venezuela", "América do Sul", 0);

        // Américas
        // México
        new GameTeam("América", "AME", "CFA", "Club de Fútbol América",
                "Las Águilas", "Estadio Azteca", 87000,
                "Cidade do México", "Distrito Federal", "México", "América do Norte", 0);
        new GameTeam("Guadalajara", "GUA", "CDG", "Club Deportivo Guadalajara",
                "Chivas", "Estadio Akron", 49350,
                "Zapopan", "Jalisco", "México", "América do Norte", 0);
        new GameTeam("Cruz Azul", "CRU", "CFC", "Cruz Azul Fútbol Club",
                "La Máquina", "Estadio Azteca", 87000,
                "Cidade do México", "Distrito Federal", "México", "América do Norte", 0);
        new GameTeam("Pumas UNAM", "PUM", "CFP", "Club de Fútbol Universidad Nacional",
                "Los Pumas", "Estadio Olímpico Universitario", 72000,
                "Cidade do México", "Distrito Federal", "México", "América do Norte", 0);
        new GameTeam("Monterrey", "MON", "CFM", "Club de Fútbol Monterrey",
                "Rayados", "Estadio BBVA", 53500,
                "Guadalupe", "Nuevo León", "México", "América do Norte", 0);
        new GameTeam("Tigres UANL", "TIG", "CFT", "Club de Fútbol Tigres de la Universidad Autónoma de Nuevo León",
                "Los Tigres", "Estadio Universitario", 42000,
                "San Nicolás de los Garza", "Nuevo León", "México", "América do Norte", 0);
        new GameTeam("Toluca", "TOL", "CDT", "Deportivo Toluca Fútbol Club",
                "Los Diablos Rojos", "Estadio Nemesio Díez", 31000,
                "Toluca", "Estado do México", "México", "América do Norte", 0);
        new GameTeam("Santos Laguna", "SAN", "CLF", "Club Santos Laguna",
                "Guerreros", "Estadio TSM Corona", 30000,
                "Torreón", "Coahuila", "México", "América do Norte", 0);

        // Estados Unidos
        new GameTeam("LA Galaxy", "LAG", "LAG", "Los Angeles Galaxy",
                "Galaxy", "Dignity Health Sports Park", 27000,
                "Carson", "Califórnia", "Estados Unidos", "América do Norte", 0);
        new GameTeam("Seattle Sounders", "SEA", "SSFC", "Seattle Sounders FC",
                "Sounders", "Lumen Field", 72000,
                "Seattle", "Washington", "Estados Unidos", "América do Norte", 0);
        new GameTeam("Atlanta United", "ATL", "AUFC", "Atlanta United FC",
                "The Five Stripes", "Mercedes-Benz Stadium", 71000,
                "Atlanta", "Geórgia", "Estados Unidos", "América do Norte", 0);
        new GameTeam("New York City FC", "NYC", "NYCFC", "New York City Football Club",
                "The Pigeons", "Yankee Stadium", 47309,
                "Nova Iorque", "Nova Iorque", "Estados Unidos", "América do Norte", 0);
        new GameTeam("Toronto FC", "TOR", "TFC", "Toronto Football Club",
                "The Reds", "BMO Field", 30000,
                "Toronto", "Ontário", "Canadá", "América do Norte", 0);

        // Costa Rica
        new GameTeam("Deportivo Saprissa", "SAP", "CDS", "Deportivo Saprissa",
                "El Monstruo Morado", "Estadio Ricardo Saprissa Aymá", 24000,
                "San Juan de Tibás", "San José", "Costa Rica", "América Central", 0);
        new GameTeam("Alajuelense", "ALA", "LDA", "Liga Deportiva Alajuelense",
                "Los Manudos", "Estadio Alejandro Morera Soto", 17895,
                "Alajuela", "Alajuela", "Costa Rica", "América Central", 0);

        // Honduras
        new GameTeam("Olimpia", "OLI", "CDO", "Club Deportivo Olimpia",
                "Los Leones", "Estadio Nacional Chelato Uclés", 35000,
                "Tegucigalpa", "Francisco Morazán", "Honduras", "América Central", 0);
        new GameTeam("Motagua", "MOT", "CDM", "Club Deportivo Motagua",
                "Los Azules", "Estadio Nacional Chelato Uclés", 35000,
                "Tegucigalpa", "Francisco Morazán", "Honduras", "América Central", 0);

        // Guatemala
        new GameTeam("Comunicaciones", "COM", "CFC", "Comunicaciones Fútbol Club",
                "Los Cremas", "Estadio Doroteo Guamuch Flores", 26000,
                "Cidade da Guatemala", "Guatemala", "Guatemala", "América Central", 0);
        new GameTeam("Municipal", "MUN", "CSDM", "Club Social y Deportivo Municipal",
                "Los Rojos", "Estadio Manuel Felipe Carrera", 17000,
                "Cidade da Guatemala", "Guatemala", "Guatemala", "América Central", 0);

        // Panamá
        new GameTeam("Tauro FC", "TAU", "TFC", "Tauro Fútbol Club",
                "Los Toros de Pedregal", "Estadio Rommel Fernández", 32000,
                "Cidade do Panamá", "Panamá", "Panamá", "América Central", 0);

        // Europa
        // Inglaterra
        new GameTeam("Manchester City", "MCI", "MCFC", "Manchester City Football Club",
                "The Citizens", "Etihad Stadium", 53400,
                "Manchester", "Inglaterra", "Reino Unido", "Europa", 0);
        new GameTeam("Liverpool", "LIV", "LFC", "Liverpool Football Club",
                "The Reds", "Anfield", 54074,
                "Liverpool", "Inglaterra", "Reino Unido", "Europa", 0);
        new GameTeam("Chelsea", "CHE", "CFC", "Chelsea Football Club",
                "The Blues", "Stamford Bridge", 41837,
                "Londres", "Inglaterra", "Reino Unido", "Europa", 0);
        new GameTeam("Manchester United", "MUN", "MUFC", "Manchester United Football Club",
                "The Red Devils", "Old Trafford", 74879,
                "Manchester", "Inglaterra", "Reino Unido", "Europa", 0);
        new GameTeam("Arsenal", "ARS", "AFC", "Arsenal Football Club",
                "The Gunners", "Emirates Stadium", 60260,
                "Londres", "Inglaterra", "Reino Unido", "Europa", 0);
        new GameTeam("Tottenham Hotspur", "TOT", "THFC", "Tottenham Hotspur Football Club",
                "Spurs", "Tottenham Hotspur Stadium", 62850,
                "Londres", "Inglaterra", "Reino Unido", "Europa", 0);

        // Espanha
        new GameTeam("Real Madrid", "RMD", "CF", "Real Madrid Club de Fútbol",
                "Los Blancos", "Estadio Santiago Bernabéu", 81044,
                "Madri", "Espanha", "Espanha", "Europa", 0);
        new GameTeam("Barcelona", "BAR", "FCB", "Futbol Club Barcelona",
                "Barça", "Spotify Camp Nou", 99354,
                "Barcelona", "Espanha", "Espanha", "Europa", 0);
        new GameTeam("Atlético de Madrid", "ATM", "ATM", "Club Atlético de Madrid",
                "Los Colchoneros", "Estadio Metropolitano", 68456,
                "Madri", "Espanha", "Espanha", "Europa", 0);

        // Alemanha
        new GameTeam("Bayern de Munique", "BAY", "FCB", "Fußball-Club Bayern München e.V.",
                "Die Bayern", "Allianz Arena", 75000,
                "Munique", "Baviera", "Alemanha", "Europa", 0);
        new GameTeam("Borussia Dortmund", "BVB", "BVB", "Ballspielverein Borussia 09 e.V. Dortmund",
                "Die Schwarzgelben", "Signal Iduna Park", 81365,
                "Dortmund", "Renânia do Norte-Vestfália", "Alemanha", "Europa", 0);

        // Itália
        new GameTeam("Juventus", "JUV", "JFC", "Juventus Football Club",
                "La Vecchia Signora", "Allianz Stadium", 41507,
                "Turim", "Piemonte", "Itália", "Europa", 0);
        new GameTeam("Internazionale", "INT", "FCIM", "Football Club Internazionale Milano",
                "I Nerazzurri", "Stadio Giuseppe Meazza", 80018,
                "Milão", "Lombardia", "Itália", "Europa", 0);
        new GameTeam("Milan", "MIL", "ACM", "Associazione Calcio Milan",
                "I Rossoneri", "Stadio Giuseppe Meazza", 80018,
                "Milão", "Lombardia", "Itália", "Europa", 0);

        // França
        new GameTeam("Paris Saint-Germain", "PSG", "PSG", "Paris Saint-Germain Football Club",
                "Les Parisiens", "Parc des Princes", 47929,
                "Paris", "Île-de-France", "França", "Europa", 0);

        // Portugal
        new GameTeam("Benfica", "BEN", "SLB", "Sport Lisboa e Benfica",
                "As Águias", "Estádio da Luz", 64642,
                "Lisboa", "Lisboa", "Portugal", "Europa", 0);
        new GameTeam("Porto", "POR", "FCP", "Futebol Clube do Porto",
                "Os Dragões", "Estádio do Dragão", 50033,
                "Porto", "Porto", "Portugal", "Europa", 0);

        // Países Baixos
        new GameTeam("Ajax", "AJA", "AFC", "Amsterdamsche Football Club Ajax",
                "De Godenzonen", "Johan Cruijff ArenA", 54990,
                "Amsterdã", "Holanda do Norte", "Países Baixos", "Europa", 0);

        // Escócia
        new GameTeam("Celtic", "CEL", "CFC", "Celtic Football Club",
                "The Bhoys", "Celtic Park", 60832,
                "Glasgow", "Escócia", "Reino Unido", "Europa", 0);

        // Turquia
        new GameTeam("Galatasaray", "GAL", "GS", "Galatasaray Spor Kulübü",
                "Cim Bom", "Nef Stadyumu", 52652,
                "Istambul", "Mármara", "Turquia", "Europa", 0);

        // Ásia
        // Arábia Saudita
        new GameTeam("Al Hilal", "HIL", "AHFC", "Al Hilal Saudi Football Club",
                "Al-Za'eem", "King Fahd International Stadium", 68752,
                "Riad", "Riad", "Arábia Saudita", "Ásia", 0);
        new GameTeam("Al Nassr", "NAS", "ANFC", "Al Nassr Football Club",
                "Al-Aalami", "Mrsool Park", 25000,
                "Riad", "Riad", "Arábia Saudita", "Ásia", 0);

        // Irã
        new GameTeam("Persepolis", "PER", "PFC", "Persepolis Football Club",
                "The Reds", "Azadi Stadium", 78116,
                "Teerã", "Teerã", "Irã", "Ásia", 0);

        // China
        new GameTeam("Shanghai Port", "SHA", "SPFC", "Shanghai Port Football Club",
                "The Red Eagles", "Pudong Football Stadium", 33765,
                "Xangai", "Xangai", "China", "Ásia", 0);

        // Catar
        new GameTeam("Al-Sadd", "SAD", "ASFC", "Al-Sadd Sports Club",
                "Al Zaeem", "Jassim Bin Hamad Stadium", 12946,
                "Doha", "Doha", "Catar", "Ásia", 0);

        // Japão
        new GameTeam("Kawasaki Frontale", "KAW", "KF", "Kawasaki Frontale",
                "Frontale", "Kawasaki Todoroki Stadium", 27495,
                "Kawasaki", "Kanagawa", "Japão", "Ásia", 0);
        new GameTeam("Urawa Red Diamonds", "URA", "URD", "Urawa Red Diamonds",
                "Reds", "Saitama Stadium 2002", 63700,
                "Saitama", "Saitama", "Japão", "Ásia", 0);

        // Coreia do Sul
        new GameTeam("Jeonbuk Hyundai Motors", "JEO", "JHMFC", "Jeonbuk Hyundai Motors Football Club",
                "Green Warriors", "Jeonju World Cup Stadium", 42477,
                "Jeonju", "Jeolla do Norte", "Coreia do Sul", "Ásia", 0);

        // Austrália
        new GameTeam("Sydney FC", "SYD", "SFC", "Sydney Football Club",
                "The Sky Blues", "Allianz Stadium", 42500,
                "Sydney", "Nova Gales do Sul", "Austrália", "Ásia", 0);

        // Emirados Árabes Unidos
        new GameTeam("Al-Ain", "AIN", "AAFC", "Al-Ain Football Club",
                "The Boss", "Hazza Bin Zayed Stadium", 25000,
                "Al Ain", "Abu Dhabi", "Emirados Árabes Unidos", "Ásia", 0);

        // Uzbequistão
        new GameTeam("Pakhtakor Tashkent", "PAK", "PTFC", "Pakhtakor Tashkent Football Club",
                "The Lions", "Pakhtakor Markaziy Stadium", 35000,
                "Tashkent", "Tashkent", "Uzbequistão", "Ásia", 0);

        // Tailândia
        new GameTeam("Buriram United", "BUR", "BUFC", "Buriram United Football Club",
                "Thunder Castle", "Chang Arena", 32600,
                "Buriram", "Buriram", "Tailândia", "Ásia", 0);

        // Índia
        new GameTeam("Mumbai City FC", "MUM", "MCFC", "Mumbai City Football Club",
                "The Islanders", "Mumbai Football Arena", 18000,
                "Mumbai", "Maharashtra", "Índia", "Ásia", 0);

        // Jordânia
        new GameTeam("Al-Faisaly", "FAI", "AFFC", "Al-Faisaly Football Club",
                "The Blue Eagles", "Amman International Stadium", 17000,
                "Amã", "Amã", "Jordânia", "Ásia", 0);

        // Iraque
        new GameTeam("Al-Shorta", "SHO", "ASFC", "Al-Shorta Sports Club",
                "The Police", "Al-Shaab Stadium", 35000,
                "Bagdá", "Bagdá", "Iraque", "Ásia", 0);

        // Síria
        new GameTeam("Al-Ittihad Aleppo", "ITT", "AISC", "Al-Ittihad Sports Club",
                "The Red Castle", "Aleppo International Stadium", 75000,
                "Aleppo", "Aleppo", "Síria", "Ásia", 0);

        // Vietnã
        new GameTeam("Hanoi FC", "HAN", "HFC", "Hanoi Football Club",
                "The Capital Team", "Hang Day Stadium", 22500,
                "Hanói", "Hanói", "Vietnã", "Ásia", 0);

        // Malásia
        new GameTeam("Johor Darul Ta'zim", "JDT", "JDTFC", "Johor Darul Ta'zim Football Club",
                "Southern Tigers", "Sultan Ibrahim Stadium", 40000,
                "Iskandar Puteri", "Johor", "Malásia", "Ásia", 0);

        // Catar
        new GameTeam("Al-Duhail", "DUH", "ADSC", "Al-Duhail Sports Club",
                "The Red Knights", "Abdullah bin Khalifa Stadium", 9740,
                "Doha", "Doha", "Catar", "Ásia", 0);

        // China
        new GameTeam("Beijing Guoan", "BEI", "BGFC", "Beijing Guoan Football Club",
                "Imperial Guards", "Workers' Stadium", 68000,
                "Pequim", "Pequim", "China", "Ásia", 0);

        // África
        // Egito
        new GameTeam("Al Ahly", "AHL", "ASC", "Al Ahly Sporting Club",
                "Os Vermelhos", "Estádio Internacional do Cairo", 75000,
                "Cairo", "Cairo", "Egito", "África", 0);
        new GameTeam("Zamalek", "ZAM", "ZSC", "Zamalek Sporting Club",
                "Os Cavaleiros Brancos", "Estádio Internacional do Cairo", 75000,
                "Cairo", "Cairo", "Egito", "África", 0);

        // África do Sul
        new GameTeam("Mamelodi Sundowns", "MSD", "MSFC", "Mamelodi Sundowns Football Club",
                "Os Brasileiros", "Loftus Versfeld Stadium", 51762,
                "Pretória", "Gauteng", "África do Sul", "África", 0);
        new GameTeam("Orlando Pirates", "ORP", "OPFC", "Orlando Pirates Football Club",
                "Os Bucaneiros", "Orlando Stadium", 37500,
                "Joanesburgo", "Gauteng", "África do Sul", "África", 0);

        // Tunísia
        new GameTeam("Espérance de Tunis", "EST", "EST", "Espérance Sportive de Tunis",
                "Sang et Or", "Estádio Olímpico de Radès", 60000,
                "Túnis", "Túnis", "Tunísia", "África", 0);
        new GameTeam("Étoile du Sahel", "ESS", "ESS", "Étoile Sportive du Sahel",
                "Os Estrelas", "Estádio Olímpico de Sousse", 28000,
                "Sousse", "Sousse", "Tunísia", "África", 0);

        // Marrocos
        new GameTeam("Wydad Casablanca", "WYD", "WAC", "Wydad Athletic Club",
                "Os Vermelhos", "Estádio Mohammed V", 67000,
                "Casablanca", "Casablanca-Settat", "Marrocos", "África", 0);
        new GameTeam("Raja Casablanca", "RAJ", "RCA", "Raja Club Athletic",
                "Os Verdes", "Estádio Mohammed V", 67000,
                "Casablanca", "Casablanca-Settat", "Marrocos", "África", 0);

        // Argélia
        new GameTeam("JS Kabylie", "JSK", "JSK", "Jeunesse Sportive de Kabylie",
                "Os Leões do Djurdjura", "Estádio 1º de Novembro de 1954", 21000,
                "Tizi Ouzou", "Tizi Ouzou", "Argélia", "África", 0);
        new GameTeam("CR Belouizdad", "CRB", "CRB", "Chabab Riadhi de Belouizdad",
                "Os Chabab", "Estádio 20 de Agosto de 1955", 20000,
                "Argel", "Argel", "Argélia", "África", 0);

        // República Democrática do Congo
        new GameTeam("TP Mazembe", "TPM", "TPM", "Tout Puissant Mazembe",
                "Os Corvos", "Estádio TP Mazembe", 18000,
                "Lubumbashi", "Haut-Katanga", "República Democrática do Congo", "África", 0);
        new GameTeam("AS Vita Club", "ASV", "ASV", "Association Sportive Vita Club",
                "Os Moscovitas", "Estádio dos Mártires", 80000,
                "Kinshasa", "Kinshasa", "República Democrática do Congo", "África", 0);

        // Nigéria
        new GameTeam("Enyimba", "ENY", "ENY", "Enyimba International Football Club",
                "Os Elefantes do Povo", "Estádio Enyimba International", 25000,
                "Aba", "Abia", "Nigéria", "África", 0);

        // Gana
        new GameTeam("Asante Kotoko", "ASK", "ASK", "Asante Kotoko Sporting Club",
                "Os Porcos-Espinhos", "Estádio Baba Yara", 40000,
                "Kumasi", "Ashanti", "Gana", "África", 0);
        new GameTeam("Hearts of Oak", "HRT", "HRT", "Accra Hearts of Oak Sporting Club",
                "Os Fenícios", "Estádio Ohene Djan", 40000,
                "Acra", "Grande Acra", "Gana", "África", 0);

        // Costa do Marfim
        new GameTeam("ASEC Mimosas", "ASE", "ASE", "Association Sportive des Employés de Commerce Mimosas",
                "Os Mimosas", "Estádio Félix Houphouët-Boigny", 50000,
                "Abidjan", "Abidjan", "Costa do Marfim", "África", 0);

        // Sudão
        new GameTeam("Al Hilal Omdurman", "HIL", "AHO", "Al Hilal Club",
                "Os Líderes", "Estádio Al Hilal", 35000,
                "Omdurman", "Cartum", "Sudão", "África", 0);

        // Angola
        new GameTeam("Petro de Luanda", "PET", "PET", "Atlético Petróleos de Luanda",
                "Os Tricolores", "Estádio 11 de Novembro", 50000,
                "Luanda", "Luanda", "Angola", "África", 0);

        // Tanzânia
        new GameTeam("Simba SC", "SIM", "SIM", "Simba Sports Club",
                "Os Leões", "Estádio Nacional da Tanzânia", 60000,
                "Dar es Salaam", "Dar es Salaam", "Tanzânia", "África", 0);

        // Zâmbia
        new GameTeam("ZESCO United", "ZES", "ZES", "ZESCO United Football Club",
                "Team Ya Ziko", "Estádio Levy Mwanawasa", 49000,
                "Ndola", "Copperbelt", "Zâmbia", "África", 0);

    }

    public static void registerStateCups() {
        // Brasil
        new GameCup("Campeonato Acreano", "Acre", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Acre") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Alagoano", "Alagoas", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Alagoas") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Amapaense", "Amapá", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Amapá") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Amazonense", "Amazonas", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Amazonas") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Baiano", "Bahia", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Bahia") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Cearense", "Ceará", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Ceará") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Candango", "Distrito Federal", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Distrito Federal") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Capixaba", "Espírito Santo", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Espírito Santo") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Goiano", "Goiás", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Goiás") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Maranhense", "Maranhão", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Maranhão") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Mato-Grossense", "Mato Grosso", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Mato Grosso") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Sul-Mato-Grossense", "Mato Grosso do Sul", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Mato Grosso do Sul") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Mineiro", "Minas Gerais", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Minas Gerais") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paraense", "Pará", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Pará") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paraibano", "Paraíba", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Paraíba") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paranaense", "Paraná", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Paraná") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Pernambucano", "Pernambuco", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Pernambuco") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Piauiense", "Piauí", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Piauí") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Carioca", "Rio de Janeiro", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rio de Janeiro") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Potiguar", "Rio Grande do Norte", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rio Grande do Norte") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Gaúcho", "Rio Grande do Sul", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rio Grande do Sul") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Rondoniense", "Rondônia", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rondônia") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Roraimense", "Roraima", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Roraima") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Catarinense", "Santa Catarina", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Santa Catarina") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paulista", "São Paulo", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("São Paulo") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Sergipano", "Sergipe", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Sergipe") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Tocantinense", "Tocantins", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Tocantins") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
    }

    public static void registerRegionCups() {
        new GameCup("Copa do Norte", "Norte", 3_000_000, GameCupType.ELIMINATION,
                team -> team.getRegion().equalsIgnoreCase("Norte") && team.getCountry().equalsIgnoreCase("Brasil"), 20, GameCupRegionType.REGION, true);
        new GameCup("Copa do Nordeste", "Nordeste", 3_000_000, GameCupType.ELIMINATION,
                team -> team.getRegion().equalsIgnoreCase("Nordeste") && team.getCountry().equalsIgnoreCase("Brasil"), 20, GameCupRegionType.REGION, true);
        new GameCup("Copa do Centro-Oeste", "Centro-Oeste", 3_000_000, GameCupType.ELIMINATION,
                team -> team.getRegion().equalsIgnoreCase("Centro-Oeste") && team.getCountry().equalsIgnoreCase("Brasil"), 20, GameCupRegionType.REGION, true);
        new GameCup("Copa do Sudeste", "Sudeste", 3_000_000, GameCupType.ELIMINATION,
                team -> team.getRegion().equalsIgnoreCase("Sudeste") && team.getCountry().equalsIgnoreCase("Brasil"), 20, GameCupRegionType.REGION, true);
        new GameCup("Copa do Sul", "Sul", 3_000_000, GameCupType.ELIMINATION,
                team -> team.getRegion().equalsIgnoreCase("Sul") && team.getCountry().equalsIgnoreCase("Brasil"), 20, GameCupRegionType.REGION, true);
    }

    public static void registerBrasilCups() {
        new GameCup("Brasileirão Série A", "1", 50_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 1 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série B", "2", 25_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 2 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série C", "3", 10_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 3 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série D", "4", 9_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 4 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série E", "5", 8_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 5 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série F", "6", 7_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 6 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série G", "7", 6_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 7 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série H", "8", 5_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 8 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série I", "9", 4_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 9 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série J", "10", 3_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 10 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileirão Série K", "11", 2_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 11 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);

        GameCup brasilCup = new GameCup("Copa do Brasil", "Brasil", 85_000_000, GameCupType.ELIMINATION, team -> false, 25, GameCupRegionType.COUNTRY, false);
        for (String region : new String[]{"Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul"}) {
            GameCup gameCup = GameCup.get(region);

            List<GameTeam> ignore = new ArrayList<>();
            for (int i = 1; i <= 8; i++) {
                int more = -1;
                GameTeam moreTeam = null;
                for (GameTeam gameTeam : gameCup.getTeams()) {
                    if (ignore.contains(gameTeam)) {
                        continue;
                    }
                    if (gameCup.getPoints().get(gameTeam) > more) {
                        more = gameCup.getPoints().get(gameTeam);
                        moreTeam = gameTeam;
                    }
                }

                ignore.add(moreTeam);
                brasilCup.getTeams().add(moreTeam);
                brasilCup.getReason().put(moreTeam, i + "º lugar na " + gameCup.getName());
            }
        }
    }

    public static void registerInternacionalCups() {
        new GameCup("Copa da Argentina", "Argentina", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Argentina"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa da Bolívia", "Bolívia", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Bolívia"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa do Chile", "Chile", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Chile"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa da Colômbia", "Colômbia", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Colômbia"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa do Equador", "Equador", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Equador"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa da Paraguai", "Paraguai", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Paraguai"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa do Peru", "Peru", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Peru"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa do Uruguai", "Uruguai", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Uruguai"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa da Venezuela", "Venezuela", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Venezuela"), 0, GameCupRegionType.COUNTRY, true);
    }

    public static void registerOutsideCups() {
        new GameCup("Copa da América", "América", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("América do Norte") || team.getContinent().equalsIgnoreCase("América Central"), 0, GameCupRegionType.CONTINENT, true);
        new GameCup("Copa da Europa", "Europa", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("Europa"), 0, GameCupRegionType.CONTINENT, true);
        new GameCup("Copa da Ásia", "Ásia", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("Ásia"), 0, GameCupRegionType.CONTINENT, true);
        new GameCup("Copa da África", "África", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("África"), 0, GameCupRegionType.CONTINENT, true);
    }

}
