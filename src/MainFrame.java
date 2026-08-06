import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame  {

    private JFrame frame;
    private JButton downloadButton;
    private JPanel downloadArea;
    private ArrayList<String> files;
    private int filesIndex=0;

    public MainFrame(){
        frame=new JFrame("File Download Simulator");
        downloadButton=new JButton("Download File");
        downloadArea=new JPanel();
        files=new ArrayList<>();

        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.add(downloadButton, BorderLayout.NORTH);

        frame.add(downloadArea, BorderLayout.CENTER);
        downloadArea.setLayout(new BoxLayout(downloadArea, BoxLayout.Y_AXIS));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        files.add("steam.exe");
        files.add("game.zip");
        files.add("java_project.rar");

        downloadButton.addActionListener(e->{
            if(filesIndex == files.size()){
                filesIndex = 0;
            }
            downloadArea.add(new DownloadPanel(files.get(filesIndex)));
            downloadArea.revalidate();
            downloadArea.repaint();
            filesIndex++;
        });
    }
}



