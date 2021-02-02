package ar.com.uala.service;

import ar.com.uala.entitie.User;

public class PaymentCollector {
  private Double subscriptionAmount = 10.0;
  private Double ualaBalance;


  public Double getUalaBalance() {
    return ualaBalance;
  }

  public void setSubscriptionAmount(Double subscriptionAmount) {
    this.subscriptionAmount = subscriptionAmount;
  }

  public boolean makeCharge(User user) {
    Double currentUserBalance = user.getBalance();
    if (currentUserBalance < subscriptionAmount){
      System.out.println("!!!!EL USUARIO "+user.getUserId()+" NO TIENE SALDO SUFICIENTE PARA CONTINUAR CON LA SUBSCRIPCION");
      return false;
    }
    Double newUserBalance = currentUserBalance - subscriptionAmount;
    user.setBalance(newUserBalance);
    this.ualaBalance = ualaBalance + subscriptionAmount;
    return true;
  }
}
