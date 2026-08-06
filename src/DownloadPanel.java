import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DownloadPanel extends JPanel{

    private JLabel fileName;
    private JProgressBar progressBar;
    private JLabel status;
    private Thread thread;
    private int downloadSpeed;
    private JLabel info;
    private JLabel downloadInfo;
    private int fileSize;
    private int downloadedSize;

    public DownloadPanel(String name)  {
        fileName=new JLabel(name);
        progressBar=new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        status=new JLabel("Downloading...");

        setLayout(new GridLayout(6,1));

        Random r=new Random();
        downloadSpeed=r.nextInt(400)+100;

        fileSize=r.nextInt(1500)+500;
        info = new JLabel("Size: " + fileSize + " MB");
        downloadInfo=new JLabel("Downloaded: " + downloadedSize + " MB / " + fileSize + " MB");

        add(fileName);
        add(info);
        add(downloadInfo);
        add(progressBar);
        add(status);

        startDownload();

    }

    public void startDownload(){
        Runnable downloadTask = () -> {
            for(int i = 0; i <= 100; i++){

                try {

                    progressBar.setValue(i);
                    downloadedSize = fileSize * i / 100;
                    Thread.sleep(downloadSpeed);
                    downloadInfo.setText("Downloaded: " + downloadedSize + " MB / " + fileSize + " MB");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            status.setText("✔ Download Completed");
        };
        thread = new Thread(downloadTask);
        thread.start();
    }
}
