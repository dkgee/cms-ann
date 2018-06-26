package com.dkgee.ch01;

import java.util.ArrayList;

/**
 * Description: 神经网络对象
 * Author: jht
 * Date: 2018/6/25
 */
public class NeuralNet {

    private InputLayer inputLayer;

    private HiddenLayer hiddenLayer;

    private ArrayList<HiddenLayer> listOfHiddenLayer;

    private OutputLayer outputLayer;

    private int numberOfHiddenLayers;

    public void initNet(){
        inputLayer = new InputLayer();
        inputLayer.setNumberOfNeuronsInLayer( 2 );

        numberOfHiddenLayers = 1;
        listOfHiddenLayer = new ArrayList<>();
        for (int i = 0; i < numberOfHiddenLayers; i++) {
            hiddenLayer = new HiddenLayer();
            hiddenLayer.setNumberOfNeuronsInLayer( 3 );
            listOfHiddenLayer.add( hiddenLayer );
        }

        outputLayer = new OutputLayer();
        outputLayer.setNumberOfNeuronsInLayer( 1 );

        inputLayer = inputLayer.initLayer(inputLayer);

        listOfHiddenLayer = hiddenLayer.initLayer(hiddenLayer, listOfHiddenLayer, inputLayer, outputLayer);

        outputLayer = outputLayer.initLayer(outputLayer);

    }

    public void printNet(){
        inputLayer.printLayer(inputLayer);
        System.out.println();
        hiddenLayer.printLayer(listOfHiddenLayer);
        System.out.println();
        outputLayer.printLayer(outputLayer);
    }

}
