package test;

/*
 *Copyright: 南国猫觅海
 *Author: wss
 *Date:2020-05-25
 *Description: Hermite曲线关键点生成
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hermite extends Frame {

    private float x = (float) 0.02;

    private float[][] P = {{100, 300}, {120, 400}, {220, 400}, {270, 500}, {370, 500}, {420, 400}, {420, 300}, {100, 300}};
    private float[][] D = {{70, 70}, {70, 70}, {70, 70}, {70, 70}, {70, 70}, {70, 70}, {70, 70}, {70, 70}};

    // 初始化窗口函数
    private Hermite() {
        this.setTitle("算机1702王顺顺-1711010202");
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        this.setLayout(null);
        this.setVisible(true);

        this.setSize(660, 650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for(int i=0; i<P.length-1; i++) {
            g2.setColor(Color.black);
            g2.drawLine((int)P[i][0], (int)P[i][1], (int)P[i+1][0], (int)P[i+1][1]);

            g2.setColor(Color.red);

            float u = 0, t=x;

            float H0u = 0, H1u = 0, H2u = 0, H3u = 0;

            float X0 = P[i][0];   //X起点坐标
            float Y0 = P[i][1];   //Y起点坐标

            float X = 0;   //X坐标
            float Y = 0;   //Y坐标

            for (u=0; u<=1; u=u+t) {
                H0u =  2*u*u*u - 3*u*u + 1;
                H1u = 0-2*u*u*u + 3*u*u;
                H2u = u*u*u - 2*u*u + u;
                H3u = u*u*u -u*u;

                System.out.println("u=" + u + "时:::" + "H0u=" + H0u + "   H1u=" + H1u + "   H2u=" + H2u + "   H3u=" + H3u);
                X = H0u*P[i][0] + H1u*P[i+1][0] + H2u*D[i][0] + H3u*D[i+1][0];
                Y = H0u*P[i][1] + H1u*P[i+1][1] + H2u*D[i][1] + H3u*D[i+1][1];
                g2.drawLine((int)X, (int)Y, (int)X0, (int)Y0);
                X0 = X; Y0 = Y;
                System.out.println("X、Y坐标为:::" + "X=" + X + "   Y=" + Y);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Hermite test = new Hermite();

    }

}
