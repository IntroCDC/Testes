package br.com.introcdc.tests.music;
/*
 * Written by IntroCDC, Bruno Coêlho at 14/02/2025 - 06:55
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public enum Music {
    // IA
    A8_BIT_PIANO("8 Bit Piano", false, "13/11/2024 - 21:49", 1, 4),
    A_PRAIA_E_O_COCO("A Praia e o Coco", false, "16/07/2024 - 10:39", 0, 1),
    A_SOPA_CHEGOU("A Sopa Chegou", false, "08/09/2024 - 17:06", 1, 1),
    A_VIAGEM_PRA_BENFICA("A Viagem pra Benfica", false, "23/11/2024 - 19:43", 2, 1),
    ACORDA_E_LUNCH("Acorda e Lunch", false, "29/06/2024 - 13:02", 0, 1),
    ACORDA_GABRIEL("Acorda Gabriel", false, "04/08/2024 - 18:36", 1, 1),
    ADALGESIO_NO_ROLE("Adalgésio no Rolê", false, "19/07/2024 - 20:55", 0, 1),
    AGUA_DE_COCO_DA_EDUARDA("Água de Coco da Eduarda", false, "01/12/2024 - 04:35", 2, 1),
    ALEATERIO_NA_RUA("Aleatório na Rua", false, "05/07/2024 - 18:27", 0, 1),
    ALFABETO("Alfabeto", false, "31/08/2024 - 04:25", 1, 1),
    ALMOCO_NO_APARTAMENTO("Almoço no Apartamento", false, "29/12/2024 - 14:00", 2, 1),
    AMIGO_VEM_DORMIR_COMIGO("Amigo Vem Dormir Comigo", false, "23/09/2024 - 02:12", 1, 1),
    AMOR_DE_JOGO("Amor de Jogo", false, "16/11/2024 - 00:50", 1, 1),
    ANIVERSARIO_DA_SAFIRA("Aniversário da Safira", false, "17/08/2024 - 12:58", 1, 8),
    AMOR_DESVELADO("Amor Desvelado", false, "31/05/2024 - 05:25", 0, 0),
    ANO_NOVO_EM_IRACEMA("Ano Novo em Iracema", false, "30/12/2024 - 16:25", 2, 3),
    ARROCHA_DO_GABRIEL("Arrocha do Gabriel", false, "31/12/2024 - 19:40", 2, 1),
    ARROCHA_DO_JOVEM_DINAMICO("Arrocha do Jovem Dinâmico", false, "08/02/2025 - 19:23", 2, 5, "Arrocha do Jovem Dinâmico (Versão Arrocha)"),
    ATENCAO_GABRIEL("Atenção Gabriel", false, "29/12/2024 - 11:41", 2, 1),
    AUDIO_WHATSAPP("Áudio WhatsApp", false, "31/08/2024 - 06:06", 1, 1),
    AVENTURA_NA_PRAIA_DE_IRACEMA("Aventura na Praia de Iracema", false, "29/12/2024 - 20:51", 2, 1),
    AVISO_PARA_EDUARDA("Aviso para Eduarda", false, "07/09/2024 - 13:24", 1, 1),
    BANHO_DA_EDUARDA("Banho da Eduarda", false, "23/10/2024 - 13:30", 1, 3),
    BEDWARS_ENTRE_4_JOGADORES("BedWars Entre 4 Jogadores", false, "16/11/2024 - 00:39", 1, 1),
    BERIMBAU("Berimbau", false, "04/08/2024 - 15:31", 1, 1),
    BLUSA_AMARELA("Blusa Amarela", false, "16/07/2024 - 16:52", 0, 1),
    BODE("Bode", false, "25/07/2024 - 22:46", 0, 0),
    BOM_DIA_A_TODOS("Bom Dia a Todos", false, "31/12/2024 - 12:34", 2, 1),
    BOOMBOX_CAIR("Boombox Cair", false, "17/07/2024 - 00:40", 0, 1),
    BOTA_PRA_DANCAR("Bota pra Dançar", false, "27/12/2024 - 01:27", 2, 0),
    CACHORRO_QUENTE("Cachorro Quente", false, "05/09/2024 - 20:05", 1, 3),
    CADE_VOCE_EDUARDA("Cadê Você Eduarda", false, "30/12/2024 - 18:26", 2, 1),
    CAGADA_NERVOSA("Cagada Nervosa", false, "21/10/2024 - 01:59", 1, 7),
    CALA_BOCA("CALA BOCA", false, "19/01/2025 - 17:05", 2, 3),
    CALMA_GABRIEL("Calma Gabriel", false, "30/12/2024 - 16:54", 2, 1),
    CENAS("Cenas", false, "29/10/2024 - 00:53", 1, 3),
    CHEGOU_O_REMEDIO("Chegou o Remédio", false, "02/01/2025 - 11:12", 2, 1),
    CHILL("Chill", false, "07/09/2024 - 08:27", 1, 1),
    CHUVINHA_AMIZADE("Chuvinha Amizade", false, "15/07/2024 - 13:23", 0, 1),
    CLAUDINHO("Claudinho", false, "11/01/2025 - 10:38", 2, 3),
    COCO("Cocô", false, "22/09/2024 - 11:30", 1, 1),
    COISAS_NO_APARTAMENTO("Coisas no Apartamento", false, "12/11/2024 - 10:28", 1, 1),
    COME_EDUARDA("Come Eduarda", false, "13/01/2025 - 10:36", 2, 2),
    COMIDAS_GOSTOSINHAS("Comidas Gostosinhas", false, "04/07/2024 - 14:06", 0, 1),
    DEITADOS("Deitados", false, "04/08/2024 - 17:05", 1, 1),
    DESENHA_EDUARDA("Desenha, Eduarda", false, "17/07/2024 - 00:47", 0, 1),
    DESILUSAO_NO_FORRO("Desilusão no Forró", false, "19/07/2024 - 23:45", 0, 3),
    DESPERTAR_INCANSAVEL("Despertar Incansavel", false, "18/07/2024 - 19:25", 0, 1),
    DESTROY_EVERYTHING("Destroy Everything", false, "26/01/2025 - 22:11", 2, 3),
    DISPUTA_NO_MUSHMC("Disputa no MushMC", false, "08/11/2024 - 00:38", 1, 1),
    DIVERSAO_NO_MUSH("Diversão no Mush", false, "24/04/2024 - 12:46", 0, 0),
    DIARIO_DE_LUCAS("Diário de Lucas", false, "30/09/2024 - 17:20", 1, 1),
    DOCES_DE_JULIANA("Doces de Juliana", false, "29/05/2024 - 13:01", 0, 1),
    DOMINIOS_DIGITAIS("Domínios Digitais", false, "05/05/2024 - 01:55", 0, 0),
    DONO_DO_PODER("Dono do Poder", false, "05/05/2024 - 01:58", 0, 0),
    DOR_DE_BARRIGA("Dor de Barriga", false, "09/02/2025 - 16:24", 2, 1),
    EDUARDA_INSPIRADA("Eduarda Inspirada", false, "17/07/2024 - 01:17", 0, 1),
    EDUARDA_NA_FAVELA("Eduarda na Favela", false, "03/11/2024 - 00:50", 1, 1),
    EDUARDA("Eduarda", false, "13/06/2024 - 20:02", 0, 1, "Eduarda (Versão Alternativa)", "Eduarda (Versão Forró)", "Eduarda (Versão Infantil)", "Eduarda (Versão Pagode)", "Eduarda (Versão Piano Calmo)", "Eduarda (Versão Piano)", "Eduarda (Versão Reggae)", "Eduarda (Versão Alternativa 2)", "Eduarda (Versão Forró 2)", "Eduarda (Versão Pagode 2)", "Eduarda (Versão Piano 1)", "Eduarda (Versão Piano 2)"),
    ELE_E_O_GABRIEL("Ele é o Gabriel", false, "01/01/2025 - 14:55", 2, 1),
    ENVIANDO_O_KINDOME("Enviando o Kindome", false, "27/11/2024 - 22:20", 2, 1),
    ESCOLHA_DA_BLUSA("Escolha da Blusa", false, "16/07/2024 - 16:52", 0, 1),
    ESCOVANDO_OS_DENTES("Escovando os Dentes", false, "02/01/2025 - 13:50", 2, 1),
    EU_TE_AMO_EDUARDA("Eu Te Amo Eduarda", false, "29/12/2024 - 13:09", 2, 1),
    EX_DJS("Ex DJs", false, "08/09/2024 - 16:22", 1, 1),
    FAYE("Faye", false, "02/01/2025 - 17:10", 2, 1),
    FERNANDO_NO_APARTAMENTO("Fernando no Apartamento", false, "12/11/2024 - 10:28", 1, 3),
    FIOS_REBELDES("Fios Rebeldes", false, "01/05/2024 - 09:49", 0, 0),
    FOGUETE_TRICOLOR("Foguete Tricolor", false, "29/08/2024 - 02:36", 1, 7),
    FOME_DA_LORENA("Fome da Lorena", false, "31/12/2024 - 12:45", 2, 1),
    FRASES_DE_EDUARDA("Frases de Eduarda", false, "17/07/2024 - 01:06", 0, 1),
    FRASES_DE_LUCIVANIA("Frases de Lucivania", false, "01/01/2025 - 20:35", 2, 1),
    FRASES_NO_APARTAMENTO("Frases no Apartamento", false, "12/11/2024 - 10:28", 1, 1),
    GABRIEL_ESCOVANDO("Gabriel Escovando", false, "19/01/2025 - 11:10", 2, 1),
    GABRIEL_PARA_JABRIEL("Gabriel para Jabriel", false, "31/12/2024 - 20:10", 2, 1),
    GABRIEL("Gabriel", false, "29/12/2024 - 14:05", 2, 1),
    GIGANTES_DO_FORROZAO("Gigantes do Forrozão", false, "07/05/2024 - 16:52", 0, 1),
    GOSTO_DE_COCO("Gosto de Cocô", false, "16/11/2024 - 14:05", 1, 9),
    GRANDE_ENIGMA("Grande Enigma", false, "02/08/2024 - 17:49", 1, 1),
    HIPER_CINEMATIC("Hiper Cinematic", false, "04/07/2024 - 12:46", 0, 1),
    HOMENAGEM_A_MINHA_VO("Homenagem a minha vó", false, "04/09/2024 - 17:45", 1, 1),
    INTRO_NA_CHAMADA("Intro na Chamada", false, "20/11/2024 - 18:28", 2, 8),
    JAVA_CODING("Java Coding", false, "22/01/2025 - 22:00", 2, 1),
    JINGLE_DAS_GATINHAS("Jingle das Gatinhas", false, "19/06/2024 - 00:33", 0, 0, "Jingle das Gatinhas (Versão Metal)"),
    JOAO_BRENO_E_O_LEGO("João Breno e o Lego", false, "15/09/2024 - 12:29", 1, 1),
    JUBARACACHUBA("Jubaracachuba", false, "20/06/2024 - 20:59", 0, 3),
    KINDOME("Kindome", false, "31/08/2024 - 04:03", 1, 3),
    KIRITO_O_BODE("Kirito o Bode", false, "11/02/2025 - 00:58", 2, 3, "Kirito o Bode (Versão Kirito)"),
    KIRITO("Kirito", false, "31/08/2024 - 01:30", 1, 1),
    LENON_NO_MICROFONE("Lenon no Microfone", false, "27/12/2024 - 01:30", 2, 0),
    LINDA_EDUARDA("Linda Eduarda", false, "29/12/2024 - 22:11", 2, 1),
    LIVE_DE_MINE("Live de Mine", false, "09/01/2025 - 19:30", 2, 3),
    LOJA_PARA_HYAN("Loja para Hyan", false, "12/02/2025 - 19:45", 2, 3),
    LORENA("Lorena", false, "30/12/2024 - 18:01", 2, 4, "Lorena (Versão Eletrônica)", "Lorena (Versão Funk)", "Lorena (Versão Opera)", "Lorena (Versão Piseiro)", "Lorena (Versão Rap)", "Lorena (Versão Reggae)", "Lorena (Versão Terror)"),
    LUCA_PROIBIDO("Luca Proibido", false, "02/02/2025 - 23:26", 2, 1),
    LUCAS_DORMINHOCO("Lucas Dorminhoco", false, "08/09/2024 - 12:45", 1, 4),
    LUCAS_FAZENDO_COCO("Lucas Fazendo Cocô", false, "12/01/2025 - 02:53", 2, 1),
    LUCAS("Lucas", false, "30/12/2024 - 17:08", 2, 1),
    LUCIVANIA("Lucivania", false, "01/01/2025 - 19:42", 2, 1),
    MAJOR_SABINO("Major Sabino", false, "22/08/2024 - 22:03", 1, 6, "Major Sabino (Versão Gospel)", "Major Sabino (Versão Metal)", "Major Sabino (Versão Gospel 1)", "Major Sabino (Versão Metal 1)", "Major Sabino (Versão Metal 2)", "Major Sabino (Versão Metal 3)"),
    MANHA_DE_METAL("Manhã de Metal", false, "15/05/2024 - 08:58", 0, 0),
    MARIA_EDUARDA_NO_FORRO("Maria Eduarda No Forró", false, "11/08/2024 - 18:51", 1, 1),
    MARIA_EDUARDA("Maria Eduarda", false, "09/02/2025 - 16:45", 2, 1),
    MARIAUM_E_JAPONESA("Mariaum e Japonesa", false, "03/01/2025 - 14:51", 2, 1, "Mariaum e Japonesa (Versão Mariaum)"),
    MC_HARIEL_PARA_SAFIRA("MC Hariel para Safira", false, "18/05/2024 - 18:17", 0, 1),
    MCGPLAYS_PARA_VINICIUS("MCGPlays para Vinicius", false, "06/06/2024 - 09:26", 0, 0),
    MENSAGENS("Mensagens", false, "27/10/2024 - 04:54", 1, 5),
    MEU_SONHO_DO_DIA_2("Meu Sonho do Dia 2", false, "02/01/2025 - 11:19", 2, 3),
    MISSOES_PARA_HYAN("Missões para Hyan", false, "05/12/2024 - 20:20", 2, 3),
    MUSHMC("MushMC", false, "10/02/2025 - 19:11", 2, 1),
    MUSICA_PARA_CAGAR("Música para Cagar", false, "04/07/2024 - 20:58", 0, 5),
    NATUREZA("Natureza", false, "21/10/2024 - 02:23", 1, 7),
    NAYARA("Nayara", false, "22/07/2024 - 02:52", 0, 1),
    NOSSO_RELACIONAMENTO("Nosso Relacionamento", false, "14/11/2024 - 18:48", 1, 1),
    NAO_PODE_BEBER("Não Pode Beber", false, "29/12/2024 - 19:34", 2, 1),
    O_AMOR_DE_EDUARDA_PELO_COCO("O Amor de Eduarda Pelo Cocô", false, "22/09/2024 - 11:33", 1, 0),
    O_DONO_DO_SERVIDOR("O Dono do Servidor", false, "01/06/2024 - 19:54", 0, 0),
    O_DUMP_DO_MYSQL("O Dump do MySQL", false, "14/05/2024 - 00:53", 0, 2),
    O_MARIAUM("O Mariaum", false, "20/10/2024 - 21:37", 1, 1),
    OLHANDO_PARA_O_LADO("Olhando para o Lado", false, "10/07/2024 - 17:29", 0, 1),
    ONI_CHAN("Oni-Chan", false, "03/01/2025 - 14:34", 2, 1),
    OURO_BRANCO_PARA_LUCAS("Ouro Branco para Lucas", false, "17/11/2024 - 07:42", 1, 3),
    PALAVRAS_GUARDADAS("Palavras Guardadas", false, "30/06/2024 - 19:46", 0, 1),
    PARABENS_MARIAUM("Parabéns Mariaum", false, "11/10/2024 - 20:39", 1, 3),
    PEDIDO_DE_MASCARA("Pedido de Máscara", false, "11/07/2024 - 14:16", 0, 3),
    PERFEITA("Perfeita", false, "02/12/2024 - 23:48", 2, 1),
    PESSOA_ACIMA("Pessoa Acima", false, "08/01/2025 - 17:47", 2, 3),
    PLUGIN_DE_REPORT("Plugin de Report", false, "23/10/2024 - 21:08", 1, 0),
    POMBO("Pombo", false, "09/09/2024 - 18:26", 1, 1),
    PROCURA_DE_EMPREGO("Procura de Emprego", false, "01/07/2024 - 08:31", 0, 1),
    PROMESSA_DA_SULAMERICANA("Promessa da Sulamericana", false, "26/09/2024 - 19:13", 1, 1),
    PUDIM_E_TORTA_DE_FRANGO("Pudim e Torta de Frango", false, "31/07/2024 - 17:35", 0, 1),
    QUE_MARAVILHA("Que Maravilha", false, "15/05/2024 - 23:29", 0, 1),
    RAIVA("Raiva", false, "08/02/2025 - 20:44", 2, 5),
    REABERTURA_DO_KINDOME("Reabertura do Kindome", false, "30/11/2024 - 13:08", 2, 1),
    REGISTRO_DE_FUTEBOL("Registro de Futebol", false, "09/07/2024 - 21:55", 0, 1),
    REINOS_DE_JOGO("Reinos de Jogo", false, "24/04/2024 - 12:57", 0, 2),
    RITMO_INSOLENTE("Ritmo Insolente", false, "29/04/2024 - 16:01", 0, 0),
    SAFIRA_VS_EDUARDA("Safira vs Eduarda", false, "23/07/2024 - 02:20", 0, 9, "Safira vs Eduarda (Versão Funk)", "Safira vs Eduarda (Versão Metal)", "Safira vs Eduarda (Versão Minimalista)", "Safira vs Eduarda (Versão Pagode)", "Safira vs Eduarda (Versão Piano)", "Safira vs Eduarda (Versão Metal 1)", "Safira vs Eduarda (Versão Metal 2)", "Safira vs Eduarda (Versão Metal 3)", "Safira vs Eduarda (Versão Pagode 1)"),
    SAFIRA("Safira", false, "03/01/2025 - 18:27", 2, 2),
    SARAIVA("Saraiva", false, "09/02/2025 - 15:05", 2, 8),
    SETE_NA_CHAMADA("Sete na Chamada", false, "06/12/2024 - 21:57", 2, 3),
    SHOW_DE_COMEDIA("Show de Comédia", false, "31/08/2024 - 20:26", 1, 2),
    SKATE("Skate", false, "29/12/2024 - 16:18", 2, 1),
    SOLO_DE_GUITARRA_PISEIRO("Solo de Guitarra Piseiro", false, "27/12/2024 - 01:45", 2, 1),
    SOM_DO_SOL("Som do Sol", false, "07/06/2024 - 17:58", 0, 0),
    SONHOS_DIGITAIS("Sonhos Digitais", false, "03/06/2024 - 19:10", 0, 0),
    SONO_DA_EDUARDA("Sono da Eduarda", false, "28/01/2025 - 22:56", 2, 4),
    SONO_DO_GABRIEL("Sono do Gabriel", false, "19/01/2025 - 10:03", 2, 6),
    SONO_DO_MARIAUM("Sono do Mariaum", false, "05/02/2025 - 03:28", 2, 1),
    STELLA_OVERTURE("Stella Overture", false, "15/07/2024 - 06:52", 0, 1),
    SUVACO_CABELUDO("Suvaco Cabeludo", false, "18/05/2024 - 10:42", 0, 0),
    TAVA_GOSTOSO("Tava Gostoso", false, "29/12/2024 - 14:29", 2, 1),
    TE_AMAR_DE_NOVO("Te Amar de Novo", false, "19/07/2024 - 21:00", 0, 3),
    TE_AMO_DEMAIS("Te Amo Demais", false, "11/08/2024 - 13:32", 1, 7),
    TESTE_DE_VOZ("Teste de voz", false, "31/08/2024 - 04:37", 1, 1),
    TEXTAO_EM_PIANO("Textão em Piano", false, "10/07/2024 - 22:53", 0, 1),
    TEXTAO_EM_SERTANEJO("Textão em Sertanejo", false, "10/07/2024 - 22:52", 0, 1),
    THE_END("The End", false, "05/02/2025 - 01:29", 2, 4),
    THE_IMPOSSIBLE("The Impossible", false, "15/02/2025 - 04:35", 2, 5),
    TIA_FOFA("Tia Fofa", false, "29/12/2024 - 14:07", 2, 1),
    TODO_MUNDO("Todo Mundo", false, "04/07/2024 - 13:04", 0, 1),
    TODOS_NA_SALA("Todos na Sala", false, "01/01/2025 - 15:01", 2, 1),
    TOMA_LUCAS("Toma Lucas", false, "01/01/2025 - 13:50", 2, 1),
    TRANQUIL_DREAMSCAPES("Tranquil Dreamscapes", false, "23/07/2024 - 17:19", 0, 1),
    TROCA_DE_ROUPAS_NO_PORTO_DAS_DUNAS("Troca de Roupas no Porto das Dunas", false, "08/12/2024 - 04:20", 2, 1),
    TRES_PATINHOS("Três Patinhos", false, "08/01/2025 - 17:37", 2, 5),
    TUDO_BEM_GABRIEL("Tudo Bem Gabriel", false, "29/12/2024 - 12:25", 2, 1),
    ULTRA_POPULAR("Ultra Popular", false, "11/07/2024 - 14:16", 0, 1),
    UM_DIA_NA_PRAIA("Um Dia Na Praia", false, "20/07/2024 - 19:59", 0, 1),
    UM_E_DOIS("Um e Dois", false, "28/07/2024 - 11:45", 0, 0),
    UMA_NOITE_EM_BENFICA("Uma Noite em Benfica", false, "23/11/2024 - 19:41", 2, 1),
    VAI_IGUATU("VAI IGUATU", false, "29/01/2025 - 21:10", 2, 8, "VAI IGUATU (Versão Hino)", "VAI IGUATU (Versão Hino 2)"),
    VAI_KAMILA("Vai Kamila", false, "30/01/2025 - 20:20", 2, 1),
    VAMOS_DANCAR_FORRO("Vamos Dançar Forró", false, "26/01/2025 - 15:09", 2, 1),
    VAMOS_LUCAS("Vamos Lucas", false, "06/09/2024 - 11:54", 1, 3),
    VEM_PRO_MEU_CORACAO("Vem Pro Meu Coração", false, "05/10/2024 - 19:28", 1, 1),
    VIBRACOES_DA_RUA("Vibrações da Rua", false, "07/05/2024 - 09:31", 0, 0),
    VIDA_DE_MARIANA("Vida de Mariana", false, "31/12/2024 - 20:19", 2, 3),
    VIDA_EM_RITMO_PESADO("Vida em Ritmo Pesado", false, "07/05/2024 - 09:31", 0, 0),
    VITAMINA_DA_EDUARDA("Vitamina da Eduarda", false, "12/11/2024 - 15:30", 1, 1),
    XAROPE_E_VITAMINA_C("Xarope e Vitamina C", false, "10/07/2024 - 21:49", 0, 3),

    // Mister IA
    AGUINHA_GELADINHA("Aguinha Geladinha", true, "16/07/2024 - 16:38", 0, 1, "Aguinha Geladinha (Versão Piano)", "Aguinha Geladinha (Versão Vozes do Inferno)"),
    AGUINHA_GELADINHA_VERSAO_PISEIRO("Aguinha Geladinha (Versão Piseiro)", true, "20/09/2024 - 18:50", 1, 0),
    AGUINHA_QUENTINHA("Aguinha Quentinha", true, "12/11/2024 - 17:34", 1, 9),
    ALEXA_COM_RAIVA("Alexa com Raiva", true, "21/10/2024 - 01:26", 1, 4),
    ASTACARABUMTS("Astacarábumts", true, "19/06/2024 - 00:07", 0, 3, "Astacarábumts (Bass Boost)", "Astacarábumts (Versão Piseiro)", "Astacarábumts (Versão Piseiro 1)"),
    ATRAPALHADOR("Atrapalhador", true, "04/07/2024 - 13:33", 0, 2, "Atrapalhador (Versão Piano)", "Atrapalhador (Versão Piseiro)", "Atrapalhador (Versão Piano 1)", "Atrapalhador (Versão Piano 2)"),
    ATRAPALHADOR_VERSAO_PISEIRO("Atrapalhador (Versão Piseiro)", true, "19/09/2024 - 13:28", 1, 0),
    AVENTURA_NO_MUNDO_DE_BLOCOS("Aventura no Mundo de Blocos", true, "19/10/2024 - 20:33", 1, 1),
    COCO_NA_ARARIUS("Cocô na Arariús", true, "04/07/2024 - 12:32", 0, 1),
    COMENTARIOS("Comentários", true, "05/07/2024 - 12:58", 0, 0),
    COMIDA_GOSTOSA("Comida Gostosa", true, "18/06/2024 - 10:48", 0, 1, "Comida Gostosa (Versão Metal 1)"),
    COMIDA_GOSTOSA_VERSAO_METAL("Comida Gostosa (Versão Metal)", true, "19/09/2024 - 12:16", 1, 0),
    CORRE_PRA_PRAIA("Corre pra Praia", true, "16/07/2024 - 22:30", 0, 1),
    DESCOLADINHO("Descoladinho", true, "19/06/2024 - 02:43", 0, 0),
    DIX_TRACK_DETRAN("Dix Track Detran", true, "04/07/2024 - 12:03", 0, 1, "Dix Track Detran (Versão Piseiro 1)"),
    DIX_TRACK_DETRAN_VERSAO_PISEIRO("Dix Track Detran (Versão Piseiro)", true, "29/09/2024 - 23:50", 1, 0),
    DOIDAO("Doidão", true, "22/10/2024 - 23:09", 1, 9),
    ENGRACADINHO("Engraçadinho", true, "25/06/2024 - 02:55", 0, 1, "Engraçadinho (Versão Alternativa)", "Engraçadinho (Versão Funk)", "Engraçadinho (Versão Metal)", "Engraçadinho (Versão Piseiro)", "Engraçadinho (Versão Pop)", "Engraçadinho (Versão Metal 1)", "Engraçadinho (Versão Metal 2)", "Engraçadinho (Versão Metal 3)", "Engraçadinho (Versão Piseiro 1)"),
    ENGRACADAO("ENGRAÇADÃO", true, "25/09/2024 - 14:44", 1, 9, "ENGRAÇADÃO (Versão Pop)", "ENGRAÇADÃO (Versão Reggae)", "ENGRAÇADÃO (Versão Épica)", "ENGRAÇADÃO (Versão Épica 1)"),
    ENGRACADAO_VERSAO_PISEIRO("ENGRAÇADÃO (Versão Piseiro)", true, "25/09/2024 - 15:00", 1, 0),
    HACKINGS("Hackings", true, "29/08/2024 - 01:33", 1, 2, "Hackings (Versão Piseiro)"),
    HA_UM_POTO("Há Um Potó", true, "27/04/2024 - 01:26", 0, 3),
    IMBATIVEL_MATHEUS("Imbatível Matheus", true, "15/09/2024 - 12:29", 1, 3),
    INTROBASE64("IntroBase64", true, "09/06/2024 - 06:39", 0, 2, "IntroBase64 (Versão Metal)"),
    INVOCACOES("Invocações", true, "08/06/2024 - 18:30", 0, 0),
    JOGOS_DO_MUSH("Jogos do Mush", true, "24/04/2024 - 12:46", 0, 3),
    JOVEM_DINAMICO("Jovem Dinâmico", true, "27/04/2024 - 01:14", 0, 7),
    JUNIOR_CHATO("Junior Chato", true, "19/06/2024 - 03:07", 0, 0),
    LAGA_LAMA("Laga Lama", true, "26/04/2024 - 13:59", 0, 1, "Laga Lama (Versão Alternativa)"),
    MENININHOS_ENGRACADINHOS("Menininhos Engraçadinhos", true, "18/06/2024 - 08:09", 0, 3, "Menininhos Engraçadinhos (Versão Alternativa)", "Menininhos Engraçadinhos (Versão Piano)", "Menininhos Engraçadinhos (Versão Piseiro)", "Menininhos Engraçadinhos (Versão Metal 1)"),
    MENININHOS_ENGRACADINHOS_VERSAO_METAL("Menininhos Engraçadinhos (Versão Metal)", true, "19/09/2024 - 10:45", 1, 0),
    MINEPARTY("MineParty", true, "19/06/2024 - 03:53", 0, 3),
    MUITO_PESADO("Muito Pesado", true, "09/07/2024 - 14:16", 0, 0),
    MUSICA_EMPOLGANTE_E_IRRITANTE("Música Empolgante e Irritante", true, "25/07/2024 - 19:01", 0, 1),
    NOSSO_DJ("Nosso DJ", true, "19/06/2024 - 03:14", 0, 1),
    OBSESSOR_DEVORADOR("Obsessor Devorador", true, "06/10/2024 - 15:07", 1, 5, "Obsessor Devorador (Versão Arrocha)", "Obsessor Devorador (Versão Piseiro)", "Obsessor Devorador (Versão Piseiro 1)"),
    PATINETE_ELETRICO("Patinete Elétrico", true, "19/06/2024 - 02:08", 0, 5, "Patinete Elétrico (Versão Arrocha)", "Patinete Elétrico (Versão Funk)", "Patinete Elétrico (Versão Romantica)"),
    PATINETE_ELETRICO_VERSAO_PISEIRO("Patinete Elétrico (Versão Piseiro)", true, "27/09/2024 - 04:25", 1, 0),
    RAFAEL_AULER_3_5("Rafael Auler 3.5", true, "07/06/2024 - 22:39", 0, 0, "Rafael Auler 3.5 (Versão Alternativa)", "Rafael Auler 3.5 (Versão Eletrônica)", "Rafael Auler 3.5 (Versão Pagode)", "Rafael Auler 3.5 (Versão Piano)", "Rafael Auler 3.5 (Versão Piseiro)", "Rafael Auler 3.5 (Versão Seresta)", "Rafael Auler 3.5 (Versão Sofrência)", "Rafael Auler 3.5 (Versão Épica)", "Rafael Auler 3.5 (Versão Pagode 1)", "Rafael Auler 3.5 (Versão Piano 1)", "Rafael Auler 3.5 (Versão Piseiro 1)"),
    RITUAL_DAS_GATINHAS("Ritual das Gatinhas", true, "13/06/2024 - 06:33", 0, 1, "Ritual das Gatinhas (Versão Piseiro)", "Ritual das Gatinhas (Versão Piseiro 1)"),
    SANIDADE_MENTAL("Sanidade Mental", true, "27/09/2024 - 05:42", 1, 9, "Sanidade Mental (Versão Piseiro)", "Sanidade Mental (Versão Seresta)"),
    SOFREDOR("Sofredor", true, "28/08/2024 - 23:02", 1, 8),
    SR_DUVIDA("Sr Dúvida", true, "29/07/2024 - 06:44", 0, 3, "Sr Dúvida (Versão Piseiro)", "Sr Dúvida (Versão Piseiro 1)", "Sr Dúvida (Versão Piseiro 2)"),
    STAND_UP_DO_DIEGO("Stand UP do Diego", true, "04/09/2024 - 17:14", 1, 2),
    STILL_WATER("Still Water", true, "01/11/2024 - 01:50", 1, 1),
    TRANSMISSAO_ESTATICA("Transmissão Estática", true, "06/06/2024 - 13:40", 0, 1),
    TUBARAO("Tubarão", true, "18/12/2024 - 16:08", 2, 3),
    VOCE_FEZ_COCO("Você fez cocô", true, "26/04/2024 - 01:46", 0, 0),
    ;

    private final String musicName;
    private final boolean misterIA;
    private final String creation;
    private final int album;
    private final int subVersions;
    private final String[] alternativeVersions;

    Music(String musicName, boolean misterIA, String creation, int album, int subVersions, String... alternativeVersions) {
        this.musicName = musicName;
        this.misterIA = misterIA;
        this.creation = creation;
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

    public String getMusicFileName() {
        return getAuthor() + " - " + getMusicName() + ".mp3";
    }

    public String getMusicPath() {
        return getAuthor() + "/" + getMusicFileName();
    }

    public File getMusicFile() {
        return new File(getMusicsFolder() + getMusicPath());
    }

    public String getLyricsPath() {
        return "assets/lyrics/" + getMusicFileName().toLowerCase() + ".txt";
    }

    public File getLyricsFile() {
        return new File(getMusicsFolder() + getLyricsPath());
    }

    public String getRemasteredPath() {
        return getAuthor() + "/" + getMusicName() + " (Remastered).mp3";
    }

    public File getRemasteredFile() {
        return new File(getMusicsFolder() + getRemasteredPath());
    }

    public boolean hasRemastered() {
        return getRemasteredFile().exists();
    }

    public String getMusicURL() {
        return getMusicsURL() + getAuthor().replace(" ", "%20") + "/" + getMusicFileName().replace(" ", "%20");
    }

    public String getSubVersionMusicURL(int number) {
        return getMusicURL() + getAuthor().replace(" ", "%20") + "%20Others/" + getMusicName() + "%20" + number + ".mp3";
    }

    public String getAlternativeFolder(String fileName) {
        return getAuthor() + (new File(getMusicsFolder() + getAuthor() + " Cover", fileName).exists() ? " Cover" : " Cover Others");
    }

    public String getMusicAlternativeURL(String fileName) {
        return getMusicsURL() + getAlternativeFolder(fileName) + "/" + fileName.replace(" ", "%20");
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

    public static String albumName(int album) {
        return switch (album) {
            case 0 -> "Antigo Testamento";
            case 1 -> "Novo Testamento";
            case 2 -> "Tempos Modernos";
            default -> "Revolução Sonora";
        };
    }

    public static String getMusicsFolder() {
        return "F:/Musicas/";
    }

    public static String getMusicsURL() {
        return "http://musics.introcdc.com/";
    }

}
