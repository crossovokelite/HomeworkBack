package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2) {
            File sourceName = new File(args[0]);
            File resultName = new File(args[1]);
            Formatter formatter = new Formatter();
            try {
                if (!sourceName.exists()) throw new IOException();
                if (!resultName.exists()) resultName.createNewFile();
                BufferedReader source;
                source = new BufferedReader(new FileReader(sourceName));
                BufferedWriter result;
                result = new BufferedWriter(new FileWriter(resultName));
                formatter.format(source, result);
                source.close();
                result.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Argument format is not correct. Be sure that you have source file and result file.");
        }
    }
}
