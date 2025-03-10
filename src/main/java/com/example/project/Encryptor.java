package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen == 0)
        {
            return 1;
        }

        return (int)Math.ceil((double)messageLen / rows);
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int col = determineColumns(message.length(), rows);
        String [][] newList = new String [rows][col];
        int i = 0;

        for(int j = 0; j < rows; j++){
            for(int h = 0; h < col; h++){
                if(i < message.length()){
                    newList[j][h]=message.substring(i,i+1);
                }else{
                    newList[j][h]= "=";
                }
                i++; 
            }
            
        }
        
        return newList;
    }

    public static String encryptMessage(String message, int rows){
        String [][] newList = generateEncryptArray(message, rows);
        String str = "";
        
        for(int j = newList[0].length-1; j>=0; j--){
            for(int h = 0; h < newList.length; h++){
                str+=newList[h][j];
            } 
        }
        return str;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int length = determineColumns(encryptedMessage.length(), rows);
        while (rows * length > encryptedMessage.length()) 
        {
            rows--;
            length = determineColumns(encryptedMessage.length(), rows);
        }

         //123
        //456
        //3 6  2 5 1 4
        String [][] newList = new String[rows][length];
        String str = "";
        int i = 0;
        
        for(int j = newList[0].length -1; j >= 0 ; j--){
            for(int h = 0; h < newList.length; h++){
                if(i < encryptedMessage.length()){
                    newList[h][j] = encryptedMessage.substring(i, i+1);
                    i++;
                }
            }
        }
        for(String [] row : newList){
            for(String string : row){
                if(! string.equals("=")){
                    str+=string;
                }
               
            }
        }
        return str;
    }

    public static void main(String[] args) {

        int rows = 2;
        String message = "123456";

    
        System.out.println(encryptMessage("123456", 2));
        System.err.println(decryptMessage("362514", 2));
        //123
        //456
        //3 6  2 5 1 4
    }
}

/*String [][] list = encryptMessage("abcde", 1);
        
        for (int i =0; i < list.length; i++){
            for(int j =0; j < list[0].length; j++){
                System.out.print(list[i][j]);
            }
        } */