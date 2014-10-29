/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj5_decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GH
 */
public class Proj5_decoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Character> characterList = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
			// master aaa
            count.add(0);
        }

        Scanner in = new Scanner(System.in);

        do {
            try {
                System.out.println("Please enter the file name");
                String fileName = in.nextLine();
                FileInputStream inputStream = new FileInputStream(new File(fileName));
                InputStreamReader reader = new InputStreamReader(inputStream);

                int character = reader.read();
                while (character != -1) {

                    characterList.add((char) character);
                    character = reader.read();
                }
                break;
            } catch (FileNotFoundException f) {
                System.out.println("The file does not exist");
            } catch (IOException e) {
                System.out.println(e);
            }
        } while (true);
        
        int sum = 0;
        for (int i = 0; i < characterList.size(); i++) {
            char c = Character.toLowerCase(characterList.get(i));
            if (Character.isLetter(c)) {
                sum++;
                count.set((int) c - 97, count.get((int) c - 97) + 1);
            }
        }

        for (int i = 0; i < count.size(); i++) {
            System.out.print((char) (i + 97) + "'s occurance is " + count.get(i) + ". The relative frequency is ");
            System.out.printf("%.2f%%\n", count.get(i) * 100.0 / sum);

        }

    }

}
