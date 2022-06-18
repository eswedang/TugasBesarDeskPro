/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DeskPro;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;
import org.opencv.videoio.VideoCapture;
/**
 *
 * @author ThinkPad X270
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    String source = "C:\\javacv-resource\\sources\\data\\haarcascades\\haarcascade_frontalface_alt2.xml"; //address
    CascadeClassifier faceDetector = new CascadeClassifier(source);
    VideoCapture capture;
    
    public Home() {
        initComponents();
    }
    
    public void getImage(String path) {
        CascadeClassifier deteksiWajah = new CascadeClassifier(source);
        Mat image = Imgcodecs.imread(path);

        MatOfRect faceDetect = new MatOfRect();
        deteksiWajah.detectMultiScale(image, faceDetect);

        int numberDetect = 0;
        for (Rect rect : faceDetect.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 2);
            ++numberDetect;
        }

        if (numberDetect < 0 && numberDetect == 0) {
            lblnumber.setText("0");
        } else {
            lblnumber.setText(String.valueOf(numberDetect));
        }
        Imgcodecs.imwrite("output.jpg", image);
        ImageIcon icon = new ImageIcon("output.jpg");

        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel2.setIcon(scaledIcon);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblnumber = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblnumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblnumber.setText("Num Of Faces");

        jButton2.setText("Load File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(lblnumber)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnumber)))
                .addGap(107, 107, 107)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
(new Thread(){
                    @Override
                    public void run(){
                        capture = new VideoCapture(0);
                        
                        MatOfRect rostros = new MatOfRect();
                        MatOfByte mem = new MatOfByte();
                        
                        Mat frame = new Mat();
                        Mat frame_gray = new Mat();
                        
                        Rect[] facesArray;
                        Graphics g;
                        BufferedImage buff = null;
                        
                        while(capture.read(frame)){
                            if(frame.empty()){
                                System.out.println("No Detection");
                                break;
                            }else{
                                try {
                                    g = jLabel2.getGraphics();
                                    Imgproc.cvtColor(frame, frame_gray, Imgproc.COLOR_BGR2GRAY);
                                    Imgproc.equalizeHist(frame_gray, frame_gray);
                                    double w = frame.width();
                                    double h = frame.height();
                                    faceDetector.detectMultiScale(frame_gray, rostros, 1.1, 2, 0|CASCADE_SCALE_IMAGE,new Size(30, 30), new Size(w, h));
                                    facesArray = rostros.toArray();
                                    System.out.println("Num Of Faces: "+facesArray.length);
                                    
                                    for (int i = 0; i < facesArray.length; i++) {
                                        Point center = new Point((facesArray[i].width * 0.5),
                                                (facesArray[i].y + facesArray[i].height * 0.5));
                                        Imgproc.ellipse(frame,
                                                center,
                                                new Size(facesArray[i].width * 0.5, facesArray[i].height * 0.5),
                                                0,
                                                0,360,
                                                new Scalar(255, 0, 255), 4, 8, 0);
                                        
                                        Mat faceROI = frame_gray.submat(facesArray[i]);
                                        Imgproc.rectangle(frame,
                                                new Point(facesArray[i].x,facesArray[i].y),
                                                new Point(facesArray[i].x+facesArray[i].width,facesArray[i].y+facesArray[i].height),
                                                new Scalar(123, 213, 23, 220));
                                        Imgproc.putText(frame, "Width: "+faceROI.width()+" Height: "+faceROI.height()+" X = "+facesArray[i].x+
                                                " Y = "+facesArray[i].y, new Point(facesArray[i].x, facesArray[i].y-20), 1, 1, new Scalar(255,255,255));
                                    }
                                    
                                    int no = facesArray.length;
                                    lblnumber.setText(String.valueOf(no));
                                    
                                    Imgcodecs.imencode(".bmp", frame, mem);
                                    Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                                    buff = (BufferedImage) im;
                                    if(g.drawImage(buff, 0, 0, jLabel2.getWidth(), jLabel2.getHeight(), 0, 0, buff.getWidth(), buff.getHeight(), null)){
                                    }
                                } catch (IOException ex){}
                            }
                        }
                    }
        }).start();
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, """
            Aplikasi ini dibuat oleh :
            Nama : Firza Naufal Alift
            NIM : 32602000028

            Prodi Teknik Informatika
            Universitas Islam Sultan Agung

            Referensi
            - Youtube : Syn Tech (https://www.youtube.com/watch?v=YHlqurpEZXc)
            - Github : yh-ong (https://github.com/yh-ong/Face-Detection)""",
            "About", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jMenu2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files (.jpg, .png, .jpeg)", "jpg", "png", "jpeg");
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new java.io.File("."));
        filechooser.setDialogTitle("Pilih satu foto");
        filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        filechooser.setFileFilter(filter);
        filechooser.setAcceptAllFileFilterUsed(false);

        if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String getFilePath = filechooser.getSelectedFile().toString();
            jTextField1.setText(getFilePath);
            getImage(getFilePath);
        } else {
            jTextField1.setText("No Selection");
        }

        capture.release();
        jLabel2.setBackground(null);
        jButton2.setEnabled(true);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblnumber;
    // End of variables declaration//GEN-END:variables
}
