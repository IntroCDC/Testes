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
    A_PROPOSTA("A Proposta", true, "23/05/2025 - 00:20", 3, 5, 3, new String[]{"v4.5", "forró piseiro", "mariaum", "letra ia"}, new String[]{"A Proposta (Versão Mariaum)", "A Proposta (Versão Maraio)", "A Proposta (Versão Nórdica)"}, new String[]{"A Proposta (Versão Nórdica 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Percussion", "Synth"}),
    AGUINHA_GELADINHA("Aguinha Geladinha", true, "16/07/2024 - 16:38", 0, 66, 1, new String[]{"v3.5", "metal", "1 verso", "letra original"}, new String[]{"Aguinha Geladinha (Versão Piano)", "Aguinha Geladinha (Versão Vozes do Inferno)", "Aguinha Geladinha (vs Aguinha Quentinha)"}, new String[]{"Aguinha Geladinha (vs Aguinha Quentinha 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    AGUINHA_GELADINHA_VERSAO_PISEIRO("Aguinha Geladinha (Versão Piseiro)", true, "20/09/2024 - 18:50", 1, 33, 0, new String[]{"v3.5", "forró piseiro", "1 verso", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Keyboard", "Synth"}),
    AGUINHA_QUENTINHA("Aguinha Quentinha", true, "12/11/2024 - 17:34", 1, 64, 15, new String[]{"v3.5", "sertanejo", "1 verso", "explícita", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Keyboard"}),
    ALEXA_COM_RAIVA("Alexa com Raiva", true, "21/10/2024 - 01:26", 1, 49, 4, new String[]{"v3.5", "rap", "jovem dinâmico", "explícita", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Percussion", "Synth", "FX"}),
    ASTACARABUMTS("Astacarábumts", true, "19/06/2024 - 00:07", 0, 34, 3, new String[]{"v3.5", "dubstep", "piada interna", "explícita"}, new String[]{"Astacarábumts (Bass Boost)", "Astacarábumts (Versão Piseiro)", "Astacarábumts (Versão DJ)"}, new String[]{"Astacarábumts (Versão Piseiro 1)", "Astacarábumts (Versão DJ 1)"}, new String[]{"Drums", "Bass"}),
    ARROCHA_DAS_GATINHAS("Arrocha das Gatinhas", true, "08/06/2025 - 08:55", 3, 11, 3, new String[]{"v4.5", "arrocha", "gatinhas", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Percussion", "Synth"}),
    ARROCHA_DO_JOVEM_DINAMICO("Arrocha do Jovem Dinâmico", true, "08/02/2025 - 19:23", 2, 66, 5, new String[]{"v4", "metal", "jovem dinâmico", "explícita", "letra original", "escatológica"}, new String[]{"Arrocha do Jovem Dinâmico (Versão Arrocha)", "Arrocha do Jovem Dinâmico (Versão Piseiro)", "Arrocha do Jovem Dinâmico (Versão Censurada)", "Arrocha do Jovem Dinâmico (Versão Brega)", "Arrocha do Jovem Dinâmico (Versão Nórdica)"}, new String[]{"Arrocha do Jovem Dinâmico (Versão Brega 1)", "Arrocha do Jovem Dinâmico (Versão Brega 2)", "Arrocha do Jovem Dinâmico (Versão Brega 3)", "Arrocha do Jovem Dinâmico (Versão Nórdica 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    ARROCHA_DO_MARIAUM("Arrocha do Mariaum", true, "03/06/2025 - 05:14", 3, 6, 1, new String[]{"v4.5", "arrocha", "mariaum", "bruno", "severo", "letra original"}, new String[]{"Arrocha do Mariaum (Versão Mariaum)", "Arrocha do Mariaum (Versão Brega)", "Arrocha do Mariaum (Versão Metal)", "Arrocha do Mariaum (Versão Nórdica)", "Arrocha do Mariaum (Versão Maraio)", "Arrocha do Mariaum (Versão 8 Bit)", "Arrocha do Mariaum (Versão Alternativa)"}, new String[]{"Arrocha do Mariaum (Versão Brega 1)", "Arrocha do Mariaum (Versão Metal 1)", "Arrocha do Mariaum (Versão Metal 2)", "Arrocha do Mariaum (Versão Metal 3)", "Arrocha do Mariaum (Versão Metal 4)", "Arrocha do Mariaum (Versão Metal 5)", "Arrocha do Mariaum (Versão Nórdica 1)", "Arrocha do Mariaum (Versão 8 Bit 1)", "Arrocha do Mariaum (Versão Alternativa 1)", "Arrocha do Mariaum (Versão Alternativa 2)", "Arrocha do Mariaum (Versão Alternativa 3)"}, new String[]{"Vocals", "Drums", "Bass", "Percussion", "Synth", "Woodlands"}),
    ATRAPALHADOR("Atrapalhador", true, "04/07/2024 - 13:33", 0, 50, 2, new String[]{"v3.5", "rock", "jovem dinâmico", "rima", "letra original", "escatológica"}, new String[]{"Atrapalhador (Versão Piano)", "Atrapalhador (Versão Nórdica)", "Atrapalhador (Versão Pagode)", "Atrapalhador (Versão Arrocha)"}, new String[]{"Atrapalhador (Versão Piano 1)", "Atrapalhador (Versão Piano 2)", "Atrapalhador (Versão Nórdica 1)", "Atrapalhador (Versão Pagode 1)", "Atrapalhador (Versão Arrocha 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    ATRAPALHADOR_VERSAO_PISEIRO("Atrapalhador (Versão Piseiro)", true, "19/09/2024 - 13:28", 1, 32, 0, new String[]{"v3.5", "forró piseiro", "jovem dinâmico", "rima", "letra original", "escatológica"}, new String[]{}, new String[]{"Atrapalhador (Versão Piseiro 1)"}, new String[]{"Vocals", "Drums", "Bass", "Percussion", "Synth"}),
    AVENTURA_NO_MUNDO_DE_BLOCOS("Aventura no Mundo de Blocos", true, "19/10/2024 - 20:33", 1, 47, 1, new String[]{"v3.5", "piano", "instrumental"}, new String[]{}, new String[]{}, new String[]{"Piano"}),
    BERIMBAU("Berimbau", true, "04/08/2024 - 15:31", 1, 2, 1, new String[]{"v3.5", "pagode", "1 verso", "explícita", "lucas moreira"}, new String[]{"Berimbau (Versão Brega)", "Berimbau (Versão Arrocha)", "Berimbau (Versão Funk)", "Berimbau (Versão Technobrega)"}, new String[]{"Berimbau (Versão Brega 1)", "Berimbau (Versão Arrocha 1)", "Berimbau (Versão Funk 1)", "Berimbau (Versão Funk 2)", "Berimbau (Versão Funk 3)", "Berimbau (Versão Technobrega 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth"}),
    CAGADA_NERVOSA("Cagada Nervosa", true, "21/10/2024 - 01:59", 1, 50, 7, new String[]{"v3.5", "pop", "vídeo do canal", "explícita", "escatológica"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Synth"}),
    CLAUDINHO("Claudinho", true, "11/01/2025 - 10:38", 2, 51, 3, new String[]{"v4", "forró piseiro", "lenon", "letra original"}, new String[]{"Claudinho (Versão Metal)"}, new String[]{"Claudinho (Versão Metal 1)"}, new String[]{"Vocals", "Drums", "Bass", "Keyboard", "Synth", "FX"}),
    COCO_NA_ARARIUS("Cocô na Arariús", true, "04/07/2024 - 12:32", 0, 47, 1, new String[]{"v3.5", "rock", "1 verso", "cd antigo", "explícita", "escatológica"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    COMENTARIOS("Comentários", true, "05/07/2024 - 12:58", 0, 53, 0, new String[]{"v3.5", "rock", "piada interna"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    COMIDA_GOSTOSA("Comida Gostosa", true, "18/06/2024 - 10:48", 0, 33, 1, new String[]{"v3.5", "pagode", "1 verso", "letra original", "escatológica"}, new String[]{}, new String[]{"Comida Gostosa (Versão Metal 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth", "Brass"}),
    COMIDA_GOSTOSA_VERSAO_METAL("Comida Gostosa (Versão Metal)", true, "19/09/2024 - 12:16", 1, 31, 0, new String[]{"v3.5", "metal", "1 verso", "letra original", "escatológica"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    CORRE_PRA_PRAIA("Corre pra Praia", true, "16/07/2024 - 22:30", 0, 69, 1, new String[]{"v3.5", "pagode", "1 verso", "letra original", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "FX", "Brass"}),
    DARKNESS("Darkness", true, "23/09/2025 - 23:29", 3, 25, 5, new String[]{"v5", "metal", "explícita", "introbase64", "letra original", "desabafo"}, new String[]{"Darkness (Versão Nórdica)"}, new String[]{"Darkness (Versão Nórdica 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth", "FX"}),
    DESCOLADINHO("Descoladinho", true, "19/06/2024 - 02:43", 0, 37, 0, new String[]{"v3.5", "pagode", "jovem dinâmico", "bruno", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Bass", "Keyboard", "Brass"}),
    DESTROY_EVERYTHING("Destroy Everything", true, "26/01/2025 - 22:11", 2, 59, 3, new String[]{"v4", "piano", "instrumental"}, new String[]{"Destroy Everything (Versão Nórdica)", "Destroy Everything (Versão Metal)"}, new String[]{"Destroy Everything (Versão Nórdica 1)", "Destroy Everything (Versão Metal 1)"}, new String[]{"Drums", "Bass", "Keyboard", "Strings", "Synth", "FX"}),
    DIX_TRACK_DETRAN("Dix Track Detran", true, "04/07/2024 - 12:03", 0, 46, 1, new String[]{"v3.5", "rock", "1 verso", "explícita", "letra original", "jovem dinâmico"}, new String[]{"Dix Track Detran (Versão Nórdica)"}, new String[]{"Dix Track Detran (Versão Piseiro 1)", "Dix Track Detran (Versão Piseiro 2)", "Dix Track Detran (Versão Nórdica 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    DIX_TRACK_DETRAN_VERSAO_PISEIRO("Dix Track Detran (Versão Piseiro)", true, "29/09/2024 - 23:50", 1, 42, 0, new String[]{"v3.5", "forró piseiro", "1 verso", "explícita", "letra original", "jovem dinâmico"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Keyboard", "Synth", "Brass"}),
    DOIDAO("Doidão", true, "22/10/2024 - 23:09", 1, 52, 10, new String[]{"v3.5", "reggae", "letra original", "mariaum", "rima"}, new String[]{"Doidão (Versão Metal)", "Doidão (Versão Mariaum)"}, new String[]{"Doidão (Versão Metal 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "FX"}),
    ENGRACADINHO("Engraçadinho", true, "25/06/2024 - 02:55", 0, 42, 1, new String[]{"v3.5", "pagode", "jovem dinâmico", "letra original", "escatológica"}, new String[]{"Engraçadinho (Versão Alternativa)", "Engraçadinho (Versão Funk)", "Engraçadinho (Versão Metal)", "Engraçadinho (Versão Piseiro)", "Engraçadinho (Versão Pop)", "Engraçadinho (Versão Arrocha)", "Engraçadinho (Versão Brega)"}, new String[]{"Engraçadinho (Versão Metal 1)", "Engraçadinho (Versão Metal 2)", "Engraçadinho (Versão Metal 3)", "Engraçadinho (Versão Piseiro 1)", "Engraçadinho (Versão Arrocha 1)", "Engraçadinho (Versão Brega 1)"}, new String[]{"Vocals", "Drums", "Bass", "Keyboard", "Synth", "Brass"}),
    ENGRACADAO("ENGRAÇADÃO", true, "25/09/2024 - 14:44", 1, 37, 19, new String[]{"v3.5", "metal", "explícita", "referência externa", "escatológica"}, new String[]{"ENGRAÇADÃO (Versão Pop)", "ENGRAÇADÃO (Versão Reggae)", "ENGRAÇADÃO (Versão Épica)", "ENGRAÇADÃO (Versão Arrocha)", "ENGRAÇADÃO (Versão Nórdica)", "ENGRAÇADÃO (Versão Pagode)", "ENGRAÇADÃO (vs Engraçadinho)", "ENGRAÇADÃO (Versão Lo-Fi)"}, new String[]{"ENGRAÇADÃO (Versão Épica 1)", "ENGRAÇADÃO (Remastered 1)", "ENGRAÇADÃO (Versão Arrocha 1)", "ENGRAÇADÃO (Versão Nórdica 1)", "ENGRAÇADÃO (Versão Pagode 1)", "ENGRAÇADÃO (vs Engraçadinho 1)", "ENGRAÇADÃO (Versão Lo-Fi 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    ENGRACADAO_VERSAO_PISEIRO("ENGRAÇADÃO (Versão Piseiro)", true, "25/09/2024 - 15:00", 1, 38, 0, new String[]{"v3.5", "forró piseiro", "explícita", "referência externa", "escatológica"}, new String[]{}, new String[]{"ENGRAÇADÃO (Versão Piseiro) (Remastered 1)", "ENGRAÇADÃO (Versão Piseiro) (Remastered 2)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Percussion", "Synth", "FX"}),
    ENTRADA_SEVERA("Entrada Severa", true, "09/05/2025 - 20:03", 3, 2, 1, new String[]{"v4.5", "metal", "severo", "discord", "letra original", "1 verso"}, new String[]{"Entrada Severa (Versão Pop)", "Entrada Severa (Versão Pagode)", "Entrada Severa (Versão Nórdica)", "Entrada Severa (Versão Curta)"}, new String[]{"Entrada Severa (Versão Pop 1)", "Entrada Severa (Versão Pagode 1)", "Entrada Severa (Versão Nórdica 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar"}),
    FELICIDADE("Felicidade", true, "22/02/2025 - 16:23", 2, 79, 1, new String[]{"v4", "reggae", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Percussion", "Synth"}),
    FOME_DINAMICA("Fome Dinâmica", true, "04/12/2025 - 13:21", 3, 33, 3, new String[]{"v5", "pagode", "jovem dinâmico", "escatológica", "letra original"}, new String[]{"Fome Dinâmica (Versão Nórdica)"}, new String[]{"Fome Dinâmica (Versão Nórdica 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Keyboard", "FX", "Brass"}),
    GALOPA_PRO_KINDOME("Galopa pro Kindome", true, "09/05/2025 - 21:09", 3, 3, 1, new String[]{"v4.5", "forró piseiro", "mariaum", "kindome", "letra ia"}, new String[]{"Galopa pro Kindome (Versão Mariaum)", "Galopa pro Kindome (Versão Maraio)", "Galopa pro Kindome (vs Primeiro de Abril)"}, new String[]{"Galopa pro Kindome (vs Primeiro de Abril 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Keyboard", "Synth", "FX", "Brass"}),
    GOSTO_DE_COCO("Gosto de Cocô", true, "16/11/2024 - 14:05", 1, 69, 9, new String[]{"v3.5", "8 bit", "jovem dinâmico", "1 verso", "letra original", "escatológica"}, new String[]{"Gosto de Cocô (Versão Metal)"}, new String[]{"Gosto de Cocô (Versão Metal 1)"}, new String[]{"Vocals", "Drums", "Bass", "Percussion", "Synth", "FX"}),
    HACKINGS("Hackings", true, "29/08/2024 - 01:33", 1, 10, 2, new String[]{"v3.5", "metal", "vídeo do canal", "explícita"}, new String[]{"Hackings (Versão Piseiro)"}, new String[]{"Hackings (Versão Piseiro 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    HA_UM_POTO("Há Um Potó", true, "27/04/2024 - 01:26", 0, 7, 3, new String[]{"v3", "sertanejo", "vídeo do canal"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    IMBATIVEL_MATHEUS("Imbatível Matheus", true, "15/09/2024 - 12:29", 1, 28, 3, new String[]{"v3", "rock", "letra ia", "matheus", "joão breno"}, new String[]{"Imbatível Matheus (Versão Arrocha)"}, new String[]{"Imbatível Matheus (Versão Arrocha 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Synth", "FX"}),
    INTROBASE64("IntroBase64", true, "09/06/2024 - 06:39", 0, 29, 2, new String[]{"v3.5", "épica", "introbase64", "letra original", "vídeo do canal", "meel"}, new String[]{"IntroBase64 (Versão Metal)", "IntroBase64 (Versão Arrocha)", "IntroBase64 (Versão Nórdica)", "IntroBase64 (Versão 2015)"}, new String[]{"IntroBase64 (Versão Metal 1)", "IntroBase64 (Versão Metal 2)", "IntroBase64 (Versão Metal 3)", "IntroBase64 (Versão Metal 4)", "IntroBase64 (Versão Arrocha 1)", "IntroBase64 (Versão Nórdica 1)", "IntroBase64 (Versão 2015 1)", "IntroBase64 (Versão 2015 2)", "IntroBase64 (Versão 2015 3)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    INVOCACOES("Invocações", true, "08/06/2024 - 18:30", 0, 28, 0, new String[]{"v3.5", "rock", "jovem dinâmico", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    JOGOS_DO_MUSH("Jogos do Mush", true, "24/04/2024 - 12:46", 0, 1, 3, new String[]{"udio", "letra ia", "mariaum"}, new String[]{"Jogos do Mush (Versão Mariaum)", "Jogos do Mush (Versão Metal)", "Jogos do Mush (Versão Arrocha)", "Jogos do Mush (Versão Technobrega)", "Jogos do Mush (Versão Maraio)"}, new String[]{"Jogos do Mush (Versão Mariaum 1)", "Jogos do Mush (Versão Metal 1)", "Jogos do Mush (Versão Arrocha 1)", "Jogos do Mush (Versão Technobrega 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth", "FX"}),
    JOVEM_DINAMICO("Jovem Dinâmico", true, "27/04/2024 - 01:14", 0, 6, 9, new String[]{"v3", "rock", "jovem dinâmico", "letra original", "escatológica"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Percussion", "Synth"}),
    JUBARACACHUBA("Jubaracachuba", true, "20/06/2024 - 20:59", 0, 41, 3, new String[]{"v4", "metal", "letra original"}, new String[]{"Jubaracachuba (Versão Alternativa)"}, new String[]{"Jubaracachuba (Versão Alternativa 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    JUNIOR_CHATO("Junior Chato", true, "19/06/2024 - 03:07", 0, 38, 0, new String[]{"v3.5", "reggae", "cd antigo"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "FX", "Brass", "Woodwinds"}),
    KINDOME("Kindome", true, "31/08/2024 - 04:03", 1, 13, 3, new String[]{"v3.5", "vocaloid", "kindome", "letra ia"}, new String[]{"Kindome (Versão Piano)", "Kindome (Versão Technobrega)", "Kindome (Versão Arrocha)", "Kindome (Versão Nórdica)", "Kindome (Versão Pagode)"}, new String[]{"Kindome (Versão Piano 1)", "Kindome (Versão Technobrega 1)", "Kindome (Versão Arrocha 1)", "Kindome (Versão Nórdica 1)", "Kindome (Versão Pagode 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Percussion", "Synth", "FX"}),
    KIRITO_O_BODE("Kirito o Bode", true, "11/02/2025 - 00:58", 2, 72, 3, new String[]{"v4", "jazz", "kirito", "safira", "bruno", "letra ia"}, new String[]{"Kirito o Bode (Versão Kirito)", "Kirito o Bode (Versão Mariaum)", "Kirito o Bode (Versão Arrocha)", "Kirito o Bode (Versão Metal)", "Kirito o Bode (Versão Vocaloid)", "Kirito o Bode (Versão Maraio)"}, new String[]{"Kirito o Bode (Versão Arrocha 1)", "Kirito o Bode (Versão Metal 1)", "Kirito o Bode (Versão Vocaloid 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Keyboard", "Brass", "Woodwinds"}),
    LAGA_LAMA("Laga Lama", true, "26/04/2024 - 13:59", 0, 5, 3, new String[]{"v3", "rock", "letra original", "escatológica", "explícita"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar"}),
    LORENA("Lorena", true, "30/12/2024 - 18:01", 2, 29, 4, new String[]{"v4", "evangélica", "lorena", "letra original", "praia de iracema"}, new String[]{"Lorena (Versão Eletrônica)", "Lorena (Versão Funk)", "Lorena (Versão Opera)", "Lorena (Versão Piseiro)", "Lorena (Versão Rap)", "Lorena (Versão Reggae)", "Lorena (Versão Terror)", "Lorena (Versão Arrocha)", "Lorena (Versão Nórdica)"}, new String[]{"Lorena (Versão Arrocha 1)", "Lorena (Versão Nórdica 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Percussion", "Synth", "FX"}),
    MARIAUM_E_JAPONESA("Mariaum e Japonesa", true, "03/01/2025 - 14:51", 2, 46, 1, new String[]{"v4", "sertanejo", "mariaum", "letra ia"}, new String[]{"Mariaum e Japonesa (Versão Mariaum)", "Mariaum e Japonesa (Versão Funk)", "Mariaum e Japonesa (Versão K-Pop)", "Mariaum e Japonesa (Versão Metal)", "Mariaum e Japonesa (Versão Piano)", "Mariaum e Japonesa (Versão Reggae)", "Mariaum e Japonesa (Versão Salsa)", "Mariaum e Japonesa (Versão Brega)", "Mariaum e Japonesa (Versão Pagode)", "Mariaum e Japonesa (Versão Nórdica)", "Mariaum e Japonesa (Versão Maraio)", "Mariaum e Japonesa (Versão Japonesa)", "Mariaum e Japonesa (Versão Lo-Fi)"}, new String[]{"Mariaum e Japonesa (Versão K-Pop 1)", "Mariaum e Japonesa (Versão Metal 1)", "Mariaum e Japonesa (Versão Metal 2)", "Mariaum e Japonesa (Versão Piano 1)", "Mariaum e Japonesa (Versão Salsa 1)", "Mariaum e Japonesa (Versão Brega 1)", "Mariaum e Japonesa (Versão Pagode 1)", "Mariaum e Japonesa (Versão Nórdica 1)", "Mariaum e Japonesa (Versão Japonesa 1)", "Mariaum e Japonesa (Versão Lo-Fi 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Synth", "FX"}),
    MELO_DO_INTRO("Melo do Intro", true, "09/06/2025 - 06:47", 3, 12, 2, new String[]{"v4.5", "brega", "bruno", "piada interna", "letra paródia"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Percussion", "Synth", "FX"}),
    MENININHOS_ENGRACADINHOS("Menininhos Engraçadinhos", true, "18/06/2024 - 08:09", 0, 32, 3, new String[]{"v3.5", "pop", "jovem dinâmico", "letra original", "escatológica"}, new String[]{"Menininhos Engraçadinhos (Versão Alternativa)", "Menininhos Engraçadinhos (Versão Piano)", "Menininhos Engraçadinhos (Versão Piseiro)"}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth", "Brass"}),
    MENININHOS_ENGRACADINHOS_VERSAO_METAL("Menininhos Engraçadinhos (Versão Metal)", true, "19/09/2024 - 10:45", 1, 30, 0, new String[]{"v3.5", "metal", "jovem dinâmico", "letra original", "escatológica"}, new String[]{}, new String[]{"Menininhos Engraçadinhos (Versão Metal 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth", "FX", "Brass"}),
    MINEPARTY("MineParty", true, "19/06/2024 - 03:53", 0, 40, 3, new String[]{"v3.5", "rock", "kindome", "serjão", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Synth"}),
    MUITO_PESADO("Muito Pesado", true, "09/07/2024 - 14:16", 0, 55, 0, new String[]{"v3.5", "dubstep", "letra original", "piada interna"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass"}),
    MUSICA_EMPOLGANTE_E_IRRITANTE("Música Empolgante e Irritante", true, "25/07/2024 - 19:01", 0, 82, 1, new String[]{"v3.5", "pop", "roberta", "piada interna"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Synth"}),
    NAO_PODE_BEBER("Não Pode Beber", true, "29/12/2024 - 19:34", 2, 23, 1, new String[]{"v4", "reggae", "letra original", "escatológica"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth", "FX", "Brass"}),
    NOSSO_DJ("Nosso DJ", true, "19/06/2024 - 03:14", 0, 39, 1, new String[]{"v3.5", "dubstep", "cd antigo"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Synth", "FX"}),
    OBSESSOR_DEVORADOR("Obsessor Devorador", true, "06/10/2024 - 15:07", 1, 45, 5, new String[]{"v3.5", "rock", "jovem dinâmico", "letra original", "escatológica"}, new String[]{"Obsessor Devorador (Versão Arrocha)", "Obsessor Devorador (Versão Piseiro)"}, new String[]{"Obsessor Devorador (Versão Piseiro 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    OLD_BURNING_LOVE("Old Burning Love", true, "18/02/2025 - 14:58", 2, 76, 6, new String[]{"v4", "metal", "instrumental", "safira"}, new String[]{"Old Burning Love (Versão Arrocha)", "Old Burning Love (Versão Piano)", "Old Burning Love (Versão Nórdica)"}, new String[]{"Old Burning Love (Versão Arrocha 1)", "Old Burning Love (Versão Piano 1)", "Old Burning Love (Versão Nórdica 1)"}, new String[]{"Drums", "Bass", "Guitar", "Keyboard", "Synth", "FX"}),
    ONI_CHAN("Oni Chan", true, "03/01/2025 - 14:34", 2, 45, 1, new String[]{"v4", "vocaloid", "referência externa", "safira"}, new String[]{"Oni Chan (Versão Metal)", "Oni Chan (Versão Technobrega)", "Oni Chan (Versão Lofi)"}, new String[]{"Oni Chan (Versão Metal 1)", "Oni Chan (Versão Metal 2)", "Oni Chan (Versão Metal 3)", "Oni Chan (Versão Technobrega 1)", "Oni Chan (Versão Technobrega 2)", "Oni Chan (Versão Technobrega 3)", "Oni Chan (Versão Lofi 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Synth", "FX"}),
    OPRESSOR_DEPRECIADOR("Opressor Depreciador", true, "06/08/2025 - 03:53", 3, 20, 6, new String[]{"v4.5+", "metal", "jovem dinâmico", "letra original", "explícita"}, new String[]{"Opressor Depreciador (Versão Brega)", "Opressor Depreciador (Versão Nórdica)", "Opressor Depreciador (Versão Mariaum)", "Opressor Depreciador (vs Obsessor Devorador)"}, new String[]{"Opressor Depreciador (Versão Nórdica 1)", "Opressor Depreciador (vs Obsessor Devorador 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    PARABENS_GABRIEL("Parabéns Gabriel", true, "03/06/2025 - 22:19", 3, 7, 2, new String[]{"v4.5", "arrocha", "gabriel", "bruno", "eduarda", "letra original", "parabéns"}, new String[]{"Parabéns Gabriel (Versão Censurada)"}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Synth", "FX"}),
    PATINETE_ELETRICO("Patinete Elétrico", true, "19/06/2024 - 02:08", 0, 36, 5, new String[]{"v3.5", "rock", "letra original", "praia de iracema"}, new String[]{"Patinete Elétrico (Versão Arrocha)", "Patinete Elétrico (Versão Funk)", "Patinete Elétrico (Versão Romantica)", "Patinete Elétrico (Versão Alternativa)"}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    PATINETE_ELETRICO_VERSAO_PISEIRO("Patinete Elétrico (Versão Piseiro)", true, "27/09/2024 - 04:25", 1, 40, 0, new String[]{"v3.5", "forró piseiro", "letra original", "praia de iracema"}, new String[]{}, new String[]{"Patinete Elétrico (Versão Piseiro 1)", "Patinete Elétrico (Versão Piseiro 2)"}, new String[]{"Vocals", "Drums", "Bass", "Synth", "FX"}),
    PRIMEIRO_DE_ABRIL("Primeiro de Abril", true, "13/03/2025 - 03:53", 2, 87, 3, new String[]{"v4", "sertanejo", "mariaum", "letra ia"}, new String[]{"Primeiro de Abril (Versão Mariaum)", "Primeiro de Abril (Versão Metal)", "Primeiro de Abril (Versão Reggae)", "Primeiro de Abril (Versão Maraio)"}, new String[]{"Primeiro de Abril (Versão Metal 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "FX"}),
    RAFAEL_AULER_3_5("Rafael Auler 3.5", true, "07/06/2024 - 22:39", 0, 27, 0, new String[]{"v3.5", "rock", "rafael auler", "letra original", "piada interna"}, new String[]{"Rafael Auler 3.5 (Versão Reggae)", "Rafael Auler 3.5 (Versão Metal)", "Rafael Auler 3.5 (Versão Alternativa)", "Rafael Auler 3.5 (Versão Eletrônica)", "Rafael Auler 3.5 (Versão Pagode)", "Rafael Auler 3.5 (Versão Piano)", "Rafael Auler 3.5 (Versão Piseiro)", "Rafael Auler 3.5 (Versão Pop)", "Rafael Auler 3.5 (Versão Funk)", "Rafael Auler 3.5 (Versão Violão)", "Rafael Auler 3.5 (Versão Vegas)", "Rafael Auler 3.5 (Versão Miami)", "Rafael Auler 3.5 (Versão Evangélica)", "Rafael Auler 3.5 (Versão Seresta)", "Rafael Auler 3.5 (Versão Sofrência)", "Rafael Auler 3.5 (Versão Épica)", "Rafael Auler 3.5 (Versão Rafael)", "Rafael Auler 3.5 (Versão Brega)", "Rafael Auler 3.5 (Versão V5)", "Rafael Auler 3.5 (Versão Swingueira)", "Rafael Auler 3.5 (Versão Nórdica)", "Rafael Auler 3.5 (Versão Drift)", "Rafael Auler 3.5 (Versão Lo-Fi)"}, new String[]{"Rafael Auler 3.5 (Versão Pagode 1)", "Rafael Auler 3.5 (Versão Piano 1)", "Rafael Auler 3.5 (Versão Piseiro 1)", "Rafael Auler 3.5 (Versão Metal 1)", "Rafael Auler 3.5 (Versão Brega 1)", "Rafael Auler 3.5 (Versão V5 1)", "Rafael Auler 3.5 (Versão Swingueira 1)", "Rafael Auler 3.5 (Versão Nórdica 1)", "Rafael Auler 3.5 (Versão Drift 1)", "Rafael Auler 3.5 (Versão Lo-Fi 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    REI_DO_CEBOLITOS("Rei do Cebolitos", true, "03/05/2025 - 16:19", 3, 1, 1, new String[]{"v4.5", "sertanejo", "gabriel", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Percussion", "Synth", "FX"}),
    RITUAL_DAS_GATINHAS("Ritual das Gatinhas", true, "13/06/2024 - 06:33", 0, 30, 1, new String[]{"v3.5", "rock", "gatinhas", "letra original"}, new String[]{"Ritual das Gatinhas (Versão Piseiro)"}, new String[]{"Ritual das Gatinhas (Versão Piseiro 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    SANIDADE_MENTAL("Sanidade Mental", true, "27/09/2024 - 05:42", 1, 41, 15, new String[]{"v3.5", "metal", "explícita", "letra original", "desabafo"}, new String[]{"Sanidade Mental (Versão Piseiro)", "Sanidade Mental (Versão Seresta)", "Sanidade Mental (Versão Nórdica)"}, new String[]{"Sanidade Mental (Versão Nórdica 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth"}),
    SARAIVA("Saraiva", true, "09/02/2025 - 15:05", 2, 68, 11, new String[]{"v4", "forró piseiro", "saraiva", "luciano", "letra original"}, new String[]{"Saraiva (Versão Reggae)", "Saraiva (Versão Rock)", "Saraiva (Versão Metal)", "Saraiva (Versão Piano)", "Saraiva (Versão Arrocha)", "Saraiva (Versão Salsa)", "Saraiva (Versão Jazz)", "Saraiva (Versão Nórdica)"}, new String[]{"Saraiva (Versão Rock 1)", "Saraiva (Versão Reggae 1)", "Saraiva (Versão Metal 1)", "Saraiva (Versão Arrocha 1)", "Saraiva (Versão Salsa 1)", "Saraiva (Versão Jazz 1)", "Saraiva (Versão Nórdica 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Keyboard", "Synth", "FX"}),
    SOFREDOR("Sofredor", true, "28/08/2024 - 23:02", 1, 9, 8, new String[]{"v3.5", "evangélica", "jovem dinâmico", "letra original"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Keyboard", "Synth", "FX"}),
    SONO_DO_MARIAUM("Sono do Mariaum", true, "05/02/2025 - 03:28", 2, 65, 1, new String[]{"v4", "sono", "mariaum", "letra original"}, new String[]{"Sono do Mariaum (Versão Mariaum)", "Sono do Mariaum (Versão Maraio)"}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar"}),
    SR_DUVIDA("Sr Dúvida", true, "29/07/2024 - 06:44", 0, 85, 3, new String[]{"v3.5", "metal", "desabafo", "explícita", "letra original", "eduarda"}, new String[]{"Sr Dúvida (Versão Piseiro)"}, new String[]{"Sr Dúvida (Versão Piseiro 1)", "Sr Dúvida (Versão Piseiro 2)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    STAND_UP_DO_DIEGO("Stand UP do Diego", true, "04/09/2024 - 17:14", 1, 18, 2, new String[]{"v3.5", "pop", "letra original", "diegosvp"}, new String[]{"Stand UP do Diego (Versão Technobrega)", "Stand UP do Diego (Versão Metal)", "Stand UP do Diego (Versão Reggae)"}, new String[]{"Stand UP do Diego (Versão Technobrega 1)", "Stand UP do Diego (Versão Metal 1)", "Stand UP do Diego (Versão Reggae 1)"}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Percussion", "FX"}),
    STILL_WATER("Still Water", true, "01/11/2024 - 01:50", 1, 57, 1, new String[]{"v3.5", "piano", "instrumental", "referência externa"}, new String[]{"Still Water (Versão Salsa)", "Still Water (Versão Arrocha)", "Still Water (Versão Reggae)", "Still Water (Versão Metal)", "Still Water (Versão Espacial)", "Still Water (Versão Órgão)", "Still Water (Versão Nórdica)", "Still Water (Versão Pagode)", "Still Water (Versão 8 Bit)", "Still Water (Versão Brega)", "Still Water (Versão Violão)", "Still Water (Versão Violino)", "Still Water (Versão Maraio)", "Still Water (Versão Baixa)", "Still Water (Versão Estéreo)", "Still Water (Versão Phonk)", "Still Water (Versão Latina)", "Still Water (Versão Drill)", "Still Water (Versão Góspel)", "Still Water (Versão Lo-Fi)", "Still Water (Versão Drift)", "Still Water (Versão Trap)", "Still Water (Versão Cinemática)", "Still Water (Versão Death Metal)", "Still Water (vs The Impossible Nórdica)", "Still Water (vs The End Nórdica)"}, new String[]{"Still Water (Versão Salsa 1)", "Still Water (Versão Arrocha 1)", "Still Water (Versão Arrocha 2)", "Still Water (Versão Arrocha 3)", "Still Water (Versão Reggae 1)", "Still Water (Versão Metal 1)", "Still Water (Versão Metal 2)", "Still Water (Versão Metal 3)", "Still Water (Remastered 1)", "Still Water (Remastered 2)", "Still Water (Remastered 3)", "Still Water (Remastered 4)", "Still Water (Remastered 5)", "Still Water (Versão Espacial 1)", "Still Water (Versão Órgão 1)", "Still Water (Versão Nórdica 1)", "Still Water (Versão Nórdica 2)", "Still Water (Versão Pagode 1)", "Still Water (Versão 8 Bit 1)", "Still Water (Versão Brega 1)", "Still Water (Versão Violão 1)", "Still Water (Versão Violino 1)", "Still Water (Versão Baixa 1)", "Still Water (Versão Baixa 2)", "Still Water (Versão Phonk 1)", "Still Water (Versão Latina 1)", "Still Water (Versão Drill 1)", "Still Water (Versão Góspel 1)", "Still Water (Versão Lo-Fi 1)", "Still Water (Versão Drift 1)", "Still Water (Versão Trap 1)", "Still Water (Versão Cinemática 1)", "Still Water (Versão Death Metal 1)", "Still Water (Versão Death Metal 2)", "Still Water (Versão Death Metal 3)", "Still Water (vs The End Nórdica 1)"}, new String[]{"Drums", "Keyboard", "Synth"}),
    THE_IMPOSSIBLE("The Impossible", true, "15/02/2025 - 04:35", 2, 74, 5, new String[]{"v4", "piano", "instrumental", "kindome"}, new String[]{"The Impossible (Versão Orquestra)", "The Impossible (Versão Reggae)", "The Impossible (Versão Piseiro)", "The Impossible (Versão Patriota)", "The Impossible (Versão Funk)", "The Impossible (Versão Pop)", "The Impossible (Versão Órgão)", "The Impossible (Versão Nórdica)", "The Impossible (Versão Lo-Fi)", "The Impossible (Versão Drift)", "The Impossible (Versão Góspel)", "The Impossible (vs Still Water)", "The Impossible (vs Still Water Nórdica)"}, new String[]{"The Impossible (Versão Épica 1)", "The Impossible (Versão Épica 2)", "The Impossible (Versão Orquestra 1)", "The Impossible (Versão Piseiro 1)", "The Impossible (Versão Funk 1)", "The Impossible (Remastered 1)", "The Impossible (Remastered 2)", "The Impossible (Versão Órgão 1)", "The Impossible (Versão Órgão 2)", "The Impossible (Versão Nórdica 1)", "The Impossible (Versão Lo-Fi 1)", "The Impossible (Versão Drift 1)", "The Impossible (Versão Góspel 1)", "The Impossible (vs Still Water 1)"}, new String[]{"Keyboard", "Synth", "FX"}),
    THE_IMPOSSIBLE_VERSAO_METAL("The Impossible (Versão Metal)", true, "18/02/2025 - 12:30", 2, 75, 0, new String[]{"v4", "metal", "instrumental", "kindome"}, new String[]{}, new String[]{"The Impossible (Versão Metal 1)", "The Impossible (Versão Metal 2)", "The Impossible (Versão Metal 3)", "The Impossible (Versão Metal 4)", "The Impossible (Versão Metal 5)", "The Impossible (Versão Metal 6)"}, new String[]{"Drums", "Bass", "Guitar", "Keyboard", "Synth"}),
    TORNEIO_DE_YOUTUBERS("Torneio de YouTubers", true, "27/06/2025 - 17:48", 3, 17, 1, new String[]{"v4.5", "épica", "instrumental", "kindome"}, new String[]{"Torneio de YouTubers (Versão Metal)", "Torneio de YouTubers (Versão Arrocha)", "Torneio de YouTubers (Versão Reggae)", "Torneio de YouTubers (Versão Salsa)", "Torneio de YouTubers (Versão Nórdica)", "Torneio de YouTubers (Versão Lo-Fi)"}, new String[]{"Torneio de YouTubers (Versão Metal 1)", "Torneio de YouTubers (Versão Arrocha 1)", "Torneio de YouTubers (Versão Reggae 1)", "Torneio de YouTubers (Versão Salsa 1)", "Torneio de YouTubers (Versão Nórdica 1)", "Torneio de YouTubers (Versão Lo-Fi 1)"}, new String[]{"Drums", "Bass", "Keyboard", "Percussion", "Strings", "Synth", "FX"}),
    TRANSMISSAO_ESTATICA("Transmissão Estática", true, "06/06/2024 - 13:40", 0, 25, 1, new String[]{"v3", "metal", "letra ia"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),
    TRES_PATINHOS("Três Patinhos", true, "08/01/2025 - 17:37", 2, 48, 5, new String[]{"v3.5", "infantil", "explícita", "referência externa"}, new String[]{"Três Patinhos (Versão Arrocha)", "Três Patinhos (Versão Brega)"}, new String[]{"Três Patinhos (Versão Arrocha 1)", "Três Patinhos (Versão Brega 1)"}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Keyboard", "Synth"}),
    TUBARAO("Tubarão", true, "18/12/2024 - 16:08", 2, 11, 3, new String[]{"v4", "arrocha", "explícita", "letra original"}, new String[]{"Tubarão (Versão Metal)", "Tubarão (Versão Funk)", "Tubarão (Versão Calma)", "Tubarão (Versão Nórdica)"}, new String[]{"Tubarão (Versão Metal 1)", "Tubarão (Versão Metal 2)", "Tubarão (Versão Metal 3)", "Tubarão (Versão Funk 1)", "Tubarão (Versão Calma 1)", "Tubarão (Versão Nórdica 1)"}, new String[]{"Vocals", "Drums", "Bass", "Percussion", "FX"}),
    VOCE_FEZ_COCO("Você fez cocô", true, "26/04/2024 - 01:46", 0, 4, 3, new String[]{"v3", "rock", "cd antigo", "explícita", "escatológica"}, new String[]{}, new String[]{}, new String[]{"Vocals", "Backing Vocals", "Drums", "Bass", "Guitar", "Synth", "FX"}),

    // IA
    _8_BIT_PIANO("8 Bit Piano", false, "13/11/2024 - 21:49", 1, 65, 4, new String[]{"v3.5", "8 bit", "instrumental", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    A_PRAIA_E_O_COCO("A Praia e o Coco", false, "16/07/2024 - 10:39", 0, 65, 1, new String[]{"v3.5", "pop", "eduarda", "praia de iracema", "escatológica", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    A_SOPA_CHEGOU("A Sopa Chegou", false, "08/09/2024 - 17:06", 1, 26, 1, new String[]{"v3.5", "pop", "eduarda", "lucas moreira", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    A_VIAGEM_PRA_BENFICA("A Viagem pra Benfica", false, "23/11/2024 - 19:43", 2, 3, 1, new String[]{"v4", "sertanejo", "eduarda", "mariana", "greice", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    ACEITA_UBER("Aceita Uber", false, "15/04/2026 - 19:38", 3, 47, 2, new String[]{"v5.5", "pop", "infantil", "heavy metal", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    ACORDA_E_LUNCH("Acorda e Lunch", false, "29/06/2024 - 13:02", 0, 43, 1, new String[]{"v3.5", "pop", "lenon", "bruno", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    ACORDA_GABRIEL("Acorda Gabriel", false, "04/08/2024 - 18:36", 1, 4, 1, new String[]{"v3.5", "rock", "eduarda", "gabriel", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    ADALGESIO_NO_ROLE("Adalgésio no Rolê", false, "19/07/2024 - 20:55", 0, 75, 1, new String[]{"v3.5", "sertanejo", "adalgésio", "lenon", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    AGUA_DE_COCO_DA_EDUARDA("Água de Coco da Eduarda", false, "01/12/2024 - 04:35", 2, 6, 1, new String[]{"v4", "sertanejo", "eduarda", "bruno", "lucas moreira", "letra original", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    ALEATERIO_NA_RUA("Aleatório na Rua", false, "05/07/2024 - 18:27", 0, 54, 1, new String[]{"v3.5", "metal", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    ALFABETO("Alfabeto", false, "31/08/2024 - 04:25", 1, 14, 1, new String[]{"v3.5", "evangélica"}, new String[]{}, new String[]{}, new String[]{}),
    ALMOCO_NO_APARTAMENTO("Almoço no Apartamento", false, "29/12/2024 - 14:00", 2, 18, 1, new String[]{"v4", "sertanejo", "bruno", "eduarda", "lucas moreira", "gabriel", "tia fofa", "letra original", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    AMIGO_VEM_DORMIR_COMIGO("Amigo Vem Dormir Comigo", false, "23/09/2024 - 02:12", 1, 36, 1, new String[]{"v3.5", "sertanejo", "explícita", "cd antigo", "bruno"}, new String[]{}, new String[]{}, new String[]{}),
    AMOR_DE_JOGO("Amor de Jogo", false, "16/11/2024 - 00:50", 1, 68, 1, new String[]{"v3.5", "piano", "pop", "seis", "prist", "kindome", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    ANIVERSARIO_DA_SAFIRA("Aniversário da Safira", false, "17/08/2024 - 12:58", 1, 7, 11, new String[]{"v3.5", "pop", "safira"}, new String[]{}, new String[]{}, new String[]{}),
    ANIVERSARIO_DO_FAEL("Aniversário do Fael", false, "20/01/2026 - 03:25", 3, 35, 7, new String[]{"v5", "rafael", "metal", "aniversário", "vídeo referência"}, new String[]{}, new String[]{}, new String[]{}),
    AMOR_DESVELADO("Amor Desvelado", false, "31/05/2024 - 05:25", 0, 21, 0, new String[]{"udio", "pop", "explícita", "safira", "bruno", "letra ia"}, new String[]{"Amor Desvelado (Versão Nórdica)", "Amor Desvelado (Versão Metal)"}, new String[]{"Amor Desvelado (Versão Nórdica 1)", "Amor Desvelado (Versão Metal 1)"}, new String[]{}),
    ANO_NOVO_EM_IRACEMA("Ano Novo em Iracema", false, "30/12/2024 - 16:25", 2, 26, 3, new String[]{"v4", "sertanejo", "eduarda", "bruno", "lucas moreira", "gabriel", "tia fofa", "luciene", "letra ia", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    ARROCHA_DA_ANA("Arrocha da Ana", false, "08/03/2025 - 20:02", 2, 85, 3, new String[]{"v4", "arrocha", "ana", "bruno", "safira", "seis", "prist", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    ARROCHA_DO_GABRIEL("Arrocha do Gabriel", false, "31/12/2024 - 19:40", 2, 33, 1, new String[]{"v4", "arrocha", "eduarda", "lucas moreira", "gabriel", "letra original"}, new String[]{"Arrocha do Gabriel (Versão Reggae)"}, new String[]{"Arrocha do Gabriel (Versão Reggae 1)"}, new String[]{}),
    ATENCAO_GABRIEL("Atenção Gabriel", false, "29/12/2024 - 11:41", 2, 15, 1, new String[]{"v4", "sertanejo", "gabriel"}, new String[]{}, new String[]{}, new String[]{}),
    AUDIO_WHATSAPP("Áudio WhatsApp", false, "31/08/2024 - 06:06", 1, 16, 3, new String[]{"v3.5", "mensagem", "eduarda"}, new String[]{"Áudio WhatsApp (Versão SAI)"}, new String[]{}, new String[]{}),
    AVENTURA_NA_PRAIA_DE_IRACEMA("Aventura na Praia de Iracema", false, "29/12/2024 - 20:51", 2, 24, 1, new String[]{"v4", "sertanejo", "eduarda", "bruno", "gabriel", "tia fofa", "praia de iracema", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    AVISO_PARA_EDUARDA("Aviso para Eduarda", false, "07/09/2024 - 13:24", 1, 23, 1, new String[]{"v3.5", "pagode", "bruno", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    BANHO_DA_EDUARDA("Banho da Eduarda", false, "23/10/2024 - 13:30", 1, 53, 3, new String[]{"v3.5", "dubstep", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    BEDWARS_ENTRE_4_JOGADORES("BedWars Entre 4 Jogadores", false, "16/11/2024 - 00:39", 1, 67, 1, new String[]{"v3.5", "piano", "seis", "prist", "bruno", "ivan", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    BLUSA_AMARELA("Blusa Amarela", false, "16/07/2024 - 16:52", 0, 67, 1, new String[]{"udio", "pagode", "roberta", "maria lucia", "maria julia", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    BODE("Bode", false, "25/07/2024 - 22:46", 0, 83, 0, new String[]{"udio", "pop", "kirito"}, new String[]{}, new String[]{}, new String[]{}),
    BOM_DIA_A_TODOS("Bom Dia a Todos", false, "31/12/2024 - 12:34", 2, 31, 1, new String[]{"v4", "reggae", "bruno", "eduarda", "lucas moreira", "gabriel", "tia fofa", "luciene", "praia de iracema", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    BOOMBOX_CAIR("Boombox Cair", false, "17/07/2024 - 00:40", 0, 70, 1, new String[]{"v3.5", "calypso", "praia de iracema", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    BOTA_PRA_DANCAR("Bota pra Dançar", false, "27/12/2024 - 01:27", 2, 12, 0, new String[]{"v4", "pop", "letra ia", "lenon"}, new String[]{}, new String[]{}, new String[]{}),
    CACHORRO_QUENTE("Cachorro Quente", false, "05/09/2024 - 20:05", 1, 20, 3, new String[]{"v3.5", "mensagem", "safira"}, new String[]{}, new String[]{}, new String[]{}),
    CADE_VOCE_EDUARDA("Cadê Você Eduarda", false, "30/12/2024 - 18:26", 2, 30, 1, new String[]{"v4", "sertanejo", "eduarda", "lucas moreira", "bruno", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    CALA_BOCA("CALA BOCA", false, "19/01/2025 - 17:05", 2, 56, 3, new String[]{"v4", "pop", "eduarda", "lucas moreira", "gabriel", "tia fofa", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    CALMA_GABRIEL("Calma Gabriel", false, "30/12/2024 - 16:54", 2, 27, 1, new String[]{"v4", "reggae", "gabriel", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    CENAS("Cenas", false, "29/10/2024 - 00:53", 1, 56, 3, new String[]{"v3.5", "rock", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    CHEGAR_DANCANDO("Chegar Dançando", false, "06/04/2026 - 22:08", 3, 40, 4, new String[]{"v5.5", "arrocha", "gatinhas", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    CHEGOU_O_REMEDIO("Chegou o Remédio", false, "02/01/2025 - 11:12", 2, 41, 1, new String[]{"v4", "pagode", "eduarda", "bruno", "letra original"}, new String[]{"Chegou o Remédio (Versão Reggae)", "Chegou o Remédio (Versão Arrocha)", "Chegou o Remédio (Versão Pop)", "Chegou o Remédio (Versão Metal)", "Chegou o Remédio (Versão Technobrega)"}, new String[]{"Chegou o Remédio (Versão Reggae 1)", "Chegou o Remédio (Versão Arrocha 1)", "Chegou o Remédio (Versão Metal 1)", "Chegou o Remédio (Versão Technobrega 1)", "Chegou o Remédio (Versão Technobrega 2)", "Chegou o Remédio (Versão Technobrega 3)"}, new String[]{}),
    CHILL("Chill", false, "07/09/2024 - 08:27", 1, 22, 1, new String[]{"v3.5", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    CHUVINHA_AMIZADE("Chuvinha Amizade", false, "15/07/2024 - 13:23", 0, 64, 1, new String[]{"v3.5", "sertanejo", "letra ia", "bruno", "eduarda"}, new String[]{}, new String[]{}, new String[]{}),
    COCO("Cocô", false, "22/09/2024 - 11:30", 1, 34, 1, new String[]{"v3.5", "forró piseiro", "eduarda", "escatológica"}, new String[]{}, new String[]{}, new String[]{}),
    COCO_BEM_SOLTO("Cocô Bem Solto", false, "25/08/2025 - 06:59", 3, 22, 3, new String[]{"v4.5+", "funk", "referência externa", "escatológica", "jovem dinâmico"}, new String[]{}, new String[]{}, new String[]{}),
    COISAS_NO_APARTAMENTO("Coisas no Apartamento", false, "12/11/2024 - 10:28", 1, 60, 1, new String[]{"v3.5", "sertanejo", "fernando", "bruno", "fortaleza", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    COME_EDUARDA("Come Eduarda", false, "13/01/2025 - 10:36", 2, 53, 2, new String[]{"v4", "calypso", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    COMIDAS_GOSTOSINHAS("Comidas Gostosinhas", false, "04/07/2024 - 14:06", 0, 51, 1, new String[]{"v3.5", "rock", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    CSGO("CSGO", false, "04/04/2025 - 05:04", 2, 89, 1, new String[]{"v4", "calypso", "mariaum", "vídeo do canal", "bruno"}, new String[]{"CSGO (Versão Mariaum)", "CSGO (Versão Dupla)"}, new String[]{}, new String[]{}),
    DEITADOS("Deitados", false, "04/08/2024 - 17:05", 1, 3, 1, new String[]{"v3.5", "piano", "gabriel", "lucas moreira", "bruno", "eduarda", "letra original", "praia de iracema"}, new String[]{"Deitados Sofredor (Versão Metal)"}, new String[]{"Deitados Sofredor (Versão Metal 1)", "Deitados Sofredor (Versão Metal 2)", "Deitados Sofredor (Versão Metal 3)"}, new String[]{}),
    DESENHA_EDUARDA("Desenha, Eduarda", false, "17/07/2024 - 00:47", 0, 71, 1, new String[]{"v3.5", "pop", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    DESILUSAO_NO_FORRO("Desilusão no Forró", false, "19/07/2024 - 23:45", 0, 77, 3, new String[]{"v3.5", "forró piseiro", "letra ia", "lenon"}, new String[]{}, new String[]{}, new String[]{}),
    DESPERTAR_INCANSAVEL("Despertar Incansavel", false, "18/07/2024 - 19:25", 0, 74, 1, new String[]{"udio", "rock", "piada interna"}, new String[]{}, new String[]{}, new String[]{}),
    DISPUTA_NO_MUSHMC("Disputa no MushMC", false, "08/11/2024 - 00:38", 1, 59, 1, new String[]{"v3.5", "dubstep", "mariaum", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    DIVERSAO_NO_MUSH("Diversão no Mush", false, "24/04/2024 - 12:47", 0, 2, 0, new String[]{"udio", "pagode", "mariaum", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    DIARIO_DE_LUCAS("Diário de Lucas", false, "30/09/2024 - 17:20", 1, 43, 1, new String[]{"v3.5", "sertanejo", "lucas", "lenon", "bruno", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    DOCES_DE_JULIANA("Doces de Juliana", false, "29/05/2024 - 13:01", 0, 20, 1, new String[]{"v3.5", "pop", "juliana", "luciano", "bruno", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    DOMINIOS_DIGITAIS("Domínios Digitais", false, "05/05/2024 - 01:55", 0, 10, 0, new String[]{"udio", "rock", "rafael auler", "mariaum", "piada interna"}, new String[]{}, new String[]{}, new String[]{}),
    DONO_DO_PODER("Dono do Poder", false, "05/05/2024 - 01:58", 0, 11, 0, new String[]{"udio", "rock", "rafael auler", "mariaum", "piada interna"}, new String[]{}, new String[]{}, new String[]{}),
    DOR_DE_BARRIGA("Dor de Barriga", false, "09/02/2025 - 16:24", 2, 69, 1, new String[]{"v4", "forró piseiro", "jovem dinâmico", "escatológica"}, new String[]{}, new String[]{}, new String[]{}),
    EDUARDA("Eduarda", false, "13/06/2024 - 20:02", 0, 31, 1, new String[]{"v3.5", "rock", "letra ia", "eduarda"}, new String[]{"Eduarda (Versão Alternativa)", "Eduarda (Versão Forró)", "Eduarda (Versão Infantil)", "Eduarda (Versão Pagode)", "Eduarda (Versão Piano Calmo)", "Eduarda (Versão Piano)", "Eduarda (Versão Reggae)", "Eduarda (Versão Espanhol)", "Eduarda (Versão Rock Clássico)", "Eduarda (Versão Arrocha)", "Eduarda (Versão Brega)", "Eduarda (Versão Technobrega)", "Eduarda (Versão Nórdica)"}, new String[]{"Eduarda (Versão Arrocha 1)", "Eduarda (Versão Alternativa 2)", "Eduarda (Versão Forró 2)", "Eduarda (Versão Pagode 2)", "Eduarda (Versão Piano 1)", "Eduarda (Versão Piano 2)", "Eduarda (Versão Espanhol 1)", "Eduarda (Versão Brega 1)", "Eduarda (Versão Technobrega 1)", "Eduarda (Versão Nórdica 1)"}, new String[]{}),
    EDUARDA_INSPIRADA("Eduarda Inspirada", false, "17/07/2024 - 01:17", 0, 73, 1, new String[]{"v3.5", "sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    EDUARDA_NA_FAVELA("Eduarda na Favela", false, "03/11/2024 - 00:50", 1, 58, 1, new String[]{"v3.5", "funk", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    ELA_E_GATINHA("Ela é Gatinha", false, "15/06/2025 - 12:21", 3, 14, 1, new String[]{"v4.5", "arrocha", "eduarda", "letra original"}, new String[]{"Ela é Gatinha (Versão Brega)", "Ela é Gatinha (Versão Reggae)", "Ela é Gatinha (Versão Metal)", "Ela é Gatinha (Versão Technobrega)", "Ela é Gatinha (Versão Funk)", "Ela é Gatinha (Versão Nórdica)", "Ela é Gatinha (Versão Rap)"}, new String[]{"Ela é Gatinha (Versão Brega 1)", "Ela é Gatinha (Versão Reggae 1)", "Ela é Gatinha (Versão Metal 1)", "Ela é Gatinha (Versão Technobrega 1)", "Ela é Gatinha (Versão Funk 1)", "Ela é Gatinha (Versão Nórdica 1)", "Ela é Gatinha (Versão Nórdica 1)"}, new String[]{}),
    ELE_E_O_GABRIEL("Ele é o Gabriel", false, "01/01/2025 - 14:55", 2, 37, 1, new String[]{"v4", "reggae", "gabriel", "letra original", "rima"}, new String[]{}, new String[]{}, new String[]{}),
    ENVIANDO_O_KINDOME("Enviando o Kindome", false, "27/11/2024 - 22:20", 2, 4, 1, new String[]{"v4", "sertanejo", "kindome", "letra ia", "bruno", "mariaum"}, new String[]{}, new String[]{}, new String[]{}),
    ESCOLHA_DA_BLUSA("Escolha da Blusa", false, "16/07/2024 - 16:52", 0, 68, 1, new String[]{"v3.5", "pop", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    ESCOVANDO_OS_DENTES("Escovando os Dentes", false, "02/01/2025 - 13:50", 2, 43, 1, new String[]{"v4", "calypso", "tia fofa", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    EU_TE_AMO_EDUARDA("Eu Te Amo Eduarda", false, "29/12/2024 - 13:09", 2, 17, 1, new String[]{"v4", "pagode", "eduarda"}, new String[]{"Eu Te Amo Eduarda (Versão Brega)"}, new String[]{"Eu Te Amo Eduarda (Versão Brega 1)"}, new String[]{}),
    EX_DJS("Ex DJs", false, "08/09/2024 - 16:22", 1, 25, 1, new String[]{"v3.5", "dubstep", "eduarda", "bruno", "lucas moreira"}, new String[]{}, new String[]{}, new String[]{}),
    FAYE("Faye", false, "02/01/2025 - 17:10", 2, 44, 1, new String[]{"v4", "pop", "letra ia", "mariana"}, new String[]{}, new String[]{}, new String[]{}),
    FERNANDO("Fernando", false, "15/09/2025 - 09:06", 3, 24, 1, new String[]{"v4.5", "arrocha", "fernando", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    FERNANDO_NO_APARTAMENTO("Fernando no Apartamento", false, "12/11/2024 - 10:28", 1, 61, 3, new String[]{"v3.5", "sertanejo", "fernando", "bruno", "praia de iracema", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    FESTA_NO_ELEVADOR("Festa no Elevador", false, "18/06/2025 - 13:11", 3, 15, 9, new String[]{"v4.5", "arrocha", "bruno", "lucas", "joão breno", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    FIOS_REBELDES("Fios Rebeldes", false, "01/05/2024 - 09:49", 0, 9, 0, new String[]{"udio", "rock", "letra ia", "roberta"}, new String[]{}, new String[]{}, new String[]{}),
    FOGUETE_TRICOLOR("Foguete Tricolor", false, "29/08/2024 - 02:36", 1, 11, 7, new String[]{"v3.5", "rock", "letra ia", "fortaleza"}, new String[]{}, new String[]{}, new String[]{}),
    FOME_DA_LORENA("Fome da Lorena", false, "31/12/2024 - 12:45", 2, 32, 1, new String[]{"v4", "sertanejo", "lorena", "praia de iracema", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    FRASES_DE_EDUARDA("Frases de Eduarda", false, "17/07/2024 - 01:06", 0, 72, 1, new String[]{"v3.5", "sertanejo", "eduarda", "bruno", "praia de iracema", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    FRASES_DE_LUCIVANIA("Frases de Lucivania", false, "01/01/2025 - 20:35", 2, 40, 1, new String[]{"v4", "evangélica", "eduarda", "tia fofa", "bruno", "praia de iracema", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    FRASES_NO_APARTAMENTO("Frases no Apartamento", false, "12/11/2024 - 10:28", 1, 62, 1, new String[]{"v4", "sertanejo", "lucas moreira", "gabriel", "bruno", "eduarda", "tia fofa", "lorena", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    GABRIEL_ESCOVANDO("Gabriel Escovando", false, "19/01/2025 - 11:10", 2, 55, 1, new String[]{"v4", "calypso", "gabriel", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    GABRIEL_PARA_JABRIEL("Gabriel para Jabriel", false, "31/12/2024 - 20:10", 2, 34, 1, new String[]{"v4", "sertanejo", "gabriel", "letra original"}, new String[]{"Gabriel para Jabriel (Versão K-Pop)", "Gabriel para Jabriel (Versão Metal)", "Gabriel para Jabriel (Versão Arrocha)"}, new String[]{"Gabriel para Jabriel (Versão Metal 1)", "Gabriel para Jabriel (Versão Arrocha 1)"}, new String[]{}),
    GABRIEL("Gabriel", false, "29/12/2024 - 14:05", 2, 19, 1, new String[]{"v4", "sertanejo", "gabriel", "1 verso"}, new String[]{}, new String[]{}, new String[]{}),
    GALERA_DO_MARIAUM("Galera do Mariaum", false, "15/02/2025 - 12:55", 2, 76, 0, new String[]{"funk", "mariaum", "referência externa"}, new String[]{"Galera do Mariaum (Versão Reggae)", "Galera do Mariaum (Versão Metal)", "Galera do Mariaum (Versão Alternativa)", "Galera do Mariaum (Versão Piseiro)"}, new String[]{"Galera do Mariaum (Versão Reggae 1)", "Galera do Mariaum (Versão Metal 1)", "Galera do Mariaum (Versão Piseiro 1)", "Galera do Mariaum (Versão Piseiro 2)", "Galera do Mariaum (Versão Piseiro 3)", "Galera do Mariaum (Versão Alternativa 1)"}, new String[]{}),
    GAROTAS_PALHACO("Garotas Palhaço", false, "26/02/2025 - 23:18", 2, 82, 5, new String[]{"v4", "rock", "prist", "explícita", "referência externa"}, new String[]{"Garotas Palhaço (Versão Brega)", "Garotas Palhaço (Versão Arrocha)"}, new String[]{}, new String[]{}),
    GIGANTES_DO_FORROZAO("Gigantes do Forrozão", false, "07/05/2024 - 16:52", 0, 14, 1, new String[]{"udio", "rock", "luciano", "piada interna"}, new String[]{}, new String[]{}, new String[]{}),
    GOSTOSINHO("Gostosinho", false, "19/07/2025 - 23:44", 3, 18, 4, new String[]{"v4.5+", "salsa", "discord", "jaozn", "1 verso", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    GRANDE_ENIGMA("Grande Enigma", false, "02/08/2024 - 17:49", 1, 1, 1, new String[]{"v3.5", "rock", "eduarda", "bruno", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    HIPER_CINEMATIC("Hiper Cinematic", false, "04/07/2024 - 12:46", 0, 48, 1, new String[]{"v3.5", "épica", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    HOMENAGEM_A_MINHA_VO("Homenagem a minha vó", false, "04/09/2024 - 17:45", 1, 19, 1, new String[]{"v3.5", "pop", "vó lúcia", "letra original", "letra paródia", "vídeo do canal"}, new String[]{}, new String[]{}, new String[]{}),
    HORROR_PIANO("Horror Piano", false, "04/06/2025 - 13:40", 3, 8, 1, new String[]{"v4.5", "piano", "instrumental", "eduarda"}, new String[]{}, new String[]{}, new String[]{}),
    INTRO_NA_CHAMADA("Intro na Chamada", false, "20/11/2024 - 18:28", 2, 1, 15, new String[]{"v4", "forró piseiro", "discord", "bruno", "1 verso", "letra original"}, new String[]{"Intro na Chamada (Versão Nórdica)"}, new String[]{"Intro na Chamada (Versão Nórdica 1)"}, new String[]{}),
    IVR("IVR", false, "09/06/2025 - 23:23", 3, 13, 7, new String[]{"v4.5", "metal", "ivan", "rafael auler", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    JAVA_CODING("Java Coding", false, "22/01/2025 - 22:00", 2, 57, 1, new String[]{"v4", "piano", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    JINGLE_DAS_GATINHAS("Jingle das Gatinhas", false, "19/06/2024 - 00:33", 0, 35, 0, new String[]{"v3.5", "voz", "gatinhas", "piada interna"}, new String[]{"Jingle das Gatinhas (Versão Metal)"}, new String[]{}, new String[]{}),
    JOAO_BRENO_E_O_LEGO("João Breno e o Lego", false, "15/09/2024 - 12:29", 1, 29, 1, new String[]{"v4", "pop", "joão breno", "letra original", "explícita"}, new String[]{"João Breno e o Lego (Versão R&B)", "João Breno e o Lego (Versão Arrocha)"}, new String[]{"João Breno e o Lego (Versão Arrocha 1)"}, new String[]{}),
    JOSE("José", false, "22/02/2025 - 12:46", 2, 78, 1, new String[]{"v4", "sertanejo", "josé", "praia de iracema", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    KIRITO("Kirito", false, "31/08/2024 - 01:30", 1, 12, 1, new String[]{"v3.5", "funk", "kirito", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    LANCHE_CHEGOU("Lanche Chegou", false, "12/04/2026 - 12:37", 3, 43, 2, new String[]{"v5.5", "hiphop", "letra original", "eduarda"}, new String[]{}, new String[]{}, new String[]{}),
    LEI_DE_GAGA("Lei de Gaga", false, "18/08/2025 - 23:11", 3, 21, 1, new String[]{"v4.5+", "pop", "letra original", "1 verso"}, new String[]{}, new String[]{}, new String[]{}),
    LENON_NO_MICROFONE("Lenon no Microfone", false, "27/12/2024 - 01:30", 2, 13, 0, new String[]{"mensagem", "lenon"}, new String[]{}, new String[]{}, new String[]{}),
    LINDA_EDUARDA("Linda Eduarda", false, "29/12/2024 - 22:11", 2, 25, 1, new String[]{"v4", "sertanejo", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    LIVE_DE_MINE("Live de Mine", false, "09/01/2025 - 19:30", 2, 50, 3, new String[]{"v4", "pop", "kindome", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    LOJA_PARA_HYAN("Loja para Hyan", false, "12/02/2025 - 19:45", 2, 73, 3, new String[]{"v4", "forró piseiro", "plugins", "bruno", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    LUCA_PROIBIDO("Luca Proibido", false, "02/02/2025 - 23:26", 2, 63, 1, new String[]{"v4", "funk", "lucas moreira", "bruno", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    LUCAS_DORMINHOCO("Lucas Dorminhoco", false, "08/09/2024 - 12:45", 1, 24, 5, new String[]{"v3.5", "sertanejo", "lucas moreira", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    LUCAS_FAZENDO_COCO("Lucas Fazendo Cocô", false, "12/01/2025 - 02:53", 2, 52, 1, new String[]{"v4", "salsa", "lucas moreira", "letra original", "escatológica"}, new String[]{}, new String[]{}, new String[]{}),
    LUCAS_NO_VOLANTE("Lucas no Volante", false, "11/05/2025 - 17:27", 3, 4, 5, new String[]{"v4.5", "metal", "lucas", "tamisa"}, new String[]{"Lucas no Volante (Versão Arrocha)"}, new String[]{"Lucas no Volante (Versão Arrocha 1)"}, new String[]{}),
    LUCAS("Lucas", false, "30/12/2024 - 17:08", 2, 28, 1, new String[]{"v4", "funk", "lucas moreira", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    LUCIVANIA("Lucivania", false, "01/01/2025 - 19:42", 2, 39, 1, new String[]{"v4", "calypso", "tia fofa", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    MAJOR_SABINO("Major Sabino", false, "22/08/2024 - 22:03", 1, 8, 6, new String[]{"v3.5", "forró piseiro", "reginaldo", "letra original", "político"}, new String[]{"Major Sabino (Versão Gospel)", "Major Sabino (Versão Metal)", "Major Sabino (Versão Reggae)", "Major Sabino (Versão Brega)"}, new String[]{"Major Sabino (Versão Gospel 1)", "Major Sabino (Versão Metal 1)", "Major Sabino (Versão Metal 2)", "Major Sabino (Versão Metal 3)", "Major Sabino (Versão Reggae 1)"}, new String[]{}),
    MANHA_DE_METAL("Manhã de Metal", false, "15/05/2024 - 08:58", 0, 16, 0, new String[]{"udio", "rock", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    MARIA_EDUARDA_NO_FORRO("Maria Eduarda No Forró", false, "11/08/2024 - 18:51", 1, 6, 1, new String[]{"v3.5", "infantil", "maria eduarda barreto", "letra ia"}, new String[]{"Maria Eduarda No Forró (Versão Metal)"}, new String[]{"Maria Eduarda No Forró (Versão Metal 1)"}, new String[]{}),
    MARIA_EDUARDA("Maria Eduarda", false, "09/02/2025 - 16:45", 2, 70, 1, new String[]{"v4", "sertanejo", "maria eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    MARIAUM("Mariaum", false, "15/02/2025 - 12:48", 2, 75, 0, new String[]{"regional", "mariaum", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    MARIAUM_VS_WG("Mariaum vs WG", false, "14/11/2025 - 23:42", 3, 29, 1, new String[]{"v5", "mariaum", "rap", "wg", "letra ia"}, new String[]{"Mariaum vs WG (Versão Duelo)", "Mariaum vs WG (Versão Maraio)"}, new String[]{}, new String[]{}),
    MC_HARIEL_PARA_SAFIRA("MC Hariel para Safira", false, "18/05/2024 - 18:17", 0, 19, 1, new String[]{"udio", "funk", "safira", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    MCGPLAYS_PARA_VINICIUS("MCGPlays para Vinicius", false, "06/06/2024 - 09:26", 0, 24, 0, new String[]{"v3", "rock", "mcgplays", "referência externa", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    MENSAGENS("Mensagens", false, "27/10/2024 - 04:54", 1, 55, 5, new String[]{"v3.5", "rock", "lenon", "bruno"}, new String[]{}, new String[]{}, new String[]{}),
    MEU_SONHO_DO_DIA_2("Meu Sonho do Dia 2", false, "02/01/2025 - 11:19", 2, 42, 3, new String[]{"v4", "forró piseiro", "reginaldo", "bruno", "adalgésio", "letra original", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    MISSOES_PARA_HYAN("Missões para Hyan", false, "05/12/2024 - 20:20", 2, 8, 3, new String[]{"v4", "forró piseiro", "plugins", "1 verso", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    MOUNTAIN_PATH("Mountain Path", false, "06/06/2025 - 22:40", 3, 10, 1, new String[]{"piano", "instrumental", "referência externa"}, new String[]{"Mountain Path (Versão Metal)", "Mountain Path (Versão Arrocha)", "Mountain Path (Versão Piseiro)", "Mountain Path (Versão Espacial)", "Mountain Path (Versão Harpa)", "Mountain Path (Versão Violino)", "Mountain Path (Versão Nórdica)"}, new String[]{"Mountain Path (Versão Metal 1)", "Mountain Path (Versão Metal 2)", "Mountain Path (Versão Metal 3)", "Mountain Path (Versão Piseiro 1)", "Mountain Path (Versão Arrocha 1)", "Mountain Path (Versão Espacial 1)", "Mountain Path (Versão Nórdica 1)"}, new String[]{}),
    MUITO_CONFORTO("Muito Conforto", false, "15/04/2026 - 02:47", 3, 46, 2, new String[]{"v5.5", "pop", "infantil", "heavy metal"}, new String[]{}, new String[]{}, new String[]{}),
    MUITO_LINDA("Muito Linda", false, "07/04/2026 - 15:17", 3, 41, 7, new String[]{"v5.5", "arrocha", "gatinhas", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    MUSHMC("MushMC", false, "10/02/2025 - 19:11", 2, 71, 1, new String[]{"v4", "forró piseiro", "mariaum"}, new String[]{}, new String[]{}, new String[]{}),
    MUSICA_PARA_CAGAR("Música para Cagar", false, "04/07/2024 - 20:58", 0, 52, 5, new String[]{"v3.5", "piano", "escatológica", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    NAO_MEXE("NÃO MEXE", false, "29/01/2026 - 06:57", 3, 36, 6, new String[]{"v5", "8 bit", "jovem dinâmico", "gatinhas", "letra original"}, new String[]{"NÃO MEXE (Versão Lo-Fi)"}, new String[]{"NÃO MEXE (Versão Lo-Fi 1)"}, new String[]{}),
    NAO_SABE_PULAR("Não Sabe Pular", false, "24/02/2025 - 11:48", 2, 80, 7, new String[]{"v4", "forró piseiro", "prist", "referência externa", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    NATUREZA("Natureza", false, "21/10/2024 - 02:23", 1, 51, 7, new String[]{"v3.5", "pop", "bruno", "letra original", "vídeo do canal"}, new String[]{"Natureza (Versão Violão)", "Natureza (Versão Metal)", "Natureza (Versão Arrocha)", "Natureza (Versão Brega)", "Natureza (Versão Alternativa)"}, new String[]{"Natureza (Versão Violão 1)", "Natureza (Versão Metal 1)", "Natureza (Versão Arrocha 1)", "Natureza (Versão Brega 1)"}, new String[]{}),
    NAYARA("Nayara", false, "22/07/2024 - 02:52", 0, 79, 1, new String[]{"v3.5", "piano", "nayara", "bruno"}, new String[]{"Nayara (Versão Arrocha)"}, new String[]{"Nayara (Versão Arrocha 1)"}, new String[]{}),
    NIGHT("Night", false, "03/10/2025 - 03:52", 3, 26, 2, new String[]{"v5", "instrumental", "piano"}, new String[]{"Night (Versão Arrocha)", "Night (Versão Violino)", "Night (Versão Metal)", "Night (Versão Nórdica)"}, new String[]{"Night (Versão Arrocha 1)", "Night (Versão Violino 1)", "Night (Versão Metal 1)", "Night (Versão Nórdica 1)"}, new String[]{}),
    NOITE_PALIDA("Noite Pálida", false, "16/03/2025 - 06:37", 2, 88, 1, new String[]{"noite", "reggae", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    NOSSO_RELACIONAMENTO("Nosso Relacionamento", false, "14/11/2024 - 18:48", 1, 66, 1, new String[]{"v3.5", "rap", "safira", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    NOVOS_SERVIDORES("Novos Servidores", false, "09/04/2025 - 06:30", 2, 91, 1, new String[]{"v4", "pop", "mariaum", "bruno", "letra ia"}, new String[]{"Novos Servidores (Versão Mariaum)"}, new String[]{}, new String[]{}),
    O_AMOR_DE_EDUARDA_PELO_COCO("O Amor de Eduarda Pelo Cocô", false, "22/09/2024 - 11:33", 1, 35, 0, new String[]{"v3.5", "forró piseiro", "eduarda", "letra ia", "escatológica"}, new String[]{}, new String[]{}, new String[]{}),
    O_DONO_DO_SERVIDOR("O Dono do Servidor", false, "01/06/2024 - 19:54", 0, 22, 0, new String[]{"udio", "rock", "rafael auler", "mariaum", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    O_DUMP_DO_MYSQL("O Dump do MySQL", false, "14/05/2024 - 00:53", 0, 15, 2, new String[]{"udio", "funk", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    O_MARIAUM("O Mariaum", false, "20/10/2024 - 21:37", 1, 48, 1, new String[]{"v3.5", "forró piseiro", "mariaum", "letra ia"}, new String[]{"O Mariaum (Versão Mariaum)"}, new String[]{}, new String[]{}),
    OI_RAFAEL("Oi Rafael", false, "20/07/2025 - 14:47", 3, 19, 16, new String[]{"v4.5+", "salsa", "rafael", "discord", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    OLHANDO_PARA_O_LADO("Olhando para o Lado", false, "10/07/2024 - 17:29", 0, 57, 1, new String[]{"v3.5", "rock", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    OURO_BRANCO_PARA_LUCAS("Ouro Branco para Lucas", false, "17/11/2024 - 07:42", 1, 70, 3, new String[]{"v3.5", "sertanejo", "lucas moreira"}, new String[]{}, new String[]{}, new String[]{}),
    PALAVRAS_GUARDADAS("Palavras Guardadas", false, "30/06/2024 - 19:46", 0, 44, 1, new String[]{"v3.5", "piano", "desabafo", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    PANDA("Panda", false, "09/04/2025 - 05:16", 2, 90, 1, new String[]{"v4", "metal", "panda", "referência original", "explícita"}, new String[]{"Panda (Versão Arrocha)"}, new String[]{"Panda (Versão Arrocha 1)"}, new String[]{}),
    PARABENS_ANA("Parabéns Ana", false, "20/02/2025 - 01:10", 2, 77, 4, new String[]{"v4", "pop", "ana", "letra original"}, new String[]{"Parabéns Ana (Versão Rock)", "Parabéns Ana (Versão Metal)"}, new String[]{"Parabéns Ana (Versão Rock 1)", "Parabéns Ana (Versão Metal 1)"}, new String[]{}),
    PARABENS_DE_KOS("Parabéns de Kos", false, "06/03/2025 - 00:23", 2, 84, 1, new String[]{"v4", "forró piseiro", "prist", "bruno", "parabéns"}, new String[]{}, new String[]{}, new String[]{}),
    PARABENS_KOS("Parabéns Kos", false, "12/03/2025 - 16:42", 2, 86, 3, new String[]{"v4", "forró piseiro", "parabéns", "prist"}, new String[]{}, new String[]{}, new String[]{}),
    PARABENS_MARIAUM("Parabéns Mariaum", false, "11/10/2024 - 20:39", 1, 46, 3, new String[]{"v3.5", "rock", "parabéns", "mariaum"}, new String[]{"Parabéns Mariaum (Versão Mariaum)"}, new String[]{}, new String[]{}),
    PASSAR_MAL("Passar Mal", false, "15/11/2025 - 01:49", 3, 30, 5, new String[]{"v2", "reggae", "escatológica", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    PECADINHA("PECADINHA", false, "12/04/2026 - 12:17", 3, 42, 7, new String[]{"v5.5", "heavy metal", "jovem dinâmico", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    PEDIDO_DE_CASAMENTO("Pedido de Casamento", false, "12/12/2025 - 16:10", 3, 34, 7, new String[]{"v5", "nordica", "aurora", "felipe neto", "bruno"}, new String[]{}, new String[]{}, new String[]{}),
    PEDIDO_DE_MASCARA("Pedido de Máscara", false, "11/07/2024 - 14:16", 0, 61, 3, new String[]{"v3.5", "sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    PERFEITA("Perfeita", false, "02/12/2024 - 23:48", 2, 7, 1, new String[]{"v4", "forró piseiro", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    PESSOA_ACIMA("Pessoa Acima", false, "08/01/2025 - 17:47", 2, 49, 3, new String[]{"v4", "sertanejo", "referência externa", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    PIADAS_HILARIAS("Piadas Hilárias", false, "29/08/2025 - 02:25", 3, 23, 1, new String[]{"v4.5+", "voz", "comédia"}, new String[]{"Piadas Hilárias (Show)", "Piadas Hilárias (História do Fabiano)", "Piadas Hilárias (História da BR)", "Piadas Hilárias (História do Rafael)", "Piadas Hilárias (MapMeel)", "Piadas Hilárias (Rafael vs Muito Linda)"}, new String[]{"Piadas Hilárias (Show 1)", "Piadas Hilárias (História do Fabiano 1)", "Piadas Hilárias (História da BR 1)", "Piadas Hilárias (História do Rafael 1)", "Piadas Hilárias (MapMeel 1)", "Piadas Hilárias (Rafael vs Muito Linda 1)"}, new String[]{}),
    PLUGIN_DE_REPORT("Plugin de Report", false, "23/10/2024 - 21:08", 1, 54, 0, new String[]{"v3.5", "sertanejo", "plugins", "letra original", "1 verso"}, new String[]{}, new String[]{}, new String[]{}),
    POMBO("Pombo", false, "09/09/2024 - 18:26", 1, 27, 1, new String[]{"v3.5", "funk", "diegosvp", "jotah", "bruno", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    PORTUGUES("Português", false, "24/02/2025 - 15:13", 2, 81, 1, new String[]{"v4", "sertanejo", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    PRESA_NOVINHA("Presa Novinha", false, "11/10/2025 - 08:16", 3, 27, 1, new String[]{"v5", "funk", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    PROCESSO("Processo", false, "15/11/2025 - 02:01", 3, 31, 3, new String[]{"v4.5-all", "rap", "bruno", "gleiciane", "letra original", "mensagem"}, new String[]{}, new String[]{}, new String[]{}),
    PROCURA_DE_EMPREGO("Procura de Emprego", false, "01/07/2024 - 08:31", 0, 45, 1, new String[]{"v3.5", "rock", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    PROMESSA_DA_SULAMERICANA("Promessa da Sulamericana", false, "26/09/2024 - 19:13", 1, 39, 1, new String[]{"v3.5", "sertanejo", "jovem dinâmico", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    PSYCHOPATH("Psychopath", false, "04/06/2025 - 13:49", 3, 9, 1, new String[]{"v4.5", "piano", "instrumental", "eduarda"}, new String[]{}, new String[]{}, new String[]{}),
    PUDIM_E_TORTA_DE_FRANGO("Pudim e Torta de Frango", false, "31/07/2024 - 17:35", 0, 86, 1, new String[]{"v3.5", "pop", "eduarda", "bruno", "praia de iracema", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    PUTS_KINDOME("Puts Kindome", false, "16/04/2025 - 05:39", 2, 92, 3, new String[]{"v4", "metal", "snifpvp", "kindome", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    QUE_MARAVILHA("Que Maravilha", false, "15/05/2024 - 23:29", 0, 17, 1, new String[]{"v3", "pagode", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    QUEBRA_O_COCO("Quebra o Coco", false, "25/10/2025 - 06:17", 3, 28, 2, new String[]{"v5", "piada interna", "eduarda", "letra original", "hiphop"}, new String[]{}, new String[]{}, new String[]{}),
    RAIVA("Raiva", false, "08/02/2025 - 20:44", 2, 67, 5, new String[]{"v4", "metal", "explícita", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    REABERTURA_DO_KINDOME("Reabertura do Kindome", false, "30/11/2024 - 13:08", 2, 5, 1, new String[]{"v4", "sertanejo", "kindome", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    REGISTRO_DE_FUTEBOL("Registro de Futebol", false, "09/07/2024 - 21:55", 0, 56, 1, new String[]{"v3.5", "rock", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    REINOS_DE_JOGO("Reinos de Jogo", false, "24/04/2024 - 12:57", 0, 3, 2, new String[]{"udio", "rock", "kindome", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    RITMO_INSOLENTE("Ritmo Insolente", false, "29/04/2024 - 16:01", 0, 8, 0, new String[]{"udio", "pagode", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    SAFIRA("Safira", false, "03/01/2025 - 18:27", 2, 47, 2, new String[]{"v3.5", "rock", "safira", "letra original"}, new String[]{"Safira (Versão Curta)", "Safira (Versão Metal)", "Safira (Versão Violão)", "Safira (Versão Arrocha)", "Safira (Versão Brega)", "Safira (Versão Piano)", "Safira (Versão Nórdica)"}, new String[]{"Safira (Versão Metal 1)", "Safira (Versão Violão 1)", "Safira (Versão Arrocha 1)", "Safira (Versão Brega 1)", "Safira (Versão Piano 1)", "Safira (Versão Nórdica 1)"}, new String[]{}),
    SAFIRA_VS_EDUARDA("Safira vs Eduarda", false, "23/07/2024 - 02:20", 0, 80, 11, new String[]{"v3.5", "épica", "safira", "eduarda", "letra original", "explícita"}, new String[]{"Safira vs Eduarda (Versão Funk)", "Safira vs Eduarda (Versão Metal)", "Safira vs Eduarda (Versão Minimalista)", "Safira vs Eduarda (Versão Pagode)", "Safira vs Eduarda (Versão Piano)", "Safira vs Eduarda (Versão Reggae)", "Safira vs Eduarda (Versão Salsa)", "Safira vs Eduarda (Versão Pop)", "Safira vs Eduarda (Versão Arrocha)", "Safira vs Eduarda (Versão Alternativa)", "Safira vs Eduarda (Versão Brega)", "Safira vs Eduarda (Versão Rebuild)", "Safira vs Eduarda (Versão V5)", "Safira vs Eduarda (Versão Nórdica)", "Safira vs Eduarda (Versão Lo-Fi)", "Safira vs Eduarda (Versão Drift)", "Safira vs Eduarda (Versão Thrash Metal)"}, new String[]{"Safira vs Eduarda (Versão Arrocha 1)", "Safira vs Eduarda (Versão Reggae 1)", "Safira vs Eduarda (Versão Salsa 1)", "Safira vs Eduarda (Versão Arrocha 2)", "Safira vs Eduarda (Versão Metal 1)", "Safira vs Eduarda (Versão Metal 2)", "Safira vs Eduarda (Versão Metal 3)", "Safira vs Eduarda (Versão Pagode 1)", "Safira vs Eduarda (Versão V5 1)", "Safira vs Eduarda (Versão Nórdica 1)", "Safira vs Eduarda (Versão Lo-Fi 1)", "Safira vs Eduarda (Versão Drift 1)", "Safira vs Eduarda (Versão Thrash Metal 1)"}, new String[]{}),
    SETE_NA_CHAMADA("Sete na Chamada", false, "06/12/2024 - 21:57", 2, 9, 3, new String[]{"v4", "rap", "kirito", "discord", "1 verso", "letra original"}, new String[]{"Sete na Chamada (Versão Metal)"}, new String[]{"Sete na Chamada (Versão Metal 1)"}, new String[]{}),
    SHOW_DE_COMEDIA("Show de Comédia", false, "31/08/2024 - 20:26", 1, 17, 2, new String[]{"udio", "voz", "comédia", "escatológica"}, new String[]{}, new String[]{}, new String[]{}),
    SKATE("Skate", false, "29/12/2024 - 16:18", 2, 22, 1, new String[]{"v4", "violão", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    SNIF("Snif", false, "23/04/2025 - 08:06", 2, 93, 1, new String[]{"v4", "metal", "snifpvp", "referência externa"}, new String[]{}, new String[]{}, new String[]{}),
    SOLO_DE_GUITARRA_PISEIRO("Solo de Guitarra Piseiro", false, "27/12/2024 - 01:45", 2, 14, 1, new String[]{"v4", "lenon", "rock", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    SOM_DO_SOL("Som do Sol", false, "07/06/2024 - 17:58", 0, 26, 0, new String[]{"udio", "sertanejo", "rafael auler", "mariaum", "piada interna"}, new String[]{}, new String[]{}, new String[]{}),
    SONHOS_DIGITAIS("Sonhos Digitais", false, "03/06/2024 - 19:10", 0, 23, 0, new String[]{"udio", "pop", "mariaum"}, new String[]{}, new String[]{}, new String[]{}),
    SONO_DA_EDUARDA("Sono da Eduarda", false, "28/01/2025 - 22:56", 2, 60, 4, new String[]{"v4", "sono", "eduarda", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    SONO_DA_GATINHA("Sono da Gatinha", false, "12/04/2026 - 13:08", 3, 44, 3, new String[]{"v5.5", "reggae", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    SONO_DO_GABRIEL("Sono do Gabriel", false, "19/01/2025 - 10:03", 2, 54, 6, new String[]{"v4", "sono", "gabriel", "letra original", "explícita"}, new String[]{}, new String[]{}, new String[]{}),
    STAIRCASE("StairCase", false, "20/06/2025 - 17:57", 3, 16, 1, new String[]{"v4.5", "terror", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    STELLA_OVERTURE("Stella Overture", false, "15/07/2024 - 06:52", 0, 63, 1, new String[]{"v3.5", "épica", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    SUVACO_CABELUDO("Suvaco Cabeludo", false, "18/05/2024 - 10:42", 0, 18, 0, new String[]{"udio", "rock", "1 verso", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    TAVA_GOSTOSO("Tava Gostoso", false, "29/12/2024 - 14:29", 2, 21, 1, new String[]{"v4", "sertanejo", "gabriel", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    TCHACOBARACATINI("Tchacobaracatini", false, "15/04/2026 - 00:19", 3, 45, 12, new String[]{"v5.5", "arrocha", "gatinhas"}, new String[]{}, new String[]{}, new String[]{}),
    TE_AMAR_DE_NOVO("Te Amar de Novo", false, "19/07/2024 - 21:00", 0, 76, 3, new String[]{"v3.5", "forró piseiro", "adalgésio", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    TE_AMO_DEMAIS("Te Amo Demais", false, "11/08/2024 - 13:32", 1, 5, 7, new String[]{"v3.5", "brega", "reginaldo", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    TESTE_DE_VOZ("Teste de voz", false, "31/08/2024 - 04:37", 1, 15, 1, new String[]{"v3.5", "voz"}, new String[]{}, new String[]{}, new String[]{}),
    TEXTAO_EM_PIANO("Textão em Piano", false, "10/07/2024 - 22:53", 0, 60, 1, new String[]{"v3.5", "piano", "desabafo", "eduarda"}, new String[]{}, new String[]{}, new String[]{}),
    TEXTAO_EM_SERTANEJO("Textão em Sertanejo", false, "10/07/2024 - 22:52", 0, 59, 1, new String[]{"v3.5", "sertanejo", "desabafo", "eduarda"}, new String[]{}, new String[]{}, new String[]{}),
    THE_END("The End", false, "05/02/2025 - 01:29", 2, 64, 4, new String[]{"v4", "piano", "eduarda", "instrumental"}, new String[]{"The End (Versão Metal)", "The End (Versão Arrocha)", "The End (Versão Nórdica)"}, new String[]{"The End (Versão Arrocha 1)", "The End (Versão Nórdica 1)"}, new String[]{}),
    TIA_FOFA("Tia Fofa", false, "29/12/2024 - 14:07", 2, 20, 1, new String[]{"v4", "sertanejo", "tia fofa", "eduarda", "lucas moreira", "gabriel", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    TODO_MUNDO("Todo Mundo", false, "04/07/2024 - 13:04", 0, 49, 1, new String[]{"v3.5", "regional", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    TODOS_NA_SALA("Todos na Sala", false, "01/01/2025 - 15:01", 2, 38, 1, new String[]{"v4", "reggae", "praia de iracema", "eduarda", "bruno", "lucas moreira", "gabriel", "lorena", "luciene", "tia fofa"}, new String[]{}, new String[]{}, new String[]{}),
    TOMA_LUCAS("Toma Lucas", false, "01/01/2025 - 13:50", 2, 36, 1, new String[]{"v4", "calypso", "lucas moreira", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    TRAILER("Trailer", false, "15/11/2025 - 19:05", 3, 32, 2, new String[]{"v5", "instrumental", "eletrônica", "kindome"}, new String[]{}, new String[]{}, new String[]{}),
    TRANQUIL_DREAMSCAPES("Tranquil Dreamscapes", false, "23/07/2024 - 17:19", 0, 81, 1, new String[]{"v3.5", "épica", "instrumental"}, new String[]{}, new String[]{}, new String[]{}),
    TROCA_DE_ROUPAS_NO_PORTO_DAS_DUNAS("Troca de Roupas no Porto das Dunas", false, "08/12/2024 - 04:20", 2, 10, 1, new String[]{"v4", "pagode", "eduarda", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    TROPA_DO_SNIFFER("Tropa do Sniffer", false, "15/03/2026 - 22:55", 3, 38, 0, new String[]{"v3.5", "pop", "prist", "jaozn"}, new String[]{"Tropa do Sniffer (Versão Nórdica)", "Tropa do Sniffer (Versão Metal)", "Tropa do Sniffer (Versão Reggae)", "Tropa do Sniffer (Versão Lo-Fi)"}, new String[]{"Tropa do Sniffer (Versão Nórdica 1)", "Tropa do Sniffer (Versão Metal 1)", "Tropa do Sniffer (Versão Reggae 1)", "Tropa do Sniffer (Versão Lo-Fi 1)"}, new String[]{}),
    TROPINHA("Tropinha", false, "20/03/2026 - 04:27", 3, 39, 3, new String[]{"v5", "phonk", "jovem dinâmico", "escatológica"}, new String[]{}, new String[]{}, new String[]{}),
    TUDO_BEM_GABRIEL("Tudo Bem Gabriel", false, "29/12/2024 - 12:25", 2, 16, 1, new String[]{"v4", "reggae", "gabriel", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    ULTRA_POPULAR("Ultra Popular", false, "11/07/2024 - 14:16", 0, 62, 1, new String[]{"v3.5", "sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    UM_DIA_NA_PRAIA("Um Dia Na Praia", false, "20/07/2024 - 19:59", 0, 78, 1, new String[]{"v3.5", "sertanejo", "lenon", "alison", "bruno", "praia de iracema"}, new String[]{}, new String[]{}, new String[]{}),
    UM_E_DOIS("Um e Dois", false, "28/07/2024 - 11:45", 0, 84, 0, new String[]{"v3.5", "rock", "cd antigo", "referência externa", "reginaldo"}, new String[]{}, new String[]{}, new String[]{}),
    UMA_NOITE_EM_BENFICA("Uma Noite em Benfica", false, "23/11/2024 - 19:41", 2, 2, 1, new String[]{"v4", "pop", "eduarda", "bruno", "mariana", "greice", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    VAI_IGUATU("VAI IGUATU", false, "29/01/2025 - 21:10", 2, 61, 8, new String[]{"v4", "metal", "explícita", "futebol"}, new String[]{"VAI IGUATU (Versão Hino)"}, new String[]{"VAI IGUATU (Versão Hino 1)"}, new String[]{}),
    VAI_KAMILA("Vai Kamila", false, "30/01/2025 - 20:20", 2, 62, 1, new String[]{"v4", "forró piseiro", "gabriel", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    VAMOS_DANCAR_FORRO("Vamos Dançar Forró", false, "26/01/2025 - 15:09", 2, 58, 1, new String[]{"v4", "forró piseiro", "roberta", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    VAMOS_LUCAS("Vamos Lucas", false, "06/09/2024 - 11:54", 1, 21, 3, new String[]{"v3.5", "funk", "lucas moreira", "bruno", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    VEM_PRO_MEU_CORACAO("Vem Pro Meu Coração", false, "05/10/2024 - 19:28", 1, 44, 1, new String[]{"v3.5", "forró piseiro", "eduarda", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    VIBRACOES_DA_RUA("Vibrações da Rua", false, "07/05/2024 - 09:31", 0, 12, 0, new String[]{"udio", "pagode", "letra ia"}, new String[]{}, new String[]{}, new String[]{}),
    VIDA_DE_MARIANA("Vida de Mariana", false, "31/12/2024 - 20:19", 2, 35, 3, new String[]{"v4", "reggae", "mariana", "rima", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    VIDA_EM_RITMO_PESADO("Vida em Ritmo Pesado", false, "07/05/2024 - 09:31", 0, 13, 0, new String[]{"udio", "rock", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    VITAMINA_DA_EDUARDA("Vitamina da Eduarda", false, "12/11/2024 - 15:30", 1, 63, 1, new String[]{"v3.5", "reggae", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    VOCE_E_MINHA_VIDA("Você É Minha Vida", false, "14/02/2026 - 17:18", 3, 37, 11, new String[]{"v5", "forró piseiro", "reginaldo", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    XAROPE_E_VITAMINA_C("Xarope e Vitamina C", false, "10/07/2024 - 21:49", 0, 58, 3, new String[]{"v3.5", "sertanejo", "eduarda", "letra original"}, new String[]{}, new String[]{}, new String[]{}),
    YUSUKE("Yusuke", false, "05/03/2025 - 03:20", 2, 83, 1, new String[]{"v4", "metal", "introbase64", "meel", "letra original", "referência externa", "vídeo do canal"}, new String[]{"Yusuke (Versão Nórdica)"}, new String[]{"Yusuke (Versão Nórdica 1)"}, new String[]{}),
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
    private final String[] instruments;

    Music(String musicName, boolean misterIA, String creation, int album, int number, int subVersions, String[] tags, String[] alternativeVersions, String[] subAlternativeVersions, String[] instruments) {
        this.musicName = musicName;
        this.misterIA = misterIA;
        this.creation = creation;
        this.number = number;
        this.album = album;
        this.subVersions = subVersions;
        this.tags = tags;
        this.alternativeVersions = alternativeVersions;
        this.subAlternativeVersions = subAlternativeVersions;
        this.instruments = instruments;
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

    public String[] getInstruments() {
        return instruments;
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
        for (String alternativeName : getAllVersions()) {
            File file = new File(getMusicsFolder() + getAlternativeFolder(alternativeName) + "/" + getAuthor() + " - " + alternativeName + ".mp3");
            if (file.exists()) {
                files.add(file);
            }
        }
        return files;
    }

    public int listSubVersions() {
        return getSubVersions() + getAllVersions().length;
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
