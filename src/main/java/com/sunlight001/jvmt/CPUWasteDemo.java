package com.sunlight001.jvmt;


import java.util.ArrayList;

/**
 * Created by sunlight001 on 2019/1/23.
 * 模拟cpu消耗的代码
 * 通过top 查看  同过jstack定位
 */
public class CPUWasteDemo {
    public static void main(String[] args) {
        CPUWasteDemo demo = new CPUWasteDemo();
        demo.runTest();
    }

    public void runTest(){
        int count = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i <count ; i++) {
            new Thread(new ConsumerCPUTask()).start();
        }

        for (int i = 0; i <count ; i++) {
            new Thread(new NotConsumerCPUTask()).start();
        }
        
    }
}

/**
 * waste cpu work
 */
class ConsumerCPUTask implements Runnable{
    @Override
    public void run() {
        String str = "yguhjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguh" +
                "jkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjk" +
                "lsyguhjkasdfghjklsyguhjkasdfghjklsygu#hjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguhjkasd" +
                "fghjklsyguhjkasdfghjklsyguhjkasdfghjklsyguhjkasdfghjkls";
        float i = 0.002f;
        float j = 233.1234f;
        while (true){
            j=i*j;
            str.indexOf("#");
            ArrayList<String> list = new ArrayList<String>();
            for (int k = 0; k <10000 ; k++) {
                list.add(str+String.valueOf(k));
            }

            list.contains("iii");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * not waster cpu
 */
class NotConsumerCPUTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
