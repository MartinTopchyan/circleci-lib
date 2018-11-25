package edu.cognaize.circleci.service;

import edu.cognaize.circleci.model.CircleCiModel;

public class CircleCiService {
  public void sayHello(CircleCiModel circleCiModel){
    System.out.println("HEllo " + circleCiModel.getName());
  }
}
