package org.soluvas.web.bootstrap.widget;

import org.joda.time.LocalDate;

/**
 * Choosable date ranges.
 * @author ceefour
 */
public enum RangeChoice {
	/**
	 * Today, from 12:00 AM to 11:59 PM.
	 * Only usable with {@link com.quikdo.core.AnalyticsPrecision#HOURLY} precision.
	 */
	TODAY,
	/**
	 * Yesterday, from 12:00 AM to 11:59 PM.
	 * Only usable with {@link com.quikdo.core.AnalyticsPrecision#HOURLY} precision.
	 */
	YESTERDAY,
	/**
	 * This week (some data may not be available), from Sunday to Saturday.
	 * Usable with both {@link com.quikdo.core.AnalyticsPrecision#HOURLY} and {@link com.quikdo.core.AnalyticsPrecision#DAILY} precisions.
	 */
	THIS_WEEK,
	/**
	 * Last week, from Sunday to Saturday.
	 * Usable with both {@link com.quikdo.core.AnalyticsPrecision#HOURLY} and {@link com.quikdo.core.AnalyticsPrecision#DAILY} precisions.
	 */
	LAST_WEEK,
	/**
	 * This month (some data may not be available), from 1st to last day.
	 * Usable with any of {@link com.quikdo.core.AnalyticsPrecision#HOURLY}, {@link com.quikdo.core.AnalyticsPrecision#DAILY}, and
	 * {@link com.quikdo.core.AnalyticsPrecision#WEEKLY} precisions.
	 */
	THIS_MONTH,
	/**
	 * Last month, from 1st to last day.
	 * Usable with any of {@link com.quikdo.core.AnalyticsPrecision#HOURLY}, {@link com.quikdo.core.AnalyticsPrecision#DAILY}, and
	 * {@link com.quikdo.core.AnalyticsPrecision#WEEKLY} precisions.
	 */
	LAST_MONTH,
	/**
	 * This year (some data may not be available), from 1st to last day.
	 * Usable with any of {@link com.quikdo.core.AnalyticsPrecision#HOURLY}, {@link com.quikdo.core.AnalyticsPrecision#DAILY}, and
	 * {@link com.quikdo.core.AnalyticsPrecision#WEEKLY} precisions.
	 */
	THIS_YEAR,
	/**
	 * Last year, from 1st to last day.
	 * Usable with any of {@link com.quikdo.core.AnalyticsPrecision#HOURLY}, {@link com.quikdo.core.AnalyticsPrecision#DAILY}, and
	 * {@link com.quikdo.core.AnalyticsPrecision#WEEKLY} precisions.
	 */
	LAST_YEAR,
	/**
	 * Custom {@link LocalDate} range. 
	 */
	CUSTOM
}
