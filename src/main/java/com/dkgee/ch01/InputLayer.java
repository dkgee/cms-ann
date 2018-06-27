package com.dkgee.ch01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * Author: jht
 * Date: 2018/6/25
 */
public class InputLayer extends Layer{

    public InputLayer initLayer(InputLayer inputLayer){

        ArrayList<Double> listOfWeightInTemp = new ArrayList<>();
        ArrayList<Neuron> listOfNeurons = new ArrayList<>();

        for(int i = 0; i < inputLayer.getNumberOfNeuronsInLayer(); i++){
            Neuron neuron = new Neuron();
            listOfWeightInTemp.add(neuron.initNeuron());
            neuron.setListOfWeightIn(listOfWeightInTemp);

            listOfNeurons.add(neuron);
            listOfWeightInTemp = new ArrayList<>();
        }

        inputLayer.setListOfNeurons(listOfNeurons);
        return inputLayer;
    }

    public void printLayer(InputLayer inputLayer){
        System.out.println("### INPUT LAYER ###");
        int n = 1;
        for(Neuron neuron: inputLayer.getListOfNeurons()){
            System.out.println("Neuron #" + n + ":");
            System.out.println("Input Weights:");
            System.out.println(Arrays.deepToString( neuron.getListOfWeightIn().toArray() ));
            n++;
        }

    }


    /*******ch02*******/
    public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer) {
        this.numberOfNeuronsInLayer = numberOfNeuronsInLayer + 1; //BIAS
    }
}
