package test;

/*
 *Copyright: 南国猫觅海
 *Author: wss
 *Date:2020-05-25
 *Description: Liang-Barsky直线段裁剪关键点生成
 */

import java.util.Scanner;

public class LiangBarsky {

    private static int Wxl=-1, Wxr=1, Wyb=-1, Wyt=1;

    public static void carve(float x1, float y1, float x2, float y2) {
        float dx = x2-x1, dy = y2-y1;
        float p1 = -dx, q1 = x1-Wxl, r1 = q1/p1;
        float p2 = dx,  q2 = Wxr-x1, r2 = q2/p2;
        float p3 = -dy, q3 = y1-Wyb, r3 = q3/p3;
        float p4 = dy,  q4 = Wyt-y1, r4 = q4/p4;

        System.out.println("p1=" + p1 + "   q1=" + q1 + "   r1=" + r1);
        System.out.println("p2=" + p2 + "   q2=" + q2 + "   r2=" + r2);
        System.out.println("p3=" + p3 + "   q3=" + q3 + "   r3=" + r3);
        System.out.println("p4=" + p4 + "   q4=" + q4 + "   r4=" + r4);
        // 从 Pi 中选取两个小于0的点

        float u1 = 0, u2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请根据以上结果输入u1、u2:");
        System.out.print("u1=");
        u2 = sc.nextFloat();
        System.out.print("u2=");
        u1 = sc.nextFloat();
        float X1 = x1 + dx * u1, Y1 = y1 + dy * u1;
        float X2 = x1 + dx * u2, Y2 = y1 + dy * u2;
        System.out.println("----------输出结果----------");
        System.out.println("A:(" + X1 + "," + Y1 + ")");
        System.out.println("B:(" + X2 + "," + Y2 + ")");

    }

    public static void main(String[] args) {
        carve((float) 0.5, (float) 1.5, (float) 1.5, (float) 0.75);
    }

}
