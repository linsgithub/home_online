package com.home.util;

import java.io.BufferedReader;

public class Test {

	public static void main(String[] args) {
//		System.out.println("22222222222");
//		  byte sj[]={0x01,0x10,0x00,(byte) 0xC9,0x00,0x10,0x10,(byte) 0xE6,(byte) 0x88,(byte) 0x91,(byte) 0xE6,(byte) 0x98,(byte) 0xAF,(byte) 0xE8,(byte) 0xB0,(byte) 0x81,0x00,0x00,0x00,0x00,0x00,0x00,0x00 };  
//	        int i, j;  
//	        //sj[1] = (byte) (sj.length + 2);  
//	        i = (int) crc16(sj, (byte) (sj.length));  
//	        //System.out.printf("%4X\n",i); //  
//	        for (j = 0; j < (byte) (sj.length); j++)  
//	            System.out.printf("%02X ", sj[j]); // 打印  
//	  
//	        System.out.printf("%02X %02X", (byte)(i % 256), (byte)(i / 256)); // 低字节 高字节   93 25  
		
		
	}


public static int crc16(byte[] str, byte num) // CRC计算子程序  
{  
    byte i, j;  
    int crc;  
    crc = (int) (0xffff);  
    for (i = 0; i < num; i++) {  
        crc ^= (int) (str[i] & 0x00ff);  
          
        for (j = 0; j < 8; j++) {  
            if ((crc & 0x0001) == 1) {  
                crc >>= 1;  
                crc ^= 0xa001;  
            } else  
                crc >>= 1;  
        }  
    }  
    return (int)(crc);  
}  
} 

