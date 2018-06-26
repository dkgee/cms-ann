package com.dkgee.ch02;

import com.dkgee.ch01.NeuralNet;
import com.dkgee.ch01.Neuron;

import java.util.ArrayList;

/**
 * Description:
 * Author: jht
 * Date: 2018/6/27
 */
public class Training {

    /**
     * 训练次数
     * */
    private int epochs;

    /**
     * 预期输出和实际输出的实数
     * */
    private double error;

    /**
     * 存储均方误差的实数
     * */
    private double mse;


    /**
     * 支持的训练类型
     * */
    public enum TrainingTypesENUM{
        PERCEPTRON,  //感知机
        ADALINE;    //适应器
    }

    /**
     *  支持的激活函数类型
     * */
    public enum ActivationFncENUM{
        STEP,       //阶跃
        LINEAR,     //线性
        SIGLOG,     //sigmoid logistics
        HYPERTAN;   //双曲正切
    }

    /**
     * 训练神经网络
     * */
    public NeuralNet train(NeuralNet n){
        return null;
    }

    /**
     * 使某层的神经元计算并改变其权值
     * */
    public ArrayList<Neuron> teachNeuronsOfLayer(int numberOfInputNeurons, int line, NeuralNet n, double netValue){
        return null;
    }

    /**
     * 计算某个神经元的新权值
     * */
    private double calcNewWeight(TrainingTypesENUM trainType, double inputWeightOld, NeuralNet n, double error,
                                 double trainSample, double netValue){
        return 0.0D;
    }


    /**
     * 决定要使用的激活函数，并调用其计算方法
     * */
    public double activationFnc(ActivationFncENUM fnc, double value){
        return 0.0D;
    }

    /**
     * 决定选择哪个激活函数并调用计算其导数的方法
     * */
    public double derivativeActivationFnc(ActivationFncENUM fnc, double value){
        return 0.0D;
    }

    /**
     * 计算阶跃函数
     * */
    private double fncStep(double v){
        return 0.0D;
    }

    /**
     * 计算线性函数
     * */
    private double fncLinear(double v){
        return 0.0D;
    }

    /**
     * 计算sigmoid logistics函数
     * */
    private double fncSingLog(double v){
        return 0.0D;
    }

    /**
     * 计算双曲正切函数
     * */
    private double fncHyperTan(double v){
        return 0.0D;
    }

    /**
     * 计算线性函数的导数
     * */
    private double derivativeFncLinear(double v){
        return 0.0D;
    }

    /**
     * 计算sigmoid logistics函数的导数
     * */
    private double derivativeFncSigLog(double v){
        return 0.0D;
    }


    /**
     * 计算双曲线正切函数的导数
     * */
    private double derivativeFncHyperTan(double v){
        return 0.0D;
    }

    /**
     * 输出训练过的神经网络并显示其效果
     * */
    public void printTrainedNetResult(NeuralNet trainedNet){

    }

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double getMse() {
        return mse;
    }

    public void setMse(double mse) {
        this.mse = mse;
    }
}
