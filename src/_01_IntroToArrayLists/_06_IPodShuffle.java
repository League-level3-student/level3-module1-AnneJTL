package _01_IntroToArrayLists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
    private JFrame window = new JFrame("IPod Shuffle");
    private JPanel panel = new JPanel();
    private JButton surpriseButton = new JButton("Surprise Me !");
    private JButton stopButton = new JButton("Stop");
    private JLabel songTitle = new JLabel();
    private JLabel songTitleValue = new JLabel();
    private JLabel songSinger = new JLabel();
    private JLabel songSingerValue = new JLabel();
    private List<Song> playList = new ArrayList<Song>();
    private Song songToPlay = null;


    public _06_IPodShuffle() {

        // 1. Use the Song class the play the demo.mp3 file.
        Song myFavoriteSong = new Song("Songs/demo.mp3", "unknown", "unknown");
        myFavoriteSong.setDuration(1);
        songSingerValue.setText(myFavoriteSong.getSinger());
        songTitleValue.setText(myFavoriteSong.getTitle());
        myFavoriteSong.play();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
        initGUI();
        populatePlayList();
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

    void initGUI() {
        window.setSize(300, 300);
        panel.setBackground(Color.DARK_GRAY);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimLabel = new Dimension(250, 30);

        songSinger.setPreferredSize(dimLabel);
        songSinger.setForeground(Color.WHITE);
        songSinger.setText("Singer");
        songSingerValue.setPreferredSize(dimLabel);
        songSingerValue.setForeground(Color.CYAN);

        songTitle.setPreferredSize(dimLabel);
        songTitle.setForeground(Color.WHITE);
        songTitle.setText("Song");
        songTitleValue.setPreferredSize(dimLabel);
        songTitleValue.setForeground(Color.CYAN);

        surpriseButton.setPreferredSize(new Dimension(100, 50));
        surpriseButton.setBackground(Color.RED);
        surpriseButton.addActionListener(this);

        stopButton.setPreferredSize(new Dimension(100, 50));
        stopButton.setBackground(Color.PINK);
        stopButton.addActionListener(this);

        panel.add(songSinger);
        panel.add(songSingerValue);
        panel.add(songTitle);
        panel.add(songTitleValue);

        panel.add(surpriseButton);
        panel.add(stopButton);

        window.add(panel);
        window.setVisible(true);
    }

    private void populatePlayList() {
        playList.add(new Song("Songs/chandelier.mp3", "Sia", "Chandelier"));
        playList.add(new Song("Songs/desole.mp3", "Tryo", "Désolé pour hier soir"));
        playList.add(new Song("Songs/you.mp3", "Disclosure", "You & Me"));
        playList.add(new Song("Songs/young.mp3", "Fun", "We Are Young"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton myButton = (JButton) e.getSource();
        Random anInt = new Random();
        int aRandomSong;
        // if (songToPlay != null){

        // }

        if (myButton == surpriseButton) {
            aRandomSong = anInt.nextInt(playList.size());
            songToPlay = playList.get(aRandomSong);
            songTitleValue.setText(songToPlay.getTitle());
            songSingerValue.setText(songToPlay.getSinger());
            songToPlay.play();
        }

        if (myButton == stopButton) {
            songTitleValue.setText("");
            songSingerValue.setText("");
            songToPlay.stop();
        }
    }
}