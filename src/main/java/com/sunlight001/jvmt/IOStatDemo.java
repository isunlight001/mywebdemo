package com.sunlight001.jvmt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by sunlight001 on 2019/1/23.
 * test iostat
 * also use pidstat if your machine have
 * @author sunlight001
 */
public class IoStatDemo {
    private String fileName = "/tmp/iowait.log";

    private  static  int threadCount = Runtime.getRuntime().availableProcessors();

    private Random random = new Random();
    public static void main(String[] args) throws Exception{
        if (args.length==1){
            threadCount = Integer.parseInt(args[1]);
        }

        IoStatDemo demo = new IoStatDemo();
        //测试
        demo.runTest();
        //删除文件
        demo.delFile();
    }

    public  void delFile(){
        File file = new File("/tmp");
        if (file.isDirectory()){
            File[] ff = file.listFiles();
            for (int i = 0; i < ff.length; i++) {
                System.out.println(ff[i].getName()+"deleted!");
                ff[i].delete();

            }
        }
    }


    public void runTest() throws Exception{
        File file = new File(fileName);
        file.createNewFile();
        for (int i = 0; i < threadCount; i++) {
//            new Thread(new Task()).start();
            ExecutorService es = new ThreadPoolExecutor(1,1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(1024));
            es.execute(new Task());
            es.shutdown();
        }


    }

    class Task implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(fileName+random.nextInt(1000000), true));
                    StringBuilder sb = new StringBuilder("====begin====").append("\n");
                    String threadName = Thread.currentThread().getName();
                    for (int i = 0; i < 1000; i++) {
                        sb.append(threadName).append("\n");
                    }
                    sb.append("===end===").append("\n");


                    br.write(sb.toString());
                    br.close();

                    Thread.sleep(random.nextInt(10));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
