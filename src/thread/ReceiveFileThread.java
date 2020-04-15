/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import dto.FileDTO;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author TruongTN
 */
public class ReceiveFileThread extends Thread {

    Socket fileSocket;
    ObjectInputStream ois;
    JTextArea txtMessage;
    Vector<FileDTO> fileList;

    public ReceiveFileThread(Socket fileSocket, ObjectInputStream ois, JTextArea txtMessage, Vector<FileDTO> fileList) {
        super();
        this.fileSocket = fileSocket;
        this.ois = ois;
        this.txtMessage = txtMessage;
        this.fileList = fileList;
    }

    public boolean checkConnect(){
        boolean check = true;
        try {
            ois = new ObjectInputStream(fileSocket.getInputStream());
        } catch (Exception e) {
            return false;
        }
        return check;
    }
    
    @Override
    public void run() {
        while (checkConnect()) {
            try {
                if (fileSocket != null) {
                    FileDTO fileData;
                    if ((fileData = (FileDTO) ois.readObject()) != null) {
                        sleep(500);
                        fileList.add(fileData);
                        txtMessage.append(fileData.fileName + "\n");
                    }
                }
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
