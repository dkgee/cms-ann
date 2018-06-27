package com.dkgee.ch02;

import com.dkgee.ch01.InputLayer;
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

        ArrayList<Double> inputWeightIn = new ArrayList<>();

        int rows = n.getTrainSet().length;
        int cols = n.getTrainSet()[0].length;

        while (this.getEpochs() < n.getMaxEpochs()){

            double estimatedOutput = 0.0;
            double realOutput = 0.0;

            for(int i = 0; i < rows; i++){

                double netValue = 0.0;

                for(int j = 0; j < cols; j++){
                    inputWeightIn = n.getInputLayer().getListOfNeurons().get(j).getListOfWeightIn();

                    double inputWeight = inputWeightIn.get(0);

                    netValue = netValue + inputWeight * n.getTrainSet()[i][j];
                }

                estimatedOutput = this.activationFnc(n.getActivationFnc(), netValue);
                realOutput = n.getRealOutputSet()[i];

                this.setError(realOutput - estimatedOutput);

                if(Math.abs(this.getError()) > n.getTargetError()){
                    //fix weights
                    InputLayer inputLayer = new InputLayer();
                    inputLayer.setListOfNeurons(this.teachNeuronsOfLayer(cols, i, n, netValue));
                    n.setInputLayer(inputLayer);
                }
            }

            this.setMse(Math.pow(realOutput - estimatedOutput, 2.0));
            n.getListOfMSE().add(this.getMse());

            this.setEpochs(this.getEpochs() + 1);
        }

        n.setTrainingError(this.getError());

        return n;
    }

    /**
     * 使某层的神经元计算并改变其权值
     * */
    public ArrayList<Neuron> teachNeuronsOfLayer(int numberOfInputNeurons, int line, NeuralNet n, double netValue){
        ArrayList<Neuron> listOfNeurons = new ArrayList<>();
        ArrayList<Double> inputWeightsInNew = new ArrayList<>();
        ArrayList<Double> inputWeightsInOld = new ArrayList<>();

        for(int j = 0; j < numberOfInputNeurons; j++){
            inputWeightsInOld = n.getInputLayer().getListOfNeurons().get(j).getListOfWeightIn();
            double inputWeightOld = inputWeightsInOld.get(0);

            inputWeightsInNew.add( this.calcNewWeight(n.getTrainType(), inputWeightOld, n,
                    this.getError(), n.getTrainSet()[line][j], netValue));

            Neuron neuron = new Neuron();
            neuron.setListOfWeightIn(inputWeightsInNew);
            listOfNeurons.add(neuron);
            inputWeightsInNew = new ArrayList<>();
        }

        return listOfNeurons;
    }

    /**
     * 计算某个神经元的新权值
     * */
    private double calcNewWeight(TrainingTypesENUM trainType, double inputWeightOld, NeuralNet n,
                                 double error, double trainSample, double netValue){
        switch (trainType){
            case PERCEPTRON:
                return inputWeightOld + n.getLearningRate() * error * trainSample;
            case ADALINE:
                return inputWeightOld + n.getLearningRate() * error * trainSample
                        * derivativeActivationFnc(n.getActivationFnc(), netValue);
            default:
                throw new IllegalArgumentException(trainType
                        + " does not exist in TrainingTypesENUM");
        }
    }


    /**
     * 决定要使用的激活函数，并调用其计算方法
     * */
    public double activationFnc(ActivationFncENUM fnc, double value){
        switch (fnc){
            case STEP:
                return fncSingLog(value);
            case LINEAR:
                return fncLinear(value);
            case SIGLOG:
                return fncSingLog(value);
            case HYPERTAN:
                return fncHyperTan(value);
            default:
                throw new IllegalArgumentException(fnc
                        + " does not exist in ActivationFncENUM");
        }
    }

    /**
     * 决定选择哪个激活函数并调用计算其导数的方法
     * */
    public double derivativeActivationFnc(ActivationFncENUM fnc, double value){
        switch (fnc){
            case LINEAR:
                return derivativeFncLinear(value);
            case SIGLOG:
                return derivativeFncSigLog(value);
            case HYPERTAN:
                return derivativeFncHyperTan(value);
            default:
                throw new IllegalArgumentException(fnc
                        + " does not exist in ActivationFncENUM");
        }
    }

    /**
     * 计算阶跃函数
     * */
    private double fncStep(double v){
        if(v >= 0){
            return 1.0;
        }else {
            return 0.0;
        }
    }

    /**
     * 计算线性函数
     * */
    private double fncLinear(double v){
        return v;
    }

    /**
     * 计算sigmoid logistics函数
     * */
    private double fncSingLog(double v){
        return 1.0 / (1.0 + Math.exp(-v));
    }

    /**
     * 计算双曲正切函数
     * */
    private double fncHyperTan(double v){
        return Math.tanh(v);
    }

    /**
     * 计算线性函数的导数
     * */
    private double derivativeFncLinear(double v){
        return 1.0;
    }

    /**
     * 计算sigmoid logistics函数的导数
     * */
    private double derivativeFncSigLog(double v){
        return v * (1.0 - v);
    }


    /**
     * 计算双曲线正切函数的导数
     * */
    private double derivativeFncHyperTan(double v){
        return (1.0 / Math.pow(Math.cos(v), 2.0));
    }

    /**
     * 输出训练过的神经网络并显示其效果
     * */
    public void printTrainedNetResult(NeuralNet trainedNet){
        int rows = trainedNet.getTrainSet().length;
        int cols = trainedNet.getTrainSet()[0].length;

        ArrayList<Double> inputWeightIn = new ArrayList<Double>();

        for (int i = 0; i < rows; i++) {
            double netValue = 0.0;
            for (int j = 0; j < cols; j++) {
                inputWeightIn = trainedNet.getInputLayer().getListOfNeurons()
                        .get(j).getListOfWeightIn();
                double inputWeight = inputWeightIn.get(0);
                netValue = netValue + inputWeight
                        * trainedNet.getTrainSet()[i][j];

                System.out.print(trainedNet.getTrainSet()[i][j] + "\t");
            }

            double estimatedOutput = this.activationFnc(
                    trainedNet.getActivationFnc(), netValue);

            System.out.print(" NET OUTPUT: " + estimatedOutput + "\t");
            System.out.print(" REAL OUTPUT: "
                    + trainedNet.getRealOutputSet()[i] + "\t");
            double error = estimatedOutput - trainedNet.getRealOutputSet()[i];
            System.out.print(" ERROR: " + error + "\n");

        }
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
