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
    AGUINHA_GELADINHA("Aguinha Geladinha", true, "16/07/2024 - 16:38", 0, 66, 1, "Aguinha Geladinha (Versão Piano)", "Aguinha Geladinha (Versão Vozes do Inferno)"),
    AGUINHA_GELADINHA_VERSAO_PISEIRO("Aguinha Geladinha (Versão Piseiro)", true, "20/09/2024 - 18:50", 1, 33, 0),
    AGUINHA_QUENTINHA("Aguinha Quentinha", true, "12/11/2024 - 17:34", 1, 64, 15),
    ALEXA_COM_RAIVA("Alexa com Raiva", true, "21/10/2024 - 01:26", 1, 49, 4),
    ASTACARABUMTS("Astacarábumts", true, "19/06/2024 - 00:07", 0, 34, 3, "Astacarábumts (Bass Boost)", "Astacarábumts (Versão Piseiro)", "Astacarábumts (Versão Piseiro 1)"),
    ARROCHA_DAS_GATINHAS("Arrocha das Gatinhas", true, "08/06/2025 - 08:55", 3, 11, 3),
    ARROCHA_DO_JOVEM_DINAMICO("Arrocha do Jovem Dinâmico", true, "08/02/2025 - 19:23", 2, 66, 5, "Arrocha do Jovem Dinâmico (Versão Arrocha)", "Arrocha do Jovem Dinâmico (Versão Piseiro)", "Arrocha do Jovem Dinâmico (Versão Censurada)"),
    ARROCHA_DO_MARIAUM("Arrocha do Mariaum", true, "03/06/2025 - 05:14", 3, 6, 1, "Arrocha do Mariaum (Versão Mariaum)"),
    ATRAPALHADOR("Atrapalhador", true, "04/07/2024 - 13:33", 0, 50, 2, "Atrapalhador (Versão Piano)", "Atrapalhador (Versão Piseiro 1)", "Atrapalhador (Versão Piano 1)", "Atrapalhador (Versão Piano 2)"),
    ATRAPALHADOR_VERSAO_PISEIRO("Atrapalhador (Versão Piseiro)", true, "19/09/2024 - 13:28", 1, 32, 0),
    AVENTURA_NO_MUNDO_DE_BLOCOS("Aventura no Mundo de Blocos", true, "19/10/2024 - 20:33", 1, 47, 1),
    CAGADA_NERVOSA("Cagada Nervosa", true, "21/10/2024 - 01:59", 1, 50, 7),
    CLAUDINHO("Claudinho", true, "11/01/2025 - 10:38", 2, 51, 3),
    COCO_NA_ARARIUS("Cocô na Arariús", true, "04/07/2024 - 12:32", 0, 47, 1),
    COMENTARIOS("Comentários", true, "05/07/2024 - 12:58", 0, 53, 0),
    COMIDA_GOSTOSA("Comida Gostosa", true, "18/06/2024 - 10:48", 0, 33, 1, "Comida Gostosa (Versão Metal 1)"),
    COMIDA_GOSTOSA_VERSAO_METAL("Comida Gostosa (Versão Metal)", true, "19/09/2024 - 12:16", 1, 31, 0),
    CORRE_PRA_PRAIA("Corre pra Praia", true, "16/07/2024 - 22:30", 0, 69, 1),
    DESCOLADINHO("Descoladinho", true, "19/06/2024 - 02:43", 0, 37, 0),
    DESTROY_EVERYTHING("Destroy Everything", true, "26/01/2025 - 22:11", 2, 59, 3),
    DIX_TRACK_DETRAN("Dix Track Detran", true, "04/07/2024 - 12:03", 0, 46, 1, "Dix Track Detran (Versão Piseiro 1)", "Dix Track Detran (Versão Piseiro 2)"),
    DIX_TRACK_DETRAN_VERSAO_PISEIRO("Dix Track Detran (Versão Piseiro)", true, "29/09/2024 - 23:50", 1, 42, 0),
    DOIDAO("Doidão", true, "22/10/2024 - 23:09", 1, 52, 10),
    ENGRACADINHO("Engraçadinho", true, "25/06/2024 - 02:55", 0, 42, 1, "Engraçadinho (Versão Alternativa)", "Engraçadinho (Versão Funk)", "Engraçadinho (Versão Metal)", "Engraçadinho (Versão Piseiro)", "Engraçadinho (Versão Pop)", "Engraçadinho (Versão Metal 1)", "Engraçadinho (Versão Metal 2)", "Engraçadinho (Versão Metal 3)", "Engraçadinho (Versão Piseiro 1)", "Engraçadinho (Versão Arrocha)", "Engraçadinho (Versão Brega)", "Engraçadinho (Versão Arrocha 1)", "Engraçadinho (Versão Brega 1)"),
    ENGRACADAO("ENGRAÇADÃO", true, "25/09/2024 - 14:44", 1, 37, 19, "ENGRAÇADÃO (Versão Pop)", "ENGRAÇADÃO (Versão Reggae)", "ENGRAÇADÃO (Versão Épica)", "ENGRAÇADÃO (Versão Épica 1)", "ENGRAÇADÃO (Remastered 1)", "ENGRAÇADÃO (Versão Arrocha)", "ENGRAÇADÃO (Versão Arrocha 1)"),
    ENGRACADAO_VERSAO_PISEIRO("ENGRAÇADÃO (Versão Piseiro)", true, "25/09/2024 - 15:00", 1, 38, 0, "ENGRAÇADÃO (Versão Piseiro) (Remastered 1)", "ENGRAÇADÃO (Versão Piseiro) (Remastered 2)"),
    ENTRADA_SEVERA("Entrada Severa", true, "09/05/2025 - 20:03", 3, 2, 1, "Entrada Severa (Versão Pop)", "Entrada Severa (Versão Pop 1)"),
    FELICIDADE("Felicidade", true, "22/02/2025 - 16:23", 2, 79, 1),
    GALOPA_PRO_KINDOME("Galopa pro Kindome", true, "09/05/2025 - 21:09", 3, 3, 1),
    GOSTO_DE_COCO("Gosto de Cocô", true, "16/11/2024 - 14:05", 1, 69, 9),
    HACKINGS("Hackings", true, "29/08/2024 - 01:33", 1, 10, 2, "Hackings (Versão Piseiro)", "Hackings (Versão Piseiro 1)"),
    HA_UM_POTO("Há Um Potó", true, "27/04/2024 - 01:26", 0, 7, 3),
    IMBATIVEL_MATHEUS("Imbatível Matheus", true, "15/09/2024 - 12:29", 1, 28, 3),
    INTROBASE64("IntroBase64", true, "09/06/2024 - 06:39", 0, 29, 2, "IntroBase64 (Versão Metal)", "IntroBase64 (Versão Metal 1)", "IntroBase64 (Versão Metal 2)", "IntroBase64 (Versão Metal 3)", "IntroBase64 (Versão Metal 4)"),
    INVOCACOES("Invocações", true, "08/06/2024 - 18:30", 0, 28, 0),
    JOGOS_DO_MUSH("Jogos do Mush", true, "24/04/2024 - 12:46", 0, 1, 3, "Jogos do Mush (Versão Mariaum)", "Jogos do Mush (Versão Mariaum 1)"),
    JOVEM_DINAMICO("Jovem Dinâmico", true, "27/04/2024 - 01:14", 0, 6, 7, "Jovem Dinâmico 3.5 1", "Jovem Dinâmico 3.5 2"),
    JUBARACACHUBA("Jubaracachuba", true, "20/06/2024 - 20:59", 0, 41, 3, "Jubaracachuba (Versão Alternativa)", "Jubaracachuba (Versão Alternativa 1)"),
    JUNIOR_CHATO("Junior Chato", true, "19/06/2024 - 03:07", 0, 38, 0),
    KINDOME("Kindome", true, "31/08/2024 - 04:03", 1, 13, 3),
    KIRITO_O_BODE("Kirito o Bode", true, "11/02/2025 - 00:58", 2, 72, 3, "Kirito o Bode (Versão Kirito)", "Kirito o Bode (Versão Mariaum)", "Kirito o Bode (Versão Arrocha)", "Kirito o Bode (Versão Metal)", "Kirito o Bode (Versão Arrocha 1)", "Kirito o Bode (Versão Metal 1)", "Kirito o Bode (Versão Vocaloid)", "Kirito o Bode (Versão Vocaloid 1)"),
    LAGA_LAMA("Laga Lama", true, "26/04/2024 - 13:59", 0, 5, 1, "Laga Lama (Versão Alternativa)", "Laga Lama 3.5 1", "Laga Lama 3.5 2"),
    LORENA("Lorena", true, "30/12/2024 - 18:01", 2, 29, 4, "Lorena (Versão Eletrônica)", "Lorena (Versão Funk)", "Lorena (Versão Opera)", "Lorena (Versão Piseiro)", "Lorena (Versão Rap)", "Lorena (Versão Reggae)", "Lorena (Versão Terror)", "Lorena (Versão Arrocha)", "Lorena (Versão Arrocha 1)"),
    MARIAUM_E_JAPONESA("Mariaum e Japonesa", true, "03/01/2025 - 14:51", 2, 46, 1, "Mariaum e Japonesa (Versão Mariaum)", "Mariaum e Japonesa (Versão Funk)", "Mariaum e Japonesa (Versão K-Pop)", "Mariaum e Japonesa (Versão Metal)", "Mariaum e Japonesa (Versão Piano)", "Mariaum e Japonesa (Versão Reggae)", "Mariaum e Japonesa (Versão K-Pop 1)", "Mariaum e Japonesa (Versão Metal 1)", "Mariaum e Japonesa (Versão Metal 2)", "Mariaum e Japonesa (Versão Piano 1)", "Mariaum e Japonesa (Versão Salsa)", "Mariaum e Japonesa (Versão Salsa 1)"),
    MELO_DO_INTRO("Melo do Intro", true, "09/06/2025 - 06:47", 3, 12, 2),
    MENININHOS_ENGRACADINHOS("Menininhos Engraçadinhos", true, "18/06/2024 - 08:09", 0, 32, 3, "Menininhos Engraçadinhos (Versão Alternativa)", "Menininhos Engraçadinhos (Versão Piano)", "Menininhos Engraçadinhos (Versão Piseiro)", "Menininhos Engraçadinhos (Versão Metal 1)"),
    MENININHOS_ENGRACADINHOS_VERSAO_METAL("Menininhos Engraçadinhos (Versão Metal)", true, "19/09/2024 - 10:45", 1, 30, 0),
    MINEPARTY("MineParty", true, "19/06/2024 - 03:53", 0, 40, 3),
    MUITO_PESADO("Muito Pesado", true, "09/07/2024 - 14:16", 0, 55, 0),
    MUSICA_EMPOLGANTE_E_IRRITANTE("Música Empolgante e Irritante", true, "25/07/2024 - 19:01", 0, 82, 1),
    NAO_PODE_BEBER("Não Pode Beber", true, "29/12/2024 - 19:34", 2, 23, 1),
    NOSSO_DJ("Nosso DJ", true, "19/06/2024 - 03:14", 0, 39, 1),
    OBSESSOR_DEVORADOR("Obsessor Devorador", true, "06/10/2024 - 15:07", 1, 45, 5, "Obsessor Devorador (Versão Arrocha)", "Obsessor Devorador (Versão Piseiro)", "Obsessor Devorador (Versão Piseiro 1)"),
    OLD_BURNING_LOVE("Old Burning Love", true, "18/02/2025 - 14:58", 2, 76, 6),
    ONI_CHAN("Oni Chan", true, "03/01/2025 - 14:34", 2, 45, 1),
    PARABENS_GABRIEL("Parabéns Gabriel", true, "03/06/2025 - 22:19", 3, 7, 2, "Parabéns Gabriel (Versão Censurada)"),
    PATINETE_ELETRICO("Patinete Elétrico", true, "19/06/2024 - 02:08", 0, 36, 5, "Patinete Elétrico (Versão Arrocha)", "Patinete Elétrico (Versão Funk)", "Patinete Elétrico (Versão Romantica)", "Patinete Elétrico (Versão Alternativa)"),
    PATINETE_ELETRICO_VERSAO_PISEIRO("Patinete Elétrico (Versão Piseiro)", true, "27/09/2024 - 04:25", 1, 40, 0, "Patinete Elétrico (Versão Piseiro 1)", "Patinete Elétrico (Versão Piseiro 2)"),
    PRIMEIRO_DE_ABRIL("Primeiro de Abril", true, "13/03/2025 - 03:53", 2, 87, 3, "Primeiro de Abril (Versão Mariaum)", "Primeiro de Abril (Versão Metal)", "Primeiro de Abril (Versão Reggae)", "Primeiro de Abril (Versão Metal 1)"),
    RAFAEL_AULER_3_5("Rafael Auler 3.5", true, "07/06/2024 - 22:39", 0, 27, 0, "Rafael Auler 3.5 (Versão Reggae)", "Rafael Auler 3.5 (Versão Metal)", "Rafael Auler 3.5 (Versão Alternativa)", "Rafael Auler 3.5 (Versão Eletrônica)", "Rafael Auler 3.5 (Versão Pagode)", "Rafael Auler 3.5 (Versão Piano)", "Rafael Auler 3.5 (Versão Piseiro)", "Rafael Auler 3.5 (Versão Pop)", "Rafael Auler 3.5 (Versão Funk)", "Rafael Auler 3.5 (Versão Violão)", "Rafael Auler 3.5 (Versão Vegas)", "Rafael Auler 3.5 (Versão Miami)", "Rafael Auler 3.5 (Versão Evangélica)", "Rafael Auler 3.5 (Versão Seresta)", "Rafael Auler 3.5 (Versão Sofrência)", "Rafael Auler 3.5 (Versão Épica)", "Rafael Auler 3.5 (Versão Pagode 1)", "Rafael Auler 3.5 (Versão Piano 1)", "Rafael Auler 3.5 (Versão Piseiro 1)", "Rafael Auler 3.5 (Versão Metal 1)", "Rafael Auler 3.5 (Versão Rafael)"),
    REI_DO_CEBOLITOS("Rei do Cebolitos", true, "03/05/2025 - 16:19", 3, 1, 1),
    RITUAL_DAS_GATINHAS("Ritual das Gatinhas", true, "13/06/2024 - 06:33", 0, 30, 1, "Ritual das Gatinhas (Versão Piseiro)", "Ritual das Gatinhas (Versão Piseiro 1)"),
    SANIDADE_MENTAL("Sanidade Mental", true, "27/09/2024 - 05:42", 1, 41, 15, "Sanidade Mental (Versão Piseiro)", "Sanidade Mental (Versão Seresta)"),
    SOFREDOR("Sofredor", true, "28/08/2024 - 23:02", 1, 9, 8),
    SONO_DO_MARIAUM("Sono do Mariaum", true, "05/02/2025 - 03:28", 2, 65, 1, "Sono do Mariaum (Versão Mariaum)"),
    SR_DUVIDA("Sr Dúvida", true, "29/07/2024 - 06:44", 0, 85, 3, "Sr Dúvida (Versão Piseiro)", "Sr Dúvida (Versão Piseiro 1)", "Sr Dúvida (Versão Piseiro 2)"),
    STAND_UP_DO_DIEGO("Stand UP do Diego", true, "04/09/2024 - 17:14", 1, 18, 2),
    STILL_WATER("Still Water", true, "01/11/2024 - 01:50", 1, 57, 1, "Still Water (Versão Salsa)", "Still Water (Versão Arrocha)", "Still Water (Versão Reggae)", "Still Water (Versão Metal)", "Still Water (Versão Salsa 1)", "Still Water (Versão Arrocha 1)", "Still Water (Versão Arrocha 2)", "Still Water (Versão Arrocha 3)", "Still Water (Versão Reggae 1)", "Still Water (Versão Metal 1)", "Still Water (Versão Metal 2)", "Still Water (Versão Metal 3)", "Still Water (Remastered 1)", "Still Water (Remastered 2)", "Still Water (Remastered 3)"),
    THE_IMPOSSIBLE("The Impossible", true, "15/02/2025 - 04:35", 2, 74, 5, "The Impossible (Versão Orquestra)", "The Impossible (Versão Reggae)", "The Impossible (Versão Épica 1)", "The Impossible (Versão Épica 2)", "The Impossible (Versão Orquestra 1)", "The Impossible (Versão Piseiro)", "The Impossible (Versão Piseiro 1)", "The Impossible (Versão Funk)", "The Impossible (Versão Funk 1)", "The Impossible (Versão Patriota)", "The Impossible (Versão Pop)", "The Impossible (Remastered 1)", "The Impossible (Remastered 2)"),
    THE_IMPOSSIBLE_VERSAO_METAL("The Impossible (Versão Metal)", true, "18/02/2025 - 12:30", 2, 75, 0, "The Impossible (Versão Metal 1)", "The Impossible (Versão Metal 2)", "The Impossible (Versão Metal 3)", "The Impossible (Versão Metal 4)", "The Impossible (Versão Metal 5)", "The Impossible (Versão Metal 6)"),
    TORNEIO_DE_YOUTUBERS("Torneio de YouTubers", true, "27/06/2025 - 17:48", 3, 17, 1, "Torneio de YouTubers (Versão Metal)", "Torneio de YouTubers (Versão Metal 1)", "Torneio de YouTubers (Versão Arrocha)", "Torneio de YouTubers (Versão Reggae)", "Torneio de YouTubers (Versão Arrocha 1)", "Torneio de YouTubers (Versão Reggae 1)", "Torneio de YouTubers (Versão Salsa)", "Torneio de YouTubers (Versão Salsa 1)"),
    TRANSMISSAO_ESTATICA("Transmissão Estática", true, "06/06/2024 - 13:40", 0, 25, 1),
    TRES_PATINHOS("Três Patinhos", true, "08/01/2025 - 17:37", 2, 48, 5),
    TUBARAO("Tubarão", true, "18/12/2024 - 16:08", 2, 11, 3),
    VOCE_FEZ_COCO("Você fez cocô", true, "26/04/2024 - 01:46", 0, 4, 3),

    // IA
    A8_BIT_PIANO("8 Bit Piano", false, "13/11/2024 - 21:49", 1, 65, 4),
    A_PRAIA_E_O_COCO("A Praia e o Coco", false, "16/07/2024 - 10:39", 0, 65, 1),
    A_PROPOSTA("A Proposta", false, "23/05/2025 - 00:20", 3, 5, 3),
    A_SOPA_CHEGOU("A Sopa Chegou", false, "08/09/2024 - 17:06", 1, 26, 1),
    A_VIAGEM_PRA_BENFICA("A Viagem pra Benfica", false, "23/11/2024 - 19:43", 2, 3, 1),
    ACORDA_E_LUNCH("Acorda e Lunch", false, "29/06/2024 - 13:02", 0, 43, 1),
    ACORDA_GABRIEL("Acorda Gabriel", false, "04/08/2024 - 18:36", 1, 4, 1),
    ADALGESIO_NO_ROLE("Adalgésio no Rolê", false, "19/07/2024 - 20:55", 0, 75, 1),
    AGUA_DE_COCO_DA_EDUARDA("Água de Coco da Eduarda", false, "01/12/2024 - 04:35", 2, 6, 1),
    ALEATERIO_NA_RUA("Aleatório na Rua", false, "05/07/2024 - 18:27", 0, 54, 1),
    ALFABETO("Alfabeto", false, "31/08/2024 - 04:25", 1, 14, 1),
    ALMOCO_NO_APARTAMENTO("Almoço no Apartamento", false, "29/12/2024 - 14:00", 2, 18, 1),
    AMIGO_VEM_DORMIR_COMIGO("Amigo Vem Dormir Comigo", false, "23/09/2024 - 02:12", 1, 36, 1),
    AMOR_DE_JOGO("Amor de Jogo", false, "16/11/2024 - 00:50", 1, 68, 1),
    ANIVERSARIO_DA_SAFIRA("Aniversário da Safira", false, "17/08/2024 - 12:58", 1, 7, 11),
    AMOR_DESVELADO("Amor Desvelado", false, "31/05/2024 - 05:25", 0, 21, 0),
    ANO_NOVO_EM_IRACEMA("Ano Novo em Iracema", false, "30/12/2024 - 16:25", 2, 26, 3),
    ARROCHA_DA_ANA("Arrocha da Ana", false, "08/03/2025 - 20:02", 2, 85, 3),
    ARROCHA_DO_GABRIEL("Arrocha do Gabriel", false, "31/12/2024 - 19:40", 2, 33, 1, "Arrocha do Gabriel (Versão Reggae)", "Arrocha do Gabriel (Versão Reggae 1)"),
    ATENCAO_GABRIEL("Atenção Gabriel", false, "29/12/2024 - 11:41", 2, 15, 1),
    AUDIO_WHATSAPP("Áudio WhatsApp", false, "31/08/2024 - 06:06", 1, 16, 3),
    AVENTURA_NA_PRAIA_DE_IRACEMA("Aventura na Praia de Iracema", false, "29/12/2024 - 20:51", 2, 24, 1),
    AVISO_PARA_EDUARDA("Aviso para Eduarda", false, "07/09/2024 - 13:24", 1, 23, 1),
    BANHO_DA_EDUARDA("Banho da Eduarda", false, "23/10/2024 - 13:30", 1, 53, 3),
    BEDWARS_ENTRE_4_JOGADORES("BedWars Entre 4 Jogadores", false, "16/11/2024 - 00:39", 1, 67, 1),
    BERIMBAU("Berimbau", false, "04/08/2024 - 15:31", 1, 2, 1, "Beriumbau (Versão Brega)", "Beriumbau (Versão Brega 1)", "Berimbau (Versão Arrocha)", "Berimbau (Versão Arrocha 1)"),
    BLUSA_AMARELA("Blusa Amarela", false, "16/07/2024 - 16:52", 0, 67, 1),
    BODE("Bode", false, "25/07/2024 - 22:46", 0, 83, 0),
    BOM_DIA_A_TODOS("Bom Dia a Todos", false, "31/12/2024 - 12:34", 2, 31, 1),
    BOOMBOX_CAIR("Boombox Cair", false, "17/07/2024 - 00:40", 0, 70, 1),
    BOTA_PRA_DANCAR("Bota pra Dançar", false, "27/12/2024 - 01:27", 2, 12, 0),
    CACHORRO_QUENTE("Cachorro Quente", false, "05/09/2024 - 20:05", 1, 20, 3),
    CADE_VOCE_EDUARDA("Cadê Você Eduarda", false, "30/12/2024 - 18:26", 2, 30, 1),
    CALA_BOCA("CALA BOCA", false, "19/01/2025 - 17:05", 2, 56, 3),
    CALMA_GABRIEL("Calma Gabriel", false, "30/12/2024 - 16:54", 2, 27, 1),
    CENAS("Cenas", false, "29/10/2024 - 00:53", 1, 56, 3),
    CHEGOU_O_REMEDIO("Chegou o Remédio", false, "02/01/2025 - 11:12", 2, 41, 1, "Chegou o Remédio (Versão Reggae)", "Chegou o Remédio (Versão Reggae 1)", "Chegou o Remédio (Versão Arrocha)", "Chegou o Remédio (Versão Arrocha 1)", "Chegou o Remédio (Versão Pop)", "Chegou o Remédio (Versão Metal)", "Chegou o Remédio (Versão Metal 1)"),
    CHILL("Chill", false, "07/09/2024 - 08:27", 1, 22, 1),
    CHUVINHA_AMIZADE("Chuvinha Amizade", false, "15/07/2024 - 13:23", 0, 64, 1),
    COCO("Cocô", false, "22/09/2024 - 11:30", 1, 34, 1),
    COISAS_NO_APARTAMENTO("Coisas no Apartamento", false, "12/11/2024 - 10:28", 1, 60, 1),
    COME_EDUARDA("Come Eduarda", false, "13/01/2025 - 10:36", 2, 53, 2),
    COMIDAS_GOSTOSINHAS("Comidas Gostosinhas", false, "04/07/2024 - 14:06", 0, 51, 1),
    CSGO("CSGO", false, "04/04/2025 - 05:04", 2, 89, 1),
    DEITADOS("Deitados", false, "04/08/2024 - 17:05", 1, 3, 1, "Deitados Sofredor (Versão Metal)", "Deitados Sofredor (Versão Metal 1)", "Deitados Sofredor (Versão Metal 2)", "Deitados Sofredor (Versão Metal 3)"),
    DESENHA_EDUARDA("Desenha, Eduarda", false, "17/07/2024 - 00:47", 0, 71, 1),
    DESILUSAO_NO_FORRO("Desilusão no Forró", false, "19/07/2024 - 23:45", 0, 77, 3),
    DESPERTAR_INCANSAVEL("Despertar Incansavel", false, "18/07/2024 - 19:25", 0, 74, 1),
    DISPUTA_NO_MUSHMC("Disputa no MushMC", false, "08/11/2024 - 00:38", 1, 59, 1),
    DIVERSAO_NO_MUSH("Diversão no Mush", false, "24/04/2024 - 12:46", 0, 2, 0),
    DIARIO_DE_LUCAS("Diário de Lucas", false, "30/09/2024 - 17:20", 1, 43, 1),
    DOCES_DE_JULIANA("Doces de Juliana", false, "29/05/2024 - 13:01", 0, 20, 1),
    DOMINIOS_DIGITAIS("Domínios Digitais", false, "05/05/2024 - 01:55", 0, 10, 0),
    DONO_DO_PODER("Dono do Poder", false, "05/05/2024 - 01:58", 0, 11, 0),
    DOR_DE_BARRIGA("Dor de Barriga", false, "09/02/2025 - 16:24", 2, 69, 1),
    EDUARDA_INSPIRADA("Eduarda Inspirada", false, "17/07/2024 - 01:17", 0, 73, 1),
    EDUARDA_NA_FAVELA("Eduarda na Favela", false, "03/11/2024 - 00:50", 1, 58, 1),
    EDUARDA("Eduarda", false, "13/06/2024 - 20:02", 0, 31, 1, "Eduarda (Versão Alternativa)", "Eduarda (Versão Forró)", "Eduarda (Versão Infantil)", "Eduarda (Versão Pagode)", "Eduarda (Versão Piano Calmo)", "Eduarda (Versão Piano)", "Eduarda (Versão Reggae)", "Eduarda (Versão Alternativa 2)", "Eduarda (Versão Forró 2)", "Eduarda (Versão Pagode 2)", "Eduarda (Versão Piano 1)", "Eduarda (Versão Piano 2)", "Eduarda (Versão Espanhol)", "Eduarda (Versão Espanhol 1)", "Eduarda (Versão Rock Clássico)", "Eduarda (Versão Arrocha)", "Eduarda (Versão Arrocha 1)"),
    ELA_E_GATINHA("Ela é Gatinha", false, "15/06/2025 - 12:21", 3, 14, 1, "Ela é Gatinha (Versão Brega)", "Ela é Gatinha (Versão Reggae)", "Ela é Gatinha (Versão Metal)", "Ela é Gatinha (Versão Brega 1)", "Ela é Gatinha (Versão Reggae 1)", "Ela é Gatinha (Versão Metal 1)"),
    ELE_E_O_GABRIEL("Ele é o Gabriel", false, "01/01/2025 - 14:55", 2, 37, 1),
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
    GALERA_DO_MARIAUM("Galera do Mariaum", false, "15/12/2025 - 12:55", 2, 76, 0, "Galera do Mariaum (Versão Reggae)", "Galera do Mariaum (Versão Reggae 1)", "Galera do Mariaum (Versão Metal)", "Galera do Mariaum (Versão Metal 1)", "Galera do Mariaum (Versão Piseiro)", "Galera do Mariaum (Versão Piseiro 1)", "Galera do Mariaum (Versão Piseiro 2)", "Galera do Mariaum (Versão Piseiro 3)", "Galera do Mariaum (Versão Alternativa)", "Galera do Mariaum (Versão Alternativa 1)"),
    GAROTAS_PALHACO("Garotas Palhaço", false, "26/02/2025 - 23:18", 2, 82, 5),
    GIGANTES_DO_FORROZAO("Gigantes do Forrozão", false, "07/05/2024 - 16:52", 0, 14, 1),
    GOSTOSINHO("Gostosinho", false, "19/07/2025 - 23:44", 3, 18, 4),
    GRANDE_ENIGMA("Grande Enigma", false, "02/08/2024 - 17:49", 1, 1, 1),
    HIPER_CINEMATIC("Hiper Cinematic", false, "04/07/2024 - 12:46", 0, 48, 1),
    HOMENAGEM_A_MINHA_VO("Homenagem a minha vó", false, "04/09/2024 - 17:45", 1, 19, 1),
    HORROR_PIANO("Horror Piano", false, "04/06/2025 - 13:40", 3, 8, 1),
    INTRO_NA_CHAMADA("Intro na Chamada", false, "20/11/2024 - 18:28", 2, 1, 15),
    IVR("IVR", false, "09/06/2025 - 23:23", 3, 13, 7),
    JAVA_CODING("Java Coding", false, "22/01/2025 - 22:00", 2, 57, 1),
    JINGLE_DAS_GATINHAS("Jingle das Gatinhas", false, "19/06/2024 - 00:33", 0, 35, 0, "Jingle das Gatinhas (Versão Metal)"),
    JOAO_BRENO_E_O_LEGO("João Breno e o Lego", false, "15/09/2024 - 12:29", 1, 29, 1),
    JOSE("José", false, "22/02/2025 - 12:46", 2, 78, 1),
    KIRITO("Kirito", false, "31/08/2024 - 01:30", 1, 12, 1),
    LENON_NO_MICROFONE("Lenon no Microfone", false, "27/12/2024 - 01:30", 2, 13, 0),
    LINDA_EDUARDA("Linda Eduarda", false, "29/12/2024 - 22:11", 2, 25, 1),
    LIVE_DE_MINE("Live de Mine", false, "09/01/2025 - 19:30", 2, 50, 3),
    LOJA_PARA_HYAN("Loja para Hyan", false, "12/02/2025 - 19:45", 2, 73, 3),
    LUCA_PROIBIDO("Luca Proibido", false, "02/02/2025 - 23:26", 2, 63, 1),
    LUCAS_DORMINHOCO("Lucas Dorminhoco", false, "08/09/2024 - 12:45", 1, 24, 5),
    LUCAS_FAZENDO_COCO("Lucas Fazendo Cocô", false, "12/01/2025 - 02:53", 2, 52, 1),
    LUCAS_NO_VOLANTE("Lucas no Volante", false, "11/05/2025 - 17:27", 3, 4, 5),
    LUCAS("Lucas", false, "30/12/2024 - 17:08", 2, 28, 1),
    LUCIVANIA("Lucivania", false, "01/01/2025 - 19:42", 2, 39, 1),
    MAJOR_SABINO("Major Sabino", false, "22/08/2024 - 22:03", 1, 8, 6, "Major Sabino (Versão Gospel)", "Major Sabino (Versão Metal)", "Major Sabino (Versão Gospel 1)", "Major Sabino (Versão Metal 1)", "Major Sabino (Versão Metal 2)", "Major Sabino (Versão Metal 3)"),
    MANHA_DE_METAL("Manhã de Metal", false, "15/05/2024 - 08:58", 0, 16, 0),
    MARIA_EDUARDA_NO_FORRO("Maria Eduarda No Forró", false, "11/08/2024 - 18:51", 1, 6, 1),
    MARIA_EDUARDA("Maria Eduarda", false, "09/02/2025 - 16:45", 2, 70, 1),
    MARIAUM("Mariaum", false, "15/02/2025 - 12:48", 2, 75, 0),
    MC_HARIEL_PARA_SAFIRA("MC Hariel para Safira", false, "18/05/2024 - 18:17", 0, 19, 1),
    MCGPLAYS_PARA_VINICIUS("MCGPlays para Vinicius", false, "06/06/2024 - 09:26", 0, 24, 0),
    MENSAGENS("Mensagens", false, "27/10/2024 - 04:54", 1, 55, 5),
    MEU_SONHO_DO_DIA_2("Meu Sonho do Dia 2", false, "02/01/2025 - 11:19", 2, 42, 3),
    MISSOES_PARA_HYAN("Missões para Hyan", false, "05/12/2024 - 20:20", 2, 8, 3),
    MOUNTAIN_PATH("Mountain Path", false, "06/06/2025 - 22:40", 3, 10, 1, "Mountain Path (Versão Metal)", "Mountain Path (Versão Arrocha)", "Mountain Path (Versão Piseiro)", "Mountain Path (Versão Espacial)", "Mountain Path (Versão Harpa)", "Mountain Path (Versão Violino)", "Mountain Path (Versão Metal 1)", "Mountain Path (Versão Metal 2)", "Mountain Path (Versão Metal 3)", "Mountain Path (Versão Piseiro 1)", "Mountain Path (Versão Arrocha 1)", "Mountain Path (Versão Espacial 1)"),
    MUSHMC("MushMC", false, "10/02/2025 - 19:11", 2, 71, 1),
    MUSICA_PARA_CAGAR("Música para Cagar", false, "04/07/2024 - 20:58", 0, 52, 5),
    NAO_SABE_PULAR("Não Sabe Pular", false, "24/02/2025 - 11:48", 2, 80, 7),
    NATUREZA("Natureza", false, "21/10/2024 - 02:23", 1, 51, 7),
    NAYARA("Nayara", false, "22/07/2024 - 02:52", 0, 79, 1),
    NOITE_PALIDA("Noite Pálida", false, "16/03/2025 - 06:37", 2, 88, 1),
    NOSSO_RELACIONAMENTO("Nosso Relacionamento", false, "14/11/2024 - 18:48", 1, 66, 1),
    NOVOS_SERVIDORES("Novos Servidores", false, "09/04/2025 - 06:30", 2, 91, 1),
    O_AMOR_DE_EDUARDA_PELO_COCO("O Amor de Eduarda Pelo Cocô", false, "22/09/2024 - 11:33", 1, 35, 0),
    O_DONO_DO_SERVIDOR("O Dono do Servidor", false, "01/06/2024 - 19:54", 0, 22, 0),
    O_DUMP_DO_MYSQL("O Dump do MySQL", false, "14/05/2024 - 00:53", 0, 15, 2),
    O_MARIAUM("O Mariaum", false, "20/10/2024 - 21:37", 1, 48, 1, "O Mariaum (Versão Mariaum)"),
    OI_RAFAEL("Oi Rafael", false, "20/07/2025 - 14:47", 3, 19, 6),
    OLHANDO_PARA_O_LADO("Olhando para o Lado", false, "10/07/2024 - 17:29", 0, 57, 1),
    OPRESSOR_DEPRECIADOR("Opressor Depreciador", false, "06/08/2025 - 03:53", 3, 20, 6),
    OURO_BRANCO_PARA_LUCAS("Ouro Branco para Lucas", false, "17/11/2024 - 07:42", 1, 70, 3),
    PALAVRAS_GUARDADAS("Palavras Guardadas", false, "30/06/2024 - 19:46", 0, 44, 1),
    PANDA("Panda", false, "09/04/2025 - 05:16", 2, 90, 1),
    PARABENS_ANA("Parabéns Ana", false, "20/02/2025 - 01:10", 2, 77, 4, "Parabéns Ana (Versão Metal)", "Parabéns Ana (Versão Metal 1)"),
    PARABENS_DE_KOS("Parabéns de Kos", false, "06/03/2025 - 00:23", 2, 84, 1),
    PARABENS_KOS("Parabéns Kos", false, "12/03/2025 - 16:42", 2, 86, 3),
    PARABENS_MARIAUM("Parabéns Mariaum", false, "11/10/2024 - 20:39", 1, 46, 3, "Parabéns Mariaum (Versão Mariaum)"),
    PEDIDO_DE_MASCARA("Pedido de Máscara", false, "11/07/2024 - 14:16", 0, 61, 3),
    PERFEITA("Perfeita", false, "02/12/2024 - 23:48", 2, 7, 1),
    PESSOA_ACIMA("Pessoa Acima", false, "08/01/2025 - 17:47", 2, 49, 3),
    PLUGIN_DE_REPORT("Plugin de Report", false, "23/10/2024 - 21:08", 1, 54, 0),
    POMBO("Pombo", false, "09/09/2024 - 18:26", 1, 27, 1),
    PORTUGUES("Português", false, "24/02/2025 - 15:13", 2, 81, 1),
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
    SAFIRA_VS_EDUARDA("Safira vs Eduarda", false, "23/07/2024 - 02:20", 0, 80, 9, "Safira vs Eduarda (Versão Funk)", "Safira vs Eduarda (Versão Metal)", "Safira vs Eduarda (Versão Minimalista)", "Safira vs Eduarda (Versão Pagode)", "Safira vs Eduarda (Versão Piano)", "Safira vs Eduarda (Versão Metal 1)", "Safira vs Eduarda (Versão Metal 2)", "Safira vs Eduarda (Versão Metal 3)", "Safira vs Eduarda (Versão Pagode 1)", "Safira vs Eduarda (Versão Reggae)", "Safira vs Eduarda (Versão Reggae 1)", "Safira vs Eduarda (Versão Salsa)", "Safira vs Eduarda (Versão Salsa 1)", "Safira vs Eduarda (Versão Pop)", "Safira vs Eduarda (Versão Arrocha)", "Safira vs Eduarda (Versão Arrocha 1)", "Safira vs Eduarda (Versão Arrocha 2)", "Safira vs Eduarda (Versão Alternativa)"),
    SAFIRA("Safira", false, "03/01/2025 - 18:27", 2, 47, 2),
    SARAIVA("Saraiva", false, "09/02/2025 - 15:05", 2, 68, 11, "Saraiva (Versão Reggae)", "Saraiva (Versão Reggae 1)", "Saraiva (Versão Rock)", "Saraiva (Versão Rock 1)", "Saraiva (Versão Metal)", "Saraiva (Versão Metal 1)"),
    SETE_NA_CHAMADA("Sete na Chamada", false, "06/12/2024 - 21:57", 2, 9, 3, "Sete na Chamada (Versão Metal)", "Sete na Chamada (Versão Metal 1)"),
    SHOW_DE_COMEDIA("Show de Comédia", false, "31/08/2024 - 20:26", 1, 17, 2),
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
    TEXTAO_EM_PIANO("Textão em Piano", false, "10/07/2024 - 22:53", 0, 60, 1),
    TEXTAO_EM_SERTANEJO("Textão em Sertanejo", false, "10/07/2024 - 22:52", 0, 59, 1),
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
    VAI_IGUATU("VAI IGUATU", false, "29/01/2025 - 21:10", 2, 61, 8, "VAI IGUATU (Versão Hino)", "VAI IGUATU (Versão Hino 1)"),
    VAI_KAMILA("Vai Kamila", false, "30/01/2025 - 20:20", 2, 62, 1),
    VAMOS_DANCAR_FORRO("Vamos Dançar Forró", false, "26/01/2025 - 15:09", 2, 58, 1),
    VAMOS_LUCAS("Vamos Lucas", false, "06/09/2024 - 11:54", 1, 21, 3),
    VEM_PRO_MEU_CORACAO("Vem Pro Meu Coração", false, "05/10/2024 - 19:28", 1, 44, 1),
    VIBRACOES_DA_RUA("Vibrações da Rua", false, "07/05/2024 - 09:31", 0, 12, 0),
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
            default -> "Revolução Sonora";
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
                    lines.add("§f" + line);
                }
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

}
