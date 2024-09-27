package com.example.jewie.backend.bunches.exceptions;

public class IllegalQuantityOnBunchException extends RuntimeException {
  public IllegalQuantityOnBunchException() {
    super("The operation you tried to do would result in a bunch with qty below zero");
  }
}
