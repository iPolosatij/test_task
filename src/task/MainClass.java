package task;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

    static Map<String, String> resume;
    static BufferedImage image;

    public static void main(String[] args) {
        resume = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            image = ImageIO.read(new File(reader.readLine()));
            System.out.println(identifier(147, 592) + " " + identifier(147, 637));
            System.out.println(identifier(218, 592) + " " + identifier(218, 637));
            System.out.println(identifier(290, 592) + " " + identifier(290, 637));
            System.out.println(identifier(362, 592) + " " + identifier(362, 637));
            System.out.println(identifier(433, 592) + " " + identifier(433, 637));
        } catch (IOException e) {
            System.out.println(e);;
        }
    }
    public static String identifier(int n, int m){
        int x = n;
        int x1 = n + 34;
        int y = m;
        int clr =  image.getRGB(x,y);
        int i = 0;
        int r = 0;
        int l = 0;
        int t = 0;
        int o = 0;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        if(clr == -1 || clr == -8882056){
            if(y < 613) {
                while (true) {
                    int clr1 = image.getRGB(x1, y);
                    x1--;
                    i++;
                    if (clr1 != clr) {
                        y++;
                        right.add(i);
                        i = 0;
                        x1 = n + 34;
                    }
                    if (y == 612) {
                        y = 592;
                        break;
                    }
                }
                Collections.sort(right);
                for (int c = 0; c < right.size(); c++) {
                    int c1 = right.get(right.size() - c - 1) - right.get(0);
                    right.set((right.size() - c - 1), c1);
                }
                for (Integer integer : right) {
                    r = r + integer;
                }
                while (true) {
                    x++;
                    i++;
                    int clr1 = image.getRGB(x, y);
                    if (clr1 != clr) {
                        y++;
                        if (i < 25) left.add(i);
                        i = 0;
                        x = n;
                    }
                    if (y == (m + 20)) {
                        break;
                    }
                }
                int k = Integer.MAX_VALUE;
                for (int c = 0; c < left.size(); c++) {
                    if (k > left.get(left.size() - c - 1)) {
                        k = left.get(left.size() - c - 1);
                        t = (left.size() - c - 1);
                    }
                }
                Collections.sort(left);
                for (int c = 0; c < left.size(); c++) {
                    int c1 = left.get(left.size() - c - 1) - left.get(0);
                    left.set((left.size() - c - 1), c1);
                }
                for (Integer integer : left) {
                    l = l + integer;
                }
            }
            if(m > 613) {
                o = image.getRGB((x + 38), (y + 10));
                int o1 = image.getRGB(x, y);
                while (true){
                    x++;
                    if(x == (n + 56)) break;
                    int o2 = image.getRGB(x, y);
                    if(o1 != o2) t++;
                    }
                }
        String s = " " + l + " " + r;
        if(r >= 43 && r <= 55 && l >= 85 && l <= 92) s = "двойка";
        if(r >= 22 && r <= 34 && l >= 83 && l <= 93) s = "тройка";
        if(r >= 46 && r <= 56 && l >= 107 && l <= 115) s = "четверка";
        if(r >= 53 && r <= 63 && l >= 59 && l <= 70) s = "пятерка";
        if(r >= 36 && r <= 47 && l >= 18 && l <= 24) s = "шестерка";
        if(r >= 70 && r <= 84 && l >= 97 && l <= 106) s = "семерка";
        if(r >= 27 && r <= 34 && l >= 22 && l <= 33 ) s = "восьмерка";
        if(r >= 18 && r <= 25 && l >= 34 && l <= 42) s = "девятка";
        if(r >= 20 && r <= 39 && l >= 58 && l <= 60) s = "десятка";
        if(r >= 2 && r <= 5 && l >= 160 && l <= 164) s = "валет";
        if(r >= 25 && r <= 35 && l >= 25 && l <= 37 && t >=12 && t <= 15) s = "дама";
        if(r >= 73 && r <= 92 && l >= 0 && l <= 5) s = "король";
        if(r >= 77 && r <= 96 && l >= 77 && l <= 88) s = "туз";
        if(t>=11 && t<= 16 && o == -14474458) s = "треф";
        if(t>=1 && t<= 8 && o == -14474458) s = "пик";
        if(t>=0 && t<= 4 && o == -3323575) s = "черви";
        if(t>=5 && t<= 12 && o == -3323575) s = "буби";
        return (s + " ");
        }else{return ("");}
    }
}
