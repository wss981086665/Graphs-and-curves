package test;

/*
 *Copyright: 南国猫觅海
 *Author: wss
 *Date:2020-05-25
 *Description: 二维图形基本变换实现
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicTransformation extends Frame {

    // 初始三角形坐标
    private float[][] point = {{300, 300}, {360, 300}, {330, 250}};

    // 初始化窗口函数
    private GraphicTransformation() {
        this.setTitle("*******************");
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setLayout(null);
        this.setVisible(true);
        // 设置背景
//        this.setBackground(Color.red);
        // 窗口大小
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // 绘画画板
//    @Override
//    public void paint(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        // 坐标轴
//        g2.setColor(Color.black);   // 设置画笔颜色
//        g2.drawLine(100, 300, 700, 300);
//        g2.drawLine(300, 100, 300, 500);
//
//        // 图形本体
//        drawIt(point, g2, Color.black);
//
//        g2.setStroke(new BasicStroke(2f));
//
//        // 旋转实例
//        drawIt(xuanzhuan(90), g2, Color.orange);
//
//        // 平移实例
//        drawIt(pingyi(100, 100), g2, Color.red);
//
//        // 比例实例
//        drawIt(bili(2, (float) 0.5), g2, Color.blue);
//
//        // 对称于x轴
//        drawIt(duichen(1), g2, Color.yellow);
//
//        // 错切变换
//        drawIt(cuoqie(0, (float) 0.9), g2, Color.black);
//
//        g2.drawString("错切", 600, 270);
//        g2.drawString("对称", 260, 240);
//        g2.drawString("旋转", 310, 330);
//        g2.drawString("比例", 400, 280);
//        g2.drawString("平移", 420, 420);
//
//        // 设置颜色
//        g2.setColor(Color.pink);
//        // 设置宽度
//        g2.setStroke(new BasicStroke(4f));
//        //(横坐标、 纵坐标、 长、 宽)
//        g2.drawOval(500, 500, 80, 80);
//
//        g2.setColor(Color.blue);
//        g2.drawString("*******************8", 300, 350);
//
//    }

//     绘画画板
@Override
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    g2.setStroke(new BasicStroke(2f));

    // 平移实例
    drawIt(pingyi(0, 0), g2, Color.red);
    drawIt(pingyi(65, 0), g2, Color.red);
    drawIt(pingyi(-130, 0), g2, Color.red);
    drawIt(pingyi(-32, -62), g2, Color.red);
    drawIt(pingyi(65, 0), g2, Color.red);
    drawIt(pingyi(65, 0), g2, Color.red);
    drawIt(pingyi(65, 0), g2, Color.red);

    duichen(0);
    drawIt(pingyi(-162, -178), g2, Color.red);
    drawIt(pingyi(130, 0), g2, Color.red);
    drawIt(pingyi(32, 60), g2, Color.red);
    drawIt(pingyi(-65, 0), g2, Color.red);
    drawIt(pingyi(-65, 0), g2, Color.red);
    drawIt(pingyi(-65, 0), g2, Color.red);

    pingyi(-115, 62);
    drawIt(cuoqie(0, (float) 0.5), g2, Color.red);
    pingyi(395, 0);
    drawIt(cuoqie(0, (float) -0.9), g2, Color.red);

    point = new float[][]{{300, 300}, {360, 300}, {330, 250}};
    duichen(0);
    bili(1, (float) 0.4);
    drawIt(pingyi(0, 5), g2, Color.red);
    drawIt(pingyi(0, 25), g2, Color.red);
    drawIt(pingyi(0, 27), g2, Color.red);

    point = new float[][]{{300, 300}, {360, 300}, {330, 250}};
    cuoqie(0, (float) 1.5); pingyi(-180, 0);bili(1, (float) 0.5);
    drawIt(duichen(0), g2, Color.red);
    xuanzhuan(10);
    drawIt(bili(2, 2), g2, Color.blue);

    g2.drawString("********************", 300, 400);

}

    // 画出结果图形
    public void drawIt(float[][] info, Graphics2D g2, Color color) {
        g2.setColor(color);
        g2.drawLine((int)info[0][0], (int)info[0][1], (int)info[1][0], (int)info[1][1]);
        g2.drawLine((int)info[1][0], (int)info[1][1], (int)info[2][0], (int)info[2][1]);
        g2.drawLine((int)info[0][0], (int)info[0][1], (int)info[2][0], (int)info[2][1]);
    }

    public static void main(String[] args) {
        GraphicTransformation test = new GraphicTransformation();
    }

    // 平移
    public float[][] pingyi(float x, float y) {
        float[][] result = point;
        for (int i=0; i<3; i++) {
            result[i][0] = result[i][0] + x;
            result[i][1] = result[i][1] + y;
        }
//        point = new float[][]{{300, 300}, {360, 300}, {330, 250}};
        return result;
    }

    // 比例，相对于A点
    public float[][] bili(float Sx, float Sy) {
        float[][] result = point;
        for (int i=0; i<3; i++) {
            result[i][0] = result[i][0] * Sx + result[0][0]*(1-Sx);
            result[i][1] = result[i][1] * Sy + result[0][1]*(1-Sy);
        }
//        point = new float[][]{{300, 300}, {360, 300}, {330, 250}};
        return result;
    }

    // 旋转，相对于A点
    public float[][] xuanzhuan(int x) {    // x:旋转角度
        float[][] result = point;
        float sinx = (float) Math.sin(Math.PI*((float) x/180));
        float cosx = (float) Math.cos(Math.PI*((float) x/180));
        for (int i = 1; i <= 2; i++) {
            float xxx = result[i][0], yyy = result[i][1];
            result[i][0] = (xxx - result[0][0]) * cosx - (yyy - result[0][1])*sinx + result[0][0];
            result[i][1] = (xxx - result[0][0]) * sinx + (yyy - result[0][1])*cosx + result[0][1];
        }
//        point = new float[][]{{300, 300}, {360, 300}, {330, 250}};
        return result;
    }

    // 对称于坐标轴
    public float[][] duichen(int x) {     // x--> 0:x轴   1:y轴
        float[][] result = point;
        if (x == 0) {
            for (int i = 0 ; i < 3; i++) {
                result[i][1] = 300 - (result[i][1] - 300);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                result[i][0] = 300 - (result[i][0] - 300);
            }
        }
//        point = new float[][]{{300, 300}, {360, 300}, {330, 250}};
        return result;
    }

    // 错切变换
    public float[][] cuoqie(int x, float c) {    // x--> 0:x轴   1:y轴  c:错切系数
        float[][] result = point;
        if (x == 0) {
            for (int i = 0 ; i < 3; i++) {
                result[i][0] = result[i][0] + c * result[i][1];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                result[i][1] = result[i][1] + c * result[i][0];
            }
        }
//        point = new float[][]{{300, 300}, {360, 300}, {330, 250}};
        return result;
    }

}
