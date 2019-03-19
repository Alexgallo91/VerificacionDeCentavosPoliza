package com.test.sumarestabigdecimals.beans;

import java.math.BigDecimal;
import java.util.Date;

public class PolizaBean {
  private String numeroPreFactura;
  private String claveSesion;
  private Date fechaEntCont;
  private String tipPro;
  private Date fechaEmision;
  private String altair1;
  private String altair2;
  private String altair3;
  private String altair4;
  private String altair5;
  private String aux;
  private String numDocto;
  private String fechaAltair;
  private String concepto;
  private BigDecimal debe;
  private BigDecimal haber;
  private String dscCentroCostos;
  private boolean totalHaber;

  public PolizaBean() {

  }

  public String getDscCentroCostos() {
    return dscCentroCostos;
  }

  public void setDscCentroCostos(String dscCentroCostos) {
    this.dscCentroCostos = dscCentroCostos;
  }

  public String getNumeroPreFactura() {
    return numeroPreFactura;
  }

  public void setNumeroPreFactura(String numeroPreFactura) {
    this.numeroPreFactura = numeroPreFactura;
  }

  public String getClaveSesion() {
    return claveSesion;
  }

  public void setClaveSesion(String claveSesion) {
    this.claveSesion = claveSesion;
  }

  public Date getFechaEntCont() {
    return fechaEntCont;
  }

  public void setFechaEntCont(Date fechaEntCont) {
    this.fechaEntCont = fechaEntCont;
  }

  public String getTipPro() {
    return tipPro;
  }

  public void setTipPro(String tipPro) {
    this.tipPro = tipPro;
  }

  public Date getFechaEmision() {
    return fechaEmision;
  }

  public void setFechaEmision(Date fechaEmision) {
    this.fechaEmision = fechaEmision;
  }

  public String getAltair1() {
    return altair1;
  }

  public void setAltair1(String altair1) {
    this.altair1 = altair1;
  }

  public String getAltair2() {
    return altair2;
  }

  public void setAltair2(String altair2) {
    this.altair2 = altair2;
  }

  public String getAltair3() {
    return altair3;
  }

  public void setAltair3(String altair3) {
    this.altair3 = altair3;
  }

  public String getAltair4() {
    return altair4;
  }

  public void setAltair4(String altair4) {
    this.altair4 = altair4;
  }

  public String getAltair5() {
    return altair5;
  }

  public void setAltair5(String altair5) {
    this.altair5 = altair5;
  }

  public String getAux() {
    return aux;
  }

  public void setAux(String aux) {
    this.aux = aux;
  }

  public String getNumDocto() {
    return numDocto;
  }

  public void setNumDocto(String numDocto) {
    this.numDocto = numDocto;
  }

  public String getFechaAltair() {
    return fechaAltair;
  }

  public void setFechaAltair(String fechaAltair) {
    this.fechaAltair = fechaAltair;
  }

  public String getConcepto() {
    return concepto;
  }

  public void setConcepto(String concepto) {
    this.concepto = concepto;
  }

  public BigDecimal getDebe() {
    return debe;
  }

  public void setDebe(BigDecimal debe) {
    this.debe = debe;
  }

  public BigDecimal getHaber() {
    return haber;
  }

  public void setHaber(BigDecimal haber) {
    this.haber = haber;
  }

  public boolean isTotalHaber() {
    return totalHaber;
  }

  public void setTotalHaber(boolean totalHaber) {
    this.totalHaber = totalHaber;
  }

}
