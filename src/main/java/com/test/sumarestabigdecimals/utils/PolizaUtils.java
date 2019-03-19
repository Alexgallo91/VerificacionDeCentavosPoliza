package com.test.sumarestabigdecimals.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.sumarestabigdecimals.beans.PolizaBean;
import com.test.sumarestabigdecimals.beans.SeccionPolizaTotalBean;
import com.test.sumarestabigdecimals.enums.EnumComparacionBigDecimals;

public class PolizaUtils {

	private static final Logger LOGGER = LogManager.getLogger(PolizaUtils.class.getName());

	public PolizaBean generarPolizaRandom() {
		PolizaBean bean = new PolizaBean();
		BigDecimal montoDebe = new BigDecimal(generarDoubleRandom(1000, 5000));
		montoDebe = new Random().nextBoolean() ? montoDebe : montoDebe.negate();
		montoDebe = montoDebe.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		bean.setDebe(montoDebe);
		bean.setDscCentroCostos("Centro de costos ");

		return bean;
	}

	public double generarDoubleRandom(double min, double max) {
		return min + (max - min) * new Random().nextDouble();
	}

	public int generarIntRandom(int min, int max) {
		return new Random().nextInt((max - min) + 1) + min;
	}

	public SeccionPolizaTotalBean generarSeccionTotalPoliza() {
		int numeroDePolizasPorGenerar = generarIntRandom(2, 10);
		SeccionPolizaTotalBean stp = new SeccionPolizaTotalBean();
		stp.setListaDePolizasDebe(generarListaPolizas(numeroDePolizasPorGenerar));

		// genera la poliza con el total de haber
		stp.setPolizaTotalHaber(generarPolizaTotalHaber(stp.getListaDePolizasDebe()));

		// se verifica los centavos
		stp.setListaDePolizasDebe(verificarCantidadesNegativa(stp.getListaDePolizasDebe()));

		// genera los totales de haber y debe
		stp.setTotalHaber(obtenerTotalHaber(stp.getListaDePolizasDebe()));
		stp.setTotalDebe(stp.getPolizaTotalHaber().getHaber());

		return stp;
	}

	// verifica que los saldos no sean negativos, en caso de ser negativos, se
	// establecen en
	// 0 las cantidades
	public List<PolizaBean> verificarCantidadesNegativa(List<PolizaBean> listaPolizaBeans) {
		for (PolizaBean p : listaPolizaBeans) {
			if (verificarBigDecimals(p.getDebe(), BigDecimal.ZERO) == EnumComparacionBigDecimals.MENOR) {
				p.setDebe(new BigDecimal(0));
			}
		}
		return listaPolizaBeans;
	}

	public BigDecimal obtenerTotalHaber(List<PolizaBean> listaPolizas) {
		BigDecimal totalHaber = new BigDecimal(0);

		for (PolizaBean p : listaPolizas) {
			totalHaber = sumaBigDecimals(totalHaber, p.getDebe());
			LOGGER.info("Se suma el totalHaber de " + totalHaber.setScale(2, BigDecimal.ROUND_HALF_EVEN) + " + "
					+ p.getDebe().setScale(2, BigDecimal.ROUND_HALF_EVEN));
		}

		return totalHaber;
	}

	public List<PolizaBean> generarListaPolizas(int numeroPolizas) {
		List<PolizaBean> listaPolizas = new ArrayList<PolizaBean>();
		for (int i = 0; i < numeroPolizas; i++) {
			listaPolizas.add(generarPolizaRandom());
		}
		return listaPolizas;
	}

	public PolizaBean generarPolizaTotalHaber(List<PolizaBean> listaPolizasDebe) {
		PolizaBean polizaTotalHaber = new PolizaBean();
		polizaTotalHaber.setHaber(obtenerTotalHaber(listaPolizasDebe).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		return polizaTotalHaber;
	}

	public BigDecimal generarTotalDebe(SeccionPolizaTotalBean sptb) {
		BigDecimal totalDebe = new BigDecimal(0);

		for (PolizaBean p : sptb.getListaDePolizasDebe()) {
			totalDebe = sumaBigDecimals(totalDebe, p.getDebe());
		}

		return totalDebe;
	}

	public BigDecimal sumaBigDecimals(BigDecimal num1, BigDecimal num2) {
		return num1.setScale(2, BigDecimal.ROUND_HALF_EVEN).add(num2).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public BigDecimal restarBigDecimals(BigDecimal num1, BigDecimal num2) {
		return num1.setScale(2, BigDecimal.ROUND_HALF_EVEN).subtract(num2).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public EnumComparacionBigDecimals verificarBigDecimals(BigDecimal bd1, BigDecimal bd2) {

		BigDecimal numeroPorComparar1 = bd1.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal numeroPorComparar2 = bd2.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		int result = numeroPorComparar1.compareTo(numeroPorComparar2);

		if (0 == result) {
			return EnumComparacionBigDecimals.IGUAL;
		} else if (1 == result) {
			return EnumComparacionBigDecimals.MAYOR;
		} else {
			return EnumComparacionBigDecimals.MENOR;
		}

	}
}
