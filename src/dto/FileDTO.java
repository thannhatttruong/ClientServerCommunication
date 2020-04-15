/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author TruongTN
 */
public class FileDTO implements Serializable {
    public byte[] data;
    public int length;
    public String fileName;

    public FileDTO(byte[] data, int length, String fileName) {
        this.data = data;
        this.length = length;
        this.fileName = fileName;
    }

}
