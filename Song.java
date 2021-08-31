package MusicPlayer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Song {

    Clip clip;
    AudioInputStream audioStream;
    long timePosition;

    private String artist, title;

    public Song(String title, String artist, String s)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.artist = artist;
        this.title = title;
        File file = new File(s);
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    public void play() {

        clip.start();
    }

    public void stop() {
        timePosition = 0;
        clip.stop();

    }

    public void pause() {
        timePosition = clip.getMicrosecondPosition();
        clip.stop();
    }

    public void resume() {
        clip.setMicrosecondPosition(timePosition);
        clip.start();

    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

}
