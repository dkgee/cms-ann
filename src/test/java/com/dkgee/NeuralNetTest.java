package com.dkgee;

import com.dkgee.ch01.NeuralNet;

/**
 * Description: 神经网络对象测试
 * Author: jht
 * Date: 2018/6/25
 */
public class NeuralNetTest {

    public static void main(String[] args) {
        NeuralNet n = new NeuralNet();
        n.initNet();
        n.printNet();
    }
}
