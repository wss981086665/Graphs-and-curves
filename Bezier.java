package test;

/*
 *Copyright: 南国猫觅海
 *Author: wss
 *Date:2020-05-25
 *Description: Bezier曲线关键点生成
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bezier extends Frame {

    private float x = (float) 0.02;

    private float[][] P = {
            {100, 300}, {120, 200}, {220, 200},
            {270, 100}, {370, 100}, {420, 200},
            {420, 300}};

    // 初始化窗口函数
    private Bezier() {
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

        for (int i=0; i< P.length-1; i=i+3) {
            g2.setColor(Color.black);
            g2.drawLine((int)P[i][0], (int)P[i][1], (int)P[i+1][0], (int)P[i+1][1]);
            g2.drawLine((int)P[i+1][0], (int)P[i+1][1], (int)P[i+2][0], (int)P[i+2][1]);
            g2.drawLine((int)P[i+2][0], (int)P[i+2][1], (int)P[i+3][0], (int)P[i+3][1]);

            g2.setColor(Color.red);
            float u = 0, t = x;

            float B03u = 0, B13u = 0, B23u = 0, B33u = 0;

            float X0 = P[i][0];   //X起点坐标
            float Y0 = P[i][1];   //Y起点坐标

            float X = 0;   //X坐标
            float Y = 0;   //Y坐标

            for (u=0; u<=1; u=u+t) {
                B03u = 0 - u*u*u + 3*u*u - 3*u + 1;
                B13u = 3*u*u*u - 6*u*u + 3*u;
                B23u = -3*u*u*u + 3*u*u;
                B33u = u*u*u;

                System.out.println("u=" + u + "时:::" + "B03u=" + B03u + "   B13u=" + B13u + "   B23u=" + B23u + "   B33u=" + B33u);
                X = B03u*P[i][0] + B13u*P[i+1][0] + B23u*P[i+2][0] + B33u*P[i+3][0];
                Y = B03u*P[i][1] + B13u*P[i+1][1] + B23u*P[i+2][1] + B33u*P[i+3][1];
                g2.drawLine((int)X, (int)Y, (int)X0, (int)Y0);
                X0 = X; Y0 = Y;
                System.out.println("X、Y坐标为:::" + "X=" + X + "   Y=" + Y);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Bezier绘制曲线");
        Bezier test = new Bezier();
    }

}
