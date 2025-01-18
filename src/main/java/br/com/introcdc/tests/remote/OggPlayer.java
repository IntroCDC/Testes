package br.com.introcdc.tests.remote;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class OggPlayer {
    static OggPlayer player;

    public static void main(final String[] args) {
        OggPlayer.player = new OggPlayer();
        OggPlayer.player.play(System.getProperty("user.dir") + "/myFile.ogg");
    }

    private SourceDataLine getLine(final AudioFormat audioFormat) throws LineUnavailableException {
        SourceDataLine res = null;
        final DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        res = (SourceDataLine) AudioSystem.getLine(info);
        res.open(audioFormat);
        return res;
    }

    public void play(final String filePath) {
        try {
            final File file = new File(filePath);
            // Get AudioInputStream from given file.
            final AudioInputStream in = AudioSystem.getAudioInputStream(file);
            AudioInputStream din = null;
            if (in != null) {
                final AudioFormat baseFormat = in.getFormat();
                final AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
                // Get AudioInputStream that will be decoded by underlying
                // VorbisSPI
                din = AudioSystem.getAudioInputStream(decodedFormat, in);
                // Play now !
                this.rawplay(decodedFormat, din);
                in.close();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private void rawplay(final AudioFormat targetFormat, final AudioInputStream din) throws IOException, LineUnavailableException {
        final byte[] data = new byte[4096];
        final SourceDataLine line = this.getLine(targetFormat);
        if (line != null) {
            // Start
            line.start();
            int nBytesRead = 0;
            while (nBytesRead != -1) {
                nBytesRead = din.read(data, 0, data.length);
                if (nBytesRead != -1) {
                }
            }
            // Stop
            line.drain();
            line.stop();
            line.close();
            din.close();
        }
    }
}
