package com.dkgee.ch01;

import java.util.ArrayList;
import java.util.Random;

/**
 * Description:定义神经元对象
 * Author: jht
 * Date: 2018/6/25
 */
public class Neuron {

    /**
     * 输入权值集合
     * */
    private ArrayList<Double> listOfWeightIn;

    /**
     * 输出权值集合
     * */
    private ArrayList<Double> listOfWeightOut;

    /**
     * 伪随机数初始化
     * */

    public double initNeuron(){
        Random random = new Random();
        return random.nextDouble();
    }

    public ArrayList<Double> getListOfWeightIn() {
        return listOfWeightIn;
    }

    public void setListOfWeightIn(ArrayList<Double> listOfWeightIn) {
        this.listOfWeightIn = listOfWeightIn;
    }

    public ArrayList<Double> getListOfWeightOut() {
        return listOfWeightOut;
    }

    public void setListOfWeightOut(ArrayList<Double> listOfWeightOut) {
        this.listOfWeightOut = listOfWeightOut;
    }
}
