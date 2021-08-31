package MusicPlayer;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Media extends JFrame {

    // GUI Variables
    JPanel background, top, center, bottom;
    JPanel cleft, cright;
    JPanel panelList, panelPlay, panelStop, panelLoop;
    JLabel artist, name, labelNextSong, labelPlayList;
    JButton prev, next;
    JLabel image;

    ImageIcon prevIm, nextIm;
    ImageIcon startIm, loopIm, stopIm, playListIm, pauseIm;
    JButton start, loop, stop, playList;
    Song s;
    Song songs[] = new Song[13];

    // Variables
    boolean reproducing = false;
    boolean looping = false;
    boolean firstPlay = true;
    boolean reproduceNewSong = false;
    int indexSong = 0;

    public Media() {

        // Creating Objects
        setStandardPlayList();
        s = songs[0];

        background = new JPanel();
        top = new JPanel();
        center = new JPanel();
        cleft = new JPanel();
        cright = new JPanel();
        bottom = new JPanel();

        panelList = new JPanel();
        panelLoop = new JPanel();
        panelPlay = new JPanel();
        panelStop = new JPanel();

        artist = new JLabel();
        name = new JLabel();
        labelNextSong = new JLabel();
        labelPlayList = new JLabel();

        artist.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        name.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        labelNextSong.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        labelPlayList.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        updateLabel(songs[0], songs[1]);

        prevIm = new ImageIcon(
                "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\prevIm.png");
        nextIm = new ImageIcon(
                "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\nextImg.png");

        prev = new JButton();
        next = new JButton();

        start = new JButton();
        stop = new JButton();
        playList = new JButton();
        loop = new JButton();

        startIm = new ImageIcon(
                "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\playImage.png");
        stopIm = new ImageIcon(
                "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\stopImage.png");
        playListIm = new ImageIcon(
                "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\listIM.png");
        loopIm = new ImageIcon("C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\loop.png");
        pauseIm = new ImageIcon(
                "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\pauseImage.png");
        // Laoyuts
        background.setLayout(new GridLayout(3, 1));
        top.setLayout(new GridLayout(4, 1));
        center.setLayout(new GridLayout(1, 3));
        cleft.setLayout(new FlowLayout());
        cright.setLayout(new FlowLayout());
        panelList.setLayout(new FlowLayout());
        panelPlay.setLayout(new FlowLayout());
        panelStop.setLayout(new FlowLayout());
        panelLoop.setLayout(new FlowLayout());
        bottom.setLayout(new GridLayout(1, 4));

        background.setBackground(Color.white);
        top.setBackground(Color.white);
        center.setBackground(Color.white);
        cleft.setBackground(Color.white);
        cright.setBackground(Color.white);
        bottom.setBackground(Color.white);

        // Top Label

        artist.setHorizontalAlignment(JLabel.CENTER);
        name.setHorizontalAlignment(JLabel.CENTER);
        labelPlayList.setHorizontalAlignment(JLabel.CENTER);
        labelNextSong.setHorizontalAlignment(JLabel.CENTER);

        // Center

        prev.setBounds(0, 0, 100, 100);
        prev.setIcon(new ImageIcon(
                prevIm.getImage().getScaledInstance(prev.getWidth(), prev.getHeight(), Image.SCALE_SMOOTH)));
        next.setBounds(0, 0, 100, 100);
        next.setIcon(new ImageIcon(
                nextIm.getImage().getScaledInstance(next.getWidth(), next.getHeight(), Image.SCALE_SMOOTH)));

        prev.setBackground(Color.WHITE);
        next.setBackground(Color.WHITE);
        image = new JLabel(new ImageIcon(
                "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Images\\musicImage.png"));
        prev.setBorder(null);
        next.setBorder(null);

        playList.setBounds(0, 0, 100, 100);
        playList.setIcon(new ImageIcon(playListIm.getImage().getScaledInstance(playList.getWidth(),
                playList.getHeight(), Image.SCALE_SMOOTH)));
        start.setBounds(0, 0, 100, 100);
        start.setIcon(new ImageIcon(
                startIm.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
        stop.setBounds(0, 0, 100, 100);
        stop.setIcon(new ImageIcon(
                stopIm.getImage().getScaledInstance(stop.getWidth(), stop.getHeight(), Image.SCALE_SMOOTH)));
        loop.setBounds(0, 0, 100, 100);
        loop.setIcon(new ImageIcon(
                loopIm.getImage().getScaledInstance(loop.getWidth(), loop.getHeight(), Image.SCALE_SMOOTH)));

        start.setBackground(Color.WHITE);
        loop.setBackground(Color.WHITE);
        stop.setBackground(Color.WHITE);
        playList.setBackground(Color.WHITE);
        start.setBorder(null);
        loop.setBorder(null);
        stop.setBorder(null);
        playList.setBorder(null);

        panelPlay.setBackground(Color.white);
        panelList.setBackground(Color.white);
        panelLoop.setBackground(Color.white);
        panelStop.setBackground(Color.white);
        bottom.setBorder(BorderFactory.createRaisedBevelBorder());
        bottom.setBorder(BorderFactory.createMatteBorder(0, 9, 9, 9, Color.GRAY));
        center.setBorder(BorderFactory.createMatteBorder(0, 9, 0, 9, Color.GRAY));
        top.setBorder(BorderFactory.createMatteBorder(9, 9, 0, 9, Color.GRAY));

        UIManager.put("Button.select", Color.gray);

        top.add(name);
        top.add(artist);
        top.add(labelPlayList);
        top.add(labelNextSong);

        cleft.add(prev);
        cright.add(next);
        center.add(cleft);
        center.add(image);
        center.add(cright);

        panelList.add(playList);
        panelPlay.add(start);
        panelStop.add(stop);
        panelLoop.add(loop);

        bottom.add(panelList);
        bottom.add(panelPlay);
        bottom.add(panelStop);
        bottom.add(panelLoop);

        background.add(top);
        background.add(center);
        background.add(bottom);

        add(background);
        addWindowListener(new WinC());
        start.addActionListener(new reproduceSong());
        stop.addActionListener(new stopSong());
        loop.addActionListener(new loopPlayList());
        prev.addActionListener(new previousSong());
        next.addActionListener(new nextSong());
        playList.addActionListener(new openPlayList());
        setSize(750, 580);
        setMinimumSize(new Dimension(700, 580));
        setTitle("Focil Music Player");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);

    }

    private class WinC extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            if (reproducing) {
                stop();
            }
            setVisible(false);
            dispose();
            JOptionPane.showMessageDialog(null, "Thanks for using this Music Media Player", "Exiting the program...",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private class previousSong implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            s.stop();
            start.setIcon(new ImageIcon(
                    pauseIm.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
            if (indexSong == 0) {
                if (looping) {
                    updateLabel(songs[11], songs[0]);
                    indexSong = 11;
                } else {

                }
            } else {
                indexSong--;
                updateLabel(songs[indexSong], songs[indexSong + 1]);
            }
            s.clip.setMicrosecondPosition(0);
            s = songs[indexSong];
            firstPlay = true;
            s.play();
        }
    }

    private class nextSong implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            s.stop();

            start.setIcon(new ImageIcon(
                    pauseIm.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
            if (indexSong == 11) {
                if (looping) {
                    indexSong = 0;
                    updateLabel(songs[0], songs[1]);
                } else {
                    indexSong = 11;

                }
            } else {
                if (indexSong == 10) {
                    updateLabel(songs[indexSong + 1], songs[0]);
                    labelNextSong.setText("Next Song : ");
                } else {
                    updateLabel(songs[indexSong + 1], songs[indexSong + 2]);
                }

                indexSong++;

            }

            s.clip.setMicrosecondPosition(0);
            s = songs[indexSong];

            firstPlay = true;
            s.play();
        }
    }

    private class reproduceSong implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            play();
        }
    }

    private class stopSong implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            stop();
        }
    }

    private class openPlayList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Integer option;

            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce a number to reproduce a Song\n"
                    + "1. " + songs[0].getTitle() + ", " + songs[0].getArtist() + "\n" + "2. " + songs[1].getTitle()
                    + ", " + songs[1].getArtist() + "\n" + "3. " + songs[2].getTitle() + ", " + songs[2].getArtist()
                    + "\n" + "4. " + songs[3].getTitle() + ", " + songs[3].getArtist() + "\n" + "5. "
                    + songs[4].getTitle() + ", " + songs[4].getArtist() + "\n" + "6. " + songs[5].getTitle() + ", "
                    + songs[5].getArtist() + "\n" + "7. " + songs[6].getTitle() + ", " + songs[6].getArtist() + "\n"
                    + "8. " + songs[7].getTitle() + ", " + songs[7].getArtist() + "\n" + "9. " + songs[8].getTitle()
                    + ", " + songs[8].getArtist() + "\n" + "10. " + songs[9].getTitle() + ", " + songs[9].getArtist()
                    + "\n" + "11. " + songs[10].getTitle() + ", " + songs[10].getArtist() + "\n" + "12. "
                    + songs[11].getTitle() + ", " + songs[11].getArtist() + "\n", "Songs",
                    JOptionPane.INFORMATION_MESSAGE));

            try {
                if (option >= 1 && option <= 12) {

                    if (reproducing) {
                        stop();
                    }
                    indexSong = option - 1;
                    s = songs[indexSong];
                    play();
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid Option : Chose a Valid Option bewteen 1 and 12",
                        "Error...", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private class loopPlayList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (looping) {
                loop.setBackground(Color.white);
                looping = false;

            } else {
                loop.setBackground(Color.green);
                looping = true;
            }
        }

    }

    private void setStandardPlayList() {
        try {
            songs[0] = (new Song("Acuerdate de mi", "Morat",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\AcuerdateDeMi.wav"));
            songs[1] = (new Song("A donde van", "Sebastian Yatra, Alvaro Diaz",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\ADondeVan.wav"));
            songs[2] = (new Song("Ahora te puedes marchar", "Luis Miguel",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\AhoraTePuedesMarchar.wav"));
            songs[3] = (new Song("Cuando nadie ve", "Morat",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\CuandoNadieVe.wav"));
            songs[4] = (new Song("Es mi mujer", "Emmanuel, Alexander Acha",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\EsMiMujer.wav"));
            songs[5] = (new Song("Hasta que me olvides", "Luis Miguel",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\HastaQueMeOlvides.wav"));
            songs[6] = (new Song("La chica de humo", "Emmanuel",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\LaChicaDeHumo.wav"));
            songs[7] = (new Song("La incondicional", "Luis Miguel",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\LaIncondicional.wav"));
            songs[8] = (new Song("La mujer perfecta", "Kurt",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\LaMujerPerfecta.wav"));
            songs[9] = (new Song("Oye", "Sebastian Yatra, Tini",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\Oye.wav"));
            songs[10] = (new Song("Para amarnos mas", "Manuel Mijaeres",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\ParaAmarnosMas.wav"));
            songs[11] = (new Song("Si me tenias", "Manuel Mijares",
                    "C:\\Users\\SAPUEBLA\\Documents\\Programacion\\Projects\\MusicPlayer\\Songs\\SiMeTenias.wav"));

        }

        catch (Exception e) {
        }

    }

    private void updateLabel(Song s1, Song s2) {
        artist.setText("Artist : " + s1.getArtist());
        name.setText("Title : " + s1.getTitle());
        labelPlayList.setText("PlayList : All Songs");
        labelNextSong.setText("Next Song : " + s2.getTitle());

    }

    public void updateLabel() {
        artist.setText("Artist : ");
        name.setText("Title : ");
        labelPlayList.setText("PlayList : All Songs");
        labelNextSong.setText("Next Song : ");
    }

    private void play() {
        if (indexSong == 11) {
            if (looping) {
                updateLabel(songs[indexSong], songs[0]);
            }
        } else {
            updateLabel(songs[indexSong], songs[indexSong + 1]);
        }

        if (firstPlay) {
            s.play();
            start.setIcon(new ImageIcon(
                    pauseIm.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
            reproducing = true;
            firstPlay = false;
        } else {
            if (reproducing) { // Pause
                s.pause();
                start.setIcon(new ImageIcon(
                        startIm.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
                reproducing = false;
            } else { // Play
                s.resume();
                start.setIcon(new ImageIcon(
                        pauseIm.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
                reproducing = true;
            }
        }

    }

    private void stop() {
        s.stop();
        start.setIcon(new ImageIcon(
                startIm.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
    }

}
