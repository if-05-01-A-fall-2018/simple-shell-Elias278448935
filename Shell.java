/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shelljava;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ShellJava {

    /**
     * @param args the command line arguments
     */
    private static Thread t;
    public static void main(String[] args) {
        Scanner scanner;
        String input;
        
        while(true){
            System.out.print("Text: ");
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
            String[] commands = input.split("&&"); //comands weil es mehrer sein können
            for (String i : commands) { // i für einen einzelnen command
                if (i.contains("exit")) {
                    return;
                }
                try {
            Process process =  Runtime.getRuntime().exec("cmd /C "+ i+" && exit");
            InputStream stream = process.getInputStream();
            int n = stream.read();
            while (n != -1) {
                System.out.print((char)n);
                n = stream.read();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage()+"\n");
        }
            }
        }
    }

}

