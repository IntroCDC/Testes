package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coelho at 14/02/2025 - 06:55
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public enum Music {
    // Mister IA
    AGUINHA_GELADINHA("Aguinha Geladinha", true, "16/07/2024 - 16:38", 0, 66, 1, new String[]{"metal", "1 verso", "letra original"}, new String[]{"Aguinha Geladinha (Vers�o Piano)", "Aguinha Geladinha (Vers�o Vozes do Inferno)"}, new String[]{}),
    AGUINHA_GELADINHA_VERSAO_PISEIRO("Aguinha Geladinha (Vers�o Piseiro)", true, "20/09/2024 - 18:50", 1, 33, 0, new String[]{"forr� piseiro", "1 verso", "letra original"}, new String[]{}, new String[]{}),
    AGUINHA_QUENTINHA("Aguinha Quentinha", true, "12/11/2024 - 17:34", 1, 64, 15, new String[]{"sertanejo", "1 verso", "expl�cita", "letra original"}, new String[]{}, new String[]{}),
    ALEXA_COM_RAIVA("Alexa com Raiva", true, "21/10/2024 - 01:26", 1, 49, 4, new String[]{"rap", "jovem din�mico", "expl�cita", "letra original"}, new String[]{}, new String[]{}),
    ASTACARABUMTS("Astacar�bumts", true, "19/06/2024 - 00:07", 0, 34, 3, new String[]{"dubstep", "piada interna", "expl�cita"}, new String[]{"Astacar�bumts (Bass Boost)", "Astacar�bumts (Vers�o Piseiro)", "Astacar�bumts (Vers�o DJ)"}, new String[]{"Astacar�bumts (Vers�o Piseiro 1)", "Astacar�bumts (Vers�o DJ 1)"}),
    ARROCHA_DAS_GATINHAS("Arrocha das Gatinhas", true, "08/06/2025 - 08:55", 3, 11, 3, new String[]{"arrocha", "gatinhas", "letra original"}, new String[]{}, new String[]{}),
    ARROCHA_DO_JOVEM_DINAMICO("Arrocha do Jovem Din�mico", true, "08/02/2025 - 19:23", 2, 66, 5, new String[]{"metal", "jovem din�mico", "expl�cita", "letra original", "escatol�gica"}, new String[]{"Arrocha do Jovem Din�mico (Vers�o Arrocha)", "Arrocha do Jovem Din�mico (Vers�o Piseiro)", "Arrocha do Jovem Din�mico (Vers�o Censurada)"}, new String[]{}),
    ARROCHA_DO_MARIAUM("Arrocha do Mariaum", true, "03/06/2025 - 05:14", 3, 6, 1, new String[]{"arrocha", "mariaum", "bruno", "severo", "letra original"}, new String[]{"Arrocha do Mariaum (Vers�o Mariaum)"}, new String[]{}),
    ATRAPALHADOR("Atrapalhador", true, "04/07/2024 - 13:33", 0, 50, 2, new String[]{"rock", "jovem din�mico", "rima", "letra original", "escatol�gica"}, new String[]{"Atrapalhador (Vers�o Piano)"}, new String[]{"Atrapalhador (Vers�o Piano 1)", "Atrapalhador (Vers�o Piano 2)"}),
    ATRAPALHADOR_VERSAO_PISEIRO("Atrapalhador (Vers�o Piseiro)", true, "19/09/2024 - 13:28", 1, 32, 0, new String[]{"forr� piseiro", "jovem din�mico", "rima", "letra original", "escatol�gica"}, new String[]{}, new String[]{"Atrapalhador (Vers�o Piseiro 1)"}),
    AVENTURA_NO_MUNDO_DE_BLOCOS("Aventura no Mundo de Blocos", true, "19/10/2024 - 20:33", 1, 47, 1, new String[]{"piano", "instrumental"}, new String[]{}, new String[]{}),
    BERIMBAU("Berimbau", true, "04/08/2024 - 15:31", 1, 2, 1, new String[]{"pagode", "1 verso", "expl�cita", "lucas moreira"}, new String[]{"Beriumbau (Vers�o Brega)", "Berimbau (Vers�o Arrocha)", "Berimbau (Vers�o Funk)"}, new String[]{"Berimbau (Vers�o Brega 1)", "Berimbau (Vers�o Arrocha 1)", "Berimbau (Vers�o Funk 1)", "Berimbau (Vers�o Funk 2)", "Berimbau (Vers�o Funk 3)"}),
    CAGADA_NERVOSA("Cagada Nervosa", true, "21/10/2024 - 01:59", 1, 50, 7, new String[]{"pop", "v�deo do canal", "expl�cita", "escatol�gica"}, new String[]{}, new String[]{}),
    CLAUDINHO("Claudinho", true, "11/01/2025 - 10:38", 2, 51, 3, new String[]{"forr� piseiro", "lenon", "letra original"}, new String[]{}, new String[]{}),
    COCO_NA_ARARIUS("Coc� na Arari�s", true, "04/07/2024 - 12:32", 0, 47, 1, new String[]{"rock", "1 verso", "cd antigo", "expl�cita", "escatol�gica"}, new String[]{}, new String[]{}),
    COMENTARIOS("Coment�rios", true, "05/07/2024 - 12:58", 0, 53, 0, new String[]{"rock", "piada interna"}, new String[]{}, new String[]{}),
    COMIDA_GOSTOSA("Comida Gostosa", true, "18/06/2024 - 10:48", 0, 33, 1, new String[]{"pagode", "1 verso", "letra original", "escatol�gica"}, new String[]{}, new String[]{"Comida Gostosa (Vers�o Metal 1)"}),
    COMIDA_GOSTOSA_VERSAO_METAL("Comida Gostosa (Vers�o Metal)", true, "19/09/2024 - 12:16", 1, 31, 0, new String[]{"metal", "1 verso", "letra original", "escatol�gica"}, new String[]{}, new String[]{}),
    CORRE_PRA_PRAIA("Corre pra Praia", true, "16/07/2024 - 22:30", 0, 69, 1, new String[]{"pagode", "1 verso", "letra original", "praia de iracema"}, new String[]{}, new String[]{}),
    DESCOLADINHO("Descoladinho", true, "19/06/2024 - 02:43", 0, 37, 0, new String[]{"pagode", "jovem din�mico", "bruno", "letra original"}, new String[]{}, new String[]{}),
    DESTROY_EVERYTHING("Destroy Everything", true, "26/01/2025 - 22:11", 2, 59, 3, new String[]{"piano", "instrumental"}, new String[]{}, new String[]{}),
    DIX_TRACK_DETRAN("Dix Track Detran", true, "04/07/2024 - 12:03", 0, 46, 1, new String[]{"rock", "1 verso", "expl�cita", "letra original"}, new String[]{}, new String[]{"Dix Track Detran (Vers�o Piseiro 1)", "Dix Track Detran (Vers�o Piseiro 2)"}),
    DIX_TRACK_DETRAN_VERSAO_PISEIRO("Dix Track Detran (Vers�o Piseiro)", true, "29/09/2024 - 23:50", 1, 42, 0, new String[]{"forr� piseiro", "1 verso", "expl�cita", "letra original"}, new String[]{}, new String[]{}),
    DOIDAO("Doid�o", true, "22/10/2024 - 23:09", 1, 52, 10, new String[]{"reggae", "letra original", "mariaum", "rima"}, new String[]{}, new String[]{}),
    ENGRACADINHO("Engra�adinho", true, "25/06/2024 - 02:55", 0, 42, 1, new String[]{"pagode", "jovem din�mico", "letra original", "escatol�gica"}, new String[]{"Engra�adinho (Vers�o Alternativa)", "Engra�adinho (Vers�o Funk)", "Engra�adinho (Vers�o Metal)", "Engra�adinho (Vers�o Piseiro)", "Engra�adinho (Vers�o Pop)", "Engra�adinho (Vers�o Arrocha)", "Engra�adinho (Vers�o Brega)"}, new String[]{"Engra�adinho (Vers�o Metal 1)", "Engra�adinho (Vers�o Metal 2)", "Engra�adinho (Vers�o Metal 3)", "Engra�adinho (Vers�o Piseiro 1)", "Engra�adinho (Vers�o Arrocha 1)", "Engra�adinho (Vers�o Brega 1)"}),
    ENGRACADAO("ENGRA�AD�O", true, "25/09/2024 - 14:44", 1, 37, 19, new String[]{"metal", "expl�cita", "refer�ncia externa", "escatol�gica"}, new String[]{"ENGRA�AD�O (Vers�o Pop)", "ENGRA�AD�O (Vers�o Reggae)", "ENGRA�AD�O (Vers�o �pica)", "ENGRA�AD�O (Vers�o Arrocha)"}, new String[]{"ENGRA�AD�O (Vers�o �pica 1)", "ENGRA�AD�O (Remastered 1)", "ENGRA�AD�O (Vers�o Arrocha 1)"}),
    ENGRACADAO_VERSAO_PISEIRO("ENGRA�AD�O (Vers�o Piseiro)", true, "25/09/2024 - 15:00", 1, 38, 0, new String[]{"forr� piseiro", "expl�cita", "refer�ncia externa", "escatol�gica"}, new String[]{}, new String[]{"ENGRA�AD�O (Vers�o Piseiro) (Remastered 1)", "ENGRA�AD�O (Vers�o Piseiro) (Remastered 2)"}),
    ENTRADA_SEVERA("Entrada Severa", true, "09/05/2025 - 20:03", 3, 2, 1, new String[]{"metal", "severo", "discord", "letra original", "1 verso"}, new String[]{"Entrada Severa (Vers�o Pop)"}, new String[]{"Entrada Severa (Vers�o Pop 1)"}),
    FELICIDADE("Felicidade", true, "22/02/2025 - 16:23", 2, 79, 1, new String[]{"reggae", "letra original"}, new String[]{}, new String[]{}),
    GALOPA_PRO_KINDOME("Galopa pro Kindome", true, "09/05/2025 - 21:09", 3, 3, 1, new String[]{"forr� piseiro", "mariaum", "kindome", "letra ia"}, new String[]{}, new String[]{}),
    GOSTO_DE_COCO("Gosto de Coc�", true, "16/11/2024 - 14:05", 1, 69, 9, new String[]{"8 bit", "jovem din�mico", "1 verso", "letra original", "escatol�gica"}, new String[]{}, new String[]{}),
    HACKINGS("Hackings", true, "29/08/2024 - 01:33", 1, 10, 2, new String[]{"metal", "v�deo do canal", "expl�cita"}, new String[]{"Hackings (Vers�o Piseiro)"}, new String[]{"Hackings (Vers�o Piseiro 1)"}),
    HA_UM_POTO("H� Um Pot�", true, "27/04/2024 - 01:26", 0, 7, 3, new String[]{"sertanejo", "v�deo do canal"}, new String[]{}, new String[]{}),
    IMBATIVEL_MATHEUS("Imbat�vel Matheus", true, "15/09/2024 - 12:29", 1, 28, 3, new String[]{"rock", "letra ia", "matheus", "jo�o breno"}, new String[]{}, new String[]{}),
    INTROBASE64("IntroBase64", true, "09/06/2024 - 06:39", 0, 29, 2, new String[]{"�pica", "introbase64", "letra original", "v�deo do canal", "meel"}, new String[]{"IntroBase64 (Vers�o Metal)", "IntroBase64 (Vers�o Arrocha)"}, new String[]{"IntroBase64 (Vers�o Metal 1)", "IntroBase64 (Vers�o Metal 2)", "IntroBase64 (Vers�o Metal 3)", "IntroBase64 (Vers�o Metal 4)", "IntroBase64 (Vers�o Arrocha 1)"}),
    INVOCACOES("Invoca��es", true, "08/06/2024 - 18:30", 0, 28, 0, new String[]{"rock", "jovem din�mico", "letra original"}, new String[]{}, new String[]{}),
    JOGOS_DO_MUSH("Jogos do Mush", true, "24/04/2024 - 12:46", 0, 1, 3, new String[]{"udio", "letra ia", "mariaum"}, new String[]{"Jogos do Mush (Vers�o Mariaum)"}, new String[]{"Jogos do Mush (Vers�o Mariaum 1)"}),
    JOVEM_DINAMICO("Jovem Din�mico", true, "27/04/2024 - 01:14", 0, 6, 9, new String[]{"rock", "jovem din�mico", "letra original", "escatol�gica"}, new String[]{}, new String[]{}),
    JUBARACACHUBA("Jubaracachuba", true, "20/06/2024 - 20:59", 0, 41, 3, new String[]{"metal", "letra original"}, new String[]{"Jubaracachuba (Vers�o Alternativa)"}, new String[]{"Jubaracachuba (Vers�o Alternativa 1)"}),
    JUNIOR_CHATO("Junior Chato", true, "19/06/2024 - 03:07", 0, 38, 0, new String[]{"reggae", "cd antigo"}, new String[]{}, new String[]{}),
    KINDOME("Kindome", true, "31/08/2024 - 04:03", 1, 13, 3, new String[]{"vocaloid", "kindome", "letra ia"}, new String[]{}, new String[]{}),
    KIRITO_O_BODE("Kirito o Bode", true, "11/02/2025 - 00:58", 2, 72, 3, new String[]{"jazz", "kirito", "safira", "bruno", "letra ia"}, new String[]{"Kirito o Bode (Vers�o Kirito)", "Kirito o Bode (Vers�o Mariaum)", "Kirito o Bode (Vers�o Arrocha)", "Kirito o Bode (Vers�o Metal)", "Kirito o Bode (Vers�o Vocaloid)"}, new String[]{"Kirito o Bode (Vers�o Arrocha 1)", "Kirito o Bode (Vers�o Metal 1)", "Kirito o Bode (Vers�o Vocaloid 1)"}),
    LAGA_LAMA("Laga Lama", true, "26/04/2024 - 13:59", 0, 5, 3, new String[]{"rock", "letra original", "escatol�gica", "expl�cita"}, new String[]{}, new String[]{}),
    LORENA("Lorena", true, "30/12/2024 - 18:01", 2, 29, 4, new String[]{"evang�lica", "lorena", "letra original", "praia de iracema"}, new String[]{"Lorena (Vers�o Eletr�nica)", "Lorena (Vers�o Funk)", "Lorena (Vers�o Opera)", "Lorena (Vers�o Piseiro)", "Lorena (Vers�o Rap)", "Lorena (Vers�o Reggae)", "Lorena (Vers�o Terror)", "Lorena (Vers�o Arrocha)"}, new String[]{"Lorena (Vers�o Arrocha 1)"}),
    MARIAUM_E_JAPONESA("Mariaum e Japonesa", true, "03/01/2025 - 14:51", 2, 46, 1, new String[]{"sertanejo", "mariaum", "letra ia"}, new String[]{"Mariaum e Japonesa (Vers�o Mariaum)", "Mariaum e Japonesa (Vers�o Funk)", "Mariaum e Japonesa (Vers�o K-Pop)", "Mariaum e Japonesa (Vers�o Metal)", "Mariaum e Japonesa (Vers�o Piano)", "Mariaum e Japonesa (Vers�o Reggae)", "Mariaum e Japonesa (Vers�o Salsa)"}, new String[]{"Mariaum e Japonesa (Vers�o K-Pop 1)", "Mariaum e Japonesa (Vers�o Metal 1)", "Mariaum e Japonesa (Vers�o Metal 2)", "Mariaum e Japonesa (Vers�o Piano 1)", "Mariaum e Japonesa (Vers�o Salsa 1)"}),
    MELO_DO_INTRO("Melo do Intro", true, "09/06/2025 - 06:47", 3, 12, 2, new String[]{"brega", "bruno", "piada interna", "letra par�dia"}, new String[]{}, new String[]{}),
    MENININHOS_ENGRACADINHOS("Menininhos Engra�adinhos", true, "18/06/2024 - 08:09", 0, 32, 3, new String[]{"pop", "jovem din�mico", "letra original", "escatol�gica"}, new String[]{"Menininhos Engra�adinhos (Vers�o Alternativa)", "Menininhos Engra�adinhos (Vers�o Piano)", "Menininhos Engra�adinhos (Vers�o Piseiro)"}, new String[]{}),
    MENININHOS_ENGRACADINHOS_VERSAO_METAL("Menininhos Engra�adinhos (Vers�o Metal)", true, "19/09/2024 - 10:45", 1, 30, 0, new String[]{"metal", "jovem din�mico", "letra original", "escatol�gica"}, new String[]{}, new String[]{"Menininhos Engra�adinhos (Vers�o Metal 1)"}),
    MINEPARTY("MineParty", true, "19/06/2024 - 03:53", 0, 40, 3, new String[]{"rock", "kindome", "serj�o", "letra original"}, new String[]{}, new String[]{}),
    MUITO_PESADO("Muito Pesado", true, "09/07/2024 - 14:16", 0, 55, 0, new String[]{"dubstep", "letra original", "piada interna"}, new String[]{}, new String[]{}),
    MUSICA_EMPOLGANTE_E_IRRITANTE("M�sica Empolgante e Irritante", true, "25/07/2024 - 19:01", 0, 82, 1, new String[]{"pop", "roberta", "piada interna"}, new String[]{}, new String[]{}),
    NAO_PODE_BEBER("N�o Pode Beber", true, "29/12/2024 - 19:34", 2, 23, 1, new String[]{"reggae", "letra original", "escatol�gica"}, new String[]{}, new String[]{}),
    NOSSO_DJ("Nosso DJ", true, "19/06/2024 - 03:14", 0, 39, 1, new String[]{"dubstep", "cd antigo"}, new String[]{}, new String[]{}),
    OBSESSOR_DEVORADOR("Obsessor Devorador", true, "06/10/2024 - 15:07", 1, 45, 5, new String[]{"rock", "jovem din�mico", "letra original", "escatol�gica"}, new String[]{"Obsessor Devorador (Vers�o Arrocha)", "Obsessor Devorador (Vers�o Piseiro)"}, new String[]{"Obsessor Devorador (Vers�o Piseiro 1)"}),
    OLD_BURNING_LOVE("Old Burning Love", true, "18/02/2025 - 14:58", 2, 76, 6, new String[]{"metal", "instrumental", "safira"}, new String[]{"Old Burning Love (Vers�o Arrocha)", "Old Burning Love (Vers�o Piano)"}, new String[]{"Old Burning Love (Vers�o Arrocha 1)", "Old Burning Love (Vers�o Piano 1)"}),
    ONI_CHAN("Oni Chan", true, "03/01/2025 - 14:34", 2, 45, 1, new String[]{"vocaloid", "refer�ncia externa", "safira"}, new String[]{}, new String[]{}),
    OPRESSOR_DEPRECIADOR("Opressor Depreciador", true, "06/08/2025 - 03:53", 3, 20, 6, new String[]{"metal", "jovem din�mico", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    PARABENS_GABRIEL("Parab�ns Gabriel", true, "03/06/2025 - 22:19", 3, 7, 2, new String[]{"arrocha", "gabriel", "bruno", "eduarda", "letra original", "parab�ns"}, new String[]{"Parab�ns Gabriel (Vers�o Censurada)"}, new String[]{}),
    PATINETE_ELETRICO("Patinete El�trico", true, "19/06/2024 - 02:08", 0, 36, 5, new String[]{"rock", "letra original", "praia de iracema"}, new String[]{"Patinete El�trico (Vers�o Arrocha)", "Patinete El�trico (Vers�o Funk)", "Patinete El�trico (Vers�o Romantica)", "Patinete El�trico (Vers�o Alternativa)"}, new String[]{}),
    PATINETE_ELETRICO_VERSAO_PISEIRO("Patinete El�trico (Vers�o Piseiro)", true, "27/09/2024 - 04:25", 1, 40, 0, new String[]{"forr� piseiro", "letra original", "praia de iracema"}, new String[]{}, new String[]{"Patinete El�trico (Vers�o Piseiro 1)", "Patinete El�trico (Vers�o Piseiro 2)"}),
    PRIMEIRO_DE_ABRIL("Primeiro de Abril", true, "13/03/2025 - 03:53", 2, 87, 3, new String[]{"sertanejo", "mariaum", "letra ia"}, new String[]{"Primeiro de Abril (Vers�o Mariaum)", "Primeiro de Abril (Vers�o Metal)", "Primeiro de Abril (Vers�o Reggae)"}, new String[]{"Primeiro de Abril (Vers�o Metal 1)"}),
    RAFAEL_AULER_3_5("Rafael Auler 3.5", true, "07/06/2024 - 22:39", 0, 27, 0, new String[]{"rock", "rafael auler", "letra original", "piada interna"}, new String[]{"Rafael Auler 3.5 (Vers�o Reggae)", "Rafael Auler 3.5 (Vers�o Metal)", "Rafael Auler 3.5 (Vers�o Alternativa)", "Rafael Auler 3.5 (Vers�o Eletr�nica)", "Rafael Auler 3.5 (Vers�o Pagode)", "Rafael Auler 3.5 (Vers�o Piano)", "Rafael Auler 3.5 (Vers�o Piseiro)", "Rafael Auler 3.5 (Vers�o Pop)", "Rafael Auler 3.5 (Vers�o Funk)", "Rafael Auler 3.5 (Vers�o Viol�o)", "Rafael Auler 3.5 (Vers�o Vegas)", "Rafael Auler 3.5 (Vers�o Miami)", "Rafael Auler 3.5 (Vers�o Evang�lica)", "Rafael Auler 3.5 (Vers�o Seresta)", "Rafael Auler 3.5 (Vers�o Sofr�ncia)", "Rafael Auler 3.5 (Vers�o �pica)", "Rafael Auler 3.5 (Vers�o Rafael)"}, new String[]{"Rafael Auler 3.5 (Vers�o Pagode 1)", "Rafael Auler 3.5 (Vers�o Piano 1)", "Rafael Auler 3.5 (Vers�o Piseiro 1)", "Rafael Auler 3.5 (Vers�o Metal 1)"}),
    REI_DO_CEBOLITOS("Rei do Cebolitos", true, "03/05/2025 - 16:19", 3, 1, 1, new String[]{"sertanejo", "gabriel", "letra original"}, new String[]{}, new String[]{}),
    RITUAL_DAS_GATINHAS("Ritual das Gatinhas", true, "13/06/2024 - 06:33", 0, 30, 1, new String[]{"rock", "gatinhas", "letra original"}, new String[]{"Ritual das Gatinhas (Vers�o Piseiro)"}, new String[]{"Ritual das Gatinhas (Vers�o Piseiro 1)"}),
    SANIDADE_MENTAL("Sanidade Mental", true, "27/09/2024 - 05:42", 1, 41, 15, new String[]{"metal", "expl�cita", "letra original", "desabafo", "eduarda", "safira", "rafael", "kindome"}, new String[]{"Sanidade Mental (Vers�o Piseiro)", "Sanidade Mental (Vers�o Seresta)"}, new String[]{}),
    SARAIVA("Saraiva", true, "09/02/2025 - 15:05", 2, 68, 11, new String[]{"forr� piseiro", "saraiva", "luciano", "letra original"}, new String[]{"Saraiva (Vers�o Reggae)", "Saraiva (Vers�o Rock)", "Saraiva (Vers�o Metal)", "Saraiva (Vers�o Piano)", "Saraiva (Vers�o Arrocha)", "Saraiva (Vers�o Salsa)", "Saraiva (Vers�o Jazz)"}, new String[]{"Saraiva (Vers�o Rock 1)", "Saraiva (Vers�o Reggae 1)", "Saraiva (Vers�o Metal 1)", "Saraiva (Vers�o Arrocha 1)", "Saraiva (Vers�o Salsa 1)", "Saraiva (Vers�o Jazz 1)"}),
    SOFREDOR("Sofredor", true, "28/08/2024 - 23:02", 1, 9, 8, new String[]{"evang�lica", "jovem din�mico", "letra original"}, new String[]{}, new String[]{}),
    SONO_DO_MARIAUM("Sono do Mariaum", true, "05/02/2025 - 03:28", 2, 65, 1, new String[]{"sono", "mariaum", "letra original"}, new String[]{"Sono do Mariaum (Vers�o Mariaum)"}, new String[]{}),
    SR_DUVIDA("Sr D�vida", true, "29/07/2024 - 06:44", 0, 85, 3, new String[]{"metal", "desabafo", "expl�cita", "letra original", "eduarda"}, new String[]{"Sr D�vida (Vers�o Piseiro)"}, new String[]{"Sr D�vida (Vers�o Piseiro 1)", "Sr D�vida (Vers�o Piseiro 2)"}),
    STAND_UP_DO_DIEGO("Stand UP do Diego", true, "04/09/2024 - 17:14", 1, 18, 2, new String[]{"pop", "letra original", "diegosvp"}, new String[]{}, new String[]{}),
    STILL_WATER("Still Water", true, "01/11/2024 - 01:50", 1, 57, 1, new String[]{"piano", "instrumental", "refer�ncia externa"}, new String[]{"Still Water (Vers�o Salsa)", "Still Water (Vers�o Arrocha)", "Still Water (Vers�o Reggae)", "Still Water (Vers�o Metal)"}, new String[]{"Still Water (Vers�o Salsa 1)", "Still Water (Vers�o Arrocha 1)", "Still Water (Vers�o Arrocha 2)", "Still Water (Vers�o Arrocha 3)", "Still Water (Vers�o Reggae 1)", "Still Water (Vers�o Metal 1)", "Still Water (Vers�o Metal 2)", "Still Water (Vers�o Metal 3)", "Still Water (Remastered 1)", "Still Water (Remastered 2)", "Still Water (Remastered 3)"}),
    THE_IMPOSSIBLE("The Impossible", true, "15/02/2025 - 04:35", 2, 74, 5, new String[]{"piano", "instrumental", "kindome"}, new String[]{"The Impossible (Vers�o Orquestra)", "The Impossible (Vers�o Reggae)", "The Impossible (Vers�o Piseiro)", "The Impossible (Vers�o Patriota)", "The Impossible (Vers�o Funk)", "The Impossible (Vers�o Pop)"}, new String[]{"The Impossible (Vers�o �pica 1)", "The Impossible (Vers�o �pica 2)", "The Impossible (Vers�o Orquestra 1)", "The Impossible (Vers�o Piseiro 1)", "The Impossible (Vers�o Funk 1)", "The Impossible (Remastered 1)", "The Impossible (Remastered 2)"}),
    THE_IMPOSSIBLE_VERSAO_METAL("The Impossible (Vers�o Metal)", true, "18/02/2025 - 12:30", 2, 75, 0, new String[]{"metal", "instrumental", "kindome"}, new String[]{}, new String[]{"The Impossible (Vers�o Metal 1)", "The Impossible (Vers�o Metal 2)", "The Impossible (Vers�o Metal 3)", "The Impossible (Vers�o Metal 4)", "The Impossible (Vers�o Metal 5)", "The Impossible (Vers�o Metal 6)"}),
    TORNEIO_DE_YOUTUBERS("Torneio de YouTubers", true, "27/06/2025 - 17:48", 3, 17, 1, new String[]{"�pica", "instrumental", "kindome"}, new String[]{"Torneio de YouTubers (Vers�o Metal)", "Torneio de YouTubers (Vers�o Arrocha)", "Torneio de YouTubers (Vers�o Reggae)", "Torneio de YouTubers (Vers�o Salsa)"}, new String[]{"Torneio de YouTubers (Vers�o Metal 1)", "Torneio de YouTubers (Vers�o Arrocha 1)", "Torneio de YouTubers (Vers�o Reggae 1)", "Torneio de YouTubers (Vers�o Salsa 1)"}),
    TRANSMISSAO_ESTATICA("Transmiss�o Est�tica", true, "06/06/2024 - 13:40", 0, 25, 1, new String[]{"metal", "letra ia"}, new String[]{}, new String[]{}),
    TRES_PATINHOS("Tr�s Patinhos", true, "08/01/2025 - 17:37", 2, 48, 5, new String[]{"infantil", "expl�cita", "refer�ncia externa"}, new String[]{}, new String[]{}),
    TUBARAO("Tubar�o", true, "18/12/2024 - 16:08", 2, 11, 3, new String[]{"arrocha", "expl�cita", "letra original"}, new String[]{}, new String[]{}),
    VOCE_FEZ_COCO("Voc� fez coc�", true, "26/04/2024 - 01:46", 0, 4, 3, new String[]{"rock", "cd antigo", "expl�cita", "escatol�gica"}, new String[]{}, new String[]{}),

    // IA
    _8_BIT_PIANO("8 Bit Piano", false, "13/11/2024 - 21:49", 1, 65, 4, new String[]{"8 bit", "instrumental", "refer�ncia externa"}, new String[]{}, new String[]{}),
    A_PRAIA_E_O_COCO("A Praia e o Coco", false, "16/07/2024 - 10:39", 0, 65, 1, new String[]{"pop", "eduarda", "praia de iracema", "escatol�gica", "letra ia"}, new String[]{}, new String[]{}),
    A_PROPOSTA("A Proposta", false, "23/05/2025 - 00:20", 3, 5, 3, new String[]{"forr� piseiro", "mariaum", "letra original"}, new String[]{}, new String[]{}),
    A_SOPA_CHEGOU("A Sopa Chegou", false, "08/09/2024 - 17:06", 1, 26, 1, new String[]{"pop", "eduarda", "lucas moreira", "letra ia"}, new String[]{}, new String[]{}),
    A_VIAGEM_PRA_BENFICA("A Viagem pra Benfica", false, "23/11/2024 - 19:43", 2, 3, 1, new String[]{"sertanejo", "eduarda", "mariana", "greice", "letra ia"}, new String[]{}, new String[]{}),
    ACORDA_E_LUNCH("Acorda e Lunch", false, "29/06/2024 - 13:02", 0, 43, 1, new String[]{"pop", "lenon", "bruno", "letra ia"}, new String[]{}, new String[]{}),
    ACORDA_GABRIEL("Acorda Gabriel", false, "04/08/2024 - 18:36", 1, 4, 1, new String[]{"rock", "eduarda", "gabriel", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    ADALGESIO_NO_ROLE("Adalg�sio no Rol�", false, "19/07/2024 - 20:55", 0, 75, 1, new String[]{"sertanejo", "adalg�sio", "lenon", "letra ia"}, new String[]{}, new String[]{}),
    AGUA_DE_COCO_DA_EDUARDA("�gua de Coco da Eduarda", false, "01/12/2024 - 04:35", 2, 6, 1, new String[]{"sertanejo", "eduarda", "bruno", "lucas moreira", "letra original", "praia de iracema"}, new String[]{}, new String[]{}),
    ALEATERIO_NA_RUA("Aleat�rio na Rua", false, "05/07/2024 - 18:27", 0, 54, 1, new String[]{"metal", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    ALFABETO("Alfabeto", false, "31/08/2024 - 04:25", 1, 14, 1, new String[]{"evang�lica"}, new String[]{}, new String[]{}),
    ALMOCO_NO_APARTAMENTO("Almo�o no Apartamento", false, "29/12/2024 - 14:00", 2, 18, 1, new String[]{"sertanejo", "bruno", "eduarda", "lucas moreira", "gabriel", "tia fofa", "letra original", "praia de iracema"}, new String[]{}, new String[]{}),
    AMIGO_VEM_DORMIR_COMIGO("Amigo Vem Dormir Comigo", false, "23/09/2024 - 02:12", 1, 36, 1, new String[]{"sertanejo", "expl�cita", "cd antigo", "bruno"}, new String[]{}, new String[]{}),
    AMOR_DE_JOGO("Amor de Jogo", false, "16/11/2024 - 00:50", 1, 68, 1, new String[]{"piano", "pop", "seis", "prist", "kindome", "letra ia"}, new String[]{}, new String[]{}),
    ANIVERSARIO_DA_SAFIRA("Anivers�rio da Safira", false, "17/08/2024 - 12:58", 1, 7, 11, new String[]{"pop", "safira"}, new String[]{}, new String[]{}),
    AMOR_DESVELADO("Amor Desvelado", false, "31/05/2024 - 05:25", 0, 21, 0, new String[]{"pop", "expl�cita", "safira", "rafael", "bruno", "letra ia"}, new String[]{}, new String[]{}),
    ANO_NOVO_EM_IRACEMA("Ano Novo em Iracema", false, "30/12/2024 - 16:25", 2, 26, 3, new String[]{"sertanejo", "eduarda", "bruno", "lucas moreira", "gabriel", "tia fofa", "luciene", "letra ia", "praia de iracema"}, new String[]{}, new String[]{}),
    ARROCHA_DA_ANA("Arrocha da Ana", false, "08/03/2025 - 20:02", 2, 85, 3, new String[]{"arrocha", "ana", "bruno", "safira", "seis", "prist", "letra original"}, new String[]{}, new String[]{}),
    ARROCHA_DO_GABRIEL("Arrocha do Gabriel", false, "31/12/2024 - 19:40", 2, 33, 1, new String[]{"arrocha", "eduarda", "lucas moreira", "gabriel", "letra original"}, new String[]{"Arrocha do Gabriel (Vers�o Reggae)"}, new String[]{"Arrocha do Gabriel (Vers�o Reggae 1)"}),
    ATENCAO_GABRIEL("Aten��o Gabriel", false, "29/12/2024 - 11:41", 2, 15, 1, new String[]{"sertanejo", "gabriel"}, new String[]{}, new String[]{}),
    AUDIO_WHATSAPP("�udio WhatsApp", false, "31/08/2024 - 06:06", 1, 16, 3, new String[]{"mensagem", "eduarda"}, new String[]{}, new String[]{}),
    AVENTURA_NA_PRAIA_DE_IRACEMA("Aventura na Praia de Iracema", false, "29/12/2024 - 20:51", 2, 24, 1, new String[]{"sertanejo", "eduarda", "bruno", "gabriel", "tia fofa", "praia de iracema", "letra ia"}, new String[]{}, new String[]{}),
    AVISO_PARA_EDUARDA("Aviso para Eduarda", false, "07/09/2024 - 13:24", 1, 23, 1, new String[]{"pagode", "bruno", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    BANHO_DA_EDUARDA("Banho da Eduarda", false, "23/10/2024 - 13:30", 1, 53, 3, new String[]{"dubstep", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    BEDWARS_ENTRE_4_JOGADORES("BedWars Entre 4 Jogadores", false, "16/11/2024 - 00:39", 1, 67, 1, new String[]{"piano", "seis", "prist", "bruno", "ivan", "letra original"}, new String[]{}, new String[]{}),
    BLUSA_AMARELA("Blusa Amarela", false, "16/07/2024 - 16:52", 0, 67, 1, new String[]{"udio", "pagode", "roberta", "maria lucia", "maria julia", "letra original"}, new String[]{}, new String[]{}),
    BODE("Bode", false, "25/07/2024 - 22:46", 0, 83, 0, new String[]{"pop", "kirito"}, new String[]{}, new String[]{}),
    BOM_DIA_A_TODOS("Bom Dia a Todos", false, "31/12/2024 - 12:34", 2, 31, 1, new String[]{"reggae", "bruno", "eduarda", "lucas moreira", "gabriel", "tia fofa", "luciene", "praia de iracema", "letra original"}, new String[]{}, new String[]{}),
    BOOMBOX_CAIR("Boombox Cair", false, "17/07/2024 - 00:40", 0, 70, 1, new String[]{"calypso", "praia de iracema", "letra ia"}, new String[]{}, new String[]{}),
    BOTA_PRA_DANCAR("Bota pra Dan�ar", false, "27/12/2024 - 01:27", 2, 12, 0, new String[]{"pop", "letra ia", "lenon"}, new String[]{}, new String[]{}),
    CACHORRO_QUENTE("Cachorro Quente", false, "05/09/2024 - 20:05", 1, 20, 3, new String[]{"mensagem", "safira"}, new String[]{}, new String[]{}),
    CADE_VOCE_EDUARDA("Cad� Voc� Eduarda", false, "30/12/2024 - 18:26", 2, 30, 1, new String[]{"sertanejo", "eduarda", "lucas moreira", "bruno", "praia de iracema"}, new String[]{}, new String[]{}),
    CALA_BOCA("CALA BOCA", false, "19/01/2025 - 17:05", 2, 56, 3, new String[]{"pop", "eduarda", "lucas moreira", "gabriel", "tia fofa", "letra original"}, new String[]{}, new String[]{}),
    CALMA_GABRIEL("Calma Gabriel", false, "30/12/2024 - 16:54", 2, 27, 1, new String[]{"reggae", "gabriel", "letra original"}, new String[]{}, new String[]{}),
    CENAS("Cenas", false, "29/10/2024 - 00:53", 1, 56, 3, new String[]{"rock", "letra ia"}, new String[]{}, new String[]{}),
    CHEGOU_O_REMEDIO("Chegou o Rem�dio", false, "02/01/2025 - 11:12", 2, 41, 1, new String[]{"pagode", "eduarda", "bruno", "letra original"}, new String[]{"Chegou o Rem�dio (Vers�o Reggae)", "Chegou o Rem�dio (Vers�o Arrocha)", "Chegou o Rem�dio (Vers�o Pop)", "Chegou o Rem�dio (Vers�o Metal)"}, new String[]{"Chegou o Rem�dio (Vers�o Reggae 1)", "Chegou o Rem�dio (Vers�o Arrocha 1)", "Chegou o Rem�dio (Vers�o Metal 1)"}),
    CHILL("Chill", false, "07/09/2024 - 08:27", 1, 22, 1, new String[]{"instrumental"}, new String[]{}, new String[]{}),
    CHUVINHA_AMIZADE("Chuvinha Amizade", false, "15/07/2024 - 13:23", 0, 64, 1, new String[]{"sertanejo", "letra ia", "bruno", "eduarda"}, new String[]{}, new String[]{}),
    COCO("Coc�", false, "22/09/2024 - 11:30", 1, 34, 1, new String[]{"forr� piseiro", "eduarda", "escatol�gica"}, new String[]{}, new String[]{}),
    COISAS_NO_APARTAMENTO("Coisas no Apartamento", false, "12/11/2024 - 10:28", 1, 60, 1, new String[]{"sertanejo", "fernando", "bruno", "fortaleza", "praia de iracema"}, new String[]{}, new String[]{}),
    COME_EDUARDA("Come Eduarda", false, "13/01/2025 - 10:36", 2, 53, 2, new String[]{"calypso", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    COMIDAS_GOSTOSINHAS("Comidas Gostosinhas", false, "04/07/2024 - 14:06", 0, 51, 1, new String[]{"rock", "letra original"}, new String[]{}, new String[]{}),
    CSGO("CSGO", false, "04/04/2025 - 05:04", 2, 89, 1, new String[]{"calypso", "mariaum", "v�deo do canal", "bruno"}, new String[]{}, new String[]{}),
    DEITADOS("Deitados", false, "04/08/2024 - 17:05", 1, 3, 1, new String[]{"piano", "gabriel", "lucas moreira", "bruno", "eduarda", "letra original", "praia de iracema"}, new String[]{"Deitados Sofredor (Vers�o Metal)"}, new String[]{"Deitados Sofredor (Vers�o Metal 1)", "Deitados Sofredor (Vers�o Metal 2)", "Deitados Sofredor (Vers�o Metal 3)"}),
    DESENHA_EDUARDA("Desenha, Eduarda", false, "17/07/2024 - 00:47", 0, 71, 1, new String[]{"pop", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    DESILUSAO_NO_FORRO("Desilus�o no Forr�", false, "19/07/2024 - 23:45", 0, 77, 3, new String[]{"forr� piseiro", "letra ia", "lenon"}, new String[]{}, new String[]{}),
    DESPERTAR_INCANSAVEL("Despertar Incansavel", false, "18/07/2024 - 19:25", 0, 74, 1, new String[]{"rock", "udio", "piada interna"}, new String[]{}, new String[]{}),
    DISPUTA_NO_MUSHMC("Disputa no MushMC", false, "08/11/2024 - 00:38", 1, 59, 1, new String[]{"dubstep", "mariaum", "refer�ncia externa"}, new String[]{}, new String[]{}),
    DIVERSAO_NO_MUSH("Divers�o no Mush", false, "24/04/2024 - 12:46", 0, 2, 0, new String[]{"pagode", "mariaum", "udio", "letra ia"}, new String[]{}, new String[]{}),
    DIARIO_DE_LUCAS("Di�rio de Lucas", false, "30/09/2024 - 17:20", 1, 43, 1, new String[]{"sertanejo", "lucas", "lenon", "bruno", "letra ia"}, new String[]{}, new String[]{}),
    DOCES_DE_JULIANA("Doces de Juliana", false, "29/05/2024 - 13:01", 0, 20, 1, new String[]{"pop", "juliana", "luciano", "bruno", "letra original"}, new String[]{}, new String[]{}),
    DOMINIOS_DIGITAIS("Dom�nios Digitais", false, "05/05/2024 - 01:55", 0, 10, 0, new String[]{"rock", "rafael auler", "mariaum", "udio", "piada interna"}, new String[]{}, new String[]{}),
    DONO_DO_PODER("Dono do Poder", false, "05/05/2024 - 01:58", 0, 11, 0, new String[]{"rock", "rafael auler", "mariaum", "udio", "piada interna"}, new String[]{}, new String[]{}),
    DOR_DE_BARRIGA("Dor de Barriga", false, "09/02/2025 - 16:24", 2, 69, 1, new String[]{"forr� piseiro", "jovem din�mico", "escatol�gica"}, new String[]{}, new String[]{}),
    EDUARDA_INSPIRADA("Eduarda Inspirada", false, "17/07/2024 - 01:17", 0, 73, 1, new String[]{"sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    EDUARDA_NA_FAVELA("Eduarda na Favela", false, "03/11/2024 - 00:50", 1, 58, 1, new String[]{"funk", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    EDUARDA("Eduarda", false, "13/06/2024 - 20:02", 0, 31, 1, new String[]{"rock", "letra ia", "eduarda"}, new String[]{"Eduarda (Vers�o Alternativa)", "Eduarda (Vers�o Forr�)", "Eduarda (Vers�o Infantil)", "Eduarda (Vers�o Pagode)", "Eduarda (Vers�o Piano Calmo)", "Eduarda (Vers�o Piano)", "Eduarda (Vers�o Reggae)", "Eduarda (Vers�o Espanhol)", "Eduarda (Vers�o Rock Cl�ssico)", "Eduarda (Vers�o Arrocha)"}, new String[]{"Eduarda (Vers�o Arrocha 1)", "Eduarda (Vers�o Alternativa 2)", "Eduarda (Vers�o Forr� 2)", "Eduarda (Vers�o Pagode 2)", "Eduarda (Vers�o Piano 1)", "Eduarda (Vers�o Piano 2)", "Eduarda (Vers�o Espanhol 1)"}),
    ELA_E_GATINHA("Ela � Gatinha", false, "15/06/2025 - 12:21", 3, 14, 1, new String[]{"arrocha", "eduarda", "letra original"}, new String[]{"Ela � Gatinha (Vers�o Brega)", "Ela � Gatinha (Vers�o Reggae)", "Ela � Gatinha (Vers�o Metal)"}, new String[]{"Ela � Gatinha (Vers�o Brega 1)", "Ela � Gatinha (Vers�o Reggae 1)", "Ela � Gatinha (Vers�o Metal 1)"}),
    ELE_E_O_GABRIEL("Ele � o Gabriel", false, "01/01/2025 - 14:55", 2, 37, 1, new String[]{"reggae", "gabriel", "letra original", "rima"}, new String[]{}, new String[]{}),
    ENVIANDO_O_KINDOME("Enviando o Kindome", false, "27/11/2024 - 22:20", 2, 4, 1, new String[]{"sertanejo", "kindome", "letra ia", "bruno", "mariaum"}, new String[]{}, new String[]{}),
    ESCOLHA_DA_BLUSA("Escolha da Blusa", false, "16/07/2024 - 16:52", 0, 68, 1, new String[]{"pop", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    ESCOVANDO_OS_DENTES("Escovando os Dentes", false, "02/01/2025 - 13:50", 2, 43, 1, new String[]{"calypso", "tia fofa", "praia de iracema"}, new String[]{}, new String[]{}),
    EU_TE_AMO_EDUARDA("Eu Te Amo Eduarda", false, "29/12/2024 - 13:09", 2, 17, 1, new String[]{"pagode", "eduarda"}, new String[]{}, new String[]{}),
    EX_DJS("Ex DJs", false, "08/09/2024 - 16:22", 1, 25, 1, new String[]{"dubstep", "eduarda", "bruno", "lucas moreira"}, new String[]{}, new String[]{}),
    FAYE("Faye", false, "02/01/2025 - 17:10", 2, 44, 1, new String[]{"pop", "letra ia", "mariana"}, new String[]{}, new String[]{}),
    FERNANDO_NO_APARTAMENTO("Fernando no Apartamento", false, "12/11/2024 - 10:28", 1, 61, 3, new String[]{"sertanejo", "fernando", "bruno", "praia de iracema", "letra original"}, new String[]{}, new String[]{}),
    FESTA_NO_ELEVADOR("Festa no Elevador", false, "18/06/2025 - 13:11", 3, 15, 9, new String[]{"arrocha", "bruno", "lucas", "jo�o breno", "letra original"}, new String[]{}, new String[]{}),
    FIOS_REBELDES("Fios Rebeldes", false, "01/05/2024 - 09:49", 0, 9, 0, new String[]{"rock", "letra ia", "udio", "roberta"}, new String[]{}, new String[]{}),
    FOGUETE_TRICOLOR("Foguete Tricolor", false, "29/08/2024 - 02:36", 1, 11, 7, new String[]{"rock", "letra ia", "fortaleza"}, new String[]{}, new String[]{}),
    FOME_DA_LORENA("Fome da Lorena", false, "31/12/2024 - 12:45", 2, 32, 1, new String[]{"sertanejo", "lorena", "praia de iracema", "letra original"}, new String[]{}, new String[]{}),
    FRASES_DE_EDUARDA("Frases de Eduarda", false, "17/07/2024 - 01:06", 0, 72, 1, new String[]{"sertanejo", "eduarda", "bruno", "praia de iracema", "letra original"}, new String[]{}, new String[]{}),
    FRASES_DE_LUCIVANIA("Frases de Lucivania", false, "01/01/2025 - 20:35", 2, 40, 1, new String[]{"evang�lica", "eduarda", "tia fofa", "bruno", "praia de iracema", "letra original"}, new String[]{}, new String[]{}),
    FRASES_NO_APARTAMENTO("Frases no Apartamento", false, "12/11/2024 - 10:28", 1, 62, 1, new String[]{"sertanejo", "lucas moreira", "gabriel", "bruno", "eduarda", "tia fofa", "lorena", "praia de iracema"}, new String[]{}, new String[]{}),
    GABRIEL_ESCOVANDO("Gabriel Escovando", false, "19/01/2025 - 11:10", 2, 55, 1, new String[]{"calypso", "gabriel", "letra original"}, new String[]{}, new String[]{}),
    GABRIEL_PARA_JABRIEL("Gabriel para Jabriel", false, "31/12/2024 - 20:10", 2, 34, 1, new String[]{"sertanejo", "gabriel", "letra original"}, new String[]{}, new String[]{}),
    GABRIEL("Gabriel", false, "29/12/2024 - 14:05", 2, 19, 1, new String[]{"sertanejo", "gabriel", "1 verso"}, new String[]{}, new String[]{}),
    GALERA_DO_MARIAUM("Galera do Mariaum", false, "15/02/2025 - 12:55", 2, 76, 0, new String[]{"funk", "mariaum", "refer�ncia externa"}, new String[]{"Galera do Mariaum (Vers�o Reggae)", "Galera do Mariaum (Vers�o Metal)", "Galera do Mariaum (Vers�o Alternativa)", "Galera do Mariaum (Vers�o Piseiro)"}, new String[]{"Galera do Mariaum (Vers�o Reggae 1)", "Galera do Mariaum (Vers�o Metal 1)", "Galera do Mariaum (Vers�o Piseiro 1)", "Galera do Mariaum (Vers�o Piseiro 2)", "Galera do Mariaum (Vers�o Piseiro 3)", "Galera do Mariaum (Vers�o Alternativa 1)"}),
    GAROTAS_PALHACO("Garotas Palha�o", false, "26/02/2025 - 23:18", 2, 82, 5, new String[]{"rock", "prist", "expl�cita", "refer�ncia externa"}, new String[]{}, new String[]{}),
    GIGANTES_DO_FORROZAO("Gigantes do Forroz�o", false, "07/05/2024 - 16:52", 0, 14, 1, new String[]{"rock", "udio", "luciano", "piada interna"}, new String[]{}, new String[]{}),
    GOSTOSINHO("Gostosinho", false, "19/07/2025 - 23:44", 3, 18, 4, new String[]{"salsa", "discord", "jaozn", "1 verso", "letra original"}, new String[]{}, new String[]{}),
    GRANDE_ENIGMA("Grande Enigma", false, "02/08/2024 - 17:49", 1, 1, 1, new String[]{"rock", "eduarda", "bruno", "letra original"}, new String[]{}, new String[]{}),
    HIPER_CINEMATIC("Hiper Cinematic", false, "04/07/2024 - 12:46", 0, 48, 1, new String[]{"�pica", "instrumental"}, new String[]{}, new String[]{}),
    HOMENAGEM_A_MINHA_VO("Homenagem a minha v�", false, "04/09/2024 - 17:45", 1, 19, 1, new String[]{"pop", "v� l�cia", "letra original", "letra par�dia", "v�deo do canal"}, new String[]{}, new String[]{}),
    HORROR_PIANO("Horror Piano", false, "04/06/2025 - 13:40", 3, 8, 1, new String[]{"piano", "instrumental", "eduarda"}, new String[]{}, new String[]{}),
    INTRO_NA_CHAMADA("Intro na Chamada", false, "20/11/2024 - 18:28", 2, 1, 15, new String[]{"forr� piseiro", "discord", "bruno", "1 verso", "letra original"}, new String[]{}, new String[]{}),
    IVR("IVR", false, "09/06/2025 - 23:23", 3, 13, 7, new String[]{"metal", "ivan", "rafael auler", "expl�cita"}, new String[]{}, new String[]{}),
    JAVA_CODING("Java Coding", false, "22/01/2025 - 22:00", 2, 57, 1, new String[]{"piano", "instrumental"}, new String[]{}, new String[]{}),
    JINGLE_DAS_GATINHAS("Jingle das Gatinhas", false, "19/06/2024 - 00:33", 0, 35, 0, new String[]{"voz", "gatinhas", "piada interna"}, new String[]{"Jingle das Gatinhas (Vers�o Metal)"}, new String[]{}),
    JOAO_BRENO_E_O_LEGO("Jo�o Breno e o Lego", false, "15/09/2024 - 12:29", 1, 29, 1, new String[]{"pop", "jo�o breno", "letra original", "expl�cita"}, new String[]{"Jo�o Breno e o Lego (Vers�o R&B)"}, new String[]{}),
    JOSE("Jos�", false, "22/02/2025 - 12:46", 2, 78, 1, new String[]{"sertanejo", "jos�", "praia de iracema", "letra original"}, new String[]{}, new String[]{}),
    KIRITO("Kirito", false, "31/08/2024 - 01:30", 1, 12, 1, new String[]{"funk", "kirito", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    LENON_NO_MICROFONE("Lenon no Microfone", false, "27/12/2024 - 01:30", 2, 13, 0, new String[]{"mensagem", "lenon"}, new String[]{}, new String[]{}),
    LINDA_EDUARDA("Linda Eduarda", false, "29/12/2024 - 22:11", 2, 25, 1, new String[]{"sertanejo", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    LIVE_DE_MINE("Live de Mine", false, "09/01/2025 - 19:30", 2, 50, 3, new String[]{"pop", "kindome", "refer�ncia externa"}, new String[]{}, new String[]{}),
    LOJA_PARA_HYAN("Loja para Hyan", false, "12/02/2025 - 19:45", 2, 73, 3, new String[]{"forr� piseiro", "plugins", "bruno", "letra original"}, new String[]{}, new String[]{}),
    LUCA_PROIBIDO("Luca Proibido", false, "02/02/2025 - 23:26", 2, 63, 1, new String[]{"funk", "lucas moreira", "bruno", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    LUCAS_DORMINHOCO("Lucas Dorminhoco", false, "08/09/2024 - 12:45", 1, 24, 5, new String[]{"sertanejo", "lucas moreira", "letra original"}, new String[]{}, new String[]{}),
    LUCAS_FAZENDO_COCO("Lucas Fazendo Coc�", false, "12/01/2025 - 02:53", 2, 52, 1, new String[]{"salsa", "lucas moreira", "letra original", "escatol�gica"}, new String[]{}, new String[]{}),
    LUCAS_NO_VOLANTE("Lucas no Volante", false, "11/05/2025 - 17:27", 3, 4, 5, new String[]{"metal", "lucas", "tamisa"}, new String[]{}, new String[]{}),
    LUCAS("Lucas", false, "30/12/2024 - 17:08", 2, 28, 1, new String[]{"funk", "lucas moreira", "letra original"}, new String[]{}, new String[]{}),
    LUCIVANIA("Lucivania", false, "01/01/2025 - 19:42", 2, 39, 1, new String[]{"calypso", "tia fofa", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    MAJOR_SABINO("Major Sabino", false, "22/08/2024 - 22:03", 1, 8, 6, new String[]{"forr� piseiro", "reginaldo", "letra original", "pol�tico"}, new String[]{"Major Sabino (Vers�o Gospel)", "Major Sabino (Vers�o Metal)"}, new String[]{"Major Sabino (Vers�o Gospel 1)", "Major Sabino (Vers�o Metal 1)", "Major Sabino (Vers�o Metal 2)", "Major Sabino (Vers�o Metal 3)"}),
    MANHA_DE_METAL("Manh� de Metal", false, "15/05/2024 - 08:58", 0, 16, 0, new String[]{"rock", "udio", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    MARIA_EDUARDA_NO_FORRO("Maria Eduarda No Forr�", false, "11/08/2024 - 18:51", 1, 6, 1, new String[]{"infantil", "maria eduarda barreto", "letra ia"}, new String[]{}, new String[]{}),
    MARIA_EDUARDA("Maria Eduarda", false, "09/02/2025 - 16:45", 2, 70, 1, new String[]{"sertanejo", "maria eduarda", "letra original"}, new String[]{}, new String[]{}),
    MARIAUM("Mariaum", false, "15/02/2025 - 12:48", 2, 75, 0, new String[]{"regional", "mariaum", "refer�ncia externa"}, new String[]{}, new String[]{}),
    MC_HARIEL_PARA_SAFIRA("MC Hariel para Safira", false, "18/05/2024 - 18:17", 0, 19, 1, new String[]{"funk", "udio", "safira", "letra ia"}, new String[]{}, new String[]{}),
    MCGPLAYS_PARA_VINICIUS("MCGPlays para Vinicius", false, "06/06/2024 - 09:26", 0, 24, 0, new String[]{"rock", "mcgplays", "refer�ncia externa", "expl�cita"}, new String[]{}, new String[]{}),
    MENSAGENS("Mensagens", false, "27/10/2024 - 04:54", 1, 55, 5, new String[]{"rock", "lenon", "bruno"}, new String[]{}, new String[]{}),
    MEU_SONHO_DO_DIA_2("Meu Sonho do Dia 2", false, "02/01/2025 - 11:19", 2, 42, 3, new String[]{"forr� piseiro", "reginaldo", "bruno", "adalg�sio", "letra original", "praia de iracema"}, new String[]{}, new String[]{}),
    MISSOES_PARA_HYAN("Miss�es para Hyan", false, "05/12/2024 - 20:20", 2, 8, 3, new String[]{"forr� piseiro", "plugins", "1 verso", "letra original"}, new String[]{}, new String[]{}),
    MOUNTAIN_PATH("Mountain Path", false, "06/06/2025 - 22:40", 3, 10, 1, new String[]{"piano", "instrumental", "refer�ncia externa"}, new String[]{"Mountain Path (Vers�o Metal)", "Mountain Path (Vers�o Arrocha)", "Mountain Path (Vers�o Piseiro)", "Mountain Path (Vers�o Espacial)", "Mountain Path (Vers�o Harpa)", "Mountain Path (Vers�o Violino)"}, new String[]{"Mountain Path (Vers�o Metal 1)", "Mountain Path (Vers�o Metal 2)", "Mountain Path (Vers�o Metal 3)", "Mountain Path (Vers�o Piseiro 1)", "Mountain Path (Vers�o Arrocha 1)", "Mountain Path (Vers�o Espacial 1)"}),
    MUSHMC("MushMC", false, "10/02/2025 - 19:11", 2, 71, 1, new String[]{"forr� piseiro", "mariaum"}, new String[]{}, new String[]{}),
    MUSICA_PARA_CAGAR("M�sica para Cagar", false, "04/07/2024 - 20:58", 0, 52, 5, new String[]{"piano", "escatol�gica", "letra ia"}, new String[]{}, new String[]{}),
    NAO_SABE_PULAR("N�o Sabe Pular", false, "24/02/2025 - 11:48", 2, 80, 7, new String[]{"forr� piseiro", "prist", "refer�ncia externa", "expl�cita"}, new String[]{}, new String[]{}),
    NATUREZA("Natureza", false, "21/10/2024 - 02:23", 1, 51, 7, new String[]{"pop", "bruno", "letra original", "v�deo do canal"}, new String[]{}, new String[]{}),
    NAYARA("Nayara", false, "22/07/2024 - 02:52", 0, 79, 1, new String[]{"piano", "nayara", "bruno"}, new String[]{"Nayara (Vers�o Arrocha)"}, new String[]{"Nayara (Vers�o Arrocha 1)"}),
    NOITE_PALIDA("Noite P�lida", false, "16/03/2025 - 06:37", 2, 88, 1, new String[]{"reggae", "refer�ncia externa"}, new String[]{}, new String[]{}),
    NOSSO_RELACIONAMENTO("Nosso Relacionamento", false, "14/11/2024 - 18:48", 1, 66, 1, new String[]{"rap", "safira", "refer�ncia externa"}, new String[]{}, new String[]{}),
    NOVOS_SERVIDORES("Novos Servidores", false, "09/04/2025 - 06:30", 2, 91, 1, new String[]{"pop", "mariaum", "bruno", "letra ia"}, new String[]{}, new String[]{}),
    O_AMOR_DE_EDUARDA_PELO_COCO("O Amor de Eduarda Pelo Coc�", false, "22/09/2024 - 11:33", 1, 35, 0, new String[]{"forr� piseiro", "eduarda", "letra ia", "escatol�gica"}, new String[]{}, new String[]{}),
    O_DONO_DO_SERVIDOR("O Dono do Servidor", false, "01/06/2024 - 19:54", 0, 22, 0, new String[]{"rock", "udio", "rafael auler", "mariaum", "letra ia"}, new String[]{}, new String[]{}),
    O_DUMP_DO_MYSQL("O Dump do MySQL", false, "14/05/2024 - 00:53", 0, 15, 2, new String[]{"funk", "letra ia", "udio"}, new String[]{}, new String[]{}),
    O_MARIAUM("O Mariaum", false, "20/10/2024 - 21:37", 1, 48, 1, new String[]{"forr� piseiro", "mariaum", "letra ia"}, new String[]{"O Mariaum (Vers�o Mariaum)"}, new String[]{}),
    OI_RAFAEL("Oi Rafael", false, "20/07/2025 - 14:47", 3, 19, 6, new String[]{"salsa", "rafael", "discord", "letra original"}, new String[]{}, new String[]{}),
    OLHANDO_PARA_O_LADO("Olhando para o Lado", false, "10/07/2024 - 17:29", 0, 57, 1, new String[]{"rock", "letra original"}, new String[]{}, new String[]{}),
    OURO_BRANCO_PARA_LUCAS("Ouro Branco para Lucas", false, "17/11/2024 - 07:42", 1, 70, 3, new String[]{"sertanejo", "lucas moreira"}, new String[]{}, new String[]{}),
    PALAVRAS_GUARDADAS("Palavras Guardadas", false, "30/06/2024 - 19:46", 0, 44, 1, new String[]{"piano", "desabafo", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    PANDA("Panda", false, "09/04/2025 - 05:16", 2, 90, 1, new String[]{"metal", "panda", "refer�ncia original", "expl�cita"}, new String[]{}, new String[]{}),
    PARABENS_ANA("Parab�ns Ana", false, "20/02/2025 - 01:10", 2, 77, 4, new String[]{"pop", "ana", "letra original"}, new String[]{"Parab�ns Ana (Vers�o Metal)"}, new String[]{"Parab�ns Ana (Vers�o Metal 1)"}),
    PARABENS_DE_KOS("Parab�ns de Kos", false, "06/03/2025 - 00:23", 2, 84, 1, new String[]{"forr� piseiro", "prist", "bruno", "parab�ns"}, new String[]{}, new String[]{}),
    PARABENS_KOS("Parab�ns Kos", false, "12/03/2025 - 16:42", 2, 86, 3, new String[]{"forr� piseiro", "parab�ns", "prist"}, new String[]{}, new String[]{}),
    PARABENS_MARIAUM("Parab�ns Mariaum", false, "11/10/2024 - 20:39", 1, 46, 3, new String[]{"rock", "parab�ns", "mariaum"}, new String[]{"Parab�ns Mariaum (Vers�o Mariaum)"}, new String[]{}),
    PEDIDO_DE_MASCARA("Pedido de M�scara", false, "11/07/2024 - 14:16", 0, 61, 3, new String[]{"sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    PERFEITA("Perfeita", false, "02/12/2024 - 23:48", 2, 7, 1, new String[]{"forr� piseiro", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    PESSOA_ACIMA("Pessoa Acima", false, "08/01/2025 - 17:47", 2, 49, 3, new String[]{"sertanejo", "refer�ncia externa", "expl�cita"}, new String[]{}, new String[]{}),
    PLUGIN_DE_REPORT("Plugin de Report", false, "23/10/2024 - 21:08", 1, 54, 0, new String[]{"sertanejo", "plugins", "letra original", "1 verso"}, new String[]{}, new String[]{}),
    POMBO("Pombo", false, "09/09/2024 - 18:26", 1, 27, 1, new String[]{"funk", "diegosvp", "jotah", "bruno", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    PORTUGUES("Portugu�s", false, "24/02/2025 - 15:13", 2, 81, 1, new String[]{"sertanejo", "letra original"}, new String[]{}, new String[]{}),
    PROCURA_DE_EMPREGO("Procura de Emprego", false, "01/07/2024 - 08:31", 0, 45, 1, new String[]{"rock", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    PROMESSA_DA_SULAMERICANA("Promessa da Sulamericana", false, "26/09/2024 - 19:13", 1, 39, 1, new String[]{"sertanejo", "jovem din�mico", "letra ia"}, new String[]{}, new String[]{}),
    PSYCHOPATH("Psychopath", false, "04/06/2025 - 13:49", 3, 9, 1, new String[]{"piano", "instrumental", "eduarda"}, new String[]{}, new String[]{}),
    PUDIM_E_TORTA_DE_FRANGO("Pudim e Torta de Frango", false, "31/07/2024 - 17:35", 0, 86, 1, new String[]{"pop", "eduarda", "bruno", "praia de iracema", "letra ia"}, new String[]{}, new String[]{}),
    PUTS_KINDOME("Puts Kindome", false, "16/04/2025 - 05:39", 2, 92, 3, new String[]{"metal", "snifpvp", "kindome", "refer�ncia externa"}, new String[]{}, new String[]{}),
    QUE_MARAVILHA("Que Maravilha", false, "15/05/2024 - 23:29", 0, 17, 1, new String[]{"pagode", "letra ia"}, new String[]{}, new String[]{}),
    RAIVA("Raiva", false, "08/02/2025 - 20:44", 2, 67, 5, new String[]{"metal", "expl�cita", "letra original"}, new String[]{}, new String[]{}),
    REABERTURA_DO_KINDOME("Reabertura do Kindome", false, "30/11/2024 - 13:08", 2, 5, 1, new String[]{"sertanejo", "kindome", "letra ia"}, new String[]{}, new String[]{}),
    REGISTRO_DE_FUTEBOL("Registro de Futebol", false, "09/07/2024 - 21:55", 0, 56, 1, new String[]{"rock", "letra ia"}, new String[]{}, new String[]{}),
    REINOS_DE_JOGO("Reinos de Jogo", false, "24/04/2024 - 12:57", 0, 3, 2, new String[]{"rock", "udio", "kindome", "letra ia"}, new String[]{}, new String[]{}),
    RITMO_INSOLENTE("Ritmo Insolente", false, "29/04/2024 - 16:01", 0, 8, 0, new String[]{"pagode", "udio", "letra ia"}, new String[]{}, new String[]{}),
    SAFIRA_VS_EDUARDA("Safira vs Eduarda", false, "23/07/2024 - 02:20", 0, 80, 9, new String[]{"�pica", "safira", "eduarda", "letra original", "expl�cita"}, new String[]{"Safira vs Eduarda (Vers�o Funk)", "Safira vs Eduarda (Vers�o Metal)", "Safira vs Eduarda (Vers�o Minimalista)", "Safira vs Eduarda (Vers�o Pagode)", "Safira vs Eduarda (Vers�o Piano)", "Safira vs Eduarda (Vers�o Reggae)", "Safira vs Eduarda (Vers�o Salsa)", "Safira vs Eduarda (Vers�o Pop)", "Safira vs Eduarda (Vers�o Arrocha)", "Safira vs Eduarda (Vers�o Alternativa)"}, new String[]{"Safira vs Eduarda (Vers�o Arrocha 1)", "Safira vs Eduarda (Vers�o Reggae 1)", "Safira vs Eduarda (Vers�o Salsa 1)", "Safira vs Eduarda (Vers�o Arrocha 2)", "Safira vs Eduarda (Vers�o Metal 1)", "Safira vs Eduarda (Vers�o Metal 2)", "Safira vs Eduarda (Vers�o Metal 3)", "Safira vs Eduarda (Vers�o Pagode 1)"}),
    SAFIRA("Safira", false, "03/01/2025 - 18:27", 2, 47, 2, new String[]{"rock", "safira", "letra original"}, new String[]{"Vers�o Curta"}, new String[]{}),
    SETE_NA_CHAMADA("Sete na Chamada", false, "06/12/2024 - 21:57", 2, 9, 3, new String[]{"rap", "kirito", "discord", "1 verso", "letra original"}, new String[]{"Sete na Chamada (Vers�o Metal)"}, new String[]{"Sete na Chamada (Vers�o Metal 1)"}),
    SHOW_DE_COMEDIA("Show de Com�dia", false, "31/08/2024 - 20:26", 1, 17, 2, new String[]{"voz", "com�dia"}, new String[]{}, new String[]{}),
    SKATE("Skate", false, "29/12/2024 - 16:18", 2, 22, 1, new String[]{"viol�o", "refer�ncia externa"}, new String[]{}, new String[]{}),
    SNIF("Snif", false, "23/04/2025 - 08:06", 2, 93, 1, new String[]{"metal", "snifpvp", "refer�ncia externa"}, new String[]{}, new String[]{}),
    SOLO_DE_GUITARRA_PISEIRO("Solo de Guitarra Piseiro", false, "27/12/2024 - 01:45", 2, 14, 1, new String[]{"rock", "instrumental"}, new String[]{}, new String[]{}),
    SOM_DO_SOL("Som do Sol", false, "07/06/2024 - 17:58", 0, 26, 0, new String[]{"sertanejo", "rafael auler", "mariaum", "udio", "piada interna"}, new String[]{}, new String[]{}),
    SONHOS_DIGITAIS("Sonhos Digitais", false, "03/06/2024 - 19:10", 0, 23, 0, new String[]{"pop", "mariaum", "udio"}, new String[]{}, new String[]{}),
    SONO_DA_EDUARDA("Sono da Eduarda", false, "28/01/2025 - 22:56", 2, 60, 4, new String[]{"sono", "eduarda", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    SONO_DO_GABRIEL("Sono do Gabriel", false, "19/01/2025 - 10:03", 2, 54, 6, new String[]{"sono", "gabriel", "letra original", "expl�cita"}, new String[]{}, new String[]{}),
    STAIRCASE("StairCase", false, "20/06/2025 - 17:57", 3, 16, 1, new String[]{"terror", "instrumental"}, new String[]{}, new String[]{}),
    STELLA_OVERTURE("Stella Overture", false, "15/07/2024 - 06:52", 0, 63, 1, new String[]{"�pica", "instrumental"}, new String[]{}, new String[]{}),
    SUVACO_CABELUDO("Suvaco Cabeludo", false, "18/05/2024 - 10:42", 0, 18, 0, new String[]{"rock", "udio", "1 verso", "letra original"}, new String[]{}, new String[]{}),
    TAVA_GOSTOSO("Tava Gostoso", false, "29/12/2024 - 14:29", 2, 21, 1, new String[]{"sertanejo", "gabriel", "letra original"}, new String[]{}, new String[]{}),
    TE_AMAR_DE_NOVO("Te Amar de Novo", false, "19/07/2024 - 21:00", 0, 76, 3, new String[]{"forr� piseiro", "adalg�sio", "letra original"}, new String[]{}, new String[]{}),
    TE_AMO_DEMAIS("Te Amo Demais", false, "11/08/2024 - 13:32", 1, 5, 7, new String[]{"brega", "reginaldo", "letra original"}, new String[]{}, new String[]{}),
    TESTE_DE_VOZ("Teste de voz", false, "31/08/2024 - 04:37", 1, 15, 1, new String[]{"voz"}, new String[]{}, new String[]{}),
    TEXTAO_EM_PIANO("Text�o em Piano", false, "10/07/2024 - 22:53", 0, 60, 1, new String[]{"piano", "desabafo", "eduarda"}, new String[]{}, new String[]{}),
    TEXTAO_EM_SERTANEJO("Text�o em Sertanejo", false, "10/07/2024 - 22:52", 0, 59, 1, new String[]{"sertanejo", "desabafo", "eduarda"}, new String[]{}, new String[]{}),
    THE_END("The End", false, "05/02/2025 - 01:29", 2, 64, 4, new String[]{"piano", "eduarda", "instrumental"}, new String[]{"The End (Vers�o Metal)"}, new String[]{}),
    TIA_FOFA("Tia Fofa", false, "29/12/2024 - 14:07", 2, 20, 1, new String[]{"sertanejo", "tia fofa", "eduarda", "lucas moreira", "gabriel", "praia de iracema"}, new String[]{}, new String[]{}),
    TODO_MUNDO("Todo Mundo", false, "04/07/2024 - 13:04", 0, 49, 1, new String[]{"regional", "instrumental"}, new String[]{}, new String[]{}),
    TODOS_NA_SALA("Todos na Sala", false, "01/01/2025 - 15:01", 2, 38, 1, new String[]{"reggae", "eduarda", "bruno", "lucas moreira", "gabriel", "lorena", "luciene", "tia fofa"}, new String[]{}, new String[]{}),
    TOMA_LUCAS("Toma Lucas", false, "01/01/2025 - 13:50", 2, 36, 1, new String[]{"calypso", "lucas moreira", "letra original"}, new String[]{}, new String[]{}),
    TRANQUIL_DREAMSCAPES("Tranquil Dreamscapes", false, "23/07/2024 - 17:19", 0, 81, 1, new String[]{"�pica", "instrumental"}, new String[]{}, new String[]{}),
    TROCA_DE_ROUPAS_NO_PORTO_DAS_DUNAS("Troca de Roupas no Porto das Dunas", false, "08/12/2024 - 04:20", 2, 10, 1, new String[]{"pagode", "eduarda", "praia de iracema"}, new String[]{}, new String[]{}),
    TUDO_BEM_GABRIEL("Tudo Bem Gabriel", false, "29/12/2024 - 12:25", 2, 16, 1, new String[]{"reggae", "gabriel", "letra original"}, new String[]{}, new String[]{}),
    ULTRA_POPULAR("Ultra Popular", false, "11/07/2024 - 14:16", 0, 62, 1, new String[]{"sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    UM_DIA_NA_PRAIA("Um Dia Na Praia", false, "20/07/2024 - 19:59", 0, 78, 1, new String[]{"sertanejo", "lenon", "alison", "bruno", "praia de iracema"}, new String[]{}, new String[]{}),
    UM_E_DOIS("Um e Dois", false, "28/07/2024 - 11:45", 0, 84, 0, new String[]{"rock", "cd antigo", "refer�ncia externa", "reginaldo"}, new String[]{}, new String[]{}),
    UMA_NOITE_EM_BENFICA("Uma Noite em Benfica", false, "23/11/2024 - 19:41", 2, 2, 1, new String[]{"pop", "eduarda", "bruno", "mariana", "greice", "letra ia"}, new String[]{}, new String[]{}),
    VAI_IGUATU("VAI IGUATU", false, "29/01/2025 - 21:10", 2, 61, 8, new String[]{"metal", "expl�cita", "futebol"}, new String[]{"VAI IGUATU (Vers�o Hino)"}, new String[]{"VAI IGUATU (Vers�o Hino 1)"}),
    VAI_KAMILA("Vai Kamila", false, "30/01/2025 - 20:20", 2, 62, 1, new String[]{"forr� piseiro", "gabriel", "letra original"}, new String[]{}, new String[]{}),
    VAMOS_DANCAR_FORRO("Vamos Dan�ar Forr�", false, "26/01/2025 - 15:09", 2, 58, 1, new String[]{"forr� piseiro", "roberta", "letra original"}, new String[]{}, new String[]{}),
    VAMOS_LUCAS("Vamos Lucas", false, "06/09/2024 - 11:54", 1, 21, 3, new String[]{"funk", "lucas moreira", "bruno", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    VEM_PRO_MEU_CORACAO("Vem Pro Meu Cora��o", false, "05/10/2024 - 19:28", 1, 44, 1, new String[]{"forr� piseiro", "eduarda", "letra ia"}, new String[]{}, new String[]{}),
    VIBRACOES_DA_RUA("Vibra��es da Rua", false, "07/05/2024 - 09:31", 0, 12, 0, new String[]{"pagode", "udio", "letra ia"}, new String[]{}, new String[]{}),
    VIDA_DE_MARIANA("Vida de Mariana", false, "31/12/2024 - 20:19", 2, 35, 3, new String[]{"reggae", "mariana", "letra original"}, new String[]{}, new String[]{}),
    VIDA_EM_RITMO_PESADO("Vida em Ritmo Pesado", false, "07/05/2024 - 09:31", 0, 13, 0, new String[]{"rock", "eduarda", "udio", "letra original"}, new String[]{}, new String[]{}),
    VITAMINA_DA_EDUARDA("Vitamina da Eduarda", false, "12/11/2024 - 15:30", 1, 63, 1, new String[]{"reggae", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    XAROPE_E_VITAMINA_C("Xarope e Vitamina C", false, "10/07/2024 - 21:49", 0, 58, 3, new String[]{"sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}),
    YUSUKE("Yusuke", false, "05/03/2025 - 03:20", 2, 83, 1, new String[]{"metal", "introbase64", "meel", "letra original", "refer�ncia externa", "v�deo do canal"}, new String[]{}, new String[]{}),
    ;

    private final String musicName;
    private final boolean misterIA;
    private final String creation;
    private final int album;
    private final int number;
    private final int subVersions;
    private final String[] tags;
    private final String[] alternativeVersions;
    private final String[] subAlternativeVersions;

    Music(String musicName, boolean misterIA, String creation, int album, int number, int subVersions, String[] tags, String[] alternativeVersions, String[] subAlternativeVersions) {
        this.musicName = musicName;
        this.misterIA = misterIA;
        this.creation = creation;
        this.number = number;
        this.album = album;
        this.subVersions = subVersions;
        this.tags = tags;
        this.alternativeVersions = alternativeVersions;
        this.subAlternativeVersions = subAlternativeVersions;
    }

    public String getMusicName() {
        return musicName;
    }

    public boolean isMisterIA() {
        return misterIA;
    }

    public String getCreation() {
        return creation;
    }

    public int getAlbum() {
        return album;
    }

    public int getNumber() {
        return number;
    }

    public int getSubVersions() {
        return subVersions;
    }

    public String[] getTags() {
        return tags;
    }

    public String[] getAlternativeVersions() {
        return alternativeVersions;
    }

    public String[] getSubAlternativeVersions() {
        return subAlternativeVersions;
    }

    public String[] getAllVersions() {
        String[] arr1 = getAlternativeVersions();
        String[] arr2 = getSubAlternativeVersions();
        String[] result = new String[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    public String getAuthor() {
        return isMisterIA() ? "Mister IA" : "IA";
    }

    public String getAlbumName() {
        return albumName(getAlbum());
    }

    public String getShortAlbumName() {
        return shortAlbumName(getAlbum());
    }

    public String getCompleteName() {
        return getAuthor() + " - " + getMusicName();
    }

    public String getMusicFileName() {
        return getCompleteName() + ".mp3";
    }

    public String getMusicPath() {
        return getAuthor() + "/" + getMusicFileName();
    }

    public File getMusicFile() {
        return new File(getMusicsFolder() + getMusicPath());
    }

    public String getLyricsPath() {
        String content = getMusicFileName();
        content = content.split(" \\(")[0];
        content = content.toLowerCase();
        content = content.replace(".mp3", "");
        return "assets/lyrics/" + content + ".txt";
    }

    public File getLyricsFile() {
        return new File(getMusicsFolder() + getLyricsPath());
    }

    public String getLyricsURL() {
        return getMusicsURL() + getLyricsPath().replace(" ", "%20");
    }

    public String getRemasteredPath() {
        return getAuthor() + " Remastered/" + getAuthor() + " - " + getMusicName() + " (Remastered).mp3";
    }

    public File getRemasteredFile() {
        return new File(getMusicsFolder() + getRemasteredPath());
    }

    public boolean hasRemastered() {
        return getRemasteredFile().exists();
    }

    public String getInstrumentalPath() {
        return getAuthor() + " Stems/" + getAuthor() + " - " + getMusicName() + " (Instrumental).mp3";
    }

    public String getVocalsPath() {
        return getAuthor() + " Stems/" + getAuthor() + " - " + getMusicName() + " (Vocals).mp3";
    }

    public boolean hasStems() {
        return new File(getMusicsFolder() + getInstrumentalPath()).exists() && new File(getMusicsFolder() + getVocalsPath()).exists();
    }

    public String getMusicURL() {
        return getMusicsURL() + getAuthor().replace(" ", "%20") + "/" + getMusicFileName().replace(" ", "%20");
    }

    public String getSubVersionMusicURL(int number) {
        return getMusicsURL() + getAuthor().replace(" ", "%20") + "%20Others/" + getAuthor().replace(" ", "%20") + "%20-%20" + getMusicName().replace(" ", "%20") + "%20" + number + ".mp3";
    }

    public String getAlternativeFolder(String fileName) {
        return getAuthor() + (new File(getMusicsFolder() + getAuthor() + " Cover", getAuthor() + " - " + fileName + ".mp3").exists() ? " Cover" : " Cover Others");
    }

    public String getMusicAlternativeURL(String fileName) {
        return getMusicsURL() + getAlternativeFolder(fileName).replace(" ", "%20") + "/" + getAuthor().replace(" ", "%20") + "%20-%20" + fileName.replace(" ", "%20") + ".mp3";
    }

    public String getRemasteredURL() {
        return getMusicsURL() + getAuthor().replace(" ", "%20") + "%20Remastered/" + getAuthor().replace(" ", "%20") + "%20-%20" + getMusicName().replace(" ", "%20") + "%20(Remastered).mp3";
    }

    public String getInstrumentalURL() {
        return getMusicsURL() + getAuthor().replace(" ", "%20") + "%20Stems/" + getAuthor().replace(" ", "%20") + "%20-%20" + getMusicName().replace(" ", "%20") + "%20(Instrumental).mp3";
    }

    public String getVocalsURL() {
        return getMusicsURL() + getAuthor().replace(" ", "%20") + "%20Stems/" + getAuthor().replace(" ", "%20") + "%20-%20" + getMusicName().replace(" ", "%20") + "%20(Vocals).mp3";
    }

    public String getMusicURL(String alternative, int subVersion) {
        return alternative != null ? getMusicAlternativeURL(alternative) : subVersion == 0 ? getRemasteredURL() :
                subVersion == -1 ? getInstrumentalURL() : subVersion == -2 ? getVocalsURL() :
                        subVersion > 0 ? getSubVersionMusicURL(subVersion) : getMusicURL();
    }

    public List<File> getSubVersionsMusicFiles() {
        List<File> files = new ArrayList<>();
        for (int i = 1; i <= getSubVersions(); i++) {
            String fileName = getAuthor() + " - " + getMusicName() + " " + i + ".mp3";
            File file = new File(getMusicsFolder() + getAuthor() + " Others/" + fileName);
            if (file.exists()) {
                files.add(file);
            }
        }
        for (File file : new File(getMusicsFolder() + getAuthor() + " Others/").listFiles()) {
            String fileName = file.getName();
            String nameWithoutExt = fileName.substring(0, fileName.length() - 4);
            String[] parts = nameWithoutExt.split(" - ");
            if (parts.length < 2) {
                continue;
            }
            String musicName = parts[1].trim();
            if (!musicName.equalsIgnoreCase(getMusicName())) {
                continue;
            }
            files.add(file);
        }
        return files;
    }

    public List<File> getAlternativeVersionsFiles() {
        List<File> files = new ArrayList<>();
        for (String alternativeName : getAlternativeVersions()) {
            File file = new File(getMusicsFolder() + getAlternativeFolder(alternativeName) + "/" + getAuthor() + " - " + alternativeName + ".mp3");
            if (file.exists()) {
                files.add(file);
            }
        }
        return files;
    }

    public int listSubVersions() {
        return getSubVersions() + getAlternativeVersions().length;
    }

    public static String albumName(int album) {
        return switch (album) {
            case 0 -> "Antigo Testamento";
            case 1 -> "Novo Testamento";
            case 2 -> "Tempos Modernos";
            default -> "Revolu��o Sonora";
        };
    }

    public static String shortAlbumName(int album) {
        return switch (album) {
            case 0 -> "AT";
            case 1 -> "NT";
            case 2 -> "TM";
            default -> "RS";
        };
    }

    public static int getMusicsAmountInAlbum(int album) {
        int result = 0;
        for (Music music : values()) {
            if (music.getAlbum() == album) {
                result++;
            }
        }
        return result;
    }

    public static String getMusicsFolder() {
        return "F:/Musicas/";
    }

    public static String getMusicsURL() {
        return "http://musics.introcdc.com/";
    }

    public static List<String> listEnum() {
        List<String> result = new ArrayList<>();
        for (Music music : values()) {
            result.add(music.name());
        }
        return result;
    }

    public static ArrayList<String> readLinesFromURL(String urlString) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add("�f" + line);
                }
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

}
