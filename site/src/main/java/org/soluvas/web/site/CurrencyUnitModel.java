package org.soluvas.web.site;

import java.io.Serializable;

import javax.annotation.Nullable;
import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.apache.wicket.model.IModel;

/**
 * Workaround for {@link CurrencyUnit}'s lack of {@link Serializable}-ity.
 * @author ceefour
 */
public class CurrencyUnitModel implements IModel<CurrencyUnit> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Backing object.
	 */
	@Nullable
	private CurrencyUnit object;

	/**
	 * 
	 */
	public CurrencyUnitModel() {
	}
	
	public CurrencyUnitModel(CurrencyUnit object) {
		super();
		this.object = object;
	}

	public CurrencyUnitModel(String currencyCode) {
		super();
		this.object = currencyCode != null ? Monetary.getCurrency(currencyCode) : null;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.wicket.model.IDetachable#detach()
	 */
	@Override
	public void detach() {
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.model.IModel#getObject()
	 */
	@Override
	@Nullable
	public CurrencyUnit getObject() {
		return object;
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.model.IModel#setObject(java.lang.Object)
	 */
	@Override
	public void setObject(@Nullable CurrencyUnit object) {
		this.object = object;
	}

}
