package br.com.introcdc.tests;
/*
 * Written by IntroCDC, Bruno Coêlho at 17/12/2022 - 01:31
 */

import br.com.introcdc.tests.advmusic.AMMain;
import br.com.introcdc.tests.advmusic.AdvMusic;
import br.com.introcdc.tests.audio.Audio;
import br.com.introcdc.tests.bot.Bot;
import br.com.introcdc.tests.bot.WhatsAppBot;
import br.com.introcdc.tests.discord.MessageSender;
import br.com.introcdc.tests.discord.SpoteffChecker;
import br.com.introcdc.tests.elevator.ElevatorMain;
import br.com.introcdc.tests.files.*;
import br.com.introcdc.tests.game.GameGUI;
import br.com.introcdc.tests.game.GameMain;
import br.com.introcdc.tests.guitarhero.GuitarHeroBot;
import br.com.introcdc.tests.instagram.InstagramTools;
import br.com.introcdc.tests.introcdc.VideoFrames;
import br.com.introcdc.tests.kindome.ChatReader;
import br.com.introcdc.tests.love.LoveMeter;
import br.com.introcdc.tests.narrator.CameraNarrator;
import br.com.introcdc.tests.ping.PingTest;
import br.com.introcdc.tests.social.SocialCalculator;
import br.com.introcdc.tests.value.ValueCalculator;

public class Main {

    public static void main(String[] args) {
        String fileName = getFileName().toUpperCase().replace(".JAR", "");
        if (fileName == null || fileName.isEmpty()) {
            System.out.println("Nome de arquivo não reconhecido, sugestões:");
            for (Program program : Program.values()) {
                System.out.println(program.toString() + ".JAR");
            }
            return;
        }
        for (Program program : Program.values()) {
            if (fileName.equalsIgnoreCase(program.toString())) {
                program.main(args);
                return;
            }
        }
        System.out.println("Nome de arquivo não reconhecido, sugestões:");
        for (Program program : Program.values()) {
            System.out.println(program.toString() + ".JAR");
        }
    }

    public static String arg(String[] args) {
        return String.join(" ", args);
    }

    public enum Program {
        ADVMUSIC(AdvMusic.class),
        AMMAIN(AMMain.class),
        AUDIO(Audio.class),
        BOT(Bot.class),
        WHATSAPPBOT(WhatsAppBot.class),
        MESSAGESENDER(MessageSender.class),
        SPOTEFFCHECKER(SpoteffChecker.class),
        ELEVATORMAIN(ElevatorMain.class),
        IMAGECONVERTER(ImageConverter.class),
        IMAGERESOLUTION(ImageResolutionConverter.class),
        MUSICORGANIZER(MusicOrganizer.class),
        PRINTORGANIZER(PrintOrganizer.class),
        PRINTSCREEN(PrintScreen.class),
        PRINTSEARCHER(PrintSearcher.class),
        GAMEGUI(GameGUI.class),
        GAMEMAIN(GameMain.class),
        GUITARHEROBOT(GuitarHeroBot.class),
        INSTAGRAMTOOLS(InstagramTools.class),
        VIDEOFRAMES(VideoFrames.class),
        CHATREADER(ChatReader.class),
        LOVEMETER(LoveMeter.class),
        MUSIVERIFIER(MusicOrganizer.class),
        CAMERANARRETOR(CameraNarrator.class),
        PINGTEST(PingTest.class),
        SOCIALCALCULATOR(SocialCalculator.class),
        VALUECALCULATOR(ValueCalculator.class);

        private final Class clazz;

        Program(Class clazz) {
            this.clazz = clazz;
        }

        public Class getClazz() {
            return clazz;
        }

        public void main(String[] args) {
            try {
                clazz.getDeclaredMethod("main", String[].class).invoke(null, (Object) args);
            } catch (Exception exception) {
                System.out.println("Ocorreu um erro ao executar o método!");
                exception.printStackTrace();
            }
        }

    }

    public static String getFileName() {
        try {
            String jarPath = Main.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();

            return jarPath.substring(jarPath.lastIndexOf("/") + 1);
        } catch (Exception ignored) {
        }
        return null;
    }

}
