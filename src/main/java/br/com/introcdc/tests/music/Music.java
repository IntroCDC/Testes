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
    AGUINHA_GELADINHA("Aguinha Geladinha", true, "16/07/2024 - 16:38", 0, 66, 1, "Aguinha Geladinha (Vers�o Piano)", "Aguinha Geladinha (Vers�o Vozes do Inferno)"),
    AGUINHA_GELADINHA_VERSAO_PISEIRO("Aguinha Geladinha (Vers�o Piseiro)", true, "20/09/2024 - 18:50", 1, 33, 0),
    AGUINHA_QUENTINHA("Aguinha Quentinha", true, "12/11/2024 - 17:34", 1, 64, 15),
    ALEXA_COM_RAIVA("Alexa com Raiva", true, "21/10/2024 - 01:26", 1, 49, 4),
    ASTACARABUMTS("Astacar�bumts", true, "19/06/2024 - 00:07", 0, 34, 3, "Astacar�bumts (Bass Boost)", "Astacar�bumts (Vers�o Piseiro)", "Astacar�bumts (Vers�o Piseiro 1)"),
    ARROCHA_DAS_GATINHAS("Arrocha das Gatinhas", true, "08/06/2025 - 08:55", 3, 11, 3),
    ARROCHA_DO_JOVEM_DINAMICO("Arrocha do Jovem Din�mico", true, "08/02/2025 - 19:23", 2, 66, 5, "Arrocha do Jovem Din�mico (Vers�o Arrocha)", "Arrocha do Jovem Din�mico (Vers�o Piseiro)", "Arrocha do Jovem Din�mico (Vers�o Censurada)"),
    ARROCHA_DO_MARIAUM("Arrocha do Mariaum", true, "03/06/2025 - 05:14", 3, 6, 1, "Arrocha do Mariaum (Vers�o Mariaum)"),
    ATRAPALHADOR("Atrapalhador", true, "04/07/2024 - 13:33", 0, 50, 2, "Atrapalhador (Vers�o Piano)", "Atrapalhador (Vers�o Piseiro 1)", "Atrapalhador (Vers�o Piano 1)", "Atrapalhador (Vers�o Piano 2)"),
    ATRAPALHADOR_VERSAO_PISEIRO("Atrapalhador (Vers�o Piseiro)", true, "19/09/2024 - 13:28", 1, 32, 0),
    AVENTURA_NO_MUNDO_DE_BLOCOS("Aventura no Mundo de Blocos", true, "19/10/2024 - 20:33", 1, 47, 1),
    CAGADA_NERVOSA("Cagada Nervosa", true, "21/10/2024 - 01:59", 1, 50, 7),
    CLAUDINHO("Claudinho", true, "11/01/2025 - 10:38", 2, 51, 3),
    COCO_NA_ARARIUS("Coc� na Arari�s", true, "04/07/2024 - 12:32", 0, 47, 1),
    COMENTARIOS("Coment�rios", true, "05/07/2024 - 12:58", 0, 53, 0),
    COMIDA_GOSTOSA("Comida Gostosa", true, "18/06/2024 - 10:48", 0, 33, 1, "Comida Gostosa (Vers�o Metal 1)"),
    COMIDA_GOSTOSA_VERSAO_METAL("Comida Gostosa (Vers�o Metal)", true, "19/09/2024 - 12:16", 1, 31, 0),
    CORRE_PRA_PRAIA("Corre pra Praia", true, "16/07/2024 - 22:30", 0, 69, 1),
    DESCOLADINHO("Descoladinho", true, "19/06/2024 - 02:43", 0, 37, 0),
    DESTROY_EVERYTHING("Destroy Everything", true, "26/01/2025 - 22:11", 2, 59, 3),
    DIX_TRACK_DETRAN("Dix Track Detran", true, "04/07/2024 - 12:03", 0, 46, 1, "Dix Track Detran (Vers�o Piseiro 1)", "Dix Track Detran (Vers�o Piseiro 2)"),
    DIX_TRACK_DETRAN_VERSAO_PISEIRO("Dix Track Detran (Vers�o Piseiro)", true, "29/09/2024 - 23:50", 1, 42, 0),
    DOIDAO("Doid�o", true, "22/10/2024 - 23:09", 1, 52, 10),
    ENGRACADINHO("Engra�adinho", true, "25/06/2024 - 02:55", 0, 42, 1, "Engra�adinho (Vers�o Alternativa)", "Engra�adinho (Vers�o Funk)", "Engra�adinho (Vers�o Metal)", "Engra�adinho (Vers�o Piseiro)", "Engra�adinho (Vers�o Pop)", "Engra�adinho (Vers�o Metal 1)", "Engra�adinho (Vers�o Metal 2)", "Engra�adinho (Vers�o Metal 3)", "Engra�adinho (Vers�o Piseiro 1)", "Engra�adinho (Vers�o Arrocha)", "Engra�adinho (Vers�o Brega)", "Engra�adinho (Vers�o Arrocha 1)", "Engra�adinho (Vers�o Brega 1)"),
    ENGRACADAO("ENGRA�AD�O", true, "25/09/2024 - 14:44", 1, 37, 19, "ENGRA�AD�O (Vers�o Pop)", "ENGRA�AD�O (Vers�o Reggae)", "ENGRA�AD�O (Vers�o �pica)", "ENGRA�AD�O (Vers�o �pica 1)", "ENGRA�AD�O (Remastered 1)", "ENGRA�AD�O (Vers�o Arrocha)", "ENGRA�AD�O (Vers�o Arrocha 1)"),
    ENGRACADAO_VERSAO_PISEIRO("ENGRA�AD�O (Vers�o Piseiro)", true, "25/09/2024 - 15:00", 1, 38, 0, "ENGRA�AD�O (Vers�o Piseiro) (Remastered 1)", "ENGRA�AD�O (Vers�o Piseiro) (Remastered 2)"),
    ENTRADA_SEVERA("Entrada Severa", true, "09/05/2025 - 20:03", 3, 2, 1, "Entrada Severa (Vers�o Pop)", "Entrada Severa (Vers�o Pop 1)"),
    FELICIDADE("Felicidade", true, "22/02/2025 - 16:23", 2, 79, 1),
    GALOPA_PRO_KINDOME("Galopa pro Kindome", true, "09/05/2025 - 21:09", 3, 3, 1),
    GOSTO_DE_COCO("Gosto de Coc�", true, "16/11/2024 - 14:05", 1, 69, 9),
    HACKINGS("Hackings", true, "29/08/2024 - 01:33", 1, 10, 2, "Hackings (Vers�o Piseiro)", "Hackings (Vers�o Piseiro 1)"),
    HA_UM_POTO("H� Um Pot�", true, "27/04/2024 - 01:26", 0, 7, 3),
    IMBATIVEL_MATHEUS("Imbat�vel Matheus", true, "15/09/2024 - 12:29", 1, 28, 3),
    INTROBASE64("IntroBase64", true, "09/06/2024 - 06:39", 0, 29, 2, "IntroBase64 (Vers�o Metal)", "IntroBase64 (Vers�o Metal 1)", "IntroBase64 (Vers�o Metal 2)", "IntroBase64 (Vers�o Metal 3)", "IntroBase64 (Vers�o Metal 4)"),
    INVOCACOES("Invoca��es", true, "08/06/2024 - 18:30", 0, 28, 0),
    JOGOS_DO_MUSH("Jogos do Mush", true, "24/04/2024 - 12:46", 0, 1, 3, "Jogos do Mush (Vers�o Mariaum)", "Jogos do Mush (Vers�o Mariaum 1)"),
    JOVEM_DINAMICO("Jovem Din�mico", true, "27/04/2024 - 01:14", 0, 6, 7, "Jovem Din�mico 3.5 1", "Jovem Din�mico 3.5 2"),
    JUBARACACHUBA("Jubaracachuba", true, "20/06/2024 - 20:59", 0, 41, 3, "Jubaracachuba (Vers�o Alternativa)", "Jubaracachuba (Vers�o Alternativa 1)"),
    JUNIOR_CHATO("Junior Chato", true, "19/06/2024 - 03:07", 0, 38, 0),
    KINDOME("Kindome", true, "31/08/2024 - 04:03", 1, 13, 3),
    KIRITO_O_BODE("Kirito o Bode", true, "11/02/2025 - 00:58", 2, 72, 3, "Kirito o Bode (Vers�o Kirito)", "Kirito o Bode (Vers�o Mariaum)", "Kirito o Bode (Vers�o Arrocha)", "Kirito o Bode (Vers�o Metal)", "Kirito o Bode (Vers�o Arrocha 1)", "Kirito o Bode (Vers�o Metal 1)", "Kirito o Bode (Vers�o Vocaloid)", "Kirito o Bode (Vers�o Vocaloid 1)"),
    LAGA_LAMA("Laga Lama", true, "26/04/2024 - 13:59", 0, 5, 1, "Laga Lama (Vers�o Alternativa)", "Laga Lama 3.5 1", "Laga Lama 3.5 2"),
    LORENA("Lorena", true, "30/12/2024 - 18:01", 2, 29, 4, "Lorena (Vers�o Eletr�nica)", "Lorena (Vers�o Funk)", "Lorena (Vers�o Opera)", "Lorena (Vers�o Piseiro)", "Lorena (Vers�o Rap)", "Lorena (Vers�o Reggae)", "Lorena (Vers�o Terror)", "Lorena (Vers�o Arrocha)", "Lorena (Vers�o Arrocha 1)"),
    MARIAUM_E_JAPONESA("Mariaum e Japonesa", true, "03/01/2025 - 14:51", 2, 46, 1, "Mariaum e Japonesa (Vers�o Mariaum)", "Mariaum e Japonesa (Vers�o Funk)", "Mariaum e Japonesa (Vers�o K-Pop)", "Mariaum e Japonesa (Vers�o Metal)", "Mariaum e Japonesa (Vers�o Piano)", "Mariaum e Japonesa (Vers�o Reggae)", "Mariaum e Japonesa (Vers�o K-Pop 1)", "Mariaum e Japonesa (Vers�o Metal 1)", "Mariaum e Japonesa (Vers�o Metal 2)", "Mariaum e Japonesa (Vers�o Piano 1)", "Mariaum e Japonesa (Vers�o Salsa)", "Mariaum e Japonesa (Vers�o Salsa 1)"),
    MELO_DO_INTRO("Melo do Intro", true, "09/06/2025 - 06:47", 3, 12, 2),
    MENININHOS_ENGRACADINHOS("Menininhos Engra�adinhos", true, "18/06/2024 - 08:09", 0, 32, 3, "Menininhos Engra�adinhos (Vers�o Alternativa)", "Menininhos Engra�adinhos (Vers�o Piano)", "Menininhos Engra�adinhos (Vers�o Piseiro)", "Menininhos Engra�adinhos (Vers�o Metal 1)"),
    MENININHOS_ENGRACADINHOS_VERSAO_METAL("Menininhos Engra�adinhos (Vers�o Metal)", true, "19/09/2024 - 10:45", 1, 30, 0),
    MINEPARTY("MineParty", true, "19/06/2024 - 03:53", 0, 40, 3),
    MUITO_PESADO("Muito Pesado", true, "09/07/2024 - 14:16", 0, 55, 0),
    MUSICA_EMPOLGANTE_E_IRRITANTE("M�sica Empolgante e Irritante", true, "25/07/2024 - 19:01", 0, 82, 1),
    NAO_PODE_BEBER("N�o Pode Beber", true, "29/12/2024 - 19:34", 2, 23, 1),
    NOSSO_DJ("Nosso DJ", true, "19/06/2024 - 03:14", 0, 39, 1),
    OBSESSOR_DEVORADOR("Obsessor Devorador", true, "06/10/2024 - 15:07", 1, 45, 5, "Obsessor Devorador (Vers�o Arrocha)", "Obsessor Devorador (Vers�o Piseiro)", "Obsessor Devorador (Vers�o Piseiro 1)"),
    OLD_BURNING_LOVE("Old Burning Love", true, "18/02/2025 - 14:58", 2, 76, 6),
    ONI_CHAN("Oni Chan", true, "03/01/2025 - 14:34", 2, 45, 1),
    PARABENS_GABRIEL("Parab�ns Gabriel", true, "03/06/2025 - 22:19", 3, 7, 2, "Parab�ns Gabriel (Vers�o Censurada)"),
    PATINETE_ELETRICO("Patinete El�trico", true, "19/06/2024 - 02:08", 0, 36, 5, "Patinete El�trico (Vers�o Arrocha)", "Patinete El�trico (Vers�o Funk)", "Patinete El�trico (Vers�o Romantica)", "Patinete El�trico (Vers�o Alternativa)"),
    PATINETE_ELETRICO_VERSAO_PISEIRO("Patinete El�trico (Vers�o Piseiro)", true, "27/09/2024 - 04:25", 1, 40, 0, "Patinete El�trico (Vers�o Piseiro 1)", "Patinete El�trico (Vers�o Piseiro 2)"),
    PRIMEIRO_DE_ABRIL("Primeiro de Abril", true, "13/03/2025 - 03:53", 2, 87, 3, "Primeiro de Abril (Vers�o Mariaum)", "Primeiro de Abril (Vers�o Metal)", "Primeiro de Abril (Vers�o Reggae)", "Primeiro de Abril (Vers�o Metal 1)"),
    RAFAEL_AULER_3_5("Rafael Auler 3.5", true, "07/06/2024 - 22:39", 0, 27, 0, "Rafael Auler 3.5 (Vers�o Reggae)", "Rafael Auler 3.5 (Vers�o Metal)", "Rafael Auler 3.5 (Vers�o Alternativa)", "Rafael Auler 3.5 (Vers�o Eletr�nica)", "Rafael Auler 3.5 (Vers�o Pagode)", "Rafael Auler 3.5 (Vers�o Piano)", "Rafael Auler 3.5 (Vers�o Piseiro)", "Rafael Auler 3.5 (Vers�o Pop)", "Rafael Auler 3.5 (Vers�o Funk)", "Rafael Auler 3.5 (Vers�o Viol�o)", "Rafael Auler 3.5 (Vers�o Vegas)", "Rafael Auler 3.5 (Vers�o Miami)", "Rafael Auler 3.5 (Vers�o Evang�lica)", "Rafael Auler 3.5 (Vers�o Seresta)", "Rafael Auler 3.5 (Vers�o Sofr�ncia)", "Rafael Auler 3.5 (Vers�o �pica)", "Rafael Auler 3.5 (Vers�o Pagode 1)", "Rafael Auler 3.5 (Vers�o Piano 1)", "Rafael Auler 3.5 (Vers�o Piseiro 1)", "Rafael Auler 3.5 (Vers�o Metal 1)", "Rafael Auler 3.5 (Vers�o Rafael)"),
    REI_DO_CEBOLITOS("Rei do Cebolitos", true, "03/05/2025 - 16:19", 3, 1, 1),
    RITUAL_DAS_GATINHAS("Ritual das Gatinhas", true, "13/06/2024 - 06:33", 0, 30, 1, "Ritual das Gatinhas (Vers�o Piseiro)", "Ritual das Gatinhas (Vers�o Piseiro 1)"),
    SANIDADE_MENTAL("Sanidade Mental", true, "27/09/2024 - 05:42", 1, 41, 15, "Sanidade Mental (Vers�o Piseiro)", "Sanidade Mental (Vers�o Seresta)"),
    SOFREDOR("Sofredor", true, "28/08/2024 - 23:02", 1, 9, 8),
    SONO_DO_MARIAUM("Sono do Mariaum", true, "05/02/2025 - 03:28", 2, 65, 1, "Sono do Mariaum (Vers�o Mariaum)"),
    SR_DUVIDA("Sr D�vida", true, "29/07/2024 - 06:44", 0, 85, 3, "Sr D�vida (Vers�o Piseiro)", "Sr D�vida (Vers�o Piseiro 1)", "Sr D�vida (Vers�o Piseiro 2)"),
    STAND_UP_DO_DIEGO("Stand UP do Diego", true, "04/09/2024 - 17:14", 1, 18, 2),
    STILL_WATER("Still Water", true, "01/11/2024 - 01:50", 1, 57, 1, "Still Water (Vers�o Salsa)", "Still Water (Vers�o Arrocha)", "Still Water (Vers�o Reggae)", "Still Water (Vers�o Metal)", "Still Water (Vers�o Salsa 1)", "Still Water (Vers�o Arrocha 1)", "Still Water (Vers�o Arrocha 2)", "Still Water (Vers�o Arrocha 3)", "Still Water (Vers�o Reggae 1)", "Still Water (Vers�o Metal 1)", "Still Water (Vers�o Metal 2)", "Still Water (Vers�o Metal 3)", "Still Water (Remastered 1)", "Still Water (Remastered 2)", "Still Water (Remastered 3)"),
    THE_IMPOSSIBLE("The Impossible", true, "15/02/2025 - 04:35", 2, 74, 5, "The Impossible (Vers�o Orquestra)", "The Impossible (Vers�o Reggae)", "The Impossible (Vers�o �pica 1)", "The Impossible (Vers�o �pica 2)", "The Impossible (Vers�o Orquestra 1)", "The Impossible (Vers�o Piseiro)", "The Impossible (Vers�o Piseiro 1)", "The Impossible (Vers�o Funk)", "The Impossible (Vers�o Funk 1)", "The Impossible (Vers�o Patriota)", "The Impossible (Vers�o Pop)", "The Impossible (Remastered 1)", "The Impossible (Remastered 2)"),
    THE_IMPOSSIBLE_VERSAO_METAL("The Impossible (Vers�o Metal)", true, "18/02/2025 - 12:30", 2, 75, 0, "The Impossible (Vers�o Metal 1)", "The Impossible (Vers�o Metal 2)", "The Impossible (Vers�o Metal 3)", "The Impossible (Vers�o Metal 4)", "The Impossible (Vers�o Metal 5)", "The Impossible (Vers�o Metal 6)"),
    TORNEIO_DE_YOUTUBERS("Torneio de YouTubers", true, "27/06/2025 - 17:48", 3, 17, 1, "Torneio de YouTubers (Vers�o Metal)", "Torneio de YouTubers (Vers�o Metal 1)", "Torneio de YouTubers (Vers�o Arrocha)", "Torneio de YouTubers (Vers�o Reggae)", "Torneio de YouTubers (Vers�o Arrocha 1)", "Torneio de YouTubers (Vers�o Reggae 1)", "Torneio de YouTubers (Vers�o Salsa)", "Torneio de YouTubers (Vers�o Salsa 1)"),
    TRANSMISSAO_ESTATICA("Transmiss�o Est�tica", true, "06/06/2024 - 13:40", 0, 25, 1),
    TRES_PATINHOS("Tr�s Patinhos", true, "08/01/2025 - 17:37", 2, 48, 5),
    TUBARAO("Tubar�o", true, "18/12/2024 - 16:08", 2, 11, 3),
    VOCE_FEZ_COCO("Voc� fez coc�", true, "26/04/2024 - 01:46", 0, 4, 3),

    // IA
    A8_BIT_PIANO("8 Bit Piano", false, "13/11/2024 - 21:49", 1, 65, 4),
    A_PRAIA_E_O_COCO("A Praia e o Coco", false, "16/07/2024 - 10:39", 0, 65, 1),
    A_PROPOSTA("A Proposta", false, "23/05/2025 - 00:20", 3, 5, 3),
    A_SOPA_CHEGOU("A Sopa Chegou", false, "08/09/2024 - 17:06", 1, 26, 1),
    A_VIAGEM_PRA_BENFICA("A Viagem pra Benfica", false, "23/11/2024 - 19:43", 2, 3, 1),
    ACORDA_E_LUNCH("Acorda e Lunch", false, "29/06/2024 - 13:02", 0, 43, 1),
    ACORDA_GABRIEL("Acorda Gabriel", false, "04/08/2024 - 18:36", 1, 4, 1),
    ADALGESIO_NO_ROLE("Adalg�sio no Rol�", false, "19/07/2024 - 20:55", 0, 75, 1),
    AGUA_DE_COCO_DA_EDUARDA("�gua de Coco da Eduarda", false, "01/12/2024 - 04:35", 2, 6, 1),
    ALEATERIO_NA_RUA("Aleat�rio na Rua", false, "05/07/2024 - 18:27", 0, 54, 1),
    ALFABETO("Alfabeto", false, "31/08/2024 - 04:25", 1, 14, 1),
    ALMOCO_NO_APARTAMENTO("Almo�o no Apartamento", false, "29/12/2024 - 14:00", 2, 18, 1),
    AMIGO_VEM_DORMIR_COMIGO("Amigo Vem Dormir Comigo", false, "23/09/2024 - 02:12", 1, 36, 1),
    AMOR_DE_JOGO("Amor de Jogo", false, "16/11/2024 - 00:50", 1, 68, 1),
    ANIVERSARIO_DA_SAFIRA("Anivers�rio da Safira", false, "17/08/2024 - 12:58", 1, 7, 11),
    AMOR_DESVELADO("Amor Desvelado", false, "31/05/2024 - 05:25", 0, 21, 0),
    ANO_NOVO_EM_IRACEMA("Ano Novo em Iracema", false, "30/12/2024 - 16:25", 2, 26, 3),
    ARROCHA_DA_ANA("Arrocha da Ana", false, "08/03/2025 - 20:02", 2, 85, 3),
    ARROCHA_DO_GABRIEL("Arrocha do Gabriel", false, "31/12/2024 - 19:40", 2, 33, 1, "Arrocha do Gabriel (Vers�o Reggae)", "Arrocha do Gabriel (Vers�o Reggae 1)"),
    ATENCAO_GABRIEL("Aten��o Gabriel", false, "29/12/2024 - 11:41", 2, 15, 1),
    AUDIO_WHATSAPP("�udio WhatsApp", false, "31/08/2024 - 06:06", 1, 16, 3),
    AVENTURA_NA_PRAIA_DE_IRACEMA("Aventura na Praia de Iracema", false, "29/12/2024 - 20:51", 2, 24, 1),
    AVISO_PARA_EDUARDA("Aviso para Eduarda", false, "07/09/2024 - 13:24", 1, 23, 1),
    BANHO_DA_EDUARDA("Banho da Eduarda", false, "23/10/2024 - 13:30", 1, 53, 3),
    BEDWARS_ENTRE_4_JOGADORES("BedWars Entre 4 Jogadores", false, "16/11/2024 - 00:39", 1, 67, 1),
    BERIMBAU("Berimbau", false, "04/08/2024 - 15:31", 1, 2, 1, "Beriumbau (Vers�o Brega)", "Beriumbau (Vers�o Brega 1)", "Berimbau (Vers�o Arrocha)", "Berimbau (Vers�o Arrocha 1)"),
    BLUSA_AMARELA("Blusa Amarela", false, "16/07/2024 - 16:52", 0, 67, 1),
    BODE("Bode", false, "25/07/2024 - 22:46", 0, 83, 0),
    BOM_DIA_A_TODOS("Bom Dia a Todos", false, "31/12/2024 - 12:34", 2, 31, 1),
    BOOMBOX_CAIR("Boombox Cair", false, "17/07/2024 - 00:40", 0, 70, 1),
    BOTA_PRA_DANCAR("Bota pra Dan�ar", false, "27/12/2024 - 01:27", 2, 12, 0),
    CACHORRO_QUENTE("Cachorro Quente", false, "05/09/2024 - 20:05", 1, 20, 3),
    CADE_VOCE_EDUARDA("Cad� Voc� Eduarda", false, "30/12/2024 - 18:26", 2, 30, 1),
    CALA_BOCA("CALA BOCA", false, "19/01/2025 - 17:05", 2, 56, 3),
    CALMA_GABRIEL("Calma Gabriel", false, "30/12/2024 - 16:54", 2, 27, 1),
    CENAS("Cenas", false, "29/10/2024 - 00:53", 1, 56, 3),
    CHEGOU_O_REMEDIO("Chegou o Rem�dio", false, "02/01/2025 - 11:12", 2, 41, 1, "Chegou o Rem�dio (Vers�o Reggae)", "Chegou o Rem�dio (Vers�o Reggae 1)", "Chegou o Rem�dio (Vers�o Arrocha)", "Chegou o Rem�dio (Vers�o Arrocha 1)", "Chegou o Rem�dio (Vers�o Pop)", "Chegou o Rem�dio (Vers�o Metal)", "Chegou o Rem�dio (Vers�o Metal 1)"),
    CHILL("Chill", false, "07/09/2024 - 08:27", 1, 22, 1),
    CHUVINHA_AMIZADE("Chuvinha Amizade", false, "15/07/2024 - 13:23", 0, 64, 1),
    COCO("Coc�", false, "22/09/2024 - 11:30", 1, 34, 1),
    COISAS_NO_APARTAMENTO("Coisas no Apartamento", false, "12/11/2024 - 10:28", 1, 60, 1),
    COME_EDUARDA("Come Eduarda", false, "13/01/2025 - 10:36", 2, 53, 2),
    COMIDAS_GOSTOSINHAS("Comidas Gostosinhas", false, "04/07/2024 - 14:06", 0, 51, 1),
    CSGO("CSGO", false, "04/04/2025 - 05:04", 2, 89, 1),
    DEITADOS("Deitados", false, "04/08/2024 - 17:05", 1, 3, 1, "Deitados Sofredor (Vers�o Metal)", "Deitados Sofredor (Vers�o Metal 1)", "Deitados Sofredor (Vers�o Metal 2)", "Deitados Sofredor (Vers�o Metal 3)"),
    DESENHA_EDUARDA("Desenha, Eduarda", false, "17/07/2024 - 00:47", 0, 71, 1),
    DESILUSAO_NO_FORRO("Desilus�o no Forr�", false, "19/07/2024 - 23:45", 0, 77, 3),
    DESPERTAR_INCANSAVEL("Despertar Incansavel", false, "18/07/2024 - 19:25", 0, 74, 1),
    DISPUTA_NO_MUSHMC("Disputa no MushMC", false, "08/11/2024 - 00:38", 1, 59, 1),
    DIVERSAO_NO_MUSH("Divers�o no Mush", false, "24/04/2024 - 12:46", 0, 2, 0),
    DIARIO_DE_LUCAS("Di�rio de Lucas", false, "30/09/2024 - 17:20", 1, 43, 1),
    DOCES_DE_JULIANA("Doces de Juliana", false, "29/05/2024 - 13:01", 0, 20, 1),
    DOMINIOS_DIGITAIS("Dom�nios Digitais", false, "05/05/2024 - 01:55", 0, 10, 0),
    DONO_DO_PODER("Dono do Poder", false, "05/05/2024 - 01:58", 0, 11, 0),
    DOR_DE_BARRIGA("Dor de Barriga", false, "09/02/2025 - 16:24", 2, 69, 1),
    EDUARDA_INSPIRADA("Eduarda Inspirada", false, "17/07/2024 - 01:17", 0, 73, 1),
    EDUARDA_NA_FAVELA("Eduarda na Favela", false, "03/11/2024 - 00:50", 1, 58, 1),
    EDUARDA("Eduarda", false, "13/06/2024 - 20:02", 0, 31, 1, "Eduarda (Vers�o Alternativa)", "Eduarda (Vers�o Forr�)", "Eduarda (Vers�o Infantil)", "Eduarda (Vers�o Pagode)", "Eduarda (Vers�o Piano Calmo)", "Eduarda (Vers�o Piano)", "Eduarda (Vers�o Reggae)", "Eduarda (Vers�o Alternativa 2)", "Eduarda (Vers�o Forr� 2)", "Eduarda (Vers�o Pagode 2)", "Eduarda (Vers�o Piano 1)", "Eduarda (Vers�o Piano 2)", "Eduarda (Vers�o Espanhol)", "Eduarda (Vers�o Espanhol 1)", "Eduarda (Vers�o Rock Cl�ssico)", "Eduarda (Vers�o Arrocha)", "Eduarda (Vers�o Arrocha 1)"),
    ELA_E_GATINHA("Ela � Gatinha", false, "15/06/2025 - 12:21", 3, 14, 1, "Ela � Gatinha (Vers�o Brega)", "Ela � Gatinha (Vers�o Reggae)", "Ela � Gatinha (Vers�o Metal)", "Ela � Gatinha (Vers�o Brega 1)", "Ela � Gatinha (Vers�o Reggae 1)", "Ela � Gatinha (Vers�o Metal 1)"),
    ELE_E_O_GABRIEL("Ele � o Gabriel", false, "01/01/2025 - 14:55", 2, 37, 1),
    ENVIANDO_O_KINDOME("Enviando o Kindome", false, "27/11/2024 - 22:20", 2, 4, 1),
    ESCOLHA_DA_BLUSA("Escolha da Blusa", false, "16/07/2024 - 16:52", 0, 68, 1),
    ESCOVANDO_OS_DENTES("Escovando os Dentes", false, "02/01/2025 - 13:50", 2, 43, 1),
    EU_TE_AMO_EDUARDA("Eu Te Amo Eduarda", false, "29/12/2024 - 13:09", 2, 17, 1),
    EX_DJS("Ex DJs", false, "08/09/2024 - 16:22", 1, 25, 1),
    FAYE("Faye", false, "02/01/2025 - 17:10", 2, 44, 1),
    FERNANDO_NO_APARTAMENTO("Fernando no Apartamento", false, "12/11/2024 - 10:28", 1, 61, 3),
    FESTA_NO_ELEVADOR("Festa no Elevador", false, "18/06/2025 - 13:11", 3, 15, 9),
    FIOS_REBELDES("Fios Rebeldes", false, "01/05/2024 - 09:49", 0, 9, 0),
    FOGUETE_TRICOLOR("Foguete Tricolor", false, "29/08/2024 - 02:36", 1, 11, 7),
    FOME_DA_LORENA("Fome da Lorena", false, "31/12/2024 - 12:45", 2, 32, 1),
    FRASES_DE_EDUARDA("Frases de Eduarda", false, "17/07/2024 - 01:06", 0, 72, 1),
    FRASES_DE_LUCIVANIA("Frases de Lucivania", false, "01/01/2025 - 20:35", 2, 40, 1),
    FRASES_NO_APARTAMENTO("Frases no Apartamento", false, "12/11/2024 - 10:28", 1, 62, 1),
    GABRIEL_ESCOVANDO("Gabriel Escovando", false, "19/01/2025 - 11:10", 2, 55, 1),
    GABRIEL_PARA_JABRIEL("Gabriel para Jabriel", false, "31/12/2024 - 20:10", 2, 34, 1),
    GABRIEL("Gabriel", false, "29/12/2024 - 14:05", 2, 19, 1),
    GALERA_DO_MARIAUM("Galera do Mariaum", false, "15/12/2025 - 12:55", 2, 76, 0, "Galera do Mariaum (Vers�o Reggae)", "Galera do Mariaum (Vers�o Reggae 1)", "Galera do Mariaum (Vers�o Metal)", "Galera do Mariaum (Vers�o Metal 1)", "Galera do Mariaum (Vers�o Piseiro)", "Galera do Mariaum (Vers�o Piseiro 1)", "Galera do Mariaum (Vers�o Piseiro 2)", "Galera do Mariaum (Vers�o Piseiro 3)", "Galera do Mariaum (Vers�o Alternativa)", "Galera do Mariaum (Vers�o Alternativa 1)"),
    GAROTAS_PALHACO("Garotas Palha�o", false, "26/02/2025 - 23:18", 2, 82, 5),
    GIGANTES_DO_FORROZAO("Gigantes do Forroz�o", false, "07/05/2024 - 16:52", 0, 14, 1),
    GOSTOSINHO("Gostosinho", false, "19/07/2025 - 23:44", 3, 18, 4),
    GRANDE_ENIGMA("Grande Enigma", false, "02/08/2024 - 17:49", 1, 1, 1),
    HIPER_CINEMATIC("Hiper Cinematic", false, "04/07/2024 - 12:46", 0, 48, 1),
    HOMENAGEM_A_MINHA_VO("Homenagem a minha v�", false, "04/09/2024 - 17:45", 1, 19, 1),
    HORROR_PIANO("Horror Piano", false, "04/06/2025 - 13:40", 3, 8, 1),
    INTRO_NA_CHAMADA("Intro na Chamada", false, "20/11/2024 - 18:28", 2, 1, 15),
    IVR("IVR", false, "09/06/2025 - 23:23", 3, 13, 7),
    JAVA_CODING("Java Coding", false, "22/01/2025 - 22:00", 2, 57, 1),
    JINGLE_DAS_GATINHAS("Jingle das Gatinhas", false, "19/06/2024 - 00:33", 0, 35, 0, "Jingle das Gatinhas (Vers�o Metal)"),
    JOAO_BRENO_E_O_LEGO("Jo�o Breno e o Lego", false, "15/09/2024 - 12:29", 1, 29, 1),
    JOSE("Jos�", false, "22/02/2025 - 12:46", 2, 78, 1),
    KIRITO("Kirito", false, "31/08/2024 - 01:30", 1, 12, 1),
    LENON_NO_MICROFONE("Lenon no Microfone", false, "27/12/2024 - 01:30", 2, 13, 0),
    LINDA_EDUARDA("Linda Eduarda", false, "29/12/2024 - 22:11", 2, 25, 1),
    LIVE_DE_MINE("Live de Mine", false, "09/01/2025 - 19:30", 2, 50, 3),
    LOJA_PARA_HYAN("Loja para Hyan", false, "12/02/2025 - 19:45", 2, 73, 3),
    LUCA_PROIBIDO("Luca Proibido", false, "02/02/2025 - 23:26", 2, 63, 1),
    LUCAS_DORMINHOCO("Lucas Dorminhoco", false, "08/09/2024 - 12:45", 1, 24, 5),
    LUCAS_FAZENDO_COCO("Lucas Fazendo Coc�", false, "12/01/2025 - 02:53", 2, 52, 1),
    LUCAS_NO_VOLANTE("Lucas no Volante", false, "11/05/2025 - 17:27", 3, 4, 5),
    LUCAS("Lucas", false, "30/12/2024 - 17:08", 2, 28, 1),
    LUCIVANIA("Lucivania", false, "01/01/2025 - 19:42", 2, 39, 1),
    MAJOR_SABINO("Major Sabino", false, "22/08/2024 - 22:03", 1, 8, 6, "Major Sabino (Vers�o Gospel)", "Major Sabino (Vers�o Metal)", "Major Sabino (Vers�o Gospel 1)", "Major Sabino (Vers�o Metal 1)", "Major Sabino (Vers�o Metal 2)", "Major Sabino (Vers�o Metal 3)"),
    MANHA_DE_METAL("Manh� de Metal", false, "15/05/2024 - 08:58", 0, 16, 0),
    MARIA_EDUARDA_NO_FORRO("Maria Eduarda No Forr�", false, "11/08/2024 - 18:51", 1, 6, 1),
    MARIA_EDUARDA("Maria Eduarda", false, "09/02/2025 - 16:45", 2, 70, 1),
    MARIAUM("Mariaum", false, "15/02/2025 - 12:48", 2, 75, 0),
    MC_HARIEL_PARA_SAFIRA("MC Hariel para Safira", false, "18/05/2024 - 18:17", 0, 19, 1),
    MCGPLAYS_PARA_VINICIUS("MCGPlays para Vinicius", false, "06/06/2024 - 09:26", 0, 24, 0),
    MENSAGENS("Mensagens", false, "27/10/2024 - 04:54", 1, 55, 5),
    MEU_SONHO_DO_DIA_2("Meu Sonho do Dia 2", false, "02/01/2025 - 11:19", 2, 42, 3),
    MISSOES_PARA_HYAN("Miss�es para Hyan", false, "05/12/2024 - 20:20", 2, 8, 3),
    MOUNTAIN_PATH("Mountain Path", false, "06/06/2025 - 22:40", 3, 10, 1, "Mountain Path (Vers�o Metal)", "Mountain Path (Vers�o Arrocha)", "Mountain Path (Vers�o Piseiro)", "Mountain Path (Vers�o Espacial)", "Mountain Path (Vers�o Harpa)", "Mountain Path (Vers�o Violino)", "Mountain Path (Vers�o Metal 1)", "Mountain Path (Vers�o Metal 2)", "Mountain Path (Vers�o Metal 3)", "Mountain Path (Vers�o Piseiro 1)", "Mountain Path (Vers�o Arrocha 1)", "Mountain Path (Vers�o Espacial 1)"),
    MUSHMC("MushMC", false, "10/02/2025 - 19:11", 2, 71, 1),
    MUSICA_PARA_CAGAR("M�sica para Cagar", false, "04/07/2024 - 20:58", 0, 52, 5),
    NAO_SABE_PULAR("N�o Sabe Pular", false, "24/02/2025 - 11:48", 2, 80, 7),
    NATUREZA("Natureza", false, "21/10/2024 - 02:23", 1, 51, 7),
    NAYARA("Nayara", false, "22/07/2024 - 02:52", 0, 79, 1),
    NOITE_PALIDA("Noite P�lida", false, "16/03/2025 - 06:37", 2, 88, 1),
    NOSSO_RELACIONAMENTO("Nosso Relacionamento", false, "14/11/2024 - 18:48", 1, 66, 1),
    NOVOS_SERVIDORES("Novos Servidores", false, "09/04/2025 - 06:30", 2, 91, 1),
    O_AMOR_DE_EDUARDA_PELO_COCO("O Amor de Eduarda Pelo Coc�", false, "22/09/2024 - 11:33", 1, 35, 0),
    O_DONO_DO_SERVIDOR("O Dono do Servidor", false, "01/06/2024 - 19:54", 0, 22, 0),
    O_DUMP_DO_MYSQL("O Dump do MySQL", false, "14/05/2024 - 00:53", 0, 15, 2),
    O_MARIAUM("O Mariaum", false, "20/10/2024 - 21:37", 1, 48, 1, "O Mariaum (Vers�o Mariaum)"),
    OI_RAFAEL("Oi Rafael", false, "20/07/2025 - 14:47", 3, 19, 6),
    OLHANDO_PARA_O_LADO("Olhando para o Lado", false, "10/07/2024 - 17:29", 0, 57, 1),
    OPRESSOR_DEPRECIADOR("Opressor Depreciador", false, "06/08/2025 - 03:53", 3, 20, 6),
    OURO_BRANCO_PARA_LUCAS("Ouro Branco para Lucas", false, "17/11/2024 - 07:42", 1, 70, 3),
    PALAVRAS_GUARDADAS("Palavras Guardadas", false, "30/06/2024 - 19:46", 0, 44, 1),
    PANDA("Panda", false, "09/04/2025 - 05:16", 2, 90, 1),
    PARABENS_ANA("Parab�ns Ana", false, "20/02/2025 - 01:10", 2, 77, 4, "Parab�ns Ana (Vers�o Metal)", "Parab�ns Ana (Vers�o Metal 1)"),
    PARABENS_DE_KOS("Parab�ns de Kos", false, "06/03/2025 - 00:23", 2, 84, 1),
    PARABENS_KOS("Parab�ns Kos", false, "12/03/2025 - 16:42", 2, 86, 3),
    PARABENS_MARIAUM("Parab�ns Mariaum", false, "11/10/2024 - 20:39", 1, 46, 3, "Parab�ns Mariaum (Vers�o Mariaum)"),
    PEDIDO_DE_MASCARA("Pedido de M�scara", false, "11/07/2024 - 14:16", 0, 61, 3),
    PERFEITA("Perfeita", false, "02/12/2024 - 23:48", 2, 7, 1),
    PESSOA_ACIMA("Pessoa Acima", false, "08/01/2025 - 17:47", 2, 49, 3),
    PLUGIN_DE_REPORT("Plugin de Report", false, "23/10/2024 - 21:08", 1, 54, 0),
    POMBO("Pombo", false, "09/09/2024 - 18:26", 1, 27, 1),
    PORTUGUES("Portugu�s", false, "24/02/2025 - 15:13", 2, 81, 1),
    PROCURA_DE_EMPREGO("Procura de Emprego", false, "01/07/2024 - 08:31", 0, 45, 1),
    PROMESSA_DA_SULAMERICANA("Promessa da Sulamericana", false, "26/09/2024 - 19:13", 1, 39, 1),
    PSYCHOPATH("Psychopath", false, "04/06/2025 - 13:49", 3, 9, 1),
    PUDIM_E_TORTA_DE_FRANGO("Pudim e Torta de Frango", false, "31/07/2024 - 17:35", 0, 86, 1),
    PUTS_KINDOME("Puts Kindome", false, "16/04/2025 - 05:39", 2, 92, 3),
    QUE_MARAVILHA("Que Maravilha", false, "15/05/2024 - 23:29", 0, 17, 1),
    RAIVA("Raiva", false, "08/02/2025 - 20:44", 2, 67, 5),
    REABERTURA_DO_KINDOME("Reabertura do Kindome", false, "30/11/2024 - 13:08", 2, 5, 1),
    REGISTRO_DE_FUTEBOL("Registro de Futebol", false, "09/07/2024 - 21:55", 0, 56, 1),
    REINOS_DE_JOGO("Reinos de Jogo", false, "24/04/2024 - 12:57", 0, 3, 2),
    RITMO_INSOLENTE("Ritmo Insolente", false, "29/04/2024 - 16:01", 0, 8, 0),
    SAFIRA_VS_EDUARDA("Safira vs Eduarda", false, "23/07/2024 - 02:20", 0, 80, 9, "Safira vs Eduarda (Vers�o Funk)", "Safira vs Eduarda (Vers�o Metal)", "Safira vs Eduarda (Vers�o Minimalista)", "Safira vs Eduarda (Vers�o Pagode)", "Safira vs Eduarda (Vers�o Piano)", "Safira vs Eduarda (Vers�o Metal 1)", "Safira vs Eduarda (Vers�o Metal 2)", "Safira vs Eduarda (Vers�o Metal 3)", "Safira vs Eduarda (Vers�o Pagode 1)", "Safira vs Eduarda (Vers�o Reggae)", "Safira vs Eduarda (Vers�o Reggae 1)", "Safira vs Eduarda (Vers�o Salsa)", "Safira vs Eduarda (Vers�o Salsa 1)", "Safira vs Eduarda (Vers�o Pop)", "Safira vs Eduarda (Vers�o Arrocha)", "Safira vs Eduarda (Vers�o Arrocha 1)", "Safira vs Eduarda (Vers�o Arrocha 2)", "Safira vs Eduarda (Vers�o Alternativa)"),
    SAFIRA("Safira", false, "03/01/2025 - 18:27", 2, 47, 2),
    SARAIVA("Saraiva", false, "09/02/2025 - 15:05", 2, 68, 11, "Saraiva (Vers�o Reggae)", "Saraiva (Vers�o Reggae 1)", "Saraiva (Vers�o Rock)", "Saraiva (Vers�o Rock 1)", "Saraiva (Vers�o Metal)", "Saraiva (Vers�o Metal 1)"),
    SETE_NA_CHAMADA("Sete na Chamada", false, "06/12/2024 - 21:57", 2, 9, 3, "Sete na Chamada (Vers�o Metal)", "Sete na Chamada (Vers�o Metal 1)"),
    SHOW_DE_COMEDIA("Show de Com�dia", false, "31/08/2024 - 20:26", 1, 17, 2),
    SKATE("Skate", false, "29/12/2024 - 16:18", 2, 22, 1),
    SNIF("Snif", false, "23/04/2025 - 08:06", 2, 93, 1),
    SOLO_DE_GUITARRA_PISEIRO("Solo de Guitarra Piseiro", false, "27/12/2024 - 01:45", 2, 14, 1),
    SOM_DO_SOL("Som do Sol", false, "07/06/2024 - 17:58", 0, 26, 0),
    SONHOS_DIGITAIS("Sonhos Digitais", false, "03/06/2024 - 19:10", 0, 23, 0),
    SONO_DA_EDUARDA("Sono da Eduarda", false, "28/01/2025 - 22:56", 2, 60, 4),
    SONO_DO_GABRIEL("Sono do Gabriel", false, "19/01/2025 - 10:03", 2, 54, 6),
    STAIRCASE("StairCase", false, "20/06/2025 - 17:57", 3, 16, 1),
    STELLA_OVERTURE("Stella Overture", false, "15/07/2024 - 06:52", 0, 63, 1),
    SUVACO_CABELUDO("Suvaco Cabeludo", false, "18/05/2024 - 10:42", 0, 18, 0),
    TAVA_GOSTOSO("Tava Gostoso", false, "29/12/2024 - 14:29", 2, 21, 1),
    TE_AMAR_DE_NOVO("Te Amar de Novo", false, "19/07/2024 - 21:00", 0, 76, 3),
    TE_AMO_DEMAIS("Te Amo Demais", false, "11/08/2024 - 13:32", 1, 5, 7),
    TESTE_DE_VOZ("Teste de voz", false, "31/08/2024 - 04:37", 1, 15, 1),
    TEXTAO_EM_PIANO("Text�o em Piano", false, "10/07/2024 - 22:53", 0, 60, 1),
    TEXTAO_EM_SERTANEJO("Text�o em Sertanejo", false, "10/07/2024 - 22:52", 0, 59, 1),
    THE_END("The End", false, "05/02/2025 - 01:29", 2, 64, 4),
    TIA_FOFA("Tia Fofa", false, "29/12/2024 - 14:07", 2, 20, 1),
    TODO_MUNDO("Todo Mundo", false, "04/07/2024 - 13:04", 0, 49, 1),
    TODOS_NA_SALA("Todos na Sala", false, "01/01/2025 - 15:01", 2, 38, 1),
    TOMA_LUCAS("Toma Lucas", false, "01/01/2025 - 13:50", 2, 36, 1),
    TRANQUIL_DREAMSCAPES("Tranquil Dreamscapes", false, "23/07/2024 - 17:19", 0, 81, 1),
    TROCA_DE_ROUPAS_NO_PORTO_DAS_DUNAS("Troca de Roupas no Porto das Dunas", false, "08/12/2024 - 04:20", 2, 10, 1),
    TUDO_BEM_GABRIEL("Tudo Bem Gabriel", false, "29/12/2024 - 12:25", 2, 16, 1),
    ULTRA_POPULAR("Ultra Popular", false, "11/07/2024 - 14:16", 0, 62, 1),
    UM_DIA_NA_PRAIA("Um Dia Na Praia", false, "20/07/2024 - 19:59", 0, 78, 1),
    UM_E_DOIS("Um e Dois", false, "28/07/2024 - 11:45", 0, 84, 0),
    UMA_NOITE_EM_BENFICA("Uma Noite em Benfica", false, "23/11/2024 - 19:41", 2, 2, 1),
    VAI_IGUATU("VAI IGUATU", false, "29/01/2025 - 21:10", 2, 61, 8, "VAI IGUATU (Vers�o Hino)", "VAI IGUATU (Vers�o Hino 1)"),
    VAI_KAMILA("Vai Kamila", false, "30/01/2025 - 20:20", 2, 62, 1),
    VAMOS_DANCAR_FORRO("Vamos Dan�ar Forr�", false, "26/01/2025 - 15:09", 2, 58, 1),
    VAMOS_LUCAS("Vamos Lucas", false, "06/09/2024 - 11:54", 1, 21, 3),
    VEM_PRO_MEU_CORACAO("Vem Pro Meu Cora��o", false, "05/10/2024 - 19:28", 1, 44, 1),
    VIBRACOES_DA_RUA("Vibra��es da Rua", false, "07/05/2024 - 09:31", 0, 12, 0),
    VIDA_DE_MARIANA("Vida de Mariana", false, "31/12/2024 - 20:19", 2, 35, 3),
    VIDA_EM_RITMO_PESADO("Vida em Ritmo Pesado", false, "07/05/2024 - 09:31", 0, 13, 0),
    VITAMINA_DA_EDUARDA("Vitamina da Eduarda", false, "12/11/2024 - 15:30", 1, 63, 1),
    XAROPE_E_VITAMINA_C("Xarope e Vitamina C", false, "10/07/2024 - 21:49", 0, 58, 3),
    YUSUKE("Yusuke", false, "05/03/2025 - 03:20", 2, 83, 1),
    ;

    private final String musicName;
    private final boolean misterIA;
    private final String creation;
    private final int album;
    private final int number;
    private final int subVersions;
    private final String[] alternativeVersions;

    Music(String musicName, boolean misterIA, String creation, int album, int number, int subVersions, String... alternativeVersions) {
        this.musicName = musicName;
        this.misterIA = misterIA;
        this.creation = creation;
        this.number = number;
        this.album = album;
        this.subVersions = subVersions;
        this.alternativeVersions = alternativeVersions;
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

    public String[] getAlternativeVersions() {
        return alternativeVersions;
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
