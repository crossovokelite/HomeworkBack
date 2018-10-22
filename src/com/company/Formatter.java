package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Formatter {

    public void format(BufferedReader source, BufferedWriter result) {

        try {
            int level = 0;
            int prev = 0;
            String tab = "    ";
            int symbol;
            while ((symbol = source.read()) != -1) {
                switch (symbol) {
                    case '{':
                        level++;
                        result.write(" ");
                        result.write(symbol);
                        result.write("\n");
                        for (int i = 0; i < level; i++) result.write(tab);
                        prev = symbol;
                        break;
                    case ';':
                        result.write(symbol);
                        result.write('\n');
                        for (int i = 0; i < level; i++) result.write(tab);
                        prev = symbol;
                        break;
                    case '}':
                        level--;
                        result.write("\n");
                        for (int i = 0; i < level; i++) result.write(tab);
                        result.write(symbol);
                        prev = symbol;
                        break;
                    case ' ':
                        if (prev == ' ') break;
                        else {
                            //for (int i = 0; i < level; i++) result.write(tab);
                            prev = symbol;
                            break;
                        }
                    case '\n':
                        if (prev!= '}') break;
                        else {
                            result.write(symbol);
                            prev = symbol;
                        }

                    default:
                        result.write(symbol);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
