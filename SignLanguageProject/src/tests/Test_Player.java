package tests;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

public class Test_Player {

	public static boolean working = false;

    public static void main(final String[] args) {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test_Player(args);
            }
        });
    }

    private Test_Player(String[] args) {
        JFrame frame = new JFrame("vlcj Tutorial");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();

        Canvas c = new Canvas();
        c.setBackground(Color.black);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(c, BorderLayout.CENTER);
        frame.add(p, BorderLayout.CENTER);


        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();

        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
        frame.setLocation(100, 100);
        frame.setSize(1050, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        mediaPlayer.playMedia("wellington.mp4");
    }

    public static void initialise(){
    	NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

    }

    static JFrame toReturn;

    public static void showVideo(int x, int y, int width, int height, String videofile){
    	toReturn = new JFrame();
    	MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();

        Canvas c = new Canvas();
        c.setBackground(Color.black);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(c, BorderLayout.CENTER);
        toReturn.add(p, BorderLayout.CENTER);


        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();

        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));

        toReturn.setLocation(x, y);
        toReturn.setSize(width, height);
        toReturn.setUndecorated(true);
        toReturn.setVisible(true);

        mediaPlayer.setRepeat(true);

        mediaPlayer.playMedia(videofile);

    }

    public static void disposeFrame(){
    	if(working){
    		toReturn.dispose();
    	}
    }
}