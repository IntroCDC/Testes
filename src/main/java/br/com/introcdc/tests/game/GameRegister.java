package br.com.introcdc.tests.game;
/*
 * Written by IntroCDC, Bruno Co�lho at 10/04/2024 - 15:55
 */

import java.util.ArrayList;
import java.util.List;

public class GameRegister {

    public static void registerTeams() {
        // Brasil
        // Acre
        new GameTeam("N�uas", "NAU", "NEC", "N�uas Esporte Clube",
                "Abutre do Norte", "Est�dio Municipal de Cruzeiro do Sul", 5000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Senador Guiomard", "SGU", "SESC", "Senador Guiomard Esporte Clube",
                "Tigr�o da Floresta", "Est�dio Municipal de Senador Guiomard", 5000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Pl�cido de Castro", "PLC", "PFC", "Pl�cido de Castro Futebol Clube",
                "Tigre do Abun�", "Est�dio Jos� de Melo", 5000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Juventus", "JUV", "JAC", "Juventus Atl�tico Clube",
                "Moleque Travesso", "Est�dio Adauto de Moraes", 5000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Independ�ncia", "IND", "IFC", "Independ�ncia Futebol Clube",
                "Tricolor de A�o", "Est�dio Florest�o", 10000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Galvez", "GAL", "GEC", "Galvez Esporte Clube",
                "Imp�rio do Galvez", "Arena da Floresta", 13000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Rio Branco", "RIO", "RBFC", "Rio Branco Futebol Clube",
                "Estrel�o do Acre", "Est�dio Arena da Floresta", 13000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Atl�tico Acreano", "AAC", "ACA", "Atl�tico Acreano Futebol Clube",
                "Galvez�o", "Est�dio Ant�nio Aquino", 20000,
                "Acre", "Norte", "Brasil", "Am�rica do Sul", 11);

        // Alagoas
        new GameTeam("CRB", "CRB", "CRB", "Clube de Regatas Brasil",
                "Galo", "Est�dio Rei Pel�", 45000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("CSA", "CSA", "CSA", "Centro Sportivo Alagoano",
                "Azul�o", "Est�dio Rei Pel�", 45000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Coruripe", "COR", "CFC", "Coruripe Futebol Clube",
                "Hulk Praiano", "Est�dio Gerson Amaral", 3000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Desportivo Alian�a", "DAL", "DA", "Desportivo Alian�a",
                "Fantasma", "Est�dio Municipal de Arapiraca", 5000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("ASA", "ASA", "ASA", "Agremia��o Sportiva Arapiraquense",
                "Fantasma", "Est�dio Municipal de Arapiraca", 5000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Sete de Setembro", "SET", "SSC", "Sete de Setembro Esporte Clube",
                "Alviverde", "Est�dio Municipal de Penedo", 5000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Jaciob�", "JAC", "JAC", "Jaciob� Atl�tico Clube",
                "Calango do Sert�o", "Est�dio Municipal de Palmeira dos �ndios", 3000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Murici", "MUR", "CAM", "Clube Atl�tico Murici",
                "Verd�o", "Est�dio Jos� Gomes da Costa", 3000,
                "Alagoas", "Nordeste", "Brasil", "Am�rica do Sul", 9);

        // Amap�
        new GameTeam("S�o Jos�", "SJO", "SJEC", "S�o Jos� Esporte Clube",
                "�guia do Norte", "Est�dio Municipal de Macap�", 4000,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Independente", "IND", "CAI", "Clube Atl�tico Independente",
                "Gavi�o Caraj�s", "Zer�o", 13680,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Macap�", "MAC", "CEM", "Clube Esportivo Macap�",
                "Le�o do Norte", "Zer�o", 13680,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Ypiranga", "YPI", "YC", "Ypiranga Clube",
                "Clube da Torre", "Zer�o", 13680,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Santana", "SAN", "SEC", "Santana Esporte Clube",
                "Can�rio do Norte", "Est�dio Municipal de Santana", 5000,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Trem", "TRE", "TDC", "Trem Desportivo Clube",
                "Locomotiva Vermelha", "Zer�o", 13680,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Guarany", "GUA", "GEC", "Guarany Esporte Clube",
                "Bugre do Amap�", "Zer�o", 13680,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Orat�rio", "ORA", "OEC", "Orat�rio Esporte Clube",
                "Drag�o do Laguinho", "Est�dio Municipal de Santana", 5000,
                "Amap�", "Norte", "Brasil", "Am�rica do Sul", 10);

        // Amazonas
        new GameTeam("Amazonas Futebol Clube", "AMA", "AFC", "Amazonas Futebol Clube",
                "Torcida Coral", "Arena da Amaz�nia", 44500,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Nacional", "NAC", "NFC", "Nacional Futebol Clube",
                "Le�o da Vila Municipal", "Est�dio Municipal Carlos Zamith", 5000,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("S�o Raimundo", "SRA", "SREC", "S�o Raimundo Esporte Clube",
                "Tucum�", "Est�dio Vivald�o", 35000,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Manaus", "MAN", "MFC", "Manaus Futebol Clube",
                "Gavi�o do Norte", "Arena da Amaz�nia", 44000,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Princesa do Solim�es", "PRI", "PSC", "Princesa do Solim�es Esporte Clube",
                "Tubar�o do Norte", "Est�dio Municipal Gilberto Mestrinho", 3000,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Fast", "FAS", "FC", "Fast Clube",
                "Rolo Compressor", "Est�dio Municipal Carlos Zamith", 5000,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Penarol", "PEN", "PAC", "Penarol Atl�tico Clube",
                "Le�o da Velha Serpa", "Est�dio Municipal de Manacapuru", 5000,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Rio Negro", "RIO", "RNC", "Rio Negro Clube",
                "Barriga Preta", "Est�dio Vivald�o", 35000,
                "Amazonas", "Norte", "Brasil", "Am�rica do Sul", 11);

        // Bahia
        new GameTeam("Bahia", "BAH", "ECB", "Esporte Clube Bahia",
                "Tricolor de A�o", "Arena Fonte Nova", 48000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Vit�ria", "VIT", "ECV", "Esporte Clube Vit�ria",
                "Le�o da Barra", "Barrad�o", 35000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Atl�tico de Alagoinhas", "ATL", "AA", "Atl�tico de Alagoinhas",
                "Carcar�", "Est�dio Ant�nio de Figueiredo Carneiro", 10000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Jacuipense", "JAC", "ECJ", "Esporte Clube Jacuipense",
                "Le�o do Sisal", "Est�dio Eliel Martins", 6000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Bahia de Feira", "BDF", "ECBF", "Esporte Clube Bahia de Feira",
                "Tremend�o", "Est�dio Municipal de Feira de Santana", 16000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Atl�tico de Itabuna", "ATI", "CAM", "Clube Atl�tico Mineiro",
                "Drag�o do Sul", "Est�dio Luiz Viana Filho", 5000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Juazeiro", "JUA", "JEC", "Juazeiro Social Clube",
                "Tricolor do Sert�o", "Est�dio Adauto Moraes", 5000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Jacobina", "JAC", "JAC", "Jacobina Esporte Clube",
                "Jegue de Ouro", "Est�dio Jos� Rocha", 5000,
                "Bahia", "Nordeste", "Brasil", "Am�rica do Sul", 10);

        // Cear�
        new GameTeam("Fortaleza", "FOR", "FEC", "Fortaleza Esporte Clube",
                "Le�o do Pici", "Arena Castel�o", 63903,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Cear�", "CEA", "CSC", "Cear� Sporting Club",
                "Voz�o", "Arena Castel�o", 63903,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Ferrovi�rio", "FER", "FAC", "Ferrovi�rio Atl�tico Clube",
                "Falange Coral", "Est�dio Presidente Vargas", 20300,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Floresta", "FLO", "FEC", "Floresta Esporte Clube",
                "Verd�o da Vila", "Est�dio Augusto Ol�mpio", 12000,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Maracan�", "MAR", "MEC", "Maracan� Esporte Clube",
                "F�ria Tricolor", "Est�dio Prefeito Almir Dutra", 18000,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Icasa", "ICA", "ICEC", "Icasa Esporte Clube",
                "Verd�o do Cariri", "Est�dio Romeir�o", 10000,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Guarany de Sobral", "GUA", "GSC", "Guarany Esporte Clube",
                "Bugre do Cear�", "Est�dio Junco", 7000,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Tiradentes", "TIR", "TEC", "Tiradentes Esporte Clube",
                "Tigre da Pol�cia Militar", "Est�dio Presidente Vargas", 20300,
                "Cear�", "Nordeste", "Brasil", "Am�rica do Sul", 8);

        // Distrito Federal
        new GameTeam("Brasiliense", "BRA", "FCF", "Brasiliense Futebol Clube",
                "Jacar�", "Est�dio Elmo Serejo Farias", 16000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Gama", "GAM", "GDF", "Gama Futebol Clube",
                "Alviverde do Gama", "Est�dio Bezerr�o", 20000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Ceil�ndia", "CEI", "CEC", "Ceil�ndia Esporte Clube",
                "Gavi�o do Cerrado", "Est�dio Abrah�o C�ndido de Moraes", 10000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Luzi�nia", "LUZ", "LEC", "Luzi�nia Esporte Clube",
                "Azul�o do Entorno", "Est�dio JK", 12000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Real Bras�lia", "RBR", "RBC", "Real Bras�lia Futebol Clube",
                "Le�o do Planalto", "Est�dio Defel�", 15000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Taguatinga", "TAG", "TEC", "Taguatinga Esporte Clube",
                "TEC", "Est�dio Elmo Serejo Farias", 16000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Capital", "CAP", "CFC", "Capital Futebol Clube",
                "Le�o do Gama", "Est�dio Serej�o", 15000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Parano�", "PAR", "PEC", "Parano� Esporte Clube",
                "Cacique do Cerrado", "Est�dio Elmo Serejo Farias", 16000,
                "Distrito Federal", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);

        // Esp�rito Santos
        new GameTeam("Desportiva Ferrovi�ria", "DES", "DFC", "Desportiva Ferrovi�ria Esporte Clube",
                "Gren�", "Est�dio Engenheiro Araripe", 21000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Vit�ria", "VIT", "ECV", "Esporte Clube Vit�ria",
                "Alvianil de Bento Ferreira", "Est�dio Salvador Costa", 3000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Rio Branco", "RIO", "RBC", "Rio Branco Atl�tico Clube",
                "Capa Preta", "Est�dio Kleber Andrade", 21000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Real Noroeste", "RNO", "RNC", "Real Noroeste Capixaba Futebol Clube",
                "Merengue", "Est�dio Jos� Ol�mpio de Lima", 5000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("S�o Mateus", "SMA", "SMC", "S�o Mateus Esporte Clube",
                "Falc�o do Norte", "Est�dio Municipal de S�o Mateus", 8000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Tupy", "TUP", "TEC", "Tupy Futebol Clube",
                "Alvinegro da Vila", "Est�dio Jos� de Azeredo Coutinho", 5000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Linhares", "LIN", "LEC", "Linhares Esporte Clube",
                "Le�o do Norte", "Est�dio Municipal de Linhares", 10000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Serra", "SER", "SES", "Serra Futebol Clube",
                "Cobra Coral", "Est�dio Robert�o", 5000,
                "Esp�rito Santo", "Sudeste", "Brasil", "Am�rica do Sul", 11);

        // Goias
        new GameTeam("Atl�tico Goianiense", "ATG", "CAC", "Clube Atl�tico Goianiense",
                "Drag�o", "Est�dio Ant�nio Accioly", 40000,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Goi�s", "GOI", "SEC", "Goi�s Esporte Clube",
                "Esmeraldino", "Est�dio Hail� Pinheiro", 60000,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Vila Nova", "VIL", "VNV", "Vila Nova Futebol Clube",
                "Tigre", "Est�dio OBA", 10000,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Aparecidense", "APE", "EC", "Aparecida Esporte Clube",
                "Galo da Aparecidinha", "Est�dio Municipal Annibal Batista de Toledo", 4800,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("An�polis", "ANA", "AAC", "Anapolina Esporte Clube",
                "Xata", "Est�dio Jonas Duarte", 11000,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Goiatuba", "GOI", "GAC", "Goiatuba Esporte Clube",
                "Azul�o do Vale", "Est�dio Valdeir Jos� de Oliveira", 8000,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Ipor�", "IPO", "IEC", "Ipor� Esporte Clube",
                "Lob�o do Cerrado", "Est�dio Ferreir�o", 5000,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Morrinhos", "MOR", "MFC", "Morrinhos Futebol Clube",
                "Boi Verde", "Est�dio Jo�o Vilela", 4000,
                "Goi�s", "Centro-Oeste", "Brasil", "Am�rica do Sul", 8);

        // Maranh�o
        new GameTeam("Sampaio Corr�a", "SAM", "SBC", "Sampaio Corr�a Futebol Clube",
                "Bol�via Querida", "Est�dio Castel�o", 40000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Moto Club", "MOT", "MCM", "Moto Club de S�o Lu�s",
                "Pap�o do Norte", "Est�dio Castel�o", 40000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Imperatriz", "IMP", "ECI", "Imperatriz Futebol Clube",
                "Cavalo de A�o", "Est�dio Frei Epif�nio D'Abadia", 10000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Cordino", "COR", "AEC", "Associa��o Esportiva Cordino",
                "On�a do Vale", "Est�dio Leoz�o", 8000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Juazeiro", "JUA", "JEC", "Juazeiro Social Clube",
                "Tricolor do Sert�o", "Est�dio Municipal de Juazeiro", 5000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Bacabal", "BAC", "BAC", "Bacabal Esporte Clube",
                "Le�o do Mearim", "Est�dio Jos� Lu�s de Oliveira", 5000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Maranh�o", "MAR", "MAC", "Maranh�o Atl�tico Clube",
                "MAc", "Est�dio Castel�o", 40000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Tuntum", "TUN", "TEC", "Tuntum Esporte Clube",
                "Touro do Sert�o", "Est�dio Rafael Seabra", 5000,
                "Maranh�o", "Nordeste", "Brasil", "Am�rica do Sul", 11);

        // Mato Grosso
        new GameTeam("Cuiab�", "CUI", "CEC", "Cuiab� Esporte Clube",
                "Dourado", "Arena Pantanal", 44000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Luverdense", "LUV", "LEC", "Luverdense Esporte Clube",
                "Verd�o do Norte", "Est�dio Municipal Passo das Emas", 10000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Uni�o Rondon�polis", "UNI", "URC", "Uni�o Esportiva Rondon�polis",
                "Verd�o do Sul", "Est�dio Municipal Luthero Lopes", 5000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Dom Bosco", "DBO", "DBC", "Dom Bosco Esporte Clube",
                "Salesiano", "Est�dio Cinez�o", 5000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Nova Mutum", "NMT", "NMC", "Nova Mutum Esporte Clube",
                "Tigre do Norte", "Est�dio Valdir Doilho Wons", 5000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Sinop", "SIN", "SEC", "Sinop Futebol Clube",
                "Carcar� do Norte", "Est�dio Gigante do Norte", 13000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Mixto", "MIX", "ECMT", "Esporte Clube Mixto",
                "Tigre da v�rzea", "Est�dio Dutrinha", 30000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Cacerense", "CAC", "CEC", "Cacerense Esporte Clube",
                "Fera da Fronteira", "Est�dio Luiz de Carvalho", 10000,
                "Mato Grosso", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);

        // Mato Grosso do Sul
        new GameTeam("Corumbaense", "COR", "CEC", "Corumbaense Futebol Clube",
                "Pantera do Pantanal", "Est�dio Major Jos� Lance Celestino", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("�guia Negra", "AGN", "AAC", "�guia Negra Esporte Clube",
                "Auri-verde", "Est�dio Ninho da �guia", 4000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Naviraiense", "NAV", "NAC", "Naviraiense Esporte Clube",
                "Jacar� do Pantanal", "Est�dio Viroteir�o", 4000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Dourados", "DOU", "DEC", "Dourados Atl�tico Clube",
                "Verd�o da Fronteira", "Est�dio Dourad�o", 20000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Sete de Setembro", "SET", "SSC", "Sete de Setembro Esporte Clube",
                "Alviverde", "Est�dio Moren�o", 44000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Ivinhema", "IVI", "IEC", "Ivinhema Esporte Clube",
                "Gavi�o do Sul", "Est�dio Municipal de Ivinhema", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Chapad�o do Sul", "CHS", "CEC", "Chapad�o do Sul Esporte Clube",
                "Galo do Norte", "Est�dio Municipal de Chapad�o do Sul", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Maracaju", "MAC", "SEMC", "Sociedade Esportiva Maracaju",
                "Azul�o do Maracaju", "Est�dio Municipal Luiz Soares de Andrade", 5000,
                "Mato Grosso do Sul", "Centro-Oeste", "Brasil", "Am�rica do Sul", 11);

        // Minas Gerais
        new GameTeam("Cruzeiro", "CRU", "ECP", "Cruzeiro Esporte Clube",
                "Celeste", "Est�dio Mineir�o", 62170,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Atl�tico Mineiro", "CAM", "CAC", "Clube Atl�tico Mineiro",
                "Galo", "Est�dio Mineir�o", 62170,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Am�rica", "AME", "AFC", "Am�rica Futebol Clube",
                "Coelho", "Independ�ncia", 23018,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Tombense", "TOM", "TEC", "Tombense Futebol Clube",
                "Gavi�o Caraj�s", "Est�dio Municipal Soares de Azevedo", 3000,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Ipatinga", "IPA", "EICI", "Ipatinga Futebol Clube",
                "Tigre do Vale", "Est�dio Municipal Ipating�o", 18000,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Athletic Club", "CAL", "AEC", "Caldense Esporte Clube",
                "Verd�o da Mata", "Est�dio Ronald�o", 7000,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Villa Nova", "VIL", "VNV", "Villa Nova Atl�tico Clube",
                "Le�o do Bonfim", "Est�dio Castor Cifuentes", 15000,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Uberl�ndia", "UBE", "ECUB", "Uberl�ndia Esporte Clube",
                "Verd�o do Tri�ngulo", "Est�dio Municipal Parque do Sabi�", 53350,
                "Minas Gerais", "Sudeste", "Brasil", "Am�rica do Sul", 7);

        // Par�
        new GameTeam("Paysandu", "PAY", "SC", "Paysandu Sport Club",
                "Pap�o da Curuzu", "Est�dio Le�nidas de Castro", 20000,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Clube do Remo", "REM", "C", "Clube do Remo",
                "Le�o Azul", "Est�dio Baen�o", 17826,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Tuna Luso Brasileira", "TUN", "SC", "Tuna Luso Brasileira",
                "A Brilhante", "Est�dio Francisco Vasques", 5000,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Castanhal", "CAS", "EC", "Castanhal Esporte Clube",
                "Japiim da Amaz�nia", "Est�dio Model�o", 8000,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Bragantino-PA", "BRA", "Clube", "Bragantino Clube do Par�",
                "Tubar�o do Caet�", "Est�dio Diog�o", 10000,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Independente-PA", "IND", "EC", "Independente Esporte Clube",
                "Galo El�trico", "Est�dio Baen�o", 17826,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Parauapebas", "PAR", "FC", "Parauapebas Futebol Clube",
                "Peixe Dourado", "Est�dio Rosen�o", 5000,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("S�o Francisco", "SFP", "FC", "S�o Francisco Futebol Clube",
                "Furac�o do Tapaj�s", "Est�dio Municipal Colosso do Tapaj�s", 5000,
                "Par�", "Norte", "Brasil", "Am�rica do Sul", 10);

        // Para�ba
        new GameTeam("Botafogo-PB", "BOT", "EC", "Esporte Clube Botafogo",
                "Belo", "Est�dio Almeid�o", 25770,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Treze", "TRE", "FC", "Treze Futebol Clube",
                "Galo da Vila", "Est�dio Presidente Vargas", 6000,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Campinense", "CAM", "CLB", "Campinense Clube",
                "Raposa", "Est�dio Renat�o", 23000,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Sousa", "SOU", "EC", "Sousa Esporte Clube",
                "Dinossauro do Sert�o", "Est�dio Mariz�o", 5000,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Nacional de Patos", "NAC", "EC", "Nacional Atl�tico Clube",
                "Can�rio do Sert�o", "Est�dio Jos� Cavalcanti", 4000,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Auto Esporte", "AUT", "CE", "Auto Esporte Clube",
                "Macac�o", "Est�dio Mangabeira", 7000,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("CSP", "CSP", "FC", "Clube Atl�tico do Sport Pernambucano",
                "Tigre do Sert�o", "Est�dio Arthur Marinho", 4000,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Queimadense", "QUE", "EC", "Queimadense Esporte Clube",
                "Carcar� do Sert�o", "Est�dio Amig�o", 4000,
                "Para�ba", "Nordeste", "Brasil", "Am�rica do Sul", 11);

        // Paran�
        new GameTeam("Athletico Paranaense", "CAP", "CAP", "Clube Atl�tico Paranaense",
                "Furac�o", "Arena da Baixada", 42372,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Coritiba", "CFC", "CFC", "Coritiba Foot Ball Club",
                "Coxa", "Est�dio Couto Pereira", 40500,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Oper�rio Ferrovi�rio", "OPE", "OFEC", "Oper�rio Ferrovi�rio Esporte Clube",
                "Fantasma", "Est�dio Germano Kr�ger", 10000,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Londrina", "LON", "LEC", "Londrina Esporte Clube",
                "Tubar�o", "Est�dio do Caf�", 30000,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Paran�", "PAR", "PCC", "Paran� Clube",
                "Tricolor da Vila Capanema", "Est�dio Durival Britto e Silva", 19000,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Cascavel", "CAS", "CFC", "Cascavel Clube Recreativo",
                "Serpente Aurinegra", "Est�dio Ol�mpico Regional Arnaldo Busatto", 28000,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Maring�", "MAR", "MFC", "Maring� Futebol Clube",
                "Tricolor do Ing�", "Est�dio Willie Davids", 21000,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Rio Branco", "RIO", "RBC", "Rio Branco Sport Club",
                "Le�o do Norte", "Est�dio Gigante do Norte", 13000,
                "Paran�", "Sul", "Brasil", "Am�rica do Sul", 9);

        // Pernambuco
        new GameTeam("Sport", "SPO", "SCP", "Sport Club Recife",
                "Le�o da Ilha", "Est�dio Ilha do Retiro", 32775,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("N�utico", "NAU", "CAC", "Clube N�utico Capibaribe",
                "Timbu", "Est�dio dos Aflitos", 22850,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Santa Cruz", "STC", "SCFC", "Santa Cruz Futebol Clube",
                "Tricolor do Arruda", "Est�dio do Arruda", 60044,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Salgueiro", "SAL", "ASC", "Salgueiro Atl�tico Clube",
                "Carcar� do Sert�o", "Est�dio Corn�lio de Barros", 12000,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Central", "CEN", "CEC", "Central Sport Club",
                "Patativa", "Est�dio Luiz Jos� de Lacerda", 12000,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Afogados da Ingazeira", "AFI", "AAFI", "Associa��o Atl�tica Afogados da Ingazeira",
                "Coruja", "Est�dio Vianey de S�", 5000,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Retr�", "RET", "FC", "Retr� Futebol Clube",
                "F�nix do Nordeste", "Est�dio Arena de Pernambuco", 44184,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Petrolina", "PET", "PFC", "Petrolina Social Futebol Clube",
                "Fera Sertaneja", "Est�dio Paulo Coelho", 5000,
                "Pernambuco", "Nordeste", "Brasil", "Am�rica do Sul", 9);

        // Piau�
        new GameTeam("Corisabb�", "COR", "AC", "Associa��o Cori-Sabb� Futebol Clube",
                "Tubar�o do Piau�", "Est�dio Municipal Lindolfo Monteiro", 5000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Fluminense-PI", "FLU", "FCF", "Fluminense Futebol Clube do Piau�",
                "Vaqueiro do Poti", "Est�dio Albert�o", 44000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("River-PI", "RIV", "RCE", "River Atl�tico Clube",
                "Galo do Piau�", "Est�dio Albert�o", 44000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("4 de Julho", "JUL", "EC", "Esporte Clube 4 de Julho",
                "Colorado", "Est�dio Municipal de Piripiri", 8000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Parnahyba", "PAR", "SCP", "Sociedade Esportiva Parnahyba",
                "Azulino", "Est�dio Pedro Alelaf", 5000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Altos", "ALT", "AAC", "Altos Esporte Clube",
                "Jacar� do Piau�", "Est�dio Municipal Felipe Raulino", 5000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Picos", "PIC", "PFC", "Picos Futebol Clube",
                "Gavi�o do Piau�", "Est�dio Municipal Lindolfo Monteiro", 5000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Cori-Sabb�", "COR", "AC", "Associa��o Cori-Sabb� Futebol Clube",
                "Tubar�o do Piau�", "Est�dio Municipal Lindolfo Monteiro", 5000,
                "Piau�", "Nordeste", "Brasil", "Am�rica do Sul", 11);

        // Rio de Janeiro
        new GameTeam("Flamengo", "FLA", "CR", "Clube de Regatas do Flamengo",
                "Meng�o", "Est�dio do Maracan�", 78838,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Fluminense", "FLU", "FCF", "Fluminense Football Club",
                "Tricolor das Laranjeiras", "Est�dio do Maracan�", 78838,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Vasco da Gama", "VAS", "CRVG", "Club de Regatas Vasco da Gama",
                "Cruzmaltino", "Est�dio S�o Janu�rio", 21880,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Botafogo", "BOT", "FR", "Botafogo de Futebol e Regatas",
                "Alvinegro", "Est�dio Nilton Santos", 46931,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Volta Redonda", "VOL", "FCVR", "Volta Redonda Futebol Clube",
                "Esquadr�o de A�o", "Est�dio Raulino de Oliveira", 20000,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Madureira", "MAD", "EC", "Madureira Esporte Clube",
                "Tricolor Suburbano", "Est�dio Conselheiro Galv�o", 5000,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Bangu", "BAN", "AAC", "Bangu Atl�tico Clube",
                "Alvirrubro", "Est�dio Mo�a Bonita", 9000,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Portuguesa", "POR", "CA", "Portuguesa da Ilha Futebol Clube",
                "Lusa Insulana", "Est�dio Luso Brasileiro", 18000,
                "Rio de Janeiro", "Sudeste", "Brasil", "Am�rica do Sul", 6);

        // Rio Grande do Norte
        new GameTeam("ABC", "ABC", "FC", "Associa��o Brasileira de Clubes",
                "Alvinegro", "Est�dio Frasqueir�o", 15000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Am�rica de Natal", "AME", "AEC", "Am�rica Futebol Clube",
                "Mec�o", "Est�dio Arena das Dunas", 31655,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Globo FC", "GLO", "FEC", "Globo Futebol Clube",
                "Xavante", "Est�dio Barrett�o", 10000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Potiguar", "POT", "EC", "Potiguar Esporte Clube",
                "Alvinegro de Mossor�", "Est�dio Nogueir�o", 10000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Santa Cruz de Natal", "STC", "AC", "Santa Cruz Futebol Clube",
                "Tricolor do Arruda", "Est�dio Iberez�o", 5000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Assu", "ASS", "AC", "Associa��o Cultural Esportiva Assu",
                "Camale�o do Vale", "Est�dio Edgarz�o", 4000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("For�a e Luz", "FOR", "AC", "Associa��o Atl�tica For�a e Luz",
                "Lampi�o do Poti", "Est�dio Barret�o", 10000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Nova Cruz", "NOV", "CEC", "Nova Cruz Esporte Clube",
                "Mec�o do Agreste", "Est�dio Jos� Nazareno", 5000,
                "Rio Grande do Norte", "Nordeste", "Brasil", "Am�rica do Sul", 11);

        // Rio Grande do Sul
        new GameTeam("Gr�mio", "GRE", "FBPA", "Gr�mio Foot-Ball Porto Alegrense",
                "Tricolor Ga�cho", "Arena do Gr�mio", 55662,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Internacional", "INT", "SCIA", "Sport Club Internacional",
                "Colorado", "Est�dio Beira-Rio", 50128,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Juventude", "JUV", "EC", "Esporte Clube Juventude",
                "Papo", "Est�dio Alfredo Jaconi", 23734,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Ypiranga", "YPI", "EC", "Ypiranga Futebol Clube",
                "Canarinho", "Est�dio Colosso da Lagoa", 19000,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Caxias", "CAX", "EC", "Clube Esportivo Caxias",
                "Gren�", "Est�dio Centen�rio", 22132,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Brasil de Pelotas", "BRA", "EP", "Esporte Clube Brasil",
                "Xavante", "Est�dio Bento Freitas", 18000,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("S�o Jos�", "SJO", "EPCS", "Esporte Clube S�o Jos�",
                "Zequinha", "Est�dio Passo D'Areia", 10000,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Pelotas", "PEL", "EC", "Esporte Clube Pelotas",
                "Lobisomem", "Est�dio Boca do Lobo", 18000,
                "Rio Grande do Sul", "Sul", "Brasil", "Am�rica do Sul", 7);

        // Rond�nia
        new GameTeam("Real Ariquemes", "REA", "EC", "Real Ariquemes Esporte Clube",
                "Furac�o do Vale do Jamari", "Est�dio Gentil Val�rio", 3000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Porto Velho", "POR", "EC", "Porto Velho Esporte Clube",
                "Locomotiva", "Est�dio Alu�zio Ferreira", 7000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Rondoniense", "RON", "SC", "Sociedade Esportiva Rondoniense",
                "Verd�o de Rond�nia", "Est�dio Alu�zio Ferreira", 7000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Genus", "GEN", "FC", "Genus Futebol Clube",
                "Aurigren�", "Est�dio Alu�zio Ferreira", 7000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Vilhena", "VIL", "EC", "Vilhena Esporte Clube",
                "Tigre da Fronteira", "Est�dio Municipal de Vilhena", 5000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Guajar�", "GUA", "EC", "Guajar� Esporte Clube",
                "Gua�u", "Est�dio Municipal de Guajar�-Mirim", 5000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Uni�o Cacoalense", "UCA", "FC", "Uni�o Cacoalense Futebol Clube",
                "Uni�o", "Est�dio Aglair Tonelli", 5000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Pimentense", "PIM", "EC", "Pimentense Esporte Clube",
                "Galo do Norte", "Est�dio Luiz Alves de Oliveira", 5000,
                "Rond�nia", "Norte", "Brasil", "Am�rica do Sul", 11);

        // Roraima
        new GameTeam("S�o Raimundo-RR", "SRR", "EC", "S�o Raimundo Esporte Clube",
                "Mund�o", "Est�dio Ribeir�o", 3000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Bar�", "BAR", "EC", "Bar� Esporte Clube",
                "Colorado", "Est�dio Canarinho", 4000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("N�utico-RR", "NAU", "EC", "N�utico Futebol Clube",
                "Alvirrubro", "Est�dio Flamarion Vasconcelos", 5000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Rio Negro-RR", "RNR", "EC", "Rio Negro Futebol Clube",
                "Galoucura", "Est�dio Canarinho", 4000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Atl�tico Roraima", "ATR", "EC", "Atl�tico Roraima Clube",
                "Ber�o dos Craques", "Est�dio Flamarion Vasconcelos", 5000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Gr�mio Atl�tico Sampaio", "GAS", "EC", "Gr�mio Atl�tico Sampaio",
                "Galo Carij�", "Est�dio Ribeir�o", 3000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("S�o Paulo-RR", "SPR", "FC", "S�o Paulo Futebol Clube",
                "Tricolor da Fronteira", "Est�dio Canarinho", 4000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 11);
        new GameTeam("Independente-RR", "IND", "EC", "Independente Esporte Clube",
                "Le�o do Norte", "Est�dio Flamarion Vasconcelos", 5000,
                "Roraima", "Norte", "Brasil", "Am�rica do Sul", 11);

        // Santa Catarina
        new GameTeam("Crici�ma", "CRI", "EC", "Crici�ma Esporte Clube",
                "Tigre do Sul", "Est�dio Heriberto H�lse", 19900,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Ava�", "AVA", "FC", "Ava� Futebol Clube",
                "Le�o da Ilha", "Est�dio Ressacada", 17826,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Chapecoense", "CHA", "ACF", "Associa��o Chapecoense de Futebol",
                "Verd�o do Oeste", "Arena Cond�", 20089,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Brusque", "BRU", "FCF", "Brusque Futebol Clube",
                "Quadricolor do Vale", "Est�dio Augusto Bauer", 10000,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Figueirense", "FIG", "FCF", "Figueirense Futebol Clube",
                "Furac�o do Estreito", "Est�dio Orlando Scarpelli", 19000,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Joinville", "JOI", "ECJ", "Joinville Esporte Clube",
                "JEC", "Est�dio Arena Joinville", 22400,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Marc�lio Dias", "MAR", "ACD", "Marc�lio Dias Futebol Clube",
                "Marinheiro", "Est�dio Dr. Herc�lio Luz", 7000,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Conc�rdia", "CON", "SCC", "Sociedade Esportiva Conc�rdia",
                " Galo do Oeste", "Est�dio Domingos Machado de Lima", 5000,
                "Santa Catarina", "Sul", "Brasil", "Am�rica do Sul", 6);

        // S�o Paulo
        new GameTeam("Corinthians", "COR", "SC", "Sport Club Corinthians Paulista",
                "Tim�o", "Est�dio Neo Qu�mica Arena", 47605,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Palmeiras", "PAL", "SE", "Sociedade Esportiva Palmeiras",
                "Verd�o", "Allianz Parque", 43713,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("S�o Paulo", "SPO", "FC", "S�o Paulo Futebol Clube",
                "Tricolor", "Est�dio C�cero Pompeu de Toledo (Morumbi)", 72030,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Red Bull Bragantino", "RBB", "SA", "Red Bull Bragantino Sociedade An�nima",
                "Massa Bruta", "Est�dio Nabi Abi Chedid", 17128,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Santos", "SAN", "FC", "Santos Futebol Clube",
                "Peixe", "Est�dio Urbano Caldeira (Vila Belmiro)", 16068,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Ponte Preta", "PON", "EA", "Associa��o Atl�tica Ponte Preta",
                "Macaca", "Est�dio Mois�s Lucarelli (Majestoso)", 19728,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Mirassol", "MIR", "FC", "Mirassol Futebol Clube",
                "Le�o", "Est�dio Municipal Jos� Maria de Campos Maia", 15000,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 1);
        new GameTeam("Novorizontino", "NOV", "EC", "Novorizontino Esporte Clube",
                "Tigre do Vale", "Est�dio Jorge Ismael de Biasi", 16000,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Ituano", "ITU", "FC", "Ituano Futebol Clube",
                "Galo de Itu", "Est�dio Novelli J�nior", 18000,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("S�o Bernardo FC", "SBC", "FC", "S�o Bernardo Futebol Clube",
                "Bern�", "Est�dio Primeiro de Maio", 15000,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Botafogo-SP", "BOT", "SA", "Botafogo Futebol Clube Sociedade An�nima do Futebol",
                "Pantera", "Est�dio Santa Cruz", 28778,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Guarani", "GUA", "FC", "Guarani Futebol Clube",
                "Bugre", "Est�dio Brinco de Ouro da Princesa", 29130,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Ferrovi�ria", "FER", "SA", "Associa��o Ferrovi�ria de Esportes",
                "Ferrinha", "Est�dio Fonte Luminosa", 20000,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 2);
        new GameTeam("Portuguesa", "POR", "TE", "Associa��o Portuguesa de Desportos",
                "Lusa", "Est�dio Canind�", 70000,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Am�rica-SP", "AME", "SP", "Am�rica Futebol Clube (SP)",
                "Coelho", "Est�dio Independ�ncia", 20000,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Santo Andr�", "SAN", "EA", "Esporte Clube Santo Andr�",
                "Ramalh�o", "Est�dio Bruno Jos� Daniel", 14400,
                "S�o Paulo", "Sudeste", "Brasil", "Am�rica do Sul", 6);

        // Sergipe
        new GameTeam("Confian�a", "CON", "SCFC", "Sociedade Esportiva Confian�a",
                "Drag�o do Bairro Industrial", "Est�dio Batist�o", 15500,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Sergipe", "SER", "CSE", "Club Sportivo Sergipe",
                "Vermelhinho", "Est�dio Jo�o Hora de Oliveira", 16000,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 5);
        new GameTeam("Itabaiana", "ITA", "FC", "Itabaiana Futebol Clube",
                "Tremend�o", "Est�dio Etelvino Mendon�a", 10000,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 3);
        new GameTeam("Lagarto", "LAG", "FC", "Lagarto Futebol Clube",
                "Vermelhinho do Agreste", "Est�dio Ol�mpico de Lagarto", 8000,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Am�rica de Propri�", "AME", "CEAD", "Centro Esportivo e Atl�tico de Propri�",
                "Mec�o do Sert�o", "Est�dio Municipal Jo�o Alves Filho", 5000,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Freipaulistano", "FRE", "FCF", "Freipaulistano Futebol Clube",
                "Touro do Sert�o", "Est�dio Municipal de Frei Paulo", 5000,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Guarany de Porto da Folha", "GUA", "ADC", "Associa��o Desportiva Guarany",
                "Periquito do Sert�o", "Est�dio Municipal de Porto da Folha", 5000,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Dorense", "DOR", "SE", "Dorense Sociedade Esportiva",
                "Le�o do Sert�o", "Est�dio Ariston Azevedo", 5000,
                "Sergipe", "Nordeste", "Brasil", "Am�rica do Sul", 10);

        // Tocantins
        new GameTeam("Palmas", "PAL", "SE", "Sociedade Esportiva Palmas",
                "Verd�o do Norte", "Est�dio Nilton Santos", 12000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Tocantin�polis", "TOC", "EC", "Tocantin�polis Esporte Clube",
                "Tigre do Norte", "Est�dio Ribeir�o", 8000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 4);
        new GameTeam("Interporto", "INT", "FC", "Interporto Futebol Clube",
                "Porto", "Est�dio General Sampaio", 7000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 6);
        new GameTeam("Gurupi", "GUR", "EC", "Gurupi Esporte Clube",
                "Gavi�o do Norte", "Est�dio Resend�o", 2000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 7);
        new GameTeam("Aragua�na", "ARA", "FAC", "Aragua�na Futebol Clube",
                "Le�o do Norte", "Est�dio Le�nidas de Castro", 8000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 8);
        new GameTeam("Jataiense", "JAT", "GE", "Jataiense Esporte Clube",
                "Canarinho do Araguaia", "Est�dio Municipal de Jata�", 5000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 9);
        new GameTeam("Tocantins de Miracema", "TOM", "EC", "Tocantins Esporte Clube de Miracema",
                "Tigre do Tocantins", "Est�dio Castanheir�o", 5000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 10);
        new GameTeam("Colinas", "COL", "FEC", "Colinas Esporte Clube",
                "Cachorr�o do Sul", "Est�dio Bigol�o", 5000,
                "Tocantins", "Norte", "Brasil", "Am�rica do Sul", 11);

        // Argentina
        new GameTeam("Boca Juniors", "BOC", "CABJ", "Club Atl�tico Boca Juniors",
                "Xeneizes", "Estadio Alberto J. Armando (La Bombonera)", 54000,
                "Buenos Aires", "Buenos Aires", "Argentina", "Am�rica do Sul", 0);
        new GameTeam("River Plate", "RIV", "CARP", "Club Atl�tico River Plate",
                "Millonarios", "Estadio Monumental", 70074,
                "Buenos Aires", "Buenos Aires", "Argentina", "Am�rica do Sul", 0);
        new GameTeam("Independiente", "IND", "CAI", "Club Atl�tico Independiente",
                "Rey de Copas", "Estadio Libertadores de Am�rica", 48314,
                "Avellaneda", "Buenos Aires", "Argentina", "Am�rica do Sul", 0);
        new GameTeam("Racing Club", "RAC", "RC", "Racing Club",
                "La Academia", "Estadio Presidente Per�n", 51389,
                "Avellaneda", "Buenos Aires", "Argentina", "Am�rica do Sul", 0);
        new GameTeam("San Lorenzo", "SLO", "CASLA", "Club Atl�tico San Lorenzo de Almagro",
                "El Cicl�n", "Estadio Pedro Bidegain", 47357,
                "Buenos Aires", "Buenos Aires", "Argentina", "Am�rica do Sul", 0);
        new GameTeam("V�lez Sarsfield", "VEL", "CAVS", "Club Atl�tico V�lez Sarsfield",
                "El Fort�n", "Estadio Jos� Amalfitani", 49540,
                "Buenos Aires", "Buenos Aires", "Argentina", "Am�rica do Sul", 0);
        new GameTeam("Estudiantes", "EST", "CGE", "Club Estudiantes de La Plata",
                "Los Pincharratas", "Estadio Jorge Luis Hirschi", 35000,
                "La Plata", "Buenos Aires", "Argentina", "Am�rica do Sul", 0);
        new GameTeam("Newell's Old Boys", "NOB", "CANOB", "Club Atl�tico Newell's Old Boys",
                "La Lepra", "Estadio Marcelo Bielsa", 38095,
                "Rosario", "Santa Fe", "Argentina", "Am�rica do Sul", 0);

        // Bol�via
        new GameTeam("Bol�var", "BOL", "CBB", "Club Bol�var",
                "La Academia", "Estadio Hernando Siles", 41943,
                "La Paz", "La Paz", "Bol�via", "Am�rica do Sul", 0);
        new GameTeam("The Strongest", "STR", "CTS", "Club The Strongest",
                "El Tigre", "Estadio Hernando Siles", 41943,
                "La Paz", "La Paz", "Bol�via", "Am�rica do Sul", 0);
        new GameTeam("Wilstermann", "WIL", "JAW", "Club Jorge Wilstermann",
                "Aviadores", "Estadio F�lix Capriles", 32000,
                "Cochabamba", "Cochabamba", "Bol�via", "Am�rica do Sul", 0);
        new GameTeam("Oriente Petrolero", "ORI", "OP", "Club Deportivo Oriente Petrolero",
                "Albiverdes", "Estadio Ram�n Tahuichi Aguilera", 35000,
                "Santa Cruz de la Sierra", "Santa Cruz", "Bol�via", "Am�rica do Sul", 0);
        new GameTeam("Blooming", "BLO", "CB", "Club Blooming",
                "La Academia Cruce�a", "Estadio Ram�n Tahuichi Aguilera", 35000,
                "Santa Cruz de la Sierra", "Santa Cruz", "Bol�via", "Am�rica do Sul", 0);
        new GameTeam("Always Ready", "ALW", "CAR", "Club Always Ready",
                "Millonario", "Estadio Municipal de El Alto", 25000,
                "El Alto", "La Paz", "Bol�via", "Am�rica do Sul", 0);
        new GameTeam("Real Potos�", "RPO", "CRP", "Club Real Potos�",
                "Los Lilas", "Estadio V�ctor Agust�n Ugarte", 32000,
                "Potos�", "Potos�", "Bol�via", "Am�rica do Sul", 0);
        new GameTeam("Nacional Potos�", "NPO", "CNP", "Club Atl�tico Nacional Potos�",
                "Rancho Guitarra", "Estadio V�ctor Agust�n Ugarte", 32000,
                "Potos�", "Potos�", "Bol�via", "Am�rica do Sul", 0);

        // Chile
        new GameTeam("Colo-Colo", "COL", "CSDCC", "Club Social y Deportivo Colo-Colo",
                "Los Albos", "Estadio Monumental David Arellano", 47347,
                "Santiago", "Regi�o Metropolitana", "Chile", "Am�rica do Sul", 0);
        new GameTeam("Universidad de Chile", "UCH", "CFUCH", "Club de F�tbol Universidad de Chile",
                "La U", "Estadio Nacional Julio Mart�nez Pr�danos", 48665,
                "Santiago", "Regi�o Metropolitana", "Chile", "Am�rica do Sul", 0);
        new GameTeam("Universidad Cat�lica", "UCA", "CDUC", "Club Deportivo Universidad Cat�lica",
                "Los Cruzados", "Estadio San Carlos de Apoquindo", 14000,
                "Santiago", "Regi�o Metropolitana", "Chile", "Am�rica do Sul", 0);
        new GameTeam("Cobreloa", "COB", "CDC", "Club de Deportes Cobreloa",
                "Los Zorros del Desierto", "Estadio Zorros del Desierto", 12000,
                "Calama", "Antofagasta", "Chile", "Am�rica do Sul", 2);
        new GameTeam("Uni�n Espa�ola", "UES", "CUE", "Club Uni�n Espa�ola",
                "Los Hispanos", "Estadio Santa Laura", 22000,
                "Santiago", "Regi�o Metropolitana", "Chile", "Am�rica do Sul", 0);
        new GameTeam("Audax Italiano", "AUD", "AIFC", "Audax Italiano La Florida",
                "Los Tanos", "Estadio Bicentenario de La Florida", 12000,
                "Santiago", "Regi�o Metropolitana", "Chile", "Am�rica do Sul", 0);
        new GameTeam("Huachipato", "HUA", "CDH", "Club Deportivo Huachipato",
                "Acereros", "Estadio CAP", 10500,
                "Talcahuano", "Biob�o", "Chile", "Am�rica do Sul", 0);
        new GameTeam("Palestino", "PAL", "CDP", "Club Deportivo Palestino",
                "�rabes", "Estadio Municipal de La Cisterna", 12000,
                "Santiago", "Regi�o Metropolitana", "Chile", "Am�rica do Sul", 0);
        new GameTeam("O'Higgins", "OHI", "CDOH", "Club Deportivo O'Higgins",
                "Los Celestes", "Estadio El Teniente", 14450,
                "Rancagua", "O'Higgins", "Chile", "Am�rica do Sul", 0);

        // Col�mbia
        new GameTeam("Atl�tico Nacional", "ATN", "AN", "Club Atl�tico Nacional S.A.",
                "Verdolagas", "Estadio Atanasio Girardot", 40043,
                "Medell�n", "Antioquia", "Col�mbia", "Am�rica do Sul", 0);
        new GameTeam("Millonarios", "MIL", "MFC", "Millonarios F�tbol Club",
                "Los Embajadores", "Estadio El Camp�n", 36000,
                "Bogot�", "Distrito Capital", "Col�mbia", "Am�rica do Sul", 0);
        new GameTeam("Am�rica de Cali", "AME", "ADC", "Am�rica de Cali S.A.",
                "Los Diablos Rojos", "Estadio Pascual Guerrero", 35405,
                "Cali", "Valle del Cauca", "Col�mbia", "Am�rica do Sul", 0);
        new GameTeam("Deportivo Cali", "CAL", "DC", "Asociaci�n Deportivo Cali",
                "Los Azucareros", "Estadio Deportivo Cali", 52000,
                "Cali", "Valle del Cauca", "Col�mbia", "Am�rica do Sul", 0);
        new GameTeam("Independiente Santa Fe", "ISF", "ISF", "Independiente Santa Fe S.A.",
                "Los Cardenales", "Estadio El Camp�n", 36000,
                "Bogot�", "Distrito Capital", "Col�mbia", "Am�rica do Sul", 0);
        new GameTeam("Junior", "JUN", "CDPJ", "Club Deportivo Popular Junior F.C. S.A.",
                "Los Tiburones", "Estadio Metropolitano Roberto Mel�ndez", 46692,
                "Barranquilla", "Atl�ntico", "Col�mbia", "Am�rica do Sul", 0);
        new GameTeam("Independiente Medell�n", "DIM", "DIM", "Deportivo Independiente Medell�n S.A.",
                "El Poderoso de la Monta�a", "Estadio Atanasio Girardot", 40043,
                "Medell�n", "Antioquia", "Col�mbia", "Am�rica do Sul", 0);
        new GameTeam("Once Caldas", "ONC", "OC", "Corporaci�n Deportiva Once Caldas",
                "El Blanco Blanco", "Estadio Palogrande", 36553,
                "Manizales", "Caldas", "Col�mbia", "Am�rica do Sul", 0);

        // Equador
        new GameTeam("Barcelona SC", "BAR", "BSC", "Barcelona Sporting Club",
                "�dolo del Ecuador", "Estadio Monumental Isidro Romero Carbo", 59354,
                "Guayaquil", "Guayas", "Equador", "Am�rica do Sul", 0);
        new GameTeam("Emelec", "EME", "CSE", "Club Sport Emelec",
                "El Bombillo", "Estadio George Capwell", 40000,
                "Guayaquil", "Guayas", "Equador", "Am�rica do Sul", 0);
        new GameTeam("LDU Quito", "LDU", "LDUQ", "Liga Deportiva Universitaria de Quito",
                "Los Albos", "Estadio Rodrigo Paz Delgado", 41575,
                "Quito", "Pichincha", "Equador", "Am�rica do Sul", 0);
        new GameTeam("Independiente del Valle", "IDV", "IDV", "Club de Alto Rendimiento Especializado Independiente del Valle",
                "Los Negriazules", "Estadio Banco Guayaquil", 12000,
                "Sangolqu�", "Pichincha", "Equador", "Am�rica do Sul", 0);
        new GameTeam("El Nacional", "NAC", "CDN", "Club Deportivo El Nacional",
                "Los Puros Criollos", "Estadio Ol�mpico Atahualpa", 35000,
                "Quito", "Pichincha", "Equador", "Am�rica do Sul", 0);
        new GameTeam("Deportivo Cuenca", "DCU", "DC", "Club Deportivo Cuenca",
                "Los Morlacos", "Estadio Alejandro Serrano Aguilar", 16540,
                "Cuenca", "Azuay", "Equador", "Am�rica do Sul", 0);
        new GameTeam("Aucas", "AUC", "SDA", "Sociedad Deportiva Aucas",
                "Los Orientales", "Estadio Gonzalo Pozo Ripalda", 18240,
                "Quito", "Pichincha", "Equador", "Am�rica do Sul", 0);
        new GameTeam("Mushuc Runa", "MUS", "MRSC", "Mushuc Runa Sporting Club",
                "El Ponchito", "Estadio Cooperativa Mushuc Runa", 8000,
                "Ambato", "Tungurahua", "Equador", "Am�rica do Sul", 0);

        // Paraguai
        new GameTeam("Olimpia", "OLI", "CAO", "Club Olimpia",
                "El Decano", "Estadio Manuel Ferreira", 22000,
                "Asunci�n", "Asunci�n", "Paraguai", "Am�rica do Sul", 0);
        new GameTeam("Cerro Porte�o", "CER", "CCP", "Club Cerro Porte�o",
                "El Cicl�n", "Estadio General Pablo Rojas", 45000,
                "Asunci�n", "Asunci�n", "Paraguai", "Am�rica do Sul", 0);
        new GameTeam("Libertad", "LIB", "CL", "Club Libertad",
                "Gumarelo", "Estadio Dr. Nicol�s Leoz", 10000,
                "Asunci�n", "Asunci�n", "Paraguai", "Am�rica do Sul", 0);
        new GameTeam("Guaran�", "GUA", "CAG", "Club Guaran�",
                "El Legendario", "Estadio Rogelio Livieres", 8000,
                "Asunci�n", "Asunci�n", "Paraguai", "Am�rica do Sul", 0);
        new GameTeam("Nacional", "NAC", "CN", "Club Nacional",
                "La Academia", "Estadio Arsenio Erico", 5000,
                "Asunci�n", "Asunci�n", "Paraguai", "Am�rica do Sul", 0);
        new GameTeam("Sol de Am�rica", "SOL", "CSDA", "Club Sol de Am�rica",
                "Los Danzarines", "Estadio Luis Alfonso Giagni", 5000,
                "Villa Elisa", "Central", "Paraguai", "Am�rica do Sul", 0);
        new GameTeam("Sportivo Luque�o", "SLU", "CSL", "Club Sportivo Luque�o",
                "Chanch�n", "Estadio Feliciano C�ceres", 25000,
                "Luque", "Central", "Paraguai", "Am�rica do Sul", 0);
        new GameTeam("General D�az", "GDI", "CGD", "Club General D�az",
                "�guias", "Estadio General Adri�n Jara", 8000,
                "Luque", "Central", "Paraguai", "Am�rica do Sul", 0);

        // Peru
        new GameTeam("Alianza Lima", "ALI", "CAA", "Club Alianza Lima",
                "Los �ntimos", "Estadio Alejandro Villanueva", 35000,
                "Lima", "Lima", "Peru", "Am�rica do Sul", 0);
        new GameTeam("Universitario", "UNI", "CUF", "Club Universitario de Deportes",
                "La U", "Estadio Monumental", 80093,
                "Lima", "Lima", "Peru", "Am�rica do Sul", 0);
        new GameTeam("Sporting Cristal", "SCR", "CSC", "Club Sporting Cristal",
                "Los Cerveceros", "Estadio Alberto Gallardo", 20000,
                "Lima", "Lima", "Peru", "Am�rica do Sul", 0);
        new GameTeam("FBC Melgar", "MEL", "FBCM", "Foot Ball Club Melgar",
                "Los Rojinegros", "Estadio Monumental Virgen de Chapi", 60000,
                "Arequipa", "Arequipa", "Peru", "Am�rica do Sul", 0);
        new GameTeam("Cienciano", "CIE", "CC", "Club Cienciano",
                "Los Imperiales", "Estadio Inca Garcilaso de la Vega", 42056,
                "Cusco", "Cusco", "Peru", "Am�rica do Sul", 0);
        new GameTeam("Deportivo Municipal", "DEM", "CDM", "Club Centro Deportivo Municipal",
                "La Academia", "Estadio Iv�n El�as Moreno", 10000,
                "Lima", "Lima", "Peru", "Am�rica do Sul", 0);
        new GameTeam("Sport Boys", "SPB", "SBA", "Sport Boys Association",
                "La Misilera", "Estadio Miguel Grau", 17000,
                "Callao", "Callao", "Peru", "Am�rica do Sul", 0);
        new GameTeam("UTC", "UTC", "UTC", "Universidad T�cnica de Cajamarca",
                "El Gavil�n del Norte", "Estadio H�roes de San Ram�n", 18000,
                "Cajamarca", "Cajamarca", "Peru", "Am�rica do Sul", 0);

        // Uruguai
        new GameTeam("Nacional", "NAC", "CNdeF", "Club Nacional de Football",
                "El Bolso", "Estadio Gran Parque Central", 34000,
                "Montevid�u", "Montevid�u", "Uruguai", "Am�rica do Sul", 0);
        new GameTeam("Pe�arol", "PEN", "CAP", "Club Atl�tico Pe�arol",
                "Los Carboneros", "Estadio Campe�n del Siglo", 40000,
                "Montevid�u", "Montevid�u", "Uruguai", "Am�rica do Sul", 0);
        new GameTeam("Defensor Sporting", "DEF", "DSC", "Defensor Sporting Club",
                "Los Violetas", "Estadio Luis Franzini", 18000,
                "Montevid�u", "Montevid�u", "Uruguai", "Am�rica do Sul", 0);
        new GameTeam("Danubio", "DAN", "DFC", "Danubio F�tbol Club",
                "La Franja", "Estadio Jardines del Hip�dromo", 18000,
                "Montevid�u", "Montevid�u", "Uruguai", "Am�rica do Sul", 0);
        new GameTeam("Liverpool", "LIV", "LFC", "Liverpool F�tbol Club",
                "Los Negriazules", "Estadio Belvedere", 8500,
                "Montevid�u", "Montevid�u", "Uruguai", "Am�rica do Sul", 0);
        new GameTeam("River Plate", "RIV", "CARP", "Club Atl�tico River Plate",
                "Darseneros", "Estadio Saroldi", 6000,
                "Montevid�u", "Montevid�u", "Uruguai", "Am�rica do Sul", 0);
        new GameTeam("Montevideo Wanderers", "MW", "MWFC", "Montevideo Wanderers F�tbol Club",
                "Bohemios", "Parque Alfredo V�ctor Viera", 10000,
                "Montevid�u", "Montevid�u", "Uruguai", "Am�rica do Sul", 0);
        new GameTeam("Plaza Colonia", "PLC", "PCC", "Club Plaza Colonia de Deportes",
                "Los Patas Blancas", "Estadio Juan Prandi", 12000,
                "Colonia del Sacramento", "Colonia", "Uruguai", "Am�rica do Sul", 0);

        // Venezuela
        new GameTeam("Caracas FC", "CAR", "CFC", "Caracas F�tbol Club",
                "Los Rojos del �vila", "Estadio Ol�mpico de la UCV", 24000,
                "Caracas", "Distrito Capital", "Venezuela", "Am�rica do Sul", 0);
        new GameTeam("Deportivo T�chira", "TAC", "DTFC", "Deportivo T�chira F�tbol Club",
                "Aurinegros", "Estadio Polideportivo de Pueblo Nuevo", 38000,
                "San Crist�bal", "T�chira", "Venezuela", "Am�rica do Sul", 0);
        new GameTeam("Deportivo La Guaira", "DLG", "DLGFC", "Deportivo La Guaira F�tbol Club",
                "Naranjas", "Estadio Ol�mpico de la UCV", 24000,
                "Caracas", "Distrito Capital", "Venezuela", "Am�rica do Sul", 0);
        new GameTeam("Zamora FC", "ZAM", "ZFC", "Zamora F�tbol Club",
                "Blanquinegros", "Estadio Agust�n Tovar", 30000,
                "Barinas", "Barinas", "Venezuela", "Am�rica do Sul", 0);
        new GameTeam("Mineros de Guayana", "MIN", "MDGFC", "Mineros de Guayana F�tbol Club",
                "Negriazules", "Estadio CTE Cachamay", 41600,
                "Puerto Ordaz", "Bol�var", "Venezuela", "Am�rica do Sul", 0);
        new GameTeam("Estudiantes de M�rida", "EST", "EMFC", "Estudiantes de M�rida F�tbol Club",
                "Acad�micos", "Estadio Metropolitano de M�rida", 42000,
                "M�rida", "M�rida", "Venezuela", "Am�rica do Sul", 0);
        new GameTeam("Aragua FC", "ARA", "AFC", "Aragua F�tbol Club",
                "Aurirrojos", "Estadio Ol�mpico Hermanos Ghersi P�ez", 14500,
                "Maracay", "Aragua", "Venezuela", "Am�rica do Sul", 0);
        new GameTeam("Carabobo FC", "CAR", "CFC", "Carabobo F�tbol Club",
                "Granates", "Estadio Misael Delgado", 10000,
                "Valencia", "Carabobo", "Venezuela", "Am�rica do Sul", 0);

        // Am�ricas
        // M�xico
        new GameTeam("Am�rica", "AME", "CFA", "Club de F�tbol Am�rica",
                "Las �guilas", "Estadio Azteca", 87000,
                "Cidade do M�xico", "Distrito Federal", "M�xico", "Am�rica do Norte", 0);
        new GameTeam("Guadalajara", "GUA", "CDG", "Club Deportivo Guadalajara",
                "Chivas", "Estadio Akron", 49350,
                "Zapopan", "Jalisco", "M�xico", "Am�rica do Norte", 0);
        new GameTeam("Cruz Azul", "CRU", "CFC", "Cruz Azul F�tbol Club",
                "La M�quina", "Estadio Azteca", 87000,
                "Cidade do M�xico", "Distrito Federal", "M�xico", "Am�rica do Norte", 0);
        new GameTeam("Pumas UNAM", "PUM", "CFP", "Club de F�tbol Universidad Nacional",
                "Los Pumas", "Estadio Ol�mpico Universitario", 72000,
                "Cidade do M�xico", "Distrito Federal", "M�xico", "Am�rica do Norte", 0);
        new GameTeam("Monterrey", "MON", "CFM", "Club de F�tbol Monterrey",
                "Rayados", "Estadio BBVA", 53500,
                "Guadalupe", "Nuevo Le�n", "M�xico", "Am�rica do Norte", 0);
        new GameTeam("Tigres UANL", "TIG", "CFT", "Club de F�tbol Tigres de la Universidad Aut�noma de Nuevo Le�n",
                "Los Tigres", "Estadio Universitario", 42000,
                "San Nicol�s de los Garza", "Nuevo Le�n", "M�xico", "Am�rica do Norte", 0);
        new GameTeam("Toluca", "TOL", "CDT", "Deportivo Toluca F�tbol Club",
                "Los Diablos Rojos", "Estadio Nemesio D�ez", 31000,
                "Toluca", "Estado do M�xico", "M�xico", "Am�rica do Norte", 0);
        new GameTeam("Santos Laguna", "SAN", "CLF", "Club Santos Laguna",
                "Guerreros", "Estadio TSM Corona", 30000,
                "Torre�n", "Coahuila", "M�xico", "Am�rica do Norte", 0);

        // Estados Unidos
        new GameTeam("LA Galaxy", "LAG", "LAG", "Los Angeles Galaxy",
                "Galaxy", "Dignity Health Sports Park", 27000,
                "Carson", "Calif�rnia", "Estados Unidos", "Am�rica do Norte", 0);
        new GameTeam("Seattle Sounders", "SEA", "SSFC", "Seattle Sounders FC",
                "Sounders", "Lumen Field", 72000,
                "Seattle", "Washington", "Estados Unidos", "Am�rica do Norte", 0);
        new GameTeam("Atlanta United", "ATL", "AUFC", "Atlanta United FC",
                "The Five Stripes", "Mercedes-Benz Stadium", 71000,
                "Atlanta", "Ge�rgia", "Estados Unidos", "Am�rica do Norte", 0);
        new GameTeam("New York City FC", "NYC", "NYCFC", "New York City Football Club",
                "The Pigeons", "Yankee Stadium", 47309,
                "Nova Iorque", "Nova Iorque", "Estados Unidos", "Am�rica do Norte", 0);
        new GameTeam("Toronto FC", "TOR", "TFC", "Toronto Football Club",
                "The Reds", "BMO Field", 30000,
                "Toronto", "Ont�rio", "Canad�", "Am�rica do Norte", 0);

        // Costa Rica
        new GameTeam("Deportivo Saprissa", "SAP", "CDS", "Deportivo Saprissa",
                "El Monstruo Morado", "Estadio Ricardo Saprissa Aym�", 24000,
                "San Juan de Tib�s", "San Jos�", "Costa Rica", "Am�rica Central", 0);
        new GameTeam("Alajuelense", "ALA", "LDA", "Liga Deportiva Alajuelense",
                "Los Manudos", "Estadio Alejandro Morera Soto", 17895,
                "Alajuela", "Alajuela", "Costa Rica", "Am�rica Central", 0);

        // Honduras
        new GameTeam("Olimpia", "OLI", "CDO", "Club Deportivo Olimpia",
                "Los Leones", "Estadio Nacional Chelato Ucl�s", 35000,
                "Tegucigalpa", "Francisco Moraz�n", "Honduras", "Am�rica Central", 0);
        new GameTeam("Motagua", "MOT", "CDM", "Club Deportivo Motagua",
                "Los Azules", "Estadio Nacional Chelato Ucl�s", 35000,
                "Tegucigalpa", "Francisco Moraz�n", "Honduras", "Am�rica Central", 0);

        // Guatemala
        new GameTeam("Comunicaciones", "COM", "CFC", "Comunicaciones F�tbol Club",
                "Los Cremas", "Estadio Doroteo Guamuch Flores", 26000,
                "Cidade da Guatemala", "Guatemala", "Guatemala", "Am�rica Central", 0);
        new GameTeam("Municipal", "MUN", "CSDM", "Club Social y Deportivo Municipal",
                "Los Rojos", "Estadio Manuel Felipe Carrera", 17000,
                "Cidade da Guatemala", "Guatemala", "Guatemala", "Am�rica Central", 0);

        // Panam�
        new GameTeam("Tauro FC", "TAU", "TFC", "Tauro F�tbol Club",
                "Los Toros de Pedregal", "Estadio Rommel Fern�ndez", 32000,
                "Cidade do Panam�", "Panam�", "Panam�", "Am�rica Central", 0);

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
        new GameTeam("Real Madrid", "RMD", "CF", "Real Madrid Club de F�tbol",
                "Los Blancos", "Estadio Santiago Bernab�u", 81044,
                "Madri", "Espanha", "Espanha", "Europa", 0);
        new GameTeam("Barcelona", "BAR", "FCB", "Futbol Club Barcelona",
                "Bar�a", "Spotify Camp Nou", 99354,
                "Barcelona", "Espanha", "Espanha", "Europa", 0);
        new GameTeam("Atl�tico de Madrid", "ATM", "ATM", "Club Atl�tico de Madrid",
                "Los Colchoneros", "Estadio Metropolitano", 68456,
                "Madri", "Espanha", "Espanha", "Europa", 0);

        // Alemanha
        new GameTeam("Bayern de Munique", "BAY", "FCB", "Fu�ball-Club Bayern M�nchen e.V.",
                "Die Bayern", "Allianz Arena", 75000,
                "Munique", "Baviera", "Alemanha", "Europa", 0);
        new GameTeam("Borussia Dortmund", "BVB", "BVB", "Ballspielverein Borussia 09 e.V. Dortmund",
                "Die Schwarzgelben", "Signal Iduna Park", 81365,
                "Dortmund", "Ren�nia do Norte-Vestf�lia", "Alemanha", "Europa", 0);

        // It�lia
        new GameTeam("Juventus", "JUV", "JFC", "Juventus Football Club",
                "La Vecchia Signora", "Allianz Stadium", 41507,
                "Turim", "Piemonte", "It�lia", "Europa", 0);
        new GameTeam("Internazionale", "INT", "FCIM", "Football Club Internazionale Milano",
                "I Nerazzurri", "Stadio Giuseppe Meazza", 80018,
                "Mil�o", "Lombardia", "It�lia", "Europa", 0);
        new GameTeam("Milan", "MIL", "ACM", "Associazione Calcio Milan",
                "I Rossoneri", "Stadio Giuseppe Meazza", 80018,
                "Mil�o", "Lombardia", "It�lia", "Europa", 0);

        // Fran�a
        new GameTeam("Paris Saint-Germain", "PSG", "PSG", "Paris Saint-Germain Football Club",
                "Les Parisiens", "Parc des Princes", 47929,
                "Paris", "�le-de-France", "Fran�a", "Europa", 0);

        // Portugal
        new GameTeam("Benfica", "BEN", "SLB", "Sport Lisboa e Benfica",
                "As �guias", "Est�dio da Luz", 64642,
                "Lisboa", "Lisboa", "Portugal", "Europa", 0);
        new GameTeam("Porto", "POR", "FCP", "Futebol Clube do Porto",
                "Os Drag�es", "Est�dio do Drag�o", 50033,
                "Porto", "Porto", "Portugal", "Europa", 0);

        // Pa�ses Baixos
        new GameTeam("Ajax", "AJA", "AFC", "Amsterdamsche Football Club Ajax",
                "De Godenzonen", "Johan Cruijff ArenA", 54990,
                "Amsterd�", "Holanda do Norte", "Pa�ses Baixos", "Europa", 0);

        // Esc�cia
        new GameTeam("Celtic", "CEL", "CFC", "Celtic Football Club",
                "The Bhoys", "Celtic Park", 60832,
                "Glasgow", "Esc�cia", "Reino Unido", "Europa", 0);

        // Turquia
        new GameTeam("Galatasaray", "GAL", "GS", "Galatasaray Spor Kul�b�",
                "Cim Bom", "Nef Stadyumu", 52652,
                "Istambul", "M�rmara", "Turquia", "Europa", 0);

        // �sia
        // Ar�bia Saudita
        new GameTeam("Al Hilal", "HIL", "AHFC", "Al Hilal Saudi Football Club",
                "Al-Za'eem", "King Fahd International Stadium", 68752,
                "Riad", "Riad", "Ar�bia Saudita", "�sia", 0);
        new GameTeam("Al Nassr", "NAS", "ANFC", "Al Nassr Football Club",
                "Al-Aalami", "Mrsool Park", 25000,
                "Riad", "Riad", "Ar�bia Saudita", "�sia", 0);

        // Ir�
        new GameTeam("Persepolis", "PER", "PFC", "Persepolis Football Club",
                "The Reds", "Azadi Stadium", 78116,
                "Teer�", "Teer�", "Ir�", "�sia", 0);

        // China
        new GameTeam("Shanghai Port", "SHA", "SPFC", "Shanghai Port Football Club",
                "The Red Eagles", "Pudong Football Stadium", 33765,
                "Xangai", "Xangai", "China", "�sia", 0);

        // Catar
        new GameTeam("Al-Sadd", "SAD", "ASFC", "Al-Sadd Sports Club",
                "Al Zaeem", "Jassim Bin Hamad Stadium", 12946,
                "Doha", "Doha", "Catar", "�sia", 0);

        // Jap�o
        new GameTeam("Kawasaki Frontale", "KAW", "KF", "Kawasaki Frontale",
                "Frontale", "Kawasaki Todoroki Stadium", 27495,
                "Kawasaki", "Kanagawa", "Jap�o", "�sia", 0);
        new GameTeam("Urawa Red Diamonds", "URA", "URD", "Urawa Red Diamonds",
                "Reds", "Saitama Stadium 2002", 63700,
                "Saitama", "Saitama", "Jap�o", "�sia", 0);

        // Coreia do Sul
        new GameTeam("Jeonbuk Hyundai Motors", "JEO", "JHMFC", "Jeonbuk Hyundai Motors Football Club",
                "Green Warriors", "Jeonju World Cup Stadium", 42477,
                "Jeonju", "Jeolla do Norte", "Coreia do Sul", "�sia", 0);

        // Austr�lia
        new GameTeam("Sydney FC", "SYD", "SFC", "Sydney Football Club",
                "The Sky Blues", "Allianz Stadium", 42500,
                "Sydney", "Nova Gales do Sul", "Austr�lia", "�sia", 0);

        // Emirados �rabes Unidos
        new GameTeam("Al-Ain", "AIN", "AAFC", "Al-Ain Football Club",
                "The Boss", "Hazza Bin Zayed Stadium", 25000,
                "Al Ain", "Abu Dhabi", "Emirados �rabes Unidos", "�sia", 0);

        // Uzbequist�o
        new GameTeam("Pakhtakor Tashkent", "PAK", "PTFC", "Pakhtakor Tashkent Football Club",
                "The Lions", "Pakhtakor Markaziy Stadium", 35000,
                "Tashkent", "Tashkent", "Uzbequist�o", "�sia", 0);

        // Tail�ndia
        new GameTeam("Buriram United", "BUR", "BUFC", "Buriram United Football Club",
                "Thunder Castle", "Chang Arena", 32600,
                "Buriram", "Buriram", "Tail�ndia", "�sia", 0);

        // �ndia
        new GameTeam("Mumbai City FC", "MUM", "MCFC", "Mumbai City Football Club",
                "The Islanders", "Mumbai Football Arena", 18000,
                "Mumbai", "Maharashtra", "�ndia", "�sia", 0);

        // Jord�nia
        new GameTeam("Al-Faisaly", "FAI", "AFFC", "Al-Faisaly Football Club",
                "The Blue Eagles", "Amman International Stadium", 17000,
                "Am�", "Am�", "Jord�nia", "�sia", 0);

        // Iraque
        new GameTeam("Al-Shorta", "SHO", "ASFC", "Al-Shorta Sports Club",
                "The Police", "Al-Shaab Stadium", 35000,
                "Bagd�", "Bagd�", "Iraque", "�sia", 0);

        // S�ria
        new GameTeam("Al-Ittihad Aleppo", "ITT", "AISC", "Al-Ittihad Sports Club",
                "The Red Castle", "Aleppo International Stadium", 75000,
                "Aleppo", "Aleppo", "S�ria", "�sia", 0);

        // Vietn�
        new GameTeam("Hanoi FC", "HAN", "HFC", "Hanoi Football Club",
                "The Capital Team", "Hang Day Stadium", 22500,
                "Han�i", "Han�i", "Vietn�", "�sia", 0);

        // Mal�sia
        new GameTeam("Johor Darul Ta'zim", "JDT", "JDTFC", "Johor Darul Ta'zim Football Club",
                "Southern Tigers", "Sultan Ibrahim Stadium", 40000,
                "Iskandar Puteri", "Johor", "Mal�sia", "�sia", 0);

        // Catar
        new GameTeam("Al-Duhail", "DUH", "ADSC", "Al-Duhail Sports Club",
                "The Red Knights", "Abdullah bin Khalifa Stadium", 9740,
                "Doha", "Doha", "Catar", "�sia", 0);

        // China
        new GameTeam("Beijing Guoan", "BEI", "BGFC", "Beijing Guoan Football Club",
                "Imperial Guards", "Workers' Stadium", 68000,
                "Pequim", "Pequim", "China", "�sia", 0);

        // �frica
        // Egito
        new GameTeam("Al Ahly", "AHL", "ASC", "Al Ahly Sporting Club",
                "Os Vermelhos", "Est�dio Internacional do Cairo", 75000,
                "Cairo", "Cairo", "Egito", "�frica", 0);
        new GameTeam("Zamalek", "ZAM", "ZSC", "Zamalek Sporting Club",
                "Os Cavaleiros Brancos", "Est�dio Internacional do Cairo", 75000,
                "Cairo", "Cairo", "Egito", "�frica", 0);

        // �frica do Sul
        new GameTeam("Mamelodi Sundowns", "MSD", "MSFC", "Mamelodi Sundowns Football Club",
                "Os Brasileiros", "Loftus Versfeld Stadium", 51762,
                "Pret�ria", "Gauteng", "�frica do Sul", "�frica", 0);
        new GameTeam("Orlando Pirates", "ORP", "OPFC", "Orlando Pirates Football Club",
                "Os Bucaneiros", "Orlando Stadium", 37500,
                "Joanesburgo", "Gauteng", "�frica do Sul", "�frica", 0);

        // Tun�sia
        new GameTeam("Esp�rance de Tunis", "EST", "EST", "Esp�rance Sportive de Tunis",
                "Sang et Or", "Est�dio Ol�mpico de Rad�s", 60000,
                "T�nis", "T�nis", "Tun�sia", "�frica", 0);
        new GameTeam("�toile du Sahel", "ESS", "ESS", "�toile Sportive du Sahel",
                "Os Estrelas", "Est�dio Ol�mpico de Sousse", 28000,
                "Sousse", "Sousse", "Tun�sia", "�frica", 0);

        // Marrocos
        new GameTeam("Wydad Casablanca", "WYD", "WAC", "Wydad Athletic Club",
                "Os Vermelhos", "Est�dio Mohammed V", 67000,
                "Casablanca", "Casablanca-Settat", "Marrocos", "�frica", 0);
        new GameTeam("Raja Casablanca", "RAJ", "RCA", "Raja Club Athletic",
                "Os Verdes", "Est�dio Mohammed V", 67000,
                "Casablanca", "Casablanca-Settat", "Marrocos", "�frica", 0);

        // Arg�lia
        new GameTeam("JS Kabylie", "JSK", "JSK", "Jeunesse Sportive de Kabylie",
                "Os Le�es do Djurdjura", "Est�dio 1� de Novembro de 1954", 21000,
                "Tizi Ouzou", "Tizi Ouzou", "Arg�lia", "�frica", 0);
        new GameTeam("CR Belouizdad", "CRB", "CRB", "Chabab Riadhi de Belouizdad",
                "Os Chabab", "Est�dio 20 de Agosto de 1955", 20000,
                "Argel", "Argel", "Arg�lia", "�frica", 0);

        // Rep�blica Democr�tica do Congo
        new GameTeam("TP Mazembe", "TPM", "TPM", "Tout Puissant Mazembe",
                "Os Corvos", "Est�dio TP Mazembe", 18000,
                "Lubumbashi", "Haut-Katanga", "Rep�blica Democr�tica do Congo", "�frica", 0);
        new GameTeam("AS Vita Club", "ASV", "ASV", "Association Sportive Vita Club",
                "Os Moscovitas", "Est�dio dos M�rtires", 80000,
                "Kinshasa", "Kinshasa", "Rep�blica Democr�tica do Congo", "�frica", 0);

        // Nig�ria
        new GameTeam("Enyimba", "ENY", "ENY", "Enyimba International Football Club",
                "Os Elefantes do Povo", "Est�dio Enyimba International", 25000,
                "Aba", "Abia", "Nig�ria", "�frica", 0);

        // Gana
        new GameTeam("Asante Kotoko", "ASK", "ASK", "Asante Kotoko Sporting Club",
                "Os Porcos-Espinhos", "Est�dio Baba Yara", 40000,
                "Kumasi", "Ashanti", "Gana", "�frica", 0);
        new GameTeam("Hearts of Oak", "HRT", "HRT", "Accra Hearts of Oak Sporting Club",
                "Os Fen�cios", "Est�dio Ohene Djan", 40000,
                "Acra", "Grande Acra", "Gana", "�frica", 0);

        // Costa do Marfim
        new GameTeam("ASEC Mimosas", "ASE", "ASE", "Association Sportive des Employ�s de Commerce Mimosas",
                "Os Mimosas", "Est�dio F�lix Houphou�t-Boigny", 50000,
                "Abidjan", "Abidjan", "Costa do Marfim", "�frica", 0);

        // Sud�o
        new GameTeam("Al Hilal Omdurman", "HIL", "AHO", "Al Hilal Club",
                "Os L�deres", "Est�dio Al Hilal", 35000,
                "Omdurman", "Cartum", "Sud�o", "�frica", 0);

        // Angola
        new GameTeam("Petro de Luanda", "PET", "PET", "Atl�tico Petr�leos de Luanda",
                "Os Tricolores", "Est�dio 11 de Novembro", 50000,
                "Luanda", "Luanda", "Angola", "�frica", 0);

        // Tanz�nia
        new GameTeam("Simba SC", "SIM", "SIM", "Simba Sports Club",
                "Os Le�es", "Est�dio Nacional da Tanz�nia", 60000,
                "Dar es Salaam", "Dar es Salaam", "Tanz�nia", "�frica", 0);

        // Z�mbia
        new GameTeam("ZESCO United", "ZES", "ZES", "ZESCO United Football Club",
                "Team Ya Ziko", "Est�dio Levy Mwanawasa", 49000,
                "Ndola", "Copperbelt", "Z�mbia", "�frica", 0);

    }

    public static void registerStateCups() {
        // Brasil
        new GameCup("Campeonato Acreano", "Acre", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Acre") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Alagoano", "Alagoas", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Alagoas") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Amapaense", "Amap�", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Amap�") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Amazonense", "Amazonas", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Amazonas") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Baiano", "Bahia", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Bahia") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Cearense", "Cear�", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Cear�") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Candango", "Distrito Federal", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Distrito Federal") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Capixaba", "Esp�rito Santo", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Esp�rito Santo") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Goiano", "Goi�s", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Goi�s") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Maranhense", "Maranh�o", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Maranh�o") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Mato-Grossense", "Mato Grosso", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Mato Grosso") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Sul-Mato-Grossense", "Mato Grosso do Sul", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Mato Grosso do Sul") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Mineiro", "Minas Gerais", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Minas Gerais") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paraense", "Par�", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Par�") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paraibano", "Para�ba", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Para�ba") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paranaense", "Paran�", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Paran�") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Pernambucano", "Pernambuco", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Pernambuco") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Piauiense", "Piau�", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Piau�") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Carioca", "Rio de Janeiro", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rio de Janeiro") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Potiguar", "Rio Grande do Norte", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rio Grande do Norte") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Ga�cho", "Rio Grande do Sul", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rio Grande do Sul") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Rondoniense", "Rond�nia", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Rond�nia") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Roraimense", "Roraima", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Roraima") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Catarinense", "Santa Catarina", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("Santa Catarina") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
        new GameCup("Campeonato Paulista", "S�o Paulo", 1_000_000, GameCupType.ELIMINATION,
                team -> team.getState().equalsIgnoreCase("S�o Paulo") && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.STATE, true);
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
        new GameCup("Brasileir�o S�rie A", "1", 50_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 1 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie B", "2", 25_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 2 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie C", "3", 10_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 3 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie D", "4", 9_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 4 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie E", "5", 8_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 5 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie F", "6", 7_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 6 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie G", "7", 6_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 7 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie H", "8", 5_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 8 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie I", "9", 4_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 9 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie J", "10", 3_000_000, GameCupType.POINTS,
                team -> team.getDivision() == 10 && team.getCountry().equalsIgnoreCase("Brasil"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Brasileir�o S�rie K", "11", 2_000_000, GameCupType.POINTS,
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
                brasilCup.getReason().put(moreTeam, i + "� lugar na " + gameCup.getName());
            }
        }
    }

    public static void registerInternacionalCups() {
        new GameCup("Copa da Argentina", "Argentina", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Argentina"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa da Bol�via", "Bol�via", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Bol�via"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa do Chile", "Chile", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Chile"), 0, GameCupRegionType.COUNTRY, true);
        new GameCup("Copa da Col�mbia", "Col�mbia", 50_000_000, GameCupType.POINTS,
                team -> team.getCountry().equalsIgnoreCase("Col�mbia"), 0, GameCupRegionType.COUNTRY, true);
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
        new GameCup("Copa da Am�rica", "Am�rica", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("Am�rica do Norte") || team.getContinent().equalsIgnoreCase("Am�rica Central"), 0, GameCupRegionType.CONTINENT, true);
        new GameCup("Copa da Europa", "Europa", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("Europa"), 0, GameCupRegionType.CONTINENT, true);
        new GameCup("Copa da �sia", "�sia", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("�sia"), 0, GameCupRegionType.CONTINENT, true);
        new GameCup("Copa da �frica", "�frica", 50_000_000, GameCupType.POINTS,
                team -> team.getContinent().equalsIgnoreCase("�frica"), 0, GameCupRegionType.CONTINENT, true);
    }

}
