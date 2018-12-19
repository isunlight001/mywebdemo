package com.sunlight001.test.exceptiont;
/**
 * 异常可以混合捕捉吗？
 * @author sunlight001
 * 2018年12月19日
 */
class AnnoyanceException extends Exception {}
class SneezeException extends AnnoyanceException {}

class Human {

    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new SneezeException();
            } 
            catch ( AnnoyanceException a ) {
                System.out.println("Caught AnnoyanceException");
                throw a;
            }
        } 
        catch ( SneezeException s ) {
            System.out.println("!!!!!!!!Caught SneezeException");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}

