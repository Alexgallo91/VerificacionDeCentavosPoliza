package com.test.sumarestabigdecimals.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SeccionPolizaTotalBean implements Serializable {

  private static final long serialVersionUID = 2941132170815471366L;
  private List<PolizaBean> listaDePolizasDebe;
  private PolizaBean polizaTotalHaber;
  private BigDecimal totalDebe;
  private BigDecimal totalHaber;

  public List<PolizaBean> getListaDePolizasDebe(){
    return listaDePolizasDebe;
  }

  public void setListaDePolizasDebe(List<PolizaBean> listaDePolizasDebe) {
    this.listaDePolizasDebe = listaDePolizasDebe;
  }

  public PolizaBean getPolizaTotalHaber() {
    return polizaTotalHaber;
  }

  public void setPolizaTotalHaber(PolizaBean polizaTotalHaber) {
    this.polizaTotalHaber = polizaTotalHaber;
  }

  public BigDecimal getTotalDebe() {
    return totalDebe;
  }

  public void setTotalDebe(BigDecimal totalDebe) {
    this.totalDebe = totalDebe;
  }

  public BigDecimal getTotalHaber() {
    return totalHaber;
  }

  public void setTotalHaber(BigDecimal totalHaber) {
    this.totalHaber = totalHaber;
  }

}
