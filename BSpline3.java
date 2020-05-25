package test;

/*
 *Copyright: 南国猫觅海
 *Author: wss
 *Date:2020-05-25
 *Description: BSplines曲线关键点生成
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BSpline3 extends Frame {

    // u取0.2
    private float x = (float) 0.02;

    // BSpline3像素点数据
    // 第一行三个加上第二行一个构成四个一组
    private float[][] P = {
            {190, 300}, {190, 300}, {190, 300},  // 起点，头部下方
            {160, 290}, {130, 260}, {130, 230},
            {160, 180}, {210, 160}, {210, 160},  // 头部第一个拐点，三点重合，下同
            {210, 160}, {240, 110}, {270, 100},
            {300, 90},  {330, 90},  {360, 100},
            {380, 120}, {360, 135}, {330, 145},
            {310, 150}, {310, 150}, {310, 150},  // 两只耳朵中间尖锐点
            {330, 145}, {360, 140}, {390, 145},
            {410, 160}, {410, 165}, {390, 180},
            {370, 190}, {350, 195}, {330, 200},
            {310, 200}, {290, 200}, {290, 200},  // 耳朵下方第一个拐点
            {290, 200}, {290, 210}, {290, 210},  // 耳朵下方第二个拐点
            {320, 215}, {350, 230}, {380, 250},
            {410, 270}, {460, 340}, {480, 380},  // 尾巴上拐点
            {480, 380}, {480, 380}, {490, 370},
            {510, 370}, {530, 375}, {550, 390},
            {560, 410}, {560, 430}, {550, 450},
            {530, 460}, {520, 460}, {500, 460},
            {480, 450}, {470, 445}, {470, 445},  // 尾巴下拐点
            {470, 445}, {455, 455}, {455, 455},  // 脚后跟拐点
            {455, 455}, {455, 480}, {450, 490},
            {440, 495}, {420, 500}, {390, 505},
            {370, 505}, {350, 503}, {330, 500},
            {310, 495}, {305, 480}, {305, 475},
            {310, 460}, {310, 460}, {310, 460},  // 肚子下方拐点
            {310, 460}, {290, 455}, {260, 445},
            {230, 400}, {230, 400}, {230, 400},  // 手臂下方拐点
            {230, 420}, {225, 435}, {220, 440},
            {200, 445}, {185, 435}, {170, 420},
            {160, 390}, {180, 360}, {200, 345},  // 手臂上方拐点
            {200, 345}, {200, 345}, {195, 330},
            {192, 315}, {190, 300}, {190, 300},  // 重点，即起点
            {190, 300}};

    // Bezier曲线部分像素点数据
    private float[][] D = {
            {310, 460}, {340, 440}, {370, 420},
            {390, 440}};

    // 初始化窗口函数
    private BSpline3() {
        this.setTitle("算机1702王顺顺-1711010202-实验三");
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

    // BSpline3算法主体
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i=0; i< P.length-3; i++) {
//            g2.setColor(Color.red);
//            g2.drawLine((int)P[i][0], (int)P[i][1], (int)P[i+1][0], (int)P[i+1][1]);
//            g2.drawLine((int)P[i+1][0], (int)P[i+1][1], (int)P[i+2][0], (int)P[i+2][1]);
//            g2.drawLine((int)P[i+2][0], (int)P[i+2][1], (int)P[i+3][0], (int)P[i+3][1]);

            g2.setColor(Color.gray);
            g2.setStroke(new BasicStroke(4f));
            float u = 0, t = x;

            float F03u = 0, F13u = 0, F23u = 0, F33u = 0;

            float X0 = 0;   //X起点坐标
            float Y0 = 0;   //Y起点坐标

            float X = 0;   //X坐标
            float Y = 0;   //Y坐标

            for (u=0; u<=1; u=u+t) {
                F03u = (-u*u*u + 3*u*u - 3*u + 1)/6;
                F13u = (3*u*u*u - 6*u*u + 4)/6;
                F23u = (-3*u*u*u + 3*u*u + 3*u + 1)/6;
                F33u = (u*u*u)/6;

//                System.out.println("u=" + u + "时:::" + "F03u=" + F03u + "   F13u=" + F13u + "   F23u=" + F23u + "   F33u=" + F33u);
                X = F03u*P[i][0] + F13u*P[i+1][0] + F23u*P[i+2][0] + F33u*P[i+3][0];
                Y = F03u*P[i][1] + F13u*P[i+1][1] + F23u*P[i+2][1] + F33u*P[i+3][1];
                if(X0 == 0) {
                    X0 = X;
                    Y0 = Y;
                } else {
                    // 在上一节点与生成的节点之间画线
                    g2.drawLine((int)X, (int)Y, (int)X0, (int)Y0);
                    X0 = X; Y0 = Y;
                }

//                System.out.println("X、Y坐标为:::" + "X=" + X + "   Y=" + Y);
//                System.out.println();
            }
        }

        // 画眼睛
        g2.setColor(Color.red);
        g2.fillOval(200, 200, 20, 20);

        g2.setColor(Color.black);
        g2.drawString("算机1702王顺顺-1711010202-实验三", 300, 300);

        BezierPaint(g2);
    }

    // Bezier算法主体
    public void BezierPaint(Graphics2D g2) {

        g2.setColor(Color.gray);

        for (int i=0; i< D.length-1; i=i+3) {
            float u = 0, t = x;

            float B03u = 0, B13u = 0, B23u = 0, B33u = 0;

            float X0 = D[i][0];   //X起点坐标
            float Y0 = D[i][1];   //Y起点坐标

            float X = 0;   //X坐标
            float Y = 0;   //Y坐标

            for (u=0; u<=1; u=u+t) {
                B03u = 0 - u*u*u + 3*u*u - 3*u + 1;
                B13u = 3*u*u*u - 6*u*u + 3*u;
                B23u = -3*u*u*u + 3*u*u;
                B33u = u*u*u;

                System.out.println("u=" + u + "时:::" + "B03u=" + B03u + "   B13u=" + B13u + "   B23u=" + B23u + "   B33u=" + B33u);
                X = B03u*D[i][0] + B13u*D[i+1][0] + B23u*D[i+2][0] + B33u*D[i+3][0];
                Y = B03u*D[i][1] + B13u*D[i+1][1] + B23u*D[i+2][1] + B33u*D[i+3][1];
                g2.drawLine((int)X, (int)Y, (int)X0, (int)Y0);
                X0 = X; Y0 = Y;
                System.out.println("X、Y坐标为:::" + "X=" + X + "   Y=" + Y);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        BSpline3 test3 = new BSpline3();
    }
}
