package com.dkgee.ch01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * Author: jht
 * Date: 2018/6/25
 */
public class OutputLayer extends Layer{

    public OutputLayer initLayer(OutputLayer outputLayer) {
        ArrayList<Double> listOfWeightOutTemp = new ArrayList<>();
        ArrayList<Neuron> listOfNeurons = new ArrayList<>();

        for(int i = 0; i < outputLayer.getNumberOfNeuronsInLayer(); i++){
            Neuron neuron = new Neuron();

            listOfWeightOutTemp.add( neuron.initNeuron() );

            neuron.setListOfWeightOut(listOfWeightOutTemp);
            listOfNeurons.add(neuron);

            listOfWeightOutTemp = new ArrayList<>();
        }

        outputLayer.setListOfNeurons(listOfNeurons);

        return outputLayer;
    }

    public void printLayer(OutputLayer outputLayer){
        System.out.println("### OUTPUT LAYER ###");
        int n = 0;
        for(Neuron neuron: outputLayer.getListOfNeurons()){
            System.out.println("Neuron #" + n + ":");
            System.out.println("Output Weights:");
            System.out.println(Arrays.deepToString( neuron.getListOfWeightOut().toArray() ));
            n++;
        }
    }
}
