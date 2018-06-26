package com.dkgee.ch02;

import java.util.ArrayList;

/**
 * Description:
 * Author: jht
 * Date: 2018/6/27
 */
public class NeuralNet {

    private double[][] trainSet;

    private double[] realOutputSet;

    private int maxEpochs;

    private double learningRate;

    private double targetError;

    private double traingingError;

    private Training.TrainingTypesENUM traingType;

    private Training.ActivationFncENUM activationFnc;

    private ArrayList<Double> listOfMSE = new ArrayList<>();


    public NeuralNet trainNet(NeuralNet n){
        return null;
    }

    public void printTrainedNetResult(NeuralNet n){

    }

    public double[][] getTrainSet() {
        return trainSet;
    }

    public void setTrainSet(double[][] trainSet) {
        this.trainSet = trainSet;
    }

    public double[] getRealOutputSet() {
        return realOutputSet;
    }

    public void setRealOutputSet(double[] realOutputSet) {
        this.realOutputSet = realOutputSet;
    }

    public int getMaxEpochs() {
        return maxEpochs;
    }

    public void setMaxEpochs(int maxEpochs) {
        this.maxEpochs = maxEpochs;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getTargetError() {
        return targetError;
    }

    public void setTargetError(double targetError) {
        this.targetError = targetError;
    }

    public double getTraingingError() {
        return traingingError;
    }

    public void setTraingingError(double traingingError) {
        this.traingingError = traingingError;
    }

    public Training.TrainingTypesENUM getTraingType() {
        return traingType;
    }

    public void setTraingType(Training.TrainingTypesENUM traingType) {
        this.traingType = traingType;
    }

    public Training.ActivationFncENUM getActivationFnc() {
        return activationFnc;
    }

    public void setActivationFnc(Training.ActivationFncENUM activationFnc) {
        this.activationFnc = activationFnc;
    }

    public ArrayList<Double> getListOfMSE() {
        return listOfMSE;
    }

    public void setListOfMSE(ArrayList<Double> listOfMSE) {
        this.listOfMSE = listOfMSE;
    }
}
