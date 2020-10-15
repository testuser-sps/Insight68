package com.insight68.utils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;


//Code to update the fields here the data from the UI forms get Update with the Object created from the table
public class UtilClass {

	public static boolean isNullOrEmpty(Object obj) {
		if (Objects.isNull(obj) || ((String) obj).isEmpty())
			return true;
		return false;
	}

	public static void copyNonNullProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
}
